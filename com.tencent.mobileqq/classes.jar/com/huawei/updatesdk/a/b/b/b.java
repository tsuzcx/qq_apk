package com.huawei.updatesdk.a.b.b;

import android.os.AsyncTask;
import android.os.Handler;
import android.text.TextUtils;
import com.huawei.updatesdk.a.a.c.d;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;

public class b
  extends AsyncTask<Void, Void, Void>
{
  private HttpURLConnection a;
  private boolean b = false;
  private a c;
  private Handler d = new b.a(null);
  
  public b(a parama)
  {
    this.c = parama;
  }
  
  private void a(int paramInt1, long paramLong, int paramInt2)
  {
    a locala = new a();
    locala.a(paramInt1);
    locala.a(paramLong);
    if (this.d == null) {
      return;
    }
    this.d.sendMessage(this.d.obtainMessage(paramInt2, locala));
  }
  
  /* Error */
  private void a(a parama, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +13 -> 14
    //   4: aload_1
    //   5: invokevirtual 60	com/huawei/updatesdk/a/b/b/a:c	()Ljava/lang/String;
    //   8: invokestatic 66	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +4 -> 15
    //   14: return
    //   15: new 68	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   22: aload_2
    //   23: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc 75
    //   28: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: astore 4
    //   36: new 80	java/io/File
    //   39: dup
    //   40: aload 4
    //   42: invokespecial 83	java/io/File:<init>	(Ljava/lang/String;)V
    //   45: astore_2
    //   46: new 85	java/io/FileOutputStream
    //   49: dup
    //   50: aload_2
    //   51: invokespecial 88	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   54: astore_3
    //   55: aload_3
    //   56: astore_2
    //   57: aload_0
    //   58: aload_1
    //   59: aload_3
    //   60: aload 4
    //   62: invokespecial 91	com/huawei/updatesdk/a/b/b/b:a	(Lcom/huawei/updatesdk/a/b/b/a;Ljava/io/OutputStream;Ljava/lang/String;)Z
    //   65: ifne +19 -> 84
    //   68: aload_3
    //   69: astore_2
    //   70: new 80	java/io/File
    //   73: dup
    //   74: invokestatic 93	com/huawei/updatesdk/a/b/b/b:d	()Ljava/lang/String;
    //   77: invokespecial 83	java/io/File:<init>	(Ljava/lang/String;)V
    //   80: invokestatic 98	com/huawei/updatesdk/a/a/c/d:a	(Ljava/io/File;)Z
    //   83: pop
    //   84: aload_3
    //   85: ifnull -71 -> 14
    //   88: aload_3
    //   89: invokevirtual 101	java/io/FileOutputStream:close	()V
    //   92: return
    //   93: astore_1
    //   94: ldc 103
    //   96: ldc 105
    //   98: invokestatic 110	com/huawei/updatesdk/a/a/b/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: return
    //   102: astore_1
    //   103: aconst_null
    //   104: astore_3
    //   105: aload_3
    //   106: astore_2
    //   107: ldc 103
    //   109: new 68	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   116: ldc 112
    //   118: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload_1
    //   122: invokevirtual 113	java/io/FileNotFoundException:toString	()Ljava/lang/String;
    //   125: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 110	com/huawei/updatesdk/a/a/b/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: aload_3
    //   135: ifnull -121 -> 14
    //   138: aload_3
    //   139: invokevirtual 101	java/io/FileOutputStream:close	()V
    //   142: return
    //   143: astore_1
    //   144: ldc 103
    //   146: ldc 105
    //   148: invokestatic 110	com/huawei/updatesdk/a/a/b/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: return
    //   152: astore_1
    //   153: aconst_null
    //   154: astore_3
    //   155: aload_3
    //   156: astore_2
    //   157: ldc 103
    //   159: new 68	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   166: ldc 115
    //   168: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload_1
    //   172: invokevirtual 116	java/lang/Exception:toString	()Ljava/lang/String;
    //   175: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 110	com/huawei/updatesdk/a/a/b/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   184: aload_3
    //   185: ifnull -171 -> 14
    //   188: aload_3
    //   189: invokevirtual 101	java/io/FileOutputStream:close	()V
    //   192: return
    //   193: astore_1
    //   194: ldc 103
    //   196: ldc 105
    //   198: invokestatic 110	com/huawei/updatesdk/a/a/b/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   201: return
    //   202: astore_1
    //   203: aconst_null
    //   204: astore_2
    //   205: aload_2
    //   206: ifnull +7 -> 213
    //   209: aload_2
    //   210: invokevirtual 101	java/io/FileOutputStream:close	()V
    //   213: aload_1
    //   214: athrow
    //   215: astore_2
    //   216: ldc 103
    //   218: ldc 105
    //   220: invokestatic 110	com/huawei/updatesdk/a/a/b/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   223: goto -10 -> 213
    //   226: astore_1
    //   227: goto -22 -> 205
    //   230: astore_1
    //   231: goto -76 -> 155
    //   234: astore_1
    //   235: goto -130 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	this	b
    //   0	238	1	parama	a
    //   0	238	2	paramString	String
    //   54	135	3	localFileOutputStream	java.io.FileOutputStream
    //   34	27	4	str	String
    // Exception table:
    //   from	to	target	type
    //   88	92	93	java/io/IOException
    //   46	55	102	java/io/FileNotFoundException
    //   138	142	143	java/io/IOException
    //   46	55	152	java/lang/Exception
    //   188	192	193	java/io/IOException
    //   46	55	202	finally
    //   209	213	215	java/io/IOException
    //   57	68	226	finally
    //   70	84	226	finally
    //   107	134	226	finally
    //   157	184	226	finally
    //   57	68	230	java/lang/Exception
    //   70	84	230	java/lang/Exception
    //   57	68	234	java/io/FileNotFoundException
    //   70	84	234	java/io/FileNotFoundException
  }
  
  private void a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    if (paramInputStream != null) {}
    try
    {
      paramInputStream.close();
      if (paramOutputStream == null) {}
    }
    catch (IOException paramInputStream)
    {
      for (;;)
      {
        try
        {
          paramOutputStream.close();
          return;
        }
        catch (IOException paramInputStream)
        {
          com.huawei.updatesdk.a.a.b.a.a.a.d("DownloadMarketTask", "downloadUrlToStream(String urlString,OutputStream outputStream) " + paramInputStream.toString());
        }
        paramInputStream = paramInputStream;
        com.huawei.updatesdk.a.a.b.a.a.a.d("DownloadMarketTask", "downloadUrlToStream(String urlString,OutputStream outputStream) " + paramInputStream.toString());
      }
    }
  }
  
  /* Error */
  private boolean a(a parama, OutputStream paramOutputStream, String paramString)
  {
    // Byte code:
    //   0: ldc2_w 127
    //   3: lstore 16
    //   5: iconst_0
    //   6: istore 7
    //   8: iconst_0
    //   9: istore 8
    //   11: iconst_0
    //   12: istore 9
    //   14: iconst_0
    //   15: istore 10
    //   17: iconst_0
    //   18: istore 6
    //   20: iconst_0
    //   21: istore 18
    //   23: iload 9
    //   25: istore 5
    //   27: lload 16
    //   29: lstore 14
    //   31: iload 10
    //   33: istore 4
    //   35: lload 16
    //   37: lstore 12
    //   39: aload_0
    //   40: invokestatic 133	com/huawei/updatesdk/a/b/b/c:a	()Lcom/huawei/updatesdk/a/b/b/c;
    //   43: aload_1
    //   44: invokevirtual 60	com/huawei/updatesdk/a/b/b/a:c	()Ljava/lang/String;
    //   47: invokevirtual 136	com/huawei/updatesdk/a/b/b/c:a	(Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   50: putfield 138	com/huawei/updatesdk/a/b/b/b:a	Ljava/net/HttpURLConnection;
    //   53: iload 9
    //   55: istore 5
    //   57: lload 16
    //   59: lstore 14
    //   61: iload 10
    //   63: istore 4
    //   65: lload 16
    //   67: lstore 12
    //   69: aload_0
    //   70: getfield 138	com/huawei/updatesdk/a/b/b/b:a	Ljava/net/HttpURLConnection;
    //   73: astore 20
    //   75: aload 20
    //   77: ifnonnull +53 -> 130
    //   80: aload_0
    //   81: getfield 20	com/huawei/updatesdk/a/b/b/b:b	Z
    //   84: ifeq +34 -> 118
    //   87: aload_0
    //   88: iconst_0
    //   89: ldc2_w 127
    //   92: iconst_3
    //   93: invokespecial 140	com/huawei/updatesdk/a/b/b/b:a	(IJI)V
    //   96: aload_0
    //   97: aconst_null
    //   98: aconst_null
    //   99: invokespecial 142	com/huawei/updatesdk/a/b/b/b:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   102: invokestatic 147	com/huawei/updatesdk/service/d/a/b:a	()Ljava/util/List;
    //   105: aload_0
    //   106: invokeinterface 153 2 0
    //   111: pop
    //   112: aload_0
    //   113: invokespecial 156	com/huawei/updatesdk/a/b/b/b:e	()V
    //   116: iconst_0
    //   117: ireturn
    //   118: aload_0
    //   119: iconst_0
    //   120: ldc2_w 127
    //   123: iconst_5
    //   124: invokespecial 140	com/huawei/updatesdk/a/b/b/b:a	(IJI)V
    //   127: goto -31 -> 96
    //   130: iload 9
    //   132: istore 5
    //   134: lload 16
    //   136: lstore 14
    //   138: iload 10
    //   140: istore 4
    //   142: lload 16
    //   144: lstore 12
    //   146: aload_0
    //   147: getfield 138	com/huawei/updatesdk/a/b/b/b:a	Ljava/net/HttpURLConnection;
    //   150: invokevirtual 161	java/net/HttpURLConnection:connect	()V
    //   153: iload 9
    //   155: istore 5
    //   157: lload 16
    //   159: lstore 14
    //   161: iload 10
    //   163: istore 4
    //   165: lload 16
    //   167: lstore 12
    //   169: aload_0
    //   170: getfield 138	com/huawei/updatesdk/a/b/b/b:a	Ljava/net/HttpURLConnection;
    //   173: invokevirtual 165	java/net/HttpURLConnection:getResponseCode	()I
    //   176: istore 11
    //   178: sipush 200
    //   181: iload 11
    //   183: if_icmpeq +61 -> 244
    //   186: sipush 206
    //   189: iload 11
    //   191: if_icmpeq +53 -> 244
    //   194: aload_0
    //   195: getfield 20	com/huawei/updatesdk/a/b/b/b:b	Z
    //   198: ifeq +34 -> 232
    //   201: aload_0
    //   202: iconst_0
    //   203: ldc2_w 127
    //   206: iconst_3
    //   207: invokespecial 140	com/huawei/updatesdk/a/b/b/b:a	(IJI)V
    //   210: aload_0
    //   211: aconst_null
    //   212: aconst_null
    //   213: invokespecial 142	com/huawei/updatesdk/a/b/b/b:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   216: invokestatic 147	com/huawei/updatesdk/service/d/a/b:a	()Ljava/util/List;
    //   219: aload_0
    //   220: invokeinterface 153 2 0
    //   225: pop
    //   226: aload_0
    //   227: invokespecial 156	com/huawei/updatesdk/a/b/b/b:e	()V
    //   230: iconst_0
    //   231: ireturn
    //   232: aload_0
    //   233: iconst_0
    //   234: ldc2_w 127
    //   237: iconst_5
    //   238: invokespecial 140	com/huawei/updatesdk/a/b/b/b:a	(IJI)V
    //   241: goto -31 -> 210
    //   244: iload 9
    //   246: istore 5
    //   248: lload 16
    //   250: lstore 14
    //   252: iload 10
    //   254: istore 4
    //   256: lload 16
    //   258: lstore 12
    //   260: aload_1
    //   261: invokevirtual 168	com/huawei/updatesdk/a/b/b/a:b	()J
    //   264: lstore 16
    //   266: lload 16
    //   268: lstore 12
    //   270: new 170	java/io/BufferedInputStream
    //   273: dup
    //   274: aload_0
    //   275: getfield 138	com/huawei/updatesdk/a/b/b/b:a	Ljava/net/HttpURLConnection;
    //   278: invokevirtual 174	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   281: sipush 8192
    //   284: invokespecial 177	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   287: astore 20
    //   289: new 179	java/io/BufferedOutputStream
    //   292: dup
    //   293: aload_2
    //   294: sipush 8192
    //   297: invokespecial 182	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   300: astore 21
    //   302: lconst_0
    //   303: lstore 14
    //   305: iload 7
    //   307: istore 5
    //   309: sipush 8192
    //   312: newarray byte
    //   314: astore_2
    //   315: iload 6
    //   317: istore 4
    //   319: iload 4
    //   321: istore 5
    //   323: aload 20
    //   325: aload_2
    //   326: invokevirtual 186	java/io/BufferedInputStream:read	([B)I
    //   329: istore 6
    //   331: iload 6
    //   333: iconst_m1
    //   334: if_icmpeq +210 -> 544
    //   337: iload 4
    //   339: istore 5
    //   341: aload 21
    //   343: aload_2
    //   344: iconst_0
    //   345: iload 6
    //   347: invokevirtual 190	java/io/BufferedOutputStream:write	([BII)V
    //   350: iload 4
    //   352: iload 6
    //   354: iadd
    //   355: istore 6
    //   357: iload 6
    //   359: istore 4
    //   361: iload 6
    //   363: istore 5
    //   365: invokestatic 195	java/lang/System:currentTimeMillis	()J
    //   368: lload 14
    //   370: lsub
    //   371: invokestatic 201	java/lang/Math:abs	(J)J
    //   374: ldc2_w 202
    //   377: lcmp
    //   378: ifle -59 -> 319
    //   381: iload 6
    //   383: istore 5
    //   385: invokestatic 195	java/lang/System:currentTimeMillis	()J
    //   388: lstore 16
    //   390: iload 6
    //   392: istore 4
    //   394: lload 16
    //   396: lstore 14
    //   398: iload 6
    //   400: i2l
    //   401: lload 12
    //   403: lcmp
    //   404: ifeq -85 -> 319
    //   407: iload 6
    //   409: istore 5
    //   411: aload_0
    //   412: iload 6
    //   414: lload 12
    //   416: iconst_2
    //   417: invokespecial 140	com/huawei/updatesdk/a/b/b/b:a	(IJI)V
    //   420: iload 6
    //   422: istore 4
    //   424: lload 16
    //   426: lstore 14
    //   428: goto -109 -> 319
    //   431: astore_3
    //   432: aload 20
    //   434: astore_2
    //   435: aload 21
    //   437: astore_1
    //   438: iload 5
    //   440: istore 4
    //   442: aload_0
    //   443: aload_2
    //   444: aload_1
    //   445: invokespecial 142	com/huawei/updatesdk/a/b/b/b:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   448: iload 4
    //   450: istore 5
    //   452: lload 12
    //   454: lstore 14
    //   456: aload_3
    //   457: athrow
    //   458: aconst_null
    //   459: astore_3
    //   460: astore_2
    //   461: lload 14
    //   463: lstore 12
    //   465: aconst_null
    //   466: astore_1
    //   467: iload 5
    //   469: istore 4
    //   471: iconst_0
    //   472: istore 18
    //   474: ldc 103
    //   476: new 68	java/lang/StringBuilder
    //   479: dup
    //   480: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   483: ldc 125
    //   485: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: aload_2
    //   489: invokevirtual 116	java/lang/Exception:toString	()Ljava/lang/String;
    //   492: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   498: invokestatic 110	com/huawei/updatesdk/a/a/b/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   501: iload 18
    //   503: ifne +19 -> 522
    //   506: aload_0
    //   507: getfield 20	com/huawei/updatesdk/a/b/b/b:b	Z
    //   510: ifeq +173 -> 683
    //   513: aload_0
    //   514: iload 4
    //   516: lload 12
    //   518: iconst_3
    //   519: invokespecial 140	com/huawei/updatesdk/a/b/b/b:a	(IJI)V
    //   522: aload_0
    //   523: aload_1
    //   524: aload_3
    //   525: invokespecial 142	com/huawei/updatesdk/a/b/b/b:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   528: invokestatic 147	com/huawei/updatesdk/service/d/a/b:a	()Ljava/util/List;
    //   531: aload_0
    //   532: invokeinterface 153 2 0
    //   537: pop
    //   538: aload_0
    //   539: invokespecial 156	com/huawei/updatesdk/a/b/b/b:e	()V
    //   542: iconst_0
    //   543: ireturn
    //   544: aload_0
    //   545: aload 20
    //   547: aload 21
    //   549: invokespecial 142	com/huawei/updatesdk/a/b/b/b:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   552: aconst_null
    //   553: astore 20
    //   555: aconst_null
    //   556: astore 21
    //   558: iload 4
    //   560: i2l
    //   561: lload 12
    //   563: lcmp
    //   564: ifne +101 -> 665
    //   567: lload 12
    //   569: lconst_0
    //   570: lcmp
    //   571: ifle +94 -> 665
    //   574: aload_1
    //   575: invokevirtual 204	com/huawei/updatesdk/a/b/b/a:d	()Ljava/lang/String;
    //   578: invokestatic 66	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   581: ifne +84 -> 665
    //   584: aload_1
    //   585: invokevirtual 204	com/huawei/updatesdk/a/b/b/a:d	()Ljava/lang/String;
    //   588: aload_3
    //   589: ldc 206
    //   591: invokestatic 209	com/huawei/updatesdk/a/a/c/d:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   594: invokevirtual 215	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   597: istore 19
    //   599: iload 19
    //   601: ifeq +64 -> 665
    //   604: iconst_1
    //   605: istore 18
    //   607: iload 18
    //   609: ifeq +12 -> 621
    //   612: aload_0
    //   613: iload 4
    //   615: lload 12
    //   617: iconst_4
    //   618: invokespecial 140	com/huawei/updatesdk/a/b/b/b:a	(IJI)V
    //   621: iload 18
    //   623: ifne +19 -> 642
    //   626: aload_0
    //   627: getfield 20	com/huawei/updatesdk/a/b/b/b:b	Z
    //   630: ifeq +41 -> 671
    //   633: aload_0
    //   634: iload 4
    //   636: lload 12
    //   638: iconst_3
    //   639: invokespecial 140	com/huawei/updatesdk/a/b/b/b:a	(IJI)V
    //   642: aload_0
    //   643: aconst_null
    //   644: aconst_null
    //   645: invokespecial 142	com/huawei/updatesdk/a/b/b/b:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   648: invokestatic 147	com/huawei/updatesdk/service/d/a/b:a	()Ljava/util/List;
    //   651: aload_0
    //   652: invokeinterface 153 2 0
    //   657: pop
    //   658: aload_0
    //   659: invokespecial 156	com/huawei/updatesdk/a/b/b/b:e	()V
    //   662: iload 18
    //   664: ireturn
    //   665: iconst_0
    //   666: istore 18
    //   668: goto -61 -> 607
    //   671: aload_0
    //   672: iload 4
    //   674: lload 12
    //   676: iconst_5
    //   677: invokespecial 140	com/huawei/updatesdk/a/b/b/b:a	(IJI)V
    //   680: goto -38 -> 642
    //   683: aload_0
    //   684: iload 4
    //   686: lload 12
    //   688: iconst_5
    //   689: invokespecial 140	com/huawei/updatesdk/a/b/b/b:a	(IJI)V
    //   692: goto -170 -> 522
    //   695: aconst_null
    //   696: astore_3
    //   697: aconst_null
    //   698: astore_2
    //   699: astore_1
    //   700: iload 18
    //   702: ifne +19 -> 721
    //   705: aload_0
    //   706: getfield 20	com/huawei/updatesdk/a/b/b/b:b	Z
    //   709: ifeq +34 -> 743
    //   712: aload_0
    //   713: iload 4
    //   715: lload 12
    //   717: iconst_3
    //   718: invokespecial 140	com/huawei/updatesdk/a/b/b/b:a	(IJI)V
    //   721: aload_0
    //   722: aload_2
    //   723: aload_3
    //   724: invokespecial 142	com/huawei/updatesdk/a/b/b/b:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   727: invokestatic 147	com/huawei/updatesdk/service/d/a/b:a	()Ljava/util/List;
    //   730: aload_0
    //   731: invokeinterface 153 2 0
    //   736: pop
    //   737: aload_0
    //   738: invokespecial 156	com/huawei/updatesdk/a/b/b/b:e	()V
    //   741: aload_1
    //   742: athrow
    //   743: aload_0
    //   744: iload 4
    //   746: lload 12
    //   748: iconst_5
    //   749: invokespecial 140	com/huawei/updatesdk/a/b/b/b:a	(IJI)V
    //   752: goto -31 -> 721
    //   755: astore_1
    //   756: aload 21
    //   758: astore_3
    //   759: aload 20
    //   761: astore_2
    //   762: goto -62 -> 700
    //   765: astore 20
    //   767: aload_1
    //   768: astore_3
    //   769: aload 20
    //   771: astore_1
    //   772: goto -72 -> 700
    //   775: astore_1
    //   776: aconst_null
    //   777: astore_2
    //   778: aload 20
    //   780: astore_3
    //   781: goto -81 -> 700
    //   784: astore_1
    //   785: aconst_null
    //   786: astore_2
    //   787: aload 20
    //   789: astore_3
    //   790: goto -90 -> 700
    //   793: astore 20
    //   795: aload_1
    //   796: astore_2
    //   797: aload 20
    //   799: astore_1
    //   800: goto -100 -> 700
    //   803: astore_2
    //   804: aload 21
    //   806: astore_3
    //   807: iconst_0
    //   808: istore 18
    //   810: aload 20
    //   812: astore_1
    //   813: goto -339 -> 474
    //   816: astore_3
    //   817: aload_2
    //   818: astore 20
    //   820: iconst_0
    //   821: istore 18
    //   823: aload_3
    //   824: astore_2
    //   825: aload_1
    //   826: astore_3
    //   827: aload 20
    //   829: astore_1
    //   830: goto -356 -> 474
    //   833: astore_2
    //   834: iconst_0
    //   835: istore 18
    //   837: aconst_null
    //   838: astore_1
    //   839: aload 21
    //   841: astore_3
    //   842: goto -368 -> 474
    //   845: astore_2
    //   846: aconst_null
    //   847: astore_1
    //   848: aload 21
    //   850: astore_3
    //   851: goto -377 -> 474
    //   854: astore_3
    //   855: aconst_null
    //   856: astore_2
    //   857: aconst_null
    //   858: astore_1
    //   859: iload 8
    //   861: istore 4
    //   863: goto -421 -> 442
    //   866: astore_3
    //   867: aconst_null
    //   868: astore_1
    //   869: aload 20
    //   871: astore_2
    //   872: iload 8
    //   874: istore 4
    //   876: goto -434 -> 442
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	879	0	this	b
    //   0	879	1	parama	a
    //   0	879	2	paramOutputStream	OutputStream
    //   0	879	3	paramString	String
    //   33	842	4	i	int
    //   25	443	5	j	int
    //   18	403	6	k	int
    //   6	300	7	m	int
    //   9	864	8	n	int
    //   12	233	9	i1	int
    //   15	238	10	i2	int
    //   176	16	11	i3	int
    //   37	710	12	l1	long
    //   29	433	14	l2	long
    //   3	422	16	l3	long
    //   21	815	18	bool1	boolean
    //   597	3	19	bool2	boolean
    //   73	687	20	localObject1	Object
    //   765	23	20	localObject2	Object
    //   793	18	20	localObject3	Object
    //   818	52	20	localOutputStream	OutputStream
    //   300	549	21	localBufferedOutputStream	java.io.BufferedOutputStream
    // Exception table:
    //   from	to	target	type
    //   309	315	431	finally
    //   323	331	431	finally
    //   341	350	431	finally
    //   365	381	431	finally
    //   385	390	431	finally
    //   411	420	431	finally
    //   39	53	458	java/lang/Exception
    //   69	75	458	java/lang/Exception
    //   146	153	458	java/lang/Exception
    //   169	178	458	java/lang/Exception
    //   260	266	458	java/lang/Exception
    //   456	458	458	java/lang/Exception
    //   39	53	695	finally
    //   69	75	695	finally
    //   146	153	695	finally
    //   169	178	695	finally
    //   260	266	695	finally
    //   456	458	695	finally
    //   544	552	755	finally
    //   442	448	765	finally
    //   574	599	775	finally
    //   612	621	784	finally
    //   474	501	793	finally
    //   544	552	803	java/lang/Exception
    //   442	448	816	java/lang/Exception
    //   574	599	833	java/lang/Exception
    //   612	621	845	java/lang/Exception
    //   270	289	854	finally
    //   289	302	866	finally
  }
  
  private static String d()
  {
    Object localObject = com.huawei.updatesdk.a.b.a.a.a().c();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      localObject = "";
    }
    File localFile;
    do
    {
      String str;
      do
      {
        return localObject;
        str = (String)localObject + "/updatesdk";
        localFile = new File(str);
        localObject = str;
      } while (localFile.exists());
      localObject = str;
    } while (localFile.mkdirs());
    return "";
  }
  
  private void e()
  {
    if (this.a != null) {
      this.a.disconnect();
    }
  }
  
  protected Void a(Void... paramVarArgs)
  {
    com.huawei.updatesdk.service.d.a.b.a(this);
    a(this.c, d());
    return null;
  }
  
  public void a()
  {
    if (this.a != null)
    {
      this.a.disconnect();
      this.b = true;
    }
    d.a(new File(d()));
  }
  
  public void b()
  {
    this.d = null;
  }
  
  protected void onCancelled()
  {
    super.onCancelled();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.a.b.b.b
 * JD-Core Version:    0.7.0.1
 */