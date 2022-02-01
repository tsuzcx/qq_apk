package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import ruy;
import rvb;
import ryx;

public class OrientationDetector$2
  implements Runnable
{
  public OrientationDetector$2(ruy paramruy, Activity paramActivity) {}
  
  public void run()
  {
    ruy.a(this.this$0, this.a.getRequestedOrientation());
    ruy.a(this.this$0, new rvb(this.this$0, new Handler(Looper.getMainLooper())));
    ruy.a(this.this$0).a();
    ruy.a(this.this$0, ryx.a(this.a));
    this.this$0.a(ruy.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.OrientationDetector.2
 * JD-Core Version:    0.7.0.1
 */