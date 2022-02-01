package com.tencent.luggage.scanner.camera;

import android.os.Handler;

class c$1
  implements Runnable
{
  c$1(c paramc, b.b paramb, b.b.a parama) {}
  
  public void run()
  {
    try
    {
      this.a.call();
      if (this.b != null) {
        c.a(this.c).post(new c.1.1(this));
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.camera.c.1
 * JD-Core Version:    0.7.0.1
 */