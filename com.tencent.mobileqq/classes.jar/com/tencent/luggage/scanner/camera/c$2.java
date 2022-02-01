package com.tencent.luggage.scanner.camera;

import android.os.Handler;

class c$2
  implements Runnable
{
  c$2(c paramc, b.d paramd, b.d.a parama) {}
  
  public void run()
  {
    try
    {
      this.a.call();
      if (this.b != null) {
        c.a(this.c).post(new c.2.1(this));
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.camera.c.2
 * JD-Core Version:    0.7.0.1
 */