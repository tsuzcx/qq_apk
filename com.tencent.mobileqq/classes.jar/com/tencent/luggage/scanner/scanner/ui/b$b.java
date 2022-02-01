package com.tencent.luggage.scanner.scanner.ui;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.luggage.scanner.camera.g;

class b$b
  extends Handler
{
  b$b(b paramb, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    b.a(this.a, System.currentTimeMillis());
    com.tencent.luggage.wxa.ry.b.c("ScanView", "take one shot");
    if (this.a.b.a()) {
      this.a.b.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.scanner.ui.b.b
 * JD-Core Version:    0.7.0.1
 */