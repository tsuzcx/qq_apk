package com.tencent.luggage.scanner.camera;

import com.tencent.luggage.wxa.qz.o;

public class b$f
  extends b.a
{
  private g a;
  
  public b$f(g paramg)
  {
    this.a = paramg;
  }
  
  public Void a()
  {
    try
    {
      if (this.a.c())
      {
        this.a.d();
        o.d("CameraTask.DefaultCloseTask", "close camera");
      }
    }
    catch (Exception localException)
    {
      o.b("CameraTask.DefaultCloseTask", "close camera failed! %s", new Object[] { localException.getMessage() });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.camera.b.f
 * JD-Core Version:    0.7.0.1
 */