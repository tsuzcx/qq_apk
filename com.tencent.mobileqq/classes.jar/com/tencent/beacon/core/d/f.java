package com.tencent.beacon.core.d;

import android.content.Context;

public abstract class f
{
  protected static f a;
  
  /* Error */
  public static f a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 18	com/tencent/beacon/core/strategy/g:b	(Landroid/content/Context;)Lcom/tencent/beacon/core/strategy/g;
    //   7: invokevirtual 22	com/tencent/beacon/core/strategy/g:e	()Z
    //   10: istore_1
    //   11: getstatic 24	com/tencent/beacon/core/d/f:a	Lcom/tencent/beacon/core/d/f;
    //   14: ifnonnull +21 -> 35
    //   17: aload_0
    //   18: ifnull +17 -> 35
    //   21: aload_0
    //   22: iload_1
    //   23: invokestatic 27	com/tencent/beacon/core/d/f:a	(Landroid/content/Context;Z)V
    //   26: getstatic 24	com/tencent/beacon/core/d/f:a	Lcom/tencent/beacon/core/d/f;
    //   29: astore_0
    //   30: ldc 2
    //   32: monitorexit
    //   33: aload_0
    //   34: areturn
    //   35: getstatic 24	com/tencent/beacon/core/d/f:a	Lcom/tencent/beacon/core/d/f;
    //   38: astore_2
    //   39: aload_2
    //   40: ifnull -14 -> 26
    //   43: aload_2
    //   44: invokevirtual 29	com/tencent/beacon/core/d/f:a	()Z
    //   47: iload_1
    //   48: if_icmpeq -22 -> 26
    //   51: aload_0
    //   52: iload_1
    //   53: invokestatic 27	com/tencent/beacon/core/d/f:a	(Landroid/content/Context;Z)V
    //   56: goto -30 -> 26
    //   59: astore_0
    //   60: ldc 2
    //   62: monitorexit
    //   63: aload_0
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	paramContext	Context
    //   10	43	1	bool	boolean
    //   38	6	2	localf	f
    // Exception table:
    //   from	to	target	type
    //   3	17	59	finally
    //   21	26	59	finally
    //   26	30	59	finally
    //   35	39	59	finally
    //   43	56	59	finally
  }
  
  private static void a(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a = new f.b(paramContext);
      return;
    }
    a = new f.a(paramContext);
  }
  
  protected void a(long paramLong)
  {
    try
    {
      Thread.sleep(paramLong);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      com.tencent.beacon.core.e.d.a(localInterruptedException);
    }
  }
  
  public abstract boolean a();
  
  public byte[] a(String paramString, int paramInt, byte[] paramArrayOfByte, a parama, d paramd)
  {
    return null;
  }
  
  public byte[] a(String paramString, byte[] paramArrayOfByte, a parama, d paramd)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.d.f
 * JD-Core Version:    0.7.0.1
 */