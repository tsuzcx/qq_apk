package com.tencent.biz.pubaccount.readinjoy.video;

import android.view.OrientationEventListener;
import com.tencent.qphone.base.util.QLog;
import sfk;

public class OrientationDetector$3
  implements Runnable
{
  public OrientationDetector$3(sfk paramsfk, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    synchronized (sfk.a(this.this$0))
    {
      if (QLog.isColorLevel()) {
        QLog.d(sfk.a, 2, "run: innerEnable: enable=" + this.a + ", mEventListener=" + sfk.a(this.this$0));
      }
      if (sfk.a(this.this$0) == null) {
        return;
      }
    }
    try
    {
      if (this.a)
      {
        if (sfk.a(this.this$0).canDetectOrientation()) {
          sfk.a(this.this$0).enable();
        }
        if (!this.b) {}
      }
    }
    catch (Throwable localThrowable)
    {
      synchronized (sfk.a(this.this$0))
      {
        for (;;)
        {
          sfk.a(this.this$0, null);
          return;
          localObject3 = finally;
          throw localObject3;
          sfk.a(this.this$0).disable();
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