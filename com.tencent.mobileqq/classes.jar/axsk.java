import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.image.DownloadParams;
import com.tencent.image.JobQueue;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.startup.step.InitUrlDrawable;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.Header;

public class axsk
  extends axoa
{
  private JobQueue a = new JobQueue(4);
  
  public static URL a(String paramString)
  {
    paramString = new URL(paramString);
    return new URL("nearbyimage", paramString.getAuthority(), paramString.getFile());
  }
  
  public static URL a(URL paramURL)
  {
    Object localObject1 = paramURL;
    String str;
    boolean bool;
    label59:
    Object localObject2;
    if (paramURL != null)
    {
      long l = SystemClock.elapsedRealtime();
      str = paramURL.getHost();
      Object localObject3 = null;
      int i = NetConnInfoCenter.getActiveNetIpFamily(true);
      if ((i != 2) && (i != 3)) {
        break label252;
      }
      bool = true;
      if (!bool) {
        break label258;
      }
      localObject1 = axwx.a().a(str, 1001, true, 28);
      localObject2 = localObject3;
      if (localObject1 != null)
      {
        localObject2 = localObject3;
        if (((ArrayList)localObject1).size() > 0) {
          localObject2 = (String)((ArrayList)localObject1).get(0);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("NearbyImgDownloader", 2, "convertURL: " + paramURL.toString() + " ip_zhitongche cost: " + (SystemClock.elapsedRealtime() - l) + " empty=" + TextUtils.isEmpty((CharSequence)localObject2) + " bIpv6=" + bool);
      }
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        if (!"p.qpic.cn".equals(str)) {
          break label274;
        }
        localObject1 = alzr.a(2);
      }
      label189:
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label521;
      }
    }
    for (;;)
    {
      localObject1 = new URL("http", (String)localObject1, paramURL.getFile());
      if (QLog.isColorLevel()) {
        QLog.i("NearbyImgDownloader", 2, "convertURL urlStr end: " + ((URL)localObject1).toString());
      }
      return localObject1;
      label252:
      bool = false;
      break;
      label258:
      localObject1 = axwx.a().a(str, 1001);
      break label59;
      label274:
      if ("p.qlogo.cn".equals(str))
      {
        localObject1 = alzr.a(1);
        break label189;
      }
      if ("ugc.qpic.cn".equals(str))
      {
        localObject1 = alzr.b(8);
        break label189;
      }
      if (a(str))
      {
        localObject1 = alzr.a(0);
        break label189;
      }
      if ("i.gtimg.cn".equals(str))
      {
        localObject1 = alzr.b();
        break label189;
      }
      if ("imgcache.qq.com".equals(str))
      {
        localObject1 = alzr.a();
        break label189;
      }
      if (c(str))
      {
        localObject1 = alzr.b(9);
        break label189;
      }
      if (d(str))
      {
        localObject1 = alzr.b(11);
        break label189;
      }
      if (e(str))
      {
        localObject1 = alzr.b(10);
        break label189;
      }
      if ("pgdt.gtimg.cn".equals(str))
      {
        localObject1 = alzr.a(3);
        break label189;
      }
      if ("sqimg.qq.com".equals(str))
      {
        localObject1 = alzr.a(4);
        break label189;
      }
      if ("download.wegame.qq.com".equals(str))
      {
        localObject1 = alzr.a(5);
        break label189;
      }
      if ("wfqqreader.3g.qq.com".equals(str))
      {
        localObject1 = alzr.a(6);
        break label189;
      }
      localObject1 = localObject2;
      if (!"buluo.qq.com".equals(str)) {
        break label189;
      }
      localObject1 = alzr.a(7);
      break label189;
      label521:
      localObject1 = str;
    }
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyImgDownloader", 2, "download img start url: " + paramString + " time: " + SystemClock.elapsedRealtime());
    }
  }
  
  private void a(String paramString, boolean paramBoolean, long paramLong)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("NearbyImgDownloader", 2, "download img end url: " + paramString + " " + paramBoolean + " " + paramLong);
      }
      return;
    }
    QLog.w("NearbyImgDownloader", 1, "download img end url: " + paramString + " " + paramBoolean + " " + paramLong);
  }
  
  /* Error */
  private boolean a(java.io.InputStream paramInputStream, long paramLong, axpw paramaxpw, URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: new 192	java/io/BufferedInputStream
    //   3: dup
    //   4: aload_1
    //   5: ldc 193
    //   7: invokespecial 196	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   10: astore 13
    //   12: ldc 193
    //   14: newarray byte
    //   16: astore 14
    //   18: new 198	java/io/FileOutputStream
    //   21: dup
    //   22: aload 4
    //   24: getfield 203	axpw:a	Ljava/io/File;
    //   27: iconst_0
    //   28: invokespecial 206	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   31: astore 4
    //   33: lconst_0
    //   34: lstore 8
    //   36: aload 4
    //   38: astore_1
    //   39: aload 13
    //   41: aload 14
    //   43: invokevirtual 212	java/io/InputStream:read	([B)I
    //   46: istore 6
    //   48: iload 6
    //   50: iconst_m1
    //   51: if_icmpeq +151 -> 202
    //   54: aload 4
    //   56: astore_1
    //   57: aload 4
    //   59: aload 14
    //   61: iconst_0
    //   62: iload 6
    //   64: invokevirtual 216	java/io/FileOutputStream:write	([BII)V
    //   67: lload 8
    //   69: iload 6
    //   71: i2l
    //   72: ladd
    //   73: lstore 10
    //   75: aload 4
    //   77: astore_1
    //   78: lload 10
    //   80: l2f
    //   81: lload_2
    //   82: l2f
    //   83: fdiv
    //   84: ldc 217
    //   86: fmul
    //   87: f2i
    //   88: istore 7
    //   90: aload 4
    //   92: astore_1
    //   93: aload 5
    //   95: iload 7
    //   97: invokeinterface 222 2 0
    //   102: lload 10
    //   104: lstore 8
    //   106: aload 4
    //   108: astore_1
    //   109: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   112: ifeq -76 -> 36
    //   115: aload 4
    //   117: astore_1
    //   118: ldc 80
    //   120: iconst_2
    //   121: new 82	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   128: ldc 224
    //   130: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: iload 7
    //   135: invokevirtual 227	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   138: ldc 229
    //   140: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: iload 6
    //   145: invokevirtual 227	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   148: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 115	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: lload 10
    //   156: lstore 8
    //   158: goto -122 -> 36
    //   161: astore 5
    //   163: aload 4
    //   165: astore_1
    //   166: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   169: ifeq +17 -> 186
    //   172: aload 4
    //   174: astore_1
    //   175: ldc 80
    //   177: iconst_2
    //   178: aload 5
    //   180: invokevirtual 230	java/io/IOException:toString	()Ljava/lang/String;
    //   183: invokestatic 182	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   186: iconst_0
    //   187: istore 12
    //   189: aload 13
    //   191: invokevirtual 233	java/io/InputStream:close	()V
    //   194: aload 4
    //   196: invokevirtual 234	java/io/FileOutputStream:close	()V
    //   199: iload 12
    //   201: ireturn
    //   202: aload 4
    //   204: astore_1
    //   205: aload 4
    //   207: invokevirtual 237	java/io/FileOutputStream:flush	()V
    //   210: iconst_1
    //   211: istore 12
    //   213: aload 13
    //   215: invokevirtual 233	java/io/InputStream:close	()V
    //   218: aload 4
    //   220: invokevirtual 234	java/io/FileOutputStream:close	()V
    //   223: iconst_1
    //   224: ireturn
    //   225: astore_1
    //   226: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   229: ifeq -30 -> 199
    //   232: ldc 80
    //   234: iconst_2
    //   235: aload_1
    //   236: invokevirtual 238	java/lang/Exception:toString	()Ljava/lang/String;
    //   239: invokestatic 182	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   242: iconst_1
    //   243: ireturn
    //   244: astore_1
    //   245: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   248: ifeq -49 -> 199
    //   251: ldc 80
    //   253: iconst_2
    //   254: aload_1
    //   255: invokevirtual 238	java/lang/Exception:toString	()Ljava/lang/String;
    //   258: invokestatic 182	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   261: iconst_0
    //   262: ireturn
    //   263: astore 4
    //   265: aconst_null
    //   266: astore_1
    //   267: aload 13
    //   269: invokevirtual 233	java/io/InputStream:close	()V
    //   272: aload_1
    //   273: invokevirtual 234	java/io/FileOutputStream:close	()V
    //   276: aload 4
    //   278: athrow
    //   279: astore_1
    //   280: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   283: ifeq -7 -> 276
    //   286: ldc 80
    //   288: iconst_2
    //   289: aload_1
    //   290: invokevirtual 238	java/lang/Exception:toString	()Ljava/lang/String;
    //   293: invokestatic 182	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   296: goto -20 -> 276
    //   299: astore 4
    //   301: goto -34 -> 267
    //   304: astore 5
    //   306: aconst_null
    //   307: astore 4
    //   309: goto -146 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	this	axsk
    //   0	312	1	paramInputStream	java.io.InputStream
    //   0	312	2	paramLong	long
    //   0	312	4	paramaxpw	axpw
    //   0	312	5	paramURLDrawableHandler	URLDrawableHandler
    //   46	98	6	i	int
    //   88	46	7	j	int
    //   34	123	8	l1	long
    //   73	82	10	l2	long
    //   187	25	12	bool	boolean
    //   10	258	13	localBufferedInputStream	java.io.BufferedInputStream
    //   16	44	14	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   39	48	161	java/io/IOException
    //   57	67	161	java/io/IOException
    //   78	90	161	java/io/IOException
    //   93	102	161	java/io/IOException
    //   109	115	161	java/io/IOException
    //   118	154	161	java/io/IOException
    //   205	210	161	java/io/IOException
    //   213	223	225	java/lang/Exception
    //   189	199	244	java/lang/Exception
    //   12	33	263	finally
    //   267	276	279	java/lang/Exception
    //   39	48	299	finally
    //   57	67	299	finally
    //   78	90	299	finally
    //   93	102	299	finally
    //   109	115	299	finally
    //   118	154	299	finally
    //   166	172	299	finally
    //   175	186	299	finally
    //   205	210	299	finally
    //   12	33	304	java/io/IOException
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.compile("^q\\d?.qlogo.cn$").matcher(paramString).find();
  }
  
  public static boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.compile("a[0-9].qpic.cn").matcher(paramString).find();
  }
  
  public static boolean d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.compile(".*qzs.qq.com").matcher(paramString).find();
  }
  
  public static boolean e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.compile(".*qzonestyle.gtimg.cn").matcher(paramString).find();
  }
  
  /* Error */
  public File a(axpw paramaxpw, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: getfield 274	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   5: invokespecial 276	axsk:a	(Ljava/lang/String;)V
    //   8: aload_3
    //   9: invokeinterface 279 1 0
    //   14: aload_2
    //   15: getfield 274	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   18: ldc_w 281
    //   21: invokevirtual 284	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   24: ifeq +223 -> 247
    //   27: aload_2
    //   28: aload_2
    //   29: getfield 274	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   32: ldc_w 281
    //   35: ldc_w 286
    //   38: invokevirtual 290	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   41: putfield 274	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   44: new 292	java/io/File
    //   47: dup
    //   48: aload_2
    //   49: getfield 296	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   52: invokevirtual 33	java/net/URL:getFile	()Ljava/lang/String;
    //   55: invokespecial 297	java/io/File:<init>	(Ljava/lang/String;)V
    //   58: astore 7
    //   60: aload 7
    //   62: invokevirtual 300	java/io/File:exists	()Z
    //   65: ifeq +161 -> 226
    //   68: aload 7
    //   70: invokevirtual 303	java/io/File:isFile	()Z
    //   73: ifeq +153 -> 226
    //   76: new 192	java/io/BufferedInputStream
    //   79: dup
    //   80: new 305	java/io/FileInputStream
    //   83: dup
    //   84: aload 7
    //   86: invokespecial 308	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   89: invokespecial 311	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   92: astore 8
    //   94: iconst_0
    //   95: istore 4
    //   97: aload_0
    //   98: aload 8
    //   100: aload 7
    //   102: invokevirtual 314	java/io/File:length	()J
    //   105: aload_1
    //   106: aload_3
    //   107: invokespecial 186	axsk:a	(Ljava/io/InputStream;JLaxpw;Lcom/tencent/image/URLDrawableHandler;)Z
    //   110: ifeq +30 -> 140
    //   113: aload_3
    //   114: aload 7
    //   116: invokevirtual 314	java/io/File:length	()J
    //   119: invokeinterface 318 3 0
    //   124: aload_0
    //   125: aload_2
    //   126: getfield 274	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   129: iconst_1
    //   130: aload 7
    //   132: invokevirtual 314	java/io/File:length	()J
    //   135: invokespecial 320	axsk:a	(Ljava/lang/String;ZJ)V
    //   138: aconst_null
    //   139: areturn
    //   140: iload 4
    //   142: iconst_3
    //   143: if_icmpne +24 -> 167
    //   146: aload_3
    //   147: iconst_4
    //   148: invokeinterface 323 2 0
    //   153: aload_0
    //   154: aload_2
    //   155: getfield 274	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   158: iconst_0
    //   159: ldc2_w 324
    //   162: invokespecial 320	axsk:a	(Ljava/lang/String;ZJ)V
    //   165: aconst_null
    //   166: areturn
    //   167: ldc2_w 326
    //   170: invokestatic 332	java/lang/Thread:sleep	(J)V
    //   173: iload 4
    //   175: iconst_1
    //   176: iadd
    //   177: istore 4
    //   179: iload 4
    //   181: iconst_3
    //   182: if_icmple +526 -> 708
    //   185: aload_3
    //   186: iconst_4
    //   187: invokeinterface 323 2 0
    //   192: aload_0
    //   193: aload_2
    //   194: getfield 274	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   197: iconst_0
    //   198: ldc2_w 324
    //   201: invokespecial 320	axsk:a	(Ljava/lang/String;ZJ)V
    //   204: aconst_null
    //   205: areturn
    //   206: astore_1
    //   207: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   210: ifeq -25 -> 185
    //   213: ldc 80
    //   215: iconst_2
    //   216: aload_1
    //   217: invokevirtual 333	java/io/FileNotFoundException:toString	()Ljava/lang/String;
    //   220: invokestatic 182	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   223: goto -38 -> 185
    //   226: aload_3
    //   227: iconst_4
    //   228: invokeinterface 323 2 0
    //   233: aload_0
    //   234: aload_2
    //   235: getfield 274	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   238: iconst_0
    //   239: ldc2_w 324
    //   242: invokespecial 320	axsk:a	(Ljava/lang/String;ZJ)V
    //   245: aconst_null
    //   246: areturn
    //   247: new 62	java/util/ArrayList
    //   250: dup
    //   251: invokespecial 334	java/util/ArrayList:<init>	()V
    //   254: astore 10
    //   256: new 21	java/net/URL
    //   259: dup
    //   260: aload_2
    //   261: getfield 274	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   264: invokespecial 24	java/net/URL:<init>	(Ljava/lang/String;)V
    //   267: astore 7
    //   269: aload 7
    //   271: invokevirtual 46	java/net/URL:getHost	()Ljava/lang/String;
    //   274: astore 11
    //   276: aload 10
    //   278: new 336	org/apache/http/message/BasicHeader
    //   281: dup
    //   282: ldc_w 338
    //   285: aload 11
    //   287: invokespecial 341	org/apache/http/message/BasicHeader:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   290: invokeinterface 346 2 0
    //   295: pop
    //   296: aload 7
    //   298: invokestatic 348	axsk:a	(Ljava/net/URL;)Ljava/net/URL;
    //   301: astore 7
    //   303: aload_2
    //   304: aload 7
    //   306: invokevirtual 92	java/net/URL:toString	()Ljava/lang/String;
    //   309: putfield 274	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   312: iconst_0
    //   313: istore 4
    //   315: invokestatic 351	android/os/SystemClock:uptimeMillis	()J
    //   318: lstore 5
    //   320: iload 4
    //   322: iconst_1
    //   323: iadd
    //   324: istore 4
    //   326: new 353	axsl
    //   329: dup
    //   330: aload_0
    //   331: aload_1
    //   332: aload_3
    //   333: aload_2
    //   334: invokespecial 356	axsl:<init>	(Laxsk;Laxpw;Lcom/tencent/image/URLDrawableHandler;Lcom/tencent/image/DownloadParams;)V
    //   337: astore 8
    //   339: aload_2
    //   340: getfield 274	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   343: aload 8
    //   345: aload 10
    //   347: iconst_1
    //   348: iconst_0
    //   349: sipush 10000
    //   352: sipush 20000
    //   355: invokestatic 361	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Ljava/lang/String;Lbacj;Ljava/util/List;IZII)Lanff;
    //   358: astore 8
    //   360: aload 8
    //   362: getfield 366	anff:b	I
    //   365: ifne +90 -> 455
    //   368: aload_3
    //   369: aload 8
    //   371: getfield 368	anff:e	I
    //   374: i2l
    //   375: invokeinterface 318 3 0
    //   380: aload_0
    //   381: aload_2
    //   382: getfield 274	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   385: iconst_1
    //   386: aload 8
    //   388: getfield 368	anff:e	I
    //   391: i2l
    //   392: invokespecial 320	axsk:a	(Ljava/lang/String;ZJ)V
    //   395: aconst_null
    //   396: areturn
    //   397: astore_1
    //   398: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   401: ifeq +32 -> 433
    //   404: ldc 80
    //   406: iconst_2
    //   407: new 82	java/lang/StringBuilder
    //   410: dup
    //   411: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   414: ldc_w 370
    //   417: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: aload_1
    //   421: invokevirtual 373	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   424: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: invokestatic 115	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   433: aload_3
    //   434: bipush 13
    //   436: invokeinterface 323 2 0
    //   441: aload_0
    //   442: aload_2
    //   443: getfield 274	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   446: iconst_0
    //   447: ldc2_w 374
    //   450: invokespecial 320	axsk:a	(Ljava/lang/String;ZJ)V
    //   453: aconst_null
    //   454: areturn
    //   455: invokestatic 351	android/os/SystemClock:uptimeMillis	()J
    //   458: lload 5
    //   460: lsub
    //   461: ldc2_w 376
    //   464: lcmp
    //   465: iflt +62 -> 527
    //   468: ldc 80
    //   470: iconst_1
    //   471: new 82	java/lang/StringBuilder
    //   474: dup
    //   475: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   478: ldc_w 379
    //   481: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: invokestatic 351	android/os/SystemClock:uptimeMillis	()J
    //   487: lload 5
    //   489: lsub
    //   490: invokevirtual 97	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   493: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   496: invokestatic 115	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   499: aload_3
    //   500: aload 8
    //   502: getfield 366	anff:b	I
    //   505: invokeinterface 323 2 0
    //   510: aload_0
    //   511: aload_2
    //   512: getfield 274	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   515: iconst_0
    //   516: aload 8
    //   518: getfield 366	anff:b	I
    //   521: i2l
    //   522: invokespecial 320	axsk:a	(Ljava/lang/String;ZJ)V
    //   525: aconst_null
    //   526: areturn
    //   527: iload 4
    //   529: iconst_2
    //   530: if_icmpne +31 -> 561
    //   533: aload_3
    //   534: aload 8
    //   536: getfield 366	anff:b	I
    //   539: invokeinterface 323 2 0
    //   544: aload_0
    //   545: aload_2
    //   546: getfield 274	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   549: iconst_0
    //   550: aload 8
    //   552: getfield 366	anff:b	I
    //   555: i2l
    //   556: invokespecial 320	axsk:a	(Ljava/lang/String;ZJ)V
    //   559: aconst_null
    //   560: areturn
    //   561: aload 7
    //   563: astore 8
    //   565: iload 4
    //   567: iconst_1
    //   568: if_icmpne +116 -> 684
    //   571: invokestatic 57	axwx:a	()Laxwx;
    //   574: aload 11
    //   576: aload 7
    //   578: invokevirtual 46	java/net/URL:getHost	()Ljava/lang/String;
    //   581: sipush 1001
    //   584: invokevirtual 382	axwx:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   587: new 21	java/net/URL
    //   590: dup
    //   591: ldc 128
    //   593: aload 11
    //   595: aload 7
    //   597: invokevirtual 33	java/net/URL:getFile	()Ljava/lang/String;
    //   600: invokespecial 36	java/net/URL:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   603: astore 8
    //   605: aload_2
    //   606: aload 8
    //   608: invokevirtual 92	java/net/URL:toString	()Ljava/lang/String;
    //   611: putfield 274	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   614: aload 8
    //   616: astore 7
    //   618: iload 4
    //   620: iconst_2
    //   621: if_icmple +84 -> 705
    //   624: aload_0
    //   625: aload_2
    //   626: getfield 274	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   629: iconst_0
    //   630: ldc2_w 383
    //   633: invokespecial 320	axsk:a	(Ljava/lang/String;ZJ)V
    //   636: aconst_null
    //   637: areturn
    //   638: astore 9
    //   640: aload 7
    //   642: astore 8
    //   644: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   647: ifeq +37 -> 684
    //   650: ldc 80
    //   652: iconst_2
    //   653: new 82	java/lang/StringBuilder
    //   656: dup
    //   657: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   660: ldc_w 386
    //   663: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: aload 9
    //   668: invokevirtual 373	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   671: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   674: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   677: invokestatic 115	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   680: aload 7
    //   682: astore 8
    //   684: aload 8
    //   686: astore 7
    //   688: goto -70 -> 618
    //   691: astore 9
    //   693: goto -520 -> 173
    //   696: astore 9
    //   698: aload 8
    //   700: astore 7
    //   702: goto -62 -> 640
    //   705: goto -385 -> 320
    //   708: goto -611 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	711	0	this	axsk
    //   0	711	1	paramaxpw	axpw
    //   0	711	2	paramDownloadParams	DownloadParams
    //   0	711	3	paramURLDrawableHandler	URLDrawableHandler
    //   95	527	4	i	int
    //   318	170	5	l	long
    //   58	643	7	localObject1	Object
    //   92	607	8	localObject2	Object
    //   638	29	9	localMalformedURLException1	java.net.MalformedURLException
    //   691	1	9	localInterruptedException	java.lang.InterruptedException
    //   696	1	9	localMalformedURLException2	java.net.MalformedURLException
    //   254	92	10	localArrayList	ArrayList
    //   274	320	11	str	String
    // Exception table:
    //   from	to	target	type
    //   76	94	206	java/io/FileNotFoundException
    //   97	138	206	java/io/FileNotFoundException
    //   146	165	206	java/io/FileNotFoundException
    //   167	173	206	java/io/FileNotFoundException
    //   256	312	397	java/net/MalformedURLException
    //   587	605	638	java/net/MalformedURLException
    //   167	173	691	java/lang/InterruptedException
    //   605	614	696	java/net/MalformedURLException
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return null;
  }
  
  public boolean a()
  {
    return true;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramURLDrawableHandler = paramDownloadParams.getHeader("gif_type");
    if (paramURLDrawableHandler != null)
    {
      paramURLDrawableHandler = paramURLDrawableHandler.getValue();
      float f = paramDownloadParams.mGifRoundCorner;
      if ((!TextUtils.isEmpty(paramURLDrawableHandler)) && (paramURLDrawableHandler.equals("1"))) {
        return new banv(paramFile, true, f, 1);
      }
    }
    return null;
  }
  
  public JobQueue getQueue(URL paramURL)
  {
    return this.a;
  }
  
  public File loadImageFile(DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    String str = paramDownloadParams.urlStr;
    Object localObject = a(str);
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("NearbyImgDownloader", 2, "loadImageFile file exist: " + ((File)localObject).getAbsolutePath());
      }
      return localObject;
    }
    localObject = c(str);
    localObject = InitUrlDrawable.a.a((String)localObject);
    try
    {
      a((axpw)localObject, paramDownloadParams, paramURLDrawableHandler);
      paramDownloadParams = a(str);
      if (paramDownloadParams != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("NearbyImgDownloader", 2, "loadImageFile f exist:" + paramDownloadParams.getAbsolutePath());
        }
        ((axpw)localObject).a.delete();
        return paramDownloadParams;
      }
    }
    catch (Exception paramDownloadParams)
    {
      if (localObject != null) {
        ((axpw)localObject).a(false);
      }
      throw paramDownloadParams;
    }
    paramDownloadParams = ((axpw)localObject).a();
    return paramDownloadParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axsk
 * JD-Core Version:    0.7.0.1
 */