package com.sixgod.pluginsdk;

import java.util.HashMap;

public final class a
{
  private static HashMap a = new HashMap();
  
  public static ClassLoader a(String paramString)
  {
    try
    {
      paramString = (ClassLoader)a.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void a(String paramString, ClassLoader paramClassLoader)
  {
    try
    {
      b(paramString, paramClassLoader);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  private static void b(String paramString, ClassLoader paramClassLoader)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 33	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: istore_2
    //   8: iload_2
    //   9: ifne +7 -> 16
    //   12: aload_1
    //   13: ifnonnull +7 -> 20
    //   16: ldc 2
    //   18: monitorexit
    //   19: return
    //   20: getstatic 15	com/sixgod/pluginsdk/a:a	Ljava/util/HashMap;
    //   23: aload_0
    //   24: invokevirtual 37	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   27: ifne -11 -> 16
    //   30: getstatic 15	com/sixgod/pluginsdk/a:a	Ljava/util/HashMap;
    //   33: aload_0
    //   34: aload_1
    //   35: invokevirtual 41	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   38: pop
    //   39: goto -23 -> 16
    //   42: astore_0
    //   43: ldc 2
    //   45: monitorexit
    //   46: aload_0
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	paramString	String
    //   0	48	1	paramClassLoader	ClassLoader
    //   7	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	8	42	finally
    //   20	39	42	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.sixgod.pluginsdk.a
 * JD-Core Version:    0.7.0.1
 */