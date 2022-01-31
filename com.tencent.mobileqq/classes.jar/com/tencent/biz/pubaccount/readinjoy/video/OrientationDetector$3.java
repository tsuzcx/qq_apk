package com.tencent.biz.pubaccount.readinjoy.video;

import android.view.OrientationEventListener;
import qzb;

public class OrientationDetector$3
  implements Runnable
{
  public OrientationDetector$3(qzb paramqzb, boolean paramBoolean) {}
  
  public void run()
  {
    synchronized (qzb.a(this.this$0))
    {
      if (qzb.a(this.this$0) == null) {
        return;
      }
    }
    try
    {
      if (this.a) {
        if (qzb.a(this.this$0).canDetectOrientation()) {
          qzb.a(this.this$0).enable();
        }
      }
      for (;;)
      {
        label53:
        return;
        localObject2 = finally;
        throw localObject2;
        qzb.a(this.this$0).disable();
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