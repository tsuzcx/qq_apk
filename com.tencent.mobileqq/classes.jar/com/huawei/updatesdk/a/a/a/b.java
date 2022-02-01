package com.huawei.updatesdk.a.a.a;

import android.content.Context;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.conn.ssl.SSLSocketFactory;

public class b
{
  private HttpURLConnection a = null;
  
  private HttpURLConnection a(String paramString, Context paramContext)
  {
    URL localURL = new URL(paramString);
    paramString = null;
    Proxy localProxy = com.huawei.updatesdk.a.a.c.b.b.d(paramContext);
    if ("https".equals(localURL.getProtocol())) {
      if (localProxy != null) {
        break label83;
      }
    }
    label83:
    for (paramString = (HttpsURLConnection)localURL.openConnection();; paramString = (HttpsURLConnection)localURL.openConnection(localProxy))
    {
      ((HttpsURLConnection)paramString).setSSLSocketFactory(d.a(paramContext));
      ((HttpsURLConnection)paramString).setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
      if (!"http".equals(localURL.getProtocol())) {
        break;
      }
      return (HttpURLConnection)localURL.openConnection();
    }
    return paramString;
  }
  
  /* Error */
  private byte[] a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload 4
    //   8: astore_2
    //   9: new 74	java/io/ByteArrayOutputStream
    //   12: dup
    //   13: invokespecial 75	java/io/ByteArrayOutputStream:<init>	()V
    //   16: astore_3
    //   17: aload 4
    //   19: astore_2
    //   20: new 77	java/io/DataOutputStream
    //   23: dup
    //   24: new 79	java/util/zip/GZIPOutputStream
    //   27: dup
    //   28: aload_3
    //   29: aload_1
    //   30: arraylength
    //   31: invokespecial 82	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   34: invokespecial 85	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   37: astore 4
    //   39: aload 4
    //   41: aload_1
    //   42: iconst_0
    //   43: aload_1
    //   44: arraylength
    //   45: invokevirtual 89	java/io/DataOutputStream:write	([BII)V
    //   48: aload 4
    //   50: invokevirtual 92	java/io/DataOutputStream:flush	()V
    //   53: aload_3
    //   54: astore_2
    //   55: aload 4
    //   57: ifnull +10 -> 67
    //   60: aload 4
    //   62: invokevirtual 95	java/io/DataOutputStream:close	()V
    //   65: aload_3
    //   66: astore_2
    //   67: aload_2
    //   68: invokevirtual 99	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   71: areturn
    //   72: astore_1
    //   73: ldc 101
    //   75: ldc 103
    //   77: aload_1
    //   78: invokestatic 108	com/huawei/updatesdk/a/a/b/a/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   81: aload_3
    //   82: astore_2
    //   83: goto -16 -> 67
    //   86: astore_3
    //   87: aconst_null
    //   88: astore_1
    //   89: aload 5
    //   91: astore 4
    //   93: aload 4
    //   95: astore_2
    //   96: ldc 101
    //   98: ldc 103
    //   100: aload_3
    //   101: invokestatic 108	com/huawei/updatesdk/a/a/b/a/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   104: aload_1
    //   105: astore_2
    //   106: aload 4
    //   108: ifnull -41 -> 67
    //   111: aload 4
    //   113: invokevirtual 95	java/io/DataOutputStream:close	()V
    //   116: aload_1
    //   117: astore_2
    //   118: goto -51 -> 67
    //   121: astore_2
    //   122: ldc 101
    //   124: ldc 103
    //   126: aload_2
    //   127: invokestatic 108	com/huawei/updatesdk/a/a/b/a/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   130: aload_1
    //   131: astore_2
    //   132: goto -65 -> 67
    //   135: astore_1
    //   136: aload_2
    //   137: ifnull +7 -> 144
    //   140: aload_2
    //   141: invokevirtual 95	java/io/DataOutputStream:close	()V
    //   144: aload_1
    //   145: athrow
    //   146: astore_2
    //   147: ldc 101
    //   149: ldc 103
    //   151: aload_2
    //   152: invokestatic 108	com/huawei/updatesdk/a/a/b/a/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   155: goto -11 -> 144
    //   158: astore_1
    //   159: aload 4
    //   161: astore_2
    //   162: goto -26 -> 136
    //   165: astore_2
    //   166: aload_3
    //   167: astore_1
    //   168: aload_2
    //   169: astore_3
    //   170: aload 5
    //   172: astore 4
    //   174: goto -81 -> 93
    //   177: astore_2
    //   178: aload_3
    //   179: astore_1
    //   180: aload_2
    //   181: astore_3
    //   182: goto -89 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	b
    //   0	185	1	paramArrayOfByte	byte[]
    //   8	110	2	localObject1	Object
    //   121	6	2	localIOException1	java.io.IOException
    //   131	10	2	arrayOfByte	byte[]
    //   146	6	2	localIOException2	java.io.IOException
    //   161	1	2	localObject2	Object
    //   165	4	2	localIOException3	java.io.IOException
    //   177	4	2	localIOException4	java.io.IOException
    //   16	66	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   86	81	3	localIOException5	java.io.IOException
    //   169	13	3	localIOException6	java.io.IOException
    //   1	172	4	localObject3	Object
    //   4	167	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   60	65	72	java/io/IOException
    //   9	17	86	java/io/IOException
    //   111	116	121	java/io/IOException
    //   9	17	135	finally
    //   20	39	135	finally
    //   96	104	135	finally
    //   140	144	146	java/io/IOException
    //   39	53	158	finally
    //   20	39	165	java/io/IOException
    //   39	53	177	java/io/IOException
  }
  
  /* Error */
  public b.a a(String paramString1, String paramString2, String paramString3, String paramString4, Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: new 111	com/huawei/updatesdk/a/a/a/b$a
    //   9: dup
    //   10: invokespecial 112	com/huawei/updatesdk/a/a/a/b$a:<init>	()V
    //   13: astore 9
    //   15: aload_0
    //   16: aload_1
    //   17: aload 5
    //   19: invokespecial 114	com/huawei/updatesdk/a/a/a/b:a	(Ljava/lang/String;Landroid/content/Context;)Ljava/net/HttpURLConnection;
    //   22: astore 5
    //   24: aload 5
    //   26: ifnonnull +24 -> 50
    //   29: aload 5
    //   31: ifnull +8 -> 39
    //   34: aload 5
    //   36: invokevirtual 117	java/net/HttpURLConnection:disconnect	()V
    //   39: aconst_null
    //   40: invokestatic 122	com/huawei/updatesdk/a/a/c/d:a	(Ljava/io/Closeable;)V
    //   43: aconst_null
    //   44: invokestatic 122	com/huawei/updatesdk/a/a/c/d:a	(Ljava/io/Closeable;)V
    //   47: aload 9
    //   49: areturn
    //   50: aload_0
    //   51: aload 5
    //   53: putfield 12	com/huawei/updatesdk/a/a/a/b:a	Ljava/net/HttpURLConnection;
    //   56: aload 5
    //   58: iconst_1
    //   59: invokevirtual 126	java/net/HttpURLConnection:setDoInput	(Z)V
    //   62: aload 5
    //   64: iconst_1
    //   65: invokevirtual 129	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   68: aload 5
    //   70: iconst_0
    //   71: invokevirtual 132	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   74: aload 5
    //   76: sipush 5000
    //   79: invokevirtual 136	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   82: aload 5
    //   84: sipush 10000
    //   87: invokevirtual 139	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   90: aload 5
    //   92: ldc 141
    //   94: invokevirtual 144	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   97: aload 5
    //   99: ldc 146
    //   101: ldc 148
    //   103: invokevirtual 152	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   106: aload 5
    //   108: ldc 154
    //   110: ldc 156
    //   112: invokevirtual 152	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: aload 5
    //   117: ldc 158
    //   119: ldc 160
    //   121: invokevirtual 152	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: aload 5
    //   126: ldc 162
    //   128: aload 4
    //   130: invokevirtual 152	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   133: new 77	java/io/DataOutputStream
    //   136: dup
    //   137: aload 5
    //   139: invokevirtual 166	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   142: invokespecial 85	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   145: astore 4
    //   147: aload 8
    //   149: astore_1
    //   150: aload 4
    //   152: aload_0
    //   153: aload_2
    //   154: aload_3
    //   155: invokevirtual 170	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   158: invokespecial 172	com/huawei/updatesdk/a/a/a/b:a	([B)[B
    //   161: invokevirtual 175	java/io/DataOutputStream:write	([B)V
    //   164: aload 8
    //   166: astore_1
    //   167: aload 4
    //   169: invokevirtual 92	java/io/DataOutputStream:flush	()V
    //   172: aload 8
    //   174: astore_1
    //   175: aload 5
    //   177: invokevirtual 179	java/net/HttpURLConnection:getResponseCode	()I
    //   180: istore 6
    //   182: aload 8
    //   184: astore_1
    //   185: aload 9
    //   187: iload 6
    //   189: invokestatic 182	com/huawei/updatesdk/a/a/a/b$a:a	(Lcom/huawei/updatesdk/a/a/a/b$a;I)I
    //   192: pop
    //   193: iload 6
    //   195: sipush 200
    //   198: if_icmpne +98 -> 296
    //   201: aload 8
    //   203: astore_1
    //   204: new 184	java/io/BufferedInputStream
    //   207: dup
    //   208: aload 5
    //   210: invokevirtual 188	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   213: invokespecial 191	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   216: astore_2
    //   217: aload_2
    //   218: astore_1
    //   219: new 193	com/huawei/updatesdk/a/a/c/b
    //   222: dup
    //   223: invokespecial 194	com/huawei/updatesdk/a/a/c/b:<init>	()V
    //   226: astore_3
    //   227: aload_2
    //   228: astore_1
    //   229: invokestatic 199	com/huawei/updatesdk/a/a/a/a:a	()Lcom/huawei/updatesdk/a/a/a/a;
    //   232: invokevirtual 202	com/huawei/updatesdk/a/a/a/a:b	()[B
    //   235: astore 7
    //   237: aload_2
    //   238: astore_1
    //   239: aload_2
    //   240: aload 7
    //   242: invokevirtual 206	java/io/BufferedInputStream:read	([B)I
    //   245: istore 6
    //   247: iload 6
    //   249: iconst_m1
    //   250: if_icmpeq +65 -> 315
    //   253: aload_2
    //   254: astore_1
    //   255: aload_3
    //   256: aload 7
    //   258: iload 6
    //   260: invokevirtual 209	com/huawei/updatesdk/a/a/c/b:a	([BI)V
    //   263: goto -26 -> 237
    //   266: astore 7
    //   268: aload 4
    //   270: astore_2
    //   271: aload_1
    //   272: astore_3
    //   273: aload 7
    //   275: astore_1
    //   276: aload 5
    //   278: ifnull +8 -> 286
    //   281: aload 5
    //   283: invokevirtual 117	java/net/HttpURLConnection:disconnect	()V
    //   286: aload_2
    //   287: invokestatic 122	com/huawei/updatesdk/a/a/c/d:a	(Ljava/io/Closeable;)V
    //   290: aload_3
    //   291: invokestatic 122	com/huawei/updatesdk/a/a/c/d:a	(Ljava/io/Closeable;)V
    //   294: aload_1
    //   295: athrow
    //   296: aload 8
    //   298: astore_1
    //   299: new 184	java/io/BufferedInputStream
    //   302: dup
    //   303: aload 5
    //   305: invokevirtual 212	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   308: invokespecial 191	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   311: astore_2
    //   312: goto -95 -> 217
    //   315: aload_2
    //   316: astore_1
    //   317: invokestatic 199	com/huawei/updatesdk/a/a/a/a:a	()Lcom/huawei/updatesdk/a/a/a/a;
    //   320: aload 7
    //   322: invokevirtual 214	com/huawei/updatesdk/a/a/a/a:a	([B)V
    //   325: aload_2
    //   326: astore_1
    //   327: aload 9
    //   329: aload_3
    //   330: invokevirtual 216	com/huawei/updatesdk/a/a/c/b:a	()Ljava/lang/String;
    //   333: invokestatic 219	com/huawei/updatesdk/a/a/a/b$a:a	(Lcom/huawei/updatesdk/a/a/a/b$a;Ljava/lang/String;)Ljava/lang/String;
    //   336: pop
    //   337: aload 5
    //   339: ifnull +8 -> 347
    //   342: aload 5
    //   344: invokevirtual 117	java/net/HttpURLConnection:disconnect	()V
    //   347: aload 4
    //   349: invokestatic 122	com/huawei/updatesdk/a/a/c/d:a	(Ljava/io/Closeable;)V
    //   352: aload_2
    //   353: invokestatic 122	com/huawei/updatesdk/a/a/c/d:a	(Ljava/io/Closeable;)V
    //   356: aload 9
    //   358: areturn
    //   359: astore_1
    //   360: aconst_null
    //   361: astore 5
    //   363: aconst_null
    //   364: astore_2
    //   365: aload 7
    //   367: astore_3
    //   368: goto -92 -> 276
    //   371: astore_1
    //   372: aconst_null
    //   373: astore_2
    //   374: aload 7
    //   376: astore_3
    //   377: goto -101 -> 276
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	380	0	this	b
    //   0	380	1	paramString1	String
    //   0	380	2	paramString2	String
    //   0	380	3	paramString3	String
    //   0	380	4	paramString4	String
    //   0	380	5	paramContext	Context
    //   180	79	6	i	int
    //   1	256	7	arrayOfByte1	byte[]
    //   266	109	7	arrayOfByte2	byte[]
    //   4	293	8	localObject	Object
    //   13	344	9	locala	b.a
    // Exception table:
    //   from	to	target	type
    //   150	164	266	finally
    //   167	172	266	finally
    //   175	182	266	finally
    //   185	193	266	finally
    //   204	217	266	finally
    //   219	227	266	finally
    //   229	237	266	finally
    //   239	247	266	finally
    //   255	263	266	finally
    //   299	312	266	finally
    //   317	325	266	finally
    //   327	337	266	finally
    //   15	24	359	finally
    //   50	147	371	finally
  }
  
  public void a()
  {
    if (this.a != null) {
      this.a.disconnect();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */