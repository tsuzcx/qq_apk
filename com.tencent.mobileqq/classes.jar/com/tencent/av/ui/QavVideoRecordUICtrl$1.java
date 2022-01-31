package com.tencent.av.ui;

import android.os.Handler;
import miq;
import mnf;

public class QavVideoRecordUICtrl$1
  implements Runnable
{
  public QavVideoRecordUICtrl$1(miq parammiq) {}
  
  public void run()
  {
    miq.a(this.this$0, this.this$0.a());
    miq.b(this.this$0, mnf.a());
    if (miq.a(this.this$0) < 31457280L) {
      miq.a(this.this$0).post(new QavVideoRecordUICtrl.1.1(this));
    }
    while (!miq.b) {
      return;
    }
    miq.a(this.this$0).sendEmptyMessageDelayed(11, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.QavVideoRecordUICtrl.1
 * JD-Core Version:    0.7.0.1
 */