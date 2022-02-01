package com.tencent.luggage.wxa.f;

import android.hardware.camera2.CameraCaptureSession;

class c$7
  implements Runnable
{
  c$7(c paramc) {}
  
  public void run()
  {
    if (this.a.c != null)
    {
      this.a.c.close();
      this.a.c = null;
    }
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.f.c.7
 * JD-Core Version:    0.7.0.1
 */