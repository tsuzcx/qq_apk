package com.tencent.commonsdk.classload;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import java.io.Closeable;

public class DexClassLoaderUtil
{
  private static final String INFO_FILE_SUFFIX = ".dat";
  private static Handler sHandler;
  public static Looper sLooper;
  
  private static void close(Closeable paramCloseable)
  {
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        return;
      }
      catch (Exception paramCloseable)
      {
        paramCloseable.printStackTrace();
      }
    }
  }
  
  /* Error */
  public static dalvik.system.DexClassLoader createDexClassLoader(String paramString1, String paramString2, String paramString3, java.lang.ClassLoader paramClassLoader)
  {
    // Byte code:
    //   0: getstatic 38	com/tencent/commonsdk/classload/DexClassLoaderUtil:sHandler	Landroid/os/Handler;
    //   3: ifnonnull +25 -> 28
    //   6: getstatic 40	com/tencent/commonsdk/classload/DexClassLoaderUtil:sLooper	Landroid/os/Looper;
    //   9: astore 7
    //   11: aload 7
    //   13: ifnull +15 -> 28
    //   16: new 42	android/os/Handler
    //   19: dup
    //   20: aload 7
    //   22: invokespecial 45	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   25: putstatic 38	com/tencent/commonsdk/classload/DexClassLoaderUtil:sHandler	Landroid/os/Handler;
    //   28: getstatic 38	com/tencent/commonsdk/classload/DexClassLoaderUtil:sHandler	Landroid/os/Handler;
    //   31: astore 12
    //   33: aload_0
    //   34: ldc 47
    //   36: invokevirtual 53	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   39: istore 4
    //   41: aload_0
    //   42: ldc 55
    //   44: invokevirtual 53	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   47: istore 5
    //   49: iload 4
    //   51: iload 5
    //   53: if_icmple +6 -> 59
    //   56: goto +7 -> 63
    //   59: iload 5
    //   61: istore 4
    //   63: iconst_0
    //   64: istore 6
    //   66: iload 4
    //   68: iflt +12 -> 80
    //   71: iload 4
    //   73: iconst_1
    //   74: iadd
    //   75: istore 4
    //   77: goto +6 -> 83
    //   80: iconst_0
    //   81: istore 4
    //   83: aload_0
    //   84: ldc 57
    //   86: invokevirtual 53	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   89: istore 5
    //   91: iload 5
    //   93: iflt +6 -> 99
    //   96: goto +9 -> 105
    //   99: aload_0
    //   100: invokevirtual 61	java/lang/String:length	()I
    //   103: istore 5
    //   105: aload_0
    //   106: iload 4
    //   108: iload 5
    //   110: invokevirtual 65	java/lang/String:substring	(II)Ljava/lang/String;
    //   113: astore 13
    //   115: new 67	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   122: astore 7
    //   124: aload 7
    //   126: aload_1
    //   127: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload 7
    //   133: getstatic 77	java/io/File:separator	Ljava/lang/String;
    //   136: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload 7
    //   142: aload 13
    //   144: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload 7
    //   150: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: astore 16
    //   155: new 74	java/io/File
    //   158: dup
    //   159: aload 16
    //   161: invokespecial 84	java/io/File:<init>	(Ljava/lang/String;)V
    //   164: astore 14
    //   166: aload 14
    //   168: invokevirtual 88	java/io/File:isFile	()Z
    //   171: ifeq +9 -> 180
    //   174: aload 14
    //   176: invokevirtual 91	java/io/File:delete	()Z
    //   179: pop
    //   180: aload 14
    //   182: invokevirtual 94	java/io/File:exists	()Z
    //   185: ifne +9 -> 194
    //   188: aload 14
    //   190: invokevirtual 97	java/io/File:mkdirs	()Z
    //   193: pop
    //   194: new 67	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   201: astore_1
    //   202: aload_1
    //   203: aload 13
    //   205: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload_1
    //   210: ldc 8
    //   212: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: new 74	java/io/File
    //   219: dup
    //   220: aload 14
    //   222: aload_1
    //   223: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokespecial 100	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   229: astore 15
    //   231: aload 15
    //   233: invokevirtual 103	java/io/File:isDirectory	()Z
    //   236: ifeq +9 -> 245
    //   239: aload 15
    //   241: invokevirtual 91	java/io/File:delete	()Z
    //   244: pop
    //   245: aconst_null
    //   246: astore_1
    //   247: aconst_null
    //   248: astore 11
    //   250: new 105	java/io/BufferedReader
    //   253: dup
    //   254: new 107	java/io/FileReader
    //   257: dup
    //   258: aload 15
    //   260: invokespecial 110	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   263: invokespecial 113	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   266: astore 9
    //   268: aload 9
    //   270: astore 7
    //   272: aload 9
    //   274: invokevirtual 116	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   277: astore 10
    //   279: aload 10
    //   281: ifnull +24 -> 305
    //   284: aload 9
    //   286: astore 7
    //   288: aload 9
    //   290: invokevirtual 116	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   293: astore_1
    //   294: goto +13 -> 307
    //   297: astore 8
    //   299: aload 10
    //   301: astore_1
    //   302: goto +36 -> 338
    //   305: aconst_null
    //   306: astore_1
    //   307: aload 9
    //   309: invokestatic 118	com/tencent/commonsdk/classload/DexClassLoaderUtil:close	(Ljava/io/Closeable;)V
    //   312: aload 10
    //   314: astore 7
    //   316: goto +45 -> 361
    //   319: astore 8
    //   321: aconst_null
    //   322: astore_1
    //   323: goto +15 -> 338
    //   326: astore_0
    //   327: goto +413 -> 740
    //   330: astore 8
    //   332: aconst_null
    //   333: astore 9
    //   335: aload 9
    //   337: astore_1
    //   338: aload 9
    //   340: astore 7
    //   342: aload 8
    //   344: invokevirtual 34	java/lang/Exception:printStackTrace	()V
    //   347: aload 9
    //   349: invokestatic 118	com/tencent/commonsdk/classload/DexClassLoaderUtil:close	(Ljava/io/Closeable;)V
    //   352: aconst_null
    //   353: astore 8
    //   355: aload_1
    //   356: astore 7
    //   358: aload 8
    //   360: astore_1
    //   361: aload 14
    //   363: invokevirtual 122	java/io/File:listFiles	()[Ljava/io/File;
    //   366: astore 9
    //   368: aload 9
    //   370: ifnull +147 -> 517
    //   373: aload 9
    //   375: arraylength
    //   376: istore 5
    //   378: iconst_0
    //   379: istore 4
    //   381: iload 4
    //   383: iload 5
    //   385: if_icmpge +132 -> 517
    //   388: aload 9
    //   390: iload 4
    //   392: aaload
    //   393: astore 8
    //   395: aload 8
    //   397: invokevirtual 125	java/io/File:getName	()Ljava/lang/String;
    //   400: ldc 8
    //   402: invokevirtual 129	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   405: ifeq +12 -> 417
    //   408: iload 4
    //   410: iconst_1
    //   411: iadd
    //   412: istore 4
    //   414: goto -33 -> 381
    //   417: new 67	java/lang/StringBuilder
    //   420: dup
    //   421: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   424: astore 9
    //   426: aload 9
    //   428: aload 8
    //   430: invokevirtual 125	java/io/File:getName	()Ljava/lang/String;
    //   433: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: pop
    //   437: aload 9
    //   439: aload 8
    //   441: invokevirtual 132	java/io/File:length	()J
    //   444: invokevirtual 135	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   447: pop
    //   448: aload 9
    //   450: aload 8
    //   452: invokevirtual 138	java/io/File:lastModified	()J
    //   455: invokevirtual 135	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   458: pop
    //   459: aload 9
    //   461: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   464: invokestatic 142	com/tencent/commonsdk/classload/DexClassLoaderUtil:getBase64String	(Ljava/lang/String;)Ljava/lang/String;
    //   467: invokestatic 147	com/tencent/commonsdk/util/MD5Coding:encodeHexStr	(Ljava/lang/String;)Ljava/lang/String;
    //   470: astore 9
    //   472: aload 7
    //   474: ifnull +22 -> 496
    //   477: aload 7
    //   479: aload 9
    //   481: invokevirtual 150	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   484: ifeq +12 -> 496
    //   487: aload_1
    //   488: ifnonnull +29 -> 517
    //   491: aload 12
    //   493: ifnull +24 -> 517
    //   496: aload 8
    //   498: invokevirtual 91	java/io/File:delete	()Z
    //   501: pop
    //   502: aload 15
    //   504: invokevirtual 91	java/io/File:delete	()Z
    //   507: pop
    //   508: aconst_null
    //   509: astore 7
    //   511: aload 11
    //   513: astore_1
    //   514: goto +13 -> 527
    //   517: aload 7
    //   519: astore 8
    //   521: aload_1
    //   522: astore 7
    //   524: aload 8
    //   526: astore_1
    //   527: new 152	dalvik/system/DexClassLoader
    //   530: dup
    //   531: aload_0
    //   532: aload 16
    //   534: aload_2
    //   535: aload_3
    //   536: invokespecial 155	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   539: astore_0
    //   540: aload 14
    //   542: invokevirtual 122	java/io/File:listFiles	()[Ljava/io/File;
    //   545: astore_3
    //   546: aload_3
    //   547: ifnull +187 -> 734
    //   550: aload_3
    //   551: arraylength
    //   552: istore 5
    //   554: iload 6
    //   556: istore 4
    //   558: iload 4
    //   560: iload 5
    //   562: if_icmpge +172 -> 734
    //   565: aload_3
    //   566: iload 4
    //   568: aaload
    //   569: astore_2
    //   570: aload_2
    //   571: invokevirtual 125	java/io/File:getName	()Ljava/lang/String;
    //   574: ldc 8
    //   576: invokevirtual 129	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   579: ifeq +12 -> 591
    //   582: iload 4
    //   584: iconst_1
    //   585: iadd
    //   586: istore 4
    //   588: goto -30 -> 558
    //   591: new 67	java/lang/StringBuilder
    //   594: dup
    //   595: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   598: astore_3
    //   599: aload_3
    //   600: aload_2
    //   601: invokevirtual 125	java/io/File:getName	()Ljava/lang/String;
    //   604: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: pop
    //   608: aload_3
    //   609: aload_2
    //   610: invokevirtual 132	java/io/File:length	()J
    //   613: invokevirtual 135	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   616: pop
    //   617: aload_3
    //   618: aload_2
    //   619: invokevirtual 138	java/io/File:lastModified	()J
    //   622: invokevirtual 135	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   625: pop
    //   626: aload_3
    //   627: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   630: invokestatic 142	com/tencent/commonsdk/classload/DexClassLoaderUtil:getBase64String	(Ljava/lang/String;)Ljava/lang/String;
    //   633: invokestatic 147	com/tencent/commonsdk/util/MD5Coding:encodeHexStr	(Ljava/lang/String;)Ljava/lang/String;
    //   636: astore_3
    //   637: new 67	java/lang/StringBuilder
    //   640: dup
    //   641: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   644: astore 8
    //   646: aload 8
    //   648: ldc 157
    //   650: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   653: pop
    //   654: aload 8
    //   656: aload 13
    //   658: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: pop
    //   662: aload 8
    //   664: ldc 8
    //   666: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   669: pop
    //   670: new 74	java/io/File
    //   673: dup
    //   674: aload 14
    //   676: aload 8
    //   678: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   681: invokespecial 100	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   684: astore 8
    //   686: aload_1
    //   687: ifnull +11 -> 698
    //   690: aload_1
    //   691: aload_3
    //   692: invokevirtual 161	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   695: ifne +13 -> 708
    //   698: aload 15
    //   700: aload 8
    //   702: aload_3
    //   703: aload 7
    //   705: invokestatic 23	com/tencent/commonsdk/classload/DexClassLoaderUtil:saveInfo	(Ljava/io/File;Ljava/io/File;Ljava/lang/String;Ljava/lang/String;)V
    //   708: aload 12
    //   710: ifnull +24 -> 734
    //   713: aload 12
    //   715: new 163	com/tencent/commonsdk/classload/DexClassLoaderUtil$CheckMD5Task
    //   718: dup
    //   719: aload_2
    //   720: aload_3
    //   721: aload 7
    //   723: aload 15
    //   725: aload 8
    //   727: invokespecial 166	com/tencent/commonsdk/classload/DexClassLoaderUtil$CheckMD5Task:<init>	(Ljava/io/File;Ljava/lang/String;Ljava/lang/String;Ljava/io/File;Ljava/io/File;)V
    //   730: invokevirtual 170	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   733: pop
    //   734: aload_0
    //   735: areturn
    //   736: astore_0
    //   737: aload 7
    //   739: astore_1
    //   740: aload_1
    //   741: invokestatic 118	com/tencent/commonsdk/classload/DexClassLoaderUtil:close	(Ljava/io/Closeable;)V
    //   744: goto +5 -> 749
    //   747: aload_0
    //   748: athrow
    //   749: goto -2 -> 747
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	752	0	paramString1	String
    //   0	752	1	paramString2	String
    //   0	752	2	paramString3	String
    //   0	752	3	paramClassLoader	java.lang.ClassLoader
    //   39	548	4	i	int
    //   47	516	5	j	int
    //   64	491	6	k	int
    //   9	729	7	localObject1	Object
    //   297	1	8	localException1	Exception
    //   319	1	8	localException2	Exception
    //   330	13	8	localException3	Exception
    //   353	373	8	localObject2	Object
    //   266	214	9	localObject3	Object
    //   277	36	10	str1	String
    //   248	264	11	localObject4	Object
    //   31	683	12	localHandler	Handler
    //   113	544	13	str2	String
    //   164	511	14	localFile1	java.io.File
    //   229	495	15	localFile2	java.io.File
    //   153	380	16	str3	String
    // Exception table:
    //   from	to	target	type
    //   288	294	297	java/lang/Exception
    //   272	279	319	java/lang/Exception
    //   250	268	326	finally
    //   250	268	330	java/lang/Exception
    //   272	279	736	finally
    //   288	294	736	finally
    //   342	347	736	finally
  }
  
  @SuppressLint({"NewApi"})
  private static String getBase64String(String paramString)
  {
    try
    {
      Object localObject = paramString.getBytes("UTF-8");
      if (Build.VERSION.SDK_INT >= 8)
      {
        localObject = Base64.encodeToString((byte[])localObject, 0);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramString;
  }
  
  /* Error */
  private static void saveInfo(java.io.File paramFile1, java.io.File paramFile2, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 4
    //   6: new 194	java/io/BufferedWriter
    //   9: dup
    //   10: new 196	java/io/FileWriter
    //   13: dup
    //   14: aload_1
    //   15: invokespecial 197	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   18: invokespecial 200	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   21: astore 5
    //   23: aload 5
    //   25: aload_2
    //   26: invokevirtual 203	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   29: aload 5
    //   31: invokevirtual 206	java/io/BufferedWriter:newLine	()V
    //   34: aload_3
    //   35: ifnull +9 -> 44
    //   38: aload 5
    //   40: aload_3
    //   41: invokevirtual 203	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   44: aload 5
    //   46: invokestatic 118	com/tencent/commonsdk/classload/DexClassLoaderUtil:close	(Ljava/io/Closeable;)V
    //   49: goto +37 -> 86
    //   52: astore_0
    //   53: aload 5
    //   55: astore 4
    //   57: goto +48 -> 105
    //   60: astore_3
    //   61: aload 5
    //   63: astore_2
    //   64: goto +11 -> 75
    //   67: astore_0
    //   68: goto +37 -> 105
    //   71: astore_3
    //   72: aload 6
    //   74: astore_2
    //   75: aload_2
    //   76: astore 4
    //   78: aload_3
    //   79: invokevirtual 34	java/lang/Exception:printStackTrace	()V
    //   82: aload_2
    //   83: invokestatic 118	com/tencent/commonsdk/classload/DexClassLoaderUtil:close	(Ljava/io/Closeable;)V
    //   86: aload_0
    //   87: invokevirtual 94	java/io/File:exists	()Z
    //   90: ifeq +8 -> 98
    //   93: aload_0
    //   94: invokevirtual 91	java/io/File:delete	()Z
    //   97: pop
    //   98: aload_1
    //   99: aload_0
    //   100: invokevirtual 210	java/io/File:renameTo	(Ljava/io/File;)Z
    //   103: pop
    //   104: return
    //   105: aload 4
    //   107: invokestatic 118	com/tencent/commonsdk/classload/DexClassLoaderUtil:close	(Ljava/io/Closeable;)V
    //   110: aload_0
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	paramFile1	java.io.File
    //   0	112	1	paramFile2	java.io.File
    //   0	112	2	paramString1	String
    //   0	112	3	paramString2	String
    //   4	102	4	localObject1	Object
    //   21	41	5	localBufferedWriter	java.io.BufferedWriter
    //   1	72	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   23	34	52	finally
    //   38	44	52	finally
    //   23	34	60	java/lang/Exception
    //   38	44	60	java/lang/Exception
    //   6	23	67	finally
    //   78	82	67	finally
    //   6	23	71	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.commonsdk.classload.DexClassLoaderUtil
 * JD-Core Version:    0.7.0.1
 */