package com.tencent.map.sdk.a;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class av
{
  private static String a = "info.3g.qq.com";
  
  public static boolean a()
  {
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    boolean[] arrayOfBoolean = new boolean[1];
    arrayOfBoolean[0] = false;
    as.a.a().a.execute(new aw(arrayOfBoolean, localCountDownLatch));
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
  private static boolean a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_2
    //   5: new 61	java/net/Socket
    //   8: dup
    //   9: invokespecial 63	java/net/Socket:<init>	()V
    //   12: astore_3
    //   13: aload_3
    //   14: new 65	java/net/InetSocketAddress
    //   17: dup
    //   18: aload_0
    //   19: bipush 80
    //   21: invokespecial 68	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   24: sipush 5000
    //   27: invokevirtual 72	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   30: aload_3
    //   31: invokevirtual 75	java/net/Socket:isConnected	()Z
    //   34: istore_1
    //   35: aload_3
    //   36: invokevirtual 78	java/net/Socket:close	()V
    //   39: iload_1
    //   40: ireturn
    //   41: astore_0
    //   42: aload_0
    //   43: invokevirtual 79	java/lang/Throwable:printStackTrace	()V
    //   46: iload_1
    //   47: ireturn
    //   48: astore_0
    //   49: goto +45 -> 94
    //   52: astore_2
    //   53: aload_3
    //   54: astore_0
    //   55: aload_2
    //   56: astore_3
    //   57: goto +13 -> 70
    //   60: astore_0
    //   61: aload_2
    //   62: astore_3
    //   63: goto +31 -> 94
    //   66: astore_3
    //   67: aload 4
    //   69: astore_0
    //   70: aload_0
    //   71: astore_2
    //   72: aload_3
    //   73: invokevirtual 79	java/lang/Throwable:printStackTrace	()V
    //   76: aload_0
    //   77: ifnull +15 -> 92
    //   80: aload_0
    //   81: invokevirtual 78	java/net/Socket:close	()V
    //   84: goto +8 -> 92
    //   87: astore_0
    //   88: aload_0
    //   89: invokevirtual 79	java/lang/Throwable:printStackTrace	()V
    //   92: iconst_0
    //   93: ireturn
    //   94: aload_3
    //   95: ifnull +15 -> 110
    //   98: aload_3
    //   99: invokevirtual 78	java/net/Socket:close	()V
    //   102: goto +8 -> 110
    //   105: astore_2
    //   106: aload_2
    //   107: invokevirtual 79	java/lang/Throwable:printStackTrace	()V
    //   110: aload_0
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	paramString	String
    //   34	13	1	bool	boolean
    //   4	1	2	localObject1	Object
    //   52	10	2	localThrowable1	java.lang.Throwable
    //   71	1	2	str	String
    //   105	2	2	localThrowable2	java.lang.Throwable
    //   12	51	3	localObject2	Object
    //   66	33	3	localThrowable3	java.lang.Throwable
    //   1	67	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   35	39	41	java/lang/Throwable
    //   13	35	48	finally
    //   13	35	52	java/lang/Throwable
    //   5	13	60	finally
    //   72	76	60	finally
    //   5	13	66	java/lang/Throwable
    //   80	84	87	java/lang/Throwable
    //   98	102	105	java/lang/Throwable
  }
  
  public static boolean b()
  {
    return a(a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.av
 * JD-Core Version:    0.7.0.1
 */