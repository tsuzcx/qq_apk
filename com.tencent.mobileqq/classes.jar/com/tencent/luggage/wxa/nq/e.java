package com.tencent.luggage.wxa.nq;

import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.p;
import com.tencent.mm.plugin.appbrand.appcache.v;
import com.tencent.mm.plugin.appbrand.appcache.v.a;
import java.io.RandomAccessFile;

public class e
  implements com.tencent.luggage.wxa.if.e
{
  private static p<String, Integer> b = new p(50);
  private static p<String, Integer> c = new p(50);
  private static p<String, Integer> d = new p(50);
  public RandomAccessFile a;
  private String e;
  private String f;
  private int g = -1;
  private int h = -1;
  private long i;
  
  public e(String paramString1, String paramString2)
  {
    this.e = paramString1;
    this.f = paramString2;
    this.a = b(paramString1, paramString2);
    a(paramString1, paramString2);
  }
  
  private void a(String paramString1, String paramString2)
  {
    if ((b.d(paramString1)) && (c.d(paramString1)))
    {
      this.g = ((Integer)b.b(paramString1)).intValue();
      this.h = ((Integer)c.b(paramString1)).intValue();
      return;
    }
    if (af.c(paramString2))
    {
      o.b("MicroMsg.WxaAudioDataSourceBelow19", "pkgpath is null, return");
      return;
    }
    paramString2 = new v(paramString2);
    if (!paramString2.c())
    {
      paramString2.close();
      o.b("MicroMsg.WxaAudioDataSourceBelow19", "pkg invalid");
      return;
    }
    if (!paramString2.e())
    {
      paramString2.close();
      o.b("MicroMsg.WxaAudioDataSourceBelow19", "pkg readInfo failed");
      return;
    }
    v.a locala = paramString2.b(paramString1);
    if (locala == null)
    {
      paramString2.close();
      o.b("MicroMsg.WxaAudioDataSourceBelow19", "info is null, err");
      return;
    }
    if ((locala.d > 0) && (locala.c > 0))
    {
      this.g = locala.d;
      this.h = locala.c;
      b.a(paramString1, Integer.valueOf(this.g));
      c.a(paramString1, Integer.valueOf(this.h));
      paramString2.close();
      return;
    }
    paramString2.close();
    o.b("MicroMsg.WxaAudioDataSourceBelow19", "info.resLength or info.fileOffset, err");
  }
  
  /* Error */
  private RandomAccessFile b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 71	com/tencent/luggage/wxa/qz/af:c	(Ljava/lang/String;)Z
    //   4: ifeq +12 -> 16
    //   7: ldc 73
    //   9: ldc 75
    //   11: invokestatic 79	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: aconst_null
    //   15: areturn
    //   16: ldc 73
    //   18: ldc 122
    //   20: iconst_3
    //   21: anewarray 4	java/lang/Object
    //   24: dup
    //   25: iconst_0
    //   26: aload_1
    //   27: aastore
    //   28: dup
    //   29: iconst_1
    //   30: aload_0
    //   31: getfield 41	com/tencent/luggage/wxa/nq/e:g	I
    //   34: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   37: aastore
    //   38: dup
    //   39: iconst_2
    //   40: aload_0
    //   41: getfield 43	com/tencent/luggage/wxa/nq/e:h	I
    //   44: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   47: aastore
    //   48: invokestatic 125	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   51: new 127	com/tencent/luggage/wxa/rt/i
    //   54: dup
    //   55: aload_2
    //   56: invokespecial 128	com/tencent/luggage/wxa/rt/i:<init>	(Ljava/lang/String;)V
    //   59: invokevirtual 131	com/tencent/luggage/wxa/rt/i:j	()Z
    //   62: ifne +20 -> 82
    //   65: ldc 73
    //   67: ldc 133
    //   69: iconst_1
    //   70: anewarray 4	java/lang/Object
    //   73: dup
    //   74: iconst_0
    //   75: aload_2
    //   76: aastore
    //   77: invokestatic 135	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   80: aconst_null
    //   81: areturn
    //   82: aload_2
    //   83: iconst_0
    //   84: invokestatic 140	com/tencent/luggage/wxa/rt/k:b	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   87: astore_1
    //   88: ldc 73
    //   90: ldc 142
    //   92: iconst_1
    //   93: anewarray 4	java/lang/Object
    //   96: dup
    //   97: iconst_0
    //   98: aload_1
    //   99: invokevirtual 148	java/io/RandomAccessFile:length	()J
    //   102: invokestatic 153	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   105: aastore
    //   106: invokestatic 155	com/tencent/luggage/wxa/qz/o:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   109: aload_1
    //   110: areturn
    //   111: astore_2
    //   112: goto +6 -> 118
    //   115: astore_2
    //   116: aconst_null
    //   117: astore_1
    //   118: ldc 73
    //   120: aload_2
    //   121: ldc 157
    //   123: iconst_0
    //   124: anewarray 4	java/lang/Object
    //   127: invokestatic 160	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   130: aload_1
    //   131: ifnull +7 -> 138
    //   134: aload_1
    //   135: invokevirtual 161	java/io/RandomAccessFile:close	()V
    //   138: aconst_null
    //   139: areturn
    //   140: astore_1
    //   141: ldc 73
    //   143: aload_1
    //   144: ldc 157
    //   146: iconst_0
    //   147: anewarray 4	java/lang/Object
    //   150: invokestatic 160	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   153: aconst_null
    //   154: areturn
    //   155: astore_1
    //   156: aconst_null
    //   157: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	e
    //   0	158	1	paramString1	String
    //   0	158	2	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   88	109	111	java/io/IOException
    //   51	80	115	java/io/IOException
    //   82	88	115	java/io/IOException
    //   51	80	140	java/io/FileNotFoundException
    //   82	88	140	java/io/FileNotFoundException
    //   88	109	140	java/io/FileNotFoundException
    //   134	138	155	java/io/IOException
  }
  
  public int a(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    RandomAccessFile localRandomAccessFile = this.a;
    if (localRandomAccessFile == null)
    {
      o.b("MicroMsg.WxaAudioDataSourceBelow19", "[readAt]randomAccessFile is null");
      return -1;
    }
    if (this.i != paramLong)
    {
      localRandomAccessFile.seek(this.h + paramLong);
      this.i = paramLong;
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      if ((paramLong >= 0L) && (paramInt1 >= 0) && (paramInt2 > 0))
      {
        if ((paramArrayOfByte != null) && (paramInt1 + paramInt2 > paramArrayOfByte.length))
        {
          o.b("MicroMsg.WxaAudioDataSourceBelow19", "offset:%d, size:%d, bytes.length:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramArrayOfByte.length) });
          return -1;
        }
        int k = this.g;
        if (paramLong >= k)
        {
          o.b("MicroMsg.WxaAudioDataSourceBelow19", "position:%d resLength:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(this.g) });
          return -1;
        }
        int j = paramInt2;
        if (paramInt2 + paramLong >= k)
        {
          o.b("MicroMsg.WxaAudioDataSourceBelow19", "position:%d, size:%d, resLength:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(this.g) });
          j = (int)(this.g - paramLong);
        }
        paramInt1 = this.a.read(paramArrayOfByte, paramInt1, j);
        if (paramInt1 >= 0)
        {
          this.i += paramInt1;
          return paramInt1;
        }
        o.b("MicroMsg.WxaAudioDataSourceBelow19", "read:%d err", new Object[] { Integer.valueOf(paramInt1) });
        return paramInt1;
      }
      o.b("MicroMsg.WxaAudioDataSourceBelow19", "position:%d, offset:%d, size:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      return -1;
    }
    o.b("MicroMsg.WxaAudioDataSourceBelow19", "[readAt]bytes is null");
    return -1;
  }
  
  public boolean a()
  {
    return (this.a != null) || (this.g == -1) || (this.h == -1);
  }
  
  public void b()
  {
    o.d("MicroMsg.WxaAudioDataSourceBelow19", "open %d", new Object[] { Integer.valueOf(hashCode()) });
    if (this.a == null) {
      this.a = b(this.e, this.f);
    }
    this.i = 0L;
    RandomAccessFile localRandomAccessFile = this.a;
    if (localRandomAccessFile != null) {
      localRandomAccessFile.seek(this.h);
    }
  }
  
  public long c()
  {
    if (this.a == null)
    {
      o.b("MicroMsg.WxaAudioDataSourceBelow19", "[getSize] randomAccessFile is null");
      return 0L;
    }
    return this.g;
  }
  
  public void close()
  {
    if (this.a != null)
    {
      o.d("MicroMsg.WxaAudioDataSourceBelow19", "close %d", new Object[] { Integer.valueOf(hashCode()) });
      this.a.close();
      this.a = null;
    }
  }
  
  /* Error */
  public int d()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 52	com/tencent/luggage/wxa/nq/e:a	Ljava/io/RandomAccessFile;
    //   4: ifnonnull +19 -> 23
    //   7: aload_0
    //   8: aload_0
    //   9: aload_0
    //   10: getfield 45	com/tencent/luggage/wxa/nq/e:e	Ljava/lang/String;
    //   13: aload_0
    //   14: getfield 47	com/tencent/luggage/wxa/nq/e:f	Ljava/lang/String;
    //   17: invokespecial 50	com/tencent/luggage/wxa/nq/e:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/RandomAccessFile;
    //   20: putfield 52	com/tencent/luggage/wxa/nq/e:a	Ljava/io/RandomAccessFile;
    //   23: getstatic 35	com/tencent/luggage/wxa/nq/e:d	Lcom/tencent/luggage/wxa/qz/p;
    //   26: aload_0
    //   27: getfield 45	com/tencent/luggage/wxa/nq/e:e	Ljava/lang/String;
    //   30: invokevirtual 57	com/tencent/luggage/wxa/qz/p:d	(Ljava/lang/Object;)Z
    //   33: ifeq +20 -> 53
    //   36: getstatic 35	com/tencent/luggage/wxa/nq/e:d	Lcom/tencent/luggage/wxa/qz/p;
    //   39: aload_0
    //   40: getfield 45	com/tencent/luggage/wxa/nq/e:e	Ljava/lang/String;
    //   43: invokevirtual 60	com/tencent/luggage/wxa/qz/p:b	(Ljava/lang/Object;)Ljava/lang/Object;
    //   46: checkcast 62	java/lang/Integer
    //   49: invokevirtual 66	java/lang/Integer:intValue	()I
    //   52: ireturn
    //   53: aload_0
    //   54: getfield 52	com/tencent/luggage/wxa/nq/e:a	Ljava/io/RandomAccessFile;
    //   57: ifnonnull +12 -> 69
    //   60: ldc 73
    //   62: ldc 199
    //   64: invokestatic 79	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: iconst_0
    //   68: ireturn
    //   69: aload_0
    //   70: getfield 45	com/tencent/luggage/wxa/nq/e:e	Ljava/lang/String;
    //   73: invokevirtual 205	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   76: ldc 207
    //   78: invokevirtual 210	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   81: ifeq +12 -> 93
    //   84: ldc 73
    //   86: ldc 212
    //   88: invokestatic 214	com/tencent/luggage/wxa/qz/o:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: iconst_2
    //   92: ireturn
    //   93: aload_0
    //   94: getfield 45	com/tencent/luggage/wxa/nq/e:e	Ljava/lang/String;
    //   97: invokevirtual 205	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   100: ldc 216
    //   102: invokevirtual 220	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   105: ifeq +12 -> 117
    //   108: ldc 73
    //   110: ldc 222
    //   112: invokestatic 214	com/tencent/luggage/wxa/qz/o:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: iconst_3
    //   116: ireturn
    //   117: aload_0
    //   118: getfield 45	com/tencent/luggage/wxa/nq/e:e	Ljava/lang/String;
    //   121: invokevirtual 205	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   124: ldc 224
    //   126: invokevirtual 220	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   129: ifeq +12 -> 141
    //   132: ldc 73
    //   134: ldc 226
    //   136: invokestatic 214	com/tencent/luggage/wxa/qz/o:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: iconst_4
    //   140: ireturn
    //   141: aconst_null
    //   142: astore_1
    //   143: bipush 64
    //   145: newarray byte
    //   147: astore_2
    //   148: aload_0
    //   149: getfield 52	com/tencent/luggage/wxa/nq/e:a	Ljava/io/RandomAccessFile;
    //   152: aload_0
    //   153: getfield 43	com/tencent/luggage/wxa/nq/e:h	I
    //   156: i2l
    //   157: invokevirtual 170	java/io/RandomAccessFile:seek	(J)V
    //   160: aload_0
    //   161: getfield 52	com/tencent/luggage/wxa/nq/e:a	Ljava/io/RandomAccessFile;
    //   164: aload_2
    //   165: invokevirtual 229	java/io/RandomAccessFile:read	([B)I
    //   168: pop
    //   169: new 201	java/lang/String
    //   172: dup
    //   173: aload_2
    //   174: invokespecial 232	java/lang/String:<init>	([B)V
    //   177: astore_2
    //   178: aload_0
    //   179: getfield 52	com/tencent/luggage/wxa/nq/e:a	Ljava/io/RandomAccessFile;
    //   182: aload_0
    //   183: getfield 43	com/tencent/luggage/wxa/nq/e:h	I
    //   186: i2l
    //   187: invokevirtual 170	java/io/RandomAccessFile:seek	(J)V
    //   190: aload_2
    //   191: astore_1
    //   192: goto +35 -> 227
    //   195: astore_1
    //   196: goto +70 -> 266
    //   199: astore_2
    //   200: ldc 73
    //   202: ldc 234
    //   204: iconst_1
    //   205: anewarray 4	java/lang/Object
    //   208: dup
    //   209: iconst_0
    //   210: aload_2
    //   211: aastore
    //   212: invokestatic 135	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   215: aload_0
    //   216: getfield 52	com/tencent/luggage/wxa/nq/e:a	Ljava/io/RandomAccessFile;
    //   219: aload_0
    //   220: getfield 43	com/tencent/luggage/wxa/nq/e:h	I
    //   223: i2l
    //   224: invokevirtual 170	java/io/RandomAccessFile:seek	(J)V
    //   227: aload_1
    //   228: ifnull +36 -> 264
    //   231: aload_1
    //   232: ldc 236
    //   234: invokevirtual 220	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   237: ifeq +27 -> 264
    //   240: ldc 73
    //   242: ldc 238
    //   244: invokestatic 214	com/tencent/luggage/wxa/qz/o:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   247: getstatic 35	com/tencent/luggage/wxa/nq/e:d	Lcom/tencent/luggage/wxa/qz/p;
    //   250: aload_0
    //   251: getfield 45	com/tencent/luggage/wxa/nq/e:e	Ljava/lang/String;
    //   254: iconst_1
    //   255: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   258: invokevirtual 114	com/tencent/luggage/wxa/qz/p:a	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   261: pop
    //   262: iconst_1
    //   263: ireturn
    //   264: iconst_0
    //   265: ireturn
    //   266: aload_0
    //   267: getfield 52	com/tencent/luggage/wxa/nq/e:a	Ljava/io/RandomAccessFile;
    //   270: aload_0
    //   271: getfield 43	com/tencent/luggage/wxa/nq/e:h	I
    //   274: i2l
    //   275: invokevirtual 170	java/io/RandomAccessFile:seek	(J)V
    //   278: aload_1
    //   279: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	this	e
    //   142	50	1	localObject1	Object
    //   195	84	1	localObject2	Object
    //   147	44	2	localObject3	Object
    //   199	12	2	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   143	178	195	finally
    //   200	215	195	finally
    //   143	178	199	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nq.e
 * JD-Core Version:    0.7.0.1
 */