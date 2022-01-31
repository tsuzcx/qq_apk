package com.tencent.mobileqq.ar.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.armap.ArMapUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import org.xmlpull.v1.XmlPullParser;
import zzs;

public class ARScanStarFaceConfigInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new zzs();
  static boolean a;
  static String b;
  public String a;
  public ARScanStarFaceActInfo[] a;
  
  static
  {
    jdField_b_of_type_JavaLangString = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n\n<!--扫明星脸活动-->\n<ScanStarConfig>\n\t<!--普通人脸描述wording-->\n\t<normalFaceDescription>发现一个很酷的人，去扫明星有惊喜！</normalFaceDescription>\n\t<Activity>\n\t\t<actID>11</actID>\n\t\t<starName>杨洋</starName>\n\t\t<starUin>12345</starUin>\n\t\t<!--活动标题-->\n\t\t<actTitle>杨洋代言空间</actTitle>\n\t\t<!--活动描述wording-->\n\t\t<actDescription>杨洋活动简介</actDescription>\n\t\t<!--活动跳转Web的地址-->\n\t\t<starWebUrl>https://qq.com/starweburl.html</starWebUrl>\n\t\t<!--广告图片url-->\n\t\t<adImgUrl>https://qq.com/adimgurl.html</adImgUrl>\n\t\t<!--活动开始时间-->\n\t\t<beginTime>2017-05-07 00:00</beginTime>\n\t\t<!--活动结束时间-->\n\t\t<endTime>2017-07-31 23:59</endTime>\n\t</Activity>\n\t\n\t<Activity>\n\t\t<actID>12</actID>\n\t\t<starName>杨颖</starName>\n\t\t<starUin>12346</starUin>\n\t\t<!--活动标题-->\n\t\t<actTitle>杨颖代言XX</actTitle>\n\t\t<!--活动描述wording-->\n\t\t<actDescription>杨颖活动简介</actDescription>\n\t\t<!--活动跳转Web的地址-->\n\t\t<starWebUrl>https://qq.com/starweburl2.html</starWebUrl>\n\t\t<!--广告图片url-->\n\t\t<adImgUrl>https://qq.com/adimgurl2.html</adImgUrl>\n\t\t<!--活动开始时间-->\n\t\t<beginTime>2017-06-07 00:00</beginTime>\n\t\t<!--活动结束时间-->\n\t\t<endTime>2017-08-31 23:59</endTime>\n\t</Activity>\n</ScanStarConfig>\n\n\n\n\n";
  }
  
  public ARScanStarFaceConfigInfo() {}
  
  public ARScanStarFaceConfigInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_ArrayOfComTencentMobileqqArAidlARScanStarFaceActInfo = ((ARScanStarFaceActInfo[])paramParcel.createTypedArray(ARScanStarFaceActInfo.CREATOR));
  }
  
  public static ARScanStarFaceConfigInfo a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanStarFaceCfgInfo", 2, "loadConfigFromFile. uin = " + paramString);
    }
    if (paramString == null) {
      return null;
    }
    return a(BaseApplicationImpl.sApplication.getFilesDir().getPath(), "ar_scan_star_face_config" + paramString);
  }
  
  /* Error */
  public static ARScanStarFaceConfigInfo a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore_3
    //   5: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +37 -> 45
    //   11: ldc 56
    //   13: iconst_2
    //   14: new 58	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   21: ldc 98
    //   23: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_0
    //   27: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc 100
    //   32: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_1
    //   36: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: getstatic 102	com/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo:jdField_a_of_type_Boolean	Z
    //   48: ifeq +12 -> 60
    //   51: getstatic 26	com/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   54: invokestatic 104	com/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo;
    //   57: astore_2
    //   58: aload_2
    //   59: areturn
    //   60: aload_3
    //   61: astore_2
    //   62: aload_0
    //   63: ifnull -5 -> 58
    //   66: aload_3
    //   67: astore_2
    //   68: aload_0
    //   69: ldc 106
    //   71: invokevirtual 112	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   74: ifne -16 -> 58
    //   77: aload_3
    //   78: astore_2
    //   79: aload_1
    //   80: ifnull -22 -> 58
    //   83: aload_3
    //   84: astore_2
    //   85: aload_1
    //   86: ldc 106
    //   88: invokevirtual 112	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   91: ifne -33 -> 58
    //   94: new 84	java/io/File
    //   97: dup
    //   98: aload_0
    //   99: aload_1
    //   100: invokespecial 115	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: astore 7
    //   105: aload_3
    //   106: astore_2
    //   107: aload 7
    //   109: invokevirtual 118	java/io/File:exists	()Z
    //   112: ifeq -54 -> 58
    //   115: new 120	java/io/FileInputStream
    //   118: dup
    //   119: aload 7
    //   121: invokespecial 123	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   124: astore_0
    //   125: new 125	java/io/BufferedInputStream
    //   128: dup
    //   129: aload_0
    //   130: invokespecial 128	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   133: astore 5
    //   135: aload_0
    //   136: astore_2
    //   137: aload 5
    //   139: astore_1
    //   140: aload_0
    //   141: invokevirtual 132	java/io/FileInputStream:available	()I
    //   144: newarray byte
    //   146: astore_3
    //   147: aload_0
    //   148: astore_2
    //   149: aload 5
    //   151: astore_1
    //   152: aload 5
    //   154: aload_3
    //   155: invokevirtual 136	java/io/BufferedInputStream:read	([B)I
    //   158: pop
    //   159: aload_0
    //   160: astore_2
    //   161: aload 5
    //   163: astore_1
    //   164: new 108	java/lang/String
    //   167: dup
    //   168: aload_3
    //   169: ldc 138
    //   171: invokespecial 141	java/lang/String:<init>	([BLjava/lang/String;)V
    //   174: invokestatic 104	com/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo;
    //   177: astore_3
    //   178: aload_3
    //   179: astore_2
    //   180: aload 5
    //   182: ifnull +8 -> 190
    //   185: aload 5
    //   187: invokevirtual 144	java/io/BufferedInputStream:close	()V
    //   190: aload_2
    //   191: astore_1
    //   192: aload_0
    //   193: ifnull +9 -> 202
    //   196: aload_0
    //   197: invokevirtual 145	java/io/FileInputStream:close	()V
    //   200: aload_2
    //   201: astore_1
    //   202: aload_1
    //   203: astore_2
    //   204: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   207: ifeq -149 -> 58
    //   210: ldc 56
    //   212: iconst_2
    //   213: new 58	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   220: ldc 147
    //   222: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: aload_1
    //   226: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   229: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   235: aload_1
    //   236: areturn
    //   237: astore_1
    //   238: aload_1
    //   239: invokevirtual 153	java/io/IOException:printStackTrace	()V
    //   242: goto -52 -> 190
    //   245: astore_0
    //   246: aload_0
    //   247: invokevirtual 153	java/io/IOException:printStackTrace	()V
    //   250: aload_2
    //   251: astore_1
    //   252: goto -50 -> 202
    //   255: astore 4
    //   257: aconst_null
    //   258: astore_3
    //   259: aconst_null
    //   260: astore_0
    //   261: aload_3
    //   262: astore_2
    //   263: aload_0
    //   264: astore_1
    //   265: aload 7
    //   267: invokevirtual 156	java/io/File:delete	()Z
    //   270: pop
    //   271: aload_3
    //   272: astore_2
    //   273: aload_0
    //   274: astore_1
    //   275: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   278: ifeq +33 -> 311
    //   281: aload_3
    //   282: astore_2
    //   283: aload_0
    //   284: astore_1
    //   285: ldc 56
    //   287: iconst_2
    //   288: new 58	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   295: ldc 158
    //   297: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: aload 4
    //   302: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   305: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: invokestatic 161	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   311: aload_0
    //   312: ifnull +7 -> 319
    //   315: aload_0
    //   316: invokevirtual 144	java/io/BufferedInputStream:close	()V
    //   319: aload 6
    //   321: astore_1
    //   322: aload_3
    //   323: ifnull -121 -> 202
    //   326: aload_3
    //   327: invokevirtual 145	java/io/FileInputStream:close	()V
    //   330: aload 6
    //   332: astore_1
    //   333: goto -131 -> 202
    //   336: astore_0
    //   337: aload_0
    //   338: invokevirtual 153	java/io/IOException:printStackTrace	()V
    //   341: aload 6
    //   343: astore_1
    //   344: goto -142 -> 202
    //   347: astore_0
    //   348: aload_0
    //   349: invokevirtual 153	java/io/IOException:printStackTrace	()V
    //   352: goto -33 -> 319
    //   355: astore_3
    //   356: aconst_null
    //   357: astore_0
    //   358: aconst_null
    //   359: astore_1
    //   360: aload_1
    //   361: ifnull +7 -> 368
    //   364: aload_1
    //   365: invokevirtual 144	java/io/BufferedInputStream:close	()V
    //   368: aload_0
    //   369: ifnull +7 -> 376
    //   372: aload_0
    //   373: invokevirtual 145	java/io/FileInputStream:close	()V
    //   376: aload_3
    //   377: athrow
    //   378: astore_1
    //   379: aload_1
    //   380: invokevirtual 153	java/io/IOException:printStackTrace	()V
    //   383: goto -15 -> 368
    //   386: astore_0
    //   387: aload_0
    //   388: invokevirtual 153	java/io/IOException:printStackTrace	()V
    //   391: goto -15 -> 376
    //   394: astore_3
    //   395: aconst_null
    //   396: astore_1
    //   397: goto -37 -> 360
    //   400: astore_3
    //   401: aload_2
    //   402: astore_0
    //   403: goto -43 -> 360
    //   406: astore 4
    //   408: aconst_null
    //   409: astore_1
    //   410: aload_0
    //   411: astore_3
    //   412: aload_1
    //   413: astore_0
    //   414: goto -153 -> 261
    //   417: astore 4
    //   419: aload_0
    //   420: astore_3
    //   421: aload 5
    //   423: astore_0
    //   424: goto -163 -> 261
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	427	0	paramString1	String
    //   0	427	1	paramString2	String
    //   57	345	2	localObject1	Object
    //   4	323	3	localObject2	Object
    //   355	22	3	localObject3	Object
    //   394	1	3	localObject4	Object
    //   400	1	3	localObject5	Object
    //   411	10	3	str	String
    //   255	46	4	localThrowable1	java.lang.Throwable
    //   406	1	4	localThrowable2	java.lang.Throwable
    //   417	1	4	localThrowable3	java.lang.Throwable
    //   133	289	5	localBufferedInputStream	java.io.BufferedInputStream
    //   1	341	6	localObject6	Object
    //   103	163	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   185	190	237	java/io/IOException
    //   196	200	245	java/io/IOException
    //   115	125	255	java/lang/Throwable
    //   326	330	336	java/io/IOException
    //   315	319	347	java/io/IOException
    //   115	125	355	finally
    //   364	368	378	java/io/IOException
    //   372	376	386	java/io/IOException
    //   125	135	394	finally
    //   140	147	400	finally
    //   152	159	400	finally
    //   164	178	400	finally
    //   265	271	400	finally
    //   275	281	400	finally
    //   285	311	400	finally
    //   125	135	406	java/lang/Throwable
    //   140	147	417	java/lang/Throwable
    //   152	159	417	java/lang/Throwable
    //   164	178	417	java/lang/Throwable
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanStarFaceCfgInfo", 2, "deleteConfigFile. uin = " + paramString);
    }
    if (paramString == null) {
      return;
    }
    a(BaseApplicationImpl.sApplication.getFilesDir().getPath(), "ar_scan_star_face_config" + paramString);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanStarFaceCfgInfo", 2, "deleteConfigFile. dir = " + paramString1 + ", filename = " + paramString2);
    }
    if ((paramString1 == null) || (paramString1.equals("")) || (paramString2 == null) || (paramString2.equals(""))) {}
    do
    {
      return;
      paramString1 = new File(paramString1, paramString2);
    } while (!paramString1.exists());
    paramString1.delete();
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanStarFaceCfgInfo", 2, "saveConfigToFile. uin = " + paramString2);
    }
    if (paramString2 == null) {
      return false;
    }
    return a(paramString1, BaseApplicationImpl.sApplication.getFilesDir().getPath(), "ar_scan_star_face_config" + paramString2);
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +37 -> 43
    //   9: ldc 56
    //   11: iconst_2
    //   12: new 58	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   19: ldc 178
    //   21: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 100
    //   30: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_2
    //   34: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: aload_0
    //   44: ifnull +29 -> 73
    //   47: aload_1
    //   48: ifnull +25 -> 73
    //   51: aload_1
    //   52: ldc 106
    //   54: invokevirtual 112	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   57: ifne +16 -> 73
    //   60: aload_2
    //   61: ifnull +12 -> 73
    //   64: aload_2
    //   65: ldc 106
    //   67: invokevirtual 112	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   70: ifeq +7 -> 77
    //   73: iconst_0
    //   74: istore_3
    //   75: iload_3
    //   76: ireturn
    //   77: new 84	java/io/File
    //   80: dup
    //   81: aload_1
    //   82: aload_2
    //   83: invokespecial 115	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: astore 6
    //   88: new 84	java/io/File
    //   91: dup
    //   92: aload_1
    //   93: new 58	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   100: aload_2
    //   101: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc 180
    //   106: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokespecial 115	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: astore 7
    //   117: iconst_0
    //   118: newarray byte
    //   120: astore_1
    //   121: aload_0
    //   122: ldc 138
    //   124: invokevirtual 184	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   127: astore_0
    //   128: aload 6
    //   130: invokevirtual 187	java/io/File:getParentFile	()Ljava/io/File;
    //   133: astore_1
    //   134: aload_1
    //   135: invokevirtual 118	java/io/File:exists	()Z
    //   138: ifne +8 -> 146
    //   141: aload_1
    //   142: invokevirtual 190	java/io/File:mkdir	()Z
    //   145: pop
    //   146: aload 7
    //   148: invokevirtual 118	java/io/File:exists	()Z
    //   151: ifeq +9 -> 160
    //   154: aload 7
    //   156: invokevirtual 156	java/io/File:delete	()Z
    //   159: pop
    //   160: new 192	java/io/FileOutputStream
    //   163: dup
    //   164: aload 7
    //   166: invokespecial 193	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   169: astore_2
    //   170: new 195	java/io/BufferedOutputStream
    //   173: dup
    //   174: aload_2
    //   175: invokespecial 198	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   178: astore_1
    //   179: aload_1
    //   180: aload_0
    //   181: invokevirtual 202	java/io/BufferedOutputStream:write	([B)V
    //   184: aload_1
    //   185: invokevirtual 205	java/io/BufferedOutputStream:flush	()V
    //   188: aload 7
    //   190: aload 6
    //   192: invokestatic 210	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/io/File;Ljava/io/File;)Z
    //   195: istore 4
    //   197: aload_1
    //   198: ifnull +7 -> 205
    //   201: aload_1
    //   202: invokevirtual 211	java/io/BufferedOutputStream:close	()V
    //   205: iload 4
    //   207: istore_3
    //   208: aload_2
    //   209: ifnull -134 -> 75
    //   212: aload_2
    //   213: invokevirtual 212	java/io/FileOutputStream:close	()V
    //   216: iload 4
    //   218: ireturn
    //   219: astore_0
    //   220: aload_0
    //   221: invokevirtual 153	java/io/IOException:printStackTrace	()V
    //   224: iload 4
    //   226: ireturn
    //   227: astore_0
    //   228: aload_0
    //   229: invokevirtual 213	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   232: aload_1
    //   233: astore_0
    //   234: goto -106 -> 128
    //   237: astore_0
    //   238: aload_0
    //   239: invokevirtual 153	java/io/IOException:printStackTrace	()V
    //   242: goto -37 -> 205
    //   245: astore_2
    //   246: aconst_null
    //   247: astore_1
    //   248: aload 5
    //   250: astore_0
    //   251: aload_2
    //   252: invokevirtual 153	java/io/IOException:printStackTrace	()V
    //   255: aload_1
    //   256: ifnull +7 -> 263
    //   259: aload_1
    //   260: invokevirtual 211	java/io/BufferedOutputStream:close	()V
    //   263: aload_0
    //   264: ifnull +7 -> 271
    //   267: aload_0
    //   268: invokevirtual 212	java/io/FileOutputStream:close	()V
    //   271: iconst_0
    //   272: ireturn
    //   273: astore_1
    //   274: aload_1
    //   275: invokevirtual 153	java/io/IOException:printStackTrace	()V
    //   278: goto -15 -> 263
    //   281: astore_0
    //   282: aload_0
    //   283: invokevirtual 153	java/io/IOException:printStackTrace	()V
    //   286: goto -15 -> 271
    //   289: astore_0
    //   290: aconst_null
    //   291: astore_1
    //   292: aconst_null
    //   293: astore_2
    //   294: aload_1
    //   295: ifnull +7 -> 302
    //   298: aload_1
    //   299: invokevirtual 211	java/io/BufferedOutputStream:close	()V
    //   302: aload_2
    //   303: ifnull +7 -> 310
    //   306: aload_2
    //   307: invokevirtual 212	java/io/FileOutputStream:close	()V
    //   310: aload_0
    //   311: athrow
    //   312: astore_1
    //   313: aload_1
    //   314: invokevirtual 153	java/io/IOException:printStackTrace	()V
    //   317: goto -15 -> 302
    //   320: astore_1
    //   321: aload_1
    //   322: invokevirtual 153	java/io/IOException:printStackTrace	()V
    //   325: goto -15 -> 310
    //   328: astore_0
    //   329: aconst_null
    //   330: astore_1
    //   331: goto -37 -> 294
    //   334: astore_0
    //   335: goto -41 -> 294
    //   338: astore 5
    //   340: aload_0
    //   341: astore_2
    //   342: aload 5
    //   344: astore_0
    //   345: goto -51 -> 294
    //   348: astore 5
    //   350: aconst_null
    //   351: astore_1
    //   352: aload_2
    //   353: astore_0
    //   354: aload 5
    //   356: astore_2
    //   357: goto -106 -> 251
    //   360: astore 5
    //   362: aload_2
    //   363: astore_0
    //   364: aload 5
    //   366: astore_2
    //   367: goto -116 -> 251
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	370	0	paramString1	String
    //   0	370	1	paramString2	String
    //   0	370	2	paramString3	String
    //   74	134	3	bool1	boolean
    //   195	30	4	bool2	boolean
    //   1	248	5	localObject1	Object
    //   338	5	5	localObject2	Object
    //   348	7	5	localIOException1	java.io.IOException
    //   360	5	5	localIOException2	java.io.IOException
    //   86	105	6	localFile1	File
    //   115	74	7	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   212	216	219	java/io/IOException
    //   121	128	227	java/io/UnsupportedEncodingException
    //   201	205	237	java/io/IOException
    //   160	170	245	java/io/IOException
    //   259	263	273	java/io/IOException
    //   267	271	281	java/io/IOException
    //   160	170	289	finally
    //   298	302	312	java/io/IOException
    //   306	310	320	java/io/IOException
    //   170	179	328	finally
    //   179	197	334	finally
    //   251	255	338	finally
    //   170	179	348	java/io/IOException
    //   179	197	360	java/io/IOException
  }
  
  public static ARScanStarFaceConfigInfo b(String paramString)
  {
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    ARScanStarFaceConfigInfo localARScanStarFaceConfigInfo = new ARScanStarFaceConfigInfo();
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        localXmlPullParser.setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
        i = localXmlPullParser.getEventType();
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ScanStarFaceCfgInfo", 2, paramString, localException);
        return null;
      }
      int i = localXmlPullParser.next();
      break label541;
      localObject = localXmlPullParser.getName();
      if (((String)localObject).equalsIgnoreCase("Activity"))
      {
        localObject = new ARScanStarFaceActInfo();
        i = localXmlPullParser.next();
        if (i != 1) {
          if (i == 2)
          {
            str = localXmlPullParser.getName();
            bool = str.equalsIgnoreCase("actID");
            if (bool) {
              try
              {
                ((ARScanStarFaceActInfo)localObject).jdField_c_of_type_Long = Long.valueOf(localXmlPullParser.nextText()).longValue();
                i = localXmlPullParser.next();
              }
              catch (NumberFormatException localNumberFormatException)
              {
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.e("ScanStarFaceCfgInfo", 2, "actID parse failed", localNumberFormatException);
                continue;
              }
            } else if (localNumberFormatException.equalsIgnoreCase("starName")) {
              ((ARScanStarFaceActInfo)localObject).jdField_a_of_type_JavaLangString = localException.nextText();
            } else if (localNumberFormatException.equalsIgnoreCase("starUin")) {
              ((ARScanStarFaceActInfo)localObject).jdField_b_of_type_JavaLangString = localException.nextText();
            } else if (localNumberFormatException.equalsIgnoreCase("actTitle")) {
              ((ARScanStarFaceActInfo)localObject).jdField_c_of_type_JavaLangString = localException.nextText();
            } else if (localNumberFormatException.equalsIgnoreCase("actDescription")) {
              ((ARScanStarFaceActInfo)localObject).d = localException.nextText();
            } else if (localNumberFormatException.equalsIgnoreCase("starWebUrl")) {
              ((ARScanStarFaceActInfo)localObject).e = localException.nextText();
            } else if (localNumberFormatException.equalsIgnoreCase("adImgUrl")) {
              ((ARScanStarFaceActInfo)localObject).f = localException.nextText();
            } else if (localNumberFormatException.equalsIgnoreCase("beginTime")) {
              ((ARScanStarFaceActInfo)localObject).jdField_a_of_type_Long = ArMapUtil.b(localException.nextText());
            } else if (localNumberFormatException.equalsIgnoreCase("endTime")) {
              ((ARScanStarFaceActInfo)localObject).jdField_b_of_type_Long = ArMapUtil.b(localException.nextText());
            }
          }
          else if ((i == 3) && (localException.getName().equalsIgnoreCase("Activity")))
          {
            localArrayList.add(localObject);
          }
        }
      }
      else if (((String)localObject).equalsIgnoreCase("normalFaceDescription"))
      {
        localARScanStarFaceConfigInfo.jdField_a_of_type_JavaLangString = localException.nextText();
        label541:
        while (i == 1)
        {
          Object localObject;
          String str;
          boolean bool;
          if (localArrayList.size() > 0)
          {
            localARScanStarFaceConfigInfo.jdField_a_of_type_ArrayOfComTencentMobileqqArAidlARScanStarFaceActInfo = new ARScanStarFaceActInfo[localArrayList.size()];
            localArrayList.toArray(localARScanStarFaceConfigInfo.jdField_a_of_type_ArrayOfComTencentMobileqqArAidlARScanStarFaceActInfo);
          }
          if (QLog.isColorLevel()) {
            QLog.d("ScanStarFaceCfgInfo", 2, "parseConfig success|config=" + Arrays.toString(localARScanStarFaceConfigInfo.jdField_a_of_type_ArrayOfComTencentMobileqqArAidlARScanStarFaceActInfo) + ", normalFaceDescription =" + localARScanStarFaceConfigInfo.jdField_a_of_type_JavaLangString);
          }
          return localARScanStarFaceConfigInfo;
        }
        switch (i)
        {
        }
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeTypedArray(this.jdField_a_of_type_ArrayOfComTencentMobileqqArAidlARScanStarFaceActInfo, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.aidl.ARScanStarFaceConfigInfo
 * JD-Core Version:    0.7.0.1
 */