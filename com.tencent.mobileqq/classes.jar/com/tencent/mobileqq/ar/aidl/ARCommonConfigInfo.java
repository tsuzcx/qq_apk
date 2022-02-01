package com.tencent.mobileqq.ar.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.ARRecognition;
import com.tencent.mobileqq.ar.ARRelationShipAIOMsg;
import com.tencent.mobileqq.ar.ARScanAR;
import com.tencent.mobileqq.ar.ArConfigUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class ARCommonConfigInfo
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<ARCommonConfigInfo> CREATOR = new ARCommonConfigInfo.1();
  public static final long DEFAULT_AR_CLOUD_UPLOAD_CHECK_TIMEOUT = 5000L;
  public static final long DEFAULT_AR_CLOUD_UPLOAD_DELAY = 2000L;
  public static final long DEFAULT_AR_LOCAL_START_DELAY = 0L;
  public static final long DEFAULT_NO_RESULT_CHECK_TIMEOUT = 8000L;
  public static final int LBS_LOCATION_CLOSE = 0;
  public static final int LBS_LOCATION_OPEN = 1;
  public static final String TAG = "AREngine_ARCommonConfigInfo";
  public long aRCloudBegin = 0L;
  public long aRCloudCacheExpireTime = 0L;
  public long aRCloudEnd = 0L;
  public ArrayList<ARScanAR> arControllers = new ArrayList();
  public long isEnableVideoRecord = 1L;
  public long mARCloudUploadCheckTime;
  public long mARCloudUploadDelayTime;
  public long mARLocalStartDelay;
  public long mARNoResultCheckTime;
  public ARRelationShipAIOMsg mARRelationShipAIOMsg;
  public ArrayList<ARCommonConfigInfo.NativeSoRes> nativeSoResList = new ArrayList();
  public String osId;
  public ArrayList<ARRecognition> recognitions = new ArrayList();
  public int switchLBSLocation = 0;
  public int switchRecogOpen;
  public String versionId;
  
  public ARCommonConfigInfo() {}
  
  public ARCommonConfigInfo(Parcel paramParcel)
  {
    this.versionId = paramParcel.readString();
    this.osId = paramParcel.readString();
    this.aRCloudBegin = paramParcel.readLong();
    this.aRCloudEnd = paramParcel.readLong();
    this.aRCloudCacheExpireTime = paramParcel.readLong();
    try
    {
      Object localObject1 = new ArrayList();
      paramParcel.readList((List)localObject1, ARScanAR.class.getClassLoader());
      localObject1 = ((ArrayList)localObject1).iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ARScanAR)((Iterator)localObject1).next();
        if (localObject2 != null) {
          this.arControllers.add(localObject2);
        }
      }
      this.switchRecogOpen = paramParcel.readInt();
      localObject1 = new ArrayList();
      paramParcel.readList((List)localObject1, ARRecognition.class.getClassLoader());
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ARRecognition)((Iterator)localObject1).next();
        if (localObject2 != null) {
          this.recognitions.add(localObject2);
        }
      }
      localObject1 = new ArrayList();
      paramParcel.readList((List)localObject1, ARCommonConfigInfo.NativeSoRes.class.getClassLoader());
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ARCommonConfigInfo.NativeSoRes)((Iterator)localObject1).next();
        if (localObject2 != null) {
          this.nativeSoResList.add(localObject2);
        }
      }
      this.mARNoResultCheckTime = paramParcel.readLong();
      this.mARCloudUploadCheckTime = paramParcel.readLong();
      this.mARCloudUploadDelayTime = paramParcel.readLong();
      this.mARLocalStartDelay = paramParcel.readLong();
      this.isEnableVideoRecord = paramParcel.readLong();
      this.mARRelationShipAIOMsg = ((ARRelationShipAIOMsg)paramParcel.readParcelable(ARRelationShipAIOMsg.class.getClassLoader()));
      this.switchLBSLocation = paramParcel.readInt();
      return;
    }
    catch (Exception|Error paramParcel) {}
  }
  
  public static void deleteConfigFile(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("deleteConfigFile. uin = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("AREngine_ARCommonConfigInfo", 2, ((StringBuilder)localObject).toString());
    }
    if (paramString == null) {
      return;
    }
    Object localObject = BaseApplicationImpl.sApplication.getFilesDir().getPath();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("common_file_config");
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
      QLog.d("AREngine_ARCommonConfigInfo", 2, localStringBuilder.toString());
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
  
  public static ARCommonConfigInfo loadConfigFromFile(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("loadConfigFromFile. uin = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("AREngine_ARCommonConfigInfo", 2, ((StringBuilder)localObject).toString());
    }
    if (paramString == null) {
      return null;
    }
    Object localObject = BaseApplicationImpl.sApplication.getFilesDir().getPath();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("common_file_config");
    localStringBuilder.append(paramString);
    return loadConfigFromFile((String)localObject, localStringBuilder.toString());
  }
  
  /* Error */
  public static ARCommonConfigInfo loadConfigFromFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 166	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +47 -> 50
    //   6: new 168	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   13: astore_2
    //   14: aload_2
    //   15: ldc 234
    //   17: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload_2
    //   22: aload_0
    //   23: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload_2
    //   28: ldc 206
    //   30: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload_2
    //   35: aload_1
    //   36: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: ldc 33
    //   42: iconst_2
    //   43: aload_2
    //   44: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: aconst_null
    //   51: astore 6
    //   53: aconst_null
    //   54: astore_3
    //   55: aconst_null
    //   56: astore 7
    //   58: aload_3
    //   59: astore_2
    //   60: aload_0
    //   61: ifnull +451 -> 512
    //   64: aload_3
    //   65: astore_2
    //   66: aload_0
    //   67: ldc 208
    //   69: invokevirtual 213	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   72: ifne +440 -> 512
    //   75: aload_3
    //   76: astore_2
    //   77: aload_1
    //   78: ifnull +434 -> 512
    //   81: aload_1
    //   82: ldc 208
    //   84: invokevirtual 213	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   87: ifeq +5 -> 92
    //   90: aconst_null
    //   91: areturn
    //   92: new 194	java/io/File
    //   95: dup
    //   96: aload_0
    //   97: aload_1
    //   98: invokespecial 215	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: astore 8
    //   103: aload_3
    //   104: astore_2
    //   105: aload 8
    //   107: invokevirtual 218	java/io/File:exists	()Z
    //   110: ifeq +402 -> 512
    //   113: new 236	java/io/FileInputStream
    //   116: dup
    //   117: aload 8
    //   119: invokespecial 239	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   122: astore_0
    //   123: new 241	java/io/BufferedInputStream
    //   126: dup
    //   127: aload_0
    //   128: invokespecial 244	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   131: astore 5
    //   133: aload_0
    //   134: astore_1
    //   135: aload 5
    //   137: astore_2
    //   138: aload_0
    //   139: invokevirtual 247	java/io/FileInputStream:available	()I
    //   142: newarray byte
    //   144: astore_3
    //   145: aload_0
    //   146: astore_1
    //   147: aload 5
    //   149: astore_2
    //   150: aload 5
    //   152: aload_3
    //   153: invokevirtual 251	java/io/BufferedInputStream:read	([B)I
    //   156: pop
    //   157: aload_0
    //   158: astore_1
    //   159: aload 5
    //   161: astore_2
    //   162: new 210	java/lang/String
    //   165: dup
    //   166: aload_3
    //   167: ldc 253
    //   169: invokespecial 256	java/lang/String:<init>	([BLjava/lang/String;)V
    //   172: astore_3
    //   173: aload_0
    //   174: astore_1
    //   175: aload 5
    //   177: astore_2
    //   178: invokestatic 166	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   181: ifeq +59 -> 240
    //   184: aload_0
    //   185: astore_1
    //   186: aload 5
    //   188: astore_2
    //   189: new 168	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   196: astore 4
    //   198: aload_0
    //   199: astore_1
    //   200: aload 5
    //   202: astore_2
    //   203: aload 4
    //   205: ldc_w 258
    //   208: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload_0
    //   213: astore_1
    //   214: aload 5
    //   216: astore_2
    //   217: aload 4
    //   219: aload_3
    //   220: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload_0
    //   225: astore_1
    //   226: aload 5
    //   228: astore_2
    //   229: ldc 33
    //   231: iconst_2
    //   232: aload 4
    //   234: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   240: aload_0
    //   241: astore_1
    //   242: aload 5
    //   244: astore_2
    //   245: aload_3
    //   246: invokestatic 261	com/tencent/mobileqq/ar/aidl/ARCommonConfigInfo:parseArConfig	(Ljava/lang/String;)Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   249: astore_3
    //   250: aload 5
    //   252: invokevirtual 264	java/io/BufferedInputStream:close	()V
    //   255: goto +8 -> 263
    //   258: astore_1
    //   259: aload_1
    //   260: invokevirtual 267	java/io/IOException:printStackTrace	()V
    //   263: aload_3
    //   264: astore_1
    //   265: aload_0
    //   266: invokevirtual 268	java/io/FileInputStream:close	()V
    //   269: aload_3
    //   270: astore_0
    //   271: goto +160 -> 431
    //   274: astore_0
    //   275: aload_0
    //   276: invokevirtual 267	java/io/IOException:printStackTrace	()V
    //   279: aload_1
    //   280: astore_0
    //   281: goto +150 -> 431
    //   284: astore 4
    //   286: aload_0
    //   287: astore_3
    //   288: aload 5
    //   290: astore_0
    //   291: goto +34 -> 325
    //   294: astore_1
    //   295: aconst_null
    //   296: astore_2
    //   297: goto +181 -> 478
    //   300: astore 4
    //   302: aconst_null
    //   303: astore_1
    //   304: aload_0
    //   305: astore_3
    //   306: aload_1
    //   307: astore_0
    //   308: goto +17 -> 325
    //   311: astore_1
    //   312: aconst_null
    //   313: astore_2
    //   314: aload_2
    //   315: astore_0
    //   316: goto +162 -> 478
    //   319: astore 4
    //   321: aconst_null
    //   322: astore_3
    //   323: aload_3
    //   324: astore_0
    //   325: aload_3
    //   326: astore_1
    //   327: aload_0
    //   328: astore_2
    //   329: aload 8
    //   331: invokevirtual 221	java/io/File:delete	()Z
    //   334: pop
    //   335: aload_3
    //   336: astore_1
    //   337: aload_0
    //   338: astore_2
    //   339: invokestatic 166	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   342: ifeq +56 -> 398
    //   345: aload_3
    //   346: astore_1
    //   347: aload_0
    //   348: astore_2
    //   349: new 168	java/lang/StringBuilder
    //   352: dup
    //   353: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   356: astore 5
    //   358: aload_3
    //   359: astore_1
    //   360: aload_0
    //   361: astore_2
    //   362: aload 5
    //   364: ldc_w 270
    //   367: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: pop
    //   371: aload_3
    //   372: astore_1
    //   373: aload_0
    //   374: astore_2
    //   375: aload 5
    //   377: aload 4
    //   379: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: aload_3
    //   384: astore_1
    //   385: aload_0
    //   386: astore_2
    //   387: ldc 33
    //   389: iconst_2
    //   390: aload 5
    //   392: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: invokestatic 276	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   398: aload_0
    //   399: ifnull +15 -> 414
    //   402: aload_0
    //   403: invokevirtual 264	java/io/BufferedInputStream:close	()V
    //   406: goto +8 -> 414
    //   409: astore_0
    //   410: aload_0
    //   411: invokevirtual 267	java/io/IOException:printStackTrace	()V
    //   414: aload 6
    //   416: astore_0
    //   417: aload_3
    //   418: ifnull +13 -> 431
    //   421: aload 7
    //   423: astore_1
    //   424: aload_3
    //   425: invokevirtual 268	java/io/FileInputStream:close	()V
    //   428: aload 6
    //   430: astore_0
    //   431: aload_0
    //   432: astore_2
    //   433: invokestatic 166	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   436: ifeq +76 -> 512
    //   439: new 168	java/lang/StringBuilder
    //   442: dup
    //   443: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   446: astore_1
    //   447: aload_1
    //   448: ldc_w 278
    //   451: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: pop
    //   455: aload_1
    //   456: aload_0
    //   457: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   460: pop
    //   461: ldc 33
    //   463: iconst_2
    //   464: aload_1
    //   465: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   468: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   471: aload_0
    //   472: areturn
    //   473: astore_3
    //   474: aload_1
    //   475: astore_0
    //   476: aload_3
    //   477: astore_1
    //   478: aload_2
    //   479: ifnull +15 -> 494
    //   482: aload_2
    //   483: invokevirtual 264	java/io/BufferedInputStream:close	()V
    //   486: goto +8 -> 494
    //   489: astore_2
    //   490: aload_2
    //   491: invokevirtual 267	java/io/IOException:printStackTrace	()V
    //   494: aload_0
    //   495: ifnull +15 -> 510
    //   498: aload_0
    //   499: invokevirtual 268	java/io/FileInputStream:close	()V
    //   502: goto +8 -> 510
    //   505: astore_0
    //   506: aload_0
    //   507: invokevirtual 267	java/io/IOException:printStackTrace	()V
    //   510: aload_1
    //   511: athrow
    //   512: aload_2
    //   513: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	514	0	paramString1	String
    //   0	514	1	paramString2	String
    //   13	470	2	localObject1	Object
    //   489	24	2	localIOException	java.io.IOException
    //   54	371	3	localObject2	Object
    //   473	4	3	localObject3	Object
    //   196	37	4	localStringBuilder	StringBuilder
    //   284	1	4	localThrowable1	java.lang.Throwable
    //   300	1	4	localThrowable2	java.lang.Throwable
    //   319	59	4	localThrowable3	java.lang.Throwable
    //   131	260	5	localObject4	Object
    //   51	378	6	localObject5	Object
    //   56	366	7	localObject6	Object
    //   101	229	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   250	255	258	java/io/IOException
    //   265	269	274	java/io/IOException
    //   424	428	274	java/io/IOException
    //   138	145	284	java/lang/Throwable
    //   150	157	284	java/lang/Throwable
    //   162	173	284	java/lang/Throwable
    //   178	184	284	java/lang/Throwable
    //   189	198	284	java/lang/Throwable
    //   203	212	284	java/lang/Throwable
    //   217	224	284	java/lang/Throwable
    //   229	240	284	java/lang/Throwable
    //   245	250	284	java/lang/Throwable
    //   123	133	294	finally
    //   123	133	300	java/lang/Throwable
    //   113	123	311	finally
    //   113	123	319	java/lang/Throwable
    //   402	406	409	java/io/IOException
    //   138	145	473	finally
    //   150	157	473	finally
    //   162	173	473	finally
    //   178	184	473	finally
    //   189	198	473	finally
    //   203	212	473	finally
    //   217	224	473	finally
    //   229	240	473	finally
    //   245	250	473	finally
    //   329	335	473	finally
    //   339	345	473	finally
    //   349	358	473	finally
    //   362	371	473	finally
    //   375	383	473	finally
    //   387	398	473	finally
    //   482	486	489	java/io/IOException
    //   498	502	505	java/io/IOException
  }
  
  public static ARCommonConfigInfo parseArConfig(String paramString)
  {
    Object localObject1 = Xml.newPullParser();
    ARCommonConfigInfo localARCommonConfigInfo = new ARCommonConfigInfo();
    int i;
    try
    {
      ((XmlPullParser)localObject1).setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
      i = ((XmlPullParser)localObject1).getEventType();
    }
    catch (Exception localException1)
    {
      Object localObject2;
      label146:
      localARCommonConfigInfo = null;
      localObject1 = localARCommonConfigInfo;
      if (!QLog.isColorLevel()) {
        break label2284;
      }
      QLog.e("AREngine_ARCommonConfigInfo", 2, paramString, localException1);
      localObject1 = localARCommonConfigInfo;
    }
    localObject2 = ((XmlPullParser)localObject1).getName();
    if (((String)localObject2).equalsIgnoreCase("VersionID")) {
      localARCommonConfigInfo.versionId = ((XmlPullParser)localObject1).nextText();
    } else if (((String)localObject2).equalsIgnoreCase("OSId")) {
      localARCommonConfigInfo.osId = ((XmlPullParser)localObject1).nextText();
    } else if (((String)localObject2).equalsIgnoreCase("ARNoResultCheckTime")) {
      localObject2 = ((XmlPullParser)localObject1).nextText();
    }
    try
    {
      localARCommonConfigInfo.mARNoResultCheckTime = (Long.valueOf((String)localObject2).longValue() * 1000L);
    }
    catch (Exception localException2)
    {
      break label146;
    }
    localARCommonConfigInfo.mARNoResultCheckTime = 8000L;
    break label2195;
    if (((String)localObject2).equalsIgnoreCase("ARLocalStartDelay")) {
      localObject2 = ((XmlPullParser)localObject1).nextText();
    }
    try
    {
      localARCommonConfigInfo.mARLocalStartDelay = (Long.valueOf((String)localObject2).longValue() * 1000L);
    }
    catch (Exception localException3)
    {
      label197:
      boolean bool;
      break label197;
    }
    localARCommonConfigInfo.mARLocalStartDelay = 0L;
    break label2195;
    bool = ((String)localObject2).equalsIgnoreCase("ScanAR");
    if (bool)
    {
      localObject2 = new ARScanAR();
      for (i = ((XmlPullParser)localObject1).next(); i != 1; i = ((XmlPullParser)localObject1).next()) {
        if (i == 2)
        {
          String str1 = ((XmlPullParser)localObject1).getName();
          if (str1.equalsIgnoreCase("EntryType"))
          {
            ((ARScanAR)localObject2).jdField_a_of_type_Int = Integer.valueOf(((XmlPullParser)localObject1).nextText()).intValue();
          }
          else if (str1.equalsIgnoreCase("Begin"))
          {
            ((ARScanAR)localObject2).jdField_a_of_type_Long = ArConfigUtils.a(((XmlPullParser)localObject1).nextText());
          }
          else if (str1.equalsIgnoreCase("End"))
          {
            ((ARScanAR)localObject2).jdField_b_of_type_Long = ArConfigUtils.a(((XmlPullParser)localObject1).nextText());
          }
          else if (str1.equalsIgnoreCase("UserGuideBeginTime"))
          {
            ((ARScanAR)localObject2).jdField_c_of_type_Long = ArConfigUtils.a(((XmlPullParser)localObject1).nextText());
          }
          else if (str1.equalsIgnoreCase("UserGuideEndTime"))
          {
            ((ARScanAR)localObject2).jdField_d_of_type_Long = ArConfigUtils.a(((XmlPullParser)localObject1).nextText());
          }
          else if (str1.equalsIgnoreCase("ActType"))
          {
            ((ARScanAR)localObject2).jdField_b_of_type_Int = Integer.valueOf(((XmlPullParser)localObject1).nextText()).intValue();
          }
          else
          {
            bool = str1.equalsIgnoreCase("UserGuideShowCount");
            if (bool)
            {
              try
              {
                ((ARScanAR)localObject2).jdField_c_of_type_Int = Integer.valueOf(((XmlPullParser)localObject1).nextText()).intValue();
              }
              catch (Exception localException8)
              {
                ((ARScanAR)localObject2).jdField_c_of_type_Int = 0;
                if (!QLog.isColorLevel()) {
                  continue;
                }
              }
              QLog.e("AREngine_ARCommonConfigInfo", 2, "UserGuideShowCount error", localException8);
            }
            else if (localException8.equalsIgnoreCase("ScanIconImg"))
            {
              ((ARScanAR)localObject2).jdField_a_of_type_JavaLangString = ((XmlPullParser)localObject1).nextText();
            }
            else if (localException8.equalsIgnoreCase("ScanIconMd5"))
            {
              ((ARScanAR)localObject2).jdField_b_of_type_JavaLangString = ((XmlPullParser)localObject1).nextText();
            }
            else if (localException8.equalsIgnoreCase("ScanIconPressed"))
            {
              ((ARScanAR)localObject2).jdField_c_of_type_JavaLangString = ((XmlPullParser)localObject1).nextText();
            }
            else if (localException8.equalsIgnoreCase("ScanIconPressedMd5"))
            {
              ((ARScanAR)localObject2).jdField_d_of_type_JavaLangString = ((XmlPullParser)localObject1).nextText();
            }
            else if (localException8.equalsIgnoreCase("ScanIconText"))
            {
              ((ARScanAR)localObject2).e = ((XmlPullParser)localObject1).nextText();
            }
            else if (localException8.equalsIgnoreCase("Scan_Line1"))
            {
              ((ARScanAR)localObject2).f = ((XmlPullParser)localObject1).nextText();
            }
            else if (localException8.equalsIgnoreCase("Scan_Line2"))
            {
              ((ARScanAR)localObject2).g = ((XmlPullParser)localObject1).nextText();
            }
            else if (localException8.equalsIgnoreCase("Scan_Line3"))
            {
              ((ARScanAR)localObject2).h = ((XmlPullParser)localObject1).nextText();
            }
            else if (localException8.equalsIgnoreCase("Scan_Line3_URL"))
            {
              ((ARScanAR)localObject2).i = ((XmlPullParser)localObject1).nextText();
            }
            else if (localException8.equalsIgnoreCase("What2ScanURL"))
            {
              ((ARScanAR)localObject2).j = ((XmlPullParser)localObject1).nextText();
            }
            else if (localException8.equalsIgnoreCase("UserGuideWording"))
            {
              ((ARScanAR)localObject2).k = ((XmlPullParser)localObject1).nextText();
            }
            else if (localException8.equalsIgnoreCase("UserGuideType"))
            {
              ((ARScanAR)localObject2).l = ((XmlPullParser)localObject1).nextText();
            }
          }
        }
        else if ((i == 3) && (((XmlPullParser)localObject1).getName().equalsIgnoreCase("ScanAR")))
        {
          localARCommonConfigInfo.arControllers.add(localObject2);
          break;
        }
      }
    }
    if (((String)localObject2).equalsIgnoreCase("switchRecogOpen"))
    {
      localARCommonConfigInfo.switchRecogOpen = Integer.valueOf(((XmlPullParser)localObject1).nextText()).intValue();
    }
    else if (((String)localObject2).equalsIgnoreCase("switchLBSLocation"))
    {
      localARCommonConfigInfo.switchLBSLocation = Integer.valueOf(((XmlPullParser)localObject1).nextText()).intValue();
    }
    else
    {
      if (((String)localObject2).equalsIgnoreCase("Recognition"))
      {
        localObject2 = new ARRecognition();
        for (i = ((XmlPullParser)localObject1).next(); i != 1; i = ((XmlPullParser)localObject1).next()) {
          if (i == 2)
          {
            String str2 = ((XmlPullParser)localObject1).getName();
            if (str2.equalsIgnoreCase("Type"))
            {
              ((ARRecognition)localObject2).jdField_a_of_type_Long = Integer.valueOf(((XmlPullParser)localObject1).nextText()).intValue();
            }
            else
            {
              bool = str2.equalsIgnoreCase("CloudRecogOpen");
              if (bool)
              {
                try
                {
                  ((ARRecognition)localObject2).jdField_a_of_type_Int = Integer.valueOf(((XmlPullParser)localObject1).nextText()).intValue();
                }
                catch (Exception localException9)
                {
                  localException9.printStackTrace();
                  ((ARRecognition)localObject2).jdField_a_of_type_Int = 1;
                }
              }
              else
              {
                bool = localException9.equalsIgnoreCase("LocalRecogOpen");
                if (bool)
                {
                  try
                  {
                    ((ARRecognition)localObject2).jdField_b_of_type_Int = Integer.valueOf(((XmlPullParser)localObject1).nextText()).intValue();
                  }
                  catch (Exception localException10)
                  {
                    localException10.printStackTrace();
                    ((ARRecognition)localObject2).jdField_b_of_type_Int = 1;
                  }
                }
                else
                {
                  bool = localException10.equalsIgnoreCase("Priority");
                  if (bool)
                  {
                    try
                    {
                      ((ARRecognition)localObject2).jdField_c_of_type_Int = Integer.valueOf(((XmlPullParser)localObject1).nextText()).intValue();
                    }
                    catch (Exception localException11)
                    {
                      localException11.printStackTrace();
                      ((ARRecognition)localObject2).jdField_c_of_type_Int = 5;
                    }
                  }
                  else
                  {
                    bool = localException11.equalsIgnoreCase("Wait_ms");
                    if (bool) {
                      try
                      {
                        ((ARRecognition)localObject2).jdField_b_of_type_Long = Long.valueOf(((XmlPullParser)localObject1).nextText()).longValue();
                      }
                      catch (Exception localException12)
                      {
                        localException12.printStackTrace();
                        ((ARRecognition)localObject2).jdField_b_of_type_Long = 3000L;
                      }
                    } else if (localException12.equalsIgnoreCase("ImagePreprocess")) {
                      for (i = ((XmlPullParser)localObject1).next(); i != 1; i = ((XmlPullParser)localObject1).next()) {
                        if (i == 2)
                        {
                          if (((XmlPullParser)localObject1).getName().equalsIgnoreCase("Open")) {
                            ((ARRecognition)localObject2).d = Integer.valueOf(((XmlPullParser)localObject1).nextText()).intValue();
                          }
                        }
                        else {
                          if ((i == 3) && (((XmlPullParser)localObject1).getName().equalsIgnoreCase("ImagePreprocess"))) {
                            break;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          else if ((i == 3) && (((XmlPullParser)localObject1).getName().equalsIgnoreCase("Recognition")))
          {
            localARCommonConfigInfo.recognitions.add(localObject2);
            break;
          }
        }
      }
      if (((String)localObject2).equalsIgnoreCase("ARVideoRecordSwitch")) {
        for (i = ((XmlPullParser)localObject1).next(); i != 1; i = ((XmlPullParser)localObject1).next()) {
          if (i == 2)
          {
            if (((XmlPullParser)localObject1).getName().equalsIgnoreCase("Enable")) {
              localARCommonConfigInfo.isEnableVideoRecord = Long.valueOf(((XmlPullParser)localObject1).nextText()).longValue();
            }
          }
          else {
            if ((i == 3) && (((XmlPullParser)localObject1).getName().equalsIgnoreCase("ARVideoRecordSwitch"))) {
              break;
            }
          }
        }
      }
      label1683:
      if (((String)localObject2).equalsIgnoreCase("Cloud")) {
        label1579:
        label1718:
        for (i = ((XmlPullParser)localObject1).next(); i != 1; i = ((XmlPullParser)localObject1).next())
        {
          if (i == 2)
          {
            localObject2 = ((XmlPullParser)localObject1).getName();
            if (((String)localObject2).equalsIgnoreCase("Begin"))
            {
              localARCommonConfigInfo.aRCloudBegin = ArConfigUtils.a(((XmlPullParser)localObject1).nextText());
              break label2330;
            }
            if (((String)localObject2).equalsIgnoreCase("End"))
            {
              localARCommonConfigInfo.aRCloudEnd = ArConfigUtils.a(((XmlPullParser)localObject1).nextText());
              break label2330;
            }
            bool = ((String)localObject2).equalsIgnoreCase("CacheExpireTime");
            if (!bool) {}
          }
          try
          {
            localARCommonConfigInfo.aRCloudCacheExpireTime = Long.valueOf(((XmlPullParser)localObject1).nextText()).longValue();
          }
          catch (Exception localException4)
          {
            break label1579;
          }
          localARCommonConfigInfo.aRCloudCacheExpireTime = 1440L;
          break label2330;
          if (((String)localObject2).equalsIgnoreCase("ARCloudUploadCheckTime")) {
            localObject2 = ((XmlPullParser)localObject1).nextText();
          }
          try
          {
            localARCommonConfigInfo.mARCloudUploadCheckTime = (Long.valueOf((String)localObject2).longValue() * 1000L);
          }
          catch (Exception localException5)
          {
            label1630:
            break label1630;
          }
          localARCommonConfigInfo.mARCloudUploadCheckTime = 5000L;
          break label2330;
          if (!((String)localObject2).equalsIgnoreCase("ARCloudUploadDelayTime")) {
            break label2330;
          }
          localObject2 = ((XmlPullParser)localObject1).nextText();
          try
          {
            l = Long.valueOf((String)localObject2).longValue();
          }
          catch (Exception localException6)
          {
            long l;
            String str4;
            break label1683;
          }
          try
          {
            localARCommonConfigInfo.mARCloudUploadDelayTime = (l * 1000L);
          }
          catch (Exception localException7)
          {
            break label1683;
          }
          localARCommonConfigInfo.mARCloudUploadDelayTime = 2000L;
          continue;
          if ((i == 3) && (((XmlPullParser)localObject1).getName().equalsIgnoreCase("Cloud"))) {
            break;
          }
        }
      }
      if (((String)localObject2).equalsIgnoreCase("NativeSoRes"))
      {
        localObject2 = new ARCommonConfigInfo.NativeSoRes();
        label1965:
        for (i = ((XmlPullParser)localObject1).next(); i != 1; i = ((XmlPullParser)localObject1).next()) {
          if (i == 2)
          {
            String str3 = ((XmlPullParser)localObject1).getName();
            if (str3.equalsIgnoreCase("Name"))
            {
              ((ARCommonConfigInfo.NativeSoRes)localObject2).jdField_a_of_type_JavaLangString = ((XmlPullParser)localObject1).nextText();
              break label2333;
            }
            if (str3.equalsIgnoreCase("Version"))
            {
              ((ARCommonConfigInfo.NativeSoRes)localObject2).jdField_b_of_type_JavaLangString = ((XmlPullParser)localObject1).nextText();
              break label2333;
            }
            if (str3.equalsIgnoreCase("Url"))
            {
              ((ARCommonConfigInfo.NativeSoRes)localObject2).jdField_c_of_type_JavaLangString = ((XmlPullParser)localObject1).nextText();
              break label2333;
            }
            if (str3.equalsIgnoreCase("Md5"))
            {
              ((ARCommonConfigInfo.NativeSoRes)localObject2).jdField_d_of_type_JavaLangString = ((XmlPullParser)localObject1).nextText();
              break label2333;
            }
            bool = str3.equalsIgnoreCase("Size");
            if (!bool) {
              break label2333;
            }
            try
            {
              ((ARCommonConfigInfo.NativeSoRes)localObject2).jdField_a_of_type_Long = Long.valueOf(((XmlPullParser)localObject1).nextText()).longValue();
            }
            catch (Exception localException13)
            {
              localException13.printStackTrace();
              ((ARCommonConfigInfo.NativeSoRes)localObject2).jdField_a_of_type_Long = 0L;
              continue;
            }
          }
          else if ((i == 3) && (((XmlPullParser)localObject1).getName().equalsIgnoreCase("NativeSoRes")))
          {
            localARCommonConfigInfo.nativeSoResList.add(localObject2);
            break;
          }
        }
      }
      if (((String)localObject2).equalsIgnoreCase("ARRelationShipAIOMsg"))
      {
        localObject2 = new ARRelationShipAIOMsg();
        i = ((XmlPullParser)localObject1).next();
        label2004:
        if (i != 1)
        {
          if (i == 2)
          {
            str4 = ((XmlPullParser)localObject1).getName();
            if (str4.equalsIgnoreCase("AIOMsgSourceName"))
            {
              ((ARRelationShipAIOMsg)localObject2).jdField_a_of_type_JavaLangString = ((XmlPullParser)localObject1).nextText();
              break label2336;
            }
            if (str4.equalsIgnoreCase("AIOMsgSourceIconUrl"))
            {
              ((ARRelationShipAIOMsg)localObject2).jdField_b_of_type_JavaLangString = ((XmlPullParser)localObject1).nextText();
              break label2336;
            }
            if (str4.equalsIgnoreCase("AIOMsgSourceAction"))
            {
              ((ARRelationShipAIOMsg)localObject2).jdField_c_of_type_JavaLangString = ((XmlPullParser)localObject1).nextText();
              break label2336;
            }
            if (str4.equalsIgnoreCase("AIOMsgSourceActionData"))
            {
              ((ARRelationShipAIOMsg)localObject2).jdField_d_of_type_JavaLangString = ((XmlPullParser)localObject1).nextText();
              break label2336;
            }
            if (!str4.equalsIgnoreCase("AIOMsgSourceUrl")) {
              break label2336;
            }
            ((ARRelationShipAIOMsg)localObject2).e = ((XmlPullParser)localObject1).nextText();
            break label2336;
          }
          if ((i == 3) && (((XmlPullParser)localObject1).getName().equalsIgnoreCase("ARRelationShipAIOMsg"))) {
            localARCommonConfigInfo.mARRelationShipAIOMsg = ((ARRelationShipAIOMsg)localObject2);
          }
        }
      }
    }
    label2195:
    label2330:
    label2333:
    label2336:
    for (;;)
    {
      i = ((XmlPullParser)localObject1).next();
      break label2004;
      for (;;)
      {
        i = ((XmlPullParser)localObject1).next();
        label2284:
        while (i == 1)
        {
          localObject1 = localARCommonConfigInfo;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("parseConfig success|config=");
            ((StringBuilder)localObject1).append(localARCommonConfigInfo);
            QLog.d("AREngine_ARCommonConfigInfo", 2, ((StringBuilder)localObject1).toString());
            return localARCommonConfigInfo;
          }
          return localObject1;
        }
        if (i == 2) {
          break;
        }
      }
      break label1718;
      break label1965;
    }
  }
  
  public static boolean saveArConfigToFile(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveArConfigToFile. uin = ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("AREngine_ARCommonConfigInfo", 2, ((StringBuilder)localObject).toString());
    }
    if (paramString2 == null) {
      return false;
    }
    Object localObject = BaseApplicationImpl.sApplication.getFilesDir().getPath();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("common_file_config");
    localStringBuilder.append(paramString2);
    return saveArConfigToFile(paramString1, (String)localObject, localStringBuilder.toString());
  }
  
  /* Error */
  public static boolean saveArConfigToFile(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: invokestatic 166	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +54 -> 57
    //   6: new 168	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   13: astore 4
    //   15: aload 4
    //   17: ldc_w 533
    //   20: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 4
    //   26: aload_1
    //   27: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload 4
    //   33: ldc 206
    //   35: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload 4
    //   41: aload_2
    //   42: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: ldc 33
    //   48: iconst_2
    //   49: aload 4
    //   51: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: aload_0
    //   58: ifnull +335 -> 393
    //   61: aload_1
    //   62: ifnull +331 -> 393
    //   65: aload_1
    //   66: ldc 208
    //   68: invokevirtual 213	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   71: ifne +322 -> 393
    //   74: aload_2
    //   75: ifnull +318 -> 393
    //   78: aload_2
    //   79: ldc 208
    //   81: invokevirtual 213	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   84: ifeq +5 -> 89
    //   87: iconst_0
    //   88: ireturn
    //   89: new 194	java/io/File
    //   92: dup
    //   93: aload_1
    //   94: aload_2
    //   95: invokespecial 215	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: astore 7
    //   100: new 168	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   107: astore 4
    //   109: aload 4
    //   111: aload_2
    //   112: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload 4
    //   118: ldc_w 535
    //   121: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: new 194	java/io/File
    //   128: dup
    //   129: aload_1
    //   130: aload 4
    //   132: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokespecial 215	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: astore 8
    //   140: iconst_0
    //   141: newarray byte
    //   143: astore 5
    //   145: aload_0
    //   146: ldc 253
    //   148: invokevirtual 538	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   151: astore_0
    //   152: aload_0
    //   153: astore 5
    //   155: goto +8 -> 163
    //   158: astore_0
    //   159: aload_0
    //   160: invokevirtual 539	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   163: aload 7
    //   165: invokevirtual 542	java/io/File:getParentFile	()Ljava/io/File;
    //   168: astore_0
    //   169: aload_0
    //   170: invokevirtual 218	java/io/File:exists	()Z
    //   173: ifne +8 -> 181
    //   176: aload_0
    //   177: invokevirtual 545	java/io/File:mkdir	()Z
    //   180: pop
    //   181: aload 8
    //   183: invokevirtual 218	java/io/File:exists	()Z
    //   186: ifeq +9 -> 195
    //   189: aload 8
    //   191: invokevirtual 221	java/io/File:delete	()Z
    //   194: pop
    //   195: aconst_null
    //   196: astore_2
    //   197: aconst_null
    //   198: astore_1
    //   199: aconst_null
    //   200: astore 6
    //   202: new 547	java/io/FileOutputStream
    //   205: dup
    //   206: aload 8
    //   208: invokespecial 548	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   211: astore_0
    //   212: aload_2
    //   213: astore_1
    //   214: aload_0
    //   215: astore_2
    //   216: new 550	java/io/BufferedOutputStream
    //   219: dup
    //   220: aload_0
    //   221: invokespecial 553	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   224: astore 4
    //   226: aload 4
    //   228: aload 5
    //   230: invokevirtual 556	java/io/BufferedOutputStream:write	([B)V
    //   233: aload 4
    //   235: invokevirtual 559	java/io/BufferedOutputStream:flush	()V
    //   238: aload 8
    //   240: aload 7
    //   242: invokestatic 565	com/tencent/mobileqq/utils/FileUtils:renameFile	(Ljava/io/File;Ljava/io/File;)Z
    //   245: istore_3
    //   246: aload 4
    //   248: invokevirtual 566	java/io/BufferedOutputStream:close	()V
    //   251: goto +8 -> 259
    //   254: astore_1
    //   255: aload_1
    //   256: invokevirtual 267	java/io/IOException:printStackTrace	()V
    //   259: aload_0
    //   260: invokevirtual 567	java/io/FileOutputStream:close	()V
    //   263: iload_3
    //   264: ireturn
    //   265: astore_0
    //   266: aload_0
    //   267: invokevirtual 267	java/io/IOException:printStackTrace	()V
    //   270: iload_3
    //   271: ireturn
    //   272: astore_2
    //   273: aload 4
    //   275: astore_1
    //   276: goto +83 -> 359
    //   279: astore 5
    //   281: goto +26 -> 307
    //   284: astore 5
    //   286: aload 6
    //   288: astore 4
    //   290: goto +17 -> 307
    //   293: astore_2
    //   294: aconst_null
    //   295: astore_0
    //   296: goto +63 -> 359
    //   299: astore 5
    //   301: aconst_null
    //   302: astore_0
    //   303: aload 6
    //   305: astore 4
    //   307: aload 4
    //   309: astore_1
    //   310: aload_0
    //   311: astore_2
    //   312: aload 5
    //   314: invokevirtual 267	java/io/IOException:printStackTrace	()V
    //   317: aload 4
    //   319: ifnull +16 -> 335
    //   322: aload 4
    //   324: invokevirtual 566	java/io/BufferedOutputStream:close	()V
    //   327: goto +8 -> 335
    //   330: astore_1
    //   331: aload_1
    //   332: invokevirtual 267	java/io/IOException:printStackTrace	()V
    //   335: aload_0
    //   336: ifnull +14 -> 350
    //   339: aload_0
    //   340: invokevirtual 567	java/io/FileOutputStream:close	()V
    //   343: iconst_0
    //   344: ireturn
    //   345: astore_0
    //   346: aload_0
    //   347: invokevirtual 267	java/io/IOException:printStackTrace	()V
    //   350: iconst_0
    //   351: ireturn
    //   352: astore 4
    //   354: aload_2
    //   355: astore_0
    //   356: aload 4
    //   358: astore_2
    //   359: aload_1
    //   360: ifnull +15 -> 375
    //   363: aload_1
    //   364: invokevirtual 566	java/io/BufferedOutputStream:close	()V
    //   367: goto +8 -> 375
    //   370: astore_1
    //   371: aload_1
    //   372: invokevirtual 267	java/io/IOException:printStackTrace	()V
    //   375: aload_0
    //   376: ifnull +15 -> 391
    //   379: aload_0
    //   380: invokevirtual 567	java/io/FileOutputStream:close	()V
    //   383: goto +8 -> 391
    //   386: astore_0
    //   387: aload_0
    //   388: invokevirtual 267	java/io/IOException:printStackTrace	()V
    //   391: aload_2
    //   392: athrow
    //   393: iconst_0
    //   394: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	395	0	paramString1	String
    //   0	395	1	paramString2	String
    //   0	395	2	paramString3	String
    //   245	26	3	bool	boolean
    //   13	310	4	localObject1	Object
    //   352	5	4	localObject2	Object
    //   143	86	5	localObject3	Object
    //   279	1	5	localIOException1	java.io.IOException
    //   284	1	5	localIOException2	java.io.IOException
    //   299	14	5	localIOException3	java.io.IOException
    //   200	104	6	localObject4	Object
    //   98	143	7	localFile1	File
    //   138	101	8	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   145	152	158	java/io/UnsupportedEncodingException
    //   246	251	254	java/io/IOException
    //   259	263	265	java/io/IOException
    //   226	246	272	finally
    //   226	246	279	java/io/IOException
    //   216	226	284	java/io/IOException
    //   202	212	293	finally
    //   202	212	299	java/io/IOException
    //   322	327	330	java/io/IOException
    //   339	343	345	java/io/IOException
    //   216	226	352	finally
    //   312	317	352	finally
    //   363	367	370	java/io/IOException
    //   379	383	386	java/io/IOException
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean isEnableARCloud()
  {
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = this.aRCloudBegin;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (l2 <= l1)
    {
      bool1 = bool2;
      if (l1 <= this.aRCloudEnd)
      {
        bool1 = bool2;
        if (this.recognitions != null)
        {
          int i = 0;
          for (;;)
          {
            bool1 = bool2;
            if (i >= this.recognitions.size()) {
              break;
            }
            if (((ARRecognition)this.recognitions.get(i)).jdField_a_of_type_Int != 0)
            {
              bool1 = true;
              break;
            }
            i += 1;
          }
        }
      }
    }
    Object localObject = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss.SSS");
    String str = ((SimpleDateFormat)localObject).format(new Date(this.aRCloudBegin));
    localObject = ((SimpleDateFormat)localObject).format(new Date(this.aRCloudEnd));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isEnableARCloud = ");
    localStringBuilder.append(bool1);
    localStringBuilder.append(", aRCloudBegin = ");
    localStringBuilder.append(this.aRCloudBegin);
    localStringBuilder.append(", aRCloudEnd = ");
    localStringBuilder.append(this.aRCloudEnd);
    localStringBuilder.append(", timeBeginStr = ");
    localStringBuilder.append(str);
    localStringBuilder.append(", timeEndStr = ");
    localStringBuilder.append((String)localObject);
    QLog.i("AREngine_ARCommonConfigInfo", 1, localStringBuilder.toString());
    return bool1;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("CommonConfigInfo{");
    localStringBuffer.append("versionId='");
    localStringBuffer.append(this.versionId);
    localStringBuffer.append('\'');
    localStringBuffer.append(", aRCloudBegin=");
    localStringBuffer.append(this.aRCloudBegin);
    localStringBuffer.append(", aRCloudCacheExpireTime=");
    localStringBuffer.append(this.aRCloudCacheExpireTime);
    localStringBuffer.append(", aRCloudEnd=");
    localStringBuffer.append(this.aRCloudEnd);
    localStringBuffer.append(", arControllers=");
    localStringBuffer.append(this.arControllers);
    localStringBuffer.append(", switchRecogOpen=");
    localStringBuffer.append(this.switchRecogOpen);
    localStringBuffer.append(", recognitions=");
    localStringBuffer.append(this.recognitions);
    localStringBuffer.append(", nativeSoResList = ");
    localStringBuffer.append(this.nativeSoResList);
    localStringBuffer.append(", mARNoResultCheckTime = ");
    localStringBuffer.append(this.mARNoResultCheckTime);
    localStringBuffer.append(", mARCloudUploadCheckTime = ");
    localStringBuffer.append(this.mARCloudUploadCheckTime);
    localStringBuffer.append(", mARCloudUploadDelayTime = ");
    localStringBuffer.append(this.mARCloudUploadDelayTime);
    localStringBuffer.append(", mARLocalStartDelay = ");
    localStringBuffer.append(this.mARLocalStartDelay);
    localStringBuffer.append(", isOpenVideoRecordSwitch = ");
    localStringBuffer.append(this.isEnableVideoRecord);
    localStringBuffer.append(", switchLBSLocation = ");
    localStringBuffer.append(this.switchLBSLocation);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.versionId);
    paramParcel.writeString(this.osId);
    paramParcel.writeLong(this.aRCloudBegin);
    paramParcel.writeLong(this.aRCloudEnd);
    paramParcel.writeLong(this.aRCloudCacheExpireTime);
    paramParcel.writeList(this.arControllers);
    paramParcel.writeInt(this.switchRecogOpen);
    paramParcel.writeList(this.recognitions);
    paramParcel.writeList(this.nativeSoResList);
    paramParcel.writeLong(this.mARNoResultCheckTime);
    paramParcel.writeLong(this.mARCloudUploadCheckTime);
    paramParcel.writeLong(this.mARCloudUploadDelayTime);
    paramParcel.writeLong(this.mARLocalStartDelay);
    paramParcel.writeLong(this.isEnableVideoRecord);
    paramParcel.writeParcelable(this.mARRelationShipAIOMsg, paramInt);
    paramParcel.writeInt(this.switchLBSLocation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo
 * JD-Core Version:    0.7.0.1
 */