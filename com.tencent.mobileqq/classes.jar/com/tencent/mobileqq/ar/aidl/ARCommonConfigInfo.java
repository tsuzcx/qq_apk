package com.tencent.mobileqq.ar.aidl;

import aaej;
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
  public static final Parcelable.Creator CREATOR = new aaej();
  public static final long DEFAULT_AR_CLOUD_UPLOAD_CHECK_TIMEOUT = 5000L;
  public static final long DEFAULT_AR_CLOUD_UPLOAD_DELAY = 2000L;
  public static final long DEFAULT_AR_LOCAL_START_DELAY = 0L;
  public static final long DEFAULT_NO_RESULT_CHECK_TIMEOUT = 8000L;
  public static final int LBS_LOCATION_CLOSE = 0;
  public static final int LBS_LOCATION_OPEN = 1;
  public static final String TAG = "AREngine_ARCommonConfigInfo";
  public static String xmls_for_test = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n\n<!--AR配置-->\n<ARConfig> \n  <!--原type87与业务无关部分，提取到通用配置中-->\n  <!--配置版本号-->  \n  <VersionID>2</VersionID>  \n  <!--支持的系统版本，校验用-->  \n  <OSId>4.1.0</OSId>  \n  <!--云识别相关配置-->  \n  <Cloud> \n    <!--云识别开启的时间段-->  \n    <Begin>2016-07-25 00:00:00</Begin>  \n    <End>2018-08-23 23:59:00</End> \n  </Cloud>\n    <!--QQAR入口配置,可配置多个入口-->  \n  <ScanAR> \n\t<!--入口类型，1：QQAR入口-->\n\t<EntryType>1</EntryType>\n    <!--入口出现的起止时间-->  \n    <Begin>2016-07-05 00:00:00</Begin>  \n    <End>2027-11-26 23:58:00</End>  \n    <!--0:通用类型AR活动;1:奥运活动;-->  \n    <!--如果是奥运活动期间(即ActType=1)，活动主页配置下载失败，则不展示扫一扫入口-->  \n    <ActType>0</ActType>  \n    <!--扫一扫AR入口的图片-->  \n    <ScanIconImg>http://hb.url.cn/myapp/qq_desk/2016olympic/20161109/qqar.png</ScanIconImg>  \n    <ScanIconMd5>0b2161cf3683a14b70affb16208f7bc9</ScanIconMd5>  \n    <!--扫一扫AR入口的图片(按下态)-->  \n    <ScanIconPressed>http://hb.url.cn/myapp/qq_desk/2016olympic/20161109/qqar_pressed.png</ScanIconPressed>  \n    <ScanIconPressedMd5>b7a54add153ea38e9f85ee1d37d54d15</ScanIconPressedMd5>  \n    <!--扫一扫AR入口的文案-->  \n    <ScanIconText>1</ScanIconText>  \n    <!--扫一扫默认提示文案-->  \n    <Scan_Line1>请将镜头对准QQ-AR识别图</Scan_Line1>  \n    <Scan_Line2/>  \n    <Scan_Line3/>  \n    <Scan_Line3_URL/> \n  </ScanAR>\n  <ScanAR></ScanAR> \n  <!--新增字段-->\n  <!--多个识别结果时，是够支持结果展示切换-->\n  <switchRecogOpen>1</switchRecogOpen>\n  <!--LBS定位使用开关。0 关闭(默认)，1 开启-->\n  <switchLBSLocation>1</switchLBSLocation>\n  <!--当前支持的识别类型-->\n  <Recognition>\n\t<!--类型id对齐bit位，参照协议bit0=1:AR特征识别;bit1=1:物体分类识别;bit2=1:人脸识别;-->\n\t<!--maker识别-->\n\t<Type>1</Type>\n\t<!--是否打开云识别-->\n\t<CloudRecogOpen>1</CloudRecogOpen>\n\t<!--是否打开本地识别-->\n\t<LocalRecogOpen>1</LocalRecogOpen>\n\t<!--优先级，1优先级最高-->\n\t<Priority>1</Priority>\n\t<!--云识别结果等待时长，单位：毫秒-->\n\t<Wait_ms>1000</Wait_ms>\n\t<!--图片预处理开关-->\n\t<ImagePreprocess>\n\t\t<Open>1</Open>\n\t</ImagePreprocess>\n  </Recognition>\n</ARConfig> ";
  public long aRCloudBegin;
  public long aRCloudCacheExpireTime;
  public long aRCloudEnd;
  public ArrayList arControllers = new ArrayList();
  public long isEnableVideoRecord = 1L;
  public long mARCloudUploadCheckTime;
  public long mARCloudUploadDelayTime;
  public long mARLocalStartDelay;
  public long mARNoResultCheckTime;
  public ARRelationShipAIOMsg mARRelationShipAIOMsg;
  public ArrayList nativeSoResList = new ArrayList();
  public String osId;
  public ArrayList recognitions = new ArrayList();
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
    catch (Exception paramParcel) {}catch (Error paramParcel) {}
  }
  
  public static void deleteConfigFile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARCommonConfigInfo", 2, "deleteConfigFile. uin = " + paramString);
    }
    if (paramString == null) {
      return;
    }
    deleteConfigFile(BaseApplicationImpl.sApplication.getFilesDir().getPath(), "common_file_config" + paramString);
  }
  
  public static void deleteConfigFile(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARCommonConfigInfo", 2, "deleteConfigFile. dir = " + paramString1 + ", filename = " + paramString2);
    }
    if ((paramString1 == null) || (paramString1.equals("")) || (paramString2 == null) || (paramString2.equals(""))) {}
    do
    {
      return;
      paramString1 = new File(paramString1, paramString2);
    } while (!paramString1.exists());
    paramString1.delete();
  }
  
  public static ARCommonConfigInfo loadConfigFromFile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARCommonConfigInfo", 2, "loadConfigFromFile. uin = " + paramString);
    }
    if (paramString == null) {
      return null;
    }
    return loadConfigFromFile(BaseApplicationImpl.sApplication.getFilesDir().getPath(), "common_file_config" + paramString);
  }
  
  /* Error */
  public static ARCommonConfigInfo loadConfigFromFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore_3
    //   5: invokestatic 167	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +37 -> 45
    //   11: ldc 32
    //   13: iconst_2
    //   14: new 169	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   21: ldc 235
    //   23: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_0
    //   27: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc 207
    //   32: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_1
    //   36: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 183	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: aload_3
    //   46: astore_2
    //   47: aload_0
    //   48: ifnull +31 -> 79
    //   51: aload_3
    //   52: astore_2
    //   53: aload_0
    //   54: ldc 209
    //   56: invokevirtual 214	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   59: ifne +20 -> 79
    //   62: aload_3
    //   63: astore_2
    //   64: aload_1
    //   65: ifnull +14 -> 79
    //   68: aload_1
    //   69: ldc 209
    //   71: invokevirtual 214	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   74: ifeq +7 -> 81
    //   77: aload_3
    //   78: astore_2
    //   79: aload_2
    //   80: areturn
    //   81: new 195	java/io/File
    //   84: dup
    //   85: aload_0
    //   86: aload_1
    //   87: invokespecial 216	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: astore 7
    //   92: aload_3
    //   93: astore_2
    //   94: aload 7
    //   96: invokevirtual 219	java/io/File:exists	()Z
    //   99: ifeq -20 -> 79
    //   102: new 237	java/io/FileInputStream
    //   105: dup
    //   106: aload 7
    //   108: invokespecial 240	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   111: astore_0
    //   112: new 242	java/io/BufferedInputStream
    //   115: dup
    //   116: aload_0
    //   117: invokespecial 245	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   120: astore 5
    //   122: aload_0
    //   123: astore_2
    //   124: aload 5
    //   126: astore_1
    //   127: aload_0
    //   128: invokevirtual 248	java/io/FileInputStream:available	()I
    //   131: newarray byte
    //   133: astore_3
    //   134: aload_0
    //   135: astore_2
    //   136: aload 5
    //   138: astore_1
    //   139: aload 5
    //   141: aload_3
    //   142: invokevirtual 252	java/io/BufferedInputStream:read	([B)I
    //   145: pop
    //   146: aload_0
    //   147: astore_2
    //   148: aload 5
    //   150: astore_1
    //   151: new 211	java/lang/String
    //   154: dup
    //   155: aload_3
    //   156: ldc 254
    //   158: invokespecial 257	java/lang/String:<init>	([BLjava/lang/String;)V
    //   161: astore_3
    //   162: aload_0
    //   163: astore_2
    //   164: aload 5
    //   166: astore_1
    //   167: invokestatic 167	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   170: ifeq +34 -> 204
    //   173: aload_0
    //   174: astore_2
    //   175: aload 5
    //   177: astore_1
    //   178: ldc 32
    //   180: iconst_2
    //   181: new 169	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   188: ldc_w 259
    //   191: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload_3
    //   195: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 183	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   204: aload_0
    //   205: astore_2
    //   206: aload 5
    //   208: astore_1
    //   209: aload_3
    //   210: invokestatic 262	com/tencent/mobileqq/ar/aidl/ARCommonConfigInfo:parseArConfig	(Ljava/lang/String;)Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   213: astore_3
    //   214: aload_3
    //   215: astore_2
    //   216: aload 5
    //   218: ifnull +8 -> 226
    //   221: aload 5
    //   223: invokevirtual 265	java/io/BufferedInputStream:close	()V
    //   226: aload_2
    //   227: astore_1
    //   228: aload_0
    //   229: ifnull +9 -> 238
    //   232: aload_0
    //   233: invokevirtual 266	java/io/FileInputStream:close	()V
    //   236: aload_2
    //   237: astore_1
    //   238: aload_1
    //   239: astore_2
    //   240: invokestatic 167	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   243: ifeq -164 -> 79
    //   246: ldc 32
    //   248: iconst_2
    //   249: new 169	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   256: ldc_w 268
    //   259: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: aload_1
    //   263: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   266: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: invokestatic 183	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   272: aload_1
    //   273: areturn
    //   274: astore_1
    //   275: aload_1
    //   276: invokevirtual 274	java/io/IOException:printStackTrace	()V
    //   279: goto -53 -> 226
    //   282: astore_0
    //   283: aload_0
    //   284: invokevirtual 274	java/io/IOException:printStackTrace	()V
    //   287: aload_2
    //   288: astore_1
    //   289: goto -51 -> 238
    //   292: astore 4
    //   294: aconst_null
    //   295: astore_3
    //   296: aconst_null
    //   297: astore_0
    //   298: aload_3
    //   299: astore_2
    //   300: aload_0
    //   301: astore_1
    //   302: aload 7
    //   304: invokevirtual 222	java/io/File:delete	()Z
    //   307: pop
    //   308: aload_3
    //   309: astore_2
    //   310: aload_0
    //   311: astore_1
    //   312: invokestatic 167	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   315: ifeq +34 -> 349
    //   318: aload_3
    //   319: astore_2
    //   320: aload_0
    //   321: astore_1
    //   322: ldc 32
    //   324: iconst_2
    //   325: new 169	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   332: ldc_w 276
    //   335: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: aload 4
    //   340: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   343: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: invokestatic 279	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   349: aload_0
    //   350: ifnull +7 -> 357
    //   353: aload_0
    //   354: invokevirtual 265	java/io/BufferedInputStream:close	()V
    //   357: aload 6
    //   359: astore_1
    //   360: aload_3
    //   361: ifnull -123 -> 238
    //   364: aload_3
    //   365: invokevirtual 266	java/io/FileInputStream:close	()V
    //   368: aload 6
    //   370: astore_1
    //   371: goto -133 -> 238
    //   374: astore_0
    //   375: aload_0
    //   376: invokevirtual 274	java/io/IOException:printStackTrace	()V
    //   379: aload 6
    //   381: astore_1
    //   382: goto -144 -> 238
    //   385: astore_0
    //   386: aload_0
    //   387: invokevirtual 274	java/io/IOException:printStackTrace	()V
    //   390: goto -33 -> 357
    //   393: astore_3
    //   394: aconst_null
    //   395: astore_0
    //   396: aconst_null
    //   397: astore_1
    //   398: aload_1
    //   399: ifnull +7 -> 406
    //   402: aload_1
    //   403: invokevirtual 265	java/io/BufferedInputStream:close	()V
    //   406: aload_0
    //   407: ifnull +7 -> 414
    //   410: aload_0
    //   411: invokevirtual 266	java/io/FileInputStream:close	()V
    //   414: aload_3
    //   415: athrow
    //   416: astore_1
    //   417: aload_1
    //   418: invokevirtual 274	java/io/IOException:printStackTrace	()V
    //   421: goto -15 -> 406
    //   424: astore_0
    //   425: aload_0
    //   426: invokevirtual 274	java/io/IOException:printStackTrace	()V
    //   429: goto -15 -> 414
    //   432: astore_3
    //   433: aconst_null
    //   434: astore_1
    //   435: goto -37 -> 398
    //   438: astore_3
    //   439: aload_2
    //   440: astore_0
    //   441: goto -43 -> 398
    //   444: astore 4
    //   446: aconst_null
    //   447: astore_1
    //   448: aload_0
    //   449: astore_3
    //   450: aload_1
    //   451: astore_0
    //   452: goto -154 -> 298
    //   455: astore 4
    //   457: aload_0
    //   458: astore_3
    //   459: aload 5
    //   461: astore_0
    //   462: goto -164 -> 298
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	465	0	paramString1	String
    //   0	465	1	paramString2	String
    //   46	394	2	localObject1	Object
    //   4	361	3	localObject2	Object
    //   393	22	3	localObject3	Object
    //   432	1	3	localObject4	Object
    //   438	1	3	localObject5	Object
    //   449	10	3	str	String
    //   292	47	4	localThrowable1	java.lang.Throwable
    //   444	1	4	localThrowable2	java.lang.Throwable
    //   455	1	4	localThrowable3	java.lang.Throwable
    //   120	340	5	localBufferedInputStream	java.io.BufferedInputStream
    //   1	379	6	localObject6	Object
    //   90	213	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   221	226	274	java/io/IOException
    //   232	236	282	java/io/IOException
    //   102	112	292	java/lang/Throwable
    //   364	368	374	java/io/IOException
    //   353	357	385	java/io/IOException
    //   102	112	393	finally
    //   402	406	416	java/io/IOException
    //   410	414	424	java/io/IOException
    //   112	122	432	finally
    //   127	134	438	finally
    //   139	146	438	finally
    //   151	162	438	finally
    //   167	173	438	finally
    //   178	204	438	finally
    //   209	214	438	finally
    //   302	308	438	finally
    //   312	318	438	finally
    //   322	349	438	finally
    //   112	122	444	java/lang/Throwable
    //   127	134	455	java/lang/Throwable
    //   139	146	455	java/lang/Throwable
    //   151	162	455	java/lang/Throwable
    //   167	173	455	java/lang/Throwable
    //   178	204	455	java/lang/Throwable
    //   209	214	455	java/lang/Throwable
  }
  
  public static ARCommonConfigInfo parseArConfig(String paramString)
  {
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    ARCommonConfigInfo localARCommonConfigInfo = new ARCommonConfigInfo();
    for (;;)
    {
      try
      {
        localXmlPullParser.setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
        i = localXmlPullParser.getEventType();
      }
      catch (Exception localException1)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("AREngine_ARCommonConfigInfo", 2, paramString, localException1);
        return null;
      }
      int i = localXmlPullParser.next();
      break label2164;
      str1 = localXmlPullParser.getName();
      if (str1.equalsIgnoreCase("VersionID"))
      {
        localARCommonConfigInfo.versionId = localXmlPullParser.nextText();
      }
      else if (str1.equalsIgnoreCase("OSId"))
      {
        localARCommonConfigInfo.osId = localException1.nextText();
      }
      else if (str1.equalsIgnoreCase("ARNoResultCheckTime"))
      {
        str1 = localException1.nextText();
        try
        {
          localARCommonConfigInfo.mARNoResultCheckTime = (Long.valueOf(str1).longValue() * 1000L);
        }
        catch (Exception localException2)
        {
          localARCommonConfigInfo.mARNoResultCheckTime = 8000L;
        }
      }
      else if (localException2.equalsIgnoreCase("ARLocalStartDelay"))
      {
        str2 = localException1.nextText();
        try
        {
          localARCommonConfigInfo.mARLocalStartDelay = (Long.valueOf(str2).longValue() * 1000L);
        }
        catch (Exception localException3)
        {
          localARCommonConfigInfo.mARLocalStartDelay = 0L;
        }
      }
      else if (localException3.equalsIgnoreCase("ScanAR"))
      {
        localObject1 = new ARScanAR();
        i = localException1.next();
        label256:
        if (i != 1)
        {
          if (i != 2) {
            break label816;
          }
          str5 = localException1.getName();
          if (!str5.equalsIgnoreCase("EntryType")) {
            break label312;
          }
          ((ARScanAR)localObject1).jdField_a_of_type_Int = Integer.valueOf(localException1.nextText()).intValue();
        }
        label312:
        while ((i != 3) || (!localException1.getName().equalsIgnoreCase("ScanAR"))) {
          for (;;)
          {
            i = localException1.next();
            break label256;
            break;
            if (str5.equalsIgnoreCase("Begin"))
            {
              ((ARScanAR)localObject1).jdField_a_of_type_Long = ArConfigUtils.a(localException1.nextText());
            }
            else if (str5.equalsIgnoreCase("End"))
            {
              ((ARScanAR)localObject1).jdField_b_of_type_Long = ArConfigUtils.a(localException1.nextText());
            }
            else if (str5.equalsIgnoreCase("UserGuideBeginTime"))
            {
              ((ARScanAR)localObject1).jdField_c_of_type_Long = ArConfigUtils.a(localException1.nextText());
            }
            else if (str5.equalsIgnoreCase("UserGuideEndTime"))
            {
              ((ARScanAR)localObject1).jdField_d_of_type_Long = ArConfigUtils.a(localException1.nextText());
            }
            else if (str5.equalsIgnoreCase("ActType"))
            {
              ((ARScanAR)localObject1).jdField_b_of_type_Int = Integer.valueOf(localException1.nextText()).intValue();
            }
            else
            {
              bool = str5.equalsIgnoreCase("UserGuideShowCount");
              if (bool)
              {
                try
                {
                  ((ARScanAR)localObject1).jdField_c_of_type_Int = Integer.valueOf(localException1.nextText()).intValue();
                }
                catch (Exception localException7)
                {
                  ((ARScanAR)localObject1).jdField_c_of_type_Int = 0;
                }
                if (QLog.isColorLevel()) {
                  QLog.e("AREngine_ARCommonConfigInfo", 2, "UserGuideShowCount error", localException7);
                }
              }
              else if (localException7.equalsIgnoreCase("ScanIconImg"))
              {
                ((ARScanAR)localObject1).jdField_a_of_type_JavaLangString = localException1.nextText();
              }
              else if (localException7.equalsIgnoreCase("ScanIconMd5"))
              {
                ((ARScanAR)localObject1).jdField_b_of_type_JavaLangString = localException1.nextText();
              }
              else if (localException7.equalsIgnoreCase("ScanIconPressed"))
              {
                ((ARScanAR)localObject1).jdField_c_of_type_JavaLangString = localException1.nextText();
              }
              else if (localException7.equalsIgnoreCase("ScanIconPressedMd5"))
              {
                ((ARScanAR)localObject1).jdField_d_of_type_JavaLangString = localException1.nextText();
              }
              else if (localException7.equalsIgnoreCase("ScanIconText"))
              {
                ((ARScanAR)localObject1).e = localException1.nextText();
              }
              else if (localException7.equalsIgnoreCase("Scan_Line1"))
              {
                ((ARScanAR)localObject1).f = localException1.nextText();
              }
              else if (localException7.equalsIgnoreCase("Scan_Line2"))
              {
                ((ARScanAR)localObject1).g = localException1.nextText();
              }
              else if (localException7.equalsIgnoreCase("Scan_Line3"))
              {
                ((ARScanAR)localObject1).h = localException1.nextText();
              }
              else if (localException7.equalsIgnoreCase("Scan_Line3_URL"))
              {
                ((ARScanAR)localObject1).i = localException1.nextText();
              }
              else if (localException7.equalsIgnoreCase("What2ScanURL"))
              {
                ((ARScanAR)localObject1).j = localException1.nextText();
              }
              else if (localException7.equalsIgnoreCase("UserGuideWording"))
              {
                ((ARScanAR)localObject1).k = localException1.nextText();
              }
              else if (localException7.equalsIgnoreCase("UserGuideType"))
              {
                ((ARScanAR)localObject1).l = localException1.nextText();
              }
            }
          }
        }
        label816:
        localARCommonConfigInfo.arControllers.add(localObject1);
      }
      else if (((String)localObject1).equalsIgnoreCase("switchRecogOpen"))
      {
        localARCommonConfigInfo.switchRecogOpen = Integer.valueOf(localException1.nextText()).intValue();
      }
      else if (((String)localObject1).equalsIgnoreCase("switchLBSLocation"))
      {
        localARCommonConfigInfo.switchLBSLocation = Integer.valueOf(localException1.nextText()).intValue();
      }
      else if (((String)localObject1).equalsIgnoreCase("Recognition"))
      {
        localObject1 = new ARRecognition();
        i = localException1.next();
        label939:
        if (i != 1)
        {
          if (i != 2) {
            break label1287;
          }
          str6 = localException1.getName();
          if (!str6.equalsIgnoreCase("Type")) {
            break label996;
          }
          ((ARRecognition)localObject1).jdField_a_of_type_Long = Integer.valueOf(localException1.nextText()).intValue();
        }
        label996:
        label1264:
        while ((i != 3) || (!localException1.getName().equalsIgnoreCase("Recognition"))) {
          for (;;)
          {
            i = localException1.next();
            break label939;
            break;
            bool = str6.equalsIgnoreCase("CloudRecogOpen");
            if (bool)
            {
              try
              {
                ((ARRecognition)localObject1).jdField_a_of_type_Int = Integer.valueOf(localException1.nextText()).intValue();
              }
              catch (Exception localException8)
              {
                localException8.printStackTrace();
                ((ARRecognition)localObject1).jdField_a_of_type_Int = 1;
              }
            }
            else
            {
              bool = localException8.equalsIgnoreCase("LocalRecogOpen");
              if (bool)
              {
                try
                {
                  ((ARRecognition)localObject1).jdField_b_of_type_Int = Integer.valueOf(localException1.nextText()).intValue();
                }
                catch (Exception localException9)
                {
                  localException9.printStackTrace();
                  ((ARRecognition)localObject1).jdField_b_of_type_Int = 1;
                }
              }
              else
              {
                bool = localException9.equalsIgnoreCase("Priority");
                if (bool)
                {
                  try
                  {
                    ((ARRecognition)localObject1).jdField_c_of_type_Int = Integer.valueOf(localException1.nextText()).intValue();
                  }
                  catch (Exception localException10)
                  {
                    localException10.printStackTrace();
                    ((ARRecognition)localObject1).jdField_c_of_type_Int = 5;
                  }
                }
                else
                {
                  bool = localException10.equalsIgnoreCase("Wait_ms");
                  if (bool)
                  {
                    try
                    {
                      ((ARRecognition)localObject1).jdField_b_of_type_Long = Long.valueOf(localException1.nextText()).longValue();
                    }
                    catch (Exception localException11)
                    {
                      localException11.printStackTrace();
                      ((ARRecognition)localObject1).jdField_b_of_type_Long = 3000L;
                    }
                  }
                  else if (localException11.equalsIgnoreCase("ImagePreprocess"))
                  {
                    i = localException1.next();
                    if (i != 1)
                    {
                      if (i != 2) {
                        break label1264;
                      }
                      if (localException1.getName().equalsIgnoreCase("Open")) {
                        ((ARRecognition)localObject1).d = Integer.valueOf(localException1.nextText()).intValue();
                      }
                    }
                    while ((i != 3) || (!localException1.getName().equalsIgnoreCase("ImagePreprocess")))
                    {
                      i = localException1.next();
                      break label1212;
                      break;
                    }
                  }
                }
              }
            }
          }
        }
        label1212:
        localARCommonConfigInfo.recognitions.add(localObject1);
      }
      else
      {
        label1287:
        if (((String)localObject1).equalsIgnoreCase("ARVideoRecordSwitch"))
        {
          i = localException1.next();
          label1339:
          if (i != 1)
          {
            if (i != 2) {
              break label1391;
            }
            if (localException1.getName().equalsIgnoreCase("Enable")) {
              localARCommonConfigInfo.isEnableVideoRecord = Long.valueOf(localException1.nextText()).longValue();
            }
          }
          label1391:
          while ((i != 3) || (!localException1.getName().equalsIgnoreCase("ARVideoRecordSwitch")))
          {
            i = localException1.next();
            break label1339;
            break;
          }
        }
        else if (((String)localObject1).equalsIgnoreCase("Cloud"))
        {
          i = localException1.next();
          label1432:
          if (i != 1)
          {
            if (i != 2) {
              break label1663;
            }
            localObject1 = localException1.getName();
            if (!((String)localObject1).equalsIgnoreCase("Begin")) {
              break label1485;
            }
            localARCommonConfigInfo.aRCloudBegin = ArConfigUtils.a(localException1.nextText());
          }
          label1485:
          label1663:
          while ((i != 3) || (!localException1.getName().equalsIgnoreCase("Cloud"))) {
            for (;;)
            {
              i = localException1.next();
              break label1432;
              break;
              if (((String)localObject1).equalsIgnoreCase("End"))
              {
                localARCommonConfigInfo.aRCloudEnd = ArConfigUtils.a(localException1.nextText());
              }
              else
              {
                bool = ((String)localObject1).equalsIgnoreCase("CacheExpireTime");
                if (bool)
                {
                  try
                  {
                    localARCommonConfigInfo.aRCloudCacheExpireTime = Long.valueOf(localException1.nextText()).longValue();
                  }
                  catch (Exception localException4)
                  {
                    localARCommonConfigInfo.aRCloudCacheExpireTime = 1440L;
                  }
                }
                else if (localException4.equalsIgnoreCase("ARCloudUploadCheckTime"))
                {
                  str3 = localException1.nextText();
                  try
                  {
                    localARCommonConfigInfo.mARCloudUploadCheckTime = (Long.valueOf(str3).longValue() * 1000L);
                  }
                  catch (Exception localException5)
                  {
                    localARCommonConfigInfo.mARCloudUploadCheckTime = 5000L;
                  }
                }
                else if (localException5.equalsIgnoreCase("ARCloudUploadDelayTime"))
                {
                  str4 = localException1.nextText();
                  try
                  {
                    localARCommonConfigInfo.mARCloudUploadDelayTime = (Long.valueOf(str4).longValue() * 1000L);
                  }
                  catch (Exception localException6)
                  {
                    localARCommonConfigInfo.mARCloudUploadDelayTime = 2000L;
                  }
                }
              }
            }
          }
        }
        else if (localException6.equalsIgnoreCase("NativeSoRes"))
        {
          localObject2 = new ARCommonConfigInfo.NativeSoRes();
          i = localException1.next();
          label1713:
          if (i != 1)
          {
            if (i != 2) {
              break label1887;
            }
            str7 = localException1.getName();
            if (!str7.equalsIgnoreCase("Name")) {
              break label1763;
            }
            ((ARCommonConfigInfo.NativeSoRes)localObject2).jdField_a_of_type_JavaLangString = localException1.nextText();
          }
          label1763:
          while ((i != 3) || (!localException1.getName().equalsIgnoreCase("NativeSoRes"))) {
            for (;;)
            {
              i = localException1.next();
              break label1713;
              break;
              if (str7.equalsIgnoreCase("Version"))
              {
                ((ARCommonConfigInfo.NativeSoRes)localObject2).jdField_b_of_type_JavaLangString = localException1.nextText();
              }
              else if (str7.equalsIgnoreCase("Url"))
              {
                ((ARCommonConfigInfo.NativeSoRes)localObject2).jdField_c_of_type_JavaLangString = localException1.nextText();
              }
              else if (str7.equalsIgnoreCase("Md5"))
              {
                ((ARCommonConfigInfo.NativeSoRes)localObject2).jdField_d_of_type_JavaLangString = localException1.nextText();
              }
              else
              {
                bool = str7.equalsIgnoreCase("Size");
                if (bool) {
                  try
                  {
                    ((ARCommonConfigInfo.NativeSoRes)localObject2).jdField_a_of_type_Long = Long.valueOf(localException1.nextText()).longValue();
                  }
                  catch (Exception localException12)
                  {
                    localException12.printStackTrace();
                    ((ARCommonConfigInfo.NativeSoRes)localObject2).jdField_a_of_type_Long = 0L;
                  }
                }
              }
            }
          }
          label1887:
          localARCommonConfigInfo.nativeSoResList.add(localObject2);
        }
        else if (((String)localObject2).equalsIgnoreCase("ARRelationShipAIOMsg"))
        {
          localObject2 = new ARRelationShipAIOMsg();
          i = localException1.next();
          label1948:
          if (i != 1)
          {
            if (i != 2) {
              break label2098;
            }
            str8 = localException1.getName();
            if (!str8.equalsIgnoreCase("AIOMsgSourceName")) {
              break label1998;
            }
            ((ARRelationShipAIOMsg)localObject2).jdField_a_of_type_JavaLangString = localException1.nextText();
          }
          label1998:
          while ((i != 3) || (!localException1.getName().equalsIgnoreCase("ARRelationShipAIOMsg"))) {
            for (;;)
            {
              i = localException1.next();
              break label1948;
              break;
              if (str8.equalsIgnoreCase("AIOMsgSourceIconUrl")) {
                ((ARRelationShipAIOMsg)localObject2).jdField_b_of_type_JavaLangString = localException1.nextText();
              } else if (str8.equalsIgnoreCase("AIOMsgSourceAction")) {
                ((ARRelationShipAIOMsg)localObject2).jdField_c_of_type_JavaLangString = localException1.nextText();
              } else if (str8.equalsIgnoreCase("AIOMsgSourceActionData")) {
                ((ARRelationShipAIOMsg)localObject2).jdField_d_of_type_JavaLangString = localException1.nextText();
              } else if (str8.equalsIgnoreCase("AIOMsgSourceUrl")) {
                ((ARRelationShipAIOMsg)localObject2).e = localException1.nextText();
              }
            }
          }
          label2098:
          localARCommonConfigInfo.mARRelationShipAIOMsg = ((ARRelationShipAIOMsg)localObject2);
          label2164:
          while (i == 1)
          {
            String str1;
            String str2;
            Object localObject1;
            String str5;
            boolean bool;
            String str6;
            String str3;
            String str4;
            Object localObject2;
            String str7;
            String str8;
            if (QLog.isColorLevel()) {
              QLog.d("AREngine_ARCommonConfigInfo", 2, "parseConfig success|config=" + localARCommonConfigInfo);
            }
            return localARCommonConfigInfo;
          }
          switch (i)
          {
          }
        }
      }
    }
  }
  
  public static boolean saveArConfigToFile(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARCommonConfigInfo", 2, "saveArConfigToFile. uin = " + paramString2);
    }
    if (paramString2 == null) {
      return false;
    }
    return saveArConfigToFile(paramString1, BaseApplicationImpl.sApplication.getFilesDir().getPath(), "common_file_config" + paramString2);
  }
  
  /* Error */
  public static boolean saveArConfigToFile(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: invokestatic 167	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +38 -> 44
    //   9: ldc 32
    //   11: iconst_2
    //   12: new 169	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 534
    //   22: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_1
    //   26: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc 207
    //   31: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_2
    //   35: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 183	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: aload_0
    //   45: ifnull +29 -> 74
    //   48: aload_1
    //   49: ifnull +25 -> 74
    //   52: aload_1
    //   53: ldc 209
    //   55: invokevirtual 214	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   58: ifne +16 -> 74
    //   61: aload_2
    //   62: ifnull +12 -> 74
    //   65: aload_2
    //   66: ldc 209
    //   68: invokevirtual 214	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   71: ifeq +7 -> 78
    //   74: iconst_0
    //   75: istore_3
    //   76: iload_3
    //   77: ireturn
    //   78: new 195	java/io/File
    //   81: dup
    //   82: aload_1
    //   83: aload_2
    //   84: invokespecial 216	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: astore 6
    //   89: new 195	java/io/File
    //   92: dup
    //   93: aload_1
    //   94: new 169	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   101: aload_2
    //   102: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: ldc_w 536
    //   108: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokespecial 216	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   117: astore 7
    //   119: iconst_0
    //   120: newarray byte
    //   122: astore_1
    //   123: aload_0
    //   124: ldc 254
    //   126: invokevirtual 539	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   129: astore_0
    //   130: aload 6
    //   132: invokevirtual 542	java/io/File:getParentFile	()Ljava/io/File;
    //   135: astore_1
    //   136: aload_1
    //   137: invokevirtual 219	java/io/File:exists	()Z
    //   140: ifne +8 -> 148
    //   143: aload_1
    //   144: invokevirtual 545	java/io/File:mkdir	()Z
    //   147: pop
    //   148: aload 7
    //   150: invokevirtual 219	java/io/File:exists	()Z
    //   153: ifeq +9 -> 162
    //   156: aload 7
    //   158: invokevirtual 222	java/io/File:delete	()Z
    //   161: pop
    //   162: new 547	java/io/FileOutputStream
    //   165: dup
    //   166: aload 7
    //   168: invokespecial 548	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   171: astore_2
    //   172: new 550	java/io/BufferedOutputStream
    //   175: dup
    //   176: aload_2
    //   177: invokespecial 553	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   180: astore_1
    //   181: aload_1
    //   182: aload_0
    //   183: invokevirtual 556	java/io/BufferedOutputStream:write	([B)V
    //   186: aload_1
    //   187: invokevirtual 559	java/io/BufferedOutputStream:flush	()V
    //   190: aload 7
    //   192: aload 6
    //   194: invokestatic 564	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/io/File;Ljava/io/File;)Z
    //   197: istore 4
    //   199: aload_1
    //   200: ifnull +7 -> 207
    //   203: aload_1
    //   204: invokevirtual 565	java/io/BufferedOutputStream:close	()V
    //   207: iload 4
    //   209: istore_3
    //   210: aload_2
    //   211: ifnull -135 -> 76
    //   214: aload_2
    //   215: invokevirtual 566	java/io/FileOutputStream:close	()V
    //   218: iload 4
    //   220: ireturn
    //   221: astore_0
    //   222: aload_0
    //   223: invokevirtual 274	java/io/IOException:printStackTrace	()V
    //   226: iload 4
    //   228: ireturn
    //   229: astore_0
    //   230: aload_0
    //   231: invokevirtual 567	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   234: aload_1
    //   235: astore_0
    //   236: goto -106 -> 130
    //   239: astore_0
    //   240: aload_0
    //   241: invokevirtual 274	java/io/IOException:printStackTrace	()V
    //   244: goto -37 -> 207
    //   247: astore_2
    //   248: aconst_null
    //   249: astore_1
    //   250: aload 5
    //   252: astore_0
    //   253: aload_2
    //   254: invokevirtual 274	java/io/IOException:printStackTrace	()V
    //   257: aload_1
    //   258: ifnull +7 -> 265
    //   261: aload_1
    //   262: invokevirtual 565	java/io/BufferedOutputStream:close	()V
    //   265: aload_0
    //   266: ifnull +7 -> 273
    //   269: aload_0
    //   270: invokevirtual 566	java/io/FileOutputStream:close	()V
    //   273: iconst_0
    //   274: ireturn
    //   275: astore_1
    //   276: aload_1
    //   277: invokevirtual 274	java/io/IOException:printStackTrace	()V
    //   280: goto -15 -> 265
    //   283: astore_0
    //   284: aload_0
    //   285: invokevirtual 274	java/io/IOException:printStackTrace	()V
    //   288: goto -15 -> 273
    //   291: astore_0
    //   292: aconst_null
    //   293: astore_1
    //   294: aconst_null
    //   295: astore_2
    //   296: aload_1
    //   297: ifnull +7 -> 304
    //   300: aload_1
    //   301: invokevirtual 565	java/io/BufferedOutputStream:close	()V
    //   304: aload_2
    //   305: ifnull +7 -> 312
    //   308: aload_2
    //   309: invokevirtual 566	java/io/FileOutputStream:close	()V
    //   312: aload_0
    //   313: athrow
    //   314: astore_1
    //   315: aload_1
    //   316: invokevirtual 274	java/io/IOException:printStackTrace	()V
    //   319: goto -15 -> 304
    //   322: astore_1
    //   323: aload_1
    //   324: invokevirtual 274	java/io/IOException:printStackTrace	()V
    //   327: goto -15 -> 312
    //   330: astore_0
    //   331: aconst_null
    //   332: astore_1
    //   333: goto -37 -> 296
    //   336: astore_0
    //   337: goto -41 -> 296
    //   340: astore 5
    //   342: aload_0
    //   343: astore_2
    //   344: aload 5
    //   346: astore_0
    //   347: goto -51 -> 296
    //   350: astore 5
    //   352: aconst_null
    //   353: astore_1
    //   354: aload_2
    //   355: astore_0
    //   356: aload 5
    //   358: astore_2
    //   359: goto -106 -> 253
    //   362: astore 5
    //   364: aload_2
    //   365: astore_0
    //   366: aload 5
    //   368: astore_2
    //   369: goto -116 -> 253
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	372	0	paramString1	String
    //   0	372	1	paramString2	String
    //   0	372	2	paramString3	String
    //   75	135	3	bool1	boolean
    //   197	30	4	bool2	boolean
    //   1	250	5	localObject1	Object
    //   340	5	5	localObject2	Object
    //   350	7	5	localIOException1	java.io.IOException
    //   362	5	5	localIOException2	java.io.IOException
    //   87	106	6	localFile1	File
    //   117	74	7	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   214	218	221	java/io/IOException
    //   123	130	229	java/io/UnsupportedEncodingException
    //   203	207	239	java/io/IOException
    //   162	172	247	java/io/IOException
    //   261	265	275	java/io/IOException
    //   269	273	283	java/io/IOException
    //   162	172	291	finally
    //   300	304	314	java/io/IOException
    //   308	312	322	java/io/IOException
    //   172	181	330	finally
    //   181	199	336	finally
    //   253	257	340	finally
    //   172	181	350	java/io/IOException
    //   181	199	362	java/io/IOException
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean isEnableARCloud()
  {
    boolean bool2 = false;
    long l = NetConnInfoCenter.getServerTimeMillis();
    boolean bool1 = bool2;
    int i;
    if (this.aRCloudBegin <= l)
    {
      bool1 = bool2;
      if (l <= this.aRCloudEnd)
      {
        bool1 = bool2;
        if (this.recognitions != null) {
          i = 0;
        }
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < this.recognitions.size())
      {
        if (((ARRecognition)this.recognitions.get(i)).jdField_a_of_type_Int != 0) {
          bool1 = true;
        }
      }
      else
      {
        Object localObject = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss.SSS");
        String str = ((SimpleDateFormat)localObject).format(new Date(this.aRCloudBegin));
        localObject = ((SimpleDateFormat)localObject).format(new Date(this.aRCloudEnd));
        QLog.i("AREngine_ARCommonConfigInfo", 1, "isEnableARCloud = " + bool1 + ", aRCloudBegin = " + this.aRCloudBegin + ", aRCloudEnd = " + this.aRCloudEnd + ", timeBeginStr = " + str + ", timeEndStr = " + (String)localObject);
        return bool1;
      }
      i += 1;
    }
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("CommonConfigInfo{");
    localStringBuffer.append("versionId='").append(this.versionId).append('\'');
    localStringBuffer.append(", aRCloudBegin=").append(this.aRCloudBegin);
    localStringBuffer.append(", aRCloudCacheExpireTime=").append(this.aRCloudCacheExpireTime);
    localStringBuffer.append(", aRCloudEnd=").append(this.aRCloudEnd);
    localStringBuffer.append(", arControllers=").append(this.arControllers);
    localStringBuffer.append(", switchRecogOpen=").append(this.switchRecogOpen);
    localStringBuffer.append(", recognitions=").append(this.recognitions);
    localStringBuffer.append(", nativeSoResList = ").append(this.nativeSoResList);
    localStringBuffer.append(", mARNoResultCheckTime = ").append(this.mARNoResultCheckTime);
    localStringBuffer.append(", mARCloudUploadCheckTime = ").append(this.mARCloudUploadCheckTime);
    localStringBuffer.append(", mARCloudUploadDelayTime = ").append(this.mARCloudUploadDelayTime);
    localStringBuffer.append(", mARLocalStartDelay = ").append(this.mARLocalStartDelay);
    localStringBuffer.append(", isOpenVideoRecordSwitch = ").append(this.isEnableVideoRecord);
    localStringBuffer.append(", switchLBSLocation = ").append(this.switchLBSLocation);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo
 * JD-Core Version:    0.7.0.1
 */