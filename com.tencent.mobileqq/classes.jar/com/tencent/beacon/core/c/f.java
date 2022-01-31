package com.tencent.beacon.core.c;

import android.content.Context;
import com.tencent.beacon.core.d.b;

public abstract class f
{
  private static f a = null;
  
  /* Error */
  public static f a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 20	com/tencent/beacon/core/strategy/a:a	()Lcom/tencent/beacon/core/strategy/a;
    //   6: invokevirtual 24	com/tencent/beacon/core/strategy/a:h	()Z
    //   9: istore_1
    //   10: getstatic 10	com/tencent/beacon/core/c/f:a	Lcom/tencent/beacon/core/c/f;
    //   13: ifnonnull +21 -> 34
    //   16: aload_0
    //   17: ifnull +17 -> 34
    //   20: aload_0
    //   21: iload_1
    //   22: invokestatic 27	com/tencent/beacon/core/c/f:a	(Landroid/content/Context;Z)V
    //   25: getstatic 10	com/tencent/beacon/core/c/f:a	Lcom/tencent/beacon/core/c/f;
    //   28: astore_0
    //   29: ldc 2
    //   31: monitorexit
    //   32: aload_0
    //   33: areturn
    //   34: getstatic 10	com/tencent/beacon/core/c/f:a	Lcom/tencent/beacon/core/c/f;
    //   37: ifnull -12 -> 25
    //   40: getstatic 10	com/tencent/beacon/core/c/f:a	Lcom/tencent/beacon/core/c/f;
    //   43: invokevirtual 29	com/tencent/beacon/core/c/f:a	()Z
    //   46: iload_1
    //   47: if_icmpeq -22 -> 25
    //   50: aload_0
    //   51: iload_1
    //   52: invokestatic 27	com/tencent/beacon/core/c/f:a	(Landroid/content/Context;Z)V
    //   55: goto -30 -> 25
    //   58: astore_0
    //   59: ldc 2
    //   61: monitorexit
    //   62: aload_0
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	paramContext	Context
    //   9	43	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	16	58	finally
    //   20	25	58	finally
    //   25	29	58	finally
    //   34	55	58	finally
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
  
  protected static void b()
  {
    try
    {
      Thread.sleep(5000L);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      b.a(localInterruptedException);
    }
  }
  
  public abstract boolean a();
  
  public byte[] a(String paramString, int paramInt, byte[] paramArrayOfByte, a parama, e parame)
  {
    return null;
  }
  
  public byte[] a(String paramString, byte[] paramArrayOfByte, a parama, e parame)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.beacon.core.c.f
 * JD-Core Version:    0.7.0.1
 */