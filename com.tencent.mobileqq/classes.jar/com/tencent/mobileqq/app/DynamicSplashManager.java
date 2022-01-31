package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.FileUtils;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import oicq.wlogin_sdk.tools.MD5;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DynamicSplashManager
{
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() begin");
    }
    for (;;)
    {
      try
      {
        String str1 = BaseApplicationImpl.getContext().getFilesDir().getAbsolutePath() + "/dynamicSplash";
        Object localObject1 = new File(str1);
        if (!((File)localObject1).exists())
        {
          ((File)localObject1).mkdirs();
          localObject3 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
          if (((Document)localObject3).getElementsByTagName("splash").getLength() < 1) {
            return false;
          }
        }
        else
        {
          if ((localObject1 == null) || (!((File)localObject1).isDirectory())) {
            continue;
          }
          localObject1 = ((File)localObject1).listFiles();
          if (localObject1 == null) {
            continue;
          }
          j = localObject1.length;
          i = 0;
          if (i >= j) {
            continue;
          }
          localObject2 = localObject1[i];
          if ((localObject2 == null) || (!((File)localObject2).exists())) {
            break label1053;
          }
          ((File)localObject2).delete();
          break label1053;
        }
        Object localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        paramString = ((Document)localObject3).getElementsByTagName("img").item(0).getFirstChild().getNodeValue();
        String str3 = ((Document)localObject3).getElementsByTagName("begin").item(0).getFirstChild().getNodeValue();
        String str2 = ((Document)localObject3).getElementsByTagName("end").item(0).getFirstChild().getNodeValue();
        localObject1 = ((Document)localObject3).getElementsByTagName("md5").item(0).getFirstChild().getNodeValue();
        int j = Integer.valueOf(((Document)localObject3).getElementsByTagName("download_net").item(0).getFirstChild().getNodeValue()).intValue();
        int k = Integer.valueOf(((Document)localObject3).getElementsByTagName("play_times").item(0).getFirstChild().getNodeValue()).intValue();
        int m = Integer.valueOf(((Document)localObject3).getElementsByTagName("play_interval").item(0).getFirstChild().getNodeValue()).intValue();
        int n = Integer.valueOf(((Document)localObject3).getElementsByTagName("total_show_times").item(0).getFirstChild().getNodeValue()).intValue();
        Object localObject3 = ((SimpleDateFormat)localObject2).parse(str3).getTime() + "|" + ((SimpleDateFormat)localObject2).parse(str2).getTime();
        int i1 = NetworkUtil.a(BaseApplication.getContext());
        i = 0;
        if (i1 == 2)
        {
          if (!QLog.isColorLevel()) {
            break label1060;
          }
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() userNetworkType == NetType.G2");
          break label1060;
          if (QLog.isColorLevel()) {
            QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() userNetworkValue == " + i);
          }
          if (i < j)
          {
            if (!QLog.isColorLevel()) {
              break label1065;
            }
            QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() user network NOT allow download, return");
            break label1065;
          }
        }
        else
        {
          if (i1 == 3)
          {
            if (!QLog.isColorLevel()) {
              break label1067;
            }
            QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() userNetworkType == NetType.G3");
            break label1067;
          }
          if (i1 == 4)
          {
            if (!QLog.isColorLevel()) {
              break label1073;
            }
            QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() userNetworkType == NetType.G4");
            break label1073;
          }
          if (i1 != 1) {
            continue;
          }
          if (!QLog.isColorLevel()) {
            break label1079;
          }
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() userNetworkType == NetType.WIFI");
          break label1079;
        }
        SharedPreUtils.a(BaseApplicationImpl.getContext(), paramInt, k, m, n, (String)localObject1, (String)localObject3, paramString);
        if (QLog.isColorLevel()) {
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() SUCCESS record to SP");
        }
        if (((SimpleDateFormat)localObject2).parse(str2).getTime() < System.currentTimeMillis())
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() the config is out of date, return");
          break;
        }
        localObject2 = new File(str1 + "/" + (String)localObject1 + ".zip");
        if (!a(paramQQAppInterface, paramString, (File)localObject2, (String)localObject1))
        {
          if (!QLog.isColorLevel()) {
            break label1087;
          }
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() downloadZipFile is filed, return");
          break label1087;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() downloadZipFile is SUCCESS");
        }
        paramQQAppInterface = str1 + "/" + (String)localObject1;
        paramString = new File(paramQQAppInterface);
        if (!FileUtils.b((File)localObject2, paramString))
        {
          if ((paramString != null) && (paramString.exists())) {
            paramString.delete();
          }
          if (!QLog.isColorLevel()) {
            break label1089;
          }
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() unzip is filed, return");
          break label1089;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() unzip is SUCCESS");
        }
        if (!a(paramQQAppInterface + "/md5.txt", paramQQAppInterface))
        {
          if (!QLog.isColorLevel()) {
            break label1091;
          }
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() checkUnzipFileMd5 is filed, return");
          break label1091;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() checkUnzipFileMd5 is SUCCESS");
        }
        if ((paramString != null) && (paramString.isDirectory()))
        {
          long l = paramString.lastModified();
          paramQQAppInterface = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
          paramQQAppInterface.putLong("dynamic_splash_config_folder_modify_time", l);
          paramQQAppInterface.commit();
        }
        if (QLog.isColorLevel())
        {
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() the folder path of splash is" + str1);
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() finish");
        }
        return true;
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() ERROR = " + paramQQAppInterface.getMessage());
        }
        return false;
      }
      label1053:
      i += 1;
      continue;
      label1060:
      int i = 0;
      continue;
      label1065:
      return false;
      label1067:
      i = 10;
      continue;
      label1073:
      i = 20;
      continue;
      label1079:
      i = 100;
    }
    return true;
    label1087:
    return false;
    label1089:
    return false;
    label1091:
    return false;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, String paramString1, File paramFile, String paramString2)
  {
    if ((paramFile != null) && (paramFile.exists()))
    {
      String str = MD5.getFileMD5(paramFile);
      if ((str == null) || (!str.equalsIgnoreCase(paramString2))) {}
    }
    do
    {
      return true;
      paramFile.delete();
      boolean bool = HttpDownloadUtil.a(paramQQAppInterface, paramString1, paramFile);
      if ((paramFile == null) || (!paramFile.exists())) {
        break;
      }
      if (bool != true) {
        break label82;
      }
      paramQQAppInterface = MD5.getFileMD5(paramFile);
    } while ((paramQQAppInterface != null) && (paramQQAppInterface.equalsIgnoreCase(paramString2)));
    return false;
    label82:
    paramFile.delete();
    return false;
  }
  
  /* Error */
  private static boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 10
    //   3: iconst_0
    //   4: istore 7
    //   6: iload 7
    //   8: istore 8
    //   10: aload_0
    //   11: invokestatic 300	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifne +14 -> 28
    //   17: aload_1
    //   18: invokestatic 300	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifeq +10 -> 31
    //   24: iload 7
    //   26: istore 8
    //   28: iload 8
    //   30: ireturn
    //   31: new 44	java/io/File
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 60	java/io/File:<init>	(Ljava/lang/String;)V
    //   39: astore 11
    //   41: new 44	java/io/File
    //   44: dup
    //   45: aload_1
    //   46: invokespecial 60	java/io/File:<init>	(Ljava/lang/String;)V
    //   49: astore 12
    //   51: aload 12
    //   53: invokevirtual 63	java/io/File:exists	()Z
    //   56: ifeq +11 -> 67
    //   59: aload 12
    //   61: invokevirtual 112	java/io/File:isDirectory	()Z
    //   64: ifne +37 -> 101
    //   67: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   70: ifeq +12 -> 82
    //   73: ldc 21
    //   75: iconst_2
    //   76: ldc_w 302
    //   79: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   82: iload 7
    //   84: istore 8
    //   86: iconst_0
    //   87: ifeq -59 -> 28
    //   90: new 304	java/lang/NullPointerException
    //   93: dup
    //   94: invokespecial 305	java/lang/NullPointerException:<init>	()V
    //   97: athrow
    //   98: astore_0
    //   99: iconst_0
    //   100: ireturn
    //   101: aload 12
    //   103: invokevirtual 116	java/io/File:listFiles	()[Ljava/io/File;
    //   106: astore 12
    //   108: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   111: ifeq +85 -> 196
    //   114: aload 12
    //   116: arraylength
    //   117: istore_3
    //   118: iconst_0
    //   119: istore_2
    //   120: iload_2
    //   121: iload_3
    //   122: if_icmpge +46 -> 168
    //   125: aload 12
    //   127: iload_2
    //   128: aaload
    //   129: astore 13
    //   131: ldc 21
    //   133: iconst_2
    //   134: new 29	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   141: ldc_w 307
    //   144: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: aload 13
    //   149: invokevirtual 310	java/io/File:getName	()Ljava/lang/String;
    //   152: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   161: iload_2
    //   162: iconst_1
    //   163: iadd
    //   164: istore_2
    //   165: goto -45 -> 120
    //   168: ldc 21
    //   170: iconst_2
    //   171: new 29	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   178: ldc_w 312
    //   181: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload 12
    //   186: arraylength
    //   187: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   190: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   196: aload 12
    //   198: arraylength
    //   199: ifgt +37 -> 236
    //   202: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   205: ifeq +12 -> 217
    //   208: ldc 21
    //   210: iconst_2
    //   211: ldc_w 314
    //   214: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   217: iload 7
    //   219: istore 8
    //   221: iconst_0
    //   222: ifeq -194 -> 28
    //   225: new 304	java/lang/NullPointerException
    //   228: dup
    //   229: invokespecial 305	java/lang/NullPointerException:<init>	()V
    //   232: athrow
    //   233: astore_0
    //   234: iconst_0
    //   235: ireturn
    //   236: aload 11
    //   238: invokevirtual 63	java/io/File:exists	()Z
    //   241: ifne +37 -> 278
    //   244: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   247: ifeq +12 -> 259
    //   250: ldc 21
    //   252: iconst_2
    //   253: ldc_w 316
    //   256: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   259: iload 7
    //   261: istore 8
    //   263: iconst_0
    //   264: ifeq -236 -> 28
    //   267: new 304	java/lang/NullPointerException
    //   270: dup
    //   271: invokespecial 305	java/lang/NullPointerException:<init>	()V
    //   274: athrow
    //   275: astore_0
    //   276: iconst_0
    //   277: ireturn
    //   278: aload 12
    //   280: arraylength
    //   281: iconst_1
    //   282: isub
    //   283: istore 4
    //   285: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   288: ifeq +30 -> 318
    //   291: ldc 21
    //   293: iconst_2
    //   294: new 29	java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   301: ldc_w 318
    //   304: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: iload 4
    //   309: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   312: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   318: new 320	java/io/BufferedReader
    //   321: dup
    //   322: new 322	java/io/InputStreamReader
    //   325: dup
    //   326: new 324	java/io/FileInputStream
    //   329: dup
    //   330: aload_0
    //   331: invokespecial 325	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   334: invokespecial 328	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   337: invokespecial 331	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   340: astore 11
    //   342: iconst_0
    //   343: istore_2
    //   344: aload 11
    //   346: astore_0
    //   347: aload 11
    //   349: invokevirtual 334	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   352: astore 12
    //   354: aload 12
    //   356: ifnull +600 -> 956
    //   359: aload 11
    //   361: astore_0
    //   362: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   365: ifeq +33 -> 398
    //   368: aload 11
    //   370: astore_0
    //   371: ldc 21
    //   373: iconst_2
    //   374: new 29	java/lang/StringBuilder
    //   377: dup
    //   378: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   381: ldc_w 336
    //   384: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: aload 12
    //   389: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   398: aload 11
    //   400: astore_0
    //   401: aload 12
    //   403: invokevirtual 339	java/lang/String:length	()I
    //   406: istore_3
    //   407: iload_3
    //   408: iconst_5
    //   409: if_icmpge +62 -> 471
    //   412: iconst_1
    //   413: istore 7
    //   415: iload_2
    //   416: iload 4
    //   418: if_icmpeq +531 -> 949
    //   421: iload 10
    //   423: istore 9
    //   425: aload 11
    //   427: astore_0
    //   428: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   431: ifeq +19 -> 450
    //   434: aload 11
    //   436: astore_0
    //   437: ldc 21
    //   439: iconst_2
    //   440: ldc_w 341
    //   443: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   446: iload 10
    //   448: istore 9
    //   450: iload 9
    //   452: istore 8
    //   454: aload 11
    //   456: ifnull -428 -> 28
    //   459: aload 11
    //   461: invokevirtual 344	java/io/BufferedReader:close	()V
    //   464: iload 9
    //   466: ireturn
    //   467: astore_0
    //   468: iload 9
    //   470: ireturn
    //   471: aload 11
    //   473: astore_0
    //   474: aload 12
    //   476: ldc_w 346
    //   479: invokevirtual 350	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   482: astore 12
    //   484: aload 11
    //   486: astore_0
    //   487: aload 12
    //   489: arraylength
    //   490: iconst_2
    //   491: if_icmpeq +9 -> 500
    //   494: iconst_0
    //   495: istore 7
    //   497: goto -82 -> 415
    //   500: aload 11
    //   502: astore_0
    //   503: new 29	java/lang/StringBuilder
    //   506: dup
    //   507: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   510: aload_1
    //   511: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: ldc 213
    //   516: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: aload 12
    //   521: iconst_0
    //   522: aaload
    //   523: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   529: astore 13
    //   531: aload 11
    //   533: astore_0
    //   534: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   537: ifeq +33 -> 570
    //   540: aload 11
    //   542: astore_0
    //   543: ldc 21
    //   545: iconst_2
    //   546: new 29	java/lang/StringBuilder
    //   549: dup
    //   550: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   553: ldc_w 352
    //   556: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: aload 13
    //   561: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   567: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   570: aload 11
    //   572: astore_0
    //   573: new 44	java/io/File
    //   576: dup
    //   577: aload 13
    //   579: invokespecial 60	java/io/File:<init>	(Ljava/lang/String;)V
    //   582: astore 13
    //   584: aload 11
    //   586: astore_0
    //   587: aload 13
    //   589: invokevirtual 63	java/io/File:exists	()Z
    //   592: ifne +27 -> 619
    //   595: aload 11
    //   597: astore_0
    //   598: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   601: ifeq +361 -> 962
    //   604: aload 11
    //   606: astore_0
    //   607: ldc 21
    //   609: iconst_2
    //   610: ldc_w 354
    //   613: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   616: goto +346 -> 962
    //   619: aload 11
    //   621: astore_0
    //   622: aload 13
    //   624: invokestatic 285	oicq/wlogin_sdk/tools/MD5:getFileMD5	(Ljava/io/File;)Ljava/lang/String;
    //   627: astore 13
    //   629: aload 13
    //   631: ifnull +91 -> 722
    //   634: aload 11
    //   636: astore_0
    //   637: aload 13
    //   639: invokevirtual 339	java/lang/String:length	()I
    //   642: aload 12
    //   644: iconst_1
    //   645: aaload
    //   646: invokevirtual 339	java/lang/String:length	()I
    //   649: if_icmpeq +73 -> 722
    //   652: aload 11
    //   654: astore_0
    //   655: aload 13
    //   657: invokevirtual 339	java/lang/String:length	()I
    //   660: istore 6
    //   662: aload 11
    //   664: astore_0
    //   665: aload 12
    //   667: iconst_1
    //   668: aaload
    //   669: invokevirtual 339	java/lang/String:length	()I
    //   672: istore 5
    //   674: iconst_0
    //   675: istore_3
    //   676: iload_3
    //   677: iload 6
    //   679: iload 5
    //   681: isub
    //   682: if_icmpge +40 -> 722
    //   685: aload 11
    //   687: astore_0
    //   688: aload 12
    //   690: iconst_1
    //   691: new 29	java/lang/StringBuilder
    //   694: dup
    //   695: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   698: ldc_w 356
    //   701: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: aload 12
    //   706: iconst_1
    //   707: aaload
    //   708: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   714: aastore
    //   715: iload_3
    //   716: iconst_1
    //   717: iadd
    //   718: istore_3
    //   719: goto -43 -> 676
    //   722: aload 13
    //   724: ifnull +18 -> 742
    //   727: aload 11
    //   729: astore_0
    //   730: aload 13
    //   732: aload 12
    //   734: iconst_1
    //   735: aaload
    //   736: invokevirtual 289	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   739: ifne +64 -> 803
    //   742: aload 11
    //   744: astore_0
    //   745: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   748: ifeq +220 -> 968
    //   751: aload 11
    //   753: astore_0
    //   754: ldc 21
    //   756: iconst_2
    //   757: new 29	java/lang/StringBuilder
    //   760: dup
    //   761: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   764: ldc_w 358
    //   767: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   770: aload 13
    //   772: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   775: ldc_w 360
    //   778: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   781: aload 12
    //   783: iconst_1
    //   784: aaload
    //   785: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   788: ldc_w 362
    //   791: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   794: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   797: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   800: goto +168 -> 968
    //   803: iload_2
    //   804: iconst_1
    //   805: iadd
    //   806: istore_2
    //   807: aload 11
    //   809: astore_0
    //   810: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   813: ifeq +32 -> 845
    //   816: aload 11
    //   818: astore_0
    //   819: ldc 21
    //   821: iconst_2
    //   822: new 29	java/lang/StringBuilder
    //   825: dup
    //   826: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   829: ldc_w 364
    //   832: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   835: iload_2
    //   836: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   839: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   842: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   845: goto -501 -> 344
    //   848: astore_1
    //   849: aconst_null
    //   850: astore 11
    //   852: iconst_1
    //   853: istore 7
    //   855: aload 11
    //   857: astore_0
    //   858: invokestatic 19	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   861: ifeq +35 -> 896
    //   864: aload 11
    //   866: astore_0
    //   867: ldc 21
    //   869: iconst_2
    //   870: new 29	java/lang/StringBuilder
    //   873: dup
    //   874: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   877: ldc_w 366
    //   880: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   883: aload_1
    //   884: invokevirtual 276	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   887: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   890: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   893: invokestatic 279	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   896: iload 7
    //   898: istore 8
    //   900: aload 11
    //   902: ifnull -874 -> 28
    //   905: aload 11
    //   907: invokevirtual 344	java/io/BufferedReader:close	()V
    //   910: iload 7
    //   912: ireturn
    //   913: astore_0
    //   914: iload 7
    //   916: ireturn
    //   917: astore_1
    //   918: aconst_null
    //   919: astore_0
    //   920: aload_0
    //   921: ifnull +7 -> 928
    //   924: aload_0
    //   925: invokevirtual 344	java/io/BufferedReader:close	()V
    //   928: aload_1
    //   929: athrow
    //   930: astore_0
    //   931: goto -3 -> 928
    //   934: astore_1
    //   935: goto -15 -> 920
    //   938: astore_1
    //   939: iconst_1
    //   940: istore 7
    //   942: goto -87 -> 855
    //   945: astore_1
    //   946: goto -91 -> 855
    //   949: iload 7
    //   951: istore 9
    //   953: goto -503 -> 450
    //   956: iconst_1
    //   957: istore 7
    //   959: goto -544 -> 415
    //   962: iconst_0
    //   963: istore 7
    //   965: goto -550 -> 415
    //   968: iconst_0
    //   969: istore 7
    //   971: goto -556 -> 415
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	974	0	paramString1	String
    //   0	974	1	paramString2	String
    //   119	717	2	i	int
    //   117	602	3	j	int
    //   283	136	4	k	int
    //   672	10	5	m	int
    //   660	22	6	n	int
    //   4	966	7	bool1	boolean
    //   8	891	8	bool2	boolean
    //   423	529	9	bool3	boolean
    //   1	446	10	bool4	boolean
    //   39	867	11	localObject1	Object
    //   49	733	12	localObject2	Object
    //   129	642	13	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   90	98	98	java/lang/Exception
    //   225	233	233	java/lang/Exception
    //   267	275	275	java/lang/Exception
    //   459	464	467	java/lang/Exception
    //   31	67	848	java/lang/Exception
    //   67	82	848	java/lang/Exception
    //   101	118	848	java/lang/Exception
    //   131	161	848	java/lang/Exception
    //   168	196	848	java/lang/Exception
    //   196	217	848	java/lang/Exception
    //   236	259	848	java/lang/Exception
    //   278	318	848	java/lang/Exception
    //   318	342	848	java/lang/Exception
    //   905	910	913	java/lang/Exception
    //   31	67	917	finally
    //   67	82	917	finally
    //   101	118	917	finally
    //   131	161	917	finally
    //   168	196	917	finally
    //   196	217	917	finally
    //   236	259	917	finally
    //   278	318	917	finally
    //   318	342	917	finally
    //   924	928	930	java/lang/Exception
    //   347	354	934	finally
    //   362	368	934	finally
    //   371	398	934	finally
    //   401	407	934	finally
    //   428	434	934	finally
    //   437	446	934	finally
    //   474	484	934	finally
    //   487	494	934	finally
    //   503	531	934	finally
    //   534	540	934	finally
    //   543	570	934	finally
    //   573	584	934	finally
    //   587	595	934	finally
    //   598	604	934	finally
    //   607	616	934	finally
    //   622	629	934	finally
    //   637	652	934	finally
    //   655	662	934	finally
    //   665	674	934	finally
    //   688	715	934	finally
    //   730	742	934	finally
    //   745	751	934	finally
    //   754	800	934	finally
    //   810	816	934	finally
    //   819	845	934	finally
    //   858	864	934	finally
    //   867	896	934	finally
    //   347	354	938	java/lang/Exception
    //   362	368	938	java/lang/Exception
    //   371	398	938	java/lang/Exception
    //   401	407	938	java/lang/Exception
    //   474	484	938	java/lang/Exception
    //   487	494	938	java/lang/Exception
    //   503	531	938	java/lang/Exception
    //   534	540	938	java/lang/Exception
    //   543	570	938	java/lang/Exception
    //   573	584	938	java/lang/Exception
    //   587	595	938	java/lang/Exception
    //   598	604	938	java/lang/Exception
    //   607	616	938	java/lang/Exception
    //   622	629	938	java/lang/Exception
    //   637	652	938	java/lang/Exception
    //   655	662	938	java/lang/Exception
    //   665	674	938	java/lang/Exception
    //   688	715	938	java/lang/Exception
    //   730	742	938	java/lang/Exception
    //   745	751	938	java/lang/Exception
    //   754	800	938	java/lang/Exception
    //   810	816	938	java/lang/Exception
    //   819	845	938	java/lang/Exception
    //   428	434	945	java/lang/Exception
    //   437	446	945	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.DynamicSplashManager
 * JD-Core Version:    0.7.0.1
 */