package com.tencent.luggage.wxa.f;

import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import java.util.concurrent.atomic.AtomicBoolean;

class b$4
  implements Camera.PictureCallback
{
  b$4(b paramb) {}
  
  public void onPictureTaken(byte[] paramArrayOfByte, Camera paramCamera)
  {
    f.b("MicroMsg.Camera1", "takePictureInternal, onPictureTaken");
    b.b(this.a).set(false);
    paramCamera.cancelAutoFocus();
    paramCamera.startPreview();
    b.a(this.a, true);
    if (b.c(this.a)) {
      paramCamera.setPreviewCallback(this.a);
    }
    this.a.f.a(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.f.b.4
 * JD-Core Version:    0.7.0.1
 */