package com.tencent.hippy.qq.patchbundle;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.utils.HippyUtils;
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
    AppInterface localAppInterface = HippyUtils.getAppInterface();
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
    //   2: new 163	org/json/JSONObject
    //   5: dup
    //   6: aload_1
    //   7: invokestatic 169	com/tencent/mobileqq/utils/FileUtils:readFileToString	(Ljava/io/File;)Ljava/lang/String;
    //   10: invokespecial 170	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13: astore_1
    //   14: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17: ifeq +38 -> 55
    //   20: new 175	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   27: astore 6
    //   29: aload 6
    //   31: ldc 178
    //   33: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload 6
    //   39: aload_1
    //   40: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: ldc 10
    //   46: iconst_2
    //   47: aload 6
    //   49: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 191	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: aload_1
    //   56: ldc 193
    //   58: invokevirtual 197	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   61: iconst_1
    //   62: if_icmpne +567 -> 629
    //   65: iconst_1
    //   66: istore 5
    //   68: goto +3 -> 71
    //   71: aload_0
    //   72: iload 5
    //   74: putfield 100	com/tencent/hippy/qq/patchbundle/PatchBundleConfig:mSwitchFlag	Z
    //   77: aload_1
    //   78: ldc 199
    //   80: invokevirtual 197	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   83: istore_2
    //   84: iload_2
    //   85: aload_0
    //   86: getfield 201	com/tencent/hippy/qq/patchbundle/PatchBundleConfig:mVersion	I
    //   89: if_icmpne +14 -> 103
    //   92: ldc 10
    //   94: iconst_1
    //   95: ldc 203
    //   97: invokestatic 206	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   100: aload_0
    //   101: monitorexit
    //   102: return
    //   103: aload_0
    //   104: iload_2
    //   105: putfield 201	com/tencent/hippy/qq/patchbundle/PatchBundleConfig:mVersion	I
    //   108: aload_1
    //   109: ldc 208
    //   111: invokevirtual 212	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   114: astore_1
    //   115: iconst_0
    //   116: istore_2
    //   117: iload_2
    //   118: aload_1
    //   119: invokevirtual 217	org/json/JSONArray:length	()I
    //   122: if_icmpge +419 -> 541
    //   125: aload_1
    //   126: iload_2
    //   127: invokevirtual 221	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   130: astore 7
    //   132: new 127	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$SubBundleConfig
    //   135: dup
    //   136: invokespecial 222	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$SubBundleConfig:<init>	()V
    //   139: astore 6
    //   141: aload 6
    //   143: aload 7
    //   145: ldc 224
    //   147: invokevirtual 228	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   150: putfield 231	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$SubBundleConfig:mBusinessName	Ljava/lang/String;
    //   153: aload 7
    //   155: ldc 233
    //   157: invokevirtual 212	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   160: astore 8
    //   162: aload 8
    //   164: ifnull +38 -> 202
    //   167: iconst_0
    //   168: istore_3
    //   169: iload_3
    //   170: aload 8
    //   172: invokevirtual 217	org/json/JSONArray:length	()I
    //   175: if_icmpge +27 -> 202
    //   178: aload 6
    //   180: getfield 236	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$SubBundleConfig:mSupportVersions	Ljava/util/List;
    //   183: aload 8
    //   185: iload_3
    //   186: invokevirtual 239	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   189: invokeinterface 243 2 0
    //   194: pop
    //   195: iload_3
    //   196: iconst_1
    //   197: iadd
    //   198: istore_3
    //   199: goto -30 -> 169
    //   202: aload 7
    //   204: ldc 245
    //   206: invokevirtual 212	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   209: astore 7
    //   211: aload 7
    //   213: ifnull +306 -> 519
    //   216: iconst_0
    //   217: istore_3
    //   218: iload_3
    //   219: aload 7
    //   221: invokevirtual 217	org/json/JSONArray:length	()I
    //   224: if_icmpge +295 -> 519
    //   227: aload 7
    //   229: iload_3
    //   230: invokevirtual 221	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   233: astore 9
    //   235: new 132	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$BundleConfigItem
    //   238: dup
    //   239: invokespecial 246	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$BundleConfigItem:<init>	()V
    //   242: astore 8
    //   244: aload 8
    //   246: aload 9
    //   248: ldc 248
    //   250: invokevirtual 228	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   253: putfield 251	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$BundleConfigItem:mName	Ljava/lang/String;
    //   256: aload 9
    //   258: ldc 253
    //   260: invokevirtual 212	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   263: astore 10
    //   265: iconst_0
    //   266: istore 4
    //   268: iload 4
    //   270: aload 10
    //   272: invokevirtual 217	org/json/JSONArray:length	()I
    //   275: if_icmpge +30 -> 305
    //   278: aload 8
    //   280: getfield 256	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$BundleConfigItem:mPreLoadList	Ljava/util/List;
    //   283: aload 10
    //   285: iload 4
    //   287: invokevirtual 239	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   290: invokeinterface 243 2 0
    //   295: pop
    //   296: iload 4
    //   298: iconst_1
    //   299: iadd
    //   300: istore 4
    //   302: goto -34 -> 268
    //   305: aload 9
    //   307: ldc_w 258
    //   310: invokevirtual 212	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   313: astore 10
    //   315: iconst_0
    //   316: istore 4
    //   318: iload 4
    //   320: aload 10
    //   322: invokevirtual 217	org/json/JSONArray:length	()I
    //   325: if_icmpge +30 -> 355
    //   328: aload 8
    //   330: getfield 261	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$BundleConfigItem:mPrefetchList	Ljava/util/List;
    //   333: aload 10
    //   335: iload 4
    //   337: invokevirtual 239	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   340: invokeinterface 243 2 0
    //   345: pop
    //   346: iload 4
    //   348: iconst_1
    //   349: iadd
    //   350: istore 4
    //   352: goto -34 -> 318
    //   355: aload 9
    //   357: ldc_w 263
    //   360: invokevirtual 212	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   363: astore 9
    //   365: iconst_0
    //   366: istore 4
    //   368: iload 4
    //   370: aload 9
    //   372: invokevirtual 217	org/json/JSONArray:length	()I
    //   375: if_icmpge +121 -> 496
    //   378: aload 9
    //   380: iload 4
    //   382: invokevirtual 221	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   385: astore 10
    //   387: new 141	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$SSOListConfig
    //   390: dup
    //   391: invokespecial 264	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$SSOListConfig:<init>	()V
    //   394: astore 11
    //   396: aload 11
    //   398: aload 10
    //   400: ldc_w 266
    //   403: invokevirtual 228	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   406: putfield 269	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$SSOListConfig:mType	Ljava/lang/String;
    //   409: aload 11
    //   411: aload 10
    //   413: ldc_w 271
    //   416: invokevirtual 228	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   419: putfield 274	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$SSOListConfig:mKey	Ljava/lang/String;
    //   422: aload 11
    //   424: aload 10
    //   426: ldc_w 276
    //   429: invokevirtual 228	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   432: putfield 279	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$SSOListConfig:mCmd	Ljava/lang/String;
    //   435: aload 11
    //   437: aload 10
    //   439: ldc_w 281
    //   442: invokevirtual 228	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   445: putfield 284	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$SSOListConfig:mMethod	Ljava/lang/String;
    //   448: aload 11
    //   450: aload 10
    //   452: ldc_w 286
    //   455: invokevirtual 290	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   458: putfield 293	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$SSOListConfig:mNeedCookie	Z
    //   461: aload 11
    //   463: aload 10
    //   465: ldc_w 295
    //   468: invokevirtual 228	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   471: putfield 298	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$SSOListConfig:mParam	Ljava/lang/String;
    //   474: aload 8
    //   476: getfield 136	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$BundleConfigItem:mSSOList	Ljava/util/List;
    //   479: aload 11
    //   481: invokeinterface 243 2 0
    //   486: pop
    //   487: iload 4
    //   489: iconst_1
    //   490: iadd
    //   491: istore 4
    //   493: goto -125 -> 368
    //   496: aload 6
    //   498: getfield 130	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$SubBundleConfig:mSubConfigs	Ljava/util/HashMap;
    //   501: aload 8
    //   503: getfield 251	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$BundleConfigItem:mName	Ljava/lang/String;
    //   506: aload 8
    //   508: invokevirtual 302	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   511: pop
    //   512: iload_3
    //   513: iconst_1
    //   514: iadd
    //   515: istore_3
    //   516: goto -298 -> 218
    //   519: aload_0
    //   520: getfield 32	com/tencent/hippy/qq/patchbundle/PatchBundleConfig:mSubBundleConfigs	Ljava/util/HashMap;
    //   523: aload 6
    //   525: getfield 231	com/tencent/hippy/qq/patchbundle/PatchBundleConfig$SubBundleConfig:mBusinessName	Ljava/lang/String;
    //   528: aload 6
    //   530: invokevirtual 302	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   533: pop
    //   534: iload_2
    //   535: iconst_1
    //   536: iadd
    //   537: istore_2
    //   538: goto -421 -> 117
    //   541: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   544: ifeq +72 -> 616
    //   547: new 175	java/lang/StringBuilder
    //   550: dup
    //   551: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   554: astore_1
    //   555: aload_1
    //   556: ldc_w 304
    //   559: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: pop
    //   563: aload_1
    //   564: aload_0
    //   565: getfield 32	com/tencent/hippy/qq/patchbundle/PatchBundleConfig:mSubBundleConfigs	Ljava/util/HashMap;
    //   568: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   571: pop
    //   572: ldc 10
    //   574: iconst_2
    //   575: aload_1
    //   576: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   579: invokestatic 191	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   582: goto +34 -> 616
    //   585: astore_1
    //   586: goto +33 -> 619
    //   589: astore_1
    //   590: ldc 10
    //   592: iconst_1
    //   593: aload_1
    //   594: iconst_0
    //   595: anewarray 4	java/lang/Object
    //   598: invokestatic 307	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   601: goto +15 -> 616
    //   604: astore_1
    //   605: ldc 10
    //   607: iconst_1
    //   608: aload_1
    //   609: iconst_0
    //   610: anewarray 4	java/lang/Object
    //   613: invokestatic 307	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   616: aload_0
    //   617: monitorexit
    //   618: return
    //   619: aload_0
    //   620: monitorexit
    //   621: goto +5 -> 626
    //   624: aload_1
    //   625: athrow
    //   626: goto -2 -> 624
    //   629: iconst_0
    //   630: istore 5
    //   632: goto -561 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	635	0	this	PatchBundleConfig
    //   0	635	1	paramFile	File
    //   83	455	2	i	int
    //   168	348	3	j	int
    //   266	226	4	k	int
    //   66	565	5	bool	boolean
    //   27	502	6	localObject1	Object
    //   130	98	7	localObject2	Object
    //   160	347	8	localObject3	Object
    //   233	146	9	localObject4	Object
    //   263	201	10	localObject5	Object
    //   394	86	11	localSSOListConfig	PatchBundleConfig.SSOListConfig
    // Exception table:
    //   from	to	target	type
    //   2	55	585	finally
    //   55	65	585	finally
    //   71	100	585	finally
    //   103	115	585	finally
    //   117	162	585	finally
    //   169	195	585	finally
    //   202	211	585	finally
    //   218	265	585	finally
    //   268	296	585	finally
    //   305	315	585	finally
    //   318	346	585	finally
    //   355	365	585	finally
    //   368	487	585	finally
    //   496	512	585	finally
    //   519	534	585	finally
    //   541	582	585	finally
    //   590	601	585	finally
    //   605	616	585	finally
    //   2	55	589	java/lang/Exception
    //   55	65	589	java/lang/Exception
    //   71	100	589	java/lang/Exception
    //   103	115	589	java/lang/Exception
    //   117	162	589	java/lang/Exception
    //   169	195	589	java/lang/Exception
    //   202	211	589	java/lang/Exception
    //   218	265	589	java/lang/Exception
    //   268	296	589	java/lang/Exception
    //   305	315	589	java/lang/Exception
    //   318	346	589	java/lang/Exception
    //   355	365	589	java/lang/Exception
    //   368	487	589	java/lang/Exception
    //   496	512	589	java/lang/Exception
    //   519	534	589	java/lang/Exception
    //   541	582	589	java/lang/Exception
    //   2	55	604	java/io/IOException
    //   55	65	604	java/io/IOException
    //   71	100	604	java/io/IOException
    //   103	115	604	java/io/IOException
    //   117	162	604	java/io/IOException
    //   169	195	604	java/io/IOException
    //   202	211	604	java/io/IOException
    //   218	265	604	java/io/IOException
    //   268	296	604	java/io/IOException
    //   305	315	604	java/io/IOException
    //   318	346	604	java/io/IOException
    //   355	365	604	java/io/IOException
    //   368	487	604	java/io/IOException
    //   496	512	604	java/io/IOException
    //   519	534	604	java/io/IOException
    //   541	582	604	java/io/IOException
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.patchbundle.PatchBundleConfig
 * JD-Core Version:    0.7.0.1
 */