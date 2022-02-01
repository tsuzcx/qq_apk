package com.tencent.luggage.wxa.am;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.luggage.wxa.ao.a;
import com.tencent.luggage.wxa.ao.x;
import com.tencent.luggage.wxa.t.b;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class o
  implements s
{
  private static final Pattern b = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
  private static final AtomicReference<byte[]> c = new AtomicReference();
  private final boolean d;
  private final int e;
  private final int f;
  private final String g;
  private final com.tencent.luggage.wxa.ao.o<String> h;
  private final s.f i;
  private final s.f j;
  private final w<? super o> k;
  private j l;
  private HttpURLConnection m;
  private InputStream n;
  private boolean o;
  private long p;
  private long q;
  private long r;
  private long s;
  
  public o(String paramString, com.tencent.luggage.wxa.ao.o<String> paramo, w<? super o> paramw, int paramInt1, int paramInt2, boolean paramBoolean, s.f paramf)
  {
    this.g = a.a(paramString);
    this.h = paramo;
    this.k = paramw;
    this.j = new s.f();
    this.e = paramInt1;
    this.f = paramInt2;
    this.d = paramBoolean;
    this.i = paramf;
  }
  
  private static long a(HttpURLConnection paramHttpURLConnection)
  {
    Object localObject1 = paramHttpURLConnection.getHeaderField("Content-Length");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    try
    {
      l1 = Long.parseLong((String)localObject1);
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      long l1;
      label25:
      Object localObject2;
      break label25;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Unexpected Content-Length [");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("]");
    b.c("DefaultHttpDataSource", ((StringBuilder)localObject2).toString(), new Object[0]);
    l1 = -1L;
    paramHttpURLConnection = paramHttpURLConnection.getHeaderField("Content-Range");
    if (!TextUtils.isEmpty(paramHttpURLConnection))
    {
      localObject2 = b.matcher(paramHttpURLConnection);
      if (!((Matcher)localObject2).find()) {}
    }
    try
    {
      long l2 = Long.parseLong(((Matcher)localObject2).group(2)) - Long.parseLong(((Matcher)localObject2).group(1)) + 1L;
      if (l1 < 0L) {
        return l2;
      }
      if (l1 == l2) {
        break label259;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Inconsistent headers [");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("] [");
      ((StringBuilder)localObject2).append(paramHttpURLConnection);
      ((StringBuilder)localObject2).append("]");
      b.b("DefaultHttpDataSource", ((StringBuilder)localObject2).toString(), new Object[0]);
      l2 = Math.max(l1, l2);
      return l2;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      label213:
      break label213;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Unexpected Content-Range [");
    ((StringBuilder)localObject1).append(paramHttpURLConnection);
    ((StringBuilder)localObject1).append("]");
    b.c("DefaultHttpDataSource", ((StringBuilder)localObject1).toString(), new Object[0]);
    label259:
    return l1;
  }
  
  private HttpURLConnection a(URL paramURL, byte[] paramArrayOfByte, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)paramURL.openConnection();
    localHttpURLConnection.setConnectTimeout(this.e);
    localHttpURLConnection.setReadTimeout(this.f);
    paramURL = this.i;
    Object localObject;
    if (paramURL != null)
    {
      paramURL = paramURL.a().entrySet().iterator();
      while (paramURL.hasNext())
      {
        localObject = (Map.Entry)paramURL.next();
        localHttpURLConnection.setRequestProperty((String)((Map.Entry)localObject).getKey(), (String)((Map.Entry)localObject).getValue());
      }
    }
    paramURL = this.j.a().entrySet().iterator();
    while (paramURL.hasNext())
    {
      localObject = (Map.Entry)paramURL.next();
      localHttpURLConnection.setRequestProperty((String)((Map.Entry)localObject).getKey(), (String)((Map.Entry)localObject).getValue());
    }
    if ((paramLong1 != 0L) || (paramLong2 != -1L))
    {
      paramURL = new StringBuilder();
      paramURL.append("bytes=");
      paramURL.append(paramLong1);
      paramURL.append("-");
      localObject = paramURL.toString();
      paramURL = (URL)localObject;
      if (paramLong2 != -1L)
      {
        paramURL = new StringBuilder();
        paramURL.append((String)localObject);
        paramURL.append(paramLong1 + paramLong2 - 1L);
        paramURL = paramURL.toString();
      }
      localHttpURLConnection.setRequestProperty("Range", paramURL);
    }
    localHttpURLConnection.setRequestProperty("User-Agent", this.g);
    if (!paramBoolean1) {
      localHttpURLConnection.setRequestProperty("Accept-Encoding", "identity");
    }
    localHttpURLConnection.setInstanceFollowRedirects(paramBoolean2);
    if (paramArrayOfByte != null) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    }
    localHttpURLConnection.setDoOutput(paramBoolean1);
    if (paramArrayOfByte != null)
    {
      localHttpURLConnection.setRequestMethod("POST");
      if (paramArrayOfByte.length == 0)
      {
        localHttpURLConnection.connect();
        return localHttpURLConnection;
      }
      localHttpURLConnection.setFixedLengthStreamingMode(paramArrayOfByte.length);
      localHttpURLConnection.connect();
      paramURL = localHttpURLConnection.getOutputStream();
      paramURL.write(paramArrayOfByte);
      paramURL.close();
      return localHttpURLConnection;
    }
    localHttpURLConnection.connect();
    return localHttpURLConnection;
  }
  
  private static URL a(URL paramURL, String paramString)
  {
    if (paramString != null)
    {
      paramString = new URL(paramURL, paramString);
      paramURL = paramString.getProtocol();
      if (!"https".equals(paramURL))
      {
        if ("http".equals(paramURL)) {
          return paramString;
        }
        paramString = new StringBuilder();
        paramString.append("Unsupported protocol redirect: ");
        paramString.append(paramURL);
        throw new ProtocolException(paramString.toString());
      }
      return paramString;
    }
    throw new ProtocolException("Null location redirect");
  }
  
  private static void a(HttpURLConnection paramHttpURLConnection, long paramLong)
  {
    if ((x.a != 19) && (x.a != 20)) {
      return;
    }
    do
    {
      try
      {
        paramHttpURLConnection = paramHttpURLConnection.getInputStream();
        if (paramLong == -1L)
        {
          if (paramHttpURLConnection.read() == -1) {
            return;
          }
          Object localObject = paramHttpURLConnection.getClass().getName();
          if ((((String)localObject).equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream")) || (((String)localObject).equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream")))
          {
            localObject = paramHttpURLConnection.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
            ((Method)localObject).setAccessible(true);
            ((Method)localObject).invoke(paramHttpURLConnection, new Object[0]);
          }
          return;
        }
      }
      catch (Exception paramHttpURLConnection)
      {
        return;
      }
    } while (paramLong > 2048L);
  }
  
  private int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return 0;
    }
    long l1 = this.q;
    int i1 = paramInt2;
    if (l1 != -1L)
    {
      l1 -= this.s;
      if (l1 == 0L) {
        return -1;
      }
      i1 = (int)Math.min(paramInt2, l1);
    }
    paramInt1 = this.n.read(paramArrayOfByte, paramInt1, i1);
    if (paramInt1 == -1)
    {
      if (this.q == -1L) {
        return -1;
      }
      throw new EOFException();
    }
    this.s += paramInt1;
    paramArrayOfByte = this.k;
    if (paramArrayOfByte != null) {
      paramArrayOfByte.a(this, paramInt1);
    }
    return paramInt1;
  }
  
  private HttpURLConnection b(j paramj)
  {
    Object localObject = new URL(paramj.a.toString());
    byte[] arrayOfByte = paramj.b;
    long l1 = paramj.d;
    long l2 = paramj.e;
    boolean bool = paramj.a(1);
    if (!this.d) {
      return a((URL)localObject, arrayOfByte, l1, l2, bool, true);
    }
    int i1 = 0;
    paramj = (j)localObject;
    int i2;
    for (;;)
    {
      i2 = i1 + 1;
      if (i1 > 20) {
        break;
      }
      localObject = a(paramj, arrayOfByte, l1, l2, bool, false);
      i1 = ((HttpURLConnection)localObject).getResponseCode();
      if ((i1 != 300) && (i1 != 301) && (i1 != 302) && (i1 != 303) && ((arrayOfByte != null) || ((i1 != 307) && (i1 != 308)))) {
        return localObject;
      }
      arrayOfByte = null;
      String str = ((HttpURLConnection)localObject).getHeaderField("Location");
      ((HttpURLConnection)localObject).disconnect();
      paramj = a(paramj, str);
      i1 = i2;
    }
    paramj = new StringBuilder();
    paramj.append("Too many redirects: ");
    paramj.append(i2);
    paramj = new NoRouteToHostException(paramj.toString());
    for (;;)
    {
      throw paramj;
    }
  }
  
  private void d()
  {
    if (this.r == this.p) {
      return;
    }
    Object localObject2 = (byte[])c.getAndSet(null);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new byte[4096];
    }
    for (;;)
    {
      long l1 = this.r;
      long l2 = this.p;
      if (l1 == l2) {
        break label145;
      }
      int i1 = (int)Math.min(l2 - l1, localObject1.length);
      i1 = this.n.read((byte[])localObject1, 0, i1);
      if (Thread.interrupted()) {
        break label137;
      }
      if (i1 == -1) {
        break;
      }
      this.r += i1;
      localObject2 = this.k;
      if (localObject2 != null) {
        ((w)localObject2).a(this, i1);
      }
    }
    throw new EOFException();
    label137:
    throw new InterruptedIOException();
    label145:
    c.set(localObject1);
  }
  
  private void e()
  {
    HttpURLConnection localHttpURLConnection = this.m;
    if (localHttpURLConnection != null)
    {
      try
      {
        localHttpURLConnection.disconnect();
      }
      catch (Exception localException)
      {
        b.c("DefaultHttpDataSource", "Unexpected error while disconnecting", new Object[] { localException });
      }
      this.m = null;
    }
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      d();
      paramInt1 = b(paramArrayOfByte, paramInt1, paramInt2);
      return paramInt1;
    }
    catch (IOException paramArrayOfByte)
    {
      throw new s.c(paramArrayOfByte, this.l, 2);
    }
  }
  
  /* Error */
  public long a(j paramj)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: putfield 431	com/tencent/luggage/wxa/am/o:l	Lcom/tencent/luggage/wxa/am/j;
    //   5: lconst_0
    //   6: lstore 5
    //   8: aload_0
    //   9: lconst_0
    //   10: putfield 341	com/tencent/luggage/wxa/am/o:s	J
    //   13: aload_0
    //   14: lconst_0
    //   15: putfield 398	com/tencent/luggage/wxa/am/o:r	J
    //   18: aload_0
    //   19: aload_0
    //   20: aload_1
    //   21: invokespecial 437	com/tencent/luggage/wxa/am/o:b	(Lcom/tencent/luggage/wxa/am/j;)Ljava/net/HttpURLConnection;
    //   24: putfield 419	com/tencent/luggage/wxa/am/o:m	Ljava/net/HttpURLConnection;
    //   27: aload_0
    //   28: getfield 419	com/tencent/luggage/wxa/am/o:m	Ljava/net/HttpURLConnection;
    //   31: invokevirtual 381	java/net/HttpURLConnection:getResponseCode	()I
    //   34: istore_2
    //   35: ldc 123
    //   37: ldc_w 439
    //   40: iconst_1
    //   41: anewarray 4	java/lang/Object
    //   44: dup
    //   45: iconst_0
    //   46: iload_2
    //   47: invokestatic 445	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   50: aastore
    //   51: invokestatic 447	com/tencent/luggage/wxa/t/b:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   54: iload_2
    //   55: sipush 200
    //   58: if_icmplt +234 -> 292
    //   61: iload_2
    //   62: sipush 299
    //   65: if_icmple +6 -> 71
    //   68: goto +224 -> 292
    //   71: aload_0
    //   72: getfield 419	com/tencent/luggage/wxa/am/o:m	Ljava/net/HttpURLConnection;
    //   75: invokevirtual 450	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   78: astore 7
    //   80: aload_0
    //   81: getfield 71	com/tencent/luggage/wxa/am/o:h	Lcom/tencent/luggage/wxa/ao/o;
    //   84: astore 8
    //   86: aload 8
    //   88: ifnull +33 -> 121
    //   91: aload 8
    //   93: aload 7
    //   95: invokeinterface 454 2 0
    //   100: ifeq +6 -> 106
    //   103: goto +18 -> 121
    //   106: aload_0
    //   107: invokespecial 456	com/tencent/luggage/wxa/am/o:e	()V
    //   110: new 458	com/tencent/luggage/wxa/am/s$d
    //   113: dup
    //   114: aload 7
    //   116: aload_1
    //   117: invokespecial 461	com/tencent/luggage/wxa/am/s$d:<init>	(Ljava/lang/String;Lcom/tencent/luggage/wxa/am/j;)V
    //   120: athrow
    //   121: lload 5
    //   123: lstore_3
    //   124: iload_2
    //   125: sipush 200
    //   128: if_icmpne +20 -> 148
    //   131: lload 5
    //   133: lstore_3
    //   134: aload_1
    //   135: getfield 371	com/tencent/luggage/wxa/am/j:d	J
    //   138: lconst_0
    //   139: lcmp
    //   140: ifeq +8 -> 148
    //   143: aload_1
    //   144: getfield 371	com/tencent/luggage/wxa/am/j:d	J
    //   147: lstore_3
    //   148: aload_0
    //   149: lload_3
    //   150: putfield 400	com/tencent/luggage/wxa/am/o:p	J
    //   153: aload_1
    //   154: iconst_1
    //   155: invokevirtual 376	com/tencent/luggage/wxa/am/j:a	(I)Z
    //   158: ifne +67 -> 225
    //   161: aload_1
    //   162: getfield 373	com/tencent/luggage/wxa/am/j:e	J
    //   165: lstore 5
    //   167: ldc2_w 133
    //   170: lstore_3
    //   171: lload 5
    //   173: ldc2_w 133
    //   176: lcmp
    //   177: ifeq +14 -> 191
    //   180: aload_0
    //   181: aload_1
    //   182: getfield 373	com/tencent/luggage/wxa/am/j:e	J
    //   185: putfield 339	com/tencent/luggage/wxa/am/o:q	J
    //   188: goto +45 -> 233
    //   191: aload_0
    //   192: getfield 419	com/tencent/luggage/wxa/am/o:m	Ljava/net/HttpURLConnection;
    //   195: invokestatic 463	com/tencent/luggage/wxa/am/o:a	(Ljava/net/HttpURLConnection;)J
    //   198: lstore 5
    //   200: lload 5
    //   202: ldc2_w 133
    //   205: lcmp
    //   206: ifeq +11 -> 217
    //   209: lload 5
    //   211: aload_0
    //   212: getfield 400	com/tencent/luggage/wxa/am/o:p	J
    //   215: lsub
    //   216: lstore_3
    //   217: aload_0
    //   218: lload_3
    //   219: putfield 339	com/tencent/luggage/wxa/am/o:q	J
    //   222: goto +11 -> 233
    //   225: aload_0
    //   226: aload_1
    //   227: getfield 373	com/tencent/luggage/wxa/am/j:e	J
    //   230: putfield 339	com/tencent/luggage/wxa/am/o:q	J
    //   233: aload_0
    //   234: aload_0
    //   235: getfield 419	com/tencent/luggage/wxa/am/o:m	Ljava/net/HttpURLConnection;
    //   238: invokevirtual 297	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   241: putfield 346	com/tencent/luggage/wxa/am/o:n	Ljava/io/InputStream;
    //   244: aload_0
    //   245: iconst_1
    //   246: putfield 465	com/tencent/luggage/wxa/am/o:o	Z
    //   249: aload_0
    //   250: getfield 73	com/tencent/luggage/wxa/am/o:k	Lcom/tencent/luggage/wxa/am/w;
    //   253: astore 7
    //   255: aload 7
    //   257: ifnull +12 -> 269
    //   260: aload 7
    //   262: aload_0
    //   263: aload_1
    //   264: invokeinterface 468 3 0
    //   269: aload_0
    //   270: getfield 339	com/tencent/luggage/wxa/am/o:q	J
    //   273: lreturn
    //   274: astore 7
    //   276: aload_0
    //   277: invokespecial 456	com/tencent/luggage/wxa/am/o:e	()V
    //   280: new 429	com/tencent/luggage/wxa/am/s$c
    //   283: dup
    //   284: aload 7
    //   286: aload_1
    //   287: iconst_1
    //   288: invokespecial 434	com/tencent/luggage/wxa/am/s$c:<init>	(Ljava/io/IOException;Lcom/tencent/luggage/wxa/am/j;I)V
    //   291: athrow
    //   292: aload_0
    //   293: getfield 419	com/tencent/luggage/wxa/am/o:m	Ljava/net/HttpURLConnection;
    //   296: invokevirtual 471	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   299: astore 7
    //   301: aload_0
    //   302: invokespecial 456	com/tencent/luggage/wxa/am/o:e	()V
    //   305: new 473	com/tencent/luggage/wxa/am/s$e
    //   308: dup
    //   309: iload_2
    //   310: aload 7
    //   312: aload_1
    //   313: invokespecial 476	com/tencent/luggage/wxa/am/s$e:<init>	(ILjava/util/Map;Lcom/tencent/luggage/wxa/am/j;)V
    //   316: astore_1
    //   317: iload_2
    //   318: sipush 416
    //   321: if_icmpne +16 -> 337
    //   324: aload_1
    //   325: new 478	com/tencent/luggage/wxa/am/h
    //   328: dup
    //   329: iconst_0
    //   330: invokespecial 480	com/tencent/luggage/wxa/am/h:<init>	(I)V
    //   333: invokevirtual 484	com/tencent/luggage/wxa/am/s$e:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   336: pop
    //   337: aload_1
    //   338: athrow
    //   339: astore 7
    //   341: aload_0
    //   342: invokespecial 456	com/tencent/luggage/wxa/am/o:e	()V
    //   345: new 112	java/lang/StringBuilder
    //   348: dup
    //   349: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   352: astore 8
    //   354: aload 8
    //   356: ldc_w 486
    //   359: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: pop
    //   363: aload 8
    //   365: aload_1
    //   366: getfield 362	com/tencent/luggage/wxa/am/j:a	Landroid/net/Uri;
    //   369: invokevirtual 365	android/net/Uri:toString	()Ljava/lang/String;
    //   372: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: new 429	com/tencent/luggage/wxa/am/s$c
    //   379: dup
    //   380: aload 8
    //   382: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   385: aload 7
    //   387: aload_1
    //   388: iconst_1
    //   389: invokespecial 489	com/tencent/luggage/wxa/am/s$c:<init>	(Ljava/lang/String;Ljava/io/IOException;Lcom/tencent/luggage/wxa/am/j;I)V
    //   392: athrow
    //   393: astore 7
    //   395: new 112	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   402: astore 8
    //   404: aload 8
    //   406: ldc_w 486
    //   409: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: pop
    //   413: aload 8
    //   415: aload_1
    //   416: getfield 362	com/tencent/luggage/wxa/am/j:a	Landroid/net/Uri;
    //   419: invokevirtual 365	android/net/Uri:toString	()Ljava/lang/String;
    //   422: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: pop
    //   426: new 429	com/tencent/luggage/wxa/am/s$c
    //   429: dup
    //   430: aload 8
    //   432: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: aload 7
    //   437: aload_1
    //   438: iconst_1
    //   439: invokespecial 489	com/tencent/luggage/wxa/am/s$c:<init>	(Ljava/lang/String;Ljava/io/IOException;Lcom/tencent/luggage/wxa/am/j;I)V
    //   442: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	443	0	this	o
    //   0	443	1	paramj	j
    //   34	288	2	i1	int
    //   123	96	3	l1	long
    //   6	204	5	l2	long
    //   78	183	7	localObject1	Object
    //   274	11	7	localIOException1	IOException
    //   299	12	7	localMap	Map
    //   339	47	7	localIOException2	IOException
    //   393	43	7	localIOException3	IOException
    //   84	347	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   233	244	274	java/io/IOException
    //   27	54	339	java/io/IOException
    //   18	27	393	java/io/IOException
  }
  
  public void a()
  {
    try
    {
      if (this.n != null)
      {
        a(this.m, c());
        try
        {
          this.n.close();
        }
        catch (IOException localIOException)
        {
          throw new s.c(localIOException, this.l, 3);
        }
      }
      w localw1;
      return;
    }
    finally
    {
      this.n = null;
      e();
      if (this.o)
      {
        this.o = false;
        w localw2 = this.k;
        if (localw2 != null) {
          localw2.a(this);
        }
      }
    }
  }
  
  public Uri b()
  {
    HttpURLConnection localHttpURLConnection = this.m;
    if (localHttpURLConnection == null) {
      return null;
    }
    return Uri.parse(localHttpURLConnection.getURL().toString());
  }
  
  protected final long c()
  {
    long l1 = this.q;
    if (l1 == -1L) {
      return l1;
    }
    return l1 - this.s;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.am.o
 * JD-Core Version:    0.7.0.1
 */