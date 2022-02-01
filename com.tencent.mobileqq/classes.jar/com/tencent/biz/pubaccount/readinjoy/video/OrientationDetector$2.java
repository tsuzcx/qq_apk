package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import rlu;
import rlx;
import rpt;

public class OrientationDetector$2
  implements Runnable
{
  public OrientationDetector$2(rlu paramrlu, Activity paramActivity) {}
  
  public void run()
  {
    rlu.a(this.this$0, this.a.getRequestedOrientation());
    rlu.a(this.this$0, new rlx(this.this$0, new Handler(Looper.getMainLooper())));
    rlu.a(this.this$0).a();
    rlu.a(this.this$0, rpt.a(this.a));
    this.this$0.a(rlu.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.OrientationDetector.2
 * JD-Core Version:    0.7.0.1
 */