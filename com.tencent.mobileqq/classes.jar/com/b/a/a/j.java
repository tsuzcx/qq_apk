package com.b.a.a;

import com.b.a.n.a;
import java.util.LinkedHashMap;

public final class j
{
  private static j b;
  private LinkedHashMap<String, n.a> a = new LinkedHashMap();
  
  public static j a()
  {
    try
    {
      if (b == null) {
        b = new j();
      }
      j localj = b;
      return localj;
    }
    finally {}
  }
  
  /* Error */
  public final void a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 18	com/b/a/a/j:a	Ljava/util/LinkedHashMap;
    //   6: ifnonnull +14 -> 20
    //   9: aload_0
    //   10: new 15	java/util/LinkedHashMap
    //   13: dup
    //   14: invokespecial 16	java/util/LinkedHashMap:<init>	()V
    //   17: putfield 18	com/b/a/a/j:a	Ljava/util/LinkedHashMap;
    //   20: aload_0
    //   21: getfield 18	com/b/a/a/j:a	Ljava/util/LinkedHashMap;
    //   24: aload_1
    //   25: invokevirtual 29	java/util/LinkedHashMap:containsKey	(Ljava/lang/Object;)Z
    //   28: istore_3
    //   29: iload_3
    //   30: ifne +6 -> 36
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: aload_0
    //   37: getfield 18	com/b/a/a/j:a	Ljava/util/LinkedHashMap;
    //   40: aload_1
    //   41: invokevirtual 33	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   44: checkcast 35	com/b/a/n$a
    //   47: astore 4
    //   49: new 37	android/os/Handler
    //   52: dup
    //   53: invokestatic 43	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   56: invokespecial 46	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   59: new 48	com/b/a/a/j$1
    //   62: dup
    //   63: aload_0
    //   64: aload 4
    //   66: iload_2
    //   67: aload_1
    //   68: invokespecial 51	com/b/a/a/j$1:<init>	(Lcom/b/a/a/j;Lcom/b/a/n$a;ILjava/lang/String;)V
    //   71: invokevirtual 55	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   74: pop
    //   75: goto -42 -> 33
    //   78: astore_1
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_1
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	j
    //   0	83	1	paramString	String
    //   0	83	2	paramInt	int
    //   28	2	3	bool	boolean
    //   47	18	4	locala	n.a
    // Exception table:
    //   from	to	target	type
    //   2	20	78	finally
    //   20	29	78	finally
    //   36	75	78	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.b.a.a.j
 * JD-Core Version:    0.7.0.1
 */