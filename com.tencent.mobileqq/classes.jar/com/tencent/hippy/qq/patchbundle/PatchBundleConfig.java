package com.tencent.hippy.qq.patchbundle;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.api.IHippyUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class PatchBundleConfig
  implements Serializable
{
  private static final String TAG = "PatchBundleConfig";
  private static PatchBundleConfig sConfig;
  private static final long serialVersionUID = 1L;
  private final HashMap<String, PatchBundleConfig.SubBundleConfig> mSubBundleConfigs = new HashMap();
  private boolean mSwitchFlag;
  private int mVersion;
  
  private PatchBundleConfig()
  {
    init();
  }
  
  private static AppRuntime getAppRuntime()
  {
    AppInterface localAppInterface = ((IHippyUtils)QRoute.api(IHippyUtils.class)).getAppInterface();
    Object localObject = localAppInterface;
    if (localAppInterface == null) {
      localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    }
    return localObject;
  }
  
  public static PatchBundleConfig getConfig()
  {
    try
    {
      if (sConfig == null) {
        sConfig = new PatchBundleConfig();
      }
      PatchBundleConfig localPatchBundleConfig = sConfig;
      return localPatchBundleConfig;
    }
    finally {}
  }
  
  private void init()
  {
    File localFile = new File(PatchUtils.getConfigFilePath());
    if ((localFile.exists()) && (localFile.length() > 0L))
    {
      parseConfig(localFile);
      return;
    }
    QLog.e("PatchBundleConfig", 1, "init getConfigFilePath not exist");
  }
  
  public HashMap<String, PatchBundleConfig.SubBundleConfig> getSubBundleConfig()
  {
    return this.mSubBundleConfigs;
  }
  
  public boolean isSwitchOpen()
  {
    return this.mSwitchFlag;
  }
  
  public void loadSSOListCache()
  {
    PatchBundleConfig.1 local1 = new PatchBundleConfig.1(this);
    Iterator localIterator1 = this.mSubBundleConfigs.values().iterator();
    if (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((PatchBundleConfig.SubBundleConfig)localIterator1.next()).mSubConfigs.values().iterator();
      while (localIterator2.hasNext())
      {
        Iterator localIterator3 = ((PatchBundleConfig.BundleConfigItem)localIterator2.next()).mSSOList.iterator();
        while (localIterator3.hasNext())
        {
          PatchBundleConfig.SSOListConfig localSSOListConfig = (PatchBundleConfig.SSOListConfig)localIterator3.next();
          localSSOListConfig.loadCache();
          if (TextUtils.isEmpty(localSSOListConfig.mRsp)) {
            localSSOListConfig.handleSSOConfigData(local1);
          }
        }
      }
    }
  }
  
  /* Error */
  public void parseConfig(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 169	org/json/JSONObject
    //   5: dup
    //   6: aload_1
    //   7: invokestatic 175	com/tencent/mobileqq/utils/FileUtils:readFileToString	(Ljava/io/File;)Ljava/lang/String;
    //   10: invokespecial 176	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13: astore_1
    //   14: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17: ifeq +38 -> 55
    //   20: new 181	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   27: astore 6
    //   29: aload 6
    //   31: ldc 184
    //   33: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload 6
    //   39: aload_1
    //   40: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: ldc 10
    //   46: iconst_2
    //   47: aload 6
    //   49: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 197	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: aload_1
    //   56: ldc 199
    //   58: invokevirtual 203	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   61: iconst_1
    //   62: if_icmpne +568 -> 630
    //   65: iconst_1
    //   66: istore 5
    //   68: goto +3 -> 71
    //   71: aload_0
    //   72: iload 5
    //   74: putfield 106	com/tencent/hippy/qq/patchbundle/PatchBundleConfig:mSwitchFlag	Z
    //   77: aload_1
    //   78: ldc 205
    //   80: invokevirtual 203	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   83: istore_2
    //   84: iload_2
    //   85: aload_0
    //   86: getfield 207	com/tencent/hippy/qq/patchbundle/PatchBundleConfig:mVersion	I
    //   89: if_icmpne +14 -> 103
    //   92: ldc 10
    //   94: iconst_1
    //   95: ldc 209
    //   97: invokestatic 212	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   100: aload_0
    //   101: monitorexit
    //   102: return
    //   103: aload_0
    //   104: iload_2
    //   105: putfield 207	com/tencent/hippy/qq/patchbundle/PatchBundleConfig:mVersion	I
    //   108: aload_1
    //   109: ldc 214
    //   111: invokevirtual 218	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   114: astore_1
    //   115: iconst_0
    //   116: istore_2
    //   117: iload_2
    //   118: aload_1
    //   119: invokevirtual 223	org/json/JSONArray:length	()I
    //   122: if_icmpge +420 -> 542
    //   125: aload_1
    //   126: iload_2
    //   127: invokevirtual 227	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   130: astore 7
    //   132: new 133	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$SubBundleConfig
    //   135: dup
    //   136: invokespecial 228	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$SubBundleConfig:<init>	()V
    //   139: astore 6
    //   141: aload 6
    //   143: aload 7
    //   145: ldc 230
    //   147: invokevirtual 234	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   150: putfield 237	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$SubBundleConfig:mBusinessName	Ljava/lang/String;
    //   153: aload 7
    //   155: ldc 239
    //   157: invokevirtual 218	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   160: astore 8
    //   162: aload 8
    //   164: ifnull +38 -> 202
    //   167: iconst_0
    //   168: istore_3
    //   169: iload_3
    //   170: aload 8
    //   172: invokevirtual 223	org/json/JSONArray:length	()I
    //   175: if_icmpge +27 -> 202
    //   178: aload 6
    //   180: getfield 242	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$SubBundleConfig:mSupportVersions	Ljava/util/List;
    //   183: aload 8
    //   185: iload_3
    //   186: invokevirtual 245	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   189: invokeinterface 249 2 0
    //   194: pop
    //   195: iload_3
    //   196: iconst_1
    //   197: iadd
    //   198: istore_3
    //   199: goto -30 -> 169
    //   202: aload 7
    //   204: ldc 251
    //   206: invokevirtual 218	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   209: astore 7
    //   211: aload 7
    //   213: ifnull +307 -> 520
    //   216: iconst_0
    //   217: istore_3
    //   218: iload_3
    //   219: aload 7
    //   221: invokevirtual 223	org/json/JSONArray:length	()I
    //   224: if_icmpge +296 -> 520
    //   227: aload 7
    //   229: iload_3
    //   230: invokevirtual 227	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   233: astore 9
    //   235: new 138	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$BundleConfigItem
    //   238: dup
    //   239: invokespecial 252	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$BundleConfigItem:<init>	()V
    //   242: astore 8
    //   244: aload 8
    //   246: aload 9
    //   248: ldc 254
    //   250: invokevirtual 234	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   253: putfield 257	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$BundleConfigItem:mName	Ljava/lang/String;
    //   256: aload 9
    //   258: ldc_w 259
    //   261: invokevirtual 218	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   264: astore 10
    //   266: iconst_0
    //   267: istore 4
    //   269: iload 4
    //   271: aload 10
    //   273: invokevirtual 223	org/json/JSONArray:length	()I
    //   276: if_icmpge +30 -> 306
    //   279: aload 8
    //   281: getfield 262	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$BundleConfigItem:mPreLoadList	Ljava/util/List;
    //   284: aload 10
    //   286: iload 4
    //   288: invokevirtual 245	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   291: invokeinterface 249 2 0
    //   296: pop
    //   297: iload 4
    //   299: iconst_1
    //   300: iadd
    //   301: istore 4
    //   303: goto -34 -> 269
    //   306: aload 9
    //   308: ldc_w 264
    //   311: invokevirtual 218	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   314: astore 10
    //   316: iconst_0
    //   317: istore 4
    //   319: iload 4
    //   321: aload 10
    //   323: invokevirtual 223	org/json/JSONArray:length	()I
    //   326: if_icmpge +30 -> 356
    //   329: aload 8
    //   331: getfield 267	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$BundleConfigItem:mPrefetchList	Ljava/util/List;
    //   334: aload 10
    //   336: iload 4
    //   338: invokevirtual 245	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   341: invokeinterface 249 2 0
    //   346: pop
    //   347: iload 4
    //   349: iconst_1
    //   350: iadd
    //   351: istore 4
    //   353: goto -34 -> 319
    //   356: aload 9
    //   358: ldc_w 269
    //   361: invokevirtual 218	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   364: astore 9
    //   366: iconst_0
    //   367: istore 4
    //   369: iload 4
    //   371: aload 9
    //   373: invokevirtual 223	org/json/JSONArray:length	()I
    //   376: if_icmpge +121 -> 497
    //   379: aload 9
    //   381: iload 4
    //   383: invokevirtual 227	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   386: astore 10
    //   388: new 147	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$SSOListConfig
    //   391: dup
    //   392: invokespecial 270	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$SSOListConfig:<init>	()V
    //   395: astore 11
    //   397: aload 11
    //   399: aload 10
    //   401: ldc_w 272
    //   404: invokevirtual 234	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   407: putfield 275	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$SSOListConfig:mType	Ljava/lang/String;
    //   410: aload 11
    //   412: aload 10
    //   414: ldc_w 277
    //   417: invokevirtual 234	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   420: putfield 280	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$SSOListConfig:mKey	Ljava/lang/String;
    //   423: aload 11
    //   425: aload 10
    //   427: ldc_w 282
    //   430: invokevirtual 234	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   433: putfield 285	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$SSOListConfig:mCmd	Ljava/lang/String;
    //   436: aload 11
    //   438: aload 10
    //   440: ldc_w 287
    //   443: invokevirtual 234	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   446: putfield 290	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$SSOListConfig:mMethod	Ljava/lang/String;
    //   449: aload 11
    //   451: aload 10
    //   453: ldc_w 292
    //   456: invokevirtual 296	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   459: putfield 299	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$SSOListConfig:mNeedCookie	Z
    //   462: aload 11
    //   464: aload 10
    //   466: ldc_w 301
    //   469: invokevirtual 234	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   472: putfield 304	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$SSOListConfig:mParam	Ljava/lang/String;
    //   475: aload 8
    //   477: getfield 142	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$BundleConfigItem:mSSOList	Ljava/util/List;
    //   480: aload 11
    //   482: invokeinterface 249 2 0
    //   487: pop
    //   488: iload 4
    //   490: iconst_1
    //   491: iadd
    //   492: istore 4
    //   494: goto -125 -> 369
    //   497: aload 6
    //   499: getfield 136	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$SubBundleConfig:mSubConfigs	Ljava/util/HashMap;
    //   502: aload 8
    //   504: getfield 257	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$BundleConfigItem:mName	Ljava/lang/String;
    //   507: aload 8
    //   509: invokevirtual 308	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   512: pop
    //   513: iload_3
    //   514: iconst_1
    //   515: iadd
    //   516: istore_3
    //   517: goto -299 -> 218
    //   520: aload_0
    //   521: getfield 32	com/tencent/hippy/qq/patchbundle/PatchBundleConfig:mSubBundleConfigs	Ljava/util/HashMap;
    //   524: aload 6
    //   526: getfield 237	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$SubBundleConfig:mBusinessName	Ljava/lang/String;
    //   529: aload 6
    //   531: invokevirtual 308	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   534: pop
    //   535: iload_2
    //   536: iconst_1
    //   537: iadd
    //   538: istore_2
    //   539: goto -422 -> 117
    //   542: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   545: ifeq +72 -> 617
    //   548: new 181	java/lang/StringBuilder
    //   551: dup
    //   552: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   555: astore_1
    //   556: aload_1
    //   557: ldc_w 310
    //   560: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: pop
    //   564: aload_1
    //   565: aload_0
    //   566: getfield 32	com/tencent/hippy/qq/patchbundle/PatchBundleConfig:mSubBundleConfigs	Ljava/util/HashMap;
    //   569: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   572: pop
    //   573: ldc 10
    //   575: iconst_2
    //   576: aload_1
    //   577: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   580: invokestatic 197	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   583: goto +34 -> 617
    //   586: astore_1
    //   587: goto +33 -> 620
    //   590: astore_1
    //   591: ldc 10
    //   593: iconst_1
    //   594: aload_1
    //   595: iconst_0
    //   596: anewarray 4	java/lang/Object
    //   599: invokestatic 313	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   602: goto +15 -> 617
    //   605: astore_1
    //   606: ldc 10
    //   608: iconst_1
    //   609: aload_1
    //   610: iconst_0
    //   611: anewarray 4	java/lang/Object
    //   614: invokestatic 313	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   617: aload_0
    //   618: monitorexit
    //   619: return
    //   620: aload_0
    //   621: monitorexit
    //   622: goto +5 -> 627
    //   625: aload_1
    //   626: athrow
    //   627: goto -2 -> 625
    //   630: iconst_0
    //   631: istore 5
    //   633: goto -562 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	636	0	this	PatchBundleConfig
    //   0	636	1	paramFile	File
    //   83	456	2	i	int
    //   168	349	3	j	int
    //   267	226	4	k	int
    //   66	566	5	bool	boolean
    //   27	503	6	localObject1	Object
    //   130	98	7	localObject2	Object
    //   160	348	8	localObject3	Object
    //   233	147	9	localObject4	Object
    //   264	201	10	localObject5	Object
    //   395	86	11	localSSOListConfig	PatchBundleConfig.SSOListConfig
    // Exception table:
    //   from	to	target	type
    //   2	55	586	finally
    //   55	65	586	finally
    //   71	100	586	finally
    //   103	115	586	finally
    //   117	162	586	finally
    //   169	195	586	finally
    //   202	211	586	finally
    //   218	266	586	finally
    //   269	297	586	finally
    //   306	316	586	finally
    //   319	347	586	finally
    //   356	366	586	finally
    //   369	488	586	finally
    //   497	513	586	finally
    //   520	535	586	finally
    //   542	583	586	finally
    //   591	602	586	finally
    //   606	617	586	finally
    //   2	55	590	java/lang/Exception
    //   55	65	590	java/lang/Exception
    //   71	100	590	java/lang/Exception
    //   103	115	590	java/lang/Exception
    //   117	162	590	java/lang/Exception
    //   169	195	590	java/lang/Exception
    //   202	211	590	java/lang/Exception
    //   218	266	590	java/lang/Exception
    //   269	297	590	java/lang/Exception
    //   306	316	590	java/lang/Exception
    //   319	347	590	java/lang/Exception
    //   356	366	590	java/lang/Exception
    //   369	488	590	java/lang/Exception
    //   497	513	590	java/lang/Exception
    //   520	535	590	java/lang/Exception
    //   542	583	590	java/lang/Exception
    //   2	55	605	java/io/IOException
    //   55	65	605	java/io/IOException
    //   71	100	605	java/io/IOException
    //   103	115	605	java/io/IOException
    //   117	162	605	java/io/IOException
    //   169	195	605	java/io/IOException
    //   202	211	605	java/io/IOException
    //   218	266	605	java/io/IOException
    //   269	297	605	java/io/IOException
    //   306	316	605	java/io/IOException
    //   319	347	605	java/io/IOException
    //   356	366	605	java/io/IOException
    //   369	488	605	java/io/IOException
    //   497	513	605	java/io/IOException
    //   520	535	605	java/io/IOException
    //   542	583	605	java/io/IOException
  }
  
  public void preloadBundleList()
  {
    Iterator localIterator1 = this.mSubBundleConfigs.values().iterator();
    if (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((PatchBundleConfig.SubBundleConfig)localIterator1.next()).mSubConfigs.values().iterator();
      while (localIterator2.hasNext())
      {
        Object localObject = (PatchBundleConfig.BundleConfigItem)localIterator2.next();
        if ((!TextUtils.isEmpty(((PatchBundleConfig.BundleConfigItem)localObject).mName)) && (((PatchBundleConfig.BundleConfigItem)localObject).mName.startsWith("http"))) {
          PatchUtils.downloadPatchBundle(((PatchBundleConfig.BundleConfigItem)localObject).mName);
        }
        Iterator localIterator3 = ((PatchBundleConfig.BundleConfigItem)localObject).mPreLoadList.iterator();
        while (localIterator3.hasNext()) {
          PatchUtils.downloadPatchBundle((String)localIterator3.next());
        }
        localObject = ((PatchBundleConfig.BundleConfigItem)localObject).mPrefetchList.iterator();
        while (((Iterator)localObject).hasNext()) {
          PatchUtils.downloadPatchBundle((String)((Iterator)localObject).next());
        }
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PatchBundleConfig{mSubBundleConfigs=");
    localStringBuilder.append(this.mSubBundleConfigs);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.patchbundle.PatchBundleConfig
 * JD-Core Version:    0.7.0.1
 */