package com.tencent.TMG.utils;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;

public class SoUtil
{
  private static final String KEY_APK_SIZE = "key_apk_size";
  private static final String KEY_APK_UPDATE_TIME = "key_apk_update_time";
  private static final String KEY_APP_VERSION = "key_app_version";
  private static final String SO_SP = "so_sp";
  private static final String TAG = "SoUtil";
  private static boolean copySoFromAssets = false;
  private static Context ctx;
  public static String customLibPath;
  private static int extractSoError;
  
  public static boolean LoadExtractedSo(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start LoadExtractedSo: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("SoUtil", 0, ((StringBuilder)localObject).toString());
    }
    for (;;)
    {
      try
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(ctx.getFilesDir().getParent());
        ((StringBuilder)localObject).append("/txav/");
        ((StringBuilder)localObject).append(getLibActualName(paramString));
        System.load(((StringBuilder)localObject).toString());
        bool1 = true;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
      {
        continue;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(ctx.getFilesDir().getParent());
      ((StringBuilder)localObject).append("/txav/");
      ((StringBuilder)localObject).append(getLibActualName(paramString));
      localObject = new File(((StringBuilder)localObject).toString());
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      extractLibraryFromAssert(paramString, true);
      try
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(ctx.getFilesDir().getParent());
        ((StringBuilder)localObject).append("/txav/");
        ((StringBuilder)localObject).append(getLibActualName(paramString));
        System.load(((StringBuilder)localObject).toString());
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError2) {}
    }
    bool1 = false;
    bool2 = bool1;
    if (!bool1) {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("finally try to use system way to load so: ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("SoUtil", 0, ((StringBuilder)localObject).toString());
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
        bool2 = bool1;
      }
    }
    if (!bool2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("LoadExtractedSo failed: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("SoUtil", 1, ((StringBuilder)localObject).toString());
    }
    return bool2;
  }
  
  /* Error */
  public static int extractAVModulesFromAssets()
  {
    // Byte code:
    //   0: getstatic 63	com/tencent/TMG/utils/SoUtil:ctx	Landroid/content/Context;
    //   3: ldc 17
    //   5: iconst_0
    //   6: invokevirtual 119	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   9: astore 12
    //   11: getstatic 63	com/tencent/TMG/utils/SoUtil:ctx	Landroid/content/Context;
    //   14: invokevirtual 123	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   17: astore 13
    //   19: ldc 125
    //   21: astore 10
    //   23: aload 12
    //   25: ldc 14
    //   27: ldc 125
    //   29: invokeinterface 131 3 0
    //   34: astore 11
    //   36: aload 12
    //   38: ldc 8
    //   40: ldc2_w 132
    //   43: invokeinterface 137 4 0
    //   48: lstore 4
    //   50: aload 12
    //   52: ldc 11
    //   54: ldc2_w 132
    //   57: invokeinterface 137 4 0
    //   62: lstore 6
    //   64: invokestatic 44	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   67: ifeq +71 -> 138
    //   70: new 46	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   77: astore 14
    //   79: aload 14
    //   81: ldc 139
    //   83: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload 14
    //   89: aload 11
    //   91: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload 14
    //   97: ldc 141
    //   99: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload 14
    //   105: lload 4
    //   107: invokevirtual 144	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload 14
    //   113: ldc 146
    //   115: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload 14
    //   121: lload 6
    //   123: invokevirtual 144	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: ldc 20
    //   129: iconst_0
    //   130: aload 14
    //   132: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 103	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   138: aload 13
    //   140: getstatic 63	com/tencent/TMG/utils/SoUtil:ctx	Landroid/content/Context;
    //   143: invokevirtual 149	android/content/Context:getPackageName	()Ljava/lang/String;
    //   146: iconst_0
    //   147: invokevirtual 155	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   150: astore 14
    //   152: aload 13
    //   154: getstatic 63	com/tencent/TMG/utils/SoUtil:ctx	Landroid/content/Context;
    //   157: invokevirtual 149	android/content/Context:getPackageName	()Ljava/lang/String;
    //   160: iconst_0
    //   161: invokevirtual 159	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   164: astore 13
    //   166: new 71	java/io/File
    //   169: dup
    //   170: aload 14
    //   172: getfield 164	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   175: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   178: astore 14
    //   180: aload 14
    //   182: invokevirtual 91	java/io/File:exists	()Z
    //   185: istore 8
    //   187: iload 8
    //   189: ifeq +35 -> 224
    //   192: aload 14
    //   194: invokevirtual 168	java/io/File:length	()J
    //   197: lstore_0
    //   198: aload 14
    //   200: invokevirtual 171	java/io/File:lastModified	()J
    //   203: lstore_2
    //   204: goto +28 -> 232
    //   207: astore 11
    //   209: iconst_1
    //   210: istore 8
    //   212: ldc2_w 132
    //   215: lstore_2
    //   216: goto +271 -> 487
    //   219: astore 11
    //   221: goto +255 -> 476
    //   224: ldc2_w 132
    //   227: lstore_2
    //   228: ldc2_w 132
    //   231: lstore_0
    //   232: aload 13
    //   234: ifnull +69 -> 303
    //   237: new 46	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   244: astore 14
    //   246: aload 14
    //   248: aload 13
    //   250: getfield 176	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   253: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload 14
    //   259: ldc 178
    //   261: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: aload 14
    //   267: aload 13
    //   269: getfield 181	android/content/pm/PackageInfo:versionCode	I
    //   272: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: aload 14
    //   278: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: astore 10
    //   283: goto +20 -> 303
    //   286: astore 11
    //   288: ldc 125
    //   290: astore 10
    //   292: goto +5 -> 297
    //   295: astore 11
    //   297: iconst_1
    //   298: istore 8
    //   300: goto +187 -> 487
    //   303: lload_0
    //   304: lload 4
    //   306: lcmp
    //   307: ifne +35 -> 342
    //   310: aload 11
    //   312: aload 10
    //   314: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   317: istore 8
    //   319: iload 8
    //   321: ifeq +21 -> 342
    //   324: lload_2
    //   325: lload 6
    //   327: lcmp
    //   328: ifne +14 -> 342
    //   331: iconst_0
    //   332: istore 8
    //   334: goto +11 -> 345
    //   337: astore 11
    //   339: goto -42 -> 297
    //   342: iconst_1
    //   343: istore 8
    //   345: lload_2
    //   346: lstore 6
    //   348: aload 10
    //   350: astore 11
    //   352: iload 8
    //   354: istore 9
    //   356: lload_0
    //   357: lstore 4
    //   359: invokestatic 44	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   362: ifeq +144 -> 506
    //   365: new 46	java/lang/StringBuilder
    //   368: dup
    //   369: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   372: astore 11
    //   374: aload 11
    //   376: ldc 192
    //   378: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: pop
    //   382: aload 11
    //   384: aload 10
    //   386: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: pop
    //   390: aload 11
    //   392: ldc 194
    //   394: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: aload 11
    //   400: lload_0
    //   401: invokevirtual 144	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   404: pop
    //   405: aload 11
    //   407: ldc 196
    //   409: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: pop
    //   413: aload 11
    //   415: lload_2
    //   416: invokevirtual 144	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   419: pop
    //   420: aload 11
    //   422: ldc 198
    //   424: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: pop
    //   428: aload 11
    //   430: iload 8
    //   432: invokevirtual 201	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   435: pop
    //   436: ldc 20
    //   438: iconst_0
    //   439: aload 11
    //   441: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: invokestatic 103	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   447: lload_2
    //   448: lstore 6
    //   450: aload 10
    //   452: astore 11
    //   454: iload 8
    //   456: istore 9
    //   458: lload_0
    //   459: lstore 4
    //   461: goto +45 -> 506
    //   464: astore 11
    //   466: goto +21 -> 487
    //   469: astore 10
    //   471: goto +219 -> 690
    //   474: astore 11
    //   476: ldc2_w 132
    //   479: lstore_2
    //   480: iconst_1
    //   481: istore 8
    //   483: ldc2_w 132
    //   486: lstore_0
    //   487: aload 11
    //   489: invokevirtual 204	android/content/pm/PackageManager$NameNotFoundException:printStackTrace	()V
    //   492: lload_0
    //   493: lstore 4
    //   495: iload 8
    //   497: istore 9
    //   499: aload 10
    //   501: astore 11
    //   503: lload_2
    //   504: lstore 6
    //   506: ldc 206
    //   508: iload 9
    //   510: invokestatic 98	com/tencent/TMG/utils/SoUtil:extractLibraryFromAssert	(Ljava/lang/String;Z)Z
    //   513: ifeq +173 -> 686
    //   516: ldc 208
    //   518: iload 9
    //   520: invokestatic 98	com/tencent/TMG/utils/SoUtil:extractLibraryFromAssert	(Ljava/lang/String;Z)Z
    //   523: ifeq +163 -> 686
    //   526: ldc 210
    //   528: iload 9
    //   530: invokestatic 98	com/tencent/TMG/utils/SoUtil:extractLibraryFromAssert	(Ljava/lang/String;Z)Z
    //   533: ifeq +153 -> 686
    //   536: ldc 212
    //   538: iload 9
    //   540: invokestatic 98	com/tencent/TMG/utils/SoUtil:extractLibraryFromAssert	(Ljava/lang/String;Z)Z
    //   543: ifeq +143 -> 686
    //   546: ldc 214
    //   548: iload 9
    //   550: invokestatic 98	com/tencent/TMG/utils/SoUtil:extractLibraryFromAssert	(Ljava/lang/String;Z)Z
    //   553: ifeq +133 -> 686
    //   556: ldc 216
    //   558: iload 9
    //   560: invokestatic 98	com/tencent/TMG/utils/SoUtil:extractLibraryFromAssert	(Ljava/lang/String;Z)Z
    //   563: ifeq +123 -> 686
    //   566: ldc 218
    //   568: iload 9
    //   570: invokestatic 98	com/tencent/TMG/utils/SoUtil:extractLibraryFromAssert	(Ljava/lang/String;Z)Z
    //   573: ifeq +113 -> 686
    //   576: ldc 220
    //   578: iload 9
    //   580: invokestatic 98	com/tencent/TMG/utils/SoUtil:extractLibraryFromAssert	(Ljava/lang/String;Z)Z
    //   583: ifeq +103 -> 686
    //   586: ldc 222
    //   588: iload 9
    //   590: invokestatic 98	com/tencent/TMG/utils/SoUtil:extractLibraryFromAssert	(Ljava/lang/String;Z)Z
    //   593: ifeq +93 -> 686
    //   596: aload 11
    //   598: invokestatic 228	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   601: ifne +25 -> 626
    //   604: aload 12
    //   606: invokeinterface 232 1 0
    //   611: ldc 14
    //   613: aload 11
    //   615: invokeinterface 238 3 0
    //   620: invokeinterface 241 1 0
    //   625: pop
    //   626: lload 4
    //   628: lconst_0
    //   629: lcmp
    //   630: ifle +25 -> 655
    //   633: aload 12
    //   635: invokeinterface 232 1 0
    //   640: ldc 8
    //   642: lload 4
    //   644: invokeinterface 245 4 0
    //   649: invokeinterface 241 1 0
    //   654: pop
    //   655: lload 6
    //   657: lconst_0
    //   658: lcmp
    //   659: ifle +25 -> 684
    //   662: aload 12
    //   664: invokeinterface 232 1 0
    //   669: ldc 11
    //   671: lload 6
    //   673: invokeinterface 245 4 0
    //   678: invokeinterface 241 1 0
    //   683: pop
    //   684: iconst_0
    //   685: ireturn
    //   686: getstatic 247	com/tencent/TMG/utils/SoUtil:extractSoError	I
    //   689: ireturn
    //   690: goto +6 -> 696
    //   693: aload 10
    //   695: athrow
    //   696: goto -3 -> 693
    // Local variable table:
    //   start	length	slot	name	signature
    //   197	296	0	l1	long
    //   203	301	2	l2	long
    //   48	595	4	l3	long
    //   62	610	6	l4	long
    //   185	311	8	bool1	boolean
    //   354	235	9	bool2	boolean
    //   21	430	10	str1	String
    //   469	225	10	localObject1	Object
    //   34	56	11	str2	String
    //   207	1	11	localNameNotFoundException1	android.content.pm.PackageManager.NameNotFoundException
    //   219	1	11	localNameNotFoundException2	android.content.pm.PackageManager.NameNotFoundException
    //   286	1	11	localNameNotFoundException3	android.content.pm.PackageManager.NameNotFoundException
    //   295	16	11	localNameNotFoundException4	android.content.pm.PackageManager.NameNotFoundException
    //   337	1	11	localNameNotFoundException5	android.content.pm.PackageManager.NameNotFoundException
    //   350	103	11	localObject2	Object
    //   464	1	11	localNameNotFoundException6	android.content.pm.PackageManager.NameNotFoundException
    //   474	14	11	localNameNotFoundException7	android.content.pm.PackageManager.NameNotFoundException
    //   501	113	11	localObject3	Object
    //   9	654	12	localSharedPreferences	android.content.SharedPreferences
    //   17	251	13	localObject4	Object
    //   77	200	14	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   198	204	207	android/content/pm/PackageManager$NameNotFoundException
    //   192	198	219	android/content/pm/PackageManager$NameNotFoundException
    //   246	283	286	android/content/pm/PackageManager$NameNotFoundException
    //   237	246	295	android/content/pm/PackageManager$NameNotFoundException
    //   310	319	337	android/content/pm/PackageManager$NameNotFoundException
    //   359	447	464	android/content/pm/PackageManager$NameNotFoundException
    //   138	187	469	finally
    //   192	198	469	finally
    //   198	204	469	finally
    //   237	246	469	finally
    //   246	283	469	finally
    //   310	319	469	finally
    //   359	447	469	finally
    //   487	492	469	finally
    //   138	187	474	android/content/pm/PackageManager$NameNotFoundException
  }
  
  /* Error */
  private static boolean extractLibraryFromAssert(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 125
    //   5: astore 17
    //   7: invokestatic 254	com/tencent/TMG/utils/SoUtil:getTxlibPath	()Ljava/lang/String;
    //   10: astore 20
    //   12: aload 20
    //   14: invokestatic 228	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: istore_3
    //   18: iload_3
    //   19: ifeq +8 -> 27
    //   22: ldc 2
    //   24: monitorexit
    //   25: iconst_0
    //   26: ireturn
    //   27: new 46	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   34: astore 11
    //   36: aload 11
    //   38: aload 20
    //   40: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload 11
    //   46: aload_0
    //   47: invokestatic 80	com/tencent/TMG/utils/SoUtil:getLibActualName	(Ljava/lang/String;)Ljava/lang/String;
    //   50: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: new 71	java/io/File
    //   57: dup
    //   58: aload 11
    //   60: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   66: astore 19
    //   68: iconst_1
    //   69: istore 4
    //   71: iload_1
    //   72: ifne +35 -> 107
    //   75: aload 19
    //   77: invokevirtual 91	java/io/File:exists	()Z
    //   80: ifeq +27 -> 107
    //   83: iload 4
    //   85: istore_3
    //   86: invokestatic 44	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   89: ifeq +1300 -> 1389
    //   92: ldc 20
    //   94: iconst_0
    //   95: ldc_w 256
    //   98: invokestatic 103	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   101: iload 4
    //   103: istore_3
    //   104: goto +1285 -> 1389
    //   107: invokestatic 261	android/os/SystemClock:uptimeMillis	()J
    //   110: lstore 5
    //   112: aload 19
    //   114: invokevirtual 94	java/io/File:delete	()Z
    //   117: pop
    //   118: aload 19
    //   120: invokevirtual 91	java/io/File:exists	()Z
    //   123: istore_1
    //   124: iload_1
    //   125: ifne +1327 -> 1452
    //   128: aconst_null
    //   129: astore 13
    //   131: aconst_null
    //   132: astore 14
    //   134: aconst_null
    //   135: astore 16
    //   137: aconst_null
    //   138: astore 15
    //   140: aconst_null
    //   141: astore 18
    //   143: aconst_null
    //   144: astore 12
    //   146: aconst_null
    //   147: astore 11
    //   149: new 71	java/io/File
    //   152: dup
    //   153: aload 20
    //   155: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   158: astore 21
    //   160: aload 21
    //   162: invokevirtual 91	java/io/File:exists	()Z
    //   165: ifne +32 -> 197
    //   168: aload 21
    //   170: invokevirtual 264	java/io/File:mkdir	()Z
    //   173: istore_1
    //   174: iload_1
    //   175: ifeq +6 -> 181
    //   178: goto +19 -> 197
    //   181: aconst_null
    //   182: astore 14
    //   184: lload 5
    //   186: lstore 7
    //   188: aload 11
    //   190: astore 16
    //   192: iconst_0
    //   193: istore_1
    //   194: goto +857 -> 1051
    //   197: invokestatic 44	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   200: ifeq +51 -> 251
    //   203: new 46	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   210: astore 11
    //   212: aload 11
    //   214: ldc_w 266
    //   217: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload 11
    //   223: invokestatic 269	com/tencent/TMG/utils/SoUtil:getLibPath	()Ljava/lang/String;
    //   226: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: pop
    //   230: aload 11
    //   232: aload_0
    //   233: invokestatic 80	com/tencent/TMG/utils/SoUtil:getLibActualName	(Ljava/lang/String;)Ljava/lang/String;
    //   236: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: ldc 20
    //   242: iconst_0
    //   243: aload 11
    //   245: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokestatic 103	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   251: getstatic 63	com/tencent/TMG/utils/SoUtil:ctx	Landroid/content/Context;
    //   254: invokevirtual 273	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   257: astore 11
    //   259: new 46	java/lang/StringBuilder
    //   262: dup
    //   263: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   266: astore 21
    //   268: aload 21
    //   270: invokestatic 269	com/tencent/TMG/utils/SoUtil:getLibPath	()Ljava/lang/String;
    //   273: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload 21
    //   279: aload_0
    //   280: invokestatic 80	com/tencent/TMG/utils/SoUtil:getLibActualName	(Ljava/lang/String;)Ljava/lang/String;
    //   283: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload 11
    //   289: aload 21
    //   291: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: invokevirtual 279	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   297: astore 11
    //   299: invokestatic 282	com/tencent/TMG/utils/SoUtil:getAvailableInternalMemorySize	()J
    //   302: lstore 7
    //   304: aload 11
    //   306: invokevirtual 287	java/io/InputStream:available	()I
    //   309: istore_2
    //   310: lload 7
    //   312: iload_2
    //   313: i2l
    //   314: lcmp
    //   315: ifge +83 -> 398
    //   318: sipush 10101
    //   321: putstatic 247	com/tencent/TMG/utils/SoUtil:extractSoError	I
    //   324: invokestatic 44	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   327: ifeq +61 -> 388
    //   330: new 46	java/lang/StringBuilder
    //   333: dup
    //   334: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   337: astore 21
    //   339: aload 21
    //   341: ldc_w 289
    //   344: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: pop
    //   348: aload 21
    //   350: invokestatic 282	com/tencent/TMG/utils/SoUtil:getAvailableInternalMemorySize	()J
    //   353: invokevirtual 144	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   356: pop
    //   357: aload 21
    //   359: ldc_w 291
    //   362: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: aload 21
    //   368: aload 11
    //   370: invokevirtual 287	java/io/InputStream:available	()I
    //   373: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   376: pop
    //   377: ldc 20
    //   379: iconst_0
    //   380: aload 21
    //   382: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   385: invokestatic 103	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   388: iconst_1
    //   389: istore_2
    //   390: goto +10 -> 400
    //   393: iconst_1
    //   394: istore_2
    //   395: goto +48 -> 443
    //   398: iconst_0
    //   399: istore_2
    //   400: iconst_0
    //   401: istore_3
    //   402: aload 11
    //   404: astore 12
    //   406: goto +43 -> 449
    //   409: astore_0
    //   410: aload 12
    //   412: astore 13
    //   414: aload 11
    //   416: astore 15
    //   418: goto +875 -> 1293
    //   421: astore 13
    //   423: aload 11
    //   425: astore 12
    //   427: aload 17
    //   429: astore 14
    //   431: aload 15
    //   433: astore 11
    //   435: goto +688 -> 1123
    //   438: aconst_null
    //   439: astore 11
    //   441: iconst_0
    //   442: istore_2
    //   443: iconst_1
    //   444: istore_3
    //   445: aload 11
    //   447: astore 12
    //   449: iload_2
    //   450: ifne +591 -> 1041
    //   453: iload_3
    //   454: ifne +587 -> 1041
    //   457: aload 13
    //   459: astore 11
    //   461: aload 12
    //   463: ifnull +109 -> 572
    //   466: lload 5
    //   468: lstore 7
    //   470: aload 14
    //   472: astore 16
    //   474: aload 18
    //   476: astore 13
    //   478: aload 12
    //   480: astore 15
    //   482: new 46	java/lang/StringBuilder
    //   485: dup
    //   486: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   489: astore 11
    //   491: lload 5
    //   493: lstore 7
    //   495: aload 14
    //   497: astore 16
    //   499: aload 18
    //   501: astore 13
    //   503: aload 12
    //   505: astore 15
    //   507: aload 11
    //   509: aload 20
    //   511: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: pop
    //   515: lload 5
    //   517: lstore 7
    //   519: aload 14
    //   521: astore 16
    //   523: aload 18
    //   525: astore 13
    //   527: aload 12
    //   529: astore 15
    //   531: aload 11
    //   533: aload_0
    //   534: invokestatic 80	com/tencent/TMG/utils/SoUtil:getLibActualName	(Ljava/lang/String;)Ljava/lang/String;
    //   537: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: pop
    //   541: lload 5
    //   543: lstore 7
    //   545: aload 14
    //   547: astore 16
    //   549: aload 18
    //   551: astore 13
    //   553: aload 12
    //   555: astore 15
    //   557: new 293	java/io/FileOutputStream
    //   560: dup
    //   561: aload 11
    //   563: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   566: iconst_1
    //   567: invokespecial 296	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   570: astore 11
    //   572: lconst_0
    //   573: lstore 9
    //   575: lload 5
    //   577: lstore 7
    //   579: aload 11
    //   581: astore 16
    //   583: aload 11
    //   585: astore 13
    //   587: aload 12
    //   589: astore 15
    //   591: ldc_w 297
    //   594: newarray byte
    //   596: astore 14
    //   598: aload 12
    //   600: ifnull +71 -> 671
    //   603: lload 5
    //   605: lstore 7
    //   607: aload 11
    //   609: astore 16
    //   611: aload 11
    //   613: astore 13
    //   615: aload 12
    //   617: astore 15
    //   619: aload 12
    //   621: aload 14
    //   623: iconst_0
    //   624: aload 14
    //   626: arraylength
    //   627: invokevirtual 301	java/io/InputStream:read	([BII)I
    //   630: istore_2
    //   631: iload_2
    //   632: iconst_m1
    //   633: if_icmpeq +38 -> 671
    //   636: lload 5
    //   638: lstore 7
    //   640: aload 11
    //   642: astore 16
    //   644: aload 11
    //   646: astore 13
    //   648: aload 12
    //   650: astore 15
    //   652: aload 11
    //   654: aload 14
    //   656: iconst_0
    //   657: iload_2
    //   658: invokevirtual 307	java/io/OutputStream:write	([BII)V
    //   661: lload 9
    //   663: iload_2
    //   664: i2l
    //   665: ladd
    //   666: lstore 9
    //   668: goto -70 -> 598
    //   671: aload 11
    //   673: astore 13
    //   675: aload 12
    //   677: astore 15
    //   679: invokestatic 44	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   682: ifeq +20 -> 702
    //   685: aload 11
    //   687: astore 13
    //   689: aload 12
    //   691: astore 15
    //   693: ldc 20
    //   695: iconst_0
    //   696: ldc_w 309
    //   699: invokestatic 103	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   702: aload 11
    //   704: astore 16
    //   706: iload_3
    //   707: istore_1
    //   708: aload 12
    //   710: astore 14
    //   712: lload 5
    //   714: lstore 7
    //   716: aload 11
    //   718: astore 13
    //   720: aload 12
    //   722: astore 15
    //   724: aload 19
    //   726: invokevirtual 91	java/io/File:exists	()Z
    //   729: ifeq +322 -> 1051
    //   732: aload 11
    //   734: astore 13
    //   736: aload 12
    //   738: astore 15
    //   740: lload 9
    //   742: aload 19
    //   744: invokevirtual 168	java/io/File:length	()J
    //   747: lcmp
    //   748: ifeq +148 -> 896
    //   751: aload 11
    //   753: astore 13
    //   755: aload 12
    //   757: astore 15
    //   759: aload 19
    //   761: invokevirtual 94	java/io/File:delete	()Z
    //   764: pop
    //   765: aload 11
    //   767: astore 13
    //   769: aload 12
    //   771: astore 15
    //   773: new 46	java/lang/StringBuilder
    //   776: dup
    //   777: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   780: astore 14
    //   782: aload 11
    //   784: astore 13
    //   786: aload 12
    //   788: astore 15
    //   790: aload 14
    //   792: ldc 125
    //   794: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   797: pop
    //   798: aload 11
    //   800: astore 13
    //   802: aload 12
    //   804: astore 15
    //   806: aload 14
    //   808: ldc_w 311
    //   811: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: pop
    //   815: aload 11
    //   817: astore 13
    //   819: aload 12
    //   821: astore 15
    //   823: aload 14
    //   825: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   828: astore 18
    //   830: aload 11
    //   832: astore 16
    //   834: aload 12
    //   836: astore 14
    //   838: lload 5
    //   840: lstore 7
    //   842: aload 11
    //   844: astore 13
    //   846: aload 12
    //   848: astore 15
    //   850: invokestatic 44	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   853: ifeq -661 -> 192
    //   856: aload 11
    //   858: astore 13
    //   860: aload 12
    //   862: astore 15
    //   864: ldc 20
    //   866: iconst_0
    //   867: aload 18
    //   869: invokestatic 103	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   872: aload 11
    //   874: astore 16
    //   876: aload 12
    //   878: astore 14
    //   880: lload 5
    //   882: lstore 7
    //   884: goto -692 -> 192
    //   887: astore 13
    //   889: aload 18
    //   891: astore 14
    //   893: goto +230 -> 1123
    //   896: aload 11
    //   898: astore 13
    //   900: aload 12
    //   902: astore 15
    //   904: invokestatic 44	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   907: ifeq +88 -> 995
    //   910: aload 11
    //   912: astore 13
    //   914: aload 12
    //   916: astore 15
    //   918: new 46	java/lang/StringBuilder
    //   921: dup
    //   922: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   925: astore 14
    //   927: aload 11
    //   929: astore 13
    //   931: aload 12
    //   933: astore 15
    //   935: aload 14
    //   937: ldc_w 313
    //   940: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   943: pop
    //   944: aload 11
    //   946: astore 13
    //   948: aload 12
    //   950: astore 15
    //   952: aload 14
    //   954: aload_0
    //   955: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   958: pop
    //   959: aload 11
    //   961: astore 13
    //   963: aload 12
    //   965: astore 15
    //   967: aload 14
    //   969: ldc_w 315
    //   972: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   975: pop
    //   976: aload 11
    //   978: astore 13
    //   980: aload 12
    //   982: astore 15
    //   984: ldc 20
    //   986: iconst_0
    //   987: aload 14
    //   989: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   992: invokestatic 103	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   995: iconst_1
    //   996: istore_1
    //   997: aload 11
    //   999: astore 16
    //   1001: aload 12
    //   1003: astore 14
    //   1005: lload 5
    //   1007: lstore 7
    //   1009: goto +42 -> 1051
    //   1012: astore 14
    //   1014: iconst_1
    //   1015: istore_1
    //   1016: goto +117 -> 1133
    //   1019: astore 14
    //   1021: iload_3
    //   1022: istore_1
    //   1023: goto +110 -> 1133
    //   1026: astore 14
    //   1028: lload 7
    //   1030: lstore 5
    //   1032: aload 16
    //   1034: astore 11
    //   1036: iload_3
    //   1037: istore_1
    //   1038: goto +95 -> 1133
    //   1041: lload 5
    //   1043: lstore 7
    //   1045: aload 12
    //   1047: astore 14
    //   1049: iload_3
    //   1050: istore_1
    //   1051: aload 16
    //   1053: ifnull +11 -> 1064
    //   1056: aload 16
    //   1058: invokevirtual 318	java/io/OutputStream:close	()V
    //   1061: goto +3 -> 1064
    //   1064: iload_1
    //   1065: istore_3
    //   1066: lload 7
    //   1068: lstore 9
    //   1070: aload 14
    //   1072: ifnull +22 -> 1094
    //   1075: lload 7
    //   1077: lstore 5
    //   1079: aload 14
    //   1081: astore 12
    //   1083: aload 12
    //   1085: invokevirtual 319	java/io/InputStream:close	()V
    //   1088: lload 5
    //   1090: lstore 9
    //   1092: iload_1
    //   1093: istore_3
    //   1094: iload_3
    //   1095: istore_1
    //   1096: goto +222 -> 1318
    //   1099: astore_0
    //   1100: aconst_null
    //   1101: astore 15
    //   1103: aload 12
    //   1105: astore 13
    //   1107: goto +186 -> 1293
    //   1110: astore 13
    //   1112: aconst_null
    //   1113: astore 12
    //   1115: aload 15
    //   1117: astore 11
    //   1119: aload 17
    //   1121: astore 14
    //   1123: iconst_0
    //   1124: istore_1
    //   1125: aload 14
    //   1127: astore 17
    //   1129: aload 13
    //   1131: astore 14
    //   1133: aload 11
    //   1135: astore 13
    //   1137: aload 12
    //   1139: astore 15
    //   1141: invokestatic 44	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   1144: ifeq +21 -> 1165
    //   1147: aload 11
    //   1149: astore 13
    //   1151: aload 12
    //   1153: astore 15
    //   1155: ldc 20
    //   1157: iconst_0
    //   1158: aload 17
    //   1160: aload 14
    //   1162: invokestatic 322	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   1165: aload 11
    //   1167: astore 13
    //   1169: aload 12
    //   1171: astore 15
    //   1173: invokestatic 44	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   1176: ifeq +75 -> 1251
    //   1179: aload 11
    //   1181: astore 13
    //   1183: aload 12
    //   1185: astore 15
    //   1187: new 46	java/lang/StringBuilder
    //   1190: dup
    //   1191: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   1194: astore 16
    //   1196: aload 11
    //   1198: astore 13
    //   1200: aload 12
    //   1202: astore 15
    //   1204: aload 16
    //   1206: ldc_w 324
    //   1209: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1212: pop
    //   1213: aload 11
    //   1215: astore 13
    //   1217: aload 12
    //   1219: astore 15
    //   1221: aload 16
    //   1223: aload 14
    //   1225: invokevirtual 325	java/io/IOException:toString	()Ljava/lang/String;
    //   1228: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1231: pop
    //   1232: aload 11
    //   1234: astore 13
    //   1236: aload 12
    //   1238: astore 15
    //   1240: ldc 20
    //   1242: iconst_0
    //   1243: aload 16
    //   1245: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1248: invokestatic 103	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1251: aload 11
    //   1253: astore 13
    //   1255: aload 12
    //   1257: astore 15
    //   1259: sipush 10102
    //   1262: putstatic 247	com/tencent/TMG/utils/SoUtil:extractSoError	I
    //   1265: aload 11
    //   1267: ifnull +11 -> 1278
    //   1270: aload 11
    //   1272: invokevirtual 318	java/io/OutputStream:close	()V
    //   1275: goto +3 -> 1278
    //   1278: iload_1
    //   1279: istore_3
    //   1280: lload 5
    //   1282: lstore 9
    //   1284: aload 12
    //   1286: ifnull -192 -> 1094
    //   1289: goto -206 -> 1083
    //   1292: astore_0
    //   1293: aload 13
    //   1295: ifnull +11 -> 1306
    //   1298: aload 13
    //   1300: invokevirtual 318	java/io/OutputStream:close	()V
    //   1303: goto +3 -> 1306
    //   1306: aload 15
    //   1308: ifnull +8 -> 1316
    //   1311: aload 15
    //   1313: invokevirtual 319	java/io/InputStream:close	()V
    //   1316: aload_0
    //   1317: athrow
    //   1318: invokestatic 261	android/os/SystemClock:uptimeMillis	()J
    //   1321: lstore 5
    //   1323: iload_1
    //   1324: istore_3
    //   1325: invokestatic 44	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   1328: ifeq +61 -> 1389
    //   1331: new 46	java/lang/StringBuilder
    //   1334: dup
    //   1335: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   1338: astore 11
    //   1340: aload 11
    //   1342: ldc_w 327
    //   1345: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1348: pop
    //   1349: aload 11
    //   1351: aload_0
    //   1352: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1355: pop
    //   1356: aload 11
    //   1358: ldc_w 329
    //   1361: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1364: pop
    //   1365: aload 11
    //   1367: lload 5
    //   1369: lload 9
    //   1371: lsub
    //   1372: invokevirtual 144	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1375: pop
    //   1376: ldc 20
    //   1378: iconst_0
    //   1379: aload 11
    //   1381: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1384: invokestatic 103	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1387: iload_1
    //   1388: istore_3
    //   1389: ldc 2
    //   1391: monitorexit
    //   1392: iload_3
    //   1393: ireturn
    //   1394: astore_0
    //   1395: ldc 2
    //   1397: monitorexit
    //   1398: goto +5 -> 1403
    //   1401: aload_0
    //   1402: athrow
    //   1403: goto -2 -> 1401
    //   1406: astore 11
    //   1408: goto -970 -> 438
    //   1411: astore 12
    //   1413: goto -972 -> 441
    //   1416: astore 12
    //   1418: goto -1025 -> 393
    //   1421: astore 11
    //   1423: goto -359 -> 1064
    //   1426: astore 11
    //   1428: iload_1
    //   1429: istore_3
    //   1430: lload 5
    //   1432: lstore 9
    //   1434: goto -340 -> 1094
    //   1437: astore 11
    //   1439: goto -161 -> 1278
    //   1442: astore 11
    //   1444: goto -138 -> 1306
    //   1447: astore 11
    //   1449: goto -133 -> 1316
    //   1452: iconst_0
    //   1453: istore_1
    //   1454: lload 5
    //   1456: lstore 9
    //   1458: goto -140 -> 1318
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1461	0	paramString	String
    //   0	1461	1	paramBoolean	boolean
    //   309	355	2	i	int
    //   17	1413	3	bool1	boolean
    //   69	33	4	bool2	boolean
    //   110	1345	5	l1	long
    //   186	890	7	l2	long
    //   573	884	9	l3	long
    //   34	1346	11	localObject1	Object
    //   1406	1	11	localFileNotFoundException1	java.io.FileNotFoundException
    //   1421	1	11	localIOException1	java.io.IOException
    //   1426	1	11	localIOException2	java.io.IOException
    //   1437	1	11	localIOException3	java.io.IOException
    //   1442	1	11	localIOException4	java.io.IOException
    //   1447	1	11	localIOException5	java.io.IOException
    //   144	1141	12	localObject2	Object
    //   1411	1	12	localFileNotFoundException2	java.io.FileNotFoundException
    //   1416	1	12	localFileNotFoundException3	java.io.FileNotFoundException
    //   129	284	13	localObject3	Object
    //   421	37	13	localIOException6	java.io.IOException
    //   476	383	13	localObject4	Object
    //   887	1	13	localIOException7	java.io.IOException
    //   898	208	13	localObject5	Object
    //   1110	20	13	localIOException8	java.io.IOException
    //   1135	164	13	localObject6	Object
    //   132	872	14	localObject7	Object
    //   1012	1	14	localIOException9	java.io.IOException
    //   1019	1	14	localIOException10	java.io.IOException
    //   1026	1	14	localIOException11	java.io.IOException
    //   1047	177	14	localObject8	Object
    //   138	1174	15	localObject9	Object
    //   135	1109	16	localObject10	Object
    //   5	1154	17	localObject11	Object
    //   141	749	18	str1	String
    //   66	694	19	localFile	File
    //   10	500	20	str2	String
    //   158	223	21	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   299	310	409	finally
    //   318	388	409	finally
    //   299	310	421	java/io/IOException
    //   318	388	421	java/io/IOException
    //   850	856	887	java/io/IOException
    //   864	872	887	java/io/IOException
    //   904	910	1012	java/io/IOException
    //   918	927	1012	java/io/IOException
    //   935	944	1012	java/io/IOException
    //   952	959	1012	java/io/IOException
    //   967	976	1012	java/io/IOException
    //   984	995	1012	java/io/IOException
    //   679	685	1019	java/io/IOException
    //   693	702	1019	java/io/IOException
    //   724	732	1019	java/io/IOException
    //   740	751	1019	java/io/IOException
    //   759	765	1019	java/io/IOException
    //   773	782	1019	java/io/IOException
    //   790	798	1019	java/io/IOException
    //   806	815	1019	java/io/IOException
    //   823	830	1019	java/io/IOException
    //   482	491	1026	java/io/IOException
    //   507	515	1026	java/io/IOException
    //   531	541	1026	java/io/IOException
    //   557	572	1026	java/io/IOException
    //   591	598	1026	java/io/IOException
    //   619	631	1026	java/io/IOException
    //   652	661	1026	java/io/IOException
    //   149	174	1099	finally
    //   197	251	1099	finally
    //   251	299	1099	finally
    //   149	174	1110	java/io/IOException
    //   197	251	1110	java/io/IOException
    //   251	299	1110	java/io/IOException
    //   482	491	1292	finally
    //   507	515	1292	finally
    //   531	541	1292	finally
    //   557	572	1292	finally
    //   591	598	1292	finally
    //   619	631	1292	finally
    //   652	661	1292	finally
    //   679	685	1292	finally
    //   693	702	1292	finally
    //   724	732	1292	finally
    //   740	751	1292	finally
    //   759	765	1292	finally
    //   773	782	1292	finally
    //   790	798	1292	finally
    //   806	815	1292	finally
    //   823	830	1292	finally
    //   850	856	1292	finally
    //   864	872	1292	finally
    //   904	910	1292	finally
    //   918	927	1292	finally
    //   935	944	1292	finally
    //   952	959	1292	finally
    //   967	976	1292	finally
    //   984	995	1292	finally
    //   1141	1147	1292	finally
    //   1155	1165	1292	finally
    //   1173	1179	1292	finally
    //   1187	1196	1292	finally
    //   1204	1213	1292	finally
    //   1221	1232	1292	finally
    //   1240	1251	1292	finally
    //   1259	1265	1292	finally
    //   7	18	1394	finally
    //   27	68	1394	finally
    //   75	83	1394	finally
    //   86	101	1394	finally
    //   107	124	1394	finally
    //   1056	1061	1394	finally
    //   1083	1088	1394	finally
    //   1270	1275	1394	finally
    //   1298	1303	1394	finally
    //   1311	1316	1394	finally
    //   1316	1318	1394	finally
    //   1318	1323	1394	finally
    //   1325	1387	1394	finally
    //   197	251	1406	java/io/FileNotFoundException
    //   251	299	1406	java/io/FileNotFoundException
    //   299	310	1411	java/io/FileNotFoundException
    //   318	388	1416	java/io/FileNotFoundException
    //   1056	1061	1421	java/io/IOException
    //   1083	1088	1426	java/io/IOException
    //   1270	1275	1437	java/io/IOException
    //   1298	1303	1442	java/io/IOException
    //   1311	1316	1447	java/io/IOException
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lib");
    localStringBuilder.append(paramString);
    localStringBuilder.append(".so");
    return localStringBuilder.toString();
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localFile.getParent());
    localStringBuilder.append("/txav/");
    return localStringBuilder.toString();
  }
  
  public static boolean loadSo(String paramString)
  {
    StringBuilder localStringBuilder3;
    if (customLibPath != null) {
      try
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append(customLibPath);
        localStringBuilder1.append("/lib");
        localStringBuilder1.append(paramString);
        localStringBuilder1.append(".so");
        System.load(localStringBuilder1.toString());
        return true;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder3 = new StringBuilder();
          localStringBuilder3.append("loadSo from customLibPath(");
          localStringBuilder3.append(customLibPath);
          localStringBuilder3.append(") failed: ");
          localStringBuilder3.append(localUnsatisfiedLinkError1.getMessage());
          QLog.d("SoUtil", 0, localStringBuilder3.toString());
        }
      }
    }
    if ((getCopySoInfo()) && (LoadExtractedSo(paramString))) {
      return true;
    }
    try
    {
      System.loadLibrary(paramString);
      return true;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder3 = new StringBuilder();
        localStringBuilder3.append("loadSo from APP Path failed: ");
        localStringBuilder3.append(localUnsatisfiedLinkError2.getMessage());
        QLog.d("SoUtil", 0, localStringBuilder3.toString());
      }
      try
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("/system/lib/lib");
        localStringBuilder2.append(paramString);
        localStringBuilder2.append(".so");
        System.load(localStringBuilder2.toString());
        return true;
      }
      catch (UnsatisfiedLinkError paramString)
      {
        StringBuilder localStringBuilder2;
        if (QLog.isColorLevel())
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("loadSo from System Path failed: ");
          localStringBuilder2.append(paramString.getMessage());
          QLog.d("SoUtil", 0, localStringBuilder2.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.utils.SoUtil
 * JD-Core Version:    0.7.0.1
 */