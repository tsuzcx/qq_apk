package com.tencent.luggage.wxa.z;

import com.tencent.luggage.wxa.l.d;
import com.tencent.luggage.wxa.l.f;

final class e$b
{
  private final d[] a;
  private final f b;
  private d c;
  
  public e$b(d[] paramArrayOfd, f paramf)
  {
    this.a = paramArrayOfd;
    this.b = paramf;
  }
  
  /* Error */
  public d a(com.tencent.luggage.wxa.l.e parame, android.net.Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 25	com/tencent/luggage/wxa/z/e$b:c	Lcom/tencent/luggage/wxa/l/d;
    //   4: astore 5
    //   6: aload 5
    //   8: ifnull +6 -> 14
    //   11: aload 5
    //   13: areturn
    //   14: aload_0
    //   15: getfield 17	com/tencent/luggage/wxa/z/e$b:a	[Lcom/tencent/luggage/wxa/l/d;
    //   18: astore 5
    //   20: aload 5
    //   22: arraylength
    //   23: istore 4
    //   25: iconst_0
    //   26: istore_3
    //   27: iload_3
    //   28: iload 4
    //   30: if_icmpge +57 -> 87
    //   33: aload 5
    //   35: iload_3
    //   36: aaload
    //   37: astore 6
    //   39: aload 6
    //   41: aload_1
    //   42: invokeinterface 30 2 0
    //   47: ifeq +27 -> 74
    //   50: aload_0
    //   51: aload 6
    //   53: putfield 25	com/tencent/luggage/wxa/z/e$b:c	Lcom/tencent/luggage/wxa/l/d;
    //   56: aload_1
    //   57: invokeinterface 34 1 0
    //   62: goto +25 -> 87
    //   65: astore_2
    //   66: aload_1
    //   67: invokeinterface 34 1 0
    //   72: aload_2
    //   73: athrow
    //   74: aload_1
    //   75: invokeinterface 34 1 0
    //   80: iload_3
    //   81: iconst_1
    //   82: iadd
    //   83: istore_3
    //   84: goto -57 -> 27
    //   87: aload_0
    //   88: getfield 25	com/tencent/luggage/wxa/z/e$b:c	Lcom/tencent/luggage/wxa/l/d;
    //   91: astore_1
    //   92: aload_1
    //   93: ifnull +18 -> 111
    //   96: aload_1
    //   97: aload_0
    //   98: getfield 19	com/tencent/luggage/wxa/z/e$b:b	Lcom/tencent/luggage/wxa/l/f;
    //   101: invokeinterface 37 2 0
    //   106: aload_0
    //   107: getfield 25	com/tencent/luggage/wxa/z/e$b:c	Lcom/tencent/luggage/wxa/l/d;
    //   110: areturn
    //   111: new 39	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   118: astore_1
    //   119: aload_1
    //   120: ldc 42
    //   122: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload_1
    //   127: aload_0
    //   128: getfield 17	com/tencent/luggage/wxa/z/e$b:a	[Lcom/tencent/luggage/wxa/l/d;
    //   131: invokestatic 51	com/tencent/luggage/wxa/ao/x:a	([Ljava/lang/Object;)Ljava/lang/String;
    //   134: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload_1
    //   139: ldc 53
    //   141: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: new 55	com/tencent/luggage/wxa/z/p
    //   148: dup
    //   149: aload_1
    //   150: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: aload_2
    //   154: invokespecial 62	com/tencent/luggage/wxa/z/p:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   157: astore_1
    //   158: goto +5 -> 163
    //   161: aload_1
    //   162: athrow
    //   163: goto -2 -> 161
    //   166: astore 6
    //   168: goto -94 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	b
    //   0	171	1	parame	com.tencent.luggage.wxa.l.e
    //   0	171	2	paramUri	android.net.Uri
    //   26	58	3	i	int
    //   23	8	4	j	int
    //   4	30	5	localObject1	Object
    //   37	15	6	localObject2	Object
    //   166	1	6	localEOFException	java.io.EOFException
    // Exception table:
    //   from	to	target	type
    //   39	56	65	finally
    //   39	56	166	java/io/EOFException
  }
  
  public void a()
  {
    d locald = this.c;
    if (locald != null)
    {
      locald.c();
      this.c = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.z.e.b
 * JD-Core Version:    0.7.0.1
 */