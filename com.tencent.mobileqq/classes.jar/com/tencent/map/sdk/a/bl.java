package com.tencent.map.sdk.a;

final class bl
  implements Runnable
{
  bl(bk parambk, be parambe, long paramLong) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: getfield 18	com/tencent/map/sdk/a/bl:a	Lcom/tencent/map/sdk/a/be;
    //   6: invokevirtual 32	com/tencent/map/sdk/a/be:a	()Lcom/tencent/map/sdk/a/bh;
    //   9: astore 4
    //   11: aload_0
    //   12: getfield 18	com/tencent/map/sdk/a/bl:a	Lcom/tencent/map/sdk/a/be;
    //   15: invokestatic 38	android/os/SystemClock:elapsedRealtime	()J
    //   18: aload_0
    //   19: getfield 20	com/tencent/map/sdk/a/bl:b	J
    //   22: lsub
    //   23: putfield 41	com/tencent/map/sdk/a/be:l	J
    //   26: aload_0
    //   27: getfield 18	com/tencent/map/sdk/a/bl:a	Lcom/tencent/map/sdk/a/be;
    //   30: iconst_0
    //   31: invokevirtual 44	com/tencent/map/sdk/a/be:a	(Z)V
    //   34: iload_3
    //   35: istore_2
    //   36: aload 4
    //   38: getfield 49	com/tencent/map/sdk/a/bh:a	I
    //   41: ifne +20 -> 61
    //   44: aload 4
    //   46: getfield 51	com/tencent/map/sdk/a/bh:c	I
    //   49: istore_1
    //   50: iload_3
    //   51: istore_2
    //   52: iload_1
    //   53: sipush 200
    //   56: if_icmpne +5 -> 61
    //   59: iconst_1
    //   60: istore_2
    //   61: aload_0
    //   62: getfield 16	com/tencent/map/sdk/a/bl:c	Lcom/tencent/map/sdk/a/bk;
    //   65: iload_2
    //   66: invokestatic 56	com/tencent/map/sdk/a/bk:a	(Lcom/tencent/map/sdk/a/bk;Z)Z
    //   69: pop
    //   70: return
    //   71: astore 4
    //   73: aload_0
    //   74: getfield 16	com/tencent/map/sdk/a/bl:c	Lcom/tencent/map/sdk/a/bk;
    //   77: iconst_0
    //   78: invokestatic 56	com/tencent/map/sdk/a/bk:a	(Lcom/tencent/map/sdk/a/bk;Z)Z
    //   81: pop
    //   82: aload 4
    //   84: athrow
    //   85: astore 4
    //   87: iload_3
    //   88: istore_2
    //   89: goto -28 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	bl
    //   49	8	1	i	int
    //   35	54	2	bool1	boolean
    //   1	87	3	bool2	boolean
    //   9	36	4	localbh	bh
    //   71	12	4	localObject	Object
    //   85	1	4	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   2	34	71	finally
    //   36	50	71	finally
    //   2	34	85	java/lang/Throwable
    //   36	50	85	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.bl
 * JD-Core Version:    0.7.0.1
 */