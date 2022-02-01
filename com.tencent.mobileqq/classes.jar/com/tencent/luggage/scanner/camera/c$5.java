package com.tencent.luggage.scanner.camera;

import android.os.Handler;

class c$5
  implements Runnable
{
  c$5(c paramc, b.c paramc1, b.c.a parama) {}
  
  public void run()
  {
    try
    {
      this.a.call();
      if (this.b != null) {
        c.a(this.c).post(new c.5.1(this));
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.camera.c.5
 * JD-Core Version:    0.7.0.1
 */