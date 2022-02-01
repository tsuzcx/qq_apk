package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;

class OrientationDetector$2
  implements Runnable
{
  OrientationDetector$2(OrientationDetector paramOrientationDetector, Activity paramActivity) {}
  
  public void run()
  {
    OrientationDetector.a(this.this$0, this.a.getRequestedOrientation());
    OrientationDetector.a(this.this$0, new OrientationDetector.RotationObserver(this.this$0, new Handler(Looper.getMainLooper())));
    OrientationDetector.a(this.this$0).a();
    OrientationDetector.a(this.this$0, VideoFeedsHelper.a(this.a));
    this.this$0.a(OrientationDetector.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.OrientationDetector.2
 * JD-Core Version:    0.7.0.1
 */