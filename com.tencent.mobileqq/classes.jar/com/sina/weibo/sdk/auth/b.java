package com.sina.weibo.sdk.auth;

import java.util.HashMap;
import java.util.Map;

public final class b
{
  private Map<String, WbAuthListener> i = new HashMap();
  
  public static b f()
  {
    try
    {
      b localb = b.a.g();
      return localb;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final WbAuthListener a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 34	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +9 -> 17
    //   11: aconst_null
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: areturn
    //   17: aload_0
    //   18: getfield 16	com/sina/weibo/sdk/auth/b:i	Ljava/util/Map;
    //   21: aload_1
    //   22: invokeinterface 40 2 0
    //   27: checkcast 42	com/sina/weibo/sdk/auth/WbAuthListener
    //   30: astore_1
    //   31: goto -18 -> 13
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	b
    //   0	39	1	paramString	String
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	34	finally
    //   17	31	34	finally
  }
  
  /* Error */
  public final void a(String paramString, WbAuthListener paramWbAuthListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 34	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifne +7 -> 15
    //   11: aload_2
    //   12: ifnonnull +6 -> 18
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: getfield 16	com/sina/weibo/sdk/auth/b:i	Ljava/util/Map;
    //   22: aload_1
    //   23: aload_2
    //   24: invokeinterface 47 3 0
    //   29: pop
    //   30: goto -15 -> 15
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	b
    //   0	38	1	paramString	String
    //   0	38	2	paramWbAuthListener	WbAuthListener
    //   6	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	33	finally
    //   18	30	33	finally
  }
  
  /* Error */
  public final void b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 34	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 16	com/sina/weibo/sdk/auth/b:i	Ljava/util/Map;
    //   18: aload_1
    //   19: invokeinterface 52 2 0
    //   24: pop
    //   25: goto -14 -> 11
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	b
    //   0	33	1	paramString	String
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	28	finally
    //   14	25	28	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.sina.weibo.sdk.auth.b
 * JD-Core Version:    0.7.0.1
 */