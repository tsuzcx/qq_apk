package com.tencent.biz.pubaccount.readinjoy.video;

import android.view.OrientationEventListener;
import com.tencent.qphone.base.util.QLog;
import rsv;

public class OrientationDetector$3
  implements Runnable
{
  public OrientationDetector$3(rsv paramrsv, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    synchronized (rsv.a(this.this$0))
    {
      if (QLog.isColorLevel()) {
        QLog.d(rsv.a, 2, "run: innerEnable: enable=" + this.a + ", mEventListener=" + rsv.a(this.this$0));
      }
      if (rsv.a(this.this$0) == null) {
        return;
      }
    }
    try
    {
      if (this.a)
      {
        if (rsv.a(this.this$0).canDetectOrientation()) {
          rsv.a(this.this$0).enable();
        }
        if (!this.b) {}
      }
    }
    catch (Throwable localThrowable)
    {
      synchronized (rsv.a(this.this$0))
      {
        for (;;)
        {
          rsv.a(this.this$0, null);
          return;
          localObject3 = finally;
          throw localObject3;
          rsv.a(this.this$0).disable();
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