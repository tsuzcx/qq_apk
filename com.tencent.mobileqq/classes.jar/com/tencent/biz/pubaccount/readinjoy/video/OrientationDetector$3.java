package com.tencent.biz.pubaccount.readinjoy.video;

import android.view.OrientationEventListener;
import ruy;

public class OrientationDetector$3
  implements Runnable
{
  public OrientationDetector$3(ruy paramruy, boolean paramBoolean) {}
  
  public void run()
  {
    synchronized (ruy.a(this.this$0))
    {
      if (ruy.a(this.this$0) == null) {
        return;
      }
    }
    try
    {
      if (this.a) {
        if (ruy.a(this.this$0).canDetectOrientation()) {
          ruy.a(this.this$0).enable();
        }
      }
      for (;;)
      {
        label53:
        return;
        localObject2 = finally;
        throw localObject2;
        ruy.a(this.this$0).disable();
      }
    }
    catch (Throwable localThrowable)
    {
      break label53;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.OrientationDetector.3
 * JD-Core Version:    0.7.0.1
 */