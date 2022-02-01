package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import sfk;
import sfn;
import six;

public class OrientationDetector$2
  implements Runnable
{
  public OrientationDetector$2(sfk paramsfk, Activity paramActivity) {}
  
  public void run()
  {
    sfk.a(this.this$0, this.a.getRequestedOrientation());
    sfk.a(this.this$0, new sfn(this.this$0, new Handler(Looper.getMainLooper())));
    sfk.a(this.this$0).a();
    sfk.a(this.this$0, six.a(this.a));
    this.this$0.a(sfk.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.OrientationDetector.2
 * JD-Core Version:    0.7.0.1
 */