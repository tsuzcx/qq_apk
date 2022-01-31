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

public abstract class axoa
  extends ProtocolDownloader.Adapter
{
  public static final String a = ajed.aU + "chatpic" + File.separator;
  
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
    return a + paramString1 + File.separator + str + File.separator + paramString2;
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    int i = bace.a(paramString2, paramString3);
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
      Object localObject1 = axwd.a + File.separator + str;
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
    //   3: invokevirtual 207	axoa:a	()Z
    //   6: ifeq +387 -> 393
    //   9: aload_1
    //   10: getfield 212	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   13: astore 6
    //   15: aload 6
    //   17: invokestatic 143	axoa:a	(Ljava/lang/String;)Ljava/io/File;
    //   20: astore 7
    //   22: aload 7
    //   24: ifnull +38 -> 62
    //   27: ldc 105
    //   29: ldc 221
    //   31: new 10	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   38: ldc 223
    //   40: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload 7
    //   45: invokevirtual 226	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   48: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 231	atpg:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   57: aload 7
    //   59: astore_1
    //   60: aload_1
    //   61: areturn
    //   62: aload_1
    //   63: getfield 235	com/tencent/image/DownloadParams:mHttpDownloaderParams	Ljava/lang/Object;
    //   66: ifnull +14 -> 80
    //   69: aload_0
    //   70: aconst_null
    //   71: aload_1
    //   72: aload_2
    //   73: invokevirtual 237	axoa:a	(Ljava/io/OutputStream;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;)Ljava/io/File;
    //   76: pop
    //   77: aload 7
    //   79: areturn
    //   80: aload 6
    //   82: invokestatic 165	axoa:c	(Ljava/lang/String;)Ljava/lang/String;
    //   85: astore 9
    //   87: getstatic 242	com/tencent/mobileqq/startup/step/InitUrlDrawable:a	Laxpv;
    //   90: aload 9
    //   92: invokevirtual 247	axpv:a	(Ljava/lang/String;)Laxpw;
    //   95: astore 10
    //   97: aload_0
    //   98: invokevirtual 249	axoa:b	()Z
    //   101: istore 4
    //   103: iload 4
    //   105: ifeq +338 -> 443
    //   108: aload_1
    //   109: aload 10
    //   111: getfield 252	axpw:a	Ljava/io/File;
    //   114: invokevirtual 255	java/io/File:length	()J
    //   117: putfield 259	com/tencent/image/DownloadParams:downloaded	J
    //   120: aload_0
    //   121: aload_1
    //   122: invokevirtual 261	axoa:a	(Lcom/tencent/image/DownloadParams;)Z
    //   125: istore 5
    //   127: iload 5
    //   129: ifne +5 -> 134
    //   132: iconst_1
    //   133: istore_3
    //   134: iload 4
    //   136: iload_3
    //   137: iand
    //   138: istore 4
    //   140: new 263	java/io/FileOutputStream
    //   143: dup
    //   144: aload 10
    //   146: getfield 252	axpw:a	Ljava/io/File;
    //   149: iload 4
    //   151: invokespecial 266	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   154: astore 8
    //   156: aload 8
    //   158: astore 7
    //   160: aload_0
    //   161: aload 8
    //   163: aload_1
    //   164: aload_2
    //   165: invokevirtual 237	axoa:a	(Ljava/io/OutputStream;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;)Ljava/io/File;
    //   168: pop
    //   169: aload 8
    //   171: astore 7
    //   173: aload 6
    //   175: ldc_w 268
    //   178: invokevirtual 271	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   181: ifeq +256 -> 437
    //   184: aload 8
    //   186: astore 7
    //   188: aload 6
    //   190: iconst_0
    //   191: aload 6
    //   193: ldc_w 268
    //   196: invokevirtual 275	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   199: invokevirtual 97	java/lang/String:substring	(II)Ljava/lang/String;
    //   202: astore_1
    //   203: aload 8
    //   205: astore 7
    //   207: aload_1
    //   208: invokestatic 143	axoa:a	(Ljava/lang/String;)Ljava/io/File;
    //   211: astore_2
    //   212: aload_2
    //   213: ifnull +67 -> 280
    //   216: aload 8
    //   218: astore 7
    //   220: ldc 105
    //   222: ldc 221
    //   224: new 10	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   231: ldc_w 277
    //   234: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload_2
    //   238: invokevirtual 226	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   241: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 231	atpg:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   250: aload 8
    //   252: astore 7
    //   254: aload 10
    //   256: getfield 252	axpw:a	Ljava/io/File;
    //   259: invokevirtual 280	java/io/File:delete	()Z
    //   262: pop
    //   263: aload_2
    //   264: astore_1
    //   265: aload 8
    //   267: ifnull -207 -> 60
    //   270: aload 8
    //   272: invokevirtual 285	java/io/OutputStream:close	()V
    //   275: aload_2
    //   276: areturn
    //   277: astore_1
    //   278: aload_2
    //   279: areturn
    //   280: aload 8
    //   282: astore 7
    //   284: aload 10
    //   286: invokevirtual 288	axpw:a	()Ljava/io/File;
    //   289: astore_2
    //   290: aload_2
    //   291: astore_1
    //   292: aload 8
    //   294: ifnull -234 -> 60
    //   297: aload 8
    //   299: invokevirtual 285	java/io/OutputStream:close	()V
    //   302: aload_2
    //   303: areturn
    //   304: astore_1
    //   305: aload_2
    //   306: areturn
    //   307: astore_1
    //   308: aconst_null
    //   309: astore_2
    //   310: aload 10
    //   312: ifnull +13 -> 325
    //   315: aload_2
    //   316: astore 7
    //   318: aload 10
    //   320: iload 4
    //   322: invokevirtual 291	axpw:a	(Z)V
    //   325: aload_2
    //   326: astore 7
    //   328: ldc_w 293
    //   331: ldc 221
    //   333: new 10	java/lang/StringBuilder
    //   336: dup
    //   337: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   340: ldc_w 295
    //   343: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: aload 9
    //   348: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: ldc_w 297
    //   354: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: aload 6
    //   359: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: invokestatic 299	atpg:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   368: aload_2
    //   369: astore 7
    //   371: aload_1
    //   372: invokevirtual 300	java/lang/Exception:printStackTrace	()V
    //   375: aload_2
    //   376: astore 7
    //   378: aload_1
    //   379: athrow
    //   380: astore_1
    //   381: aload 7
    //   383: ifnull +8 -> 391
    //   386: aload 7
    //   388: invokevirtual 285	java/io/OutputStream:close	()V
    //   391: aload_1
    //   392: athrow
    //   393: aload_0
    //   394: aconst_null
    //   395: aload_1
    //   396: aload_2
    //   397: invokevirtual 237	axoa:a	(Ljava/io/OutputStream;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;)Ljava/io/File;
    //   400: areturn
    //   401: astore_2
    //   402: goto -11 -> 391
    //   405: astore_1
    //   406: aconst_null
    //   407: astore 7
    //   409: goto -28 -> 381
    //   412: astore_1
    //   413: aconst_null
    //   414: astore_2
    //   415: goto -105 -> 310
    //   418: astore_1
    //   419: aload 8
    //   421: astore_2
    //   422: goto -112 -> 310
    //   425: astore_2
    //   426: aload_1
    //   427: astore 6
    //   429: aload_2
    //   430: astore_1
    //   431: aload 8
    //   433: astore_2
    //   434: goto -124 -> 310
    //   437: aload 6
    //   439: astore_1
    //   440: goto -237 -> 203
    //   443: goto -303 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	446	0	this	axoa
    //   0	446	1	paramDownloadParams	DownloadParams
    //   0	446	2	paramURLDrawableHandler	URLDrawableHandler
    //   1	137	3	bool1	boolean
    //   101	220	4	bool2	boolean
    //   125	3	5	bool3	boolean
    //   13	425	6	localObject1	Object
    //   20	388	7	localObject2	Object
    //   154	278	8	localFileOutputStream	java.io.FileOutputStream
    //   85	262	9	str	String
    //   95	224	10	localaxpw	axpw
    // Exception table:
    //   from	to	target	type
    //   270	275	277	java/io/IOException
    //   297	302	304	java/io/IOException
    //   108	127	307	java/lang/Exception
    //   160	169	380	finally
    //   173	184	380	finally
    //   188	203	380	finally
    //   207	212	380	finally
    //   220	250	380	finally
    //   254	263	380	finally
    //   284	290	380	finally
    //   318	325	380	finally
    //   328	368	380	finally
    //   371	375	380	finally
    //   378	380	380	finally
    //   386	391	401	java/io/IOException
    //   108	127	405	finally
    //   140	156	405	finally
    //   140	156	412	java/lang/Exception
    //   160	169	418	java/lang/Exception
    //   173	184	418	java/lang/Exception
    //   188	203	418	java/lang/Exception
    //   207	212	425	java/lang/Exception
    //   220	250	425	java/lang/Exception
    //   254	263	425	java/lang/Exception
    //   284	290	425	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axoa
 * JD-Core Version:    0.7.0.1
 */