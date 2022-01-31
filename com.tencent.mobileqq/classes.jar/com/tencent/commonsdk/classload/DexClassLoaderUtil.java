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
  private static Handler sHandler = null;
  public static Looper sLooper = null;
  
  private static void close(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
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
  
  /* Error */
  public static dalvik.system.DexClassLoader createDexClassLoader(String paramString1, String paramString2, String paramString3, java.lang.ClassLoader paramClassLoader)
  {
    // Byte code:
    //   0: getstatic 18	com/tencent/commonsdk/classload/DexClassLoaderUtil:sHandler	Landroid/os/Handler;
    //   3: ifnonnull +22 -> 25
    //   6: getstatic 16	com/tencent/commonsdk/classload/DexClassLoaderUtil:sLooper	Landroid/os/Looper;
    //   9: ifnull +16 -> 25
    //   12: new 42	android/os/Handler
    //   15: dup
    //   16: getstatic 16	com/tencent/commonsdk/classload/DexClassLoaderUtil:sLooper	Landroid/os/Looper;
    //   19: invokespecial 45	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   22: putstatic 18	com/tencent/commonsdk/classload/DexClassLoaderUtil:sHandler	Landroid/os/Handler;
    //   25: getstatic 18	com/tencent/commonsdk/classload/DexClassLoaderUtil:sHandler	Landroid/os/Handler;
    //   28: astore 10
    //   30: aload_0
    //   31: ldc 47
    //   33: invokevirtual 53	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   36: istore 4
    //   38: aload_0
    //   39: ldc 55
    //   41: invokevirtual 53	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   44: istore 5
    //   46: iload 4
    //   48: iload 5
    //   50: if_icmple +268 -> 318
    //   53: iload 4
    //   55: iflt +270 -> 325
    //   58: iload 4
    //   60: iconst_1
    //   61: iadd
    //   62: istore 4
    //   64: aload_0
    //   65: ldc 57
    //   67: invokevirtual 53	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   70: istore 5
    //   72: iload 5
    //   74: iflt +257 -> 331
    //   77: aload_0
    //   78: iload 4
    //   80: iload 5
    //   82: invokevirtual 61	java/lang/String:substring	(II)Ljava/lang/String;
    //   85: astore 11
    //   87: new 63	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   94: aload_1
    //   95: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: getstatic 73	java/io/File:separator	Ljava/lang/String;
    //   101: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload 11
    //   106: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: astore 14
    //   114: new 70	java/io/File
    //   117: dup
    //   118: aload 14
    //   120: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
    //   123: astore 13
    //   125: aload 13
    //   127: invokevirtual 84	java/io/File:isFile	()Z
    //   130: ifeq +9 -> 139
    //   133: aload 13
    //   135: invokevirtual 87	java/io/File:delete	()Z
    //   138: pop
    //   139: aload 13
    //   141: invokevirtual 90	java/io/File:exists	()Z
    //   144: ifne +9 -> 153
    //   147: aload 13
    //   149: invokevirtual 93	java/io/File:mkdirs	()Z
    //   152: pop
    //   153: new 70	java/io/File
    //   156: dup
    //   157: aload 13
    //   159: new 63	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   166: aload 11
    //   168: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: ldc 8
    //   173: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokespecial 96	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   182: astore 12
    //   184: aload 12
    //   186: invokevirtual 99	java/io/File:isDirectory	()Z
    //   189: ifeq +9 -> 198
    //   192: aload 12
    //   194: invokevirtual 87	java/io/File:delete	()Z
    //   197: pop
    //   198: aconst_null
    //   199: astore 9
    //   201: aconst_null
    //   202: astore 7
    //   204: aconst_null
    //   205: astore_1
    //   206: new 101	java/io/BufferedReader
    //   209: dup
    //   210: new 103	java/io/FileReader
    //   213: dup
    //   214: aload 12
    //   216: invokespecial 106	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   219: invokespecial 109	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   222: astore 8
    //   224: aload 8
    //   226: astore 6
    //   228: aload 8
    //   230: invokevirtual 112	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   233: astore_1
    //   234: aload 7
    //   236: astore 6
    //   238: aload_1
    //   239: ifnull +18 -> 257
    //   242: aload 8
    //   244: astore 6
    //   246: aload 8
    //   248: invokevirtual 112	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   251: astore 7
    //   253: aload 7
    //   255: astore 6
    //   257: aload 8
    //   259: invokestatic 114	com/tencent/commonsdk/classload/DexClassLoaderUtil:close	(Ljava/io/Closeable;)V
    //   262: aload 13
    //   264: invokevirtual 118	java/io/File:listFiles	()[Ljava/io/File;
    //   267: astore 8
    //   269: aload 8
    //   271: ifnull +392 -> 663
    //   274: aload 8
    //   276: arraylength
    //   277: istore 5
    //   279: iconst_0
    //   280: istore 4
    //   282: iload 4
    //   284: iload 5
    //   286: if_icmpge +377 -> 663
    //   289: aload 8
    //   291: iload 4
    //   293: aaload
    //   294: astore 7
    //   296: aload 7
    //   298: invokevirtual 121	java/io/File:getName	()Ljava/lang/String;
    //   301: ldc 8
    //   303: invokevirtual 125	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   306: ifeq +69 -> 375
    //   309: iload 4
    //   311: iconst_1
    //   312: iadd
    //   313: istore 4
    //   315: goto -33 -> 282
    //   318: iload 5
    //   320: istore 4
    //   322: goto -269 -> 53
    //   325: iconst_0
    //   326: istore 4
    //   328: goto -264 -> 64
    //   331: aload_0
    //   332: invokevirtual 129	java/lang/String:length	()I
    //   335: istore 5
    //   337: goto -260 -> 77
    //   340: astore 7
    //   342: aconst_null
    //   343: astore 8
    //   345: aconst_null
    //   346: astore_1
    //   347: aload 8
    //   349: astore 6
    //   351: aload 7
    //   353: invokevirtual 38	java/lang/Exception:printStackTrace	()V
    //   356: aload 8
    //   358: invokestatic 114	com/tencent/commonsdk/classload/DexClassLoaderUtil:close	(Ljava/io/Closeable;)V
    //   361: aload 9
    //   363: astore 6
    //   365: goto -103 -> 262
    //   368: astore_0
    //   369: aload_1
    //   370: invokestatic 114	com/tencent/commonsdk/classload/DexClassLoaderUtil:close	(Ljava/io/Closeable;)V
    //   373: aload_0
    //   374: athrow
    //   375: new 63	java/lang/StringBuilder
    //   378: dup
    //   379: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   382: aload 7
    //   384: invokevirtual 121	java/io/File:getName	()Ljava/lang/String;
    //   387: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: aload 7
    //   392: invokevirtual 132	java/io/File:length	()J
    //   395: invokevirtual 135	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   398: aload 7
    //   400: invokevirtual 138	java/io/File:lastModified	()J
    //   403: invokevirtual 135	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   406: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   409: invokestatic 142	com/tencent/commonsdk/classload/DexClassLoaderUtil:getBase64String	(Ljava/lang/String;)Ljava/lang/String;
    //   412: invokestatic 147	com/tencent/commonsdk/util/MD5Coding:encodeHexStr	(Ljava/lang/String;)Ljava/lang/String;
    //   415: astore 8
    //   417: aload_1
    //   418: ifnull +22 -> 440
    //   421: aload_1
    //   422: aload 8
    //   424: invokevirtual 150	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   427: ifeq +13 -> 440
    //   430: aload 6
    //   432: ifnonnull +231 -> 663
    //   435: aload 10
    //   437: ifnull +226 -> 663
    //   440: aload 7
    //   442: invokevirtual 87	java/io/File:delete	()Z
    //   445: pop
    //   446: aload 12
    //   448: invokevirtual 87	java/io/File:delete	()Z
    //   451: pop
    //   452: aconst_null
    //   453: astore 6
    //   455: aconst_null
    //   456: astore_1
    //   457: new 152	dalvik/system/DexClassLoader
    //   460: dup
    //   461: aload_0
    //   462: aload 14
    //   464: aload_2
    //   465: aload_3
    //   466: invokespecial 155	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   469: astore_0
    //   470: aload 13
    //   472: invokevirtual 118	java/io/File:listFiles	()[Ljava/io/File;
    //   475: astore_3
    //   476: aload_3
    //   477: ifnull +165 -> 642
    //   480: aload_3
    //   481: arraylength
    //   482: istore 5
    //   484: iconst_0
    //   485: istore 4
    //   487: iload 4
    //   489: iload 5
    //   491: if_icmpge +151 -> 642
    //   494: aload_3
    //   495: iload 4
    //   497: aaload
    //   498: astore_2
    //   499: aload_2
    //   500: invokevirtual 121	java/io/File:getName	()Ljava/lang/String;
    //   503: ldc 8
    //   505: invokevirtual 125	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   508: ifeq +12 -> 520
    //   511: iload 4
    //   513: iconst_1
    //   514: iadd
    //   515: istore 4
    //   517: goto -30 -> 487
    //   520: new 63	java/lang/StringBuilder
    //   523: dup
    //   524: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   527: aload_2
    //   528: invokevirtual 121	java/io/File:getName	()Ljava/lang/String;
    //   531: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: aload_2
    //   535: invokevirtual 132	java/io/File:length	()J
    //   538: invokevirtual 135	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   541: aload_2
    //   542: invokevirtual 138	java/io/File:lastModified	()J
    //   545: invokevirtual 135	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   548: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   551: invokestatic 142	com/tencent/commonsdk/classload/DexClassLoaderUtil:getBase64String	(Ljava/lang/String;)Ljava/lang/String;
    //   554: invokestatic 147	com/tencent/commonsdk/util/MD5Coding:encodeHexStr	(Ljava/lang/String;)Ljava/lang/String;
    //   557: astore_3
    //   558: new 70	java/io/File
    //   561: dup
    //   562: aload 13
    //   564: new 63	java/lang/StringBuilder
    //   567: dup
    //   568: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   571: ldc 157
    //   573: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: aload 11
    //   578: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: ldc 8
    //   583: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   589: invokespecial 96	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   592: astore 7
    //   594: aload_1
    //   595: ifnull +11 -> 606
    //   598: aload_1
    //   599: aload_3
    //   600: invokevirtual 161	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   603: ifne +13 -> 616
    //   606: aload 12
    //   608: aload 7
    //   610: aload_3
    //   611: aload 6
    //   613: invokestatic 27	com/tencent/commonsdk/classload/DexClassLoaderUtil:saveInfo	(Ljava/io/File;Ljava/io/File;Ljava/lang/String;Ljava/lang/String;)V
    //   616: aload 10
    //   618: ifnull +24 -> 642
    //   621: aload 10
    //   623: new 163	com/tencent/commonsdk/classload/DexClassLoaderUtil$CheckMD5Task
    //   626: dup
    //   627: aload_2
    //   628: aload_3
    //   629: aload 6
    //   631: aload 12
    //   633: aload 7
    //   635: invokespecial 166	com/tencent/commonsdk/classload/DexClassLoaderUtil$CheckMD5Task:<init>	(Ljava/io/File;Ljava/lang/String;Ljava/lang/String;Ljava/io/File;Ljava/io/File;)V
    //   638: invokevirtual 170	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   641: pop
    //   642: aload_0
    //   643: areturn
    //   644: astore_0
    //   645: aload 6
    //   647: astore_1
    //   648: goto -279 -> 369
    //   651: astore 7
    //   653: aconst_null
    //   654: astore_1
    //   655: goto -308 -> 347
    //   658: astore 7
    //   660: goto -313 -> 347
    //   663: goto -206 -> 457
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	666	0	paramString1	String
    //   0	666	1	paramString2	String
    //   0	666	2	paramString3	String
    //   0	666	3	paramClassLoader	java.lang.ClassLoader
    //   36	480	4	i	int
    //   44	448	5	j	int
    //   226	420	6	localObject1	Object
    //   202	95	7	str1	String
    //   340	101	7	localException1	Exception
    //   592	42	7	localFile1	java.io.File
    //   651	1	7	localException2	Exception
    //   658	1	7	localException3	Exception
    //   222	201	8	localObject2	Object
    //   199	163	9	localObject3	Object
    //   28	594	10	localHandler	Handler
    //   85	492	11	str2	String
    //   182	450	12	localFile2	java.io.File
    //   123	440	13	localFile3	java.io.File
    //   112	351	14	str3	String
    // Exception table:
    //   from	to	target	type
    //   206	224	340	java/lang/Exception
    //   206	224	368	finally
    //   228	234	644	finally
    //   246	253	644	finally
    //   351	356	644	finally
    //   228	234	651	java/lang/Exception
    //   246	253	658	java/lang/Exception
  }
  
  @SuppressLint({"NewApi"})
  private static String getBase64String(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("UTF-8");
      String str = paramString;
      if (Build.VERSION.SDK_INT >= 8) {
        str = Base64.encodeToString(arrayOfByte, 0);
      }
      return str;
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
    //   0: new 194	java/io/BufferedWriter
    //   3: dup
    //   4: new 196	java/io/FileWriter
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 197	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   12: invokespecial 200	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   15: astore 5
    //   17: aload 5
    //   19: astore 4
    //   21: aload 5
    //   23: aload_2
    //   24: invokevirtual 203	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   27: aload 5
    //   29: astore 4
    //   31: aload 5
    //   33: invokevirtual 206	java/io/BufferedWriter:newLine	()V
    //   36: aload_3
    //   37: ifnull +13 -> 50
    //   40: aload 5
    //   42: astore 4
    //   44: aload 5
    //   46: aload_3
    //   47: invokevirtual 203	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   50: aload 5
    //   52: invokestatic 114	com/tencent/commonsdk/classload/DexClassLoaderUtil:close	(Ljava/io/Closeable;)V
    //   55: aload_0
    //   56: invokevirtual 90	java/io/File:exists	()Z
    //   59: ifeq +8 -> 67
    //   62: aload_0
    //   63: invokevirtual 87	java/io/File:delete	()Z
    //   66: pop
    //   67: aload_1
    //   68: aload_0
    //   69: invokevirtual 210	java/io/File:renameTo	(Ljava/io/File;)Z
    //   72: pop
    //   73: return
    //   74: astore_3
    //   75: aconst_null
    //   76: astore_2
    //   77: aload_2
    //   78: astore 4
    //   80: aload_3
    //   81: invokevirtual 38	java/lang/Exception:printStackTrace	()V
    //   84: aload_2
    //   85: invokestatic 114	com/tencent/commonsdk/classload/DexClassLoaderUtil:close	(Ljava/io/Closeable;)V
    //   88: goto -33 -> 55
    //   91: astore_0
    //   92: aconst_null
    //   93: astore 4
    //   95: aload 4
    //   97: invokestatic 114	com/tencent/commonsdk/classload/DexClassLoaderUtil:close	(Ljava/io/Closeable;)V
    //   100: aload_0
    //   101: athrow
    //   102: astore_0
    //   103: goto -8 -> 95
    //   106: astore_3
    //   107: aload 5
    //   109: astore_2
    //   110: goto -33 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	paramFile1	java.io.File
    //   0	113	1	paramFile2	java.io.File
    //   0	113	2	paramString1	String
    //   0	113	3	paramString2	String
    //   19	77	4	localObject	Object
    //   15	93	5	localBufferedWriter	java.io.BufferedWriter
    // Exception table:
    //   from	to	target	type
    //   0	17	74	java/lang/Exception
    //   0	17	91	finally
    //   21	27	102	finally
    //   31	36	102	finally
    //   44	50	102	finally
    //   80	84	102	finally
    //   21	27	106	java/lang/Exception
    //   31	36	106	java/lang/Exception
    //   44	50	106	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.commonsdk.classload.DexClassLoaderUtil
 * JD-Core Version:    0.7.0.1
 */