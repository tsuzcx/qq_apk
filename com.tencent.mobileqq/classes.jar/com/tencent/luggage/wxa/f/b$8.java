package com.tencent.luggage.wxa.f;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import java.util.List;

class b$8
  implements Runnable
{
  b$8(b paramb, Camera paramCamera, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.a != null) && (b.e(this.c)))
    {
      this.a.cancelAutoFocus();
      try
      {
        Camera.Parameters localParameters = this.a.getParameters();
        if ((localParameters != null) && (!localParameters.getFocusMode().equalsIgnoreCase("continuous-picture")) && (localParameters.getSupportedFocusModes().contains("continuous-picture")))
        {
          localParameters.setFocusMode("continuous-picture");
          localParameters.setFocusAreas(null);
          localParameters.setMeteringAreas(null);
          this.a.setParameters(localParameters);
        }
      }
      catch (Exception localException)
      {
        f.c("MicroMsg.Camera1", "resetFocus, camera getParameters or setParameters fail", localException);
      }
      if (b.d(this.c) != null) {
        b.d(this.c).onAutoFocus(this.b, this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.f.b.8
 * JD-Core Version:    0.7.0.1
 */