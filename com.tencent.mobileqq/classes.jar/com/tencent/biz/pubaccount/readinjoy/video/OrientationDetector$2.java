package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import qju;
import qjx;
import qoi;

public class OrientationDetector$2
  implements Runnable
{
  public OrientationDetector$2(qju paramqju, Activity paramActivity) {}
  
  public void run()
  {
    qju.a(this.this$0, this.a.getRequestedOrientation());
    qju.a(this.this$0, new qjx(this.this$0, new Handler(Looper.getMainLooper())));
    qju.a(this.this$0).a();
    qju.a(this.this$0, qoi.a(this.a));
    this.this$0.a(qju.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.OrientationDetector.2
 * JD-Core Version:    0.7.0.1
 */