package com.tencent.luggage.scanner.camera;

import com.tencent.luggage.wxa.qz.o;

public class b$j
  extends b.e
{
  private g a;
  
  public b$j(g paramg)
  {
    this.a = paramg;
  }
  
  public Void a()
  {
    try
    {
      if (this.a.a())
      {
        o.d("CameraTask.DefaultStopPreviewTask", "stop preview");
        this.a.b();
      }
    }
    catch (Exception localException)
    {
      o.d("CameraTask.DefaultStopPreviewTask", "stop preview failed! %s", new Object[] { localException.getMessage() });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.camera.b.j
 * JD-Core Version:    0.7.0.1
 */