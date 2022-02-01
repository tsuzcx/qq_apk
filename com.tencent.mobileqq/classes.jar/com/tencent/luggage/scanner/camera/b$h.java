package com.tencent.luggage.scanner.camera;

import com.tencent.luggage.wxa.qz.o;

public class b$h
  extends b.c
{
  private g a;
  private int b;
  
  public b$h(g paramg, int paramInt)
  {
    this.a = paramg;
    this.b = paramInt;
  }
  
  public Void a()
  {
    try
    {
      o.d("CameraTask.CameraReOpenTask", "reopen camera");
      this.a.d();
      this.a.a(this.b);
      this.a.a(new b.h.1(this));
    }
    catch (Exception localException)
    {
      o.b("CameraTask.CameraReOpenTask", "reopen camera failed! %s", new Object[] { localException.getMessage() });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.camera.b.h
 * JD-Core Version:    0.7.0.1
 */