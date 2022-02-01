package com.tencent.luggage.scanner.camera;

import com.tencent.luggage.wxa.qz.o;

public class b$g
  extends b.b
{
  private g a;
  private int b;
  
  public b$g(g paramg, int paramInt)
  {
    this.a = paramg;
    this.b = paramInt;
  }
  
  public Void a()
  {
    try
    {
      if (!this.a.c())
      {
        o.d("CameraTask.DefaultOpenTask", "open camera");
        this.a.a(this.b);
        this.a.a(new b.g.1(this));
      }
    }
    catch (Exception localException)
    {
      o.b("CameraTask.DefaultOpenTask", "open camera failed! %s", new Object[] { localException.getMessage() });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.camera.b.g
 * JD-Core Version:    0.7.0.1
 */