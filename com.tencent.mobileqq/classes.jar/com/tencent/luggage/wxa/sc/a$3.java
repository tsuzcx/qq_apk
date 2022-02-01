package com.tencent.luggage.wxa.sc;

import android.os.HandlerThread;
import com.tencent.luggage.wxa.rz.c;
import com.tencent.luggage.wxa.rz.c.f;

final class a$3
  extends HandlerThread
{
  a$3(String paramString)
  {
    super(paramString);
  }
  
  public void interrupt()
  {
    super.interrupt();
    c.b.a(this, getName(), getId());
  }
  
  public boolean quit()
  {
    c.b.a(this, getName(), getId());
    return super.quit();
  }
  
  public boolean quitSafely()
  {
    c.b.a(this, getName(), getId());
    return super.quitSafely();
  }
  
  public void start()
  {
    try
    {
      super.start();
      c.b.b(this, getName(), getId());
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
 * Qualified Name:     com.tencent.luggage.wxa.sc.a.3
 * JD-Core Version:    0.7.0.1
 */