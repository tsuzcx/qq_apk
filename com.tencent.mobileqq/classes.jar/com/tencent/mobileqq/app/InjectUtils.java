package com.tencent.mobileqq.app;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import com.tencent.commonsdk.soload.SoLoadCore;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import zfu;

public class InjectUtils
{
  public static final String SUCCESS = "Success";
  private static final String TAG = "DexLoadOat";
  public static final String[] sExtraDexes = { "classes2.dex", "classes3.dex", "classes4.dex", "classes5.dex", "classes6.dex", "classes7.dex" };
  private static final String[] sExtraJarDexes = { "classes2.jar", "classes3.jar", "classes4.jar", "classes5.jar", "classes6.dex", "classes7.jar" };
  private static final String[] sExtraLibs = { "exlibs.1.jar", "exlibs.2.jar", "exlibs.3.jar", "exlibs.4.jar", "exlibs.5.jar", "exlibs.6.jar" };
  public static final String[] sExtraLibsStartUpClassName = { "Foo", "Foo2", "Foo3", "Foo4", "Foo5", "Foo6" };
  private static boolean sIsART;
  public static boolean sSpaceNoEnough;
  private static String sVmVersion;
  
  public static long copy(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    long l = 0L;
    byte[] arrayOfByte = new byte[8192];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte, 0, arrayOfByte.length);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
      l += i;
    }
    return l;
  }
  
  /* Error */
  private static String extractLib(Application paramApplication, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 7
    //   6: ldc 8
    //   8: astore 6
    //   10: new 104	java/io/File
    //   13: dup
    //   14: aload_0
    //   15: invokevirtual 110	android/app/Application:getFilesDir	()Ljava/io/File;
    //   18: aload_1
    //   19: invokespecial 113	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   22: astore_3
    //   23: new 104	java/io/File
    //   26: dup
    //   27: aload_0
    //   28: invokevirtual 110	android/app/Application:getFilesDir	()Ljava/io/File;
    //   31: aload_2
    //   32: invokespecial 113	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   35: astore 9
    //   37: aload_0
    //   38: invokevirtual 117	android/app/Application:getAssets	()Landroid/content/res/AssetManager;
    //   41: aload_1
    //   42: invokevirtual 123	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   45: astore_1
    //   46: new 125	java/io/FileOutputStream
    //   49: dup
    //   50: aload_3
    //   51: iconst_0
    //   52: invokespecial 128	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   55: astore_3
    //   56: aload_3
    //   57: astore 5
    //   59: aload_1
    //   60: astore 4
    //   62: aload_1
    //   63: aload_3
    //   64: invokestatic 130	com/tencent/mobileqq/app/InjectUtils:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   67: pop2
    //   68: aload_1
    //   69: ifnull +7 -> 76
    //   72: aload_1
    //   73: invokevirtual 133	java/io/InputStream:close	()V
    //   76: aload 6
    //   78: astore 4
    //   80: aload_3
    //   81: ifnull +11 -> 92
    //   84: aload_3
    //   85: invokevirtual 134	java/io/OutputStream:close	()V
    //   88: aload 6
    //   90: astore 4
    //   92: ldc 8
    //   94: aload 4
    //   96: invokevirtual 138	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   99: ifeq +379 -> 478
    //   102: aload_0
    //   103: invokevirtual 117	android/app/Application:getAssets	()Landroid/content/res/AssetManager;
    //   106: aload_2
    //   107: invokevirtual 123	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   110: astore_0
    //   111: new 125	java/io/FileOutputStream
    //   114: dup
    //   115: aload 9
    //   117: iconst_0
    //   118: invokespecial 128	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   121: astore_1
    //   122: aload_0
    //   123: aload_1
    //   124: invokestatic 130	com/tencent/mobileqq/app/InjectUtils:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   127: pop2
    //   128: aload_0
    //   129: ifnull +7 -> 136
    //   132: aload_0
    //   133: invokevirtual 133	java/io/InputStream:close	()V
    //   136: aload_1
    //   137: ifnull +7 -> 144
    //   140: aload_1
    //   141: invokevirtual 134	java/io/OutputStream:close	()V
    //   144: aload 4
    //   146: areturn
    //   147: astore 6
    //   149: aconst_null
    //   150: astore_3
    //   151: aconst_null
    //   152: astore_1
    //   153: aload_3
    //   154: astore 5
    //   156: aload_1
    //   157: astore 4
    //   159: aload 6
    //   161: invokevirtual 141	java/lang/Throwable:printStackTrace	()V
    //   164: aload_3
    //   165: astore 5
    //   167: aload_1
    //   168: astore 4
    //   170: aload 9
    //   172: invokevirtual 145	java/io/File:delete	()Z
    //   175: pop
    //   176: aload_3
    //   177: astore 5
    //   179: aload_1
    //   180: astore 4
    //   182: new 147	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   189: ldc 150
    //   191: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload 6
    //   196: invokestatic 160	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   199: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: astore 6
    //   207: aload 6
    //   209: astore 5
    //   211: aload_1
    //   212: ifnull +7 -> 219
    //   215: aload_1
    //   216: invokevirtual 133	java/io/InputStream:close	()V
    //   219: aload 5
    //   221: astore 4
    //   223: aload_3
    //   224: ifnull -132 -> 92
    //   227: aload_3
    //   228: invokevirtual 134	java/io/OutputStream:close	()V
    //   231: aload 5
    //   233: astore 4
    //   235: goto -143 -> 92
    //   238: astore_1
    //   239: aload 5
    //   241: astore 4
    //   243: goto -151 -> 92
    //   246: astore_0
    //   247: aconst_null
    //   248: astore 5
    //   250: aconst_null
    //   251: astore_1
    //   252: aload_1
    //   253: ifnull +7 -> 260
    //   256: aload_1
    //   257: invokevirtual 133	java/io/InputStream:close	()V
    //   260: aload 5
    //   262: ifnull +8 -> 270
    //   265: aload 5
    //   267: invokevirtual 134	java/io/OutputStream:close	()V
    //   270: aload_0
    //   271: athrow
    //   272: astore_0
    //   273: aconst_null
    //   274: astore_1
    //   275: aload 7
    //   277: astore_2
    //   278: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   281: ifeq +30 -> 311
    //   284: ldc 171
    //   286: iconst_2
    //   287: new 147	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   294: aload 9
    //   296: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   299: ldc 176
    //   301: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: aload_0
    //   308: invokestatic 180	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   311: aload_1
    //   312: ifnull +7 -> 319
    //   315: aload_1
    //   316: invokevirtual 133	java/io/InputStream:close	()V
    //   319: aload_2
    //   320: ifnull -176 -> 144
    //   323: aload_2
    //   324: invokevirtual 134	java/io/OutputStream:close	()V
    //   327: aload 4
    //   329: areturn
    //   330: astore_0
    //   331: aload 4
    //   333: areturn
    //   334: astore_0
    //   335: aconst_null
    //   336: astore_1
    //   337: aload 8
    //   339: astore_2
    //   340: aload_1
    //   341: ifnull +7 -> 348
    //   344: aload_1
    //   345: invokevirtual 133	java/io/InputStream:close	()V
    //   348: aload_2
    //   349: ifnull +7 -> 356
    //   352: aload_2
    //   353: invokevirtual 134	java/io/OutputStream:close	()V
    //   356: aload_0
    //   357: athrow
    //   358: astore_1
    //   359: goto -283 -> 76
    //   362: astore_1
    //   363: aload 6
    //   365: astore 4
    //   367: goto -275 -> 92
    //   370: astore_1
    //   371: goto -152 -> 219
    //   374: astore_1
    //   375: goto -115 -> 260
    //   378: astore_1
    //   379: goto -109 -> 270
    //   382: astore_0
    //   383: goto -247 -> 136
    //   386: astore_0
    //   387: aload 4
    //   389: areturn
    //   390: astore_0
    //   391: goto -72 -> 319
    //   394: astore_1
    //   395: goto -47 -> 348
    //   398: astore_1
    //   399: goto -43 -> 356
    //   402: astore_2
    //   403: aload_0
    //   404: astore_1
    //   405: aload_2
    //   406: astore_0
    //   407: aload 8
    //   409: astore_2
    //   410: goto -70 -> 340
    //   413: astore_2
    //   414: aload_0
    //   415: astore_3
    //   416: aload_2
    //   417: astore_0
    //   418: aload_1
    //   419: astore_2
    //   420: aload_3
    //   421: astore_1
    //   422: goto -82 -> 340
    //   425: astore_0
    //   426: goto -86 -> 340
    //   429: astore_2
    //   430: aload_0
    //   431: astore_1
    //   432: aload_2
    //   433: astore_0
    //   434: aload 7
    //   436: astore_2
    //   437: goto -159 -> 278
    //   440: astore_2
    //   441: aload_0
    //   442: astore_3
    //   443: aload_2
    //   444: astore_0
    //   445: aload_1
    //   446: astore_2
    //   447: aload_3
    //   448: astore_1
    //   449: goto -171 -> 278
    //   452: astore_0
    //   453: aconst_null
    //   454: astore 5
    //   456: goto -204 -> 252
    //   459: astore_0
    //   460: aload 4
    //   462: astore_1
    //   463: goto -211 -> 252
    //   466: astore 6
    //   468: aconst_null
    //   469: astore_3
    //   470: goto -317 -> 153
    //   473: astore 6
    //   475: goto -322 -> 153
    //   478: aconst_null
    //   479: astore_1
    //   480: aconst_null
    //   481: astore_0
    //   482: goto -354 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	485	0	paramApplication	Application
    //   0	485	1	paramString1	String
    //   0	485	2	paramString2	String
    //   22	448	3	localObject1	Object
    //   60	401	4	localObject2	Object
    //   57	398	5	localObject3	Object
    //   8	81	6	str1	String
    //   147	48	6	localThrowable1	Throwable
    //   205	159	6	str2	String
    //   466	1	6	localThrowable2	Throwable
    //   473	1	6	localThrowable3	Throwable
    //   4	431	7	localObject4	Object
    //   1	407	8	localObject5	Object
    //   35	260	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   37	46	147	java/lang/Throwable
    //   227	231	238	java/io/IOException
    //   37	46	246	finally
    //   92	111	272	java/lang/Throwable
    //   323	327	330	java/io/IOException
    //   92	111	334	finally
    //   72	76	358	java/io/IOException
    //   84	88	362	java/io/IOException
    //   215	219	370	java/io/IOException
    //   256	260	374	java/io/IOException
    //   265	270	378	java/io/IOException
    //   132	136	382	java/io/IOException
    //   140	144	386	java/io/IOException
    //   315	319	390	java/io/IOException
    //   344	348	394	java/io/IOException
    //   352	356	398	java/io/IOException
    //   111	122	402	finally
    //   122	128	413	finally
    //   278	311	425	finally
    //   111	122	429	java/lang/Throwable
    //   122	128	440	java/lang/Throwable
    //   46	56	452	finally
    //   62	68	459	finally
    //   159	164	459	finally
    //   170	176	459	finally
    //   182	207	459	finally
    //   46	56	466	java/lang/Throwable
    //   62	68	473	java/lang/Throwable
  }
  
  /* Error */
  private static String extractMd5File(Application paramApplication, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_0
    //   6: invokevirtual 110	android/app/Application:getFilesDir	()Ljava/io/File;
    //   9: astore_2
    //   10: aload_2
    //   11: ifnull +74 -> 85
    //   14: aload_2
    //   15: invokevirtual 185	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   18: astore_2
    //   19: new 104	java/io/File
    //   22: dup
    //   23: aload_2
    //   24: aload_1
    //   25: invokespecial 188	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: astore 5
    //   30: ldc 8
    //   32: ldc 8
    //   34: invokevirtual 138	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   37: ifeq +199 -> 236
    //   40: aload_0
    //   41: invokevirtual 117	android/app/Application:getAssets	()Landroid/content/res/AssetManager;
    //   44: aload_1
    //   45: invokevirtual 123	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   48: astore_0
    //   49: new 125	java/io/FileOutputStream
    //   52: dup
    //   53: aload 5
    //   55: iconst_0
    //   56: invokespecial 128	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   59: astore_1
    //   60: aload_0
    //   61: aload_1
    //   62: invokestatic 130	com/tencent/mobileqq/app/InjectUtils:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   65: pop2
    //   66: aload_0
    //   67: ifnull +7 -> 74
    //   70: aload_0
    //   71: invokevirtual 133	java/io/InputStream:close	()V
    //   74: aload_1
    //   75: ifnull +7 -> 82
    //   78: aload_1
    //   79: invokevirtual 134	java/io/OutputStream:close	()V
    //   82: ldc 8
    //   84: areturn
    //   85: ldc 190
    //   87: astore_2
    //   88: goto -69 -> 19
    //   91: astore_0
    //   92: aconst_null
    //   93: astore_1
    //   94: aload_3
    //   95: astore_2
    //   96: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   99: ifeq +30 -> 129
    //   102: ldc 171
    //   104: iconst_2
    //   105: new 147	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   112: aload 5
    //   114: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   117: ldc 176
    //   119: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: aload_0
    //   126: invokestatic 180	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   129: aload_2
    //   130: ifnull +7 -> 137
    //   133: aload_2
    //   134: invokevirtual 133	java/io/InputStream:close	()V
    //   137: aload_1
    //   138: ifnull -56 -> 82
    //   141: aload_1
    //   142: invokevirtual 134	java/io/OutputStream:close	()V
    //   145: ldc 8
    //   147: areturn
    //   148: astore_0
    //   149: ldc 8
    //   151: areturn
    //   152: astore_0
    //   153: aconst_null
    //   154: astore_1
    //   155: aload 4
    //   157: astore_2
    //   158: aload_2
    //   159: ifnull +7 -> 166
    //   162: aload_2
    //   163: invokevirtual 133	java/io/InputStream:close	()V
    //   166: aload_1
    //   167: ifnull +7 -> 174
    //   170: aload_1
    //   171: invokevirtual 134	java/io/OutputStream:close	()V
    //   174: aload_0
    //   175: athrow
    //   176: astore_0
    //   177: goto -103 -> 74
    //   180: astore_0
    //   181: ldc 8
    //   183: areturn
    //   184: astore_0
    //   185: goto -48 -> 137
    //   188: astore_2
    //   189: goto -23 -> 166
    //   192: astore_1
    //   193: goto -19 -> 174
    //   196: astore_3
    //   197: aconst_null
    //   198: astore_1
    //   199: aload_0
    //   200: astore_2
    //   201: aload_3
    //   202: astore_0
    //   203: goto -45 -> 158
    //   206: astore_3
    //   207: aload_0
    //   208: astore_2
    //   209: aload_3
    //   210: astore_0
    //   211: goto -53 -> 158
    //   214: astore_0
    //   215: goto -57 -> 158
    //   218: astore_3
    //   219: aconst_null
    //   220: astore_1
    //   221: aload_0
    //   222: astore_2
    //   223: aload_3
    //   224: astore_0
    //   225: goto -129 -> 96
    //   228: astore_3
    //   229: aload_0
    //   230: astore_2
    //   231: aload_3
    //   232: astore_0
    //   233: goto -137 -> 96
    //   236: aconst_null
    //   237: astore_1
    //   238: aconst_null
    //   239: astore_0
    //   240: goto -174 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	paramApplication	Application
    //   0	243	1	paramString	String
    //   9	154	2	localObject1	Object
    //   188	1	2	localIOException	java.io.IOException
    //   200	31	2	localApplication	Application
    //   4	91	3	localObject2	Object
    //   196	6	3	localObject3	Object
    //   206	4	3	localObject4	Object
    //   218	6	3	localThrowable1	Throwable
    //   228	4	3	localThrowable2	Throwable
    //   1	155	4	localObject5	Object
    //   28	85	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   30	49	91	java/lang/Throwable
    //   141	145	148	java/io/IOException
    //   30	49	152	finally
    //   70	74	176	java/io/IOException
    //   78	82	180	java/io/IOException
    //   133	137	184	java/io/IOException
    //   162	166	188	java/io/IOException
    //   170	174	192	java/io/IOException
    //   49	60	196	finally
    //   60	66	206	finally
    //   96	129	214	finally
    //   49	60	218	java/lang/Throwable
    //   60	66	228	java/lang/Throwable
  }
  
  /* Error */
  private static String extractMd5File(Application paramApplication, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: new 104	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: invokevirtual 110	android/app/Application:getFilesDir	()Ljava/io/File;
    //   13: aload_2
    //   14: invokespecial 113	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   17: astore 5
    //   19: ldc 8
    //   21: ldc 8
    //   23: invokevirtual 138	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   26: ifeq +193 -> 219
    //   29: aload_0
    //   30: invokevirtual 117	android/app/Application:getAssets	()Landroid/content/res/AssetManager;
    //   33: aload_1
    //   34: invokevirtual 123	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   37: astore_0
    //   38: new 125	java/io/FileOutputStream
    //   41: dup
    //   42: aload 5
    //   44: iconst_0
    //   45: invokespecial 128	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   48: astore_1
    //   49: aload_0
    //   50: aload_1
    //   51: invokestatic 130	com/tencent/mobileqq/app/InjectUtils:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   54: pop2
    //   55: aload_0
    //   56: ifnull +7 -> 63
    //   59: aload_0
    //   60: invokevirtual 133	java/io/InputStream:close	()V
    //   63: aload_1
    //   64: ifnull +7 -> 71
    //   67: aload_1
    //   68: invokevirtual 134	java/io/OutputStream:close	()V
    //   71: ldc 8
    //   73: areturn
    //   74: astore_0
    //   75: aconst_null
    //   76: astore_1
    //   77: aload_3
    //   78: astore_2
    //   79: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   82: ifeq +30 -> 112
    //   85: ldc 171
    //   87: iconst_2
    //   88: new 147	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   95: aload 5
    //   97: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   100: ldc 176
    //   102: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: aload_0
    //   109: invokestatic 180	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   112: aload_2
    //   113: ifnull +7 -> 120
    //   116: aload_2
    //   117: invokevirtual 133	java/io/InputStream:close	()V
    //   120: aload_1
    //   121: ifnull -50 -> 71
    //   124: aload_1
    //   125: invokevirtual 134	java/io/OutputStream:close	()V
    //   128: ldc 8
    //   130: areturn
    //   131: astore_0
    //   132: ldc 8
    //   134: areturn
    //   135: astore_0
    //   136: aconst_null
    //   137: astore_1
    //   138: aload 4
    //   140: astore_2
    //   141: aload_2
    //   142: ifnull +7 -> 149
    //   145: aload_2
    //   146: invokevirtual 133	java/io/InputStream:close	()V
    //   149: aload_1
    //   150: ifnull +7 -> 157
    //   153: aload_1
    //   154: invokevirtual 134	java/io/OutputStream:close	()V
    //   157: aload_0
    //   158: athrow
    //   159: astore_0
    //   160: goto -97 -> 63
    //   163: astore_0
    //   164: ldc 8
    //   166: areturn
    //   167: astore_0
    //   168: goto -48 -> 120
    //   171: astore_2
    //   172: goto -23 -> 149
    //   175: astore_1
    //   176: goto -19 -> 157
    //   179: astore_3
    //   180: aconst_null
    //   181: astore_1
    //   182: aload_0
    //   183: astore_2
    //   184: aload_3
    //   185: astore_0
    //   186: goto -45 -> 141
    //   189: astore_3
    //   190: aload_0
    //   191: astore_2
    //   192: aload_3
    //   193: astore_0
    //   194: goto -53 -> 141
    //   197: astore_0
    //   198: goto -57 -> 141
    //   201: astore_3
    //   202: aconst_null
    //   203: astore_1
    //   204: aload_0
    //   205: astore_2
    //   206: aload_3
    //   207: astore_0
    //   208: goto -129 -> 79
    //   211: astore_3
    //   212: aload_0
    //   213: astore_2
    //   214: aload_3
    //   215: astore_0
    //   216: goto -137 -> 79
    //   219: aconst_null
    //   220: astore_1
    //   221: aconst_null
    //   222: astore_0
    //   223: goto -168 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	paramApplication	Application
    //   0	226	1	paramString1	String
    //   0	226	2	paramString2	String
    //   4	74	3	localObject1	Object
    //   179	6	3	localObject2	Object
    //   189	4	3	localObject3	Object
    //   201	6	3	localThrowable1	Throwable
    //   211	4	3	localThrowable2	Throwable
    //   1	138	4	localObject4	Object
    //   17	79	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   19	38	74	java/lang/Throwable
    //   124	128	131	java/io/IOException
    //   19	38	135	finally
    //   59	63	159	java/io/IOException
    //   67	71	163	java/io/IOException
    //   116	120	167	java/io/IOException
    //   145	149	171	java/io/IOException
    //   153	157	175	java/io/IOException
    //   38	49	179	finally
    //   49	55	189	finally
    //   79	112	197	finally
    //   38	49	201	java/lang/Throwable
    //   49	55	211	java/lang/Throwable
  }
  
  public static float getAvailableInnernalMemorySizeInK()
  {
    Object localObject = Environment.getDataDirectory().getPath();
    try
    {
      localObject = new StatFs((String)localObject);
      float f = ((StatFs)localObject).getAvailableBlocks() / 1024.0F;
      int i = ((StatFs)localObject).getBlockSize();
      return i * f;
    }
    catch (Exception localException) {}
    return -1.0F;
  }
  
  public static long[] getTotalInternalMemorySize()
  {
    long l2 = 0L;
    try
    {
      localStatFs = new StatFs(Environment.getDataDirectory().getPath());
      i = localStatFs.getBlockSize();
      l3 = i;
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        StatFs localStatFs;
        int i;
        label45:
        l1 = 0L;
        long l3 = 0L;
      }
    }
    try
    {
      i = localStatFs.getBlockCount();
      l1 = i;
    }
    catch (Throwable localThrowable2)
    {
      l1 = 0L;
      break label45;
    }
    try
    {
      i = localStatFs.getAvailableBlocks();
      l2 = i;
    }
    catch (Throwable localThrowable3)
    {
      break label45;
    }
    return new long[] { l2 * l3, l1 * l3 };
  }
  
  /* Error */
  public static String injectExtraDexManual(Application paramApplication, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: iconst_1
    //   4: istore 5
    //   6: ldc 2
    //   8: monitorenter
    //   9: ldc 8
    //   11: astore 7
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: getstatic 66	com/tencent/mobileqq/app/InjectUtils:sExtraDexes	[Ljava/lang/String;
    //   19: arraylength
    //   20: if_icmpge +305 -> 325
    //   23: getstatic 66	com/tencent/mobileqq/app/InjectUtils:sExtraDexes	[Ljava/lang/String;
    //   26: iload_3
    //   27: aaload
    //   28: astore 12
    //   30: getstatic 52	com/tencent/mobileqq/app/InjectUtils:sExtraLibsStartUpClassName	[Ljava/lang/String;
    //   33: iload_3
    //   34: aaload
    //   35: astore 11
    //   37: new 147	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   44: getstatic 66	com/tencent/mobileqq/app/InjectUtils:sExtraDexes	[Ljava/lang/String;
    //   47: iload_3
    //   48: aaload
    //   49: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc 225
    //   54: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: astore 10
    //   62: aload_0
    //   63: invokevirtual 229	android/app/Application:getApplicationContext	()Landroid/content/Context;
    //   66: getstatic 78	com/tencent/mobileqq/app/InjectUtils:sExtraJarDexes	[Ljava/lang/String;
    //   69: iload_3
    //   70: aaload
    //   71: aload 10
    //   73: invokestatic 235	com/tencent/commonsdk/soload/SoLoadCore:isLibExtracted	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    //   76: istore 6
    //   78: iload 6
    //   80: ifne +27 -> 107
    //   83: iconst_1
    //   84: istore 4
    //   86: aload 7
    //   88: astore 8
    //   90: iload 4
    //   92: ifeq +36 -> 128
    //   95: iload_1
    //   96: ifeq +17 -> 113
    //   99: aload 9
    //   101: astore_0
    //   102: ldc 2
    //   104: monitorexit
    //   105: aload_0
    //   106: areturn
    //   107: iconst_0
    //   108: istore 4
    //   110: goto -24 -> 86
    //   113: aload_0
    //   114: invokevirtual 229	android/app/Application:getApplicationContext	()Landroid/content/Context;
    //   117: aload 12
    //   119: invokestatic 239	com/tencent/commonsdk/soload/SoLoadCore:releaseDexFromApk	(Landroid/content/Context;Ljava/lang/String;)Z
    //   122: ifne +155 -> 277
    //   125: aconst_null
    //   126: astore 8
    //   128: aload 8
    //   130: astore 7
    //   132: ldc 8
    //   134: aload 8
    //   136: invokevirtual 138	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   139: ifeq +47 -> 186
    //   142: aload_0
    //   143: invokevirtual 110	android/app/Application:getFilesDir	()Ljava/io/File;
    //   146: astore 7
    //   148: aload 7
    //   150: ifnull +138 -> 288
    //   153: aload 7
    //   155: invokevirtual 185	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   158: astore 7
    //   160: aload_0
    //   161: new 104	java/io/File
    //   164: dup
    //   165: aload 7
    //   167: getstatic 78	com/tencent/mobileqq/app/InjectUtils:sExtraJarDexes	[Ljava/lang/String;
    //   170: iload_3
    //   171: aaload
    //   172: invokespecial 188	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   175: invokevirtual 185	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   178: aload 11
    //   180: iconst_1
    //   181: invokestatic 245	com/tencent/mobileqq/app/SystemClassLoaderInjector:a	(Landroid/app/Application;Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   184: astore 7
    //   186: ldc 11
    //   188: iconst_1
    //   189: aload 7
    //   191: invokestatic 248	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   194: ldc 8
    //   196: aload 7
    //   198: invokevirtual 138	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   201: ifne +106 -> 307
    //   204: aload_0
    //   205: ldc 250
    //   207: aload 7
    //   209: invokestatic 254	com/tencent/mobileqq/app/InjectUtils:uploadInjectFailure	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   212: invokestatic 256	com/tencent/mobileqq/app/InjectUtils:getAvailableInnernalMemorySizeInK	()F
    //   215: fstore_2
    //   216: fload_2
    //   217: fconst_0
    //   218: fcmpl
    //   219: ifle +76 -> 295
    //   222: fload_2
    //   223: ldc_w 257
    //   226: fcmpg
    //   227: ifge +68 -> 295
    //   230: iload 5
    //   232: istore_1
    //   233: iload_1
    //   234: putstatic 259	com/tencent/mobileqq/app/InjectUtils:sSpaceNoEnough	Z
    //   237: new 104	java/io/File
    //   240: dup
    //   241: aload_0
    //   242: invokevirtual 110	android/app/Application:getFilesDir	()Ljava/io/File;
    //   245: aload 10
    //   247: invokespecial 113	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   250: invokevirtual 145	java/io/File:delete	()Z
    //   253: pop
    //   254: new 104	java/io/File
    //   257: dup
    //   258: aload_0
    //   259: invokevirtual 110	android/app/Application:getFilesDir	()Ljava/io/File;
    //   262: aload 10
    //   264: invokespecial 113	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   267: invokevirtual 145	java/io/File:delete	()Z
    //   270: pop
    //   271: aload 7
    //   273: astore_0
    //   274: goto -172 -> 102
    //   277: aload_0
    //   278: aload 10
    //   280: invokestatic 261	com/tencent/mobileqq/app/InjectUtils:extractMd5File	(Landroid/app/Application;Ljava/lang/String;)Ljava/lang/String;
    //   283: astore 8
    //   285: goto -157 -> 128
    //   288: ldc 190
    //   290: astore 7
    //   292: goto -132 -> 160
    //   295: iconst_0
    //   296: istore_1
    //   297: goto -64 -> 233
    //   300: astore_0
    //   301: aload 7
    //   303: astore_0
    //   304: goto -202 -> 102
    //   307: iload_3
    //   308: iconst_1
    //   309: iadd
    //   310: istore_3
    //   311: goto -296 -> 15
    //   314: astore_0
    //   315: ldc 2
    //   317: monitorexit
    //   318: aload_0
    //   319: athrow
    //   320: astore 8
    //   322: goto -68 -> 254
    //   325: aload 7
    //   327: astore_0
    //   328: goto -226 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	331	0	paramApplication	Application
    //   0	331	1	paramBoolean	boolean
    //   215	8	2	f	float
    //   14	297	3	i	int
    //   84	25	4	j	int
    //   4	227	5	bool1	boolean
    //   76	3	6	bool2	boolean
    //   11	315	7	localObject1	Object
    //   88	196	8	localObject2	Object
    //   320	1	8	localException	Exception
    //   1	99	9	localObject3	Object
    //   60	219	10	str1	String
    //   35	144	11	str2	String
    //   28	90	12	str3	String
    // Exception table:
    //   from	to	target	type
    //   254	271	300	java/lang/Exception
    //   15	78	314	finally
    //   113	125	314	finally
    //   132	148	314	finally
    //   153	160	314	finally
    //   160	186	314	finally
    //   186	216	314	finally
    //   233	237	314	finally
    //   237	254	314	finally
    //   254	271	314	finally
    //   277	285	314	finally
    //   237	254	320	java/lang/Exception
  }
  
  /* Error */
  public static String injectExtraDexes(Application paramApplication, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +53 -> 59
    //   9: new 147	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 264
    //   19: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: astore_3
    //   23: invokestatic 267	com/tencent/mobileqq/app/InjectUtils:isRuntimeART	()Z
    //   26: ifeq +52 -> 78
    //   29: ldc_w 269
    //   32: astore_2
    //   33: ldc 11
    //   35: iconst_2
    //   36: aload_3
    //   37: aload_2
    //   38: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc_w 271
    //   44: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: getstatic 277	android/os/Build$VERSION:SDK_INT	I
    //   50: invokevirtual 280	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   53: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 283	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: getstatic 277	android/os/Build$VERSION:SDK_INT	I
    //   62: bipush 21
    //   64: if_icmplt +21 -> 85
    //   67: aload_0
    //   68: iload_1
    //   69: invokestatic 286	com/tencent/mobileqq/app/InjectUtils:injectExtraDexesOat	(Landroid/app/Application;Z)Ljava/lang/String;
    //   72: astore_0
    //   73: ldc 2
    //   75: monitorexit
    //   76: aload_0
    //   77: areturn
    //   78: ldc_w 288
    //   81: astore_2
    //   82: goto -49 -> 33
    //   85: aload_0
    //   86: iload_1
    //   87: invokestatic 290	com/tencent/mobileqq/app/InjectUtils:injectExtraDexManual	(Landroid/app/Application;Z)Ljava/lang/String;
    //   90: astore_0
    //   91: goto -18 -> 73
    //   94: astore_0
    //   95: ldc 11
    //   97: iconst_1
    //   98: ldc 250
    //   100: aload_0
    //   101: invokestatic 180	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   104: aconst_null
    //   105: astore_0
    //   106: goto -33 -> 73
    //   109: astore_0
    //   110: ldc 2
    //   112: monitorexit
    //   113: aload_0
    //   114: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	paramApplication	Application
    //   0	115	1	paramBoolean	boolean
    //   32	50	2	str	String
    //   22	15	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   59	73	94	java/lang/Throwable
    //   85	91	94	java/lang/Throwable
    //   3	29	109	finally
    //   33	59	109	finally
    //   59	73	109	finally
    //   85	91	109	finally
    //   95	104	109	finally
  }
  
  /* Error */
  public static String injectExtraDexesOat(Application paramApplication, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 8
    //   5: astore 6
    //   7: iconst_0
    //   8: istore_2
    //   9: aload 6
    //   11: astore 5
    //   13: iload_2
    //   14: getstatic 66	com/tencent/mobileqq/app/InjectUtils:sExtraDexes	[Ljava/lang/String;
    //   17: arraylength
    //   18: if_icmpge +158 -> 176
    //   21: new 147	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   28: getstatic 66	com/tencent/mobileqq/app/InjectUtils:sExtraDexes	[Ljava/lang/String;
    //   31: iload_2
    //   32: aaload
    //   33: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: ldc 225
    //   38: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: astore 5
    //   46: new 147	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   53: getstatic 66	com/tencent/mobileqq/app/InjectUtils:sExtraDexes	[Ljava/lang/String;
    //   56: iload_2
    //   57: aaload
    //   58: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc_w 292
    //   64: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: astore 7
    //   72: aload_0
    //   73: aload_0
    //   74: invokevirtual 229	android/app/Application:getApplicationContext	()Landroid/content/Context;
    //   77: aload 5
    //   79: aload 7
    //   81: invokestatic 296	com/tencent/mobileqq/app/InjectUtils:isOatMd5Extracted	(Landroid/app/Application;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    //   84: istore 4
    //   86: iload 4
    //   88: ifne +22 -> 110
    //   91: iconst_1
    //   92: istore_3
    //   93: iload_3
    //   94: ifeq +30 -> 124
    //   97: iload_1
    //   98: ifeq +17 -> 115
    //   101: aconst_null
    //   102: astore 6
    //   104: ldc 2
    //   106: monitorexit
    //   107: aload 6
    //   109: areturn
    //   110: iconst_0
    //   111: istore_3
    //   112: goto -19 -> 93
    //   115: aload_0
    //   116: aload 5
    //   118: aload 7
    //   120: invokestatic 298	com/tencent/mobileqq/app/InjectUtils:extractMd5File	(Landroid/app/Application;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   123: pop
    //   124: aload_0
    //   125: invokevirtual 302	android/app/Application:getClassLoader	()Ljava/lang/ClassLoader;
    //   128: astore 5
    //   130: aload 5
    //   132: getstatic 52	com/tencent/mobileqq/app/InjectUtils:sExtraLibsStartUpClassName	[Ljava/lang/String;
    //   135: iload_2
    //   136: aaload
    //   137: invokevirtual 308	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   140: pop
    //   141: iload_2
    //   142: iconst_1
    //   143: iadd
    //   144: istore_2
    //   145: goto -136 -> 9
    //   148: astore 5
    //   150: new 147	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   157: ldc_w 310
    //   160: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload 5
    //   165: invokestatic 160	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   168: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: astore 5
    //   176: ldc 11
    //   178: iconst_1
    //   179: aload 5
    //   181: invokestatic 248	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: aload 5
    //   186: astore 6
    //   188: ldc 8
    //   190: aload 5
    //   192: invokevirtual 138	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   195: ifne -91 -> 104
    //   198: aload_0
    //   199: iload_1
    //   200: invokestatic 290	com/tencent/mobileqq/app/InjectUtils:injectExtraDexManual	(Landroid/app/Application;Z)Ljava/lang/String;
    //   203: astore 6
    //   205: goto -101 -> 104
    //   208: astore_0
    //   209: ldc 2
    //   211: monitorexit
    //   212: aload_0
    //   213: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	paramApplication	Application
    //   0	214	1	paramBoolean	boolean
    //   8	137	2	i	int
    //   92	20	3	j	int
    //   84	3	4	bool	boolean
    //   11	120	5	localObject1	Object
    //   148	16	5	localThrowable	Throwable
    //   174	17	5	str1	String
    //   5	199	6	localObject2	Object
    //   70	49	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   130	141	148	java/lang/Throwable
    //   13	86	208	finally
    //   115	124	208	finally
    //   124	130	208	finally
    //   130	141	208	finally
    //   150	176	208	finally
    //   176	184	208	finally
    //   188	205	208	finally
  }
  
  public static String injectExtraLibs(Application paramApplication, boolean paramBoolean)
  {
    boolean bool1 = true;
    Object localObject1 = "Success";
    int i = 0;
    for (;;)
    {
      Object localObject2 = localObject1;
      try
      {
        String str3;
        String str2;
        String str1;
        File localFile;
        if (i < sExtraLibs.length)
        {
          str3 = sExtraLibs[i];
          str2 = sExtraLibsStartUpClassName[i];
          str1 = str3 + ".MD5";
          localFile = new File(paramApplication.getFilesDir(), str3);
          boolean bool2 = SoLoadCore.isLibExtracted(paramApplication.getApplicationContext(), str3, str1);
          if (bool2) {
            break label118;
          }
        }
        label118:
        for (int j = 1;; j = 0)
        {
          localObject2 = localObject1;
          if (j == 0) {
            break label134;
          }
          if (!paramBoolean) {
            break;
          }
          localObject2 = null;
          return localObject2;
        }
        localObject2 = extractLib(paramApplication, str3, str1);
        label134:
        localObject1 = localObject2;
        if ("Success".equals(localObject2)) {
          localObject1 = SystemClassLoaderInjector.a(paramApplication, localFile.getAbsolutePath(), str2, true);
        }
        QLog.e("DexLoad", 1, (String)localObject1);
        if (!"Success".equals(localObject1))
        {
          uploadInjectFailure(paramApplication, "", (String)localObject1);
          float f = getAvailableInnernalMemorySizeInK();
          if ((f > 0.0F) && (f < 250.0F)) {}
          for (paramBoolean = bool1;; paramBoolean = false)
          {
            for (;;)
            {
              sSpaceNoEnough = paramBoolean;
              try
              {
                new File(paramApplication.getFilesDir(), str1).delete();
                localObject2 = localObject1;
              }
              catch (Exception paramApplication)
              {
                localObject2 = localObject1;
              }
            }
            break;
          }
        }
        i += 1;
      }
      finally {}
    }
  }
  
  public static boolean isEverInjectedDex(Context paramContext)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        if (SoLoadCore.getExistFile(paramContext, sExtraDexes[0] + ".oat.MD5") == null) {
          break label87;
        }
        return true;
      }
      paramContext = SoLoadCore.getExistFile(paramContext, sExtraDexes[0] + ".MD5");
      if (paramContext == null) {
        return false;
      }
    }
    catch (Throwable paramContext)
    {
      QLog.e("DexLoadOat", 1, "", paramContext);
    }
    return true;
    label87:
    return false;
  }
  
  /* Error */
  private static boolean isOatMd5Extracted(Application paramApplication, Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_1
    //   4: aload_3
    //   5: invokestatic 319	com/tencent/commonsdk/soload/SoLoadCore:getExistFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   8: astore 6
    //   10: aload 6
    //   12: ifnonnull +37 -> 49
    //   15: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   18: ifeq +29 -> 47
    //   21: ldc 11
    //   23: iconst_2
    //   24: new 147	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   31: aload_3
    //   32: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc_w 321
    //   38: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 248	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   47: iconst_0
    //   48: ireturn
    //   49: aload_0
    //   50: invokevirtual 117	android/app/Application:getAssets	()Landroid/content/res/AssetManager;
    //   53: aload_2
    //   54: invokevirtual 123	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   57: astore_0
    //   58: new 323	java/io/FileInputStream
    //   61: dup
    //   62: aload 6
    //   64: invokespecial 326	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   67: astore_3
    //   68: aload_0
    //   69: aload_3
    //   70: invokestatic 330	com/tencent/commonsdk/soload/SoLoadCore:contentEquals	(Ljava/io/InputStream;Ljava/io/InputStream;)Z
    //   73: istore 4
    //   75: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   78: ifeq +35 -> 113
    //   81: ldc 11
    //   83: iconst_2
    //   84: new 147	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   91: aload 6
    //   93: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   96: ldc_w 332
    //   99: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: iload 4
    //   104: invokevirtual 335	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   107: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 248	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: aload_0
    //   114: ifnull +7 -> 121
    //   117: aload_0
    //   118: invokevirtual 133	java/io/InputStream:close	()V
    //   121: aload_3
    //   122: ifnull +7 -> 129
    //   125: aload_3
    //   126: invokevirtual 133	java/io/InputStream:close	()V
    //   129: iload 4
    //   131: ireturn
    //   132: astore_2
    //   133: aconst_null
    //   134: astore_0
    //   135: aload 5
    //   137: astore_1
    //   138: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   141: ifeq +31 -> 172
    //   144: ldc 11
    //   146: iconst_2
    //   147: new 147	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   154: aload 6
    //   156: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   159: ldc_w 337
    //   162: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: aload_2
    //   169: invokestatic 180	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   172: aload_2
    //   173: invokevirtual 338	java/io/IOException:printStackTrace	()V
    //   176: aload_1
    //   177: ifnull +7 -> 184
    //   180: aload_1
    //   181: invokevirtual 133	java/io/InputStream:close	()V
    //   184: aload_0
    //   185: ifnull -138 -> 47
    //   188: aload_0
    //   189: invokevirtual 133	java/io/InputStream:close	()V
    //   192: iconst_0
    //   193: ireturn
    //   194: astore_0
    //   195: iconst_0
    //   196: ireturn
    //   197: astore_1
    //   198: aconst_null
    //   199: astore_2
    //   200: aconst_null
    //   201: astore_0
    //   202: aload_0
    //   203: ifnull +7 -> 210
    //   206: aload_0
    //   207: invokevirtual 133	java/io/InputStream:close	()V
    //   210: aload_2
    //   211: ifnull +7 -> 218
    //   214: aload_2
    //   215: invokevirtual 133	java/io/InputStream:close	()V
    //   218: aload_1
    //   219: athrow
    //   220: astore_0
    //   221: goto -100 -> 121
    //   224: astore_0
    //   225: goto -96 -> 129
    //   228: astore_1
    //   229: goto -45 -> 184
    //   232: astore_0
    //   233: goto -23 -> 210
    //   236: astore_0
    //   237: goto -19 -> 218
    //   240: astore_1
    //   241: aconst_null
    //   242: astore_2
    //   243: goto -41 -> 202
    //   246: astore_1
    //   247: aload_3
    //   248: astore_2
    //   249: goto -47 -> 202
    //   252: astore_2
    //   253: aload_1
    //   254: astore_3
    //   255: aload_2
    //   256: astore_1
    //   257: aload_0
    //   258: astore_2
    //   259: aload_3
    //   260: astore_0
    //   261: goto -59 -> 202
    //   264: astore_2
    //   265: aconst_null
    //   266: astore_3
    //   267: aload_0
    //   268: astore_1
    //   269: aload_3
    //   270: astore_0
    //   271: goto -133 -> 138
    //   274: astore_2
    //   275: aload_0
    //   276: astore_1
    //   277: aload_3
    //   278: astore_0
    //   279: goto -141 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	paramApplication	Application
    //   0	282	1	paramContext	Context
    //   0	282	2	paramString1	String
    //   0	282	3	paramString2	String
    //   73	57	4	bool	boolean
    //   1	135	5	localObject	Object
    //   8	147	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   49	58	132	java/io/IOException
    //   188	192	194	java/io/IOException
    //   49	58	197	finally
    //   117	121	220	java/io/IOException
    //   125	129	224	java/io/IOException
    //   180	184	228	java/io/IOException
    //   206	210	232	java/io/IOException
    //   214	218	236	java/io/IOException
    //   58	68	240	finally
    //   68	113	246	finally
    //   138	172	252	finally
    //   172	176	252	finally
    //   58	68	264	java/io/IOException
    //   68	113	274	java/io/IOException
  }
  
  public static boolean isRuntimeART()
  {
    if (sVmVersion == null)
    {
      sVmVersion = System.getProperty("java.vm.version");
      if ((sVmVersion == null) || (!sVmVersion.startsWith("2"))) {
        break label43;
      }
    }
    label43:
    for (boolean bool = true;; bool = false)
    {
      sIsART = bool;
      return sIsART;
    }
  }
  
  public static void uploadInjectFailure(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      byte[] arrayOfByte = "9u23fh$jkf^%43hj".getBytes();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1).append("|");
      localStringBuilder.append(Build.DEVICE).append("|");
      localStringBuilder.append(Build.MANUFACTURER).append("|");
      localStringBuilder.append(Build.MODEL).append("|");
      localStringBuilder.append(Build.VERSION.SDK_INT).append("|");
      paramString1 = getTotalInternalMemorySize();
      localStringBuilder.append(paramString1[0]).append("|").append(paramString1[1]).append("|");
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null) {
        localStringBuilder.append(paramContext.getDeviceId()).append("|");
      }
      localStringBuilder.append(paramString2).append("|");
      ThreadManager.post(new zfu(arrayOfByte, localStringBuilder.toString()), 8, null, false);
      return;
    }
    catch (Throwable paramContext) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.InjectUtils
 * JD-Core Version:    0.7.0.1
 */