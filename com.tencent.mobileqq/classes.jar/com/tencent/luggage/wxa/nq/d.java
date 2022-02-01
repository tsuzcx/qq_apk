package com.tencent.luggage.wxa.nq;

import com.tencent.luggage.util.a;
import com.tencent.luggage.wxa.if.e;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rt.i;
import com.tencent.mm.plugin.appbrand.appcache.v;
import java.io.InputStream;

public class d
  implements e
{
  public a a = null;
  private String b;
  private String c;
  private long d;
  
  public d(String paramString1, String paramString2)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.a = a(paramString1, paramString2);
  }
  
  private a a(String paramString1, String paramString2)
  {
    long l = System.nanoTime();
    if (af.c(paramString2))
    {
      o.b("MicroMsg.WxaAudioDataSource", "pkgpath is null, return");
      return null;
    }
    paramString2 = new v(new i(paramString2));
    if (!paramString2.c())
    {
      paramString2.close();
      o.b("MicroMsg.WxaAudioDataSource", "pkg invalid");
      return null;
    }
    if (!paramString2.e())
    {
      paramString2.close();
      o.b("MicroMsg.WxaAudioDataSource", "pkg readInfo failed");
      return null;
    }
    InputStream localInputStream = paramString2.c(paramString1);
    if (localInputStream == null)
    {
      paramString2.close();
      o.b("MicroMsg.WxaAudioDataSource", "inputstream for %s is null", new Object[] { paramString1 });
      return null;
    }
    paramString2.close();
    o.e("MicroMsg.WxaAudioDataSource", "time:%d", new Object[] { Long.valueOf(System.nanoTime() - l) });
    return (a)localInputStream;
  }
  
  public int a(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.a == null)
    {
      o.b("MicroMsg.WxaAudioDataSource", "[readAt]inputstream is null");
      return -1;
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      if ((paramLong >= 0L) && (paramInt1 >= 0) && (paramInt2 > 0))
      {
        if ((paramArrayOfByte != null) && (paramInt1 + paramInt2 > paramArrayOfByte.length))
        {
          o.b("MicroMsg.WxaAudioDataSource", "offset:%d, size:%d, bytes.length:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramArrayOfByte.length) });
          return -1;
        }
        if (paramInt2 + paramLong > c()) {
          o.b("MicroMsg.WxaAudioDataSource", "position:%d, size:%d, getSize():%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt2), Long.valueOf(c()) });
        }
        if (this.d != paramLong)
        {
          this.a.a((int)paramLong);
          this.d = paramLong;
        }
        paramInt1 = this.a.read(paramArrayOfByte, paramInt1, paramInt2);
        if (paramInt1 >= 0) {
          this.d += paramInt1;
        }
        return paramInt1;
      }
      o.b("MicroMsg.WxaAudioDataSource", "position:%d, offset:%d, size:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      return -1;
    }
    o.b("MicroMsg.WxaAudioDataSource", "[readAt]bytes is null");
    return -1;
  }
  
  public boolean a()
  {
    return this.a != null;
  }
  
  public void b()
  {
    o.d("MicroMsg.WxaAudioDataSource", "open");
    if (this.a == null) {
      this.a = a(this.b, this.c);
    }
    this.d = 0L;
    a locala = this.a;
    if (locala != null) {
      locala.a(0);
    }
  }
  
  public long c()
  {
    a locala = this.a;
    if (locala == null)
    {
      o.b("MicroMsg.WxaAudioDataSource", "[getSize] inputStream is null");
      return 0L;
    }
    return locala.a();
  }
  
  public void close()
  {
    a locala = this.a;
    if (locala != null)
    {
      o.d("MicroMsg.WxaAudioDataSource", "close");
      locala.close();
      this.a = null;
    }
  }
  
  /* Error */
  public int d()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 20	com/tencent/luggage/wxa/nq/d:a	Lcom/tencent/luggage/util/a;
    //   4: ifnonnull +19 -> 23
    //   7: aload_0
    //   8: aload_0
    //   9: aload_0
    //   10: getfield 22	com/tencent/luggage/wxa/nq/d:b	Ljava/lang/String;
    //   13: aload_0
    //   14: getfield 24	com/tencent/luggage/wxa/nq/d:c	Ljava/lang/String;
    //   17: invokespecial 27	com/tencent/luggage/wxa/nq/d:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/luggage/util/a;
    //   20: putfield 20	com/tencent/luggage/wxa/nq/d:a	Lcom/tencent/luggage/util/a;
    //   23: aload_0
    //   24: getfield 20	com/tencent/luggage/wxa/nq/d:a	Lcom/tencent/luggage/util/a;
    //   27: ifnonnull +12 -> 39
    //   30: ldc 41
    //   32: ldc 132
    //   34: invokestatic 47	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: iconst_0
    //   38: ireturn
    //   39: aload_0
    //   40: getfield 22	com/tencent/luggage/wxa/nq/d:b	Ljava/lang/String;
    //   43: invokevirtual 138	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   46: ldc 140
    //   48: invokevirtual 143	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   51: ifeq +12 -> 63
    //   54: ldc 41
    //   56: ldc 145
    //   58: invokestatic 147	com/tencent/luggage/wxa/qz/o:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: iconst_2
    //   62: ireturn
    //   63: aload_0
    //   64: getfield 22	com/tencent/luggage/wxa/nq/d:b	Ljava/lang/String;
    //   67: invokevirtual 138	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   70: ldc 149
    //   72: invokevirtual 153	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   75: ifeq +12 -> 87
    //   78: ldc 41
    //   80: ldc 155
    //   82: invokestatic 147	com/tencent/luggage/wxa/qz/o:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: iconst_3
    //   86: ireturn
    //   87: aload_0
    //   88: getfield 22	com/tencent/luggage/wxa/nq/d:b	Ljava/lang/String;
    //   91: invokevirtual 138	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   94: ldc 157
    //   96: invokevirtual 153	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   99: ifeq +12 -> 111
    //   102: ldc 41
    //   104: ldc 159
    //   106: invokestatic 147	com/tencent/luggage/wxa/qz/o:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   109: iconst_4
    //   110: ireturn
    //   111: aconst_null
    //   112: astore_1
    //   113: bipush 64
    //   115: newarray byte
    //   117: astore_2
    //   118: aload_0
    //   119: getfield 20	com/tencent/luggage/wxa/nq/d:a	Lcom/tencent/luggage/util/a;
    //   122: iconst_0
    //   123: invokevirtual 109	com/tencent/luggage/util/a:a	(I)V
    //   126: aload_0
    //   127: getfield 20	com/tencent/luggage/wxa/nq/d:a	Lcom/tencent/luggage/util/a;
    //   130: aload_2
    //   131: invokevirtual 162	com/tencent/luggage/util/a:read	([B)I
    //   134: pop
    //   135: new 134	java/lang/String
    //   138: dup
    //   139: aload_2
    //   140: invokespecial 165	java/lang/String:<init>	([B)V
    //   143: astore_2
    //   144: aload_0
    //   145: getfield 20	com/tencent/luggage/wxa/nq/d:a	Lcom/tencent/luggage/util/a;
    //   148: iconst_0
    //   149: invokevirtual 109	com/tencent/luggage/util/a:a	(I)V
    //   152: aload_2
    //   153: astore_1
    //   154: goto +31 -> 185
    //   157: astore_1
    //   158: goto +51 -> 209
    //   161: astore_2
    //   162: ldc 41
    //   164: ldc 167
    //   166: iconst_1
    //   167: anewarray 4	java/lang/Object
    //   170: dup
    //   171: iconst_0
    //   172: aload_2
    //   173: aastore
    //   174: invokestatic 78	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   177: aload_0
    //   178: getfield 20	com/tencent/luggage/wxa/nq/d:a	Lcom/tencent/luggage/util/a;
    //   181: iconst_0
    //   182: invokevirtual 109	com/tencent/luggage/util/a:a	(I)V
    //   185: aload_1
    //   186: ifnull +21 -> 207
    //   189: aload_1
    //   190: ldc 169
    //   192: invokevirtual 153	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   195: ifeq +12 -> 207
    //   198: ldc 41
    //   200: ldc 171
    //   202: invokestatic 147	com/tencent/luggage/wxa/qz/o:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   205: iconst_1
    //   206: ireturn
    //   207: iconst_0
    //   208: ireturn
    //   209: aload_0
    //   210: getfield 20	com/tencent/luggage/wxa/nq/d:a	Lcom/tencent/luggage/util/a;
    //   213: iconst_0
    //   214: invokevirtual 109	com/tencent/luggage/util/a:a	(I)V
    //   217: aload_1
    //   218: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	this	d
    //   112	42	1	localObject1	Object
    //   157	61	1	localObject2	Object
    //   117	36	2	localObject3	Object
    //   161	12	2	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   113	144	157	finally
    //   162	177	157	finally
    //   113	144	161	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nq.d
 * JD-Core Version:    0.7.0.1
 */