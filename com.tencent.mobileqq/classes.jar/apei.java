import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil.1;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil.2;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import mqq.os.MqqHandler;

public class apei
{
  public static int a(String paramString)
  {
    return a(paramString, null);
  }
  
  public static int a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return -1;
    }
    try
    {
      if (!new File(paramString1).exists())
      {
        QLog.e("UniformDownloadUtil", 1, "[UniformDL] openApk. file is not exsited. PH:" + paramString1);
        return -2;
      }
      TMAssistantDownloadManager.getInstance(BaseApplication.getContext()).hookAM4Install();
      paramString1 = FileProvider7Helper.openApkIntent(BaseApplication.getContext(), paramString1);
      paramString1.putExtra("big_brother_source_key", paramString2);
      BaseApplication.getContext().startActivity(paramString1);
      return 0;
    }
    catch (Exception paramString1)
    {
      QLog.e("UniformDownloadUtil", 1, "[UniformDL] openApk. Exception 2");
      paramString1.printStackTrace();
    }
    return -3;
  }
  
  public static Bitmap a(String paramString)
  {
    if (paramString == null)
    {
      QLog.i("UniformDownloadUtil", 1, "[UniformDL] getApkIcon failed.url = null");
      return null;
    }
    try
    {
      Object localObject1 = Class.forName("android.content.pm.PackageParser");
      Object localObject2 = ((Class)localObject1).getConstructor(new Class[] { String.class }).newInstance(new Object[] { paramString });
      Object localObject3 = new DisplayMetrics();
      ((DisplayMetrics)localObject3).setToDefaults();
      localObject1 = ((Class)localObject1).getDeclaredMethod("parsePackage", new Class[] { File.class, String.class, DisplayMetrics.class, Integer.TYPE }).invoke(localObject2, new Object[] { new File(paramString), paramString, localObject3, Integer.valueOf(0) });
      localObject1 = (ApplicationInfo)localObject1.getClass().getDeclaredField("applicationInfo").get(localObject1);
      localObject3 = Class.forName("android.content.res.AssetManager");
      localObject2 = ((Class)localObject3).newInstance();
      ((Class)localObject3).getDeclaredMethod("addAssetPath", new Class[] { String.class }).invoke(localObject2, new Object[] { paramString });
      paramString = BaseApplication.getContext().getResources();
      paramString = (Resources)Resources.class.getConstructor(new Class[] { localObject2.getClass(), paramString.getDisplayMetrics().getClass(), paramString.getConfiguration().getClass() }).newInstance(new Object[] { localObject2, paramString.getDisplayMetrics(), paramString.getConfiguration() });
      if ((localObject1 != null) && (((ApplicationInfo)localObject1).icon != 0))
      {
        localObject2 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
        BitmapFactory.decodeResource(paramString, ((ApplicationInfo)localObject1).icon, (BitmapFactory.Options)localObject2);
        ((BitmapFactory.Options)localObject2).inSampleSize = 1;
        ((BitmapFactory.Options)localObject2).inJustDecodeBounds = false;
        paramString = BitmapFactory.decodeResource(paramString, ((ApplicationInfo)localObject1).icon, (BitmapFactory.Options)localObject2);
        return paramString;
      }
    }
    catch (OutOfMemoryError paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  /* Error */
  public static apek a(String paramString)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_3
    //   2: aconst_null
    //   3: astore 12
    //   5: ldc 206
    //   7: astore 17
    //   9: aload_0
    //   10: ifnull +11 -> 21
    //   13: aload_0
    //   14: invokevirtual 210	java/lang/String:length	()I
    //   17: iconst_1
    //   18: if_icmpge +13 -> 31
    //   21: new 212	apek
    //   24: dup
    //   25: aconst_null
    //   26: lconst_0
    //   27: invokespecial 215	apek:<init>	(Ljava/lang/String;J)V
    //   30: areturn
    //   31: new 217	java/net/URL
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 218	java/net/URL:<init>	(Ljava/lang/String;)V
    //   39: invokevirtual 222	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   42: checkcast 224	java/net/HttpURLConnection
    //   45: astore 18
    //   47: lload_3
    //   48: lstore 5
    //   50: aload 17
    //   52: astore 14
    //   54: lload_3
    //   55: lstore 7
    //   57: aload 17
    //   59: astore 15
    //   61: lload_3
    //   62: lstore 9
    //   64: aload 17
    //   66: astore 16
    //   68: aload 18
    //   70: ldc 226
    //   72: ldc 228
    //   74: invokevirtual 232	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   77: lload_3
    //   78: lstore 5
    //   80: aload 17
    //   82: astore 14
    //   84: lload_3
    //   85: lstore 7
    //   87: aload 17
    //   89: astore 15
    //   91: lload_3
    //   92: lstore 9
    //   94: aload 17
    //   96: astore 16
    //   98: aload 18
    //   100: ldc 234
    //   102: ldc 228
    //   104: invokevirtual 232	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: lload_3
    //   108: lstore 5
    //   110: aload 17
    //   112: astore 14
    //   114: lload_3
    //   115: lstore 7
    //   117: aload 17
    //   119: astore 15
    //   121: lload_3
    //   122: lstore 9
    //   124: aload 17
    //   126: astore 16
    //   128: aload 18
    //   130: ldc 226
    //   132: ldc 228
    //   134: invokevirtual 232	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: lload_3
    //   138: lstore 5
    //   140: aload 17
    //   142: astore 14
    //   144: lload_3
    //   145: lstore 7
    //   147: aload 17
    //   149: astore 15
    //   151: lload_3
    //   152: lstore 9
    //   154: aload 17
    //   156: astore 16
    //   158: aload 18
    //   160: ldc 234
    //   162: ldc 228
    //   164: invokevirtual 232	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   167: lload_3
    //   168: lstore 5
    //   170: aload 17
    //   172: astore 14
    //   174: lload_3
    //   175: lstore 7
    //   177: aload 17
    //   179: astore 15
    //   181: lload_3
    //   182: lstore 9
    //   184: aload 17
    //   186: astore 16
    //   188: aload 18
    //   190: invokevirtual 237	java/net/HttpURLConnection:connect	()V
    //   193: lload_3
    //   194: lstore 5
    //   196: aload 17
    //   198: astore 14
    //   200: lload_3
    //   201: lstore 7
    //   203: aload 17
    //   205: astore 15
    //   207: lload_3
    //   208: lstore 9
    //   210: aload 17
    //   212: astore 16
    //   214: aload 18
    //   216: invokevirtual 240	java/net/HttpURLConnection:getResponseCode	()I
    //   219: pop
    //   220: lload_3
    //   221: lstore 5
    //   223: aload 17
    //   225: astore 14
    //   227: lload_3
    //   228: lstore 7
    //   230: aload 17
    //   232: astore 15
    //   234: lload_3
    //   235: lstore 9
    //   237: aload 17
    //   239: astore 16
    //   241: aload 18
    //   243: invokevirtual 244	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   246: astore 19
    //   248: lload_3
    //   249: lstore 5
    //   251: aload 17
    //   253: astore 14
    //   255: lload_3
    //   256: lstore 7
    //   258: aload 17
    //   260: astore 15
    //   262: lload_3
    //   263: lstore 9
    //   265: aload 17
    //   267: astore 16
    //   269: ldc 246
    //   271: iconst_1
    //   272: new 26	java/lang/StringBuilder
    //   275: dup
    //   276: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   279: ldc 248
    //   281: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: aload 19
    //   286: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   289: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokestatic 45	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   295: lload_3
    //   296: lstore 5
    //   298: aload 17
    //   300: astore 14
    //   302: lload_3
    //   303: lstore 7
    //   305: aload 17
    //   307: astore 15
    //   309: lload_3
    //   310: lstore 9
    //   312: aload 17
    //   314: astore 16
    //   316: aload 18
    //   318: invokevirtual 254	java/net/HttpURLConnection:getContentLength	()I
    //   321: i2l
    //   322: lstore_3
    //   323: lload_3
    //   324: lstore 5
    //   326: aload 17
    //   328: astore 14
    //   330: lload_3
    //   331: lstore 7
    //   333: aload 17
    //   335: astore 15
    //   337: lload_3
    //   338: lstore 9
    //   340: aload 17
    //   342: astore 16
    //   344: new 101	java/lang/String
    //   347: dup
    //   348: aload 18
    //   350: ldc_w 256
    //   353: invokevirtual 260	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   356: ldc_w 262
    //   359: invokevirtual 266	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   362: ldc 228
    //   364: invokespecial 269	java/lang/String:<init>	([BLjava/lang/String;)V
    //   367: ldc 228
    //   369: invokestatic 275	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   372: astore 13
    //   374: aload 17
    //   376: astore 12
    //   378: aload 13
    //   380: ifnull +452 -> 832
    //   383: lload_3
    //   384: lstore 5
    //   386: aload 17
    //   388: astore 14
    //   390: lload_3
    //   391: lstore 7
    //   393: aload 17
    //   395: astore 15
    //   397: lload_3
    //   398: lstore 9
    //   400: aload 17
    //   402: astore 16
    //   404: new 101	java/lang/String
    //   407: dup
    //   408: aload 13
    //   410: ldc_w 262
    //   413: invokevirtual 266	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   416: ldc 228
    //   418: invokespecial 269	java/lang/String:<init>	([BLjava/lang/String;)V
    //   421: ldc 228
    //   423: invokestatic 275	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   426: astore 20
    //   428: aload 17
    //   430: astore 12
    //   432: aload 20
    //   434: ifnull +398 -> 832
    //   437: lload_3
    //   438: lstore 5
    //   440: aload 17
    //   442: astore 14
    //   444: lload_3
    //   445: lstore 7
    //   447: aload 17
    //   449: astore 15
    //   451: lload_3
    //   452: lstore 9
    //   454: aload 17
    //   456: astore 16
    //   458: aload 20
    //   460: ldc_w 277
    //   463: invokevirtual 280	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   466: istore_2
    //   467: iload_2
    //   468: istore_1
    //   469: iconst_m1
    //   470: iload_2
    //   471: if_icmpne +33 -> 504
    //   474: lload_3
    //   475: lstore 5
    //   477: aload 17
    //   479: astore 14
    //   481: lload_3
    //   482: lstore 7
    //   484: aload 17
    //   486: astore 15
    //   488: lload_3
    //   489: lstore 9
    //   491: aload 17
    //   493: astore 16
    //   495: aload 20
    //   497: ldc_w 282
    //   500: invokevirtual 280	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   503: istore_1
    //   504: aload 17
    //   506: astore 13
    //   508: iconst_m1
    //   509: iload_1
    //   510: if_icmpeq +120 -> 630
    //   513: lload_3
    //   514: lstore 5
    //   516: aload 17
    //   518: astore 14
    //   520: lload_3
    //   521: lstore 7
    //   523: aload 17
    //   525: astore 15
    //   527: lload_3
    //   528: lstore 9
    //   530: aload 17
    //   532: astore 16
    //   534: aload 20
    //   536: iload_1
    //   537: ldc_w 277
    //   540: invokevirtual 210	java/lang/String:length	()I
    //   543: iadd
    //   544: aload 20
    //   546: invokevirtual 210	java/lang/String:length	()I
    //   549: invokevirtual 286	java/lang/String:substring	(II)Ljava/lang/String;
    //   552: astore 12
    //   554: aload 17
    //   556: astore 13
    //   558: aload 12
    //   560: ifnull +70 -> 630
    //   563: lload_3
    //   564: lstore 5
    //   566: aload 17
    //   568: astore 14
    //   570: lload_3
    //   571: lstore 7
    //   573: aload 17
    //   575: astore 15
    //   577: lload_3
    //   578: lstore 9
    //   580: aload 17
    //   582: astore 16
    //   584: aload 12
    //   586: ldc_w 288
    //   589: invokevirtual 280	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   592: istore_1
    //   593: iconst_m1
    //   594: iload_1
    //   595: if_icmpeq +492 -> 1087
    //   598: lload_3
    //   599: lstore 5
    //   601: aload 17
    //   603: astore 14
    //   605: lload_3
    //   606: lstore 7
    //   608: aload 17
    //   610: astore 15
    //   612: lload_3
    //   613: lstore 9
    //   615: aload 17
    //   617: astore 16
    //   619: aload 12
    //   621: iconst_0
    //   622: iload_1
    //   623: iconst_1
    //   624: isub
    //   625: invokevirtual 286	java/lang/String:substring	(II)Ljava/lang/String;
    //   628: astore 13
    //   630: aload 13
    //   632: astore 12
    //   634: lload_3
    //   635: lstore 5
    //   637: aload 13
    //   639: astore 14
    //   641: lload_3
    //   642: lstore 7
    //   644: aload 13
    //   646: astore 15
    //   648: lload_3
    //   649: lstore 9
    //   651: aload 13
    //   653: astore 16
    //   655: aload 13
    //   657: invokestatic 294	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   660: ifne +172 -> 832
    //   663: lload_3
    //   664: lstore 5
    //   666: aload 13
    //   668: astore 14
    //   670: lload_3
    //   671: lstore 7
    //   673: aload 13
    //   675: astore 15
    //   677: lload_3
    //   678: lstore 9
    //   680: aload 13
    //   682: astore 16
    //   684: aload 13
    //   686: ldc_w 296
    //   689: invokevirtual 280	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   692: istore_1
    //   693: lload_3
    //   694: lstore 5
    //   696: aload 13
    //   698: astore 14
    //   700: lload_3
    //   701: lstore 7
    //   703: aload 13
    //   705: astore 15
    //   707: lload_3
    //   708: lstore 9
    //   710: aload 13
    //   712: astore 16
    //   714: aload 13
    //   716: ldc_w 296
    //   719: invokevirtual 299	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   722: istore_2
    //   723: aload 13
    //   725: astore 12
    //   727: iload_1
    //   728: ifne +104 -> 832
    //   731: aload 13
    //   733: astore 12
    //   735: lload_3
    //   736: lstore 5
    //   738: aload 13
    //   740: astore 14
    //   742: lload_3
    //   743: lstore 7
    //   745: aload 13
    //   747: astore 15
    //   749: lload_3
    //   750: lstore 9
    //   752: aload 13
    //   754: astore 16
    //   756: iload_2
    //   757: iconst_1
    //   758: iadd
    //   759: aload 13
    //   761: invokevirtual 210	java/lang/String:length	()I
    //   764: if_icmpne +68 -> 832
    //   767: lload_3
    //   768: lstore 5
    //   770: aload 13
    //   772: astore 14
    //   774: lload_3
    //   775: lstore 7
    //   777: aload 13
    //   779: astore 15
    //   781: lload_3
    //   782: lstore 9
    //   784: aload 13
    //   786: astore 16
    //   788: aload 13
    //   790: iconst_1
    //   791: invokevirtual 302	java/lang/String:substring	(I)Ljava/lang/String;
    //   794: astore 12
    //   796: lload_3
    //   797: lstore 5
    //   799: aload 12
    //   801: astore 14
    //   803: lload_3
    //   804: lstore 7
    //   806: aload 12
    //   808: astore 15
    //   810: lload_3
    //   811: lstore 9
    //   813: aload 12
    //   815: astore 16
    //   817: aload 12
    //   819: iconst_0
    //   820: aload 12
    //   822: invokevirtual 210	java/lang/String:length	()I
    //   825: iconst_1
    //   826: isub
    //   827: invokevirtual 286	java/lang/String:substring	(II)Ljava/lang/String;
    //   830: astore 12
    //   832: aload 12
    //   834: astore 13
    //   836: lload_3
    //   837: lstore 5
    //   839: aload 12
    //   841: astore 14
    //   843: lload_3
    //   844: lstore 7
    //   846: aload 12
    //   848: astore 15
    //   850: lload_3
    //   851: lstore 9
    //   853: aload 12
    //   855: astore 16
    //   857: aload 12
    //   859: invokestatic 294	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   862: ifeq +40 -> 902
    //   865: aload 12
    //   867: astore 13
    //   869: aload 19
    //   871: ifnull +31 -> 902
    //   874: lload_3
    //   875: lstore 5
    //   877: aload 12
    //   879: astore 14
    //   881: lload_3
    //   882: lstore 7
    //   884: aload 12
    //   886: astore 15
    //   888: lload_3
    //   889: lstore 9
    //   891: aload 12
    //   893: astore 16
    //   895: aload 19
    //   897: invokevirtual 305	java/net/URL:getFile	()Ljava/lang/String;
    //   900: astore 13
    //   902: aload 13
    //   904: ifnull +430 -> 1334
    //   907: lload_3
    //   908: lstore 5
    //   910: aload 13
    //   912: astore 14
    //   914: lload_3
    //   915: lstore 7
    //   917: aload 13
    //   919: astore 15
    //   921: lload_3
    //   922: lstore 9
    //   924: aload 13
    //   926: astore 16
    //   928: aload 13
    //   930: ldc_w 307
    //   933: invokevirtual 310	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   936: ifne +39 -> 975
    //   939: lload_3
    //   940: lstore 5
    //   942: aload 13
    //   944: astore 14
    //   946: lload_3
    //   947: lstore 7
    //   949: aload 13
    //   951: astore 15
    //   953: lload_3
    //   954: lstore 9
    //   956: aload 13
    //   958: astore 16
    //   960: aload 13
    //   962: ldc_w 312
    //   965: invokevirtual 310	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   968: istore 11
    //   970: iload 11
    //   972: ifeq +362 -> 1334
    //   975: aconst_null
    //   976: astore 12
    //   978: aload 18
    //   980: ifnull +351 -> 1331
    //   983: aload 18
    //   985: invokevirtual 315	java/net/HttpURLConnection:disconnect	()V
    //   988: ldc 206
    //   990: astore 14
    //   992: aload 14
    //   994: astore 13
    //   996: aload_0
    //   997: invokestatic 321	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   1000: astore 15
    //   1002: aload 14
    //   1004: astore_0
    //   1005: aload 15
    //   1007: ifnull +61 -> 1068
    //   1010: aload 14
    //   1012: astore 13
    //   1014: aload 15
    //   1016: invokevirtual 324	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   1019: astore 14
    //   1021: aload 14
    //   1023: astore_0
    //   1024: aload 14
    //   1026: ifnull +42 -> 1068
    //   1029: aload 14
    //   1031: astore 13
    //   1033: aload 14
    //   1035: ldc_w 307
    //   1038: invokevirtual 310	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1041: ifne +25 -> 1066
    //   1044: aload 14
    //   1046: astore 13
    //   1048: aload 14
    //   1050: ldc_w 312
    //   1053: invokevirtual 310	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1056: istore 11
    //   1058: aload 14
    //   1060: astore_0
    //   1061: iload 11
    //   1063: ifeq +5 -> 1068
    //   1066: aconst_null
    //   1067: astore_0
    //   1068: aload 12
    //   1070: invokestatic 294	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1073: ifne +189 -> 1262
    //   1076: new 212	apek
    //   1079: dup
    //   1080: aload 12
    //   1082: lload_3
    //   1083: invokespecial 215	apek:<init>	(Ljava/lang/String;J)V
    //   1086: areturn
    //   1087: aload 12
    //   1089: astore 13
    //   1091: goto -461 -> 630
    //   1094: astore 15
    //   1096: lconst_0
    //   1097: lstore 5
    //   1099: ldc 206
    //   1101: astore 13
    //   1103: aconst_null
    //   1104: astore 14
    //   1106: aload 14
    //   1108: astore 12
    //   1110: aload 15
    //   1112: invokevirtual 325	java/net/MalformedURLException:printStackTrace	()V
    //   1115: lload 5
    //   1117: lstore_3
    //   1118: aload 13
    //   1120: astore 12
    //   1122: aload 14
    //   1124: ifnull -136 -> 988
    //   1127: aload 14
    //   1129: invokevirtual 315	java/net/HttpURLConnection:disconnect	()V
    //   1132: lload 5
    //   1134: lstore_3
    //   1135: aload 13
    //   1137: astore 12
    //   1139: goto -151 -> 988
    //   1142: astore 15
    //   1144: lconst_0
    //   1145: lstore 5
    //   1147: ldc 206
    //   1149: astore 13
    //   1151: aconst_null
    //   1152: astore 14
    //   1154: aload 14
    //   1156: astore 12
    //   1158: aload 15
    //   1160: invokevirtual 326	java/io/IOException:printStackTrace	()V
    //   1163: lload 5
    //   1165: lstore_3
    //   1166: aload 13
    //   1168: astore 12
    //   1170: aload 14
    //   1172: ifnull -184 -> 988
    //   1175: aload 14
    //   1177: invokevirtual 315	java/net/HttpURLConnection:disconnect	()V
    //   1180: lload 5
    //   1182: lstore_3
    //   1183: aload 13
    //   1185: astore 12
    //   1187: goto -199 -> 988
    //   1190: astore 15
    //   1192: lconst_0
    //   1193: lstore 5
    //   1195: ldc 206
    //   1197: astore 13
    //   1199: aconst_null
    //   1200: astore 14
    //   1202: aload 14
    //   1204: astore 12
    //   1206: aload 15
    //   1208: invokevirtual 83	java/lang/Exception:printStackTrace	()V
    //   1211: lload 5
    //   1213: lstore_3
    //   1214: aload 13
    //   1216: astore 12
    //   1218: aload 14
    //   1220: ifnull -232 -> 988
    //   1223: aload 14
    //   1225: invokevirtual 315	java/net/HttpURLConnection:disconnect	()V
    //   1228: lload 5
    //   1230: lstore_3
    //   1231: aload 13
    //   1233: astore 12
    //   1235: goto -247 -> 988
    //   1238: astore_0
    //   1239: aload 12
    //   1241: ifnull +8 -> 1249
    //   1244: aload 12
    //   1246: invokevirtual 315	java/net/HttpURLConnection:disconnect	()V
    //   1249: aload_0
    //   1250: athrow
    //   1251: astore_0
    //   1252: aload_0
    //   1253: invokevirtual 83	java/lang/Exception:printStackTrace	()V
    //   1256: aload 13
    //   1258: astore_0
    //   1259: goto -191 -> 1068
    //   1262: aload_0
    //   1263: astore 12
    //   1265: goto -189 -> 1076
    //   1268: astore_0
    //   1269: aload 18
    //   1271: astore 12
    //   1273: goto -34 -> 1239
    //   1276: astore_0
    //   1277: goto -38 -> 1239
    //   1280: astore 15
    //   1282: aload 14
    //   1284: astore 13
    //   1286: aload 18
    //   1288: astore 14
    //   1290: goto -88 -> 1202
    //   1293: astore 12
    //   1295: lload 7
    //   1297: lstore 5
    //   1299: aload 15
    //   1301: astore 13
    //   1303: aload 18
    //   1305: astore 14
    //   1307: aload 12
    //   1309: astore 15
    //   1311: goto -157 -> 1154
    //   1314: astore 15
    //   1316: lload 9
    //   1318: lstore 5
    //   1320: aload 16
    //   1322: astore 13
    //   1324: aload 18
    //   1326: astore 14
    //   1328: goto -222 -> 1106
    //   1331: goto -343 -> 988
    //   1334: aload 13
    //   1336: astore 12
    //   1338: goto -360 -> 978
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1341	0	paramString	String
    //   468	260	1	i	int
    //   466	293	2	j	int
    //   1	1230	3	l1	long
    //   48	1271	5	l2	long
    //   55	1241	7	l3	long
    //   62	1255	9	l4	long
    //   968	94	11	bool	boolean
    //   3	1269	12	localObject1	Object
    //   1293	15	12	localIOException1	java.io.IOException
    //   1336	1	12	localObject2	Object
    //   372	963	13	localObject3	Object
    //   52	1275	14	localObject4	Object
    //   59	956	15	localObject5	Object
    //   1094	17	15	localMalformedURLException1	java.net.MalformedURLException
    //   1142	17	15	localIOException2	java.io.IOException
    //   1190	17	15	localException1	Exception
    //   1280	20	15	localException2	Exception
    //   1309	1	15	localIOException3	java.io.IOException
    //   1314	1	15	localMalformedURLException2	java.net.MalformedURLException
    //   66	1255	16	localObject6	Object
    //   7	609	17	str1	String
    //   45	1280	18	localHttpURLConnection	java.net.HttpURLConnection
    //   246	650	19	localURL	java.net.URL
    //   426	119	20	str2	String
    // Exception table:
    //   from	to	target	type
    //   31	47	1094	java/net/MalformedURLException
    //   31	47	1142	java/io/IOException
    //   31	47	1190	java/lang/Exception
    //   31	47	1238	finally
    //   996	1002	1251	java/lang/Exception
    //   1014	1021	1251	java/lang/Exception
    //   1033	1044	1251	java/lang/Exception
    //   1048	1058	1251	java/lang/Exception
    //   68	77	1268	finally
    //   98	107	1268	finally
    //   128	137	1268	finally
    //   158	167	1268	finally
    //   188	193	1268	finally
    //   214	220	1268	finally
    //   241	248	1268	finally
    //   269	295	1268	finally
    //   316	323	1268	finally
    //   344	374	1268	finally
    //   404	428	1268	finally
    //   458	467	1268	finally
    //   495	504	1268	finally
    //   534	554	1268	finally
    //   584	593	1268	finally
    //   619	630	1268	finally
    //   655	663	1268	finally
    //   684	693	1268	finally
    //   714	723	1268	finally
    //   756	767	1268	finally
    //   788	796	1268	finally
    //   817	832	1268	finally
    //   857	865	1268	finally
    //   895	902	1268	finally
    //   928	939	1268	finally
    //   960	970	1268	finally
    //   1110	1115	1276	finally
    //   1158	1163	1276	finally
    //   1206	1211	1276	finally
    //   68	77	1280	java/lang/Exception
    //   98	107	1280	java/lang/Exception
    //   128	137	1280	java/lang/Exception
    //   158	167	1280	java/lang/Exception
    //   188	193	1280	java/lang/Exception
    //   214	220	1280	java/lang/Exception
    //   241	248	1280	java/lang/Exception
    //   269	295	1280	java/lang/Exception
    //   316	323	1280	java/lang/Exception
    //   344	374	1280	java/lang/Exception
    //   404	428	1280	java/lang/Exception
    //   458	467	1280	java/lang/Exception
    //   495	504	1280	java/lang/Exception
    //   534	554	1280	java/lang/Exception
    //   584	593	1280	java/lang/Exception
    //   619	630	1280	java/lang/Exception
    //   655	663	1280	java/lang/Exception
    //   684	693	1280	java/lang/Exception
    //   714	723	1280	java/lang/Exception
    //   756	767	1280	java/lang/Exception
    //   788	796	1280	java/lang/Exception
    //   817	832	1280	java/lang/Exception
    //   857	865	1280	java/lang/Exception
    //   895	902	1280	java/lang/Exception
    //   928	939	1280	java/lang/Exception
    //   960	970	1280	java/lang/Exception
    //   68	77	1293	java/io/IOException
    //   98	107	1293	java/io/IOException
    //   128	137	1293	java/io/IOException
    //   158	167	1293	java/io/IOException
    //   188	193	1293	java/io/IOException
    //   214	220	1293	java/io/IOException
    //   241	248	1293	java/io/IOException
    //   269	295	1293	java/io/IOException
    //   316	323	1293	java/io/IOException
    //   344	374	1293	java/io/IOException
    //   404	428	1293	java/io/IOException
    //   458	467	1293	java/io/IOException
    //   495	504	1293	java/io/IOException
    //   534	554	1293	java/io/IOException
    //   584	593	1293	java/io/IOException
    //   619	630	1293	java/io/IOException
    //   655	663	1293	java/io/IOException
    //   684	693	1293	java/io/IOException
    //   714	723	1293	java/io/IOException
    //   756	767	1293	java/io/IOException
    //   788	796	1293	java/io/IOException
    //   817	832	1293	java/io/IOException
    //   857	865	1293	java/io/IOException
    //   895	902	1293	java/io/IOException
    //   928	939	1293	java/io/IOException
    //   960	970	1293	java/io/IOException
    //   68	77	1314	java/net/MalformedURLException
    //   98	107	1314	java/net/MalformedURLException
    //   128	137	1314	java/net/MalformedURLException
    //   158	167	1314	java/net/MalformedURLException
    //   188	193	1314	java/net/MalformedURLException
    //   214	220	1314	java/net/MalformedURLException
    //   241	248	1314	java/net/MalformedURLException
    //   269	295	1314	java/net/MalformedURLException
    //   316	323	1314	java/net/MalformedURLException
    //   344	374	1314	java/net/MalformedURLException
    //   404	428	1314	java/net/MalformedURLException
    //   458	467	1314	java/net/MalformedURLException
    //   495	504	1314	java/net/MalformedURLException
    //   534	554	1314	java/net/MalformedURLException
    //   584	593	1314	java/net/MalformedURLException
    //   619	630	1314	java/net/MalformedURLException
    //   655	663	1314	java/net/MalformedURLException
    //   684	693	1314	java/net/MalformedURLException
    //   714	723	1314	java/net/MalformedURLException
    //   756	767	1314	java/net/MalformedURLException
    //   788	796	1314	java/net/MalformedURLException
    //   817	832	1314	java/net/MalformedURLException
    //   857	865	1314	java/net/MalformedURLException
    //   895	902	1314	java/net/MalformedURLException
    //   928	939	1314	java/net/MalformedURLException
    //   960	970	1314	java/net/MalformedURLException
  }
  
  public static String a(String paramString)
  {
    if (paramString == null)
    {
      QLog.e("UniformDownloadUtil", 1, "[UniformDL] isApk. path = null");
      return null;
    }
    for (;;)
    {
      try
      {
        localObject = BaseApplication.getContext().getPackageManager().getPackageArchiveInfo(paramString, 1);
        if (localObject == null) {
          break label89;
        }
        localObject = ((PackageInfo)localObject).applicationInfo.packageName;
        if (localObject != null) {
          return localObject;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("UniformDownloadUtil", 1, "[UniformDL] isApk. Exception 1");
        paramString.printStackTrace();
        return null;
      }
      QLog.e("UniformDownloadUtil", 1, "[UniformDL] isApk. get package failed.  PH:" + paramString);
      return null;
      label89:
      Object localObject = null;
    }
  }
  
  public static void a(String paramString)
  {
    a(paramString, null);
  }
  
  public static void a(String paramString, apel paramapel)
  {
    apcw.a().execute(new UniformDownloadUtil.2(paramString, paramapel));
  }
  
  public static void a(String paramString, apem paramapem)
  {
    ThreadManager.getSubThreadHandler().post(new UniformDownloadUtil.1(paramString, paramapem));
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a(paramString1, new apej(paramString1, paramString2));
  }
  
  public static boolean a(String paramString)
  {
    return (paramString != null) && (apdh.a(paramString).equalsIgnoreCase(".apk"));
  }
  
  public static void b(String paramString1, String paramString2)
  {
    QLog.i("UniformDownloadUtil", 1, "[UniformDL] >>>openFileWithOtherApp. localPath:" + paramString1);
    if ((paramString1 == null) || (!apdh.a(paramString1)))
    {
      QLog.e("UniformDownloadUtil", 1, "[UniformDL] openFileWithOtherApp. file is not existed. localPath:" + paramString1);
      return;
    }
    BaseApplication localBaseApplication = BaseApplication.getContext();
    String str = axxf.a(localBaseApplication, paramString1);
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.putExtra("big_brother_source_key", paramString2);
    localIntent.setDataAndType(Uri.fromFile(new File(paramString1)), str);
    try
    {
      localBaseApplication.startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException paramString2)
    {
      QLog.w("UniformDownloadUtil", 1, "[UniformDL] openFileWithOtherApp. no useful app. localPath:" + paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apei
 * JD-Core Version:    0.7.0.1
 */