package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import pxy;
import pyb;
import qcn;

public class OrientationDetector$2
  implements Runnable
{
  public OrientationDetector$2(pxy parampxy, Activity paramActivity) {}
  
  public void run()
  {
    pxy.a(this.this$0, this.a.getRequestedOrientation());
    pxy.a(this.this$0, new pyb(this.this$0, new Handler(Looper.getMainLooper())));
    pxy.a(this.this$0).a();
    pxy.a(this.this$0, qcn.a(this.a));
    this.this$0.a(pxy.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.OrientationDetector.2
 * JD-Core Version:    0.7.0.1
 */