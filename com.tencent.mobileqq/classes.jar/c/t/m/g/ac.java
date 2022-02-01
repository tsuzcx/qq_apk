package c.t.m.g;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ac
{
  private static String a = "info.3g.qq.com";
  
  public static boolean a()
  {
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    boolean[] arrayOfBoolean = new boolean[1];
    arrayOfBoolean[0] = false;
    aa.a.a().a.execute(new ad(arrayOfBoolean, localCountDownLatch));
    try
    {
      localCountDownLatch.await(5L, TimeUnit.SECONDS);
      return arrayOfBoolean[0];
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
  
  /* Error */
  private static boolean a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_1
    //   4: new 63	java/net/Socket
    //   7: dup
    //   8: invokespecial 65	java/net/Socket:<init>	()V
    //   11: astore 5
    //   13: aload 5
    //   15: astore 4
    //   17: aload 5
    //   19: new 67	java/net/InetSocketAddress
    //   22: dup
    //   23: aload_0
    //   24: bipush 80
    //   26: invokespecial 70	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   29: sipush 5000
    //   32: invokevirtual 74	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   35: aload 5
    //   37: astore 4
    //   39: aload 5
    //   41: invokevirtual 77	java/net/Socket:isConnected	()Z
    //   44: istore_3
    //   45: iload_3
    //   46: ifeq +5 -> 51
    //   49: iconst_1
    //   50: istore_1
    //   51: aload 5
    //   53: invokevirtual 80	java/net/Socket:close	()V
    //   56: iload_1
    //   57: ireturn
    //   58: astore_0
    //   59: aload_0
    //   60: invokevirtual 81	java/lang/Throwable:printStackTrace	()V
    //   63: iload_1
    //   64: ireturn
    //   65: astore 6
    //   67: aconst_null
    //   68: astore_0
    //   69: aload_0
    //   70: astore 4
    //   72: aload 6
    //   74: invokevirtual 81	java/lang/Throwable:printStackTrace	()V
    //   77: iload_2
    //   78: istore_1
    //   79: aload_0
    //   80: ifnull -24 -> 56
    //   83: aload_0
    //   84: invokevirtual 80	java/net/Socket:close	()V
    //   87: iconst_0
    //   88: ireturn
    //   89: astore_0
    //   90: aload_0
    //   91: invokevirtual 81	java/lang/Throwable:printStackTrace	()V
    //   94: iconst_0
    //   95: ireturn
    //   96: astore_0
    //   97: aconst_null
    //   98: astore 4
    //   100: aload 4
    //   102: ifnull +8 -> 110
    //   105: aload 4
    //   107: invokevirtual 80	java/net/Socket:close	()V
    //   110: aload_0
    //   111: athrow
    //   112: astore 4
    //   114: aload 4
    //   116: invokevirtual 81	java/lang/Throwable:printStackTrace	()V
    //   119: goto -9 -> 110
    //   122: astore_0
    //   123: goto -23 -> 100
    //   126: astore 6
    //   128: aload 5
    //   130: astore_0
    //   131: goto -62 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	paramString	String
    //   3	76	1	bool1	boolean
    //   1	77	2	bool2	boolean
    //   44	2	3	bool3	boolean
    //   15	91	4	localObject	Object
    //   112	3	4	localThrowable1	java.lang.Throwable
    //   11	118	5	localSocket	java.net.Socket
    //   65	8	6	localThrowable2	java.lang.Throwable
    //   126	1	6	localThrowable3	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   51	56	58	java/lang/Throwable
    //   4	13	65	java/lang/Throwable
    //   83	87	89	java/lang/Throwable
    //   4	13	96	finally
    //   105	110	112	java/lang/Throwable
    //   17	35	122	finally
    //   39	45	122	finally
    //   72	77	122	finally
    //   17	35	126	java/lang/Throwable
    //   39	45	126	java/lang/Throwable
  }
  
  public static boolean b()
  {
    return a(a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     c.t.m.g.ac
 * JD-Core Version:    0.7.0.1
 */