package com.tencent.luggage.scanner.scanner.ui;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.luggage.scanner.camera.g;

class b$a
  extends Handler
{
  b$a(b paramb, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    b.b(this.a, System.currentTimeMillis());
    if (this.a.b.a())
    {
      if (!"auto".equals(this.a.b.k())) {
        this.a.b.a("auto");
      }
      this.a.b.a(this.a);
      com.tencent.luggage.wxa.ry.b.c("ScanView", "do auto focus");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.scanner.ui.b.a
 * JD-Core Version:    0.7.0.1
 */