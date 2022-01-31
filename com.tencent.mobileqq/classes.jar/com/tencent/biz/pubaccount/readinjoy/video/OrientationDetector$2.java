package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import qzb;
import qze;
import rdm;

public class OrientationDetector$2
  implements Runnable
{
  public OrientationDetector$2(qzb paramqzb, Activity paramActivity) {}
  
  public void run()
  {
    qzb.a(this.this$0, this.a.getRequestedOrientation());
    qzb.a(this.this$0, new qze(this.this$0, new Handler(Looper.getMainLooper())));
    qzb.a(this.this$0).a();
    qzb.a(this.this$0, rdm.a(this.a));
    this.this$0.a(qzb.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.OrientationDetector.2
 * JD-Core Version:    0.7.0.1
 */