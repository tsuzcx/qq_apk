package com.tencent.biz.pubaccount.readinjoy.video;

import android.view.OrientationEventListener;
import com.tencent.qphone.base.util.QLog;

class OrientationDetector$3
  implements Runnable
{
  OrientationDetector$3(OrientationDetector paramOrientationDetector, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    synchronized (OrientationDetector.a(this.this$0))
    {
      if (QLog.isColorLevel()) {
        QLog.d(OrientationDetector.a, 2, "run: innerEnable: enable=" + this.a + ", mEventListener=" + OrientationDetector.a(this.this$0));
      }
      if (OrientationDetector.a(this.this$0) == null) {
        return;
      }
    }
    try
    {
      if (this.a)
      {
        if (OrientationDetector.a(this.this$0).canDetectOrientation()) {
          OrientationDetector.a(this.this$0).enable();
        }
        if (!this.b) {}
      }
    }
    catch (Throwable localThrowable)
    {
      synchronized (OrientationDetector.a(this.this$0))
      {
        for (;;)
        {
          OrientationDetector.a(this.this$0, null);
          return;
          localObject3 = finally;
          throw localObject3;
          OrientationDetector.a(this.this$0).disable();
        }
        localThrowable = localThrowable;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.OrientationDetector.3
 * JD-Core Version:    0.7.0.1
 */