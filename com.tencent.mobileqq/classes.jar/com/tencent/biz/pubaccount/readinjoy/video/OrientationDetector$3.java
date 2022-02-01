package com.tencent.biz.pubaccount.readinjoy.video;

import android.view.OrientationEventListener;
import com.tencent.qphone.base.util.QLog;
import rlu;

public class OrientationDetector$3
  implements Runnable
{
  public OrientationDetector$3(rlu paramrlu, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    synchronized (rlu.a(this.this$0))
    {
      if (QLog.isColorLevel()) {
        QLog.d(rlu.a, 2, "run: innerEnable: enable=" + this.a + ", mEventListener=" + rlu.a(this.this$0));
      }
      if (rlu.a(this.this$0) == null) {
        return;
      }
    }
    try
    {
      if (this.a)
      {
        if (rlu.a(this.this$0).canDetectOrientation()) {
          rlu.a(this.this$0).enable();
        }
        if (!this.b) {}
      }
    }
    catch (Throwable localThrowable)
    {
      synchronized (rlu.a(this.this$0))
      {
        for (;;)
        {
          rlu.a(this.this$0, null);
          return;
          localObject3 = finally;
          throw localObject3;
          rlu.a(this.this$0).disable();
        }
        localThrowable = localThrowable;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.OrientationDetector.3
 * JD-Core Version:    0.7.0.1
 */