package com.tencent.biz.pubaccount.readinjoy.video;

import android.view.OrientationEventListener;
import qjx;

public class OrientationDetector$3
  implements Runnable
{
  public OrientationDetector$3(qjx paramqjx, boolean paramBoolean) {}
  
  public void run()
  {
    synchronized (qjx.a(this.this$0))
    {
      if (qjx.a(this.this$0) == null) {
        return;
      }
    }
    try
    {
      if (this.a) {
        if (qjx.a(this.this$0).canDetectOrientation()) {
          qjx.a(this.this$0).enable();
        }
      }
      for (;;)
      {
        label53:
        return;
        localObject2 = finally;
        throw localObject2;
        qjx.a(this.this$0).disable();
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