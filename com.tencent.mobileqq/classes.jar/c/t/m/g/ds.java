package c.t.m.g;

import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import java.util.concurrent.ConcurrentHashMap;

public final class ds
{
  private static ConcurrentHashMap<String, HandlerThread> a = new ConcurrentHashMap();
  private static ConcurrentHashMap<String, Integer> b = new ConcurrentHashMap();
  private static ConcurrentHashMap<String, Long> c = new ConcurrentHashMap();
  
  public static HandlerThread a(@NonNull String paramString)
  {
    try
    {
      paramString = b(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void a(String paramString, long paramLong)
  {
    do
    {
      try
      {
        boolean bool = b.containsKey(paramString);
        if (!bool) {}
        int i;
        for (;;)
        {
          return;
          i = ((Integer)b.get(paramString)).intValue() - 1;
          if (i != 0) {
            break;
          }
          b.remove(paramString);
          HandlerThread localHandlerThread = (HandlerThread)a.remove(paramString);
          l = paramLong;
          if (c.containsKey(paramString)) {
            l = Math.max(paramLong, ((Long)c.remove(paramString)).longValue() - System.currentTimeMillis());
          }
          dt.a(localHandlerThread, null, l);
        }
        b.put(paramString, Integer.valueOf(i));
      }
      finally {}
    } while (paramLong == 0L);
    if (c.containsKey(paramString)) {}
    for (long l = ((Long)c.get(paramString)).longValue();; l = 0L)
    {
      c.put(paramString, Long.valueOf(Math.max(System.currentTimeMillis() + paramLong, l)));
      break;
    }
  }
  
  public static void a(String paramString, Runnable paramRunnable)
  {
    try
    {
      Handler localHandler = new Handler(a(paramString).getLooper());
      if (co.a(localHandler)) {
        localHandler.postDelayed(paramRunnable, 0L);
      }
      a(paramString, 0L);
      return;
    }
    finally {}
  }
  
  /* Error */
  private static HandlerThread b(@NonNull String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 20	c/t/m/g/ds:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   6: aload_0
    //   7: invokevirtual 39	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 50	android/os/HandlerThread
    //   13: astore_1
    //   14: aload_1
    //   15: ifnonnull +45 -> 60
    //   18: new 50	android/os/HandlerThread
    //   21: dup
    //   22: aload_0
    //   23: iconst_0
    //   24: invokespecial 109	android/os/HandlerThread:<init>	(Ljava/lang/String;I)V
    //   27: astore_1
    //   28: aload_1
    //   29: invokevirtual 112	android/os/HandlerThread:start	()V
    //   32: getstatic 20	c/t/m/g/ds:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   35: aload_0
    //   36: aload_1
    //   37: invokevirtual 80	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   40: pop
    //   41: getstatic 22	c/t/m/g/ds:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   44: aload_0
    //   45: iconst_1
    //   46: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   49: invokevirtual 80	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   52: pop
    //   53: aload_1
    //   54: astore_0
    //   55: ldc 2
    //   57: monitorexit
    //   58: aload_0
    //   59: areturn
    //   60: getstatic 22	c/t/m/g/ds:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   63: aload_0
    //   64: getstatic 22	c/t/m/g/ds:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   67: aload_0
    //   68: invokevirtual 39	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   71: checkcast 41	java/lang/Integer
    //   74: invokevirtual 45	java/lang/Integer:intValue	()I
    //   77: iconst_1
    //   78: iadd
    //   79: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   82: invokevirtual 80	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   85: pop
    //   86: aload_1
    //   87: astore_0
    //   88: goto -33 -> 55
    //   91: astore_0
    //   92: ldc 2
    //   94: monitorexit
    //   95: aload_0
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	paramString	String
    //   13	74	1	localHandlerThread	HandlerThread
    // Exception table:
    //   from	to	target	type
    //   3	14	91	finally
    //   18	53	91	finally
    //   60	86	91	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     c.t.m.g.ds
 * JD-Core Version:    0.7.0.1
 */