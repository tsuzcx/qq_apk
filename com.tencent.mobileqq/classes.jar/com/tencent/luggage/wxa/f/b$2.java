package com.tencent.luggage.wxa.f;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import java.util.concurrent.atomic.AtomicBoolean;

class b$2
  implements Camera.AutoFocusCallback
{
  b$2(b paramb) {}
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    if (b.a(this.a).get())
    {
      f.b("MicroMsg.Camera1", "takePicture, auto focus => takePictureInternal");
      b.a(this.a).set(false);
      this.a.q();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.f.b.2
 * JD-Core Version:    0.7.0.1
 */