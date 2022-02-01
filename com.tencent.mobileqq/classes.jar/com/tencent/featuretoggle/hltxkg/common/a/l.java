package com.tencent.featuretoggle.hltxkg.common.a;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class l
{
  private static String a = "info.3g.qq.com";
  
  public static boolean a()
  {
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    boolean[] arrayOfBoolean = new boolean[1];
    arrayOfBoolean[0] = false;
    i.a.a().b().execute(new m(arrayOfBoolean, localCountDownLatch));
    try
    {
      localCountDownLatch.await(5L, TimeUnit.SECONDS);
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
    return arrayOfBoolean[0];
  }
  
  /* Error */
  private static boolean a(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 4
    //   6: new 62	java/net/Socket
    //   9: dup
    //   10: invokespecial 64	java/net/Socket:<init>	()V
    //   13: astore 5
    //   15: aload 5
    //   17: new 66	java/net/InetSocketAddress
    //   20: dup
    //   21: aload_0
    //   22: bipush 80
    //   24: invokespecial 69	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   27: sipush 5000
    //   30: invokevirtual 73	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   33: aload 5
    //   35: invokevirtual 76	java/net/Socket:isConnected	()Z
    //   38: istore_3
    //   39: aload 5
    //   41: invokevirtual 79	java/net/Socket:close	()V
    //   44: iload_3
    //   45: ireturn
    //   46: astore_0
    //   47: aload_0
    //   48: invokevirtual 80	java/lang/Throwable:printStackTrace	()V
    //   51: iload_3
    //   52: ireturn
    //   53: astore_0
    //   54: aload 5
    //   56: astore 4
    //   58: goto +50 -> 108
    //   61: astore 4
    //   63: aload 5
    //   65: astore_0
    //   66: aload 4
    //   68: astore 5
    //   70: goto +12 -> 82
    //   73: astore_0
    //   74: goto +34 -> 108
    //   77: astore 5
    //   79: aload 6
    //   81: astore_0
    //   82: aload_0
    //   83: astore 4
    //   85: aload 5
    //   87: invokevirtual 80	java/lang/Throwable:printStackTrace	()V
    //   90: aload_0
    //   91: ifnull +15 -> 106
    //   94: aload_0
    //   95: invokevirtual 79	java/net/Socket:close	()V
    //   98: goto +8 -> 106
    //   101: astore_0
    //   102: aload_0
    //   103: invokevirtual 80	java/lang/Throwable:printStackTrace	()V
    //   106: iconst_0
    //   107: ireturn
    //   108: aload 4
    //   110: ifnull +18 -> 128
    //   113: aload 4
    //   115: invokevirtual 79	java/net/Socket:close	()V
    //   118: goto +10 -> 128
    //   121: astore 4
    //   123: aload 4
    //   125: invokevirtual 80	java/lang/Throwable:printStackTrace	()V
    //   128: aload_0
    //   129: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	paramString	String
    //   0	130	1	paramInt1	int
    //   0	130	2	paramInt2	int
    //   38	14	3	bool	boolean
    //   4	53	4	localObject1	Object
    //   61	6	4	localThrowable1	java.lang.Throwable
    //   83	31	4	str	String
    //   121	3	4	localThrowable2	java.lang.Throwable
    //   13	56	5	localObject2	Object
    //   77	9	5	localThrowable3	java.lang.Throwable
    //   1	79	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   39	44	46	java/lang/Throwable
    //   15	39	53	finally
    //   15	39	61	java/lang/Throwable
    //   6	15	73	finally
    //   85	90	73	finally
    //   6	15	77	java/lang/Throwable
    //   94	98	101	java/lang/Throwable
    //   113	118	121	java/lang/Throwable
  }
  
  public static boolean b()
  {
    return a(a, 80, 5000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.a.l
 * JD-Core Version:    0.7.0.1
 */