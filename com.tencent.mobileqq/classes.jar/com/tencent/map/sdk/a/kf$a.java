package com.tencent.map.sdk.a;

public final class kf$a
  extends Thread
{
  private boolean b;
  private boolean c;
  
  private kf$a(kf paramkf) {}
  
  public final void a()
  {
    try
    {
      this.c = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void b()
  {
    try
    {
      this.c = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void destroy()
  {
    try
    {
      this.b = false;
      interrupt();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void run()
  {
    for (;;)
    {
      if (this.b)
      {
        if (!this.c)
        {
          if (this.a.c != null) {
            this.a.c.b(nv.p);
          }
          if ((this.a.e) && (System.currentTimeMillis() - this.a.d > 500L))
          {
            this.a.e = false;
            if (this.a.f != null) {
              this.a.f.a();
            }
          }
        }
        try
        {
          try
          {
            wait(this.a.a());
            continue;
          }
          finally {}
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          Thread.currentThread().interrupt();
        }
      }
    }
  }
  
  public final void start()
  {
    try
    {
      this.b = true;
      super.start();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.a.kf.a
 * JD-Core Version:    0.7.0.1
 */