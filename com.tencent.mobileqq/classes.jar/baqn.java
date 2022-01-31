import android.graphics.BitmapFactory.Options;
import com.tencent.image.DownloadParams;
import com.tencent.image.ProtocolDownloader.Adapter;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.URLState;
import com.tencent.image.Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

public abstract class baqn
  extends ProtocolDownloader.Adapter
{
  public static final String a = alof.aX + "chatpic" + File.separator;
  
  public static final File a(String paramString)
  {
    if (paramString != null)
    {
      paramString = new File(d(paramString));
      if (paramString.exists()) {
        return paramString;
      }
      return null;
    }
    return null;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    String str = paramString2.substring(paramString2.length() - 3);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(a);
    localStringBuffer.append(paramString1);
    localStringBuffer.append(File.separator);
    localStringBuffer.append(str);
    localStringBuffer.append(File.separator);
    localStringBuffer.append(paramString2);
    return bbck.a(localStringBuffer.toString());
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    int i = bdhb.a(paramString2, paramString3);
    if (QLog.isColorLevel()) {
      QLog.d("ChatImageMigrate", 2, "migrate:" + paramString1 + " from:" + paramString2 + " to:" + paramString3 + " status:" + i);
    }
  }
  
  public static final File b(String paramString)
  {
    if (paramString != null)
    {
      paramString = new File(d(paramString) + "_fp");
      if (paramString.exists()) {
        return paramString;
      }
      return null;
    }
    return null;
  }
  
  public static String b(String paramString)
  {
    String str = paramString;
    if (paramString != null) {
      str = paramString;
    }
    try
    {
      if (paramString.substring(0, "aiothumb".length()).equalsIgnoreCase("aiothumb"))
      {
        str = "chatthumb" + paramString.substring("aiothumb".length());
        if (QLog.isColorLevel()) {
          QLog.d("AbsDownloader", 2, "getUrlStringForDisk newUrl = " + str);
        }
      }
      return str;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      do
      {
        str = paramString;
      } while (!QLog.isColorLevel());
      QLog.d("AbsDownloader", 2, "getUrlStringForDisk IndexOutOfBoundsException" + localIndexOutOfBoundsException);
    }
    return paramString;
  }
  
  public static final boolean b(String paramString)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1;
    if (paramString != null) {
      if (paramString.startsWith("regionalthumb")) {
        localObject1 = localObject2;
      }
    }
    try
    {
      if (paramString.substring(0, "regionalthumb:".length()).equalsIgnoreCase("regionalthumb:")) {
        localObject1 = paramString.substring("regionalthumb:".length());
      }
      if (localObject1 != null)
      {
        paramString = ((String)localObject1).split("\\|");
        if (paramString != null)
        {
          return new File(paramString[0]).exists();
          if (paramString.toLowerCase(Locale.US).startsWith("file")) {
            localObject1 = localObject3;
          }
        }
      }
      try
      {
        if (paramString.substring(0, "file:".length()).equalsIgnoreCase("file:")) {
          localObject1 = paramString.substring("file:".length());
        }
        if (localObject1 != null)
        {
          return new File((String)localObject1).exists();
          paramString = b(paramString);
          if (paramString != null) {
            return a(paramString) != null;
          }
        }
        return false;
      }
      catch (IndexOutOfBoundsException paramString)
      {
        for (;;)
        {
          localObject1 = localObject3;
        }
      }
    }
    catch (IndexOutOfBoundsException paramString)
    {
      for (;;)
      {
        localObject1 = localObject2;
      }
    }
  }
  
  public static final String c(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.startsWith("pubaccountimage")) {
        str = paramString.replace("pubaccountimage:", "");
      }
    }
    return "Cache_" + Utils.Crc64String(str);
  }
  
  public static final String d(String paramString)
  {
    Object localObject4 = null;
    Object localObject2 = null;
    if (paramString == null) {}
    for (;;)
    {
      return localObject2;
      String str = c(paramString);
      Object localObject1 = bayu.a + File.separator + str;
      try
      {
        localObject2 = new URL(paramString);
        if (localObject2 != null) {
          localObject4 = ((URL)localObject2).getProtocol();
        }
        if ("chatthumb".equals(localObject4))
        {
          localObject2 = a((String)localObject4, str);
          if (new File((String)localObject2 + "_hd").exists())
          {
            localObject2 = (String)localObject2 + "_hd";
            i = 0;
            localObject4 = localObject1;
            localObject1 = localObject2;
            localObject2 = localObject1;
            if (i == 0) {
              continue;
            }
            a(paramString, (String)localObject4, (String)localObject1);
            return localObject1;
          }
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          int i;
          localMalformedURLException.printStackTrace();
          Object localObject3 = null;
          continue;
          if (new File((String)localObject1 + "_hd").exists())
          {
            localObject4 = (String)localObject1 + "_hd";
            localObject1 = (String)localObject3 + "_hd";
            i = 1;
          }
          else
          {
            if (new File((String)localObject1).exists())
            {
              localObject4 = localObject1;
              i = 1;
              localObject1 = localObject3;
              continue;
              if ("chatimg".equals(localObject4))
              {
                localObject4 = a((String)localObject4, str);
                localObject3 = localObject4;
                if (!new File((String)localObject1).exists()) {
                  break;
                }
                a(paramString, (String)localObject1, (String)localObject4);
                return localObject4;
              }
              if ("chatraw".equals(localObject4))
              {
                localObject4 = a((String)localObject4, str);
                localObject3 = localObject4;
                if (!new File((String)localObject1).exists()) {
                  break;
                }
                a(paramString, (String)localObject1, (String)localObject4);
                return localObject4;
              }
              return localObject1;
            }
            localObject4 = localObject1;
            i = 0;
            localObject1 = localObject3;
          }
        }
      }
    }
  }
  
  public static String e(String paramString)
  {
    return d(paramString) + "_dp";
  }
  
  protected int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    return URLState.calculateInSampleSize(paramOptions, paramInt1, paramInt2);
  }
  
  public abstract File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler);
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(DownloadParams paramDownloadParams)
  {
    return false;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public final boolean hasDiskFile(DownloadParams paramDownloadParams)
  {
    if (!a()) {
      return false;
    }
    return b(paramDownloadParams.urlStr);
  }
  
  /* Error */
  public File loadImageFile(DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: invokevirtual 218	baqn:a	()Z
    //   6: ifeq +402 -> 408
    //   9: aload_1
    //   10: getfield 223	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   13: astore 6
    //   15: aload 6
    //   17: invokestatic 154	baqn:a	(Ljava/lang/String;)Ljava/io/File;
    //   20: astore 7
    //   22: aload 7
    //   24: ifnull +53 -> 77
    //   27: ldc 116
    //   29: ldc 232
    //   31: new 10	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   38: ldc 234
    //   40: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload 7
    //   45: invokevirtual 237	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   48: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 242	awiw:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   57: aload_2
    //   58: ifnull +14 -> 72
    //   61: aload_2
    //   62: aload 7
    //   64: invokevirtual 245	java/io/File:length	()J
    //   67: invokeinterface 251 3 0
    //   72: aload 7
    //   74: astore_1
    //   75: aload_1
    //   76: areturn
    //   77: aload_1
    //   78: getfield 255	com/tencent/image/DownloadParams:mHttpDownloaderParams	Ljava/lang/Object;
    //   81: ifnull +14 -> 95
    //   84: aload_0
    //   85: aconst_null
    //   86: aload_1
    //   87: aload_2
    //   88: invokevirtual 257	baqn:a	(Ljava/io/OutputStream;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;)Ljava/io/File;
    //   91: pop
    //   92: aload 7
    //   94: areturn
    //   95: aload 6
    //   97: invokestatic 176	baqn:c	(Ljava/lang/String;)Ljava/lang/String;
    //   100: astore 9
    //   102: getstatic 262	com/tencent/mobileqq/startup/step/InitUrlDrawable:a	Lbasi;
    //   105: aload 9
    //   107: invokevirtual 267	basi:a	(Ljava/lang/String;)Lbasj;
    //   110: astore 10
    //   112: aload_0
    //   113: invokevirtual 269	baqn:b	()Z
    //   116: istore 4
    //   118: iload 4
    //   120: ifeq +338 -> 458
    //   123: aload_1
    //   124: aload 10
    //   126: getfield 272	basj:a	Ljava/io/File;
    //   129: invokevirtual 245	java/io/File:length	()J
    //   132: putfield 276	com/tencent/image/DownloadParams:downloaded	J
    //   135: aload_0
    //   136: aload_1
    //   137: invokevirtual 278	baqn:a	(Lcom/tencent/image/DownloadParams;)Z
    //   140: istore 5
    //   142: iload 5
    //   144: ifne +5 -> 149
    //   147: iconst_1
    //   148: istore_3
    //   149: iload 4
    //   151: iload_3
    //   152: iand
    //   153: istore 4
    //   155: new 280	java/io/FileOutputStream
    //   158: dup
    //   159: aload 10
    //   161: getfield 272	basj:a	Ljava/io/File;
    //   164: iload 4
    //   166: invokespecial 283	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   169: astore 8
    //   171: aload 8
    //   173: astore 7
    //   175: aload_0
    //   176: aload 8
    //   178: aload_1
    //   179: aload_2
    //   180: invokevirtual 257	baqn:a	(Ljava/io/OutputStream;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;)Ljava/io/File;
    //   183: pop
    //   184: aload 8
    //   186: astore 7
    //   188: aload 6
    //   190: ldc_w 285
    //   193: invokevirtual 288	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   196: ifeq +256 -> 452
    //   199: aload 8
    //   201: astore 7
    //   203: aload 6
    //   205: iconst_0
    //   206: aload 6
    //   208: ldc_w 285
    //   211: invokevirtual 292	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   214: invokevirtual 108	java/lang/String:substring	(II)Ljava/lang/String;
    //   217: astore_1
    //   218: aload 8
    //   220: astore 7
    //   222: aload_1
    //   223: invokestatic 154	baqn:a	(Ljava/lang/String;)Ljava/io/File;
    //   226: astore_2
    //   227: aload_2
    //   228: ifnull +67 -> 295
    //   231: aload 8
    //   233: astore 7
    //   235: ldc 116
    //   237: ldc 232
    //   239: new 10	java/lang/StringBuilder
    //   242: dup
    //   243: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   246: ldc_w 294
    //   249: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: aload_2
    //   253: invokevirtual 237	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   256: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: invokestatic 242	awiw:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   265: aload 8
    //   267: astore 7
    //   269: aload 10
    //   271: getfield 272	basj:a	Ljava/io/File;
    //   274: invokevirtual 297	java/io/File:delete	()Z
    //   277: pop
    //   278: aload_2
    //   279: astore_1
    //   280: aload 8
    //   282: ifnull -207 -> 75
    //   285: aload 8
    //   287: invokevirtual 302	java/io/OutputStream:close	()V
    //   290: aload_2
    //   291: areturn
    //   292: astore_1
    //   293: aload_2
    //   294: areturn
    //   295: aload 8
    //   297: astore 7
    //   299: aload 10
    //   301: invokevirtual 305	basj:a	()Ljava/io/File;
    //   304: astore_2
    //   305: aload_2
    //   306: astore_1
    //   307: aload 8
    //   309: ifnull -234 -> 75
    //   312: aload 8
    //   314: invokevirtual 302	java/io/OutputStream:close	()V
    //   317: aload_2
    //   318: areturn
    //   319: astore_1
    //   320: aload_2
    //   321: areturn
    //   322: astore_1
    //   323: aconst_null
    //   324: astore_2
    //   325: aload 10
    //   327: ifnull +13 -> 340
    //   330: aload_2
    //   331: astore 7
    //   333: aload 10
    //   335: iload 4
    //   337: invokevirtual 308	basj:a	(Z)V
    //   340: aload_2
    //   341: astore 7
    //   343: ldc_w 310
    //   346: ldc 232
    //   348: new 10	java/lang/StringBuilder
    //   351: dup
    //   352: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   355: ldc_w 312
    //   358: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: aload 9
    //   363: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: ldc_w 314
    //   369: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: aload 6
    //   374: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   380: invokestatic 316	awiw:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   383: aload_2
    //   384: astore 7
    //   386: aload_1
    //   387: invokevirtual 317	java/lang/Exception:printStackTrace	()V
    //   390: aload_2
    //   391: astore 7
    //   393: aload_1
    //   394: athrow
    //   395: astore_1
    //   396: aload 7
    //   398: ifnull +8 -> 406
    //   401: aload 7
    //   403: invokevirtual 302	java/io/OutputStream:close	()V
    //   406: aload_1
    //   407: athrow
    //   408: aload_0
    //   409: aconst_null
    //   410: aload_1
    //   411: aload_2
    //   412: invokevirtual 257	baqn:a	(Ljava/io/OutputStream;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;)Ljava/io/File;
    //   415: areturn
    //   416: astore_2
    //   417: goto -11 -> 406
    //   420: astore_1
    //   421: aconst_null
    //   422: astore 7
    //   424: goto -28 -> 396
    //   427: astore_1
    //   428: aconst_null
    //   429: astore_2
    //   430: goto -105 -> 325
    //   433: astore_1
    //   434: aload 8
    //   436: astore_2
    //   437: goto -112 -> 325
    //   440: astore_2
    //   441: aload_1
    //   442: astore 6
    //   444: aload_2
    //   445: astore_1
    //   446: aload 8
    //   448: astore_2
    //   449: goto -124 -> 325
    //   452: aload 6
    //   454: astore_1
    //   455: goto -237 -> 218
    //   458: goto -303 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	461	0	this	baqn
    //   0	461	1	paramDownloadParams	DownloadParams
    //   0	461	2	paramURLDrawableHandler	URLDrawableHandler
    //   1	152	3	bool1	boolean
    //   116	220	4	bool2	boolean
    //   140	3	5	bool3	boolean
    //   13	440	6	localObject1	Object
    //   20	403	7	localObject2	Object
    //   169	278	8	localFileOutputStream	java.io.FileOutputStream
    //   100	262	9	str	String
    //   110	224	10	localbasj	basj
    // Exception table:
    //   from	to	target	type
    //   285	290	292	java/io/IOException
    //   312	317	319	java/io/IOException
    //   123	142	322	java/lang/Exception
    //   175	184	395	finally
    //   188	199	395	finally
    //   203	218	395	finally
    //   222	227	395	finally
    //   235	265	395	finally
    //   269	278	395	finally
    //   299	305	395	finally
    //   333	340	395	finally
    //   343	383	395	finally
    //   386	390	395	finally
    //   393	395	395	finally
    //   401	406	416	java/io/IOException
    //   123	142	420	finally
    //   155	171	420	finally
    //   155	171	427	java/lang/Exception
    //   175	184	433	java/lang/Exception
    //   188	199	433	java/lang/Exception
    //   203	218	433	java/lang/Exception
    //   222	227	440	java/lang/Exception
    //   235	265	440	java/lang/Exception
    //   269	278	440	java/lang/Exception
    //   299	305	440	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baqn
 * JD-Core Version:    0.7.0.1
 */