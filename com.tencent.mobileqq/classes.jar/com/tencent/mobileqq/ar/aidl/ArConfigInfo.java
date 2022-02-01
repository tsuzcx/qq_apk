package com.tencent.mobileqq.ar.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.ArConfigUtils;
import com.tencent.mobileqq.ar.model.ArAwardInfo;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.mobileqq.ar.model.ArModelResource;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.ar.model.ArWebInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

public class ArConfigInfo
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<ArConfigInfo> CREATOR = new ArConfigInfo.1();
  public static final String TAG = "ArConfigInfo";
  public static final int VERSION_700 = 10;
  public static final int VERSION_710 = 11;
  public static final int VERSION_715 = 12;
  public static final int VERSION_718 = 13;
  public static final int VERSION_720 = 14;
  public static final int VERSION_739 = 19;
  public static final int VERSION_760 = 20;
  public long aRBegin;
  public long aRCloudBegin = 0L;
  public long aRCloudCacheExpireTime = 0L;
  public long aRCloudEnd = 0L;
  public long aREnd;
  public ArrayList<ArCloudConfigInfo> mArCloudConfigInfos = new ArrayList();
  public boolean saveConfig = true;
  public String scanLine1;
  public String scanLine2;
  public String scanLineLink;
  public String scanLinkUrl;
  public int version;
  
  public ArConfigInfo() {}
  
  protected ArConfigInfo(Parcel paramParcel)
  {
    try
    {
      int i = paramParcel.readInt();
      ArCloudConfigInfo.h = i;
      if (i >= 10) {
        this.version = paramParcel.readInt();
      }
      boolean bool = false;
      if (i < 14) {
        this.version = 0;
      } else {
        this.version = i;
      }
      this.aRBegin = paramParcel.readLong();
      this.aREnd = paramParcel.readLong();
      this.scanLine1 = paramParcel.readString();
      this.scanLine2 = paramParcel.readString();
      this.scanLineLink = paramParcel.readString();
      this.scanLinkUrl = paramParcel.readString();
      this.mArCloudConfigInfos = paramParcel.createTypedArrayList(ArCloudConfigInfo.CREATOR);
      this.aRCloudBegin = paramParcel.readLong();
      this.aRCloudEnd = paramParcel.readLong();
      this.aRCloudCacheExpireTime = paramParcel.readLong();
      if (paramParcel.readByte() != 0) {
        bool = true;
      }
      this.saveConfig = bool;
      return;
    }
    catch (Exception paramParcel)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ArConfigInfo read fail");
      localStringBuilder.append(paramParcel.getMessage());
      QLog.i("ArConfigInfo", 1, localStringBuilder.toString());
    }
  }
  
  public static void deleteConfigFile(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("deleteConfigFile. uin = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("ArConfigInfo", 2, ((StringBuilder)localObject).toString());
    }
    if (paramString == null) {
      return;
    }
    Object localObject = BaseApplicationImpl.sApplication.getFilesDir().getPath();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ar_file_config_v739_");
    localStringBuilder.append(paramString);
    deleteConfigFile((String)localObject, localStringBuilder.toString());
  }
  
  public static void deleteConfigFile(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("deleteConfigFile. dir = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", filename = ");
      localStringBuilder.append(paramString2);
      QLog.d("ArConfigInfo", 2, localStringBuilder.toString());
    }
    if ((paramString1 != null) && (!paramString1.equals("")) && (paramString2 != null))
    {
      if (paramString2.equals("")) {
        return;
      }
      paramString1 = new File(paramString1, paramString2);
      if (paramString1.exists()) {
        paramString1.delete();
      }
    }
  }
  
  public static ArConfigInfo loadConfigFromFile(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("loadConfigFromFile. uin = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("ArConfigInfo", 2, ((StringBuilder)localObject).toString());
    }
    if (paramString == null) {
      return null;
    }
    Object localObject = BaseApplicationImpl.sApplication.getFilesDir().getPath();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ar_file_config_v739_");
    localStringBuilder.append(paramString);
    return loadConfigFromFile((String)localObject, localStringBuilder.toString());
  }
  
  /* Error */
  public static ArConfigInfo loadConfigFromFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +47 -> 50
    //   6: new 117	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   13: astore_2
    //   14: aload_2
    //   15: ldc 200
    //   17: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload_2
    //   22: aload_0
    //   23: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload_2
    //   28: ldc 171
    //   30: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload_2
    //   35: aload_1
    //   36: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: ldc 15
    //   42: iconst_2
    //   43: aload_2
    //   44: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 147	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: aconst_null
    //   51: astore_3
    //   52: aconst_null
    //   53: astore 6
    //   55: aload_3
    //   56: astore_2
    //   57: aload_0
    //   58: ifnull +601 -> 659
    //   61: aload_3
    //   62: astore_2
    //   63: aload_0
    //   64: ldc 173
    //   66: invokevirtual 179	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   69: ifne +590 -> 659
    //   72: aload_3
    //   73: astore_2
    //   74: aload_1
    //   75: ifnull +584 -> 659
    //   78: aload_1
    //   79: ldc 173
    //   81: invokevirtual 179	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   84: ifeq +5 -> 89
    //   87: aconst_null
    //   88: areturn
    //   89: new 159	java/io/File
    //   92: dup
    //   93: aload_0
    //   94: aload_1
    //   95: invokespecial 181	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: astore 7
    //   100: aload_3
    //   101: astore_2
    //   102: aload 7
    //   104: invokevirtual 184	java/io/File:exists	()Z
    //   107: ifeq +552 -> 659
    //   110: new 202	java/io/FileInputStream
    //   113: dup
    //   114: aload 7
    //   116: invokespecial 205	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   119: astore_0
    //   120: new 207	java/io/BufferedInputStream
    //   123: dup
    //   124: aload_0
    //   125: invokespecial 210	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   128: astore 5
    //   130: aload_0
    //   131: astore_1
    //   132: aload 5
    //   134: astore_2
    //   135: aload_0
    //   136: invokevirtual 213	java/io/FileInputStream:available	()I
    //   139: newarray byte
    //   141: astore_3
    //   142: aload_0
    //   143: astore_1
    //   144: aload 5
    //   146: astore_2
    //   147: aload 5
    //   149: aload_3
    //   150: invokevirtual 217	java/io/BufferedInputStream:read	([B)I
    //   153: pop
    //   154: aload_0
    //   155: astore_1
    //   156: aload 5
    //   158: astore_2
    //   159: invokestatic 221	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   162: astore 4
    //   164: aload_0
    //   165: astore_1
    //   166: aload 5
    //   168: astore_2
    //   169: aload 4
    //   171: aload_3
    //   172: iconst_0
    //   173: aload_3
    //   174: arraylength
    //   175: invokevirtual 225	android/os/Parcel:unmarshall	([BII)V
    //   178: aload_0
    //   179: astore_1
    //   180: aload 5
    //   182: astore_2
    //   183: aload 4
    //   185: iconst_0
    //   186: invokevirtual 229	android/os/Parcel:setDataPosition	(I)V
    //   189: aload_0
    //   190: astore_1
    //   191: aload 5
    //   193: astore_2
    //   194: getstatic 55	com/tencent/mobileqq/ar/aidl/ArConfigInfo:CREATOR	Landroid/os/Parcelable$Creator;
    //   197: aload 4
    //   199: invokeinterface 235 2 0
    //   204: checkcast 2	com/tencent/mobileqq/ar/aidl/ArConfigInfo
    //   207: astore_3
    //   208: aload_0
    //   209: astore_1
    //   210: aload 5
    //   212: astore_2
    //   213: new 59	java/util/ArrayList
    //   216: dup
    //   217: invokespecial 60	java/util/ArrayList:<init>	()V
    //   220: pop
    //   221: aload_0
    //   222: astore_1
    //   223: aload 5
    //   225: astore_2
    //   226: aload_3
    //   227: getfield 62	com/tencent/mobileqq/ar/aidl/ArConfigInfo:mArCloudConfigInfos	Ljava/util/ArrayList;
    //   230: astore 8
    //   232: aload_0
    //   233: astore_1
    //   234: aload 5
    //   236: astore_2
    //   237: aload_3
    //   238: getfield 62	com/tencent/mobileqq/ar/aidl/ArConfigInfo:mArCloudConfigInfos	Ljava/util/ArrayList;
    //   241: invokevirtual 239	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   244: astore 9
    //   246: aload_0
    //   247: astore_1
    //   248: aload 5
    //   250: astore_2
    //   251: aload 9
    //   253: invokeinterface 244 1 0
    //   258: ifeq +49 -> 307
    //   261: aload_0
    //   262: astore_1
    //   263: aload 5
    //   265: astore_2
    //   266: aload 9
    //   268: invokeinterface 248 1 0
    //   273: checkcast 81	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo
    //   276: astore 10
    //   278: aload_0
    //   279: astore_1
    //   280: aload 5
    //   282: astore_2
    //   283: aload 10
    //   285: getfield 251	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:p	Z
    //   288: ifne -42 -> 246
    //   291: aload_0
    //   292: astore_1
    //   293: aload 5
    //   295: astore_2
    //   296: aload 8
    //   298: aload 10
    //   300: invokevirtual 254	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   303: pop
    //   304: goto -58 -> 246
    //   307: aload_0
    //   308: astore_1
    //   309: aload 5
    //   311: astore_2
    //   312: aload_3
    //   313: aload 8
    //   315: putfield 62	com/tencent/mobileqq/ar/aidl/ArConfigInfo:mArCloudConfigInfos	Ljava/util/ArrayList;
    //   318: goto +65 -> 383
    //   321: astore 8
    //   323: aload_0
    //   324: astore_1
    //   325: aload 5
    //   327: astore_2
    //   328: new 117	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   335: astore 9
    //   337: aload_0
    //   338: astore_1
    //   339: aload 5
    //   341: astore_2
    //   342: aload 9
    //   344: ldc_w 256
    //   347: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: pop
    //   351: aload_0
    //   352: astore_1
    //   353: aload 5
    //   355: astore_2
    //   356: aload 9
    //   358: aload 8
    //   360: invokevirtual 127	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   363: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: pop
    //   367: aload_0
    //   368: astore_1
    //   369: aload 5
    //   371: astore_2
    //   372: ldc 15
    //   374: iconst_1
    //   375: aload 9
    //   377: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   380: invokestatic 136	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   383: aload_0
    //   384: astore_1
    //   385: aload 5
    //   387: astore_2
    //   388: aload 4
    //   390: invokevirtual 259	android/os/Parcel:recycle	()V
    //   393: aload 5
    //   395: invokevirtual 262	java/io/BufferedInputStream:close	()V
    //   398: goto +8 -> 406
    //   401: astore_1
    //   402: aload_1
    //   403: invokevirtual 265	java/io/IOException:printStackTrace	()V
    //   406: aload_0
    //   407: invokevirtual 266	java/io/FileInputStream:close	()V
    //   410: goto +8 -> 418
    //   413: astore_0
    //   414: aload_0
    //   415: invokevirtual 265	java/io/IOException:printStackTrace	()V
    //   418: aload_3
    //   419: astore_0
    //   420: goto +158 -> 578
    //   423: astore 4
    //   425: aload_0
    //   426: astore_3
    //   427: aload 5
    //   429: astore_0
    //   430: goto +34 -> 464
    //   433: astore_1
    //   434: aconst_null
    //   435: astore_2
    //   436: goto +189 -> 625
    //   439: astore 4
    //   441: aconst_null
    //   442: astore_1
    //   443: aload_0
    //   444: astore_3
    //   445: aload_1
    //   446: astore_0
    //   447: goto +17 -> 464
    //   450: astore_1
    //   451: aconst_null
    //   452: astore_2
    //   453: aload_2
    //   454: astore_0
    //   455: goto +170 -> 625
    //   458: astore 4
    //   460: aconst_null
    //   461: astore_3
    //   462: aload_3
    //   463: astore_0
    //   464: aload_3
    //   465: astore_1
    //   466: aload_0
    //   467: astore_2
    //   468: aload 7
    //   470: invokevirtual 187	java/io/File:delete	()Z
    //   473: pop
    //   474: aload_3
    //   475: astore_1
    //   476: aload_0
    //   477: astore_2
    //   478: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   481: ifeq +56 -> 537
    //   484: aload_3
    //   485: astore_1
    //   486: aload_0
    //   487: astore_2
    //   488: new 117	java/lang/StringBuilder
    //   491: dup
    //   492: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   495: astore 5
    //   497: aload_3
    //   498: astore_1
    //   499: aload_0
    //   500: astore_2
    //   501: aload 5
    //   503: ldc_w 268
    //   506: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: pop
    //   510: aload_3
    //   511: astore_1
    //   512: aload_0
    //   513: astore_2
    //   514: aload 5
    //   516: aload 4
    //   518: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   521: pop
    //   522: aload_3
    //   523: astore_1
    //   524: aload_0
    //   525: astore_2
    //   526: ldc 15
    //   528: iconst_2
    //   529: aload 5
    //   531: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   534: invokestatic 274	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   537: aload_0
    //   538: ifnull +15 -> 553
    //   541: aload_0
    //   542: invokevirtual 262	java/io/BufferedInputStream:close	()V
    //   545: goto +8 -> 553
    //   548: astore_0
    //   549: aload_0
    //   550: invokevirtual 265	java/io/IOException:printStackTrace	()V
    //   553: aload 6
    //   555: astore_0
    //   556: aload_3
    //   557: ifnull +21 -> 578
    //   560: aload_3
    //   561: invokevirtual 266	java/io/FileInputStream:close	()V
    //   564: aload 6
    //   566: astore_0
    //   567: goto +11 -> 578
    //   570: astore_0
    //   571: aload_0
    //   572: invokevirtual 265	java/io/IOException:printStackTrace	()V
    //   575: aload 6
    //   577: astore_0
    //   578: aload_0
    //   579: astore_2
    //   580: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   583: ifeq +76 -> 659
    //   586: new 117	java/lang/StringBuilder
    //   589: dup
    //   590: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   593: astore_1
    //   594: aload_1
    //   595: ldc_w 276
    //   598: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: pop
    //   602: aload_1
    //   603: aload_0
    //   604: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   607: pop
    //   608: ldc 15
    //   610: iconst_2
    //   611: aload_1
    //   612: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   615: invokestatic 147	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   618: aload_0
    //   619: areturn
    //   620: astore_3
    //   621: aload_1
    //   622: astore_0
    //   623: aload_3
    //   624: astore_1
    //   625: aload_2
    //   626: ifnull +15 -> 641
    //   629: aload_2
    //   630: invokevirtual 262	java/io/BufferedInputStream:close	()V
    //   633: goto +8 -> 641
    //   636: astore_2
    //   637: aload_2
    //   638: invokevirtual 265	java/io/IOException:printStackTrace	()V
    //   641: aload_0
    //   642: ifnull +15 -> 657
    //   645: aload_0
    //   646: invokevirtual 266	java/io/FileInputStream:close	()V
    //   649: goto +8 -> 657
    //   652: astore_0
    //   653: aload_0
    //   654: invokevirtual 265	java/io/IOException:printStackTrace	()V
    //   657: aload_1
    //   658: athrow
    //   659: aload_2
    //   660: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	661	0	paramString1	String
    //   0	661	1	paramString2	String
    //   13	617	2	localObject1	Object
    //   636	24	2	localIOException	java.io.IOException
    //   51	510	3	localObject2	Object
    //   620	4	3	localObject3	Object
    //   162	227	4	localParcel	Parcel
    //   423	1	4	localThrowable1	java.lang.Throwable
    //   439	1	4	localThrowable2	java.lang.Throwable
    //   458	59	4	localThrowable3	java.lang.Throwable
    //   128	402	5	localObject4	Object
    //   53	523	6	localObject5	Object
    //   98	371	7	localFile	File
    //   230	84	8	localArrayList	ArrayList
    //   321	38	8	localException	Exception
    //   244	132	9	localObject6	Object
    //   276	23	10	localArCloudConfigInfo	ArCloudConfigInfo
    // Exception table:
    //   from	to	target	type
    //   213	221	321	java/lang/Exception
    //   226	232	321	java/lang/Exception
    //   237	246	321	java/lang/Exception
    //   251	261	321	java/lang/Exception
    //   266	278	321	java/lang/Exception
    //   283	291	321	java/lang/Exception
    //   296	304	321	java/lang/Exception
    //   312	318	321	java/lang/Exception
    //   393	398	401	java/io/IOException
    //   406	410	413	java/io/IOException
    //   135	142	423	java/lang/Throwable
    //   147	154	423	java/lang/Throwable
    //   159	164	423	java/lang/Throwable
    //   169	178	423	java/lang/Throwable
    //   183	189	423	java/lang/Throwable
    //   194	208	423	java/lang/Throwable
    //   213	221	423	java/lang/Throwable
    //   226	232	423	java/lang/Throwable
    //   237	246	423	java/lang/Throwable
    //   251	261	423	java/lang/Throwable
    //   266	278	423	java/lang/Throwable
    //   283	291	423	java/lang/Throwable
    //   296	304	423	java/lang/Throwable
    //   312	318	423	java/lang/Throwable
    //   328	337	423	java/lang/Throwable
    //   342	351	423	java/lang/Throwable
    //   356	367	423	java/lang/Throwable
    //   372	383	423	java/lang/Throwable
    //   388	393	423	java/lang/Throwable
    //   120	130	433	finally
    //   120	130	439	java/lang/Throwable
    //   110	120	450	finally
    //   110	120	458	java/lang/Throwable
    //   541	545	548	java/io/IOException
    //   560	564	570	java/io/IOException
    //   135	142	620	finally
    //   147	154	620	finally
    //   159	164	620	finally
    //   169	178	620	finally
    //   183	189	620	finally
    //   194	208	620	finally
    //   213	221	620	finally
    //   226	232	620	finally
    //   237	246	620	finally
    //   251	261	620	finally
    //   266	278	620	finally
    //   283	291	620	finally
    //   296	304	620	finally
    //   312	318	620	finally
    //   328	337	620	finally
    //   342	351	620	finally
    //   356	367	620	finally
    //   372	383	620	finally
    //   388	393	620	finally
    //   468	474	620	finally
    //   478	484	620	finally
    //   488	497	620	finally
    //   501	510	620	finally
    //   514	522	620	finally
    //   526	537	620	finally
    //   629	633	636	java/io/IOException
    //   645	649	652	java/io/IOException
  }
  
  public static ArConfigInfo parseArConfig(String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("parseArConfig. xmlConfigContent:");
    ((StringBuilder)localObject1).append(paramString);
    QLog.i("ArConfigInfo", 1, ((StringBuilder)localObject1).toString());
    localObject1 = Xml.newPullParser();
    ArConfigInfo localArConfigInfo = new ArConfigInfo();
    int i;
    try
    {
      ((XmlPullParser)localObject1).setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
      i = ((XmlPullParser)localObject1).getEventType();
    }
    catch (Exception localException1)
    {
      Object localObject2;
      int m;
      Object localObject3;
      localArConfigInfo = null;
      localObject1 = localArConfigInfo;
      if (!QLog.isColorLevel()) {
        break label2358;
      }
      QLog.e("ArConfigInfo", 2, paramString, localException1);
      localObject1 = localArConfigInfo;
    }
    localObject2 = ((XmlPullParser)localObject1).getName();
    boolean bool = ((String)localObject2).equalsIgnoreCase("ScanAR");
    if (bool) {
      for (i = ((XmlPullParser)localObject1).next(); i != 1; i = ((XmlPullParser)localObject1).next()) {
        if (i == 2)
        {
          localObject2 = ((XmlPullParser)localObject1).getName();
          if (((String)localObject2).equalsIgnoreCase("Begin")) {
            localArConfigInfo.aRBegin = ArConfigUtils.a(((XmlPullParser)localObject1).nextText());
          } else if (((String)localObject2).equalsIgnoreCase("End")) {
            localArConfigInfo.aREnd = ArConfigUtils.a(((XmlPullParser)localObject1).nextText());
          } else if (((String)localObject2).equalsIgnoreCase("Scan_Line1")) {
            localArConfigInfo.scanLine1 = ((XmlPullParser)localObject1).nextText();
          } else if (((String)localObject2).equalsIgnoreCase("Scan_Line2")) {
            localArConfigInfo.scanLine2 = ((XmlPullParser)localObject1).nextText();
          } else if (((String)localObject2).equalsIgnoreCase("Scan_Line3")) {
            localArConfigInfo.scanLineLink = ((XmlPullParser)localObject1).nextText();
          } else if (((String)localObject2).equalsIgnoreCase("Scan_Line3_URL")) {
            localArConfigInfo.scanLinkUrl = ((XmlPullParser)localObject1).nextText();
          }
        }
        else
        {
          if ((i == 3) && (((XmlPullParser)localObject1).getName().equalsIgnoreCase("ScanAR"))) {
            break;
          }
        }
      }
    }
    int k;
    if (((String)localObject2).equalsIgnoreCase("Task"))
    {
      localObject2 = new ArCloudConfigInfo();
      m = ((XmlPullParser)localObject1).next();
      k = 0;
      i = 0;
      for (;;)
      {
        if (m != 1) {
          if (m == 2)
          {
            localObject3 = ((XmlPullParser)localObject1).getName();
            bool = ((String)localObject3).equalsIgnoreCase("BusinessId");
            if (!bool) {}
          }
        }
        try
        {
          ((ArCloudConfigInfo)localObject2).a = Integer.parseInt(((XmlPullParser)localObject1).nextText());
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          label417:
          break label417;
        }
        ((ArCloudConfigInfo)localObject2).a = k;
        break label2459;
        bool = ((String)localObject3).equalsIgnoreCase("LotterySet");
        if (bool) {}
        try
        {
          ((ArCloudConfigInfo)localObject2).g = Integer.parseInt(((XmlPullParser)localObject1).nextText());
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          label459:
          break label459;
        }
        ((ArCloudConfigInfo)localObject2).g = k;
        break label2459;
        if (((String)localObject3).equalsIgnoreCase("PicId"))
        {
          ((ArCloudConfigInfo)localObject2).f = ((XmlPullParser)localObject1).nextText();
          break label2459;
        }
        if (((String)localObject3).equalsIgnoreCase("SDKVersion"))
        {
          ((ArCloudConfigInfo)localObject2).b = ((XmlPullParser)localObject1).nextText();
          break label2459;
        }
        bool = ((String)localObject3).equalsIgnoreCase("TrackMode");
        if (bool) {}
        try
        {
          ((ArCloudConfigInfo)localObject2).d = Integer.parseInt(((XmlPullParser)localObject1).nextText());
        }
        catch (NumberFormatException localNumberFormatException3)
        {
          label553:
          break label553;
        }
        ((ArCloudConfigInfo)localObject2).d = k;
        break label2459;
        bool = ((String)localObject3).equalsIgnoreCase("Type");
        if (bool) {}
        try
        {
          ((ArCloudConfigInfo)localObject2).e = Integer.parseInt(((XmlPullParser)localObject1).nextText());
        }
        catch (NumberFormatException localNumberFormatException4)
        {
          label595:
          String str;
          break label595;
        }
        ((ArCloudConfigInfo)localObject2).e = k;
        break label2459;
        bool = ((String)localObject3).equalsIgnoreCase("Feature");
        j = i;
        if (bool)
        {
          localObject3 = new ArFeatureInfo();
          k = ((XmlPullParser)localObject1).next();
          for (i = j;; i = j)
          {
            if (k == 1) {
              break label2469;
            }
            if (k == 2)
            {
              str = ((XmlPullParser)localObject1).getName();
              if (str.equalsIgnoreCase("FeatureMD5"))
              {
                ((ArFeatureInfo)localObject3).a = ((XmlPullParser)localObject1).nextText();
                break;
              }
              bool = str.equalsIgnoreCase("FeatureSize");
              if (!bool) {}
            }
            try
            {
              ((ArFeatureInfo)localObject3).b = Long.parseLong(((XmlPullParser)localObject1).nextText());
            }
            catch (NumberFormatException localNumberFormatException5)
            {
              label718:
              break label718;
            }
            ((ArFeatureInfo)localObject3).b = 0L;
            break;
            if (!str.equalsIgnoreCase("FeatureUrl")) {
              break;
            }
            ((ArFeatureInfo)localObject3).c = ((XmlPullParser)localObject1).nextText();
            break;
            j = i;
            if (k == 3)
            {
              j = i;
              if (((XmlPullParser)localObject1).getName().equalsIgnoreCase("Feature"))
              {
                ((ArCloudConfigInfo)localObject2).j = ((ArFeatureInfo)localObject3);
                break label2469;
              }
            }
            label788:
            k = ((XmlPullParser)localObject1).next();
          }
        }
        if (((String)localObject3).equalsIgnoreCase("Web"))
        {
          localObject3 = new ArWebInfo();
          for (j = ((XmlPullParser)localObject1).next();; j = ((XmlPullParser)localObject1).next())
          {
            if (j == 1) {
              break label2486;
            }
            if (j == 2)
            {
              str = ((XmlPullParser)localObject1).getName();
              bool = str.equalsIgnoreCase("IsUrlTransparent");
              if (!bool) {}
            }
            try
            {
              if (Integer.parseInt(((XmlPullParser)localObject1).nextText()) != 1) {
                break;
              }
              bool = true;
              label883:
              ((ArWebInfo)localObject3).b = bool;
            }
            catch (NumberFormatException localNumberFormatException6)
            {
              label893:
              break label893;
            }
            ((ArWebInfo)localObject3).b = false;
            continue;
            bool = str.equalsIgnoreCase("IsUrlAutoJump");
            if (bool) {}
            try
            {
              if (Integer.parseInt(((XmlPullParser)localObject1).nextText()) != 1) {
                break label2480;
              }
              bool = true;
              label937:
              ((ArWebInfo)localObject3).a = bool;
            }
            catch (NumberFormatException localNumberFormatException7)
            {
              label947:
              break label947;
            }
            ((ArWebInfo)localObject3).a = false;
            continue;
            if (str.equalsIgnoreCase("WebJumpUrl"))
            {
              ((ArWebInfo)localObject3).c = ((XmlPullParser)localObject1).nextText();
              continue;
              if ((j == 3) && (((XmlPullParser)localObject1).getName().equalsIgnoreCase("Web")))
              {
                ((ArCloudConfigInfo)localObject2).m = ((ArWebInfo)localObject3);
                break label2486;
              }
            }
          }
        }
        if (((String)localObject3).equalsIgnoreCase("ModelResource"))
        {
          localObject3 = new ArModelResource();
          j = ((XmlPullParser)localObject1).next();
          label1052:
          if (j == 1) {
            break label2486;
          }
          if (j == 2)
          {
            str = ((XmlPullParser)localObject1).getName();
            bool = str.equalsIgnoreCase("ModelResourceSize");
            if (!bool) {}
          }
        }
        try
        {
          ((ArModelResource)localObject3).a = Integer.parseInt(((XmlPullParser)localObject1).nextText());
        }
        catch (NumberFormatException localNumberFormatException8)
        {
          label1105:
          break label1105;
        }
        ((ArModelResource)localObject3).a = 0L;
        break label1291;
        bool = str.equalsIgnoreCase("ModelRepeatTimes");
        if (!bool) {
          break;
        }
      }
    }
    label1291:
    label1330:
    label1382:
    label2022:
    try
    {
      ((ArModelResource)localObject3).f = Integer.parseInt(((XmlPullParser)localObject1).nextText());
    }
    catch (NumberFormatException localNumberFormatException9)
    {
      label1147:
      label1660:
      break label1147;
    }
    ((ArModelResource)localObject3).f = 0;
    break label1291;
    if (str.equalsIgnoreCase("ModelResourceMD5"))
    {
      ((ArModelResource)localObject3).b = ((XmlPullParser)localObject1).nextText();
    }
    else if (str.equalsIgnoreCase("ModelResourceUrl"))
    {
      ((ArModelResource)localObject3).c = ((XmlPullParser)localObject1).nextText();
    }
    else if (str.equalsIgnoreCase("ModelResourceBgMusic"))
    {
      ((ArModelResource)localObject3).d = ((XmlPullParser)localObject1).nextText();
    }
    else if (str.equalsIgnoreCase("ModelConfigFile"))
    {
      ((ArModelResource)localObject3).e = ((XmlPullParser)localObject1).nextText();
      break label1291;
      if ((j == 3) && (((XmlPullParser)localObject1).getName().equalsIgnoreCase("ModelResource")))
      {
        ((ArCloudConfigInfo)localObject2).k = ((ArModelResource)localObject3);
        break label2486;
      }
    }
    int j = ((XmlPullParser)localObject1).next();
    break label1052;
    if (((String)localObject3).equalsIgnoreCase("Award"))
    {
      localObject3 = new ArAwardInfo();
      j = ((XmlPullParser)localObject1).next();
      if (j == 1) {
        break label2486;
      }
      if (j == 2)
      {
        str = ((XmlPullParser)localObject1).getName();
        bool = str.equalsIgnoreCase("AwardDistance");
        if (!bool) {}
      }
    }
    label1569:
    label1702:
    label1848:
    label2110:
    label2269:
    try
    {
      ((ArAwardInfo)localObject3).a = Integer.parseInt(((XmlPullParser)localObject1).nextText());
    }
    catch (NumberFormatException localNumberFormatException10)
    {
      label1890:
      break label1382;
    }
    ((ArAwardInfo)localObject3).a = 0;
    break label1569;
    if (str.equalsIgnoreCase("NotPlayModel"))
    {
      if (Integer.parseInt(((XmlPullParser)localObject1).nextText()) == 1) {
        ((ArAwardInfo)localObject3).f = 0;
      } else {
        ((ArAwardInfo)localObject3).f = 1;
      }
    }
    else if (str.equalsIgnoreCase("BusinessBanner"))
    {
      ((ArAwardInfo)localObject3).b = ((XmlPullParser)localObject1).nextText();
    }
    else if (str.equalsIgnoreCase("BusinessLogo"))
    {
      ((ArAwardInfo)localObject3).c = ((XmlPullParser)localObject1).nextText();
    }
    else if (str.equalsIgnoreCase("BusinessName"))
    {
      ((ArAwardInfo)localObject3).d = ((XmlPullParser)localObject1).nextText();
    }
    else if (str.equalsIgnoreCase("BusinessWishing"))
    {
      ((ArAwardInfo)localObject3).e = ((XmlPullParser)localObject1).nextText();
      break label1569;
      if ((j == 3) && (((XmlPullParser)localObject1).getName().equalsIgnoreCase("Award")))
      {
        ((ArCloudConfigInfo)localObject2).l = ((ArAwardInfo)localObject3);
        break label2486;
      }
    }
    j = ((XmlPullParser)localObject1).next();
    break label1330;
    if (((String)localObject3).equalsIgnoreCase("VideoResource"))
    {
      localObject3 = new ArVideoResourceInfo();
      j = ((XmlPullParser)localObject1).next();
      for (;;)
      {
        if (j != 1)
        {
          if (j == 2)
          {
            str = ((XmlPullParser)localObject1).getName();
            bool = str.equalsIgnoreCase("VideoConnectType");
            if (!bool) {}
          }
          try
          {
            ((ArVideoResourceInfo)localObject3).a = Integer.parseInt(((XmlPullParser)localObject1).nextText());
          }
          catch (NumberFormatException localNumberFormatException11)
          {
            break label1660;
          }
          ((ArVideoResourceInfo)localObject3).a = 0;
          break label2491;
          bool = str.equalsIgnoreCase("VideoTrackMode");
          if (bool) {}
          try
          {
            ((ArVideoResourceInfo)localObject3).g = Integer.parseInt(((XmlPullParser)localObject1).nextText());
          }
          catch (NumberFormatException localNumberFormatException12)
          {
            break label1702;
          }
          ((ArVideoResourceInfo)localObject3).g = 0;
          break label2491;
          if (str.equalsIgnoreCase("VideoKeyingConfig"))
          {
            ((ArVideoResourceInfo)localObject3).c = ((XmlPullParser)localObject1).nextText();
            break label2491;
          }
          if (str.equalsIgnoreCase("VideoLayout"))
          {
            ((ArVideoResourceInfo)localObject3).d = ((XmlPullParser)localObject1).nextText();
            break label2491;
          }
          if (str.equalsIgnoreCase("VideoMD5"))
          {
            ((ArVideoResourceInfo)localObject3).e = ((XmlPullParser)localObject1).nextText();
            break label2491;
          }
          if (str.equalsIgnoreCase("VideoUrl"))
          {
            ((ArVideoResourceInfo)localObject3).i = ((XmlPullParser)localObject1).nextText();
            break label2491;
          }
          bool = str.equalsIgnoreCase("VideoRepeatTimes");
          if (bool) {}
          try
          {
            ((ArVideoResourceInfo)localObject3).f = Integer.parseInt(((XmlPullParser)localObject1).nextText());
          }
          catch (NumberFormatException localNumberFormatException13)
          {
            break label1848;
          }
          ((ArVideoResourceInfo)localObject3).f = 0;
          break label2491;
          bool = str.equalsIgnoreCase("VideoType");
          if (bool) {}
          try
          {
            ((ArVideoResourceInfo)localObject3).h = Integer.parseInt(((XmlPullParser)localObject1).nextText());
          }
          catch (NumberFormatException localNumberFormatException14)
          {
            break label1890;
          }
          ((ArVideoResourceInfo)localObject3).h = 0;
          break label2491;
          bool = str.equalsIgnoreCase("VideoSize");
          if (bool) {}
          try
          {
            ((ArVideoResourceInfo)localObject3).b = Long.parseLong(((XmlPullParser)localObject1).nextText());
          }
          catch (NumberFormatException localNumberFormatException15)
          {
            label1932:
            break label1932;
          }
          ((ArVideoResourceInfo)localObject3).b = 0L;
          break label2491;
          bool = str.equalsIgnoreCase("VideoTrackMode");
          if (!bool) {
            break label2491;
          }
          try
          {
            ((ArVideoResourceInfo)localObject3).g = Integer.parseInt(((XmlPullParser)localObject1).nextText());
          }
          catch (NumberFormatException localNumberFormatException16)
          {
            label1974:
            break label1974;
          }
          ((ArVideoResourceInfo)localObject3).g = 0;
          break label2022;
          k = 0;
          if ((j == 3) && (((XmlPullParser)localObject1).getName().equalsIgnoreCase("VideoResource")))
          {
            ((ArCloudConfigInfo)localObject2).i.add(localObject3);
            j = k;
            break label2494;
          }
          j = ((XmlPullParser)localObject1).next();
          continue;
          j = k;
          if (m != 3) {
            break label2494;
          }
          j = k;
          if (!((XmlPullParser)localObject1).getName().equalsIgnoreCase("Task")) {
            break label2494;
          }
          if (i != 0)
          {
            localArConfigInfo.mArCloudConfigInfos.add(localObject2);
            break label2269;
            label2077:
            m = ((XmlPullParser)localObject1).next();
            k = j;
            break;
            if (((String)localObject2).equalsIgnoreCase("Cloud"))
            {
              i = ((XmlPullParser)localObject1).next();
              if (i != 1) {
                if (i == 2)
                {
                  localObject2 = ((XmlPullParser)localObject1).getName();
                  if (((String)localObject2).equalsIgnoreCase("Begin"))
                  {
                    localArConfigInfo.aRCloudBegin = ArConfigUtils.a(((XmlPullParser)localObject1).nextText());
                    break label2497;
                  }
                  if (((String)localObject2).equalsIgnoreCase("End"))
                  {
                    localArConfigInfo.aRCloudEnd = ArConfigUtils.a(((XmlPullParser)localObject1).nextText());
                    break label2497;
                  }
                  bool = ((String)localObject2).equalsIgnoreCase("CacheExpireTime");
                  if (!bool) {
                    break label2497;
                  }
                }
              }
            }
          }
          try
          {
            localArConfigInfo.aRCloudCacheExpireTime = Long.valueOf(((XmlPullParser)localObject1).nextText()).longValue();
          }
          catch (Exception localException2)
          {
            label2223:
            break label2223;
          }
          localArConfigInfo.aRCloudCacheExpireTime = 1440L;
          break label2497;
          if ((i == 3) && (((XmlPullParser)localObject1).getName().equalsIgnoreCase("Cloud"))) {}
        }
      }
    }
    label2358:
    label2486:
    label2491:
    label2494:
    label2497:
    for (;;)
    {
      i = ((XmlPullParser)localObject1).next();
      break label2110;
      for (;;)
      {
        i = ((XmlPullParser)localObject1).next();
        while (i == 1)
        {
          localObject1 = localArConfigInfo;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("parseConfig success|config=");
            ((StringBuilder)localObject1).append(localArConfigInfo);
            QLog.d("ArConfigInfo", 2, ((StringBuilder)localObject1).toString());
            return localArConfigInfo;
          }
          return localObject1;
        }
        if (i == 2) {
          break;
        }
      }
      j = k;
      break label2494;
      j = 1;
      break label788;
      j = 0;
      break label2077;
      bool = false;
      break label883;
      bool = false;
      break label937;
      j = 0;
      break label2494;
      break label2022;
      break label2077;
    }
  }
  
  public static boolean saveArConfigToFile(ArConfigInfo paramArConfigInfo, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveArConfigToFile. uin = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("ArConfigInfo", 2, ((StringBuilder)localObject).toString());
    }
    if (paramString == null) {
      return false;
    }
    Object localObject = BaseApplicationImpl.sApplication.getFilesDir().getPath();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ar_file_config_v739_");
    localStringBuilder.append(paramString);
    return saveArConfigToFile(paramArConfigInfo, (String)localObject, localStringBuilder.toString());
  }
  
  /* Error */
  public static boolean saveArConfigToFile(ArConfigInfo paramArConfigInfo, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +54 -> 57
    //   6: new 117	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   13: astore 4
    //   15: aload 4
    //   17: ldc_w 546
    //   20: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 4
    //   26: aload_1
    //   27: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload 4
    //   33: ldc 171
    //   35: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload 4
    //   41: aload_2
    //   42: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: ldc 15
    //   48: iconst_2
    //   49: aload 4
    //   51: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 147	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: aload_0
    //   58: ifnull +349 -> 407
    //   61: aload_1
    //   62: ifnull +345 -> 407
    //   65: aload_1
    //   66: ldc 173
    //   68: invokevirtual 179	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   71: ifne +336 -> 407
    //   74: aload_2
    //   75: ifnull +332 -> 407
    //   78: aload_2
    //   79: ldc 173
    //   81: invokevirtual 179	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   84: ifeq +5 -> 89
    //   87: iconst_0
    //   88: ireturn
    //   89: new 159	java/io/File
    //   92: dup
    //   93: aload_1
    //   94: aload_2
    //   95: invokespecial 181	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: astore 7
    //   100: new 117	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   107: astore 4
    //   109: aload 4
    //   111: aload_2
    //   112: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload 4
    //   118: ldc_w 548
    //   121: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: new 159	java/io/File
    //   128: dup
    //   129: aload_1
    //   130: aload 4
    //   132: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokespecial 181	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: astore 8
    //   140: invokestatic 221	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   143: astore 6
    //   145: aload 6
    //   147: iconst_0
    //   148: invokevirtual 229	android/os/Parcel:setDataPosition	(I)V
    //   151: aload_0
    //   152: aload 6
    //   154: iconst_0
    //   155: invokevirtual 552	com/tencent/mobileqq/ar/aidl/ArConfigInfo:writeToParcel	(Landroid/os/Parcel;I)V
    //   158: aload 6
    //   160: invokevirtual 555	android/os/Parcel:marshall	()[B
    //   163: astore 9
    //   165: aload 7
    //   167: invokevirtual 558	java/io/File:getParentFile	()Ljava/io/File;
    //   170: astore_0
    //   171: aload_0
    //   172: invokevirtual 184	java/io/File:exists	()Z
    //   175: ifne +8 -> 183
    //   178: aload_0
    //   179: invokevirtual 561	java/io/File:mkdir	()Z
    //   182: pop
    //   183: aload 8
    //   185: invokevirtual 184	java/io/File:exists	()Z
    //   188: ifeq +9 -> 197
    //   191: aload 8
    //   193: invokevirtual 187	java/io/File:delete	()Z
    //   196: pop
    //   197: aconst_null
    //   198: astore_2
    //   199: aconst_null
    //   200: astore 4
    //   202: aconst_null
    //   203: astore 5
    //   205: new 563	java/io/FileOutputStream
    //   208: dup
    //   209: aload 8
    //   211: invokespecial 564	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   214: astore_0
    //   215: aload_0
    //   216: astore_1
    //   217: new 566	java/io/BufferedOutputStream
    //   220: dup
    //   221: aload_0
    //   222: invokespecial 569	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   225: astore 4
    //   227: aload 4
    //   229: aload 9
    //   231: invokevirtual 572	java/io/BufferedOutputStream:write	([B)V
    //   234: aload 4
    //   236: invokevirtual 575	java/io/BufferedOutputStream:flush	()V
    //   239: aload 8
    //   241: aload 7
    //   243: invokestatic 581	com/tencent/mobileqq/utils/FileUtils:renameFile	(Ljava/io/File;Ljava/io/File;)Z
    //   246: istore_3
    //   247: aload 6
    //   249: invokevirtual 259	android/os/Parcel:recycle	()V
    //   252: aload 4
    //   254: invokevirtual 582	java/io/BufferedOutputStream:close	()V
    //   257: goto +8 -> 265
    //   260: astore_1
    //   261: aload_1
    //   262: invokevirtual 265	java/io/IOException:printStackTrace	()V
    //   265: aload_0
    //   266: invokevirtual 583	java/io/FileOutputStream:close	()V
    //   269: iload_3
    //   270: ireturn
    //   271: astore_0
    //   272: aload_0
    //   273: invokevirtual 265	java/io/IOException:printStackTrace	()V
    //   276: iload_3
    //   277: ireturn
    //   278: astore_2
    //   279: goto +87 -> 366
    //   282: astore_1
    //   283: aload 4
    //   285: astore 5
    //   287: aload_1
    //   288: astore 4
    //   290: goto +18 -> 308
    //   293: astore 4
    //   295: goto +13 -> 308
    //   298: astore_2
    //   299: aconst_null
    //   300: astore_0
    //   301: goto +65 -> 366
    //   304: astore 4
    //   306: aconst_null
    //   307: astore_0
    //   308: aload_0
    //   309: astore_1
    //   310: aload 5
    //   312: astore_2
    //   313: aload 4
    //   315: invokevirtual 265	java/io/IOException:printStackTrace	()V
    //   318: aload 6
    //   320: invokevirtual 259	android/os/Parcel:recycle	()V
    //   323: aload 5
    //   325: ifnull +16 -> 341
    //   328: aload 5
    //   330: invokevirtual 582	java/io/BufferedOutputStream:close	()V
    //   333: goto +8 -> 341
    //   336: astore_1
    //   337: aload_1
    //   338: invokevirtual 265	java/io/IOException:printStackTrace	()V
    //   341: aload_0
    //   342: ifnull +14 -> 356
    //   345: aload_0
    //   346: invokevirtual 583	java/io/FileOutputStream:close	()V
    //   349: iconst_0
    //   350: ireturn
    //   351: astore_0
    //   352: aload_0
    //   353: invokevirtual 265	java/io/IOException:printStackTrace	()V
    //   356: iconst_0
    //   357: ireturn
    //   358: astore_0
    //   359: aload_2
    //   360: astore 4
    //   362: aload_0
    //   363: astore_2
    //   364: aload_1
    //   365: astore_0
    //   366: aload 6
    //   368: invokevirtual 259	android/os/Parcel:recycle	()V
    //   371: aload 4
    //   373: ifnull +16 -> 389
    //   376: aload 4
    //   378: invokevirtual 582	java/io/BufferedOutputStream:close	()V
    //   381: goto +8 -> 389
    //   384: astore_1
    //   385: aload_1
    //   386: invokevirtual 265	java/io/IOException:printStackTrace	()V
    //   389: aload_0
    //   390: ifnull +15 -> 405
    //   393: aload_0
    //   394: invokevirtual 583	java/io/FileOutputStream:close	()V
    //   397: goto +8 -> 405
    //   400: astore_0
    //   401: aload_0
    //   402: invokevirtual 265	java/io/IOException:printStackTrace	()V
    //   405: aload_2
    //   406: athrow
    //   407: iconst_0
    //   408: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	409	0	paramArConfigInfo	ArConfigInfo
    //   0	409	1	paramString1	String
    //   0	409	2	paramString2	String
    //   246	31	3	bool	boolean
    //   13	276	4	localObject1	Object
    //   293	1	4	localIOException1	java.io.IOException
    //   304	10	4	localIOException2	java.io.IOException
    //   360	17	4	str	String
    //   203	126	5	localObject2	Object
    //   143	224	6	localParcel	Parcel
    //   98	144	7	localFile1	File
    //   138	102	8	localFile2	File
    //   163	67	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   252	257	260	java/io/IOException
    //   265	269	271	java/io/IOException
    //   227	247	278	finally
    //   227	247	282	java/io/IOException
    //   217	227	293	java/io/IOException
    //   205	215	298	finally
    //   205	215	304	java/io/IOException
    //   328	333	336	java/io/IOException
    //   345	349	351	java/io/IOException
    //   217	227	358	finally
    //   313	318	358	finally
    //   376	381	384	java/io/IOException
    //   393	397	400	java/io/IOException
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public ArCloudConfigInfo getModelResByMd5(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      Iterator localIterator = this.mArCloudConfigInfos.iterator();
      while (localIterator.hasNext())
      {
        ArCloudConfigInfo localArCloudConfigInfo = (ArCloudConfigInfo)localIterator.next();
        if ((localArCloudConfigInfo.k != null) && (!TextUtils.isEmpty(localArCloudConfigInfo.k.b)))
        {
          boolean bool = paramString.equals(localArCloudConfigInfo.k.b);
          if (bool) {
            return localArCloudConfigInfo;
          }
        }
      }
      return null;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ArConfigInfo{");
    localStringBuffer.append("version='");
    localStringBuffer.append(this.version);
    localStringBuffer.append('\'');
    localStringBuffer.append(", aRBegin=");
    localStringBuffer.append(this.aRBegin);
    localStringBuffer.append(", aREnd=");
    localStringBuffer.append(this.aREnd);
    localStringBuffer.append(", scanLine1='");
    localStringBuffer.append(this.scanLine1);
    localStringBuffer.append('\'');
    localStringBuffer.append(", scanLine2='");
    localStringBuffer.append(this.scanLine2);
    localStringBuffer.append('\'');
    localStringBuffer.append(", scanLineLink='");
    localStringBuffer.append(this.scanLineLink);
    localStringBuffer.append('\'');
    localStringBuffer.append(", scanLinkUrl='");
    localStringBuffer.append(this.scanLinkUrl);
    localStringBuffer.append('\'');
    localStringBuffer.append(", aRCloudBegin=");
    localStringBuffer.append(this.aRCloudBegin);
    localStringBuffer.append('\'');
    localStringBuffer.append(", mArCloudConfigInfos=");
    localStringBuffer.append(this.mArCloudConfigInfos);
    localStringBuffer.append('\'');
    localStringBuffer.append(", aRCloudCacheExpireTime=");
    localStringBuffer.append(this.aRCloudCacheExpireTime);
    localStringBuffer.append('\'');
    localStringBuffer.append(", aRCloudEnd=");
    localStringBuffer.append(this.aRCloudEnd);
    localStringBuffer.append('\'');
    localStringBuffer.append(", saveConfig=");
    localStringBuffer.append(this.saveConfig);
    localStringBuffer.append('\'');
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.aidl.ArConfigInfo
 * JD-Core Version:    0.7.0.1
 */