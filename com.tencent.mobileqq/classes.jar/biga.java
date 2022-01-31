import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import java.io.File;

public class biga
{
  private static final String a = ;
  private static final String b = "http://dldir1.qq.com/weiyun/android/qq/" + a + "/weiyunLibrary" + 1004 + ".zip";
  private static final String c = "http://dldir1.qq.com/weiyun/android/qq/" + a + "/librarySize" + 1004 + ".txt";
  
  /* Error */
  static int a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 4
    //   12: new 54	java/io/File
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 57	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore_0
    //   21: aload_0
    //   22: invokevirtual 61	java/io/File:exists	()Z
    //   25: istore_2
    //   26: iload_2
    //   27: ifne +41 -> 68
    //   30: iconst_0
    //   31: ifeq +11 -> 42
    //   34: new 63	java/lang/NullPointerException
    //   37: dup
    //   38: invokespecial 64	java/lang/NullPointerException:<init>	()V
    //   41: athrow
    //   42: iconst_0
    //   43: ifeq +11 -> 54
    //   46: new 63	java/lang/NullPointerException
    //   49: dup
    //   50: invokespecial 64	java/lang/NullPointerException:<init>	()V
    //   53: athrow
    //   54: iconst_0
    //   55: ifeq +11 -> 66
    //   58: new 63	java/lang/NullPointerException
    //   61: dup
    //   62: invokespecial 64	java/lang/NullPointerException:<init>	()V
    //   65: athrow
    //   66: iconst_0
    //   67: ireturn
    //   68: new 66	java/io/FileInputStream
    //   71: dup
    //   72: aload_0
    //   73: invokespecial 69	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   76: astore 5
    //   78: aload 5
    //   80: ifnull +358 -> 438
    //   83: new 71	java/io/InputStreamReader
    //   86: dup
    //   87: aload 5
    //   89: invokespecial 74	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   92: astore_3
    //   93: new 76	java/io/BufferedReader
    //   96: dup
    //   97: aload_3
    //   98: invokespecial 79	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   101: astore 4
    //   103: ldc 81
    //   105: astore_0
    //   106: aload 4
    //   108: invokevirtual 84	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   111: astore 6
    //   113: aload 6
    //   115: ifnull +30 -> 145
    //   118: new 17	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   125: aload_0
    //   126: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload 6
    //   131: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: astore 6
    //   139: aload 6
    //   141: astore_0
    //   142: goto -36 -> 106
    //   145: aload 5
    //   147: ifnull +8 -> 155
    //   150: aload 5
    //   152: invokevirtual 89	java/io/InputStream:close	()V
    //   155: aload_3
    //   156: ifnull +7 -> 163
    //   159: aload_3
    //   160: invokevirtual 90	java/io/InputStreamReader:close	()V
    //   163: aload_0
    //   164: astore_3
    //   165: aload 4
    //   167: ifnull +10 -> 177
    //   170: aload 4
    //   172: invokevirtual 91	java/io/BufferedReader:close	()V
    //   175: aload_0
    //   176: astore_3
    //   177: aload_3
    //   178: invokestatic 97	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   181: ifne +161 -> 342
    //   184: aload_3
    //   185: invokestatic 102	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   188: istore_1
    //   189: iload_1
    //   190: ireturn
    //   191: astore_0
    //   192: aconst_null
    //   193: astore_3
    //   194: aconst_null
    //   195: astore 5
    //   197: ldc 81
    //   199: astore_0
    //   200: aload 7
    //   202: astore 4
    //   204: aload 5
    //   206: ifnull +8 -> 214
    //   209: aload 5
    //   211: invokevirtual 89	java/io/InputStream:close	()V
    //   214: aload_3
    //   215: ifnull +7 -> 222
    //   218: aload_3
    //   219: invokevirtual 90	java/io/InputStreamReader:close	()V
    //   222: aload_0
    //   223: astore_3
    //   224: aload 4
    //   226: ifnull -49 -> 177
    //   229: aload 4
    //   231: invokevirtual 91	java/io/BufferedReader:close	()V
    //   234: aload_0
    //   235: astore_3
    //   236: goto -59 -> 177
    //   239: astore_3
    //   240: aload_0
    //   241: astore_3
    //   242: goto -65 -> 177
    //   245: astore_0
    //   246: aconst_null
    //   247: astore_3
    //   248: aconst_null
    //   249: astore 5
    //   251: ldc 81
    //   253: astore_0
    //   254: aload 6
    //   256: astore 4
    //   258: aload 5
    //   260: ifnull +8 -> 268
    //   263: aload 5
    //   265: invokevirtual 89	java/io/InputStream:close	()V
    //   268: aload_3
    //   269: ifnull +7 -> 276
    //   272: aload_3
    //   273: invokevirtual 90	java/io/InputStreamReader:close	()V
    //   276: aload_0
    //   277: astore_3
    //   278: aload 4
    //   280: ifnull -103 -> 177
    //   283: aload 4
    //   285: invokevirtual 91	java/io/BufferedReader:close	()V
    //   288: aload_0
    //   289: astore_3
    //   290: goto -113 -> 177
    //   293: astore_3
    //   294: aload_0
    //   295: astore_3
    //   296: goto -119 -> 177
    //   299: astore_0
    //   300: aconst_null
    //   301: astore_3
    //   302: aconst_null
    //   303: astore 5
    //   305: aload 8
    //   307: astore 4
    //   309: aload 5
    //   311: ifnull +8 -> 319
    //   314: aload 5
    //   316: invokevirtual 89	java/io/InputStream:close	()V
    //   319: aload_3
    //   320: ifnull +7 -> 327
    //   323: aload_3
    //   324: invokevirtual 90	java/io/InputStreamReader:close	()V
    //   327: aload 4
    //   329: ifnull +8 -> 337
    //   332: aload 4
    //   334: invokevirtual 91	java/io/BufferedReader:close	()V
    //   337: aload_0
    //   338: athrow
    //   339: astore_0
    //   340: iconst_0
    //   341: ireturn
    //   342: iconst_0
    //   343: ireturn
    //   344: astore_3
    //   345: goto -8 -> 337
    //   348: astore_0
    //   349: aconst_null
    //   350: astore_3
    //   351: aload 8
    //   353: astore 4
    //   355: goto -46 -> 309
    //   358: astore_0
    //   359: aload 8
    //   361: astore 4
    //   363: goto -54 -> 309
    //   366: astore_0
    //   367: goto -58 -> 309
    //   370: astore_0
    //   371: aconst_null
    //   372: astore_3
    //   373: ldc 81
    //   375: astore_0
    //   376: aload 6
    //   378: astore 4
    //   380: goto -122 -> 258
    //   383: astore_0
    //   384: ldc 81
    //   386: astore_0
    //   387: aload 6
    //   389: astore 4
    //   391: goto -133 -> 258
    //   394: astore 6
    //   396: goto -138 -> 258
    //   399: astore_0
    //   400: aconst_null
    //   401: astore_3
    //   402: ldc 81
    //   404: astore_0
    //   405: aload 7
    //   407: astore 4
    //   409: goto -205 -> 204
    //   412: astore_0
    //   413: ldc 81
    //   415: astore_0
    //   416: aload 7
    //   418: astore 4
    //   420: goto -216 -> 204
    //   423: astore 6
    //   425: goto -221 -> 204
    //   428: astore_3
    //   429: aload_0
    //   430: astore_3
    //   431: goto -254 -> 177
    //   434: astore_0
    //   435: goto -369 -> 66
    //   438: aconst_null
    //   439: astore_3
    //   440: ldc 81
    //   442: astore_0
    //   443: goto -298 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	446	0	paramString	String
    //   188	2	1	i	int
    //   25	2	2	bool	boolean
    //   92	144	3	localObject1	Object
    //   239	1	3	localIOException1	java.io.IOException
    //   241	49	3	str1	String
    //   293	1	3	localIOException2	java.io.IOException
    //   295	29	3	str2	String
    //   344	1	3	localIOException3	java.io.IOException
    //   350	52	3	localObject2	Object
    //   428	1	3	localIOException4	java.io.IOException
    //   430	10	3	str3	String
    //   10	409	4	localObject3	Object
    //   76	239	5	localFileInputStream	java.io.FileInputStream
    //   4	384	6	str4	String
    //   394	1	6	localIOException5	java.io.IOException
    //   423	1	6	localFileNotFoundException	java.io.FileNotFoundException
    //   1	416	7	localObject4	Object
    //   7	353	8	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   12	26	191	java/io/FileNotFoundException
    //   68	78	191	java/io/FileNotFoundException
    //   209	214	239	java/io/IOException
    //   218	222	239	java/io/IOException
    //   229	234	239	java/io/IOException
    //   12	26	245	java/io/IOException
    //   68	78	245	java/io/IOException
    //   263	268	293	java/io/IOException
    //   272	276	293	java/io/IOException
    //   283	288	293	java/io/IOException
    //   12	26	299	finally
    //   68	78	299	finally
    //   184	189	339	java/lang/NumberFormatException
    //   314	319	344	java/io/IOException
    //   323	327	344	java/io/IOException
    //   332	337	344	java/io/IOException
    //   83	93	348	finally
    //   93	103	358	finally
    //   106	113	366	finally
    //   118	139	366	finally
    //   83	93	370	java/io/IOException
    //   93	103	383	java/io/IOException
    //   106	113	394	java/io/IOException
    //   118	139	394	java/io/IOException
    //   83	93	399	java/io/FileNotFoundException
    //   93	103	412	java/io/FileNotFoundException
    //   106	113	423	java/io/FileNotFoundException
    //   118	139	423	java/io/FileNotFoundException
    //   150	155	428	java/io/IOException
    //   159	163	428	java/io/IOException
    //   170	175	428	java/io/IOException
    //   34	42	434	java/io/IOException
    //   46	54	434	java/io/IOException
    //   58	66	434	java/io/IOException
  }
  
  public static File a(Context paramContext)
  {
    return new File(paramContext.getFilesDir(), "libwlc_upload_uni_v1.0.1.so");
  }
  
  public static void a(Context paramContext, bigd parambigd)
  {
    File localFile1 = a(paramContext);
    File localFile2 = b(paramContext);
    if ((localFile1.exists()) && (localFile2.exists()))
    {
      if (parambigd != null) {
        parambigd.a(localFile1.getAbsolutePath(), localFile2.getAbsolutePath());
      }
      return;
    }
    String str2 = bigf.a(123L);
    String str1 = str2 + "weiyunLibrary.zip";
    str2 = str2 + "sizeLibrary.txt";
    biep.a().a(b, str1, "SoHelper", new bigb(str2, str1, parambigd, paramContext, localFile1, localFile2));
  }
  
  static void a(File paramFile, String paramString)
  {
    paramFile.delete();
    paramFile = new File(paramString);
    if (paramFile.exists()) {
      paramFile.delete();
    }
  }
  
  public static boolean a(Context paramContext)
  {
    File localFile1 = a(paramContext);
    File localFile2 = b(paramContext);
    File localFile3 = new File(paramContext.getFilesDir(), "libWeiyunSDK.so");
    paramContext = bifz.a(paramContext, "0", "key_local_so_version");
    if ((localFile1.exists()) && ((localFile2.exists()) || (localFile3.exists())))
    {
      if (!String.valueOf(1004).equals(paramContext))
      {
        localFile1.delete();
        localFile2.delete();
        localFile3.delete();
      }
    }
    else {
      return false;
    }
    return true;
  }
  
  public static File b(Context paramContext)
  {
    return new File(paramContext.getFilesDir(), "libwlc_data_cmd_qq_v1.0.1.so");
  }
  
  private static String b()
  {
    String str;
    if (Build.VERSION.SDK_INT < 21) {
      str = Build.CPU_ABI;
    }
    while (!TextUtils.isEmpty(str)) {
      if ((AppSetting.b) && (str.contains("arm64-v8a")))
      {
        return "arm64-v8a";
        if ((Build.SUPPORTED_ABIS == null) || (Build.SUPPORTED_ABIS.length <= 0)) {
          str = null;
        } else {
          str = Build.SUPPORTED_ABIS[0];
        }
      }
      else if (str.contains("armeabi-v7a"))
      {
        return "armeabi-v7a";
      }
    }
    return "armeabi";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biga
 * JD-Core Version:    0.7.0.1
 */