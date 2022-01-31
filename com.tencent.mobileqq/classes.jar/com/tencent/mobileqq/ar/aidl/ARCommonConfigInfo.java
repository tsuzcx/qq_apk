package com.tencent.mobileqq.ar.aidl;

import aknk;
import akpi;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.ARRecognition;
import com.tencent.mobileqq.ar.ARRelationShipAIOMsg;
import com.tencent.mobileqq.ar.ARScanAR;
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
  public static final Parcelable.Creator<ARCommonConfigInfo> CREATOR = new akpi();
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
    //   5: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +37 -> 45
    //   11: ldc 33
    //   13: iconst_2
    //   14: new 173	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   21: ldc 239
    //   23: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_0
    //   27: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc 211
    //   32: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_1
    //   36: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: aload_3
    //   46: astore_2
    //   47: aload_0
    //   48: ifnull +31 -> 79
    //   51: aload_3
    //   52: astore_2
    //   53: aload_0
    //   54: ldc 213
    //   56: invokevirtual 218	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   59: ifne +20 -> 79
    //   62: aload_3
    //   63: astore_2
    //   64: aload_1
    //   65: ifnull +14 -> 79
    //   68: aload_1
    //   69: ldc 213
    //   71: invokevirtual 218	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   74: ifeq +7 -> 81
    //   77: aload_3
    //   78: astore_2
    //   79: aload_2
    //   80: areturn
    //   81: new 199	java/io/File
    //   84: dup
    //   85: aload_0
    //   86: aload_1
    //   87: invokespecial 220	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: astore 7
    //   92: aload_3
    //   93: astore_2
    //   94: aload 7
    //   96: invokevirtual 223	java/io/File:exists	()Z
    //   99: ifeq -20 -> 79
    //   102: new 241	java/io/FileInputStream
    //   105: dup
    //   106: aload 7
    //   108: invokespecial 244	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   111: astore_0
    //   112: new 246	java/io/BufferedInputStream
    //   115: dup
    //   116: aload_0
    //   117: invokespecial 249	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   120: astore 5
    //   122: aload_0
    //   123: astore_2
    //   124: aload 5
    //   126: astore_1
    //   127: aload_0
    //   128: invokevirtual 252	java/io/FileInputStream:available	()I
    //   131: newarray byte
    //   133: astore_3
    //   134: aload_0
    //   135: astore_2
    //   136: aload 5
    //   138: astore_1
    //   139: aload 5
    //   141: aload_3
    //   142: invokevirtual 256	java/io/BufferedInputStream:read	([B)I
    //   145: pop
    //   146: aload_0
    //   147: astore_2
    //   148: aload 5
    //   150: astore_1
    //   151: new 215	java/lang/String
    //   154: dup
    //   155: aload_3
    //   156: ldc_w 258
    //   159: invokespecial 261	java/lang/String:<init>	([BLjava/lang/String;)V
    //   162: astore_3
    //   163: aload_0
    //   164: astore_2
    //   165: aload 5
    //   167: astore_1
    //   168: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   171: ifeq +34 -> 205
    //   174: aload_0
    //   175: astore_2
    //   176: aload 5
    //   178: astore_1
    //   179: ldc 33
    //   181: iconst_2
    //   182: new 173	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   189: ldc_w 263
    //   192: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload_3
    //   196: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: aload_0
    //   206: astore_2
    //   207: aload 5
    //   209: astore_1
    //   210: aload_3
    //   211: invokestatic 266	com/tencent/mobileqq/ar/aidl/ARCommonConfigInfo:parseArConfig	(Ljava/lang/String;)Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   214: astore_3
    //   215: aload_3
    //   216: astore_2
    //   217: aload 5
    //   219: ifnull +8 -> 227
    //   222: aload 5
    //   224: invokevirtual 269	java/io/BufferedInputStream:close	()V
    //   227: aload_2
    //   228: astore_1
    //   229: aload_0
    //   230: ifnull +9 -> 239
    //   233: aload_0
    //   234: invokevirtual 270	java/io/FileInputStream:close	()V
    //   237: aload_2
    //   238: astore_1
    //   239: aload_1
    //   240: astore_2
    //   241: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   244: ifeq -165 -> 79
    //   247: ldc 33
    //   249: iconst_2
    //   250: new 173	java/lang/StringBuilder
    //   253: dup
    //   254: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   257: ldc_w 272
    //   260: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: aload_1
    //   264: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   273: aload_1
    //   274: areturn
    //   275: astore_1
    //   276: aload_1
    //   277: invokevirtual 278	java/io/IOException:printStackTrace	()V
    //   280: goto -53 -> 227
    //   283: astore_0
    //   284: aload_0
    //   285: invokevirtual 278	java/io/IOException:printStackTrace	()V
    //   288: aload_2
    //   289: astore_1
    //   290: goto -51 -> 239
    //   293: astore 4
    //   295: aconst_null
    //   296: astore_3
    //   297: aconst_null
    //   298: astore_0
    //   299: aload_3
    //   300: astore_2
    //   301: aload_0
    //   302: astore_1
    //   303: aload 7
    //   305: invokevirtual 226	java/io/File:delete	()Z
    //   308: pop
    //   309: aload_3
    //   310: astore_2
    //   311: aload_0
    //   312: astore_1
    //   313: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   316: ifeq +34 -> 350
    //   319: aload_3
    //   320: astore_2
    //   321: aload_0
    //   322: astore_1
    //   323: ldc 33
    //   325: iconst_2
    //   326: new 173	java/lang/StringBuilder
    //   329: dup
    //   330: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   333: ldc_w 280
    //   336: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: aload 4
    //   341: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   344: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   347: invokestatic 283	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   350: aload_0
    //   351: ifnull +7 -> 358
    //   354: aload_0
    //   355: invokevirtual 269	java/io/BufferedInputStream:close	()V
    //   358: aload 6
    //   360: astore_1
    //   361: aload_3
    //   362: ifnull -123 -> 239
    //   365: aload_3
    //   366: invokevirtual 270	java/io/FileInputStream:close	()V
    //   369: aload 6
    //   371: astore_1
    //   372: goto -133 -> 239
    //   375: astore_0
    //   376: aload_0
    //   377: invokevirtual 278	java/io/IOException:printStackTrace	()V
    //   380: aload 6
    //   382: astore_1
    //   383: goto -144 -> 239
    //   386: astore_0
    //   387: aload_0
    //   388: invokevirtual 278	java/io/IOException:printStackTrace	()V
    //   391: goto -33 -> 358
    //   394: astore_3
    //   395: aconst_null
    //   396: astore_0
    //   397: aconst_null
    //   398: astore_1
    //   399: aload_1
    //   400: ifnull +7 -> 407
    //   403: aload_1
    //   404: invokevirtual 269	java/io/BufferedInputStream:close	()V
    //   407: aload_0
    //   408: ifnull +7 -> 415
    //   411: aload_0
    //   412: invokevirtual 270	java/io/FileInputStream:close	()V
    //   415: aload_3
    //   416: athrow
    //   417: astore_1
    //   418: aload_1
    //   419: invokevirtual 278	java/io/IOException:printStackTrace	()V
    //   422: goto -15 -> 407
    //   425: astore_0
    //   426: aload_0
    //   427: invokevirtual 278	java/io/IOException:printStackTrace	()V
    //   430: goto -15 -> 415
    //   433: astore_3
    //   434: aconst_null
    //   435: astore_1
    //   436: goto -37 -> 399
    //   439: astore_3
    //   440: aload_2
    //   441: astore_0
    //   442: goto -43 -> 399
    //   445: astore 4
    //   447: aconst_null
    //   448: astore_1
    //   449: aload_0
    //   450: astore_3
    //   451: aload_1
    //   452: astore_0
    //   453: goto -154 -> 299
    //   456: astore 4
    //   458: aload_0
    //   459: astore_3
    //   460: aload 5
    //   462: astore_0
    //   463: goto -164 -> 299
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	466	0	paramString1	String
    //   0	466	1	paramString2	String
    //   46	395	2	localObject1	Object
    //   4	362	3	localObject2	Object
    //   394	22	3	localObject3	Object
    //   433	1	3	localObject4	Object
    //   439	1	3	localObject5	Object
    //   450	10	3	str	String
    //   293	47	4	localThrowable1	java.lang.Throwable
    //   445	1	4	localThrowable2	java.lang.Throwable
    //   456	1	4	localThrowable3	java.lang.Throwable
    //   120	341	5	localBufferedInputStream	java.io.BufferedInputStream
    //   1	380	6	localObject6	Object
    //   90	214	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   222	227	275	java/io/IOException
    //   233	237	283	java/io/IOException
    //   102	112	293	java/lang/Throwable
    //   365	369	375	java/io/IOException
    //   354	358	386	java/io/IOException
    //   102	112	394	finally
    //   403	407	417	java/io/IOException
    //   411	415	425	java/io/IOException
    //   112	122	433	finally
    //   127	134	439	finally
    //   139	146	439	finally
    //   151	163	439	finally
    //   168	174	439	finally
    //   179	205	439	finally
    //   210	215	439	finally
    //   303	309	439	finally
    //   313	319	439	finally
    //   323	350	439	finally
    //   112	122	445	java/lang/Throwable
    //   127	134	456	java/lang/Throwable
    //   139	146	456	java/lang/Throwable
    //   151	163	456	java/lang/Throwable
    //   168	174	456	java/lang/Throwable
    //   179	205	456	java/lang/Throwable
    //   210	215	456	java/lang/Throwable
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
      break label2165;
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
        label257:
        if (i != 1)
        {
          if (i != 2) {
            break label817;
          }
          str5 = localException1.getName();
          if (!str5.equalsIgnoreCase("EntryType")) {
            break label313;
          }
          ((ARScanAR)localObject1).jdField_a_of_type_Int = Integer.valueOf(localException1.nextText()).intValue();
        }
        label313:
        while ((i != 3) || (!localException1.getName().equalsIgnoreCase("ScanAR"))) {
          for (;;)
          {
            i = localException1.next();
            break label257;
            break;
            if (str5.equalsIgnoreCase("Begin"))
            {
              ((ARScanAR)localObject1).jdField_a_of_type_Long = aknk.a(localException1.nextText());
            }
            else if (str5.equalsIgnoreCase("End"))
            {
              ((ARScanAR)localObject1).jdField_b_of_type_Long = aknk.a(localException1.nextText());
            }
            else if (str5.equalsIgnoreCase("UserGuideBeginTime"))
            {
              ((ARScanAR)localObject1).jdField_c_of_type_Long = aknk.a(localException1.nextText());
            }
            else if (str5.equalsIgnoreCase("UserGuideEndTime"))
            {
              ((ARScanAR)localObject1).jdField_d_of_type_Long = aknk.a(localException1.nextText());
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
        label817:
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
      else
      {
        label1664:
        if (((String)localObject1).equalsIgnoreCase("Recognition"))
        {
          localObject1 = new ARRecognition();
          i = localException1.next();
          label940:
          if (i != 1)
          {
            if (i != 2) {
              break label1288;
            }
            str6 = localException1.getName();
            if (!str6.equalsIgnoreCase("Type")) {
              break label997;
            }
            ((ARRecognition)localObject1).jdField_a_of_type_Long = Integer.valueOf(localException1.nextText()).intValue();
          }
          label997:
          label1265:
          while ((i != 3) || (!localException1.getName().equalsIgnoreCase("Recognition"))) {
            for (;;)
            {
              i = localException1.next();
              break label940;
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
                          break label1265;
                        }
                        if (localException1.getName().equalsIgnoreCase("Open")) {
                          ((ARRecognition)localObject1).d = Integer.valueOf(localException1.nextText()).intValue();
                        }
                      }
                      while ((i != 3) || (!localException1.getName().equalsIgnoreCase("ImagePreprocess")))
                      {
                        i = localException1.next();
                        break label1213;
                        break;
                      }
                    }
                  }
                }
              }
            }
          }
          label1213:
          localARCommonConfigInfo.recognitions.add(localObject1);
        }
        else
        {
          label1288:
          if (((String)localObject1).equalsIgnoreCase("ARVideoRecordSwitch"))
          {
            i = localException1.next();
            label1340:
            if (i != 1)
            {
              if (i != 2) {
                break label1392;
              }
              if (localException1.getName().equalsIgnoreCase("Enable")) {
                localARCommonConfigInfo.isEnableVideoRecord = Long.valueOf(localException1.nextText()).longValue();
              }
            }
            label1392:
            while ((i != 3) || (!localException1.getName().equalsIgnoreCase("ARVideoRecordSwitch")))
            {
              i = localException1.next();
              break label1340;
              break;
            }
          }
          else if (((String)localObject1).equalsIgnoreCase("Cloud"))
          {
            i = localException1.next();
            label1433:
            if (i != 1)
            {
              if (i != 2) {
                break label1664;
              }
              localObject1 = localException1.getName();
              if (!((String)localObject1).equalsIgnoreCase("Begin")) {
                break label1486;
              }
              localARCommonConfigInfo.aRCloudBegin = aknk.a(localException1.nextText());
            }
            label1486:
            while ((i != 3) || (!localException1.getName().equalsIgnoreCase("Cloud"))) {
              for (;;)
              {
                i = localException1.next();
                break label1433;
                break;
                if (((String)localObject1).equalsIgnoreCase("End"))
                {
                  localARCommonConfigInfo.aRCloudEnd = aknk.a(localException1.nextText());
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
            label1714:
            if (i != 1)
            {
              if (i != 2) {
                break label1888;
              }
              str7 = localException1.getName();
              if (!str7.equalsIgnoreCase("Name")) {
                break label1764;
              }
              ((ARCommonConfigInfo.NativeSoRes)localObject2).jdField_a_of_type_JavaLangString = localException1.nextText();
            }
            label1764:
            while ((i != 3) || (!localException1.getName().equalsIgnoreCase("NativeSoRes"))) {
              for (;;)
              {
                i = localException1.next();
                break label1714;
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
            label1888:
            localARCommonConfigInfo.nativeSoResList.add(localObject2);
          }
          else if (((String)localObject2).equalsIgnoreCase("ARRelationShipAIOMsg"))
          {
            localObject2 = new ARRelationShipAIOMsg();
            i = localException1.next();
            label1949:
            if (i != 1)
            {
              if (i != 2) {
                break label2099;
              }
              str8 = localException1.getName();
              if (!str8.equalsIgnoreCase("AIOMsgSourceName")) {
                break label1999;
              }
              ((ARRelationShipAIOMsg)localObject2).jdField_a_of_type_JavaLangString = localException1.nextText();
            }
            label1999:
            while ((i != 3) || (!localException1.getName().equalsIgnoreCase("ARRelationShipAIOMsg"))) {
              for (;;)
              {
                i = localException1.next();
                break label1949;
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
            label2099:
            localARCommonConfigInfo.mARRelationShipAIOMsg = ((ARRelationShipAIOMsg)localObject2);
            label2165:
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
    //   3: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +38 -> 44
    //   9: ldc 33
    //   11: iconst_2
    //   12: new 173	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 538
    //   22: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_1
    //   26: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc 211
    //   31: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_2
    //   35: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: aload_0
    //   45: ifnull +29 -> 74
    //   48: aload_1
    //   49: ifnull +25 -> 74
    //   52: aload_1
    //   53: ldc 213
    //   55: invokevirtual 218	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   58: ifne +16 -> 74
    //   61: aload_2
    //   62: ifnull +12 -> 74
    //   65: aload_2
    //   66: ldc 213
    //   68: invokevirtual 218	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   71: ifeq +7 -> 78
    //   74: iconst_0
    //   75: istore_3
    //   76: iload_3
    //   77: ireturn
    //   78: new 199	java/io/File
    //   81: dup
    //   82: aload_1
    //   83: aload_2
    //   84: invokespecial 220	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: astore 6
    //   89: new 199	java/io/File
    //   92: dup
    //   93: aload_1
    //   94: new 173	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   101: aload_2
    //   102: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: ldc_w 540
    //   108: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokespecial 220	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   117: astore 7
    //   119: iconst_0
    //   120: newarray byte
    //   122: astore_1
    //   123: aload_0
    //   124: ldc_w 258
    //   127: invokevirtual 543	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   130: astore_0
    //   131: aload 6
    //   133: invokevirtual 546	java/io/File:getParentFile	()Ljava/io/File;
    //   136: astore_1
    //   137: aload_1
    //   138: invokevirtual 223	java/io/File:exists	()Z
    //   141: ifne +8 -> 149
    //   144: aload_1
    //   145: invokevirtual 549	java/io/File:mkdir	()Z
    //   148: pop
    //   149: aload 7
    //   151: invokevirtual 223	java/io/File:exists	()Z
    //   154: ifeq +9 -> 163
    //   157: aload 7
    //   159: invokevirtual 226	java/io/File:delete	()Z
    //   162: pop
    //   163: new 551	java/io/FileOutputStream
    //   166: dup
    //   167: aload 7
    //   169: invokespecial 552	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   172: astore_2
    //   173: new 554	java/io/BufferedOutputStream
    //   176: dup
    //   177: aload_2
    //   178: invokespecial 557	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   181: astore_1
    //   182: aload_1
    //   183: aload_0
    //   184: invokevirtual 560	java/io/BufferedOutputStream:write	([B)V
    //   187: aload_1
    //   188: invokevirtual 563	java/io/BufferedOutputStream:flush	()V
    //   191: aload 7
    //   193: aload 6
    //   195: invokestatic 568	bace:b	(Ljava/io/File;Ljava/io/File;)Z
    //   198: istore 4
    //   200: aload_1
    //   201: ifnull +7 -> 208
    //   204: aload_1
    //   205: invokevirtual 569	java/io/BufferedOutputStream:close	()V
    //   208: iload 4
    //   210: istore_3
    //   211: aload_2
    //   212: ifnull -136 -> 76
    //   215: aload_2
    //   216: invokevirtual 570	java/io/FileOutputStream:close	()V
    //   219: iload 4
    //   221: ireturn
    //   222: astore_0
    //   223: aload_0
    //   224: invokevirtual 278	java/io/IOException:printStackTrace	()V
    //   227: iload 4
    //   229: ireturn
    //   230: astore_0
    //   231: aload_0
    //   232: invokevirtual 571	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   235: aload_1
    //   236: astore_0
    //   237: goto -106 -> 131
    //   240: astore_0
    //   241: aload_0
    //   242: invokevirtual 278	java/io/IOException:printStackTrace	()V
    //   245: goto -37 -> 208
    //   248: astore_2
    //   249: aconst_null
    //   250: astore_1
    //   251: aload 5
    //   253: astore_0
    //   254: aload_2
    //   255: invokevirtual 278	java/io/IOException:printStackTrace	()V
    //   258: aload_1
    //   259: ifnull +7 -> 266
    //   262: aload_1
    //   263: invokevirtual 569	java/io/BufferedOutputStream:close	()V
    //   266: aload_0
    //   267: ifnull +7 -> 274
    //   270: aload_0
    //   271: invokevirtual 570	java/io/FileOutputStream:close	()V
    //   274: iconst_0
    //   275: ireturn
    //   276: astore_1
    //   277: aload_1
    //   278: invokevirtual 278	java/io/IOException:printStackTrace	()V
    //   281: goto -15 -> 266
    //   284: astore_0
    //   285: aload_0
    //   286: invokevirtual 278	java/io/IOException:printStackTrace	()V
    //   289: goto -15 -> 274
    //   292: astore_0
    //   293: aconst_null
    //   294: astore_1
    //   295: aconst_null
    //   296: astore_2
    //   297: aload_1
    //   298: ifnull +7 -> 305
    //   301: aload_1
    //   302: invokevirtual 569	java/io/BufferedOutputStream:close	()V
    //   305: aload_2
    //   306: ifnull +7 -> 313
    //   309: aload_2
    //   310: invokevirtual 570	java/io/FileOutputStream:close	()V
    //   313: aload_0
    //   314: athrow
    //   315: astore_1
    //   316: aload_1
    //   317: invokevirtual 278	java/io/IOException:printStackTrace	()V
    //   320: goto -15 -> 305
    //   323: astore_1
    //   324: aload_1
    //   325: invokevirtual 278	java/io/IOException:printStackTrace	()V
    //   328: goto -15 -> 313
    //   331: astore_0
    //   332: aconst_null
    //   333: astore_1
    //   334: goto -37 -> 297
    //   337: astore_0
    //   338: goto -41 -> 297
    //   341: astore 5
    //   343: aload_0
    //   344: astore_2
    //   345: aload 5
    //   347: astore_0
    //   348: goto -51 -> 297
    //   351: astore 5
    //   353: aconst_null
    //   354: astore_1
    //   355: aload_2
    //   356: astore_0
    //   357: aload 5
    //   359: astore_2
    //   360: goto -106 -> 254
    //   363: astore 5
    //   365: aload_2
    //   366: astore_0
    //   367: aload 5
    //   369: astore_2
    //   370: goto -116 -> 254
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	373	0	paramString1	String
    //   0	373	1	paramString2	String
    //   0	373	2	paramString3	String
    //   75	136	3	bool1	boolean
    //   198	30	4	bool2	boolean
    //   1	251	5	localObject1	Object
    //   341	5	5	localObject2	Object
    //   351	7	5	localIOException1	java.io.IOException
    //   363	5	5	localIOException2	java.io.IOException
    //   87	107	6	localFile1	File
    //   117	75	7	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   215	219	222	java/io/IOException
    //   123	131	230	java/io/UnsupportedEncodingException
    //   204	208	240	java/io/IOException
    //   163	173	248	java/io/IOException
    //   262	266	276	java/io/IOException
    //   270	274	284	java/io/IOException
    //   163	173	292	finally
    //   301	305	315	java/io/IOException
    //   309	313	323	java/io/IOException
    //   173	182	331	finally
    //   182	200	337	finally
    //   254	258	341	finally
    //   173	182	351	java/io/IOException
    //   182	200	363	java/io/IOException
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo
 * JD-Core Version:    0.7.0.1
 */