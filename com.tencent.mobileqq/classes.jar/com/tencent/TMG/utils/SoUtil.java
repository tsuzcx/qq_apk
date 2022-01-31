package com.tencent.TMG.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import java.io.File;

public class SoUtil
{
  private static final String KEY_APK_SIZE = "key_apk_size";
  private static final String KEY_APK_UPDATE_TIME = "key_apk_update_time";
  private static final String KEY_APP_VERSION = "key_app_version";
  private static final String SO_SP = "so_sp";
  private static final String TAG = "SoUtil";
  private static boolean copySoFromAssets;
  private static Context ctx = null;
  public static String customLibPath = null;
  private static int extractSoError;
  
  static
  {
    copySoFromAssets = false;
    extractSoError = 0;
  }
  
  public static boolean LoadExtractedSo(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SoUtil", 0, "start LoadExtractedSo: " + paramString);
    }
    try
    {
      System.load(ctx.getFilesDir().getParent() + "/txav/" + getLibActualName(paramString));
      bool1 = true;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
    {
      for (;;)
      {
        localFile = new File(ctx.getFilesDir().getParent() + "/txav/" + getLibActualName(paramString));
        if (localFile.exists()) {
          localFile.delete();
        }
        extractLibraryFromAssert(paramString, true);
        try
        {
          System.load(ctx.getFilesDir().getParent() + "/txav/" + getLibActualName(paramString));
          bool1 = true;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
        {
          bool1 = false;
        }
      }
    }
    bool2 = bool1;
    if (!bool1) {
      if (QLog.isColorLevel()) {
        QLog.d("SoUtil", 0, "finally try to use system way to load so: " + paramString);
      }
    }
    try
    {
      System.loadLibrary(paramString);
      bool2 = true;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError3)
    {
      for (;;)
      {
        File localFile;
        bool2 = bool1;
      }
    }
    if (!bool2) {
      QLog.e("SoUtil", 1, "LoadExtractedSo failed: " + paramString);
    }
    return bool2;
  }
  
  public static int extractAVModulesFromAssets()
  {
    SharedPreferences localSharedPreferences = ctx.getSharedPreferences("so_sp", 0);
    Object localObject5 = ctx.getPackageManager();
    Object localObject3 = localSharedPreferences.getString("key_app_version", "");
    long l4 = localSharedPreferences.getLong("key_apk_size", -1L);
    long l5 = localSharedPreferences.getLong("key_apk_update_time", -1L);
    long l2 = -1L;
    if (QLog.isColorLevel()) {
      QLog.d("SoUtil", 0, "local version = " + (String)localObject3 + ", lastUpdateApkSize = " + l4 + ", lastUpdateApkTime = " + l5);
    }
    for (long l1 = l2;; l1 = -1L)
    {
      for (;;)
      {
        try
        {
          Object localObject1 = ((PackageManager)localObject5).getApplicationInfo(ctx.getPackageName(), 0);
          l1 = l2;
          localObject5 = ((PackageManager)localObject5).getPackageInfo(ctx.getPackageName(), 0);
          l1 = l2;
          localObject1 = new File(((ApplicationInfo)localObject1).sourceDir);
          if (localObject1 == null) {
            break;
          }
          l1 = l2;
          if (!((File)localObject1).exists()) {
            break;
          }
          l1 = l2;
          l2 = ((File)localObject1).length();
          l1 = l2;
          long l3 = ((File)localObject1).lastModified();
          l1 = l2;
          l2 = l3;
          if (localObject5 != null)
          {
            boolean bool2;
            Object localObject4;
            return extractSoError;
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException1)
        {
          for (;;)
          {
            try
            {
              localObject1 = ((PackageInfo)localObject5).versionName + "." + ((PackageInfo)localObject5).versionCode;
              if (l1 != l4) {
                continue;
              }
            }
            catch (PackageManager.NameNotFoundException localNameNotFoundException2)
            {
              boolean bool1 = true;
              str = "";
              continue;
              bool1 = true;
              continue;
            }
            try
            {
              bool1 = ((String)localObject3).equals(localObject1);
              if ((!bool1) || (l2 != l5)) {
                continue;
              }
              bool1 = false;
              l3 = l2;
              l4 = l1;
              localObject3 = localObject1;
              bool2 = bool1;
            }
            catch (PackageManager.NameNotFoundException localNameNotFoundException3)
            {
              bool1 = true;
            }
          }
          try
          {
            if (QLog.isColorLevel())
            {
              QLog.d("SoUtil", 0, "apk version = " + (String)localObject1 + ", apksize = " + l1 + ", apkTime = " + l2 + ", needupdate = " + bool1);
              bool2 = bool1;
              localObject3 = localObject1;
              l4 = l1;
              l3 = l2;
            }
            if ((!extractLibraryFromAssert("hwcodec", bool2)) || (!extractLibraryFromAssert("traeimp-armeabi-v7a", bool2)) || (!extractLibraryFromAssert("qav_graphics", bool2)) || (!extractLibraryFromAssert("qavsdk", bool2)) || (!extractLibraryFromAssert("stlport_shared", bool2)) || (!extractLibraryFromAssert("TcVpxDec", bool2)) || (!extractLibraryFromAssert("TcVpxEnc", bool2)) || (!extractLibraryFromAssert("xplatform", bool2)) || (!extractLibraryFromAssert("UDT", bool2))) {
              break label578;
            }
            if (!TextUtils.isEmpty((CharSequence)localObject3)) {
              localSharedPreferences.edit().putString("key_app_version", (String)localObject3).commit();
            }
            if (l4 > 0L) {
              localSharedPreferences.edit().putLong("key_apk_size", l4).commit();
            }
            if (l3 > 0L) {
              localSharedPreferences.edit().putLong("key_apk_update_time", l3).commit();
            }
            return 0;
          }
          catch (PackageManager.NameNotFoundException localNameNotFoundException4)
          {
            continue;
          }
          localNameNotFoundException1 = localNameNotFoundException1;
          l2 = -1L;
          localObject1 = "";
          bool1 = true;
          localNameNotFoundException1.printStackTrace();
          l3 = l2;
          l4 = l1;
          localObject4 = localObject1;
          bool2 = bool1;
          continue;
        }
        finally {}
        label578:
        String str = "";
      }
      l2 = -1L;
    }
  }
  
  /* Error */
  private static boolean extractLibraryFromAssert(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iconst_0
    //   4: istore 6
    //   6: iconst_0
    //   7: istore 8
    //   9: iconst_0
    //   10: istore 7
    //   12: iconst_0
    //   13: istore 9
    //   15: ldc 130
    //   17: astore 24
    //   19: iconst_0
    //   20: istore_3
    //   21: iconst_0
    //   22: istore_2
    //   23: invokestatic 257	com/tencent/TMG/utils/SoUtil:getTxlibPath	()Ljava/lang/String;
    //   26: astore 30
    //   28: aload 30
    //   30: invokestatic 230	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   33: istore 10
    //   35: iload 10
    //   37: ifeq +12 -> 49
    //   40: iconst_0
    //   41: istore 6
    //   43: ldc 2
    //   45: monitorexit
    //   46: iload 6
    //   48: ireturn
    //   49: new 76	java/io/File
    //   52: dup
    //   53: new 53	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   60: aload 30
    //   62: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: aload_0
    //   66: invokestatic 85	com/tencent/TMG/utils/SoUtil:getLibActualName	(Ljava/lang/String;)Ljava/lang/String;
    //   69: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokespecial 106	java/io/File:<init>	(Ljava/lang/String;)V
    //   78: astore 29
    //   80: iload_1
    //   81: ifne +29 -> 110
    //   84: aload 29
    //   86: invokevirtual 109	java/io/File:exists	()Z
    //   89: ifeq +21 -> 110
    //   92: invokestatic 51	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   95: ifeq +1545 -> 1640
    //   98: ldc 20
    //   100: iconst_0
    //   101: ldc_w 259
    //   104: invokestatic 96	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   107: goto +1533 -> 1640
    //   110: invokestatic 264	android/os/SystemClock:uptimeMillis	()J
    //   113: lstore 13
    //   115: aload 29
    //   117: invokevirtual 112	java/io/File:delete	()Z
    //   120: pop
    //   121: aload 29
    //   123: invokevirtual 109	java/io/File:exists	()Z
    //   126: istore_1
    //   127: iload_1
    //   128: ifne +1506 -> 1634
    //   131: aconst_null
    //   132: astore 28
    //   134: aconst_null
    //   135: astore 25
    //   137: aconst_null
    //   138: astore 26
    //   140: aconst_null
    //   141: astore 27
    //   143: aconst_null
    //   144: astore 16
    //   146: aconst_null
    //   147: astore 15
    //   149: aconst_null
    //   150: astore 22
    //   152: aload 16
    //   154: astore 18
    //   156: aload 25
    //   158: astore 20
    //   160: aload 24
    //   162: astore 21
    //   164: iload 8
    //   166: istore_1
    //   167: aload 15
    //   169: astore 17
    //   171: aload 26
    //   173: astore 19
    //   175: new 76	java/io/File
    //   178: dup
    //   179: aload 30
    //   181: invokespecial 106	java/io/File:<init>	(Ljava/lang/String;)V
    //   184: astore 23
    //   186: aload 16
    //   188: astore 18
    //   190: aload 25
    //   192: astore 20
    //   194: aload 24
    //   196: astore 21
    //   198: iload 8
    //   200: istore_1
    //   201: aload 15
    //   203: astore 17
    //   205: aload 26
    //   207: astore 19
    //   209: aload 23
    //   211: invokevirtual 109	java/io/File:exists	()Z
    //   214: ifne +42 -> 256
    //   217: aload 16
    //   219: astore 18
    //   221: aload 25
    //   223: astore 20
    //   225: aload 24
    //   227: astore 21
    //   229: iload 8
    //   231: istore_1
    //   232: aload 15
    //   234: astore 17
    //   236: aload 26
    //   238: astore 19
    //   240: aload 23
    //   242: invokevirtual 267	java/io/File:mkdir	()Z
    //   245: istore 7
    //   247: aload 28
    //   249: astore 23
    //   251: iload 7
    //   253: ifeq +933 -> 1186
    //   256: aload 16
    //   258: astore 18
    //   260: aload 25
    //   262: astore 20
    //   264: aload 24
    //   266: astore 21
    //   268: iload 8
    //   270: istore_1
    //   271: aload 15
    //   273: astore 17
    //   275: aload 26
    //   277: astore 19
    //   279: invokestatic 51	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   282: ifeq +61 -> 343
    //   285: aload 16
    //   287: astore 18
    //   289: aload 25
    //   291: astore 20
    //   293: aload 24
    //   295: astore 21
    //   297: iload 8
    //   299: istore_1
    //   300: aload 15
    //   302: astore 17
    //   304: aload 26
    //   306: astore 19
    //   308: ldc 20
    //   310: iconst_0
    //   311: new 53	java/lang/StringBuilder
    //   314: dup
    //   315: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   318: ldc_w 269
    //   321: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: invokestatic 272	com/tencent/TMG/utils/SoUtil:getLibPath	()Ljava/lang/String;
    //   327: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: aload_0
    //   331: invokestatic 85	com/tencent/TMG/utils/SoUtil:getLibActualName	(Ljava/lang/String;)Ljava/lang/String;
    //   334: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokestatic 96	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   343: aload 16
    //   345: astore 18
    //   347: aload 25
    //   349: astore 20
    //   351: aload 24
    //   353: astore 21
    //   355: iload 8
    //   357: istore_1
    //   358: aload 15
    //   360: astore 17
    //   362: aload 26
    //   364: astore 19
    //   366: getstatic 31	com/tencent/TMG/utils/SoUtil:ctx	Landroid/content/Context;
    //   369: invokevirtual 276	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   372: new 53	java/lang/StringBuilder
    //   375: dup
    //   376: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   379: invokestatic 272	com/tencent/TMG/utils/SoUtil:getLibPath	()Ljava/lang/String;
    //   382: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: aload_0
    //   386: invokestatic 85	com/tencent/TMG/utils/SoUtil:getLibActualName	(Ljava/lang/String;)Ljava/lang/String;
    //   389: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: invokevirtual 282	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   398: astore 16
    //   400: aload 16
    //   402: astore 15
    //   404: iload 9
    //   406: istore 7
    //   408: aload 16
    //   410: astore 18
    //   412: aload 25
    //   414: astore 20
    //   416: aload 24
    //   418: astore 21
    //   420: iload 8
    //   422: istore_1
    //   423: aload 16
    //   425: astore 17
    //   427: aload 26
    //   429: astore 19
    //   431: invokestatic 285	com/tencent/TMG/utils/SoUtil:getAvailableInternalMemorySize	()J
    //   434: aload 16
    //   436: invokevirtual 290	java/io/InputStream:available	()I
    //   439: i2l
    //   440: lcmp
    //   441: ifge +163 -> 604
    //   444: iconst_1
    //   445: istore 4
    //   447: iconst_1
    //   448: istore 5
    //   450: aload 16
    //   452: astore 18
    //   454: aload 25
    //   456: astore 20
    //   458: aload 24
    //   460: astore 21
    //   462: iload 8
    //   464: istore_1
    //   465: aload 16
    //   467: astore 17
    //   469: aload 26
    //   471: astore 19
    //   473: iload 4
    //   475: istore_3
    //   476: sipush 10101
    //   479: putstatic 35	com/tencent/TMG/utils/SoUtil:extractSoError	I
    //   482: iload 5
    //   484: istore_2
    //   485: aload 16
    //   487: astore 15
    //   489: iload 9
    //   491: istore 7
    //   493: aload 16
    //   495: astore 18
    //   497: aload 25
    //   499: astore 20
    //   501: aload 24
    //   503: astore 21
    //   505: iload 8
    //   507: istore_1
    //   508: aload 16
    //   510: astore 17
    //   512: aload 26
    //   514: astore 19
    //   516: iload 4
    //   518: istore_3
    //   519: invokestatic 51	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   522: ifeq +82 -> 604
    //   525: aload 16
    //   527: astore 18
    //   529: aload 25
    //   531: astore 20
    //   533: aload 24
    //   535: astore 21
    //   537: iload 8
    //   539: istore_1
    //   540: aload 16
    //   542: astore 17
    //   544: aload 26
    //   546: astore 19
    //   548: iload 4
    //   550: istore_3
    //   551: ldc 20
    //   553: iconst_0
    //   554: new 53	java/lang/StringBuilder
    //   557: dup
    //   558: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   561: ldc_w 292
    //   564: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: invokestatic 285	com/tencent/TMG/utils/SoUtil:getAvailableInternalMemorySize	()J
    //   570: invokevirtual 149	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   573: ldc_w 294
    //   576: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: aload 16
    //   581: invokevirtual 290	java/io/InputStream:available	()I
    //   584: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   587: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   590: invokestatic 96	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   593: iload 9
    //   595: istore 7
    //   597: aload 16
    //   599: astore 15
    //   601: iload 5
    //   603: istore_2
    //   604: aload 15
    //   606: astore 22
    //   608: aload 28
    //   610: astore 23
    //   612: iload 7
    //   614: istore 6
    //   616: iload_2
    //   617: ifne +569 -> 1186
    //   620: aload 15
    //   622: astore 22
    //   624: aload 28
    //   626: astore 23
    //   628: iload 7
    //   630: istore 6
    //   632: iload 7
    //   634: ifne +552 -> 1186
    //   637: aload 27
    //   639: astore 16
    //   641: aload 15
    //   643: ifnull +58 -> 701
    //   646: aload 15
    //   648: astore 18
    //   650: aload 25
    //   652: astore 20
    //   654: aload 24
    //   656: astore 21
    //   658: iload 7
    //   660: istore_1
    //   661: aload 15
    //   663: astore 17
    //   665: aload 26
    //   667: astore 19
    //   669: new 296	java/io/FileOutputStream
    //   672: dup
    //   673: new 53	java/lang/StringBuilder
    //   676: dup
    //   677: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   680: aload 30
    //   682: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: aload_0
    //   686: invokestatic 85	com/tencent/TMG/utils/SoUtil:getLibActualName	(Ljava/lang/String;)Ljava/lang/String;
    //   689: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   695: iconst_1
    //   696: invokespecial 299	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   699: astore 16
    //   701: lconst_0
    //   702: lstore 11
    //   704: aload 15
    //   706: astore 18
    //   708: aload 16
    //   710: astore 20
    //   712: aload 24
    //   714: astore 21
    //   716: iload 7
    //   718: istore_1
    //   719: aload 15
    //   721: astore 17
    //   723: aload 16
    //   725: astore 19
    //   727: ldc_w 300
    //   730: newarray byte
    //   732: astore 22
    //   734: aload 15
    //   736: ifnull +85 -> 821
    //   739: aload 15
    //   741: astore 18
    //   743: aload 16
    //   745: astore 20
    //   747: aload 24
    //   749: astore 21
    //   751: iload 7
    //   753: istore_1
    //   754: aload 15
    //   756: astore 17
    //   758: aload 16
    //   760: astore 19
    //   762: aload 15
    //   764: aload 22
    //   766: iconst_0
    //   767: aload 22
    //   769: arraylength
    //   770: invokevirtual 304	java/io/InputStream:read	([BII)I
    //   773: istore_2
    //   774: iload_2
    //   775: iconst_m1
    //   776: if_icmpeq +45 -> 821
    //   779: aload 15
    //   781: astore 18
    //   783: aload 16
    //   785: astore 20
    //   787: aload 24
    //   789: astore 21
    //   791: iload 7
    //   793: istore_1
    //   794: aload 15
    //   796: astore 17
    //   798: aload 16
    //   800: astore 19
    //   802: aload 16
    //   804: aload 22
    //   806: iconst_0
    //   807: iload_2
    //   808: invokevirtual 310	java/io/OutputStream:write	([BII)V
    //   811: lload 11
    //   813: iload_2
    //   814: i2l
    //   815: ladd
    //   816: lstore 11
    //   818: goto -84 -> 734
    //   821: iconst_0
    //   822: ifeq +61 -> 883
    //   825: aload 15
    //   827: astore 18
    //   829: aload 16
    //   831: astore 20
    //   833: aload 24
    //   835: astore 21
    //   837: iload 7
    //   839: istore_1
    //   840: aload 15
    //   842: astore 17
    //   844: aload 16
    //   846: astore 19
    //   848: aload 22
    //   850: arraylength
    //   851: istore_2
    //   852: aload 15
    //   854: astore 18
    //   856: aload 16
    //   858: astore 20
    //   860: aload 24
    //   862: astore 21
    //   864: iload 7
    //   866: istore_1
    //   867: aload 15
    //   869: astore 17
    //   871: aload 16
    //   873: astore 19
    //   875: new 312	java/lang/NullPointerException
    //   878: dup
    //   879: invokespecial 313	java/lang/NullPointerException:<init>	()V
    //   882: athrow
    //   883: aload 15
    //   885: astore 18
    //   887: aload 16
    //   889: astore 20
    //   891: aload 24
    //   893: astore 21
    //   895: iload 7
    //   897: istore_1
    //   898: aload 15
    //   900: astore 17
    //   902: aload 16
    //   904: astore 19
    //   906: invokestatic 51	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   909: ifeq +35 -> 944
    //   912: aload 15
    //   914: astore 18
    //   916: aload 16
    //   918: astore 20
    //   920: aload 24
    //   922: astore 21
    //   924: iload 7
    //   926: istore_1
    //   927: aload 15
    //   929: astore 17
    //   931: aload 16
    //   933: astore 19
    //   935: ldc 20
    //   937: iconst_0
    //   938: ldc_w 315
    //   941: invokestatic 96	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   944: aload 15
    //   946: astore 22
    //   948: aload 16
    //   950: astore 23
    //   952: iload 7
    //   954: istore 6
    //   956: aload 15
    //   958: astore 18
    //   960: aload 16
    //   962: astore 20
    //   964: aload 24
    //   966: astore 21
    //   968: iload 7
    //   970: istore_1
    //   971: aload 15
    //   973: astore 17
    //   975: aload 16
    //   977: astore 19
    //   979: aload 29
    //   981: invokevirtual 109	java/io/File:exists	()Z
    //   984: ifeq +202 -> 1186
    //   987: aload 15
    //   989: astore 18
    //   991: aload 16
    //   993: astore 20
    //   995: aload 24
    //   997: astore 21
    //   999: iload 7
    //   1001: istore_1
    //   1002: aload 15
    //   1004: astore 17
    //   1006: aload 16
    //   1008: astore 19
    //   1010: lload 11
    //   1012: aload 29
    //   1014: invokevirtual 173	java/io/File:length	()J
    //   1017: lcmp
    //   1018: ifeq +270 -> 1288
    //   1021: aload 15
    //   1023: astore 18
    //   1025: aload 16
    //   1027: astore 20
    //   1029: aload 24
    //   1031: astore 21
    //   1033: iload 7
    //   1035: istore_1
    //   1036: aload 15
    //   1038: astore 17
    //   1040: aload 16
    //   1042: astore 19
    //   1044: aload 29
    //   1046: invokevirtual 112	java/io/File:delete	()Z
    //   1049: pop
    //   1050: aload 15
    //   1052: astore 18
    //   1054: aload 16
    //   1056: astore 20
    //   1058: aload 24
    //   1060: astore 21
    //   1062: iload 7
    //   1064: istore_1
    //   1065: aload 15
    //   1067: astore 17
    //   1069: aload 16
    //   1071: astore 19
    //   1073: new 53	java/lang/StringBuilder
    //   1076: dup
    //   1077: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   1080: ldc 130
    //   1082: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1085: ldc_w 317
    //   1088: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1091: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1094: astore 24
    //   1096: iconst_0
    //   1097: istore 7
    //   1099: iconst_0
    //   1100: istore 8
    //   1102: aload 15
    //   1104: astore 22
    //   1106: aload 16
    //   1108: astore 23
    //   1110: iload 8
    //   1112: istore 6
    //   1114: aload 15
    //   1116: astore 18
    //   1118: aload 16
    //   1120: astore 20
    //   1122: aload 24
    //   1124: astore 21
    //   1126: iload 7
    //   1128: istore_1
    //   1129: aload 15
    //   1131: astore 17
    //   1133: aload 16
    //   1135: astore 19
    //   1137: invokestatic 51	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   1140: ifeq +46 -> 1186
    //   1143: aload 15
    //   1145: astore 18
    //   1147: aload 16
    //   1149: astore 20
    //   1151: aload 24
    //   1153: astore 21
    //   1155: iload 7
    //   1157: istore_1
    //   1158: aload 15
    //   1160: astore 17
    //   1162: aload 16
    //   1164: astore 19
    //   1166: ldc 20
    //   1168: iconst_0
    //   1169: aload 24
    //   1171: invokestatic 96	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1174: iload 8
    //   1176: istore 6
    //   1178: aload 16
    //   1180: astore 23
    //   1182: aload 15
    //   1184: astore 22
    //   1186: aload 23
    //   1188: ifnull +8 -> 1196
    //   1191: aload 23
    //   1193: invokevirtual 320	java/io/OutputStream:close	()V
    //   1196: aload 22
    //   1198: ifnull +8 -> 1206
    //   1201: aload 22
    //   1203: invokevirtual 321	java/io/InputStream:close	()V
    //   1206: iload 6
    //   1208: istore 7
    //   1210: iconst_0
    //   1211: ifeq +423 -> 1634
    //   1214: new 312	java/lang/NullPointerException
    //   1217: dup
    //   1218: invokespecial 313	java/lang/NullPointerException:<init>	()V
    //   1221: athrow
    //   1222: invokestatic 264	android/os/SystemClock:uptimeMillis	()J
    //   1225: lstore 11
    //   1227: iload_1
    //   1228: istore 6
    //   1230: invokestatic 51	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   1233: ifeq -1190 -> 43
    //   1236: ldc 20
    //   1238: iconst_0
    //   1239: new 53	java/lang/StringBuilder
    //   1242: dup
    //   1243: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   1246: ldc_w 323
    //   1249: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1252: aload_0
    //   1253: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1256: ldc_w 325
    //   1259: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1262: lload 11
    //   1264: lload 13
    //   1266: lsub
    //   1267: invokevirtual 149	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1270: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1273: invokestatic 96	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1276: iload_1
    //   1277: istore 6
    //   1279: goto -1236 -> 43
    //   1282: astore_0
    //   1283: ldc 2
    //   1285: monitorexit
    //   1286: aload_0
    //   1287: athrow
    //   1288: iconst_1
    //   1289: istore 8
    //   1291: iconst_1
    //   1292: istore 7
    //   1294: aload 15
    //   1296: astore 22
    //   1298: aload 16
    //   1300: astore 23
    //   1302: iload 7
    //   1304: istore 6
    //   1306: aload 15
    //   1308: astore 18
    //   1310: aload 16
    //   1312: astore 20
    //   1314: aload 24
    //   1316: astore 21
    //   1318: iload 8
    //   1320: istore_1
    //   1321: aload 15
    //   1323: astore 17
    //   1325: aload 16
    //   1327: astore 19
    //   1329: invokestatic 51	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   1332: ifeq -146 -> 1186
    //   1335: aload 15
    //   1337: astore 18
    //   1339: aload 16
    //   1341: astore 20
    //   1343: aload 24
    //   1345: astore 21
    //   1347: iload 8
    //   1349: istore_1
    //   1350: aload 15
    //   1352: astore 17
    //   1354: aload 16
    //   1356: astore 19
    //   1358: ldc 20
    //   1360: iconst_0
    //   1361: new 53	java/lang/StringBuilder
    //   1364: dup
    //   1365: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   1368: ldc_w 327
    //   1371: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1374: aload_0
    //   1375: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1378: ldc_w 329
    //   1381: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1384: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1387: invokestatic 96	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1390: aload 15
    //   1392: astore 22
    //   1394: aload 16
    //   1396: astore 23
    //   1398: iload 7
    //   1400: istore 6
    //   1402: goto -216 -> 1186
    //   1405: astore 15
    //   1407: aload 18
    //   1409: astore 17
    //   1411: aload 20
    //   1413: astore 19
    //   1415: invokestatic 51	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   1418: ifeq +21 -> 1439
    //   1421: aload 18
    //   1423: astore 17
    //   1425: aload 20
    //   1427: astore 19
    //   1429: ldc 20
    //   1431: iconst_0
    //   1432: aload 21
    //   1434: aload 15
    //   1436: invokestatic 332	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   1439: aload 18
    //   1441: astore 17
    //   1443: aload 20
    //   1445: astore 19
    //   1447: invokestatic 51	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   1450: ifeq +41 -> 1491
    //   1453: aload 18
    //   1455: astore 17
    //   1457: aload 20
    //   1459: astore 19
    //   1461: ldc 20
    //   1463: iconst_0
    //   1464: new 53	java/lang/StringBuilder
    //   1467: dup
    //   1468: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   1471: ldc_w 334
    //   1474: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1477: aload 15
    //   1479: invokevirtual 335	java/io/IOException:toString	()Ljava/lang/String;
    //   1482: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1485: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1488: invokestatic 96	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1491: aload 18
    //   1493: astore 17
    //   1495: aload 20
    //   1497: astore 19
    //   1499: sipush 10102
    //   1502: putstatic 35	com/tencent/TMG/utils/SoUtil:extractSoError	I
    //   1505: aload 20
    //   1507: ifnull +8 -> 1515
    //   1510: aload 20
    //   1512: invokevirtual 320	java/io/OutputStream:close	()V
    //   1515: aload 18
    //   1517: ifnull +8 -> 1525
    //   1520: aload 18
    //   1522: invokevirtual 321	java/io/InputStream:close	()V
    //   1525: iload_1
    //   1526: istore 7
    //   1528: iconst_0
    //   1529: ifeq +105 -> 1634
    //   1532: new 312	java/lang/NullPointerException
    //   1535: dup
    //   1536: invokespecial 313	java/lang/NullPointerException:<init>	()V
    //   1539: athrow
    //   1540: astore 15
    //   1542: iload 6
    //   1544: istore_1
    //   1545: goto -323 -> 1222
    //   1548: astore 15
    //   1550: goto -328 -> 1222
    //   1553: astore_0
    //   1554: aload 19
    //   1556: ifnull +8 -> 1564
    //   1559: aload 19
    //   1561: invokevirtual 320	java/io/OutputStream:close	()V
    //   1564: aload 17
    //   1566: ifnull +8 -> 1574
    //   1569: aload 17
    //   1571: invokevirtual 321	java/io/InputStream:close	()V
    //   1574: iconst_0
    //   1575: ifeq +11 -> 1586
    //   1578: new 312	java/lang/NullPointerException
    //   1581: dup
    //   1582: invokespecial 313	java/lang/NullPointerException:<init>	()V
    //   1585: athrow
    //   1586: aload_0
    //   1587: athrow
    //   1588: astore 15
    //   1590: goto -394 -> 1196
    //   1593: astore 15
    //   1595: goto -389 -> 1206
    //   1598: astore 15
    //   1600: goto -85 -> 1515
    //   1603: astore 15
    //   1605: goto -80 -> 1525
    //   1608: astore 15
    //   1610: goto -46 -> 1564
    //   1613: astore 15
    //   1615: goto -41 -> 1574
    //   1618: astore 15
    //   1620: goto -34 -> 1586
    //   1623: astore 15
    //   1625: iload_3
    //   1626: istore_2
    //   1627: aload 16
    //   1629: astore 15
    //   1631: goto +22 -> 1653
    //   1634: iload 7
    //   1636: istore_1
    //   1637: goto -415 -> 1222
    //   1640: iconst_1
    //   1641: istore 6
    //   1643: goto -1600 -> 43
    //   1646: astore 15
    //   1648: iconst_0
    //   1649: istore_2
    //   1650: aconst_null
    //   1651: astore 15
    //   1653: iconst_1
    //   1654: istore 7
    //   1656: goto -1052 -> 604
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1659	0	paramString	String
    //   0	1659	1	paramBoolean	boolean
    //   22	1628	2	i	int
    //   20	1606	3	j	int
    //   445	104	4	k	int
    //   448	154	5	m	int
    //   4	1638	6	bool1	boolean
    //   10	1645	7	bool2	boolean
    //   7	1341	8	bool3	boolean
    //   13	581	9	bool4	boolean
    //   33	3	10	bool5	boolean
    //   702	561	11	l1	long
    //   113	1152	13	l2	long
    //   147	1244	15	localObject1	Object
    //   1405	73	15	localIOException1	java.io.IOException
    //   1540	1	15	localIOException2	java.io.IOException
    //   1548	1	15	localIOException3	java.io.IOException
    //   1588	1	15	localIOException4	java.io.IOException
    //   1593	1	15	localIOException5	java.io.IOException
    //   1598	1	15	localIOException6	java.io.IOException
    //   1603	1	15	localIOException7	java.io.IOException
    //   1608	1	15	localIOException8	java.io.IOException
    //   1613	1	15	localIOException9	java.io.IOException
    //   1618	1	15	localIOException10	java.io.IOException
    //   1623	1	15	localFileNotFoundException1	java.io.FileNotFoundException
    //   1629	1	15	localObject2	Object
    //   1646	1	15	localFileNotFoundException2	java.io.FileNotFoundException
    //   1651	1	15	localObject3	Object
    //   144	1484	16	localObject4	Object
    //   169	1401	17	localObject5	Object
    //   154	1367	18	localObject6	Object
    //   173	1387	19	localObject7	Object
    //   158	1353	20	localObject8	Object
    //   162	1271	21	str1	String
    //   150	1243	22	localObject9	Object
    //   184	1213	23	localObject10	Object
    //   17	1327	24	str2	String
    //   135	516	25	localObject11	Object
    //   138	528	26	localObject12	Object
    //   141	497	27	localObject13	Object
    //   132	493	28	localObject14	Object
    //   78	967	29	localFile	File
    //   26	655	30	str3	String
    // Exception table:
    //   from	to	target	type
    //   23	35	1282	finally
    //   49	80	1282	finally
    //   84	107	1282	finally
    //   110	127	1282	finally
    //   1191	1196	1282	finally
    //   1201	1206	1282	finally
    //   1214	1222	1282	finally
    //   1222	1227	1282	finally
    //   1230	1276	1282	finally
    //   1510	1515	1282	finally
    //   1520	1525	1282	finally
    //   1532	1540	1282	finally
    //   1559	1564	1282	finally
    //   1569	1574	1282	finally
    //   1578	1586	1282	finally
    //   1586	1588	1282	finally
    //   175	186	1405	java/io/IOException
    //   209	217	1405	java/io/IOException
    //   240	247	1405	java/io/IOException
    //   279	285	1405	java/io/IOException
    //   308	343	1405	java/io/IOException
    //   366	400	1405	java/io/IOException
    //   431	444	1405	java/io/IOException
    //   476	482	1405	java/io/IOException
    //   519	525	1405	java/io/IOException
    //   551	593	1405	java/io/IOException
    //   669	701	1405	java/io/IOException
    //   727	734	1405	java/io/IOException
    //   762	774	1405	java/io/IOException
    //   802	811	1405	java/io/IOException
    //   848	852	1405	java/io/IOException
    //   875	883	1405	java/io/IOException
    //   906	912	1405	java/io/IOException
    //   935	944	1405	java/io/IOException
    //   979	987	1405	java/io/IOException
    //   1010	1021	1405	java/io/IOException
    //   1044	1050	1405	java/io/IOException
    //   1073	1096	1405	java/io/IOException
    //   1137	1143	1405	java/io/IOException
    //   1166	1174	1405	java/io/IOException
    //   1329	1335	1405	java/io/IOException
    //   1358	1390	1405	java/io/IOException
    //   1214	1222	1540	java/io/IOException
    //   1532	1540	1548	java/io/IOException
    //   175	186	1553	finally
    //   209	217	1553	finally
    //   240	247	1553	finally
    //   279	285	1553	finally
    //   308	343	1553	finally
    //   366	400	1553	finally
    //   431	444	1553	finally
    //   476	482	1553	finally
    //   519	525	1553	finally
    //   551	593	1553	finally
    //   669	701	1553	finally
    //   727	734	1553	finally
    //   762	774	1553	finally
    //   802	811	1553	finally
    //   848	852	1553	finally
    //   875	883	1553	finally
    //   906	912	1553	finally
    //   935	944	1553	finally
    //   979	987	1553	finally
    //   1010	1021	1553	finally
    //   1044	1050	1553	finally
    //   1073	1096	1553	finally
    //   1137	1143	1553	finally
    //   1166	1174	1553	finally
    //   1329	1335	1553	finally
    //   1358	1390	1553	finally
    //   1415	1421	1553	finally
    //   1429	1439	1553	finally
    //   1447	1453	1553	finally
    //   1461	1491	1553	finally
    //   1499	1505	1553	finally
    //   1191	1196	1588	java/io/IOException
    //   1201	1206	1593	java/io/IOException
    //   1510	1515	1598	java/io/IOException
    //   1520	1525	1603	java/io/IOException
    //   1559	1564	1608	java/io/IOException
    //   1569	1574	1613	java/io/IOException
    //   1578	1586	1618	java/io/IOException
    //   431	444	1623	java/io/FileNotFoundException
    //   476	482	1623	java/io/FileNotFoundException
    //   519	525	1623	java/io/FileNotFoundException
    //   551	593	1623	java/io/FileNotFoundException
    //   279	285	1646	java/io/FileNotFoundException
    //   308	343	1646	java/io/FileNotFoundException
    //   366	400	1646	java/io/FileNotFoundException
  }
  
  public static Context getAppContext()
  {
    return ctx;
  }
  
  private static long getAvailableInternalMemorySize()
  {
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    long l = localStatFs.getBlockSize();
    return localStatFs.getAvailableBlocks() * l;
  }
  
  public static boolean getCopySoInfo()
  {
    return copySoFromAssets;
  }
  
  private static String getLibActualName(String paramString)
  {
    return "lib" + paramString + ".so";
  }
  
  private static String getLibPath()
  {
    return "lib/armeabi/";
  }
  
  private static String getTxlibPath()
  {
    File localFile = ctx.getFilesDir();
    if (localFile == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SoUtil", 0, "getFilesDir is null");
      }
      return "";
    }
    return localFile.getParent() + "/txav/";
  }
  
  public static boolean loadSo(String paramString)
  {
    if (customLibPath != null) {}
    while ((getCopySoInfo()) && (LoadExtractedSo(paramString))) {
      try
      {
        System.load(customLibPath + "/lib" + paramString + ".so");
        return true;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SoUtil", 0, "loadSo from customLibPath(" + customLibPath + ") failed: " + localUnsatisfiedLinkError1.getMessage());
        }
      }
    }
    try
    {
      System.loadLibrary(paramString);
      return true;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SoUtil", 0, "loadSo from APP Path failed: " + localUnsatisfiedLinkError2.getMessage());
      }
      try
      {
        System.load("/system/lib/lib" + paramString + ".so");
        return true;
      }
      catch (UnsatisfiedLinkError paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SoUtil", 0, "loadSo from System Path failed: " + paramString.getMessage());
        }
      }
    }
    return false;
  }
  
  public static void releaseAppContext()
  {
    ctx = null;
  }
  
  public static void setAppContext(Context paramContext)
  {
    ctx = paramContext;
  }
  
  public static void setCopySoInfo(boolean paramBoolean)
  {
    copySoFromAssets = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.TMG.utils.SoUtil
 * JD-Core Version:    0.7.0.1
 */