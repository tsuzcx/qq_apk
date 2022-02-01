package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import rsv;
import rsy;
import rwv;

public class OrientationDetector$2
  implements Runnable
{
  public OrientationDetector$2(rsv paramrsv, Activity paramActivity) {}
  
  public void run()
  {
    rsv.a(this.this$0, this.a.getRequestedOrientation());
    rsv.a(this.this$0, new rsy(this.this$0, new Handler(Looper.getMainLooper())));
    rsv.a(this.this$0).a();
    rsv.a(this.this$0, rwv.a(this.a));
    this.this$0.a(rsv.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.OrientationDetector.2
 * JD-Core Version:    0.7.0.1
 */