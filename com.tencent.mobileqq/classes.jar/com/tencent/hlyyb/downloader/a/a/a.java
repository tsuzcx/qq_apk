package com.tencent.hlyyb.downloader.a.a;

import android.text.TextUtils;
import com.tencent.hlyyb.common.a.f;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
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
    Object localObject = this.p;
    if (localObject != null) {
      localObject = ((HttpURLConnection)localObject).getHeaderField("X-Extra-Servers");
    } else {
      localObject = "";
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    try
    {
      boolean bool = "http".equals(new URL(paramString).getProtocol());
      if (!bool) {
        return;
      }
      if (!paramString.startsWith("http://")) {
        return;
      }
      int i1 = paramString.indexOf("/", 7);
      if (i1 == -1) {
        return;
      }
      paramString.substring(7, i1);
      paramString = paramString.substring(i1);
      localObject = ((String)localObject).split(";");
      if ((localObject != null) && (localObject.length > 0))
      {
        this.y = new ArrayList();
        int i2 = localObject.length;
        i1 = 0;
        while (i1 < i2)
        {
          String str = localObject[i1];
          List localList = this.y;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("http://");
          localStringBuilder.append(str);
          localStringBuilder.append(paramString);
          localList.add(localStringBuilder.toString());
          i1 += 1;
        }
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  private void a(Throwable paramThrowable)
  {
    paramThrowable.printStackTrace();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramThrowable.getClass().getName());
    localStringBuilder.append("|");
    localStringBuilder.append(paramThrowable);
    this.k = localStringBuilder.toString();
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
    try
    {
      boolean bool = paramThrowable.getMessage().contains("Permission");
      if (bool) {
        return -71;
      }
    }
    catch (Throwable localThrowable)
    {
      label17:
      break label17;
    }
    if (!(paramThrowable instanceof Exception)) {
      return -70;
    }
    if (paramThrowable != null)
    {
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
      if ((paramThrowable instanceof IOException)) {
        return -27;
      }
    }
    return -48;
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
    int i2 = 0;
    int i1 = 0;
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = ((Map)localObject).keySet().iterator();
      for (;;)
      {
        i2 = i1;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        String str1 = (String)((Iterator)localObject).next();
        String str2 = (String)this.d.get(str1);
        this.p.addRequestProperty(str1, str2);
        if ("User-Agent".equalsIgnoreCase(str1)) {
          i1 = 1;
        }
      }
    }
    if (i2 == 0) {
      this.p.addRequestProperty("User-Agent", "HalleyService/3.0");
    }
  }
  
  public final int a()
  {
    return this.j;
  }
  
  public final String a(boolean paramBoolean)
  {
    Object localObject = this.g;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      localObject = new StringBuilder();
      int i2 = this.g.size();
      int i1 = 0;
      while (i1 < i2 - 1)
      {
        ((StringBuilder)localObject).append(com.tencent.hlyyb.common.b.b.a((String)this.g.get(i1), false));
        ((StringBuilder)localObject).append("-");
        i1 += 1;
      }
      return ((StringBuilder)localObject).toString();
    }
    return "";
  }
  
  public final void a(b paramb)
  {
    this.i.a(paramb);
  }
  
  /* Error */
  public final void a(d paramd)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield 78	com/tencent/hlyyb/downloader/a/a/a:p	Ljava/net/HttpURLConnection;
    //   5: invokevirtual 317	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   8: putfield 80	com/tencent/hlyyb/downloader/a/a/a:q	Ljava/io/InputStream;
    //   11: aload_0
    //   12: getfield 58	com/tencent/hlyyb/downloader/a/a/a:i	Lcom/tencent/hlyyb/downloader/a/a/c;
    //   15: invokevirtual 320	com/tencent/hlyyb/downloader/a/a/c:b	()Lcom/tencent/hlyyb/downloader/a/a/b;
    //   18: astore 19
    //   20: aload 19
    //   22: ifnonnull +12 -> 34
    //   25: aload_0
    //   26: getfield 96	com/tencent/hlyyb/downloader/a/a/a:x	J
    //   29: lstore 11
    //   31: goto +31 -> 62
    //   34: aload 19
    //   36: getfield 324	com/tencent/hlyyb/downloader/a/a/b:b	J
    //   39: lstore_3
    //   40: aload 19
    //   42: getfield 326	com/tencent/hlyyb/downloader/a/a/b:a	J
    //   45: lstore 5
    //   47: aload 19
    //   49: getfield 324	com/tencent/hlyyb/downloader/a/a/b:b	J
    //   52: ldc2_w 93
    //   55: lcmp
    //   56: ifne +428 -> 484
    //   59: goto -34 -> 25
    //   62: aload_0
    //   63: getfield 68	com/tencent/hlyyb/downloader/a/a/a:l	I
    //   66: newarray byte
    //   68: astore 19
    //   70: lconst_0
    //   71: lstore 13
    //   73: iconst_1
    //   74: istore 15
    //   76: iconst_1
    //   77: istore 16
    //   79: lconst_0
    //   80: lstore_3
    //   81: lconst_0
    //   82: lstore 5
    //   84: lload 13
    //   86: lload 11
    //   88: lcmp
    //   89: ifge +301 -> 390
    //   92: aload_0
    //   93: getfield 328	com/tencent/hlyyb/downloader/a/a/a:f	Lcom/tencent/hlyyb/downloader/a/b;
    //   96: invokeinterface 332 1 0
    //   101: istore 17
    //   103: iload 17
    //   105: ifeq +21 -> 126
    //   108: aload_0
    //   109: getfield 100	com/tencent/hlyyb/downloader/a/a/a:z	Z
    //   112: ifeq +9 -> 121
    //   115: aload_0
    //   116: bipush 190
    //   118: putfield 62	com/tencent/hlyyb/downloader/a/a/a:j	I
    //   121: aload_0
    //   122: invokevirtual 334	com/tencent/hlyyb/downloader/a/a/a:r	()V
    //   125: return
    //   126: iload 15
    //   128: ifne +21 -> 149
    //   131: aload_0
    //   132: getfield 100	com/tencent/hlyyb/downloader/a/a/a:z	Z
    //   135: ifeq +9 -> 144
    //   138: aload_0
    //   139: bipush 190
    //   141: putfield 62	com/tencent/hlyyb/downloader/a/a/a:j	I
    //   144: aload_0
    //   145: invokevirtual 334	com/tencent/hlyyb/downloader/a/a/a:r	()V
    //   148: return
    //   149: aload_0
    //   150: getfield 68	com/tencent/hlyyb/downloader/a/a/a:l	I
    //   153: istore_2
    //   154: iload_2
    //   155: i2l
    //   156: lstore 7
    //   158: lload 7
    //   160: lload 11
    //   162: lload 13
    //   164: lsub
    //   165: invokestatic 340	java/lang/Math:min	(JJ)J
    //   168: l2i
    //   169: istore_2
    //   170: lload 13
    //   172: lconst_0
    //   173: lcmp
    //   174: ifne +14 -> 188
    //   177: invokestatic 345	android/os/SystemClock:elapsedRealtime	()J
    //   180: lstore 7
    //   182: lload 7
    //   184: lstore_3
    //   185: goto +3 -> 188
    //   188: lload 5
    //   190: lstore 9
    //   192: aload_0
    //   193: getfield 80	com/tencent/hlyyb/downloader/a/a/a:q	Ljava/io/InputStream;
    //   196: astore 20
    //   198: lload 5
    //   200: lstore 9
    //   202: aload 20
    //   204: aload 19
    //   206: iconst_0
    //   207: iload_2
    //   208: invokevirtual 351	java/io/InputStream:read	([BII)I
    //   211: istore_2
    //   212: lload 5
    //   214: lstore 7
    //   216: lload 13
    //   218: lconst_0
    //   219: lcmp
    //   220: ifne +12 -> 232
    //   223: lload 5
    //   225: lstore 9
    //   227: invokestatic 345	android/os/SystemClock:elapsedRealtime	()J
    //   230: lstore 7
    //   232: iload_2
    //   233: iconst_m1
    //   234: if_icmpeq +51 -> 285
    //   237: iload 15
    //   239: istore 17
    //   241: iload 16
    //   243: istore 18
    //   245: aload_1
    //   246: ifnull +267 -> 513
    //   249: lload 7
    //   251: lstore 9
    //   253: aload_0
    //   254: getfield 328	com/tencent/hlyyb/downloader/a/a/a:f	Lcom/tencent/hlyyb/downloader/a/b;
    //   257: invokeinterface 332 1 0
    //   262: ifne +231 -> 493
    //   265: lload 7
    //   267: lstore 9
    //   269: aload_1
    //   270: aload 19
    //   272: iload_2
    //   273: iload 16
    //   275: invokeinterface 356 4 0
    //   280: istore 15
    //   282: goto +211 -> 493
    //   285: lload 7
    //   287: lstore 9
    //   289: aload_0
    //   290: bipush 194
    //   292: putfield 62	com/tencent/hlyyb/downloader/a/a/a:j	I
    //   295: lload 7
    //   297: lstore 9
    //   299: new 166	java/lang/StringBuilder
    //   302: dup
    //   303: ldc_w 358
    //   306: invokespecial 359	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   309: astore_1
    //   310: lload 7
    //   312: lstore 9
    //   314: aload_1
    //   315: lload 13
    //   317: invokevirtual 362	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: lload 7
    //   323: lstore 9
    //   325: aload_1
    //   326: ldc_w 364
    //   329: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: lload 7
    //   335: lstore 9
    //   337: aload_1
    //   338: lload 11
    //   340: invokevirtual 362	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: lload 7
    //   346: lstore 9
    //   348: aload_0
    //   349: aload_1
    //   350: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   353: putfield 66	com/tencent/hlyyb/downloader/a/a/a:k	Ljava/lang/String;
    //   356: aload_0
    //   357: getfield 100	com/tencent/hlyyb/downloader/a/a/a:z	Z
    //   360: ifeq +9 -> 369
    //   363: aload_0
    //   364: bipush 190
    //   366: putfield 62	com/tencent/hlyyb/downloader/a/a/a:j	I
    //   369: aload_0
    //   370: invokevirtual 334	com/tencent/hlyyb/downloader/a/a/a:r	()V
    //   373: return
    //   374: astore_1
    //   375: lload 9
    //   377: lstore 5
    //   379: goto +39 -> 418
    //   382: astore_1
    //   383: goto +35 -> 418
    //   386: astore_1
    //   387: goto +31 -> 418
    //   390: aload_0
    //   391: getfield 100	com/tencent/hlyyb/downloader/a/a/a:z	Z
    //   394: ifeq +9 -> 403
    //   397: aload_0
    //   398: bipush 190
    //   400: putfield 62	com/tencent/hlyyb/downloader/a/a/a:j	I
    //   403: aload_0
    //   404: invokevirtual 334	com/tencent/hlyyb/downloader/a/a/a:r	()V
    //   407: return
    //   408: astore_1
    //   409: goto +50 -> 459
    //   412: astore_1
    //   413: lconst_0
    //   414: lstore_3
    //   415: lconst_0
    //   416: lstore 5
    //   418: aload_0
    //   419: aload_1
    //   420: invokespecial 366	com/tencent/hlyyb/downloader/a/a/a:a	(Ljava/lang/Throwable;)V
    //   423: lload_3
    //   424: lconst_0
    //   425: lcmp
    //   426: ifeq +14 -> 440
    //   429: lload 5
    //   431: lconst_0
    //   432: lcmp
    //   433: ifne +7 -> 440
    //   436: invokestatic 345	android/os/SystemClock:elapsedRealtime	()J
    //   439: pop2
    //   440: aload_0
    //   441: getfield 100	com/tencent/hlyyb/downloader/a/a/a:z	Z
    //   444: ifeq +9 -> 453
    //   447: aload_0
    //   448: bipush 190
    //   450: putfield 62	com/tencent/hlyyb/downloader/a/a/a:j	I
    //   453: aload_0
    //   454: invokevirtual 334	com/tencent/hlyyb/downloader/a/a/a:r	()V
    //   457: return
    //   458: astore_1
    //   459: aload_0
    //   460: getfield 100	com/tencent/hlyyb/downloader/a/a/a:z	Z
    //   463: ifeq +9 -> 472
    //   466: aload_0
    //   467: bipush 190
    //   469: putfield 62	com/tencent/hlyyb/downloader/a/a/a:j	I
    //   472: aload_0
    //   473: invokevirtual 334	com/tencent/hlyyb/downloader/a/a/a:r	()V
    //   476: goto +5 -> 481
    //   479: aload_1
    //   480: athrow
    //   481: goto -2 -> 479
    //   484: lload_3
    //   485: lload 5
    //   487: lsub
    //   488: lstore 11
    //   490: goto -428 -> 62
    //   493: iload 15
    //   495: istore 17
    //   497: iload 16
    //   499: istore 18
    //   501: iload 16
    //   503: ifeq +10 -> 513
    //   506: iconst_0
    //   507: istore 18
    //   509: iload 15
    //   511: istore 17
    //   513: lload 13
    //   515: iload_2
    //   516: i2l
    //   517: ladd
    //   518: lstore 13
    //   520: iload 17
    //   522: istore 15
    //   524: iload 18
    //   526: istore 16
    //   528: lload 7
    //   530: lstore 5
    //   532: goto -448 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	535	0	this	a
    //   0	535	1	paramd	d
    //   153	363	2	i1	int
    //   39	446	3	l1	long
    //   45	486	5	l2	long
    //   156	373	7	l3	long
    //   190	186	9	l4	long
    //   29	460	11	l5	long
    //   71	448	13	l6	long
    //   74	449	15	bool1	boolean
    //   77	450	16	bool2	boolean
    //   101	420	17	bool3	boolean
    //   243	282	18	bool4	boolean
    //   18	253	19	localObject	Object
    //   196	7	20	localInputStream	InputStream
    // Exception table:
    //   from	to	target	type
    //   192	198	374	java/lang/Throwable
    //   202	212	374	java/lang/Throwable
    //   227	232	374	java/lang/Throwable
    //   253	265	374	java/lang/Throwable
    //   269	282	374	java/lang/Throwable
    //   289	295	374	java/lang/Throwable
    //   299	310	374	java/lang/Throwable
    //   314	321	374	java/lang/Throwable
    //   325	333	374	java/lang/Throwable
    //   337	344	374	java/lang/Throwable
    //   348	356	374	java/lang/Throwable
    //   158	170	382	java/lang/Throwable
    //   177	182	382	java/lang/Throwable
    //   92	103	386	java/lang/Throwable
    //   149	154	386	java/lang/Throwable
    //   0	20	408	finally
    //   25	31	408	finally
    //   34	59	408	finally
    //   62	70	408	finally
    //   92	103	408	finally
    //   149	154	408	finally
    //   158	170	408	finally
    //   177	182	408	finally
    //   192	198	408	finally
    //   0	20	412	java/lang/Throwable
    //   25	31	412	java/lang/Throwable
    //   34	59	412	java/lang/Throwable
    //   62	70	412	java/lang/Throwable
    //   202	212	458	finally
    //   227	232	458	finally
    //   253	265	458	finally
    //   269	282	458	finally
    //   289	295	458	finally
    //   299	310	458	finally
    //   314	321	458	finally
    //   325	333	458	finally
    //   337	344	458	finally
    //   348	356	458	finally
    //   418	423	458	finally
    //   436	440	458	finally
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
    List localList = this.g;
    if ((localList != null) && (localList.size() > 0))
    {
      localList = this.g;
      return (String)localList.get(localList.size() - 1);
    }
    return null;
  }
  
  public final String f()
  {
    Object localObject = this.g;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = this.g;
      localObject = (String)((List)localObject).get(((List)localObject).size() - 1);
    }
    else
    {
      localObject = "";
    }
    return com.tencent.hlyyb.common.b.b.a((String)localObject, false);
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
  
  public final void p()
  {
    Object localObject1;
    Object localObject3;
    if (TextUtils.isEmpty(this.h)) {
      if (this.a == 2)
      {
        localObject1 = this.b;
        if (!TextUtils.isEmpty(((com.tencent.hlyyb.downloader.e.d.a)localObject1).e)) {
          localObject1 = ((com.tencent.hlyyb.downloader.e.d.a)localObject1).e;
        } else {
          localObject1 = ((com.tencent.hlyyb.downloader.e.d.a)localObject1).a;
        }
        this.h = ((String)localObject1);
      }
      else
      {
        if (this.b.d)
        {
          localObject3 = this.b;
          localObject1 = localObject3;
          if (!TextUtils.isEmpty(((com.tencent.hlyyb.downloader.e.d.a)localObject3).e))
          {
            localObject1 = ((com.tencent.hlyyb.downloader.e.d.a)localObject3).e;
            break label115;
          }
        }
        else
        {
          localObject1 = this.b;
        }
        localObject1 = ((com.tencent.hlyyb.downloader.e.d.a)localObject1).a;
        label115:
        this.h = ((String)localObject1);
      }
    }
    r();
    int i1 = 0;
    if (i1 < this.m)
    {
      if (this.f.a()) {
        return;
      }
      this.j = 0;
      this.k = "";
    }
    for (;;)
    {
      try
      {
        this.o = new URL(this.h);
        try
        {
          this.p = ((HttpURLConnection)this.o.openConnection());
          this.p.setConnectTimeout(20000);
          this.p.setReadTimeout(20000);
          this.p.setUseCaches(false);
          localObject1 = this.p;
          int i3 = 1;
          i2 = 1;
          ((HttpURLConnection)localObject1).setDoInput(true);
          this.p.setInstanceFollowRedirects(false);
          t();
          try
          {
            int i4 = this.p.getResponseCode();
            this.A = true;
            if ((i4 != 200) && (i4 != 206)) {
              if (i4 != 307) {
                if ((i4 == 413) || (i4 == 500)) {}
              }
            }
            switch (i4)
            {
            case 301: 
              this.j = i4;
              break;
              if ((!com.tencent.hlyyb.common.a.a.i()) || (this.e)) {
                continue;
              }
              if (this.i.a() <= 0) {
                break label1081;
              }
              if (i2 == 0) {
                continue;
              }
              this.j = -59;
              break;
            case 302: 
            case 303: 
              localObject1 = this.p.getHeaderField("location");
              if (TextUtils.isEmpty((CharSequence)localObject1))
              {
                this.j = -58;
                localObject3 = new StringBuilder("location:");
                ((StringBuilder)localObject3).append((String)localObject1);
                localObject1 = ((StringBuilder)localObject3).toString();
                this.k = ((String)localObject1);
                break;
              }
              this.h = ((String)localObject1);
              if (this.g == null) {
                this.g = new ArrayList();
              }
              this.g.add(localObject1);
              this.h = ((String)localObject1);
              a((String)localObject1);
              this.j = -57;
              break;
              this.r = this.p.getHeaderField("Content-Type");
              localObject1 = this.r;
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                break label1091;
              }
              localObject1 = ((String)localObject1).toLowerCase();
              if ((((String)localObject1).startsWith("text/html")) || (((String)localObject1).startsWith("text/vnd.wap.wml"))) {
                break label1086;
              }
              if (!((String)localObject1).startsWith("text/webviewhtml")) {
                break label1091;
              }
            }
          }
          catch (Throwable localThrowable)
          {
            a(localThrowable);
            break label888;
          }
          if (i2 != 0)
          {
            this.j = -11;
            localObject1 = this.h;
            continue;
          }
          this.s = this.p.getHeaderField("Content-Range");
          this.t = this.p.getHeaderField("Content-Length");
          i2 = this.i.a();
          if (i2 > 0) {
            i2 = i3;
          } else {
            i2 = 0;
          }
          if (i2 != 0)
          {
            if (!TextUtils.isEmpty(this.s))
            {
              this.x = b(this.s);
              if (this.x == -1L)
              {
                this.j = -54;
                localObject1 = new StringBuilder("content-range header:");
                ((StringBuilder)localObject1).append(this.s);
                localObject1 = ((StringBuilder)localObject1).toString();
              }
            }
            else
            {
              this.j = -53;
              break label888;
            }
          }
          else
          {
            if (TextUtils.isEmpty(this.t)) {
              continue;
            }
            this.x = c(this.t);
            if (this.x == -1L)
            {
              this.j = -56;
              localObject1 = new StringBuilder("content-range header:");
              ((StringBuilder)localObject1).append(this.t);
              localObject1 = ((StringBuilder)localObject1).toString();
              continue;
            }
          }
          this.v = this.p.getHeaderField("etag");
          this.w = this.p.getHeaderField("Last-Modified");
          this.u = this.p.getHeaderField("Content-Disposition");
          break label888;
          this.j = -55;
        }
        catch (IOException localIOException)
        {
          a(localIOException);
          localIOException.printStackTrace();
        }
        if (i1 != 0) {
          break label926;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        this.j = -51;
        this.k = localMalformedURLException.getMessage();
        localMalformedURLException.printStackTrace();
      }
      label888:
      if (this.A) {
        try
        {
          this.n = InetAddress.getByName(this.o.getHost()).getHostAddress();
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
        }
      }
      label926:
      Object localObject2;
      if (this.j == -57) {
        if (this.c)
        {
          this.j = -74;
          localObject2 = new StringBuilder("location:");
          ((StringBuilder)localObject2).append(this.h);
          this.k = ((StringBuilder)localObject2).toString();
        }
        else
        {
          i1 += 1;
          break;
        }
      }
      if ((i1 >= this.m) && (this.j == -57)) {
        this.j = -1;
      }
      if (this.j == 0) {
        try
        {
          if (TextUtils.isEmpty(this.b.e))
          {
            localObject2 = e();
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              this.b.e = ((String)localObject2);
              return;
            }
            this.b.e = this.b.a;
          }
          return;
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
      }
      return;
      continue;
      label1081:
      int i2 = 0;
      continue;
      label1086:
      i2 = 1;
      continue;
      label1091:
      i2 = 0;
    }
  }
  
  /* Error */
  public final byte[] q()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aload_0
    //   6: aload_0
    //   7: getfield 78	com/tencent/hlyyb/downloader/a/a/a:p	Ljava/net/HttpURLConnection;
    //   10: invokevirtual 317	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   13: putfield 80	com/tencent/hlyyb/downloader/a/a/a:q	Ljava/io/InputStream;
    //   16: sipush 256
    //   19: newarray byte
    //   21: astore 4
    //   23: new 471	java/io/ByteArrayOutputStream
    //   26: dup
    //   27: invokespecial 472	java/io/ByteArrayOutputStream:<init>	()V
    //   30: astore_2
    //   31: aload_2
    //   32: astore_3
    //   33: aload_0
    //   34: getfield 80	com/tencent/hlyyb/downloader/a/a/a:q	Ljava/io/InputStream;
    //   37: aload 4
    //   39: invokevirtual 475	java/io/InputStream:read	([B)I
    //   42: istore_1
    //   43: iload_1
    //   44: iconst_m1
    //   45: if_icmpeq +16 -> 61
    //   48: aload_2
    //   49: astore_3
    //   50: aload_2
    //   51: aload 4
    //   53: iconst_0
    //   54: iload_1
    //   55: invokevirtual 479	java/io/ByteArrayOutputStream:write	([BII)V
    //   58: goto -27 -> 31
    //   61: aload_2
    //   62: astore_3
    //   63: aload_2
    //   64: invokevirtual 482	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   67: astore 4
    //   69: aload_0
    //   70: invokevirtual 334	com/tencent/hlyyb/downloader/a/a/a:r	()V
    //   73: aload 4
    //   75: astore_3
    //   76: aload_2
    //   77: invokevirtual 484	java/io/ByteArrayOutputStream:close	()V
    //   80: aload_3
    //   81: areturn
    //   82: astore 4
    //   84: goto +11 -> 95
    //   87: astore_2
    //   88: goto +32 -> 120
    //   91: astore 4
    //   93: aconst_null
    //   94: astore_2
    //   95: aload_2
    //   96: astore_3
    //   97: aload_0
    //   98: aload 4
    //   100: invokespecial 366	com/tencent/hlyyb/downloader/a/a/a:a	(Ljava/lang/Throwable;)V
    //   103: aload_0
    //   104: invokevirtual 334	com/tencent/hlyyb/downloader/a/a/a:r	()V
    //   107: aload_2
    //   108: ifnull +9 -> 117
    //   111: aload 5
    //   113: astore_3
    //   114: goto -38 -> 76
    //   117: aconst_null
    //   118: areturn
    //   119: astore_2
    //   120: aload_0
    //   121: invokevirtual 334	com/tencent/hlyyb/downloader/a/a/a:r	()V
    //   124: aload_3
    //   125: ifnull +7 -> 132
    //   128: aload_3
    //   129: invokevirtual 484	java/io/ByteArrayOutputStream:close	()V
    //   132: goto +5 -> 137
    //   135: aload_2
    //   136: athrow
    //   137: goto -2 -> 135
    //   140: astore_2
    //   141: aload_3
    //   142: areturn
    //   143: astore_3
    //   144: goto -12 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	a
    //   42	13	1	i1	int
    //   30	47	2	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   87	1	2	localObject1	Object
    //   94	14	2	localObject2	Object
    //   119	17	2	localObject3	Object
    //   140	1	2	localIOException1	IOException
    //   1	141	3	localObject4	Object
    //   143	1	3	localIOException2	IOException
    //   21	53	4	arrayOfByte	byte[]
    //   82	1	4	localThrowable1	Throwable
    //   91	8	4	localThrowable2	Throwable
    //   3	109	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   33	43	82	java/lang/Throwable
    //   50	58	82	java/lang/Throwable
    //   63	69	82	java/lang/Throwable
    //   5	31	87	finally
    //   5	31	91	java/lang/Throwable
    //   33	43	119	finally
    //   50	58	119	finally
    //   63	69	119	finally
    //   97	103	119	finally
    //   76	80	140	java/io/IOException
    //   128	132	143	java/io/IOException
  }
  
  public final void r()
  {
    HttpURLConnection localHttpURLConnection = this.p;
    if (localHttpURLConnection != null) {}
    try
    {
      localHttpURLConnection.disconnect();
      this.q.close();
      label20:
      this.p = null;
      this.q = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      break label20;
    }
  }
  
  public final void s()
  {
    this.z = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.a.a.a
 * JD-Core Version:    0.7.0.1
 */