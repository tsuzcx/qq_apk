package com.tencent.hlyyb.downloader.a.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.hlyyb.common.a.f;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class a
  implements e
{
  private boolean A = false;
  protected int a;
  protected com.tencent.hlyyb.downloader.e.d.a b;
  protected boolean c;
  protected Map<String, String> d = null;
  public boolean e = false;
  public com.tencent.hlyyb.downloader.a.b f;
  private List<String> g = null;
  private String h;
  private c i = new c();
  private int j = 0;
  private String k = "";
  private int l = 4096;
  private int m = 8;
  private String n = "";
  private URL o = null;
  private HttpURLConnection p = null;
  private InputStream q = null;
  private String r = "";
  private String s = "";
  private String t = "";
  private String u = "";
  private String v = "";
  private String w = "";
  private long x = -1L;
  private List<String> y = null;
  private volatile boolean z = false;
  
  private void a(String paramString)
  {
    Object localObject = "";
    if (this.p != null) {
      localObject = this.p.getHeaderField("X-Extra-Servers");
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      return;
      try
      {
        boolean bool = "http".equals(new URL(paramString).getProtocol());
        if ((!bool) || (!paramString.startsWith("http://"))) {
          continue;
        }
        int i1 = "http://".length();
        int i2 = paramString.indexOf("/", i1);
        if (i2 == -1) {
          continue;
        }
        paramString.substring(i1, i2);
        paramString = paramString.substring(i2);
        localObject = ((String)localObject).split(";");
        if ((localObject == null) || (localObject.length <= 0)) {
          continue;
        }
        this.y = new ArrayList();
        i2 = localObject.length;
        i1 = 0;
        while (i1 < i2)
        {
          String str = localObject[i1];
          this.y.add("http://" + str + paramString);
          i1 += 1;
        }
        return;
      }
      catch (Exception paramString) {}
    }
  }
  
  private void a(Throwable paramThrowable)
  {
    paramThrowable.printStackTrace();
    this.k = (paramThrowable.getClass().getName() + "|" + paramThrowable);
    if (this.z)
    {
      this.j = -66;
      return;
    }
    if (com.tencent.hlyyb.common.a.a.e())
    {
      this.j = -77;
      return;
    }
    if (!com.tencent.hlyyb.common.a.a.h())
    {
      this.j = -15;
      return;
    }
    if (!f.a("info.3g.qq.com", 80, 5000))
    {
      this.j = -16;
      return;
    }
    this.j = b(paramThrowable);
  }
  
  private static int b(Throwable paramThrowable)
  {
    int i2 = -48;
    try
    {
      boolean bool = paramThrowable.getMessage().contains("Permission");
      if (!bool) {
        break label24;
      }
      i1 = -71;
    }
    catch (Throwable localThrowable)
    {
      label24:
      do
      {
        do
        {
          if (!(paramThrowable instanceof Exception)) {
            return -70;
          }
          i1 = i2;
        } while (paramThrowable == null);
        if ((paramThrowable instanceof SocketTimeoutException)) {
          return -25;
        }
        if ((paramThrowable instanceof UnknownHostException)) {
          return -29;
        }
        if ((paramThrowable instanceof ConnectException)) {
          return -24;
        }
        if ((paramThrowable instanceof SocketException)) {
          return -26;
        }
        int i1 = i2;
      } while (!(paramThrowable instanceof IOException));
    }
    return i1;
    return -27;
  }
  
  private static long b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split("/");
      if ((paramString != null) && (paramString.length == 2)) {
        try
        {
          long l1 = Long.valueOf(paramString[1]).longValue();
          return l1;
        }
        catch (NumberFormatException paramString)
        {
          paramString.printStackTrace();
        }
      }
    }
    return -1L;
  }
  
  private static long c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        long l1 = Long.valueOf(paramString).longValue();
        return l1;
      }
      catch (NumberFormatException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return -1L;
  }
  
  private void t()
  {
    if (c.a(this.i).size() > 0) {
      this.p.addRequestProperty("Range", this.i.toString());
    }
    this.p.addRequestProperty("Connection", "close");
    int i2;
    if (this.d != null)
    {
      Iterator localIterator = this.d.keySet().iterator();
      int i1 = 0;
      i2 = i1;
      if (!localIterator.hasNext()) {
        break label136;
      }
      String str1 = (String)localIterator.next();
      String str2 = (String)this.d.get(str1);
      this.p.addRequestProperty(str1, str2);
      if (!"User-Agent".equalsIgnoreCase(str1)) {
        break label154;
      }
      i1 = 1;
    }
    label136:
    label154:
    for (;;)
    {
      break;
      i2 = 0;
      if (i2 == 0) {
        this.p.addRequestProperty("User-Agent", "HalleyService/3.0");
      }
      return;
    }
  }
  
  public final int a()
  {
    return this.j;
  }
  
  public final String a(boolean paramBoolean)
  {
    if ((this.g == null) || (this.g.size() == 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i2 = this.g.size();
    int i1 = 0;
    while (i1 < i2 - 1)
    {
      localStringBuilder.append(com.tencent.hlyyb.common.b.b.a((String)this.g.get(i1), false)).append("-");
      i1 += 1;
    }
    return localStringBuilder.toString();
  }
  
  public final void a(b paramb)
  {
    this.i.a(paramb);
  }
  
  public final void a(d paramd)
  {
    long l6 = 0L;
    long l4 = 0L;
    long l1 = l4;
    long l2 = l6;
    for (;;)
    {
      long l3;
      long l7;
      long l5;
      int i1;
      try
      {
        this.q = this.p.getInputStream();
        l1 = l4;
        l2 = l6;
        Object localObject = this.i.b();
        if (localObject == null)
        {
          l1 = l4;
          l2 = l6;
          l3 = this.x;
          l1 = l4;
          l2 = l6;
          localObject = new byte[this.l];
          l7 = 0L;
          bool2 = true;
          bool1 = true;
          if (l7 >= l3) {
            continue;
          }
          l1 = l4;
          l2 = l6;
          bool3 = this.f.a();
          if (!bool3) {}
        }
        else
        {
          l1 = l4;
          l2 = l6;
          l3 = ((b)localObject).b;
          l1 = l4;
          l2 = l6;
          l5 = ((b)localObject).a;
          l1 = l4;
          l2 = l6;
          if (((b)localObject).b != -1L) {
            break label513;
          }
          l1 = l4;
          l2 = l6;
          l3 = this.x;
          continue;
        }
        if (!bool1) {
          return;
        }
        l1 = l4;
        l2 = l6;
        i1 = (int)Math.min(this.l, l3 - l7);
        l5 = l6;
        if (l7 == 0L)
        {
          l1 = l4;
          l2 = l6;
          l5 = SystemClock.elapsedRealtime();
        }
        l1 = l4;
        l2 = l5;
        i1 = this.q.read((byte[])localObject, 0, i1);
        l6 = l4;
        if (l7 == 0L)
        {
          l1 = l4;
          l2 = l5;
          l6 = SystemClock.elapsedRealtime();
        }
        if (i1 != -1)
        {
          bool3 = bool1;
          bool4 = bool2;
          if (paramd == null) {
            break label543;
          }
          l1 = l6;
          l2 = l5;
          if (this.f.a()) {
            break label523;
          }
          l1 = l6;
          l2 = l5;
          bool1 = paramd.a((byte[])localObject, i1, bool2);
          break label523;
        }
        l1 = l6;
        l2 = l5;
        this.j = -62;
        l1 = l6;
        l2 = l5;
        this.k = ("readLen:" + l7 + ",dataLen:" + l3);
        return;
        return;
      }
      catch (Throwable paramd)
      {
        a(paramd);
        if ((l2 != 0L) && (l1 == 0L)) {
          SystemClock.elapsedRealtime();
        }
        return;
      }
      finally
      {
        if (this.z) {
          this.j = -66;
        }
        r();
      }
      label513:
      l3 -= l5;
      continue;
      label523:
      boolean bool3 = bool1;
      boolean bool4 = bool2;
      if (bool2)
      {
        bool4 = false;
        bool3 = bool1;
      }
      label543:
      l7 += i1;
      boolean bool1 = bool3;
      boolean bool2 = bool4;
      l4 = l6;
      l6 = l5;
    }
  }
  
  public final String b()
  {
    return this.k;
  }
  
  public final long c()
  {
    return this.x;
  }
  
  public final String d()
  {
    return com.tencent.hlyyb.common.b.b.a(this.h, false);
  }
  
  public final String e()
  {
    if ((this.g != null) && (this.g.size() > 0)) {
      return (String)this.g.get(this.g.size() - 1);
    }
    return null;
  }
  
  public final String f()
  {
    String str2 = "";
    String str1 = str2;
    if (this.g != null)
    {
      str1 = str2;
      if (this.g.size() > 0) {
        str1 = (String)this.g.get(this.g.size() - 1);
      }
    }
    return com.tencent.hlyyb.common.b.b.a(str1, false);
  }
  
  public final String g()
  {
    return this.n;
  }
  
  public final String h()
  {
    return this.r;
  }
  
  public final String i()
  {
    return this.s;
  }
  
  public final String j()
  {
    return this.t;
  }
  
  public final String k()
  {
    return this.v;
  }
  
  public final String l()
  {
    return this.w;
  }
  
  public final String m()
  {
    return this.u;
  }
  
  public final List<String> n()
  {
    return this.y;
  }
  
  public final boolean o()
  {
    return this.i.a() > 0;
  }
  
  /* Error */
  public final void p()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 371	com/tencent/hlyyb/downloader/a/a/a:h	Ljava/lang/String;
    //   4: invokestatic 120	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +41 -> 48
    //   10: aload_0
    //   11: getfield 380	com/tencent/hlyyb/downloader/a/a/a:a	I
    //   14: iconst_2
    //   15: if_icmpne +70 -> 85
    //   18: aload_0
    //   19: getfield 382	com/tencent/hlyyb/downloader/a/a/a:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   22: astore 4
    //   24: aload 4
    //   26: getfield 386	com/tencent/hlyyb/downloader/e/d/a:e	Ljava/lang/String;
    //   29: invokestatic 120	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   32: ifne +43 -> 75
    //   35: aload 4
    //   37: getfield 386	com/tencent/hlyyb/downloader/e/d/a:e	Ljava/lang/String;
    //   40: astore 4
    //   42: aload_0
    //   43: aload 4
    //   45: putfield 371	com/tencent/hlyyb/downloader/a/a/a:h	Ljava/lang/String;
    //   48: aload_0
    //   49: invokevirtual 331	com/tencent/hlyyb/downloader/a/a/a:r	()V
    //   52: iconst_0
    //   53: istore_1
    //   54: iload_1
    //   55: aload_0
    //   56: getfield 72	com/tencent/hlyyb/downloader/a/a/a:m	I
    //   59: if_icmpge +348 -> 407
    //   62: aload_0
    //   63: getfield 325	com/tencent/hlyyb/downloader/a/a/a:f	Lcom/tencent/hlyyb/downloader/a/b;
    //   66: invokeinterface 329 1 0
    //   71: ifeq +81 -> 152
    //   74: return
    //   75: aload 4
    //   77: getfield 388	com/tencent/hlyyb/downloader/e/d/a:a	Ljava/lang/String;
    //   80: astore 4
    //   82: goto -40 -> 42
    //   85: aload_0
    //   86: getfield 382	com/tencent/hlyyb/downloader/a/a/a:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   89: getfield 390	com/tencent/hlyyb/downloader/e/d/a:d	Z
    //   92: ifeq +46 -> 138
    //   95: aload_0
    //   96: getfield 382	com/tencent/hlyyb/downloader/a/a/a:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   99: astore 4
    //   101: aload 4
    //   103: getfield 386	com/tencent/hlyyb/downloader/e/d/a:e	Ljava/lang/String;
    //   106: invokestatic 120	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   109: ifne +19 -> 128
    //   112: aload 4
    //   114: getfield 386	com/tencent/hlyyb/downloader/e/d/a:e	Ljava/lang/String;
    //   117: astore 4
    //   119: aload_0
    //   120: aload 4
    //   122: putfield 371	com/tencent/hlyyb/downloader/a/a/a:h	Ljava/lang/String;
    //   125: goto -77 -> 48
    //   128: aload 4
    //   130: getfield 388	com/tencent/hlyyb/downloader/e/d/a:a	Ljava/lang/String;
    //   133: astore 4
    //   135: goto -16 -> 119
    //   138: aload_0
    //   139: aload_0
    //   140: getfield 382	com/tencent/hlyyb/downloader/a/a/a:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   143: getfield 388	com/tencent/hlyyb/downloader/e/d/a:a	Ljava/lang/String;
    //   146: putfield 371	com/tencent/hlyyb/downloader/a/a/a:h	Ljava/lang/String;
    //   149: goto -101 -> 48
    //   152: aload_0
    //   153: iconst_0
    //   154: putfield 62	com/tencent/hlyyb/downloader/a/a/a:j	I
    //   157: aload_0
    //   158: ldc 64
    //   160: putfield 66	com/tencent/hlyyb/downloader/a/a/a:k	Ljava/lang/String;
    //   163: aload_0
    //   164: new 124	java/net/URL
    //   167: dup
    //   168: aload_0
    //   169: getfield 371	com/tencent/hlyyb/downloader/a/a/a:h	Ljava/lang/String;
    //   172: invokespecial 126	java/net/URL:<init>	(Ljava/lang/String;)V
    //   175: putfield 76	com/tencent/hlyyb/downloader/a/a/a:o	Ljava/net/URL;
    //   178: aload_0
    //   179: aload_0
    //   180: getfield 76	com/tencent/hlyyb/downloader/a/a/a:o	Ljava/net/URL;
    //   183: invokevirtual 394	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   186: checkcast 110	java/net/HttpURLConnection
    //   189: putfield 78	com/tencent/hlyyb/downloader/a/a/a:p	Ljava/net/HttpURLConnection;
    //   192: aload_0
    //   193: getfield 78	com/tencent/hlyyb/downloader/a/a/a:p	Ljava/net/HttpURLConnection;
    //   196: sipush 20000
    //   199: invokevirtual 398	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   202: aload_0
    //   203: getfield 78	com/tencent/hlyyb/downloader/a/a/a:p	Ljava/net/HttpURLConnection;
    //   206: sipush 20000
    //   209: invokevirtual 401	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   212: aload_0
    //   213: getfield 78	com/tencent/hlyyb/downloader/a/a/a:p	Ljava/net/HttpURLConnection;
    //   216: iconst_0
    //   217: invokevirtual 405	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   220: aload_0
    //   221: getfield 78	com/tencent/hlyyb/downloader/a/a/a:p	Ljava/net/HttpURLConnection;
    //   224: iconst_1
    //   225: invokevirtual 408	java/net/HttpURLConnection:setDoInput	(Z)V
    //   228: aload_0
    //   229: getfield 78	com/tencent/hlyyb/downloader/a/a/a:p	Ljava/net/HttpURLConnection;
    //   232: iconst_0
    //   233: invokevirtual 411	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   236: aload_0
    //   237: invokespecial 413	com/tencent/hlyyb/downloader/a/a/a:t	()V
    //   240: aload_0
    //   241: getfield 78	com/tencent/hlyyb/downloader/a/a/a:p	Ljava/net/HttpURLConnection;
    //   244: invokevirtual 416	java/net/HttpURLConnection:getResponseCode	()I
    //   247: istore_3
    //   248: aload_0
    //   249: iconst_1
    //   250: putfield 102	com/tencent/hlyyb/downloader/a/a/a:A	Z
    //   253: iload_3
    //   254: lookupswitch	default:+799->1053, 200:+268->522, 206:+268->522, 301:+613->867, 302:+613->867, 303:+613->867, 307:+613->867, 413:+721->975, 500:+721->975
    //   329: iload_3
    //   330: putfield 62	com/tencent/hlyyb/downloader/a/a/a:j	I
    //   333: iload_1
    //   334: ifne +27 -> 361
    //   337: aload_0
    //   338: getfield 102	com/tencent/hlyyb/downloader/a/a/a:A	Z
    //   341: ifeq +20 -> 361
    //   344: aload_0
    //   345: aload_0
    //   346: getfield 76	com/tencent/hlyyb/downloader/a/a/a:o	Ljava/net/URL;
    //   349: invokevirtual 419	java/net/URL:getHost	()Ljava/lang/String;
    //   352: invokestatic 425	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   355: invokevirtual 428	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   358: putfield 74	com/tencent/hlyyb/downloader/a/a/a:n	Ljava/lang/String;
    //   361: aload_0
    //   362: getfield 62	com/tencent/hlyyb/downloader/a/a/a:j	I
    //   365: bipush 199
    //   367: if_icmpne +40 -> 407
    //   370: aload_0
    //   371: getfield 430	com/tencent/hlyyb/downloader/a/a/a:c	Z
    //   374: ifeq +657 -> 1031
    //   377: aload_0
    //   378: bipush 182
    //   380: putfield 62	com/tencent/hlyyb/downloader/a/a/a:j	I
    //   383: aload_0
    //   384: new 170	java/lang/StringBuilder
    //   387: dup
    //   388: ldc_w 432
    //   391: invokespecial 362	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   394: aload_0
    //   395: getfield 371	com/tencent/hlyyb/downloader/a/a/a:h	Ljava/lang/String;
    //   398: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   404: putfield 66	com/tencent/hlyyb/downloader/a/a/a:k	Ljava/lang/String;
    //   407: iload_1
    //   408: aload_0
    //   409: getfield 72	com/tencent/hlyyb/downloader/a/a/a:m	I
    //   412: if_icmplt +17 -> 429
    //   415: aload_0
    //   416: getfield 62	com/tencent/hlyyb/downloader/a/a/a:j	I
    //   419: bipush 199
    //   421: if_icmpne +8 -> 429
    //   424: aload_0
    //   425: iconst_m1
    //   426: putfield 62	com/tencent/hlyyb/downloader/a/a/a:j	I
    //   429: aload_0
    //   430: getfield 62	com/tencent/hlyyb/downloader/a/a/a:j	I
    //   433: ifne -359 -> 74
    //   436: aload_0
    //   437: getfield 382	com/tencent/hlyyb/downloader/a/a/a:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   440: getfield 386	com/tencent/hlyyb/downloader/e/d/a:e	Ljava/lang/String;
    //   443: invokestatic 120	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   446: ifeq -372 -> 74
    //   449: aload_0
    //   450: invokevirtual 434	com/tencent/hlyyb/downloader/a/a/a:e	()Ljava/lang/String;
    //   453: astore 4
    //   455: aload 4
    //   457: invokestatic 120	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   460: ifne +578 -> 1038
    //   463: aload_0
    //   464: getfield 382	com/tencent/hlyyb/downloader/a/a/a:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   467: aload 4
    //   469: putfield 386	com/tencent/hlyyb/downloader/e/d/a:e	Ljava/lang/String;
    //   472: return
    //   473: astore 4
    //   475: aload 4
    //   477: invokevirtual 435	java/lang/Exception:printStackTrace	()V
    //   480: return
    //   481: astore 4
    //   483: aload_0
    //   484: bipush 205
    //   486: putfield 62	com/tencent/hlyyb/downloader/a/a/a:j	I
    //   489: aload_0
    //   490: aload 4
    //   492: invokevirtual 436	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   495: putfield 66	com/tencent/hlyyb/downloader/a/a/a:k	Ljava/lang/String;
    //   498: aload 4
    //   500: invokevirtual 437	java/net/MalformedURLException:printStackTrace	()V
    //   503: goto -170 -> 333
    //   506: astore 4
    //   508: aload_0
    //   509: aload 4
    //   511: invokespecial 369	com/tencent/hlyyb/downloader/a/a/a:a	(Ljava/lang/Throwable;)V
    //   514: aload 4
    //   516: invokevirtual 438	java/io/IOException:printStackTrace	()V
    //   519: goto -186 -> 333
    //   522: aload_0
    //   523: aload_0
    //   524: getfield 78	com/tencent/hlyyb/downloader/a/a/a:p	Ljava/net/HttpURLConnection;
    //   527: ldc_w 440
    //   530: invokevirtual 114	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   533: putfield 82	com/tencent/hlyyb/downloader/a/a/a:r	Ljava/lang/String;
    //   536: aload_0
    //   537: getfield 82	com/tencent/hlyyb/downloader/a/a/a:r	Ljava/lang/String;
    //   540: astore 4
    //   542: aload 4
    //   544: invokestatic 120	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   547: ifne +78 -> 625
    //   550: aload 4
    //   552: invokevirtual 443	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   555: astore 4
    //   557: aload 4
    //   559: ldc_w 445
    //   562: invokevirtual 142	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   565: ifne +491 -> 1056
    //   568: aload 4
    //   570: ldc_w 447
    //   573: invokevirtual 142	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   576: ifne +480 -> 1056
    //   579: aload 4
    //   581: ldc_w 449
    //   584: invokevirtual 142	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   587: ifeq +38 -> 625
    //   590: goto +466 -> 1056
    //   593: iload_2
    //   594: ifeq +36 -> 630
    //   597: aload_0
    //   598: bipush 245
    //   600: putfield 62	com/tencent/hlyyb/downloader/a/a/a:j	I
    //   603: aload_0
    //   604: aload_0
    //   605: getfield 371	com/tencent/hlyyb/downloader/a/a/a:h	Ljava/lang/String;
    //   608: putfield 66	com/tencent/hlyyb/downloader/a/a/a:k	Ljava/lang/String;
    //   611: goto -278 -> 333
    //   614: astore 4
    //   616: aload_0
    //   617: aload 4
    //   619: invokespecial 369	com/tencent/hlyyb/downloader/a/a/a:a	(Ljava/lang/Throwable;)V
    //   622: goto -289 -> 333
    //   625: iconst_0
    //   626: istore_2
    //   627: goto -34 -> 593
    //   630: aload_0
    //   631: aload_0
    //   632: getfield 78	com/tencent/hlyyb/downloader/a/a/a:p	Ljava/net/HttpURLConnection;
    //   635: ldc_w 451
    //   638: invokevirtual 114	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   641: putfield 84	com/tencent/hlyyb/downloader/a/a/a:s	Ljava/lang/String;
    //   644: aload_0
    //   645: aload_0
    //   646: getfield 78	com/tencent/hlyyb/downloader/a/a/a:p	Ljava/net/HttpURLConnection;
    //   649: ldc_w 453
    //   652: invokevirtual 114	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   655: putfield 86	com/tencent/hlyyb/downloader/a/a/a:t	Ljava/lang/String;
    //   658: aload_0
    //   659: getfield 58	com/tencent/hlyyb/downloader/a/a/a:i	Lcom/tencent/hlyyb/downloader/a/a/c;
    //   662: invokevirtual 376	com/tencent/hlyyb/downloader/a/a/c:a	()I
    //   665: ifle +396 -> 1061
    //   668: iconst_1
    //   669: istore_2
    //   670: iload_2
    //   671: ifeq +77 -> 748
    //   674: aload_0
    //   675: getfield 84	com/tencent/hlyyb/downloader/a/a/a:s	Ljava/lang/String;
    //   678: invokestatic 120	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   681: ifne +58 -> 739
    //   684: aload_0
    //   685: aload_0
    //   686: getfield 84	com/tencent/hlyyb/downloader/a/a/a:s	Ljava/lang/String;
    //   689: invokestatic 455	com/tencent/hlyyb/downloader/a/a/a:b	(Ljava/lang/String;)J
    //   692: putfield 96	com/tencent/hlyyb/downloader/a/a/a:x	J
    //   695: aload_0
    //   696: getfield 96	com/tencent/hlyyb/downloader/a/a/a:x	J
    //   699: ldc2_w 93
    //   702: lcmp
    //   703: ifne +119 -> 822
    //   706: aload_0
    //   707: bipush 202
    //   709: putfield 62	com/tencent/hlyyb/downloader/a/a/a:j	I
    //   712: aload_0
    //   713: new 170	java/lang/StringBuilder
    //   716: dup
    //   717: ldc_w 457
    //   720: invokespecial 362	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   723: aload_0
    //   724: getfield 84	com/tencent/hlyyb/downloader/a/a/a:s	Ljava/lang/String;
    //   727: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   730: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   733: putfield 66	com/tencent/hlyyb/downloader/a/a/a:k	Ljava/lang/String;
    //   736: goto -403 -> 333
    //   739: aload_0
    //   740: bipush 203
    //   742: putfield 62	com/tencent/hlyyb/downloader/a/a/a:j	I
    //   745: goto -412 -> 333
    //   748: aload_0
    //   749: getfield 86	com/tencent/hlyyb/downloader/a/a/a:t	Ljava/lang/String;
    //   752: invokestatic 120	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   755: ifne +58 -> 813
    //   758: aload_0
    //   759: aload_0
    //   760: getfield 86	com/tencent/hlyyb/downloader/a/a/a:t	Ljava/lang/String;
    //   763: invokestatic 459	com/tencent/hlyyb/downloader/a/a/a:c	(Ljava/lang/String;)J
    //   766: putfield 96	com/tencent/hlyyb/downloader/a/a/a:x	J
    //   769: aload_0
    //   770: getfield 96	com/tencent/hlyyb/downloader/a/a/a:x	J
    //   773: ldc2_w 93
    //   776: lcmp
    //   777: ifne +45 -> 822
    //   780: aload_0
    //   781: bipush 200
    //   783: putfield 62	com/tencent/hlyyb/downloader/a/a/a:j	I
    //   786: aload_0
    //   787: new 170	java/lang/StringBuilder
    //   790: dup
    //   791: ldc_w 457
    //   794: invokespecial 362	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   797: aload_0
    //   798: getfield 86	com/tencent/hlyyb/downloader/a/a/a:t	Ljava/lang/String;
    //   801: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   804: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   807: putfield 66	com/tencent/hlyyb/downloader/a/a/a:k	Ljava/lang/String;
    //   810: goto -477 -> 333
    //   813: aload_0
    //   814: bipush 201
    //   816: putfield 62	com/tencent/hlyyb/downloader/a/a/a:j	I
    //   819: goto -486 -> 333
    //   822: aload_0
    //   823: aload_0
    //   824: getfield 78	com/tencent/hlyyb/downloader/a/a/a:p	Ljava/net/HttpURLConnection;
    //   827: ldc_w 461
    //   830: invokevirtual 114	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   833: putfield 90	com/tencent/hlyyb/downloader/a/a/a:v	Ljava/lang/String;
    //   836: aload_0
    //   837: aload_0
    //   838: getfield 78	com/tencent/hlyyb/downloader/a/a/a:p	Ljava/net/HttpURLConnection;
    //   841: ldc_w 463
    //   844: invokevirtual 114	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   847: putfield 92	com/tencent/hlyyb/downloader/a/a/a:w	Ljava/lang/String;
    //   850: aload_0
    //   851: aload_0
    //   852: getfield 78	com/tencent/hlyyb/downloader/a/a/a:p	Ljava/net/HttpURLConnection;
    //   855: ldc_w 465
    //   858: invokevirtual 114	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   861: putfield 88	com/tencent/hlyyb/downloader/a/a/a:u	Ljava/lang/String;
    //   864: goto -531 -> 333
    //   867: aload_0
    //   868: getfield 78	com/tencent/hlyyb/downloader/a/a/a:p	Ljava/net/HttpURLConnection;
    //   871: ldc_w 467
    //   874: invokevirtual 114	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   877: astore 4
    //   879: aload 4
    //   881: invokestatic 120	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   884: ifeq +34 -> 918
    //   887: aload_0
    //   888: bipush 198
    //   890: putfield 62	com/tencent/hlyyb/downloader/a/a/a:j	I
    //   893: aload_0
    //   894: new 170	java/lang/StringBuilder
    //   897: dup
    //   898: ldc_w 432
    //   901: invokespecial 362	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   904: aload 4
    //   906: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   909: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   912: putfield 66	com/tencent/hlyyb/downloader/a/a/a:k	Ljava/lang/String;
    //   915: goto -582 -> 333
    //   918: aload_0
    //   919: aload 4
    //   921: putfield 371	com/tencent/hlyyb/downloader/a/a/a:h	Ljava/lang/String;
    //   924: aload_0
    //   925: getfield 53	com/tencent/hlyyb/downloader/a/a/a:g	Ljava/util/List;
    //   928: ifnonnull +14 -> 942
    //   931: aload_0
    //   932: new 167	java/util/ArrayList
    //   935: dup
    //   936: invokespecial 168	java/util/ArrayList:<init>	()V
    //   939: putfield 53	com/tencent/hlyyb/downloader/a/a/a:g	Ljava/util/List;
    //   942: aload_0
    //   943: getfield 53	com/tencent/hlyyb/downloader/a/a/a:g	Ljava/util/List;
    //   946: aload 4
    //   948: invokeinterface 183 2 0
    //   953: pop
    //   954: aload_0
    //   955: aload 4
    //   957: putfield 371	com/tencent/hlyyb/downloader/a/a/a:h	Ljava/lang/String;
    //   960: aload_0
    //   961: aload 4
    //   963: invokespecial 469	com/tencent/hlyyb/downloader/a/a/a:a	(Ljava/lang/String;)V
    //   966: aload_0
    //   967: bipush 199
    //   969: putfield 62	com/tencent/hlyyb/downloader/a/a/a:j	I
    //   972: goto -639 -> 333
    //   975: invokestatic 471	com/tencent/hlyyb/common/a/a:i	()Z
    //   978: ifeq +35 -> 1013
    //   981: aload_0
    //   982: getfield 70	com/tencent/hlyyb/downloader/a/a/a:e	Z
    //   985: ifne +28 -> 1013
    //   988: aload_0
    //   989: getfield 58	com/tencent/hlyyb/downloader/a/a/a:i	Lcom/tencent/hlyyb/downloader/a/a/c;
    //   992: invokevirtual 376	com/tencent/hlyyb/downloader/a/a/c:a	()I
    //   995: ifle +71 -> 1066
    //   998: iconst_1
    //   999: istore_2
    //   1000: iload_2
    //   1001: ifeq +12 -> 1013
    //   1004: aload_0
    //   1005: bipush 197
    //   1007: putfield 62	com/tencent/hlyyb/downloader/a/a/a:j	I
    //   1010: goto -677 -> 333
    //   1013: aload_0
    //   1014: iload_3
    //   1015: putfield 62	com/tencent/hlyyb/downloader/a/a/a:j	I
    //   1018: goto -685 -> 333
    //   1021: astore 4
    //   1023: aload 4
    //   1025: invokevirtual 435	java/lang/Exception:printStackTrace	()V
    //   1028: goto -667 -> 361
    //   1031: iload_1
    //   1032: iconst_1
    //   1033: iadd
    //   1034: istore_1
    //   1035: goto -981 -> 54
    //   1038: aload_0
    //   1039: getfield 382	com/tencent/hlyyb/downloader/a/a/a:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   1042: aload_0
    //   1043: getfield 382	com/tencent/hlyyb/downloader/a/a/a:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   1046: getfield 388	com/tencent/hlyyb/downloader/e/d/a:a	Ljava/lang/String;
    //   1049: putfield 386	com/tencent/hlyyb/downloader/e/d/a:e	Ljava/lang/String;
    //   1052: return
    //   1053: goto -725 -> 328
    //   1056: iconst_1
    //   1057: istore_2
    //   1058: goto -465 -> 593
    //   1061: iconst_0
    //   1062: istore_2
    //   1063: goto -393 -> 670
    //   1066: iconst_0
    //   1067: istore_2
    //   1068: goto -68 -> 1000
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1071	0	this	a
    //   53	982	1	i1	int
    //   593	475	2	i2	int
    //   247	768	3	i3	int
    //   22	446	4	localObject	Object
    //   473	3	4	localException1	Exception
    //   481	18	4	localMalformedURLException	java.net.MalformedURLException
    //   506	9	4	localIOException	IOException
    //   540	40	4	str1	String
    //   614	4	4	localThrowable	Throwable
    //   877	85	4	str2	String
    //   1021	3	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   436	472	473	java/lang/Exception
    //   1038	1052	473	java/lang/Exception
    //   163	178	481	java/net/MalformedURLException
    //   178	192	506	java/io/IOException
    //   240	253	614	java/lang/Throwable
    //   328	333	614	java/lang/Throwable
    //   522	590	614	java/lang/Throwable
    //   597	611	614	java/lang/Throwable
    //   630	668	614	java/lang/Throwable
    //   674	736	614	java/lang/Throwable
    //   739	745	614	java/lang/Throwable
    //   748	810	614	java/lang/Throwable
    //   813	819	614	java/lang/Throwable
    //   822	864	614	java/lang/Throwable
    //   867	915	614	java/lang/Throwable
    //   918	942	614	java/lang/Throwable
    //   942	972	614	java/lang/Throwable
    //   975	998	614	java/lang/Throwable
    //   1004	1010	614	java/lang/Throwable
    //   1013	1018	614	java/lang/Throwable
    //   344	361	1021	java/lang/Exception
  }
  
  /* Error */
  public final byte[] q()
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield 78	com/tencent/hlyyb/downloader/a/a/a:p	Ljava/net/HttpURLConnection;
    //   5: invokevirtual 320	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   8: putfield 80	com/tencent/hlyyb/downloader/a/a/a:q	Ljava/io/InputStream;
    //   11: sipush 256
    //   14: newarray byte
    //   16: astore 4
    //   18: new 474	java/io/ByteArrayOutputStream
    //   21: dup
    //   22: invokespecial 475	java/io/ByteArrayOutputStream:<init>	()V
    //   25: astore_3
    //   26: aload_3
    //   27: astore_2
    //   28: aload_0
    //   29: getfield 80	com/tencent/hlyyb/downloader/a/a/a:q	Ljava/io/InputStream;
    //   32: aload 4
    //   34: invokevirtual 478	java/io/InputStream:read	([B)I
    //   37: istore_1
    //   38: iload_1
    //   39: iconst_m1
    //   40: if_icmpeq +40 -> 80
    //   43: aload_3
    //   44: astore_2
    //   45: aload_3
    //   46: aload 4
    //   48: iconst_0
    //   49: iload_1
    //   50: invokevirtual 482	java/io/ByteArrayOutputStream:write	([BII)V
    //   53: goto -27 -> 26
    //   56: astore 4
    //   58: aload_3
    //   59: astore_2
    //   60: aload_0
    //   61: aload 4
    //   63: invokespecial 369	com/tencent/hlyyb/downloader/a/a/a:a	(Ljava/lang/Throwable;)V
    //   66: aload_0
    //   67: invokevirtual 331	com/tencent/hlyyb/downloader/a/a/a:r	()V
    //   70: aload_3
    //   71: ifnull +7 -> 78
    //   74: aload_3
    //   75: invokevirtual 484	java/io/ByteArrayOutputStream:close	()V
    //   78: aconst_null
    //   79: areturn
    //   80: aload_3
    //   81: astore_2
    //   82: aload_3
    //   83: invokevirtual 487	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   86: astore 4
    //   88: aload_0
    //   89: invokevirtual 331	com/tencent/hlyyb/downloader/a/a/a:r	()V
    //   92: aload_3
    //   93: invokevirtual 484	java/io/ByteArrayOutputStream:close	()V
    //   96: aload 4
    //   98: areturn
    //   99: astore_2
    //   100: aload 4
    //   102: areturn
    //   103: astore_3
    //   104: aconst_null
    //   105: astore_2
    //   106: aload_0
    //   107: invokevirtual 331	com/tencent/hlyyb/downloader/a/a/a:r	()V
    //   110: aload_2
    //   111: ifnull +7 -> 118
    //   114: aload_2
    //   115: invokevirtual 484	java/io/ByteArrayOutputStream:close	()V
    //   118: aload_3
    //   119: athrow
    //   120: astore_2
    //   121: aconst_null
    //   122: areturn
    //   123: astore_2
    //   124: goto -6 -> 118
    //   127: astore_3
    //   128: goto -22 -> 106
    //   131: astore 4
    //   133: aconst_null
    //   134: astore_3
    //   135: goto -77 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	a
    //   37	13	1	i1	int
    //   27	55	2	localByteArrayOutputStream1	java.io.ByteArrayOutputStream
    //   99	1	2	localIOException1	IOException
    //   105	10	2	localObject1	Object
    //   120	1	2	localIOException2	IOException
    //   123	1	2	localIOException3	IOException
    //   25	68	3	localByteArrayOutputStream2	java.io.ByteArrayOutputStream
    //   103	16	3	localObject2	Object
    //   127	1	3	localObject3	Object
    //   134	1	3	localObject4	Object
    //   16	31	4	arrayOfByte1	byte[]
    //   56	6	4	localThrowable1	Throwable
    //   86	15	4	arrayOfByte2	byte[]
    //   131	1	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   28	38	56	java/lang/Throwable
    //   45	53	56	java/lang/Throwable
    //   82	88	56	java/lang/Throwable
    //   92	96	99	java/io/IOException
    //   0	26	103	finally
    //   74	78	120	java/io/IOException
    //   114	118	123	java/io/IOException
    //   28	38	127	finally
    //   45	53	127	finally
    //   60	66	127	finally
    //   82	88	127	finally
    //   0	26	131	java/lang/Throwable
  }
  
  public final void r()
  {
    if (this.p != null) {}
    try
    {
      this.p.disconnect();
      this.q.close();
      label21:
      this.p = null;
      this.q = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      break label21;
    }
  }
  
  public final void s()
  {
    this.z = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.a.a.a
 * JD-Core Version:    0.7.0.1
 */