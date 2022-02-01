import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
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

public class antt
{
  public static boolean a(int paramInt)
  {
    boolean bool = false;
    int i = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    if (i == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() userNetworkType == NetType.G2");
      }
      i = 0;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() userNetworkValue == " + i);
      }
      if (i < paramInt)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() user network NOT allow download, return");
        }
        bool = true;
      }
      return bool;
      if (i == 3)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() userNetworkType == NetType.G3");
        }
        i = 10;
      }
      else if (i == 4)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() userNetworkType == NetType.G4");
        }
        i = 20;
      }
      else if (i == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() userNetworkType == NetType.WIFI");
        }
        i = 100;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() begin");
    }
    for (;;)
    {
      int i;
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
            break label720;
          }
          ((File)localObject2).delete();
          break label720;
        }
        Object localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        paramString = ((Document)localObject3).getElementsByTagName("img").item(0).getFirstChild().getNodeValue();
        String str3 = ((Document)localObject3).getElementsByTagName("begin").item(0).getFirstChild().getNodeValue();
        String str2 = ((Document)localObject3).getElementsByTagName("end").item(0).getFirstChild().getNodeValue();
        localObject1 = ((Document)localObject3).getElementsByTagName("md5").item(0).getFirstChild().getNodeValue();
        i = Integer.valueOf(((Document)localObject3).getElementsByTagName("download_net").item(0).getFirstChild().getNodeValue()).intValue();
        int j = Integer.valueOf(((Document)localObject3).getElementsByTagName("play_times").item(0).getFirstChild().getNodeValue()).intValue();
        int k = Integer.valueOf(((Document)localObject3).getElementsByTagName("play_interval").item(0).getFirstChild().getNodeValue()).intValue();
        int m = Integer.valueOf(((Document)localObject3).getElementsByTagName("total_show_times").item(0).getFirstChild().getNodeValue()).intValue();
        Object localObject3 = ((SimpleDateFormat)localObject2).parse(str3).getTime() + "|" + ((SimpleDateFormat)localObject2).parse(str2).getTime();
        if (a(i)) {
          return false;
        }
        bhhr.a(BaseApplicationImpl.getContext(), paramInt, j, k, m, (String)localObject1, (String)localObject3, paramString);
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
            break label729;
          }
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() downloadZipFile is filed, return");
          break label729;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() downloadZipFile is SUCCESS");
        }
        if (a(str1, (String)localObject1, (File)localObject2)) {
          return false;
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
      label720:
      i += 1;
    }
    return true;
    label729:
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
      boolean bool = HttpDownloadUtil.download(paramQQAppInterface, paramString1, paramFile);
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
    //   1: istore 9
    //   3: iconst_0
    //   4: istore 7
    //   6: iload 7
    //   8: istore 8
    //   10: aload_0
    //   11: invokestatic 263	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifne +14 -> 28
    //   17: aload_1
    //   18: invokestatic 263	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifeq +10 -> 31
    //   24: iload 7
    //   26: istore 8
    //   28: iload 8
    //   30: ireturn
    //   31: new 74	java/io/File
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 82	java/io/File:<init>	(Ljava/lang/String;)V
    //   39: invokevirtual 85	java/io/File:exists	()Z
    //   42: ifne +31 -> 73
    //   45: ldc 26
    //   47: iconst_1
    //   48: ldc_w 265
    //   51: invokestatic 32	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   54: iload 7
    //   56: istore 8
    //   58: iconst_0
    //   59: ifeq -31 -> 28
    //   62: new 267	java/lang/NullPointerException
    //   65: dup
    //   66: invokespecial 268	java/lang/NullPointerException:<init>	()V
    //   69: athrow
    //   70: astore_0
    //   71: iconst_0
    //   72: ireturn
    //   73: new 74	java/io/File
    //   76: dup
    //   77: aload_1
    //   78: invokespecial 82	java/io/File:<init>	(Ljava/lang/String;)V
    //   81: astore 10
    //   83: aload 10
    //   85: invokevirtual 85	java/io/File:exists	()Z
    //   88: ifeq +11 -> 99
    //   91: aload 10
    //   93: invokevirtual 134	java/io/File:isDirectory	()Z
    //   96: ifne +31 -> 127
    //   99: ldc 26
    //   101: iconst_1
    //   102: ldc_w 270
    //   105: invokestatic 32	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   108: iload 7
    //   110: istore 8
    //   112: iconst_0
    //   113: ifeq -85 -> 28
    //   116: new 267	java/lang/NullPointerException
    //   119: dup
    //   120: invokespecial 268	java/lang/NullPointerException:<init>	()V
    //   123: athrow
    //   124: astore_0
    //   125: iconst_0
    //   126: ireturn
    //   127: aload 10
    //   129: invokevirtual 138	java/io/File:listFiles	()[Ljava/io/File;
    //   132: astore 11
    //   134: aload 11
    //   136: arraylength
    //   137: istore_3
    //   138: iconst_0
    //   139: istore_2
    //   140: iload_2
    //   141: iload_3
    //   142: if_icmpge +46 -> 188
    //   145: aload 11
    //   147: iload_2
    //   148: aaload
    //   149: astore 10
    //   151: ldc 26
    //   153: iconst_1
    //   154: new 34	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   161: ldc_w 272
    //   164: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload 10
    //   169: invokevirtual 275	java/io/File:getName	()Ljava/lang/String;
    //   172: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 32	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   181: iload_2
    //   182: iconst_1
    //   183: iadd
    //   184: istore_2
    //   185: goto -45 -> 140
    //   188: ldc 26
    //   190: iconst_1
    //   191: new 34	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   198: ldc_w 277
    //   201: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload 11
    //   206: arraylength
    //   207: invokevirtual 47	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   210: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokestatic 32	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   216: aload 11
    //   218: arraylength
    //   219: ifgt +31 -> 250
    //   222: ldc 26
    //   224: iconst_1
    //   225: ldc_w 279
    //   228: invokestatic 32	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   231: iload 7
    //   233: istore 8
    //   235: iconst_0
    //   236: ifeq -208 -> 28
    //   239: new 267	java/lang/NullPointerException
    //   242: dup
    //   243: invokespecial 268	java/lang/NullPointerException:<init>	()V
    //   246: athrow
    //   247: astore_0
    //   248: iconst_0
    //   249: ireturn
    //   250: aload 11
    //   252: arraylength
    //   253: iconst_1
    //   254: isub
    //   255: istore 4
    //   257: ldc 26
    //   259: iconst_1
    //   260: new 34	java/lang/StringBuilder
    //   263: dup
    //   264: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   267: ldc_w 281
    //   270: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: iload 4
    //   275: invokevirtual 47	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   278: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokestatic 32	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   284: new 283	java/io/BufferedReader
    //   287: dup
    //   288: new 285	java/io/InputStreamReader
    //   291: dup
    //   292: new 287	java/io/FileInputStream
    //   295: dup
    //   296: aload_0
    //   297: invokespecial 288	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   300: invokespecial 291	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   303: invokespecial 294	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   306: astore 11
    //   308: iconst_0
    //   309: istore_2
    //   310: aload 11
    //   312: astore_0
    //   313: aload 11
    //   315: invokevirtual 297	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   318: astore 10
    //   320: aload 10
    //   322: ifnull +467 -> 789
    //   325: aload 11
    //   327: astore_0
    //   328: ldc 26
    //   330: iconst_1
    //   331: new 34	java/lang/StringBuilder
    //   334: dup
    //   335: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   338: ldc_w 299
    //   341: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: aload 10
    //   346: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: invokestatic 32	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   355: aload 11
    //   357: astore_0
    //   358: aload 10
    //   360: invokevirtual 302	java/lang/String:length	()I
    //   363: istore_3
    //   364: iload_3
    //   365: iconst_5
    //   366: if_icmpge +49 -> 415
    //   369: iconst_1
    //   370: istore 7
    //   372: iload_2
    //   373: iload 4
    //   375: if_icmpeq +411 -> 786
    //   378: aload 11
    //   380: astore_0
    //   381: ldc 26
    //   383: iconst_1
    //   384: ldc_w 304
    //   387: invokestatic 32	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   390: iload 9
    //   392: istore 7
    //   394: iload 7
    //   396: istore 8
    //   398: aload 11
    //   400: ifnull -372 -> 28
    //   403: aload 11
    //   405: invokevirtual 307	java/io/BufferedReader:close	()V
    //   408: iload 7
    //   410: ireturn
    //   411: astore_0
    //   412: iload 7
    //   414: ireturn
    //   415: aload 11
    //   417: astore_0
    //   418: aload 10
    //   420: ldc_w 309
    //   423: invokevirtual 313	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   426: astore 10
    //   428: aload 11
    //   430: astore_0
    //   431: aload 10
    //   433: arraylength
    //   434: iconst_2
    //   435: if_icmpeq +9 -> 444
    //   438: iconst_0
    //   439: istore 7
    //   441: goto -69 -> 372
    //   444: aload 11
    //   446: astore_0
    //   447: new 34	java/lang/StringBuilder
    //   450: dup
    //   451: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   454: aload_1
    //   455: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: ldc 216
    //   460: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: aload 10
    //   465: iconst_0
    //   466: aaload
    //   467: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   473: astore 12
    //   475: aload 11
    //   477: astore_0
    //   478: ldc 26
    //   480: iconst_1
    //   481: new 34	java/lang/StringBuilder
    //   484: dup
    //   485: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   488: ldc_w 315
    //   491: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: aload 12
    //   496: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   502: invokestatic 32	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   505: aload 11
    //   507: astore_0
    //   508: new 74	java/io/File
    //   511: dup
    //   512: aload 12
    //   514: invokespecial 82	java/io/File:<init>	(Ljava/lang/String;)V
    //   517: astore 12
    //   519: aload 11
    //   521: astore_0
    //   522: aload 12
    //   524: invokevirtual 85	java/io/File:exists	()Z
    //   527: ifne +21 -> 548
    //   530: aload 11
    //   532: astore_0
    //   533: ldc 26
    //   535: iconst_1
    //   536: ldc_w 317
    //   539: invokestatic 32	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   542: iconst_0
    //   543: istore 7
    //   545: goto -173 -> 372
    //   548: aload 11
    //   550: astore_0
    //   551: aload 12
    //   553: invokestatic 246	oicq/wlogin_sdk/tools/MD5:getFileMD5	(Ljava/io/File;)Ljava/lang/String;
    //   556: astore 12
    //   558: aload 12
    //   560: ifnull +91 -> 651
    //   563: aload 11
    //   565: astore_0
    //   566: aload 12
    //   568: invokevirtual 302	java/lang/String:length	()I
    //   571: aload 10
    //   573: iconst_1
    //   574: aaload
    //   575: invokevirtual 302	java/lang/String:length	()I
    //   578: if_icmpeq +73 -> 651
    //   581: aload 11
    //   583: astore_0
    //   584: aload 12
    //   586: invokevirtual 302	java/lang/String:length	()I
    //   589: istore 5
    //   591: aload 11
    //   593: astore_0
    //   594: aload 10
    //   596: iconst_1
    //   597: aaload
    //   598: invokevirtual 302	java/lang/String:length	()I
    //   601: istore 6
    //   603: iconst_0
    //   604: istore_3
    //   605: iload_3
    //   606: iload 5
    //   608: iload 6
    //   610: isub
    //   611: if_icmpge +40 -> 651
    //   614: aload 11
    //   616: astore_0
    //   617: aload 10
    //   619: iconst_1
    //   620: new 34	java/lang/StringBuilder
    //   623: dup
    //   624: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   627: ldc_w 319
    //   630: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   633: aload 10
    //   635: iconst_1
    //   636: aaload
    //   637: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   643: aastore
    //   644: iload_3
    //   645: iconst_1
    //   646: iadd
    //   647: istore_3
    //   648: goto -43 -> 605
    //   651: aload 12
    //   653: ifnull +22 -> 675
    //   656: aload 11
    //   658: astore_0
    //   659: aload 12
    //   661: aload 10
    //   663: iconst_1
    //   664: aaload
    //   665: invokevirtual 250	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   668: istore 7
    //   670: iload 7
    //   672: ifne +9 -> 681
    //   675: iconst_0
    //   676: istore 7
    //   678: goto -306 -> 372
    //   681: iload_2
    //   682: iconst_1
    //   683: iadd
    //   684: istore_2
    //   685: goto -375 -> 310
    //   688: astore 10
    //   690: aconst_null
    //   691: astore_1
    //   692: iconst_1
    //   693: istore 7
    //   695: aload_1
    //   696: astore_0
    //   697: ldc 26
    //   699: iconst_1
    //   700: new 34	java/lang/StringBuilder
    //   703: dup
    //   704: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   707: ldc_w 321
    //   710: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: aload 10
    //   715: invokevirtual 237	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   718: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   724: invokestatic 240	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   727: iload 7
    //   729: istore 8
    //   731: aload_1
    //   732: ifnull -704 -> 28
    //   735: aload_1
    //   736: invokevirtual 307	java/io/BufferedReader:close	()V
    //   739: iload 7
    //   741: ireturn
    //   742: astore_0
    //   743: iload 7
    //   745: ireturn
    //   746: astore_1
    //   747: aconst_null
    //   748: astore_0
    //   749: aload_0
    //   750: ifnull +7 -> 757
    //   753: aload_0
    //   754: invokevirtual 307	java/io/BufferedReader:close	()V
    //   757: aload_1
    //   758: athrow
    //   759: astore_0
    //   760: goto -3 -> 757
    //   763: astore_1
    //   764: goto -15 -> 749
    //   767: astore 10
    //   769: iconst_1
    //   770: istore 7
    //   772: aload 11
    //   774: astore_1
    //   775: goto -80 -> 695
    //   778: astore 10
    //   780: aload 11
    //   782: astore_1
    //   783: goto -88 -> 695
    //   786: goto -392 -> 394
    //   789: iconst_1
    //   790: istore 7
    //   792: goto -420 -> 372
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	795	0	paramString1	String
    //   0	795	1	paramString2	String
    //   139	546	2	i	int
    //   137	511	3	j	int
    //   255	121	4	k	int
    //   589	22	5	m	int
    //   601	10	6	n	int
    //   4	787	7	bool1	boolean
    //   8	722	8	bool2	boolean
    //   1	390	9	bool3	boolean
    //   81	581	10	localObject1	Object
    //   688	26	10	localException1	Exception
    //   767	1	10	localException2	Exception
    //   778	1	10	localException3	Exception
    //   132	649	11	localObject2	Object
    //   473	187	12	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   62	70	70	java/lang/Exception
    //   116	124	124	java/lang/Exception
    //   239	247	247	java/lang/Exception
    //   403	408	411	java/lang/Exception
    //   31	54	688	java/lang/Exception
    //   73	99	688	java/lang/Exception
    //   99	108	688	java/lang/Exception
    //   127	138	688	java/lang/Exception
    //   151	181	688	java/lang/Exception
    //   188	231	688	java/lang/Exception
    //   250	308	688	java/lang/Exception
    //   735	739	742	java/lang/Exception
    //   31	54	746	finally
    //   73	99	746	finally
    //   99	108	746	finally
    //   127	138	746	finally
    //   151	181	746	finally
    //   188	231	746	finally
    //   250	308	746	finally
    //   753	757	759	java/lang/Exception
    //   313	320	763	finally
    //   328	355	763	finally
    //   358	364	763	finally
    //   381	390	763	finally
    //   418	428	763	finally
    //   431	438	763	finally
    //   447	475	763	finally
    //   478	505	763	finally
    //   508	519	763	finally
    //   522	530	763	finally
    //   533	542	763	finally
    //   551	558	763	finally
    //   566	581	763	finally
    //   584	591	763	finally
    //   594	603	763	finally
    //   617	644	763	finally
    //   659	670	763	finally
    //   697	727	763	finally
    //   313	320	767	java/lang/Exception
    //   328	355	767	java/lang/Exception
    //   358	364	767	java/lang/Exception
    //   418	428	767	java/lang/Exception
    //   431	438	767	java/lang/Exception
    //   447	475	767	java/lang/Exception
    //   478	505	767	java/lang/Exception
    //   508	519	767	java/lang/Exception
    //   522	530	767	java/lang/Exception
    //   533	542	767	java/lang/Exception
    //   551	558	767	java/lang/Exception
    //   566	581	767	java/lang/Exception
    //   584	591	767	java/lang/Exception
    //   594	603	767	java/lang/Exception
    //   617	644	767	java/lang/Exception
    //   659	670	767	java/lang/Exception
    //   381	390	778	java/lang/Exception
  }
  
  public static boolean a(String paramString1, String paramString2, File paramFile)
  {
    paramString1 = paramString1 + "/" + paramString2;
    paramString2 = new File(paramString1);
    if (!FileUtils.unzip(paramFile, paramString2))
    {
      if ((paramString2 != null) && (paramString2.exists())) {
        paramString2.delete();
      }
      if (QLog.isColorLevel()) {
        QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() unzip is filed, return");
      }
    }
    do
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() unzip is SUCCESS");
      }
      if (a(paramString1 + "/md5.txt", paramString1)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() checkUnzipFileMd5 is filed, return");
    return true;
    if (QLog.isColorLevel()) {
      QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() checkUnzipFileMd5 is SUCCESS");
    }
    if ((paramString2 != null) && (paramString2.isDirectory()))
    {
      long l = paramString2.lastModified();
      paramString1 = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
      paramString1.putLong("dynamic_splash_config_folder_modify_time", l);
      paramString1.commit();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     antt
 * JD-Core Version:    0.7.0.1
 */