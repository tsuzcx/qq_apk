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
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.Header;

public class bauz
  extends baqn
{
  private JobQueue a = new JobQueue(4);
  
  public static URL a(String paramString)
  {
    paramString = new URL(paramString);
    return new URL("nearbyimage", paramString.getAuthority(), paramString.getFile());
  }
  
  public static List<String> a(String paramString)
  {
    int i = 28;
    ArrayList localArrayList = new ArrayList();
    int k;
    Object localObject;
    int j;
    if (paramString != null)
    {
      long l = SystemClock.elapsedRealtime();
      boolean bool = alue.a().a();
      k = NetConnInfoCenter.getActiveNetIpFamily(true);
      if (k != 3) {
        break label348;
      }
      localObject = bazo.a();
      if (!bool) {
        break label343;
      }
      j = 28;
      localObject = ((bazo)localObject).a(paramString, 1001, true, j);
      if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
        localArrayList.add(((ArrayList)localObject).get(0));
      }
      localObject = bazo.a();
      if (bool) {
        i = 1;
      }
      localObject = ((bazo)localObject).a(paramString, 1001, true, i);
      if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
        localArrayList.add(((ArrayList)localObject).get(0));
      }
      if (QLog.isColorLevel()) {
        QLog.i("NearbyImgDownloader", 2, "convertURL: " + paramString.toString() + " ip_zhitongche cost: " + (SystemClock.elapsedRealtime() - l) + " ipType=" + k + " bPrefIpv6=" + bool + " ips=" + Arrays.toString(localArrayList.toArray()));
      }
      if ((localArrayList.size() == 0) && (k != 2))
      {
        localObject = null;
        if (!"p.qpic.cn".equals(paramString)) {
          break label417;
        }
        localObject = aokn.a(2);
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localArrayList.add(localObject);
      }
      if (localArrayList.size() < 2) {
        localArrayList.add(paramString);
      }
      if (QLog.isColorLevel()) {
        QLog.i("NearbyImgDownloader", 2, "convertURL urlStr end: ips=" + Arrays.toString(localArrayList.toArray()));
      }
      return localArrayList;
      label343:
      j = 1;
      break;
      label348:
      if (k == 2)
      {
        j = 1;
        label355:
        localObject = bazo.a();
        if (j == 0) {
          break label412;
        }
      }
      for (;;)
      {
        localObject = ((bazo)localObject).a(paramString, 1001, true, i);
        if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {
          break;
        }
        localArrayList.add(((ArrayList)localObject).get(0));
        break;
        j = 0;
        break label355;
        label412:
        i = 1;
      }
      label417:
      if ("p.qlogo.cn".equals(paramString)) {
        localObject = aokn.a(1);
      } else if ("ugc.qpic.cn".equals(paramString)) {
        localObject = aokn.b(8);
      } else if (a(paramString)) {
        localObject = aokn.a(0);
      } else if ("i.gtimg.cn".equals(paramString)) {
        localObject = aokn.b();
      } else if ("imgcache.qq.com".equals(paramString)) {
        localObject = aokn.a();
      } else if (c(paramString)) {
        localObject = aokn.b(9);
      } else if (d(paramString)) {
        localObject = aokn.b(11);
      } else if (e(paramString)) {
        localObject = aokn.b(10);
      } else if ("pgdt.gtimg.cn".equals(paramString)) {
        localObject = aokn.a(3);
      } else if ("sqimg.qq.com".equals(paramString)) {
        localObject = aokn.a(4);
      } else if ("download.wegame.qq.com".equals(paramString)) {
        localObject = aokn.a(5);
      } else if ("wfqqreader.3g.qq.com".equals(paramString)) {
        localObject = aokn.a(6);
      } else if ("buluo.qq.com".equals(paramString)) {
        localObject = aokn.a(7);
      }
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
  private boolean a(java.io.InputStream paramInputStream, long paramLong, basj parambasj, URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: new 214	java/io/BufferedInputStream
    //   3: dup
    //   4: aload_1
    //   5: ldc 215
    //   7: invokespecial 218	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   10: astore 13
    //   12: ldc 215
    //   14: newarray byte
    //   16: astore 14
    //   18: new 220	java/io/FileOutputStream
    //   21: dup
    //   22: aload 4
    //   24: getfield 225	basj:a	Ljava/io/File;
    //   27: iconst_0
    //   28: invokespecial 228	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   31: astore 4
    //   33: lconst_0
    //   34: lstore 8
    //   36: aload 4
    //   38: astore_1
    //   39: aload 13
    //   41: aload 14
    //   43: invokevirtual 234	java/io/InputStream:read	([B)I
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
    //   64: invokevirtual 238	java/io/FileOutputStream:write	([BII)V
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
    //   84: ldc 239
    //   86: fmul
    //   87: f2i
    //   88: istore 7
    //   90: aload 4
    //   92: astore_1
    //   93: aload 5
    //   95: iload 7
    //   97: invokeinterface 244 2 0
    //   102: lload 10
    //   104: lstore 8
    //   106: aload 4
    //   108: astore_1
    //   109: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   112: ifeq -76 -> 36
    //   115: aload 4
    //   117: astore_1
    //   118: ldc 89
    //   120: iconst_2
    //   121: new 91	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   128: ldc 246
    //   130: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: iload 7
    //   135: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   138: ldc 248
    //   140: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: iload 6
    //   145: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   148: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 134	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: lload 10
    //   156: lstore 8
    //   158: goto -122 -> 36
    //   161: astore 5
    //   163: aload 4
    //   165: astore_1
    //   166: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   169: ifeq +17 -> 186
    //   172: aload 4
    //   174: astore_1
    //   175: ldc 89
    //   177: iconst_2
    //   178: aload 5
    //   180: invokevirtual 249	java/io/IOException:toString	()Ljava/lang/String;
    //   183: invokestatic 204	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   186: iconst_0
    //   187: istore 12
    //   189: aload 13
    //   191: invokevirtual 252	java/io/InputStream:close	()V
    //   194: aload 4
    //   196: invokevirtual 253	java/io/FileOutputStream:close	()V
    //   199: iload 12
    //   201: ireturn
    //   202: aload 4
    //   204: astore_1
    //   205: aload 4
    //   207: invokevirtual 256	java/io/FileOutputStream:flush	()V
    //   210: iconst_1
    //   211: istore 12
    //   213: aload 13
    //   215: invokevirtual 252	java/io/InputStream:close	()V
    //   218: aload 4
    //   220: invokevirtual 253	java/io/FileOutputStream:close	()V
    //   223: iconst_1
    //   224: ireturn
    //   225: astore_1
    //   226: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   229: ifeq -30 -> 199
    //   232: ldc 89
    //   234: iconst_2
    //   235: aload_1
    //   236: invokevirtual 257	java/lang/Exception:toString	()Ljava/lang/String;
    //   239: invokestatic 204	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   242: iconst_1
    //   243: ireturn
    //   244: astore_1
    //   245: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   248: ifeq -49 -> 199
    //   251: ldc 89
    //   253: iconst_2
    //   254: aload_1
    //   255: invokevirtual 257	java/lang/Exception:toString	()Ljava/lang/String;
    //   258: invokestatic 204	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   261: iconst_0
    //   262: ireturn
    //   263: astore 4
    //   265: aconst_null
    //   266: astore_1
    //   267: aload 13
    //   269: invokevirtual 252	java/io/InputStream:close	()V
    //   272: aload_1
    //   273: invokevirtual 253	java/io/FileOutputStream:close	()V
    //   276: aload 4
    //   278: athrow
    //   279: astore_1
    //   280: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   283: ifeq -7 -> 276
    //   286: ldc 89
    //   288: iconst_2
    //   289: aload_1
    //   290: invokevirtual 257	java/lang/Exception:toString	()Ljava/lang/String;
    //   293: invokestatic 204	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   296: goto -20 -> 276
    //   299: astore 4
    //   301: goto -34 -> 267
    //   304: astore 5
    //   306: aconst_null
    //   307: astore 4
    //   309: goto -146 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	this	bauz
    //   0	312	1	paramInputStream	java.io.InputStream
    //   0	312	2	paramLong	long
    //   0	312	4	parambasj	basj
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
  public File a(basj parambasj, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: getfield 293	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   5: invokespecial 295	bauz:a	(Ljava/lang/String;)V
    //   8: aload_3
    //   9: invokeinterface 298 1 0
    //   14: aload_2
    //   15: getfield 293	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   18: ldc_w 300
    //   21: invokevirtual 303	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   24: ifeq +223 -> 247
    //   27: aload_2
    //   28: aload_2
    //   29: getfield 293	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   32: ldc_w 300
    //   35: ldc_w 305
    //   38: invokevirtual 309	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   41: putfield 293	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   44: new 311	java/io/File
    //   47: dup
    //   48: aload_2
    //   49: getfield 315	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   52: invokevirtual 33	java/net/URL:getFile	()Ljava/lang/String;
    //   55: invokespecial 316	java/io/File:<init>	(Ljava/lang/String;)V
    //   58: astore 8
    //   60: aload 8
    //   62: invokevirtual 319	java/io/File:exists	()Z
    //   65: ifeq +161 -> 226
    //   68: aload 8
    //   70: invokevirtual 322	java/io/File:isFile	()Z
    //   73: ifeq +153 -> 226
    //   76: new 214	java/io/BufferedInputStream
    //   79: dup
    //   80: new 324	java/io/FileInputStream
    //   83: dup
    //   84: aload 8
    //   86: invokespecial 327	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   89: invokespecial 330	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   92: astore 9
    //   94: iconst_0
    //   95: istore 4
    //   97: aload_0
    //   98: aload 9
    //   100: aload 8
    //   102: invokevirtual 333	java/io/File:length	()J
    //   105: aload_1
    //   106: aload_3
    //   107: invokespecial 208	bauz:a	(Ljava/io/InputStream;JLbasj;Lcom/tencent/image/URLDrawableHandler;)Z
    //   110: ifeq +30 -> 140
    //   113: aload_3
    //   114: aload 8
    //   116: invokevirtual 333	java/io/File:length	()J
    //   119: invokeinterface 337 3 0
    //   124: aload_0
    //   125: aload_2
    //   126: getfield 293	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   129: iconst_1
    //   130: aload 8
    //   132: invokevirtual 333	java/io/File:length	()J
    //   135: invokespecial 339	bauz:a	(Ljava/lang/String;ZJ)V
    //   138: aconst_null
    //   139: areturn
    //   140: iload 4
    //   142: iconst_3
    //   143: if_icmpne +24 -> 167
    //   146: aload_3
    //   147: iconst_4
    //   148: invokeinterface 342 2 0
    //   153: aload_0
    //   154: aload_2
    //   155: getfield 293	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   158: iconst_0
    //   159: ldc2_w 343
    //   162: invokespecial 339	bauz:a	(Ljava/lang/String;ZJ)V
    //   165: aconst_null
    //   166: areturn
    //   167: ldc2_w 345
    //   170: invokestatic 351	java/lang/Thread:sleep	(J)V
    //   173: iload 4
    //   175: iconst_1
    //   176: iadd
    //   177: istore 4
    //   179: iload 4
    //   181: iconst_3
    //   182: if_icmple +538 -> 720
    //   185: aload_3
    //   186: iconst_4
    //   187: invokeinterface 342 2 0
    //   192: aload_0
    //   193: aload_2
    //   194: getfield 293	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   197: iconst_0
    //   198: ldc2_w 343
    //   201: invokespecial 339	bauz:a	(Ljava/lang/String;ZJ)V
    //   204: aconst_null
    //   205: areturn
    //   206: astore_1
    //   207: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   210: ifeq -25 -> 185
    //   213: ldc 89
    //   215: iconst_2
    //   216: aload_1
    //   217: invokevirtual 352	java/io/FileNotFoundException:toString	()Ljava/lang/String;
    //   220: invokestatic 204	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   223: goto -38 -> 185
    //   226: aload_3
    //   227: iconst_4
    //   228: invokeinterface 342 2 0
    //   233: aload_0
    //   234: aload_2
    //   235: getfield 293	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   238: iconst_0
    //   239: ldc2_w 343
    //   242: invokespecial 339	bauz:a	(Ljava/lang/String;ZJ)V
    //   245: aconst_null
    //   246: areturn
    //   247: new 39	java/util/ArrayList
    //   250: dup
    //   251: invokespecial 40	java/util/ArrayList:<init>	()V
    //   254: astore 9
    //   256: new 39	java/util/ArrayList
    //   259: dup
    //   260: invokespecial 40	java/util/ArrayList:<init>	()V
    //   263: astore 10
    //   265: new 21	java/net/URL
    //   268: dup
    //   269: aload_2
    //   270: getfield 293	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   273: invokespecial 24	java/net/URL:<init>	(Ljava/lang/String;)V
    //   276: astore 11
    //   278: aload 11
    //   280: invokevirtual 355	java/net/URL:getHost	()Ljava/lang/String;
    //   283: astore 12
    //   285: aload 10
    //   287: new 357	org/apache/http/message/BasicHeader
    //   290: dup
    //   291: ldc_w 359
    //   294: aload 12
    //   296: invokespecial 362	org/apache/http/message/BasicHeader:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   299: invokeinterface 82 2 0
    //   304: pop
    //   305: aload 9
    //   307: aload 12
    //   309: invokestatic 364	bauz:a	(Ljava/lang/String;)Ljava/util/List;
    //   312: invokeinterface 368 2 0
    //   317: pop
    //   318: iconst_0
    //   319: istore 4
    //   321: invokestatic 371	android/os/SystemClock:uptimeMillis	()J
    //   324: lstore 6
    //   326: iload 4
    //   328: iconst_1
    //   329: iadd
    //   330: istore 5
    //   332: aload 9
    //   334: invokeinterface 135 1 0
    //   339: iload 5
    //   341: if_icmplt +121 -> 462
    //   344: iload 5
    //   346: iconst_1
    //   347: isub
    //   348: istore 4
    //   350: new 21	java/net/URL
    //   353: dup
    //   354: ldc_w 373
    //   357: aload 9
    //   359: iload 4
    //   361: invokeinterface 374 2 0
    //   366: checkcast 100	java/lang/String
    //   369: aload 11
    //   371: invokevirtual 33	java/net/URL:getFile	()Ljava/lang/String;
    //   374: invokespecial 36	java/net/URL:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   377: astore 8
    //   379: aload 8
    //   381: ifnonnull +116 -> 497
    //   384: iload 5
    //   386: iconst_2
    //   387: if_icmple +326 -> 713
    //   390: aload_0
    //   391: aload_2
    //   392: getfield 293	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   395: iconst_0
    //   396: ldc2_w 375
    //   399: invokespecial 339	bauz:a	(Ljava/lang/String;ZJ)V
    //   402: aconst_null
    //   403: areturn
    //   404: astore_1
    //   405: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   408: ifeq +32 -> 440
    //   411: ldc 89
    //   413: iconst_2
    //   414: new 91	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   421: ldc_w 378
    //   424: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: aload_1
    //   428: invokevirtual 381	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   431: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   437: invokestatic 134	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   440: aload_3
    //   441: bipush 13
    //   443: invokeinterface 342 2 0
    //   448: aload_0
    //   449: aload_2
    //   450: getfield 293	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   453: iconst_0
    //   454: ldc2_w 382
    //   457: invokespecial 339	bauz:a	(Ljava/lang/String;ZJ)V
    //   460: aconst_null
    //   461: areturn
    //   462: aload 9
    //   464: invokeinterface 135 1 0
    //   469: iconst_1
    //   470: isub
    //   471: istore 4
    //   473: goto -123 -> 350
    //   476: astore 8
    //   478: ldc 89
    //   480: iconst_1
    //   481: aload 8
    //   483: invokevirtual 381	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   486: aload 8
    //   488: invokestatic 386	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   491: aconst_null
    //   492: astore 8
    //   494: goto -115 -> 379
    //   497: aload_2
    //   498: aload 8
    //   500: invokevirtual 387	java/net/URL:toString	()Ljava/lang/String;
    //   503: putfield 293	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   506: new 389	bava
    //   509: dup
    //   510: aload_0
    //   511: aload_1
    //   512: aload_3
    //   513: aload_2
    //   514: invokespecial 392	bava:<init>	(Lbauz;Lbasj;Lcom/tencent/image/URLDrawableHandler;Lcom/tencent/image/DownloadParams;)V
    //   517: astore 8
    //   519: aload_2
    //   520: getfield 293	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   523: aload 8
    //   525: aload 10
    //   527: iconst_1
    //   528: iconst_0
    //   529: sipush 10000
    //   532: sipush 20000
    //   535: invokestatic 397	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Ljava/lang/String;Lbdhg;Ljava/util/List;IZII)Laprk;
    //   538: astore 8
    //   540: aload 8
    //   542: getfield 402	aprk:b	I
    //   545: ifne +32 -> 577
    //   548: aload_3
    //   549: aload 8
    //   551: getfield 404	aprk:e	I
    //   554: i2l
    //   555: invokeinterface 337 3 0
    //   560: aload_0
    //   561: aload_2
    //   562: getfield 293	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   565: iconst_1
    //   566: aload 8
    //   568: getfield 404	aprk:e	I
    //   571: i2l
    //   572: invokespecial 339	bauz:a	(Ljava/lang/String;ZJ)V
    //   575: aconst_null
    //   576: areturn
    //   577: invokestatic 371	android/os/SystemClock:uptimeMillis	()J
    //   580: lload 6
    //   582: lsub
    //   583: ldc2_w 405
    //   586: lcmp
    //   587: iflt +62 -> 649
    //   590: ldc 89
    //   592: iconst_1
    //   593: new 91	java/lang/StringBuilder
    //   596: dup
    //   597: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   600: ldc_w 408
    //   603: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: invokestatic 371	android/os/SystemClock:uptimeMillis	()J
    //   609: lload 6
    //   611: lsub
    //   612: invokevirtual 108	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   615: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   618: invokestatic 134	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   621: aload_3
    //   622: aload 8
    //   624: getfield 402	aprk:b	I
    //   627: invokeinterface 342 2 0
    //   632: aload_0
    //   633: aload_2
    //   634: getfield 293	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   637: iconst_0
    //   638: aload 8
    //   640: getfield 402	aprk:b	I
    //   643: i2l
    //   644: invokespecial 339	bauz:a	(Ljava/lang/String;ZJ)V
    //   647: aconst_null
    //   648: areturn
    //   649: iload 5
    //   651: iconst_2
    //   652: if_icmpne +31 -> 683
    //   655: aload_3
    //   656: aload 8
    //   658: getfield 402	aprk:b	I
    //   661: invokeinterface 342 2 0
    //   666: aload_0
    //   667: aload_2
    //   668: getfield 293	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   671: iconst_0
    //   672: aload 8
    //   674: getfield 402	aprk:b	I
    //   677: i2l
    //   678: invokespecial 339	bauz:a	(Ljava/lang/String;ZJ)V
    //   681: aconst_null
    //   682: areturn
    //   683: iload 5
    //   685: iconst_1
    //   686: if_icmpne -302 -> 384
    //   689: invokestatic 65	bazo:a	()Lbazo;
    //   692: aload 12
    //   694: aload 11
    //   696: invokevirtual 355	java/net/URL:getHost	()Ljava/lang/String;
    //   699: sipush 1001
    //   702: invokevirtual 411	bazo:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   705: goto -321 -> 384
    //   708: astore 10
    //   710: goto -537 -> 173
    //   713: iload 5
    //   715: istore 4
    //   717: goto -391 -> 326
    //   720: goto -623 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	723	0	this	bauz
    //   0	723	1	parambasj	basj
    //   0	723	2	paramDownloadParams	DownloadParams
    //   0	723	3	paramURLDrawableHandler	URLDrawableHandler
    //   95	621	4	i	int
    //   330	384	5	j	int
    //   324	286	6	l	long
    //   58	322	8	localObject1	Object
    //   476	11	8	localMalformedURLException	java.net.MalformedURLException
    //   492	181	8	localObject2	Object
    //   92	371	9	localObject3	Object
    //   263	263	10	localArrayList	ArrayList
    //   708	1	10	localInterruptedException	java.lang.InterruptedException
    //   276	419	11	localURL	URL
    //   283	410	12	str	String
    // Exception table:
    //   from	to	target	type
    //   76	94	206	java/io/FileNotFoundException
    //   97	138	206	java/io/FileNotFoundException
    //   146	165	206	java/io/FileNotFoundException
    //   167	173	206	java/io/FileNotFoundException
    //   265	318	404	java/net/MalformedURLException
    //   350	379	476	java/net/MalformedURLException
    //   167	173	708	java/lang/InterruptedException
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
        return new bdti(paramFile, true, f, 1);
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
      a((basj)localObject, paramDownloadParams, paramURLDrawableHandler);
      paramDownloadParams = a(str);
      if (paramDownloadParams != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("NearbyImgDownloader", 2, "loadImageFile f exist:" + paramDownloadParams.getAbsolutePath());
        }
        ((basj)localObject).a.delete();
        return paramDownloadParams;
      }
    }
    catch (Exception paramDownloadParams)
    {
      if (localObject != null) {
        ((basj)localObject).a(false);
      }
      throw paramDownloadParams;
    }
    paramDownloadParams = ((basj)localObject).a();
    return paramDownloadParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bauz
 * JD-Core Version:    0.7.0.1
 */