package com.tencent.luggage.wxa.f;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;

class b$7
  implements Camera.AutoFocusCallback
{
  b$7(b paramb) {}
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    if (b.d(this.a) != null) {
      b.d(this.a).onAutoFocus(paramBoolean, paramCamera);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.f.b.7
 * JD-Core Version:    0.7.0.1
 */