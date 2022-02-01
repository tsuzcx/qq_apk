package com.tencent.luggage.scanner.camera;

import android.graphics.SurfaceTexture;
import com.tencent.luggage.wxa.qz.o;

public class b$i
  extends b.d
{
  private g a;
  private SurfaceTexture b;
  
  public b$i(g paramg, SurfaceTexture paramSurfaceTexture)
  {
    this.a = paramg;
    this.b = paramSurfaceTexture;
  }
  
  public Void a()
  {
    try
    {
      if ((this.a.c()) && (!this.a.a()))
      {
        o.d("CameraTask.DefaultStartPreviewTask", "start preview");
        this.a.a(this.b);
      }
    }
    catch (Exception localException)
    {
      o.b("CameraTask.DefaultStartPreviewTask", "start preview failed! %s", new Object[] { localException.getMessage() });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.camera.b.i
 * JD-Core Version:    0.7.0.1
 */