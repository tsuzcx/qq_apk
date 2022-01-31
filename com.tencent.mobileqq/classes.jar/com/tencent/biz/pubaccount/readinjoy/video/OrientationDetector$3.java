package com.tencent.biz.pubaccount.readinjoy.video;

import android.view.OrientationEventListener;
import qju;

public class OrientationDetector$3
  implements Runnable
{
  public OrientationDetector$3(qju paramqju, boolean paramBoolean) {}
  
  public void run()
  {
    synchronized (qju.a(this.this$0))
    {
      if (qju.a(this.this$0) == null) {
        return;
      }
    }
    try
    {
      if (this.a) {
        if (qju.a(this.this$0).canDetectOrientation()) {
          qju.a(this.this$0).enable();
        }
      }
      for (;;)
      {
        label53:
        return;
        localObject2 = finally;
        throw localObject2;
        qju.a(this.this$0).disable();
      }
    }
    catch (Throwable localThrowable)
    {
      break label53;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.OrientationDetector.3
 * JD-Core Version:    0.7.0.1
 */