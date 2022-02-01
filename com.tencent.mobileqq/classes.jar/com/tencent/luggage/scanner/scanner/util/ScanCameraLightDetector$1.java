package com.tencent.luggage.scanner.scanner.util;

import android.os.Looper;
import android.os.Message;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.s;
import com.tencent.luggage.wxa.qz.t;

class ScanCameraLightDetector$1
  extends s
{
  ScanCameraLightDetector$1(ScanCameraLightDetector paramScanCameraLightDetector, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void a(Message paramMessage)
  {
    if (paramMessage.what == 233)
    {
      paramMessage = (ScanCameraLightDetector.a)paramMessage.obj;
      if (paramMessage != null)
      {
        long l = af.b();
        boolean bool = ScanCameraLightDetector.a(this.a, paramMessage.a, paramMessage.b, paramMessage.c);
        o.d("MicroMsg.ScanCameraLightDetector", "isYuvDark: %s, currentLight: %s, used %sms", new Object[] { Boolean.valueOf(bool), Float.valueOf(ScanCameraLightDetector.a(this.a)), Long.valueOf(af.c(l)) });
        if (bool)
        {
          o.d("MicroMsg.ScanCameraLightDetector", "is dark now");
          ScanCameraLightDetector.b(this.a);
          if ((ScanCameraLightDetector.c(this.a).equals("continuous-video")) && (ScanCameraLightDetector.d(this.a) < 2)) {
            return;
          }
          ScanCameraLightDetector.a(this.a, 0);
          t.a(new ScanCameraLightDetector.1.1(this));
          return;
        }
        o.d("MicroMsg.ScanCameraLightDetector", "not dark");
        ScanCameraLightDetector.a(this.a, 0);
        t.a(new ScanCameraLightDetector.1.2(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.scanner.util.ScanCameraLightDetector.1
 * JD-Core Version:    0.7.0.1
 */