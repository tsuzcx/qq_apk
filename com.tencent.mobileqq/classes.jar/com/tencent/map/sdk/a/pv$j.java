package com.tencent.map.sdk.a;

import javax.microedition.khronos.opengles.GL10;

final class pv$j
{
  private static String a = "GLThreadManager";
  private boolean b;
  private int c;
  private boolean d;
  private boolean e;
  private boolean f;
  private pv.i g;
  
  private void c()
  {
    if (!this.b)
    {
      this.c = 131072;
      if (this.c >= 131072) {
        this.e = true;
      }
      this.b = true;
    }
  }
  
  public final void a(pv.i parami)
  {
    try
    {
      pv.i.a(parami);
      if (this.g == parami) {
        this.g = null;
      }
      notifyAll();
      return;
    }
    finally {}
  }
  
  public final void a(GL10 paramGL10)
  {
    for (;;)
    {
      try
      {
        if (!this.d)
        {
          c();
          paramGL10 = paramGL10.glGetString(7937);
          int i = this.c;
          boolean bool2 = false;
          if (i < 131072)
          {
            if (!paramGL10.startsWith("Q3Dimension MSM7500 "))
            {
              bool1 = true;
              this.e = bool1;
              notifyAll();
            }
          }
          else
          {
            bool1 = bool2;
            if (!this.e) {
              bool1 = true;
            }
            this.f = bool1;
            this.d = true;
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      boolean bool1 = false;
    }
  }
  
  public final boolean a()
  {
    try
    {
      boolean bool = this.f;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 48	com/tencent/map/sdk/a/pv$j:c	()V
    //   6: aload_0
    //   7: getfield 32	com/tencent/map/sdk/a/pv$j:e	Z
    //   10: istore_1
    //   11: iload_1
    //   12: ifne +9 -> 21
    //   15: iconst_1
    //   16: istore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: iload_1
    //   20: ireturn
    //   21: iconst_0
    //   22: istore_1
    //   23: goto -6 -> 17
    //   26: astore_2
    //   27: aload_0
    //   28: monitorexit
    //   29: goto +5 -> 34
    //   32: aload_2
    //   33: athrow
    //   34: goto -2 -> 32
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	j
    //   10	13	1	bool	boolean
    //   26	7	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	26	finally
  }
  
  public final boolean b(pv.i arg1)
  {
    try
    {
      if ((this.g != ???) && (this.g != null))
      {
        c();
        boolean bool = this.e;
        if (bool) {
          return true;
        }
        if (this.g != null)
        {
          pv.i locali = this.g;
          synchronized (pv.a())
          {
            locali.i = true;
            pv.a().notifyAll();
          }
        }
        return false;
      }
      this.g = ???;
      notifyAll();
      return true;
    }
    finally {}
  }
  
  public final void c(pv.i parami)
  {
    try
    {
      if (this.g == parami) {
        this.g = null;
      }
      notifyAll();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.pv.j
 * JD-Core Version:    0.7.0.1
 */