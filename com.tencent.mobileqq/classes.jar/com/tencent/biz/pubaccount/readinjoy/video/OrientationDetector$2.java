package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import qjx;
import qka;
import qol;

public class OrientationDetector$2
  implements Runnable
{
  public OrientationDetector$2(qjx paramqjx, Activity paramActivity) {}
  
  public void run()
  {
    qjx.a(this.this$0, this.a.getRequestedOrientation());
    qjx.a(this.this$0, new qka(this.this$0, new Handler(Looper.getMainLooper())));
    qjx.a(this.this$0).a();
    qjx.a(this.this$0, qol.a(this.a));
    this.this$0.a(qjx.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.OrientationDetector.2
 * JD-Core Version:    0.7.0.1
 */