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
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanageraux.util.UniformDownloadUtil.1;
import com.tencent.mobileqq.filemanageraux.util.UniformDownloadUtil.2;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URLDecoder;
import java.util.concurrent.Executor;
import mqq.os.MqqHandler;

public class auuf
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
  public static auuh a(String paramString)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_1
    //   2: aconst_null
    //   3: astore 12
    //   5: ldc 206
    //   7: astore 10
    //   9: aload_0
    //   10: ifnull +11 -> 21
    //   13: aload_0
    //   14: invokevirtual 210	java/lang/String:length	()I
    //   17: iconst_1
    //   18: if_icmpge +13 -> 31
    //   21: new 212	auuh
    //   24: dup
    //   25: aconst_null
    //   26: lconst_0
    //   27: invokespecial 215	auuh:<init>	(Ljava/lang/String;J)V
    //   30: areturn
    //   31: new 217	java/net/URL
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 218	java/net/URL:<init>	(Ljava/lang/String;)V
    //   39: invokevirtual 222	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   42: checkcast 224	java/net/HttpURLConnection
    //   45: astore 11
    //   47: lload_1
    //   48: lstore_3
    //   49: aload 10
    //   51: astore 12
    //   53: lload_1
    //   54: lstore 5
    //   56: aload 10
    //   58: astore 13
    //   60: lload_1
    //   61: lstore 7
    //   63: aload 10
    //   65: astore 14
    //   67: aload 11
    //   69: ldc 226
    //   71: ldc 228
    //   73: invokevirtual 232	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: lload_1
    //   77: lstore_3
    //   78: aload 10
    //   80: astore 12
    //   82: lload_1
    //   83: lstore 5
    //   85: aload 10
    //   87: astore 13
    //   89: lload_1
    //   90: lstore 7
    //   92: aload 10
    //   94: astore 14
    //   96: aload 11
    //   98: ldc 234
    //   100: ldc 228
    //   102: invokevirtual 232	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: lload_1
    //   106: lstore_3
    //   107: aload 10
    //   109: astore 12
    //   111: lload_1
    //   112: lstore 5
    //   114: aload 10
    //   116: astore 13
    //   118: lload_1
    //   119: lstore 7
    //   121: aload 10
    //   123: astore 14
    //   125: aload 11
    //   127: ldc 226
    //   129: ldc 228
    //   131: invokevirtual 232	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: lload_1
    //   135: lstore_3
    //   136: aload 10
    //   138: astore 12
    //   140: lload_1
    //   141: lstore 5
    //   143: aload 10
    //   145: astore 13
    //   147: lload_1
    //   148: lstore 7
    //   150: aload 10
    //   152: astore 14
    //   154: aload 11
    //   156: ldc 234
    //   158: ldc 228
    //   160: invokevirtual 232	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   163: lload_1
    //   164: lstore_3
    //   165: aload 10
    //   167: astore 12
    //   169: lload_1
    //   170: lstore 5
    //   172: aload 10
    //   174: astore 13
    //   176: lload_1
    //   177: lstore 7
    //   179: aload 10
    //   181: astore 14
    //   183: aload 11
    //   185: invokevirtual 237	java/net/HttpURLConnection:connect	()V
    //   188: lload_1
    //   189: lstore_3
    //   190: aload 10
    //   192: astore 12
    //   194: lload_1
    //   195: lstore 5
    //   197: aload 10
    //   199: astore 13
    //   201: lload_1
    //   202: lstore 7
    //   204: aload 10
    //   206: astore 14
    //   208: aload 11
    //   210: invokevirtual 240	java/net/HttpURLConnection:getResponseCode	()I
    //   213: pop
    //   214: lload_1
    //   215: lstore_3
    //   216: aload 10
    //   218: astore 12
    //   220: lload_1
    //   221: lstore 5
    //   223: aload 10
    //   225: astore 13
    //   227: lload_1
    //   228: lstore 7
    //   230: aload 10
    //   232: astore 14
    //   234: aload 11
    //   236: invokevirtual 244	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   239: astore 16
    //   241: lload_1
    //   242: lstore_3
    //   243: aload 10
    //   245: astore 12
    //   247: lload_1
    //   248: lstore 5
    //   250: aload 10
    //   252: astore 13
    //   254: lload_1
    //   255: lstore 7
    //   257: aload 10
    //   259: astore 14
    //   261: ldc 246
    //   263: iconst_1
    //   264: new 26	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   271: ldc 248
    //   273: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload 16
    //   278: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   281: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokestatic 45	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   287: lload_1
    //   288: lstore_3
    //   289: aload 10
    //   291: astore 12
    //   293: lload_1
    //   294: lstore 5
    //   296: aload 10
    //   298: astore 13
    //   300: lload_1
    //   301: lstore 7
    //   303: aload 10
    //   305: astore 14
    //   307: aload 11
    //   309: invokevirtual 254	java/net/HttpURLConnection:getContentLength	()I
    //   312: i2l
    //   313: lstore_1
    //   314: lload_1
    //   315: lstore_3
    //   316: aload 10
    //   318: astore 12
    //   320: lload_1
    //   321: lstore 5
    //   323: aload 10
    //   325: astore 13
    //   327: lload_1
    //   328: lstore 7
    //   330: aload 10
    //   332: astore 14
    //   334: aload 11
    //   336: invokestatic 257	auuf:a	(Ljava/net/HttpURLConnection;)Ljava/lang/String;
    //   339: astore 15
    //   341: aload 15
    //   343: astore 10
    //   345: lload_1
    //   346: lstore_3
    //   347: aload 15
    //   349: astore 12
    //   351: lload_1
    //   352: lstore 5
    //   354: aload 15
    //   356: astore 13
    //   358: lload_1
    //   359: lstore 7
    //   361: aload 15
    //   363: astore 14
    //   365: aload 15
    //   367: invokestatic 263	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   370: ifeq +39 -> 409
    //   373: aload 15
    //   375: astore 10
    //   377: aload 16
    //   379: ifnull +30 -> 409
    //   382: lload_1
    //   383: lstore_3
    //   384: aload 15
    //   386: astore 12
    //   388: lload_1
    //   389: lstore 5
    //   391: aload 15
    //   393: astore 13
    //   395: lload_1
    //   396: lstore 7
    //   398: aload 15
    //   400: astore 14
    //   402: aload 16
    //   404: invokevirtual 266	java/net/URL:getFile	()Ljava/lang/String;
    //   407: astore 10
    //   409: aload 10
    //   411: ifnull +418 -> 829
    //   414: lload_1
    //   415: lstore_3
    //   416: aload 10
    //   418: astore 12
    //   420: lload_1
    //   421: lstore 5
    //   423: aload 10
    //   425: astore 13
    //   427: lload_1
    //   428: lstore 7
    //   430: aload 10
    //   432: astore 14
    //   434: aload 10
    //   436: ldc_w 268
    //   439: invokevirtual 271	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   442: ifne +38 -> 480
    //   445: lload_1
    //   446: lstore_3
    //   447: aload 10
    //   449: astore 12
    //   451: lload_1
    //   452: lstore 5
    //   454: aload 10
    //   456: astore 13
    //   458: lload_1
    //   459: lstore 7
    //   461: aload 10
    //   463: astore 14
    //   465: aload 10
    //   467: ldc_w 273
    //   470: invokevirtual 271	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   473: istore 9
    //   475: iload 9
    //   477: ifeq +352 -> 829
    //   480: aconst_null
    //   481: astore 10
    //   483: aload 11
    //   485: ifnull +341 -> 826
    //   488: aload 11
    //   490: invokevirtual 276	java/net/HttpURLConnection:disconnect	()V
    //   493: ldc 206
    //   495: astore 12
    //   497: aload 12
    //   499: astore 11
    //   501: aload_0
    //   502: invokestatic 282	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   505: astore 13
    //   507: aload 12
    //   509: astore_0
    //   510: aload 13
    //   512: ifnull +61 -> 573
    //   515: aload 12
    //   517: astore 11
    //   519: aload 13
    //   521: invokevirtual 285	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   524: astore 12
    //   526: aload 12
    //   528: astore_0
    //   529: aload 12
    //   531: ifnull +42 -> 573
    //   534: aload 12
    //   536: astore 11
    //   538: aload 12
    //   540: ldc_w 268
    //   543: invokevirtual 271	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   546: ifne +25 -> 571
    //   549: aload 12
    //   551: astore 11
    //   553: aload 12
    //   555: ldc_w 273
    //   558: invokevirtual 271	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   561: istore 9
    //   563: aload 12
    //   565: astore_0
    //   566: iload 9
    //   568: ifeq +5 -> 573
    //   571: aconst_null
    //   572: astore_0
    //   573: aload 10
    //   575: invokestatic 263	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   578: ifne +177 -> 755
    //   581: new 212	auuh
    //   584: dup
    //   585: aload 10
    //   587: lload_1
    //   588: invokespecial 215	auuh:<init>	(Ljava/lang/String;J)V
    //   591: areturn
    //   592: astore 13
    //   594: lconst_0
    //   595: lstore_3
    //   596: ldc 206
    //   598: astore 11
    //   600: aconst_null
    //   601: astore 12
    //   603: aload 12
    //   605: astore 10
    //   607: aload 13
    //   609: invokevirtual 286	java/net/MalformedURLException:printStackTrace	()V
    //   612: lload_3
    //   613: lstore_1
    //   614: aload 11
    //   616: astore 10
    //   618: aload 12
    //   620: ifnull -127 -> 493
    //   623: aload 12
    //   625: invokevirtual 276	java/net/HttpURLConnection:disconnect	()V
    //   628: lload_3
    //   629: lstore_1
    //   630: aload 11
    //   632: astore 10
    //   634: goto -141 -> 493
    //   637: astore 13
    //   639: lconst_0
    //   640: lstore_3
    //   641: ldc 206
    //   643: astore 11
    //   645: aconst_null
    //   646: astore 12
    //   648: aload 12
    //   650: astore 10
    //   652: aload 13
    //   654: invokevirtual 287	java/io/IOException:printStackTrace	()V
    //   657: lload_3
    //   658: lstore_1
    //   659: aload 11
    //   661: astore 10
    //   663: aload 12
    //   665: ifnull -172 -> 493
    //   668: aload 12
    //   670: invokevirtual 276	java/net/HttpURLConnection:disconnect	()V
    //   673: lload_3
    //   674: lstore_1
    //   675: aload 11
    //   677: astore 10
    //   679: goto -186 -> 493
    //   682: astore 13
    //   684: lconst_0
    //   685: lstore_3
    //   686: ldc 206
    //   688: astore 11
    //   690: aconst_null
    //   691: astore 12
    //   693: aload 12
    //   695: astore 10
    //   697: aload 13
    //   699: invokevirtual 83	java/lang/Exception:printStackTrace	()V
    //   702: lload_3
    //   703: lstore_1
    //   704: aload 11
    //   706: astore 10
    //   708: aload 12
    //   710: ifnull -217 -> 493
    //   713: aload 12
    //   715: invokevirtual 276	java/net/HttpURLConnection:disconnect	()V
    //   718: lload_3
    //   719: lstore_1
    //   720: aload 11
    //   722: astore 10
    //   724: goto -231 -> 493
    //   727: astore_0
    //   728: aload 12
    //   730: astore 10
    //   732: aload 10
    //   734: ifnull +8 -> 742
    //   737: aload 10
    //   739: invokevirtual 276	java/net/HttpURLConnection:disconnect	()V
    //   742: aload_0
    //   743: athrow
    //   744: astore_0
    //   745: aload_0
    //   746: invokevirtual 83	java/lang/Exception:printStackTrace	()V
    //   749: aload 11
    //   751: astore_0
    //   752: goto -179 -> 573
    //   755: aload_0
    //   756: astore 10
    //   758: goto -177 -> 581
    //   761: astore_0
    //   762: aload 11
    //   764: astore 10
    //   766: goto -34 -> 732
    //   769: astore_0
    //   770: goto -38 -> 732
    //   773: astore 13
    //   775: aload 12
    //   777: astore 10
    //   779: aload 11
    //   781: astore 12
    //   783: aload 10
    //   785: astore 11
    //   787: goto -94 -> 693
    //   790: astore 10
    //   792: lload 5
    //   794: lstore_3
    //   795: aload 11
    //   797: astore 12
    //   799: aload 13
    //   801: astore 11
    //   803: aload 10
    //   805: astore 13
    //   807: goto -159 -> 648
    //   810: astore 13
    //   812: lload 7
    //   814: lstore_3
    //   815: aload 11
    //   817: astore 12
    //   819: aload 14
    //   821: astore 11
    //   823: goto -220 -> 603
    //   826: goto -333 -> 493
    //   829: goto -346 -> 483
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	832	0	paramString	String
    //   1	719	1	l1	long
    //   48	767	3	l2	long
    //   54	739	5	l3	long
    //   61	752	7	l4	long
    //   473	94	9	bool	boolean
    //   7	777	10	localObject1	Object
    //   790	14	10	localIOException1	java.io.IOException
    //   45	777	11	localObject2	Object
    //   3	815	12	localObject3	Object
    //   58	462	13	localObject4	Object
    //   592	16	13	localMalformedURLException1	java.net.MalformedURLException
    //   637	16	13	localIOException2	java.io.IOException
    //   682	16	13	localException1	Exception
    //   773	27	13	localException2	Exception
    //   805	1	13	localIOException3	java.io.IOException
    //   810	1	13	localMalformedURLException2	java.net.MalformedURLException
    //   65	755	14	localObject5	Object
    //   339	60	15	str	String
    //   239	164	16	localURL	java.net.URL
    // Exception table:
    //   from	to	target	type
    //   31	47	592	java/net/MalformedURLException
    //   31	47	637	java/io/IOException
    //   31	47	682	java/lang/Exception
    //   31	47	727	finally
    //   501	507	744	java/lang/Exception
    //   519	526	744	java/lang/Exception
    //   538	549	744	java/lang/Exception
    //   553	563	744	java/lang/Exception
    //   67	76	761	finally
    //   96	105	761	finally
    //   125	134	761	finally
    //   154	163	761	finally
    //   183	188	761	finally
    //   208	214	761	finally
    //   234	241	761	finally
    //   261	287	761	finally
    //   307	314	761	finally
    //   334	341	761	finally
    //   365	373	761	finally
    //   402	409	761	finally
    //   434	445	761	finally
    //   465	475	761	finally
    //   607	612	769	finally
    //   652	657	769	finally
    //   697	702	769	finally
    //   67	76	773	java/lang/Exception
    //   96	105	773	java/lang/Exception
    //   125	134	773	java/lang/Exception
    //   154	163	773	java/lang/Exception
    //   183	188	773	java/lang/Exception
    //   208	214	773	java/lang/Exception
    //   234	241	773	java/lang/Exception
    //   261	287	773	java/lang/Exception
    //   307	314	773	java/lang/Exception
    //   334	341	773	java/lang/Exception
    //   365	373	773	java/lang/Exception
    //   402	409	773	java/lang/Exception
    //   434	445	773	java/lang/Exception
    //   465	475	773	java/lang/Exception
    //   67	76	790	java/io/IOException
    //   96	105	790	java/io/IOException
    //   125	134	790	java/io/IOException
    //   154	163	790	java/io/IOException
    //   183	188	790	java/io/IOException
    //   208	214	790	java/io/IOException
    //   234	241	790	java/io/IOException
    //   261	287	790	java/io/IOException
    //   307	314	790	java/io/IOException
    //   334	341	790	java/io/IOException
    //   365	373	790	java/io/IOException
    //   402	409	790	java/io/IOException
    //   434	445	790	java/io/IOException
    //   465	475	790	java/io/IOException
    //   67	76	810	java/net/MalformedURLException
    //   96	105	810	java/net/MalformedURLException
    //   125	134	810	java/net/MalformedURLException
    //   154	163	810	java/net/MalformedURLException
    //   183	188	810	java/net/MalformedURLException
    //   208	214	810	java/net/MalformedURLException
    //   234	241	810	java/net/MalformedURLException
    //   261	287	810	java/net/MalformedURLException
    //   307	314	810	java/net/MalformedURLException
    //   334	341	810	java/net/MalformedURLException
    //   365	373	810	java/net/MalformedURLException
    //   402	409	810	java/net/MalformedURLException
    //   434	445	810	java/net/MalformedURLException
    //   465	475	810	java/net/MalformedURLException
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
  
  private static String a(HttpURLConnection paramHttpURLConnection)
  {
    Object localObject5 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    localObject1 = localObject4;
    for (;;)
    {
      Object localObject2;
      try
      {
        paramHttpURLConnection = URLDecoder.decode(new String(paramHttpURLConnection.getHeaderField("Content-Disposition").getBytes("ISO-8859-1"), "utf-8"), "utf-8");
        localObject2 = localObject5;
        if (paramHttpURLConnection != null)
        {
          localObject1 = localObject4;
          String str = URLDecoder.decode(new String(paramHttpURLConnection.getBytes("ISO-8859-1"), "utf-8"), "utf-8");
          localObject2 = localObject5;
          if (str != null)
          {
            localObject1 = localObject4;
            int j = str.indexOf("filename=");
            int i = j;
            if (-1 == j)
            {
              localObject1 = localObject4;
              i = str.indexOf("FileName=");
            }
            paramHttpURLConnection = localObject3;
            if (-1 != i)
            {
              localObject1 = localObject4;
              localObject2 = str.substring(i + "filename=".length(), str.length());
              paramHttpURLConnection = localObject3;
              if (localObject2 != null)
              {
                localObject1 = localObject4;
                i = ((String)localObject2).indexOf(";");
                if (-1 == i) {
                  continue;
                }
                localObject1 = localObject4;
                paramHttpURLConnection = ((String)localObject2).substring(0, i - 1);
              }
            }
            localObject2 = paramHttpURLConnection;
            localObject1 = paramHttpURLConnection;
            if (!TextUtils.isEmpty(paramHttpURLConnection))
            {
              localObject1 = paramHttpURLConnection;
              i = paramHttpURLConnection.indexOf("\"");
              localObject1 = paramHttpURLConnection;
              j = paramHttpURLConnection.lastIndexOf("\"");
              localObject2 = paramHttpURLConnection;
              if (i == 0)
              {
                localObject2 = paramHttpURLConnection;
                localObject1 = paramHttpURLConnection;
                if (j + 1 == paramHttpURLConnection.length())
                {
                  localObject1 = paramHttpURLConnection;
                  paramHttpURLConnection = paramHttpURLConnection.substring(1);
                }
              }
            }
          }
        }
      }
      catch (UnsupportedEncodingException paramHttpURLConnection) {}
      try
      {
        localObject2 = paramHttpURLConnection.substring(0, paramHttpURLConnection.length() - 1);
        return localObject2;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          localObject1 = paramHttpURLConnection;
          paramHttpURLConnection = localUnsupportedEncodingException;
        }
      }
      paramHttpURLConnection = (HttpURLConnection)localObject2;
    }
    paramHttpURLConnection.printStackTrace();
    return localObject1;
  }
  
  public static void a(String paramString)
  {
    a(paramString, null);
  }
  
  public static void a(String paramString, auui paramauui)
  {
    aunu.a().execute(new UniformDownloadUtil.2(paramString, paramauui));
  }
  
  public static void a(String paramString, auuj paramauuj)
  {
    ThreadManager.getSubThreadHandler().post(new UniformDownloadUtil.1(paramString, paramauuj));
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a(paramString1, new auug(paramString1, paramString2));
  }
  
  public static boolean a(String paramString)
  {
    return (paramString != null) && (auog.a(paramString).equalsIgnoreCase(".apk"));
  }
  
  public static void b(String paramString1, String paramString2)
  {
    QLog.i("UniformDownloadUtil", 1, "[UniformDL] >>>openFileWithOtherApp. localPath:" + paramString1);
    if ((paramString1 == null) || (!auog.a(paramString1)))
    {
      QLog.e("UniformDownloadUtil", 1, "[UniformDL] openFileWithOtherApp. file is not existed. localPath:" + paramString1);
      return;
    }
    BaseApplication localBaseApplication = BaseApplication.getContext();
    String str = bezl.a(localBaseApplication, paramString1);
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
 * Qualified Name:     auuf
 * JD-Core Version:    0.7.0.1
 */