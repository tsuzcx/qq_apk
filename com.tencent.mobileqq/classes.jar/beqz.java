import android.graphics.BitmapFactory.Options;
import com.tencent.image.DownloadParams;
import com.tencent.image.ProtocolDownloader.Adapter;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.URLState;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.AbsDownloader.1;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import mqq.os.MqqHandler;

public abstract class beqz
  extends ProtocolDownloader.Adapter
{
  public static final String a = antf.ba + "chatpic" + File.separator;
  
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
    return bfcj.a(localStringBuffer.toString());
  }
  
  private void a(besv parambesv, File paramFile)
  {
    ThreadManager.getFileThreadHandler().post(new AbsDownloader.1(this, parambesv));
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    int i = bhmi.a(paramString2, paramString3);
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
      Object localObject1 = beyq.a + File.separator + str;
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
  
  protected boolean a(File paramFile)
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
    //   2: aconst_null
    //   3: astore 9
    //   5: aconst_null
    //   6: astore 8
    //   8: aload_0
    //   9: invokevirtual 237	beqz:a	()Z
    //   12: ifeq +437 -> 449
    //   15: aload_1
    //   16: getfield 242	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   19: astore 7
    //   21: aload 7
    //   23: invokestatic 172	beqz:a	(Ljava/lang/String;)Ljava/io/File;
    //   26: astore 6
    //   28: aload 6
    //   30: ifnull +53 -> 83
    //   33: ldc 134
    //   35: ldc 251
    //   37: new 10	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   44: ldc 253
    //   46: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload 6
    //   51: invokevirtual 256	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   54: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 261	azpw:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   63: aload_2
    //   64: ifnull +14 -> 78
    //   67: aload_2
    //   68: aload 6
    //   70: invokevirtual 264	java/io/File:length	()J
    //   73: invokeinterface 270 3 0
    //   78: aload 6
    //   80: astore_1
    //   81: aload_1
    //   82: areturn
    //   83: aload_1
    //   84: getfield 274	com/tencent/image/DownloadParams:mHttpDownloaderParams	Ljava/lang/Object;
    //   87: ifnull +14 -> 101
    //   90: aload_0
    //   91: aconst_null
    //   92: aload_1
    //   93: aload_2
    //   94: invokevirtual 276	beqz:a	(Ljava/io/OutputStream;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;)Ljava/io/File;
    //   97: pop
    //   98: aload 6
    //   100: areturn
    //   101: aload 7
    //   103: invokestatic 194	beqz:c	(Ljava/lang/String;)Ljava/lang/String;
    //   106: astore 10
    //   108: getstatic 281	com/tencent/mobileqq/startup/step/InitUrlDrawable:a	Lbesu;
    //   111: aload 10
    //   113: invokevirtual 286	besu:a	(Ljava/lang/String;)Lbesv;
    //   116: astore 11
    //   118: aload_0
    //   119: invokevirtual 288	beqz:b	()Z
    //   122: istore 4
    //   124: iload 4
    //   126: ifeq +396 -> 522
    //   129: aload_1
    //   130: aload 11
    //   132: getfield 291	besv:a	Ljava/io/File;
    //   135: invokevirtual 264	java/io/File:length	()J
    //   138: putfield 295	com/tencent/image/DownloadParams:downloaded	J
    //   141: aload_0
    //   142: aload_1
    //   143: invokevirtual 297	beqz:a	(Lcom/tencent/image/DownloadParams;)Z
    //   146: istore 5
    //   148: iload 5
    //   150: ifne +5 -> 155
    //   153: iconst_1
    //   154: istore_3
    //   155: iload 4
    //   157: iload_3
    //   158: iand
    //   159: istore 4
    //   161: new 299	java/io/FileOutputStream
    //   164: dup
    //   165: aload 11
    //   167: getfield 291	besv:a	Ljava/io/File;
    //   170: iload 4
    //   172: invokespecial 302	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   175: astore 6
    //   177: aload_0
    //   178: aload 6
    //   180: aload_1
    //   181: aload_2
    //   182: invokevirtual 276	beqz:a	(Ljava/io/OutputStream;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;)Ljava/io/File;
    //   185: astore_2
    //   186: aload 7
    //   188: ldc_w 304
    //   191: invokevirtual 307	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   194: ifeq +322 -> 516
    //   197: aload 7
    //   199: iconst_0
    //   200: aload 7
    //   202: ldc_w 304
    //   205: invokevirtual 311	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   208: invokevirtual 126	java/lang/String:substring	(II)Ljava/lang/String;
    //   211: astore_1
    //   212: aload_1
    //   213: invokestatic 172	beqz:a	(Ljava/lang/String;)Ljava/io/File;
    //   216: astore 7
    //   218: aload 7
    //   220: ifnull +73 -> 293
    //   223: ldc 134
    //   225: ldc 251
    //   227: new 10	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   234: ldc_w 313
    //   237: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: aload 7
    //   242: invokevirtual 256	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   245: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokestatic 261	azpw:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   254: aload 11
    //   256: getfield 291	besv:a	Ljava/io/File;
    //   259: invokevirtual 316	java/io/File:delete	()Z
    //   262: pop
    //   263: aload 7
    //   265: astore_1
    //   266: aload 6
    //   268: ifnull -187 -> 81
    //   271: aload 7
    //   273: astore_1
    //   274: aload_2
    //   275: instanceof 318
    //   278: ifne -197 -> 81
    //   281: aload 6
    //   283: invokevirtual 323	java/io/OutputStream:close	()V
    //   286: aload 7
    //   288: areturn
    //   289: astore_1
    //   290: aload 7
    //   292: areturn
    //   293: aload_0
    //   294: aload_2
    //   295: invokevirtual 325	beqz:a	(Ljava/io/File;)Z
    //   298: ifeq +29 -> 327
    //   301: aload_0
    //   302: aload 11
    //   304: aload_2
    //   305: invokespecial 327	beqz:a	(Lbesv;Ljava/io/File;)V
    //   308: aload 6
    //   310: ifnull +15 -> 325
    //   313: aload_2
    //   314: instanceof 318
    //   317: ifne +8 -> 325
    //   320: aload 6
    //   322: invokevirtual 323	java/io/OutputStream:close	()V
    //   325: aload_2
    //   326: areturn
    //   327: aload 11
    //   329: invokevirtual 330	besv:a	()Ljava/io/File;
    //   332: astore 7
    //   334: aload 7
    //   336: astore_1
    //   337: aload 6
    //   339: ifnull -258 -> 81
    //   342: aload 7
    //   344: astore_1
    //   345: aload_2
    //   346: instanceof 318
    //   349: ifne -268 -> 81
    //   352: aload 6
    //   354: invokevirtual 323	java/io/OutputStream:close	()V
    //   357: aload 7
    //   359: areturn
    //   360: astore_1
    //   361: aload 7
    //   363: areturn
    //   364: astore_1
    //   365: aconst_null
    //   366: astore_2
    //   367: aload 8
    //   369: astore 6
    //   371: aload 11
    //   373: ifnull +10 -> 383
    //   376: aload 11
    //   378: iload 4
    //   380: invokevirtual 333	besv:a	(Z)V
    //   383: ldc_w 335
    //   386: ldc 251
    //   388: new 10	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   395: ldc_w 337
    //   398: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: aload 10
    //   403: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: ldc_w 339
    //   409: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: aload 7
    //   414: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   420: invokestatic 341	azpw:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   423: aload_1
    //   424: invokevirtual 342	java/lang/Exception:printStackTrace	()V
    //   427: aload_1
    //   428: athrow
    //   429: astore_1
    //   430: aload 6
    //   432: ifnull +15 -> 447
    //   435: aload_2
    //   436: instanceof 318
    //   439: ifne +8 -> 447
    //   442: aload 6
    //   444: invokevirtual 323	java/io/OutputStream:close	()V
    //   447: aload_1
    //   448: athrow
    //   449: aload_0
    //   450: aconst_null
    //   451: aload_1
    //   452: aload_2
    //   453: invokevirtual 276	beqz:a	(Ljava/io/OutputStream;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;)Ljava/io/File;
    //   456: areturn
    //   457: astore_2
    //   458: goto -11 -> 447
    //   461: astore_1
    //   462: aconst_null
    //   463: astore_2
    //   464: aload 9
    //   466: astore 6
    //   468: goto -38 -> 430
    //   471: astore_1
    //   472: aconst_null
    //   473: astore_2
    //   474: goto -44 -> 430
    //   477: astore_1
    //   478: goto -48 -> 430
    //   481: astore_1
    //   482: aconst_null
    //   483: astore_2
    //   484: aload 8
    //   486: astore 6
    //   488: goto -117 -> 371
    //   491: astore_1
    //   492: aconst_null
    //   493: astore_2
    //   494: goto -123 -> 371
    //   497: astore_1
    //   498: goto -127 -> 371
    //   501: astore 8
    //   503: aload_1
    //   504: astore 7
    //   506: aload 8
    //   508: astore_1
    //   509: goto -138 -> 371
    //   512: astore_1
    //   513: goto -188 -> 325
    //   516: aload 7
    //   518: astore_1
    //   519: goto -307 -> 212
    //   522: goto -361 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	525	0	this	beqz
    //   0	525	1	paramDownloadParams	DownloadParams
    //   0	525	2	paramURLDrawableHandler	URLDrawableHandler
    //   1	158	3	bool1	boolean
    //   122	257	4	bool2	boolean
    //   146	3	5	bool3	boolean
    //   26	461	6	localObject1	Object
    //   19	498	7	localObject2	Object
    //   6	479	8	localObject3	Object
    //   501	6	8	localException	java.lang.Exception
    //   3	462	9	localObject4	Object
    //   106	296	10	str	String
    //   116	261	11	localbesv	besv
    // Exception table:
    //   from	to	target	type
    //   274	286	289	java/io/IOException
    //   345	357	360	java/io/IOException
    //   129	148	364	java/lang/Exception
    //   376	383	429	finally
    //   383	429	429	finally
    //   435	447	457	java/io/IOException
    //   129	148	461	finally
    //   161	177	461	finally
    //   177	186	471	finally
    //   186	212	477	finally
    //   212	218	477	finally
    //   223	263	477	finally
    //   293	308	477	finally
    //   327	334	477	finally
    //   161	177	481	java/lang/Exception
    //   177	186	491	java/lang/Exception
    //   186	212	497	java/lang/Exception
    //   212	218	501	java/lang/Exception
    //   223	263	501	java/lang/Exception
    //   293	308	501	java/lang/Exception
    //   327	334	501	java/lang/Exception
    //   313	325	512	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beqz
 * JD-Core Version:    0.7.0.1
 */