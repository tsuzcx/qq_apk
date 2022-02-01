package com.tencent.luggage.wxa.hd;

import android.net.LocalServerSocket;
import android.text.TextUtils;

class c$e
{
  private final String a;
  private volatile LocalServerSocket b = null;
  private volatile int c = 0;
  
  c$e(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        this.a = paramString;
        return;
      }
      finally {}
    }
    throw new IllegalArgumentException("lockName is null or empty.");
  }
  
  boolean a()
  {
    label40:
    try
    {
      LocalServerSocket localLocalServerSocket = this.b;
      if (localLocalServerSocket != null) {}
    }
    finally {}
    try
    {
      this.b = new LocalServerSocket(this.a);
      this.c += 1;
      return true;
    }
    catch (Throwable localThrowable)
    {
      break label40;
    }
    this.b = null;
    return false;
    this.c += 1;
    return true;
  }
  
  void b()
  {
    for (;;)
    {
      try
      {
        boolean bool = a();
        if (bool) {
          return;
        }
      }
      finally
      {
        try
        {
          Thread.sleep(10L);
        }
        catch (Throwable localThrowable) {}
        localObject = finally;
        continue;
        throw localObject;
      }
    }
  }
  
  /* Error */
  void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 19	com/tencent/luggage/wxa/hd/c$e:c	I
    //   6: ifle +13 -> 19
    //   9: aload_0
    //   10: aload_0
    //   11: getfield 19	com/tencent/luggage/wxa/hd/c$e:c	I
    //   14: iconst_1
    //   15: isub
    //   16: putfield 19	com/tencent/luggage/wxa/hd/c$e:c	I
    //   19: aload_0
    //   20: getfield 19	com/tencent/luggage/wxa/hd/c$e:c	I
    //   23: ifne +35 -> 58
    //   26: aload_0
    //   27: getfield 17	com/tencent/luggage/wxa/hd/c$e:b	Landroid/net/LocalServerSocket;
    //   30: astore_1
    //   31: aload_1
    //   32: ifnull +26 -> 58
    //   35: aload_0
    //   36: getfield 17	com/tencent/luggage/wxa/hd/c$e:b	Landroid/net/LocalServerSocket;
    //   39: invokevirtual 53	android/net/LocalServerSocket:close	()V
    //   42: aload_0
    //   43: aconst_null
    //   44: putfield 17	com/tencent/luggage/wxa/hd/c$e:b	Landroid/net/LocalServerSocket;
    //   47: goto +11 -> 58
    //   50: astore_1
    //   51: aload_0
    //   52: aconst_null
    //   53: putfield 17	com/tencent/luggage/wxa/hd/c$e:b	Landroid/net/LocalServerSocket;
    //   56: aload_1
    //   57: athrow
    //   58: aload_0
    //   59: monitorexit
    //   60: return
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    //   66: astore_1
    //   67: goto -25 -> 42
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	e
    //   30	2	1	localLocalServerSocket	LocalServerSocket
    //   50	7	1	localObject1	Object
    //   61	4	1	localObject2	Object
    //   66	1	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   35	42	50	finally
    //   2	19	61	finally
    //   19	31	61	finally
    //   42	47	61	finally
    //   51	58	61	finally
    //   35	42	66	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hd.c.e
 * JD-Core Version:    0.7.0.1
 */