package com.tencent.av.ui;

import android.os.Handler;
import min;
import mnc;

public class QavVideoRecordUICtrl$1
  implements Runnable
{
  public QavVideoRecordUICtrl$1(min parammin) {}
  
  public void run()
  {
    min.a(this.this$0, this.this$0.a());
    min.b(this.this$0, mnc.a());
    if (min.a(this.this$0) < 31457280L) {
      min.a(this.this$0).post(new QavVideoRecordUICtrl.1.1(this));
    }
    while (!min.b) {
      return;
    }
    min.a(this.this$0).sendEmptyMessageDelayed(11, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.QavVideoRecordUICtrl.1
 * JD-Core Version:    0.7.0.1
 */