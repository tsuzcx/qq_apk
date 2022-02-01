package com.tencent.av.ui;

import android.os.Handler;
import mjd;
import mny;

public class QavVideoRecordUICtrl$1
  implements Runnable
{
  public QavVideoRecordUICtrl$1(mjd parammjd) {}
  
  public void run()
  {
    mjd.a(this.this$0, this.this$0.a());
    mjd.b(this.this$0, mny.a());
    if (mjd.a(this.this$0) < 31457280L) {
      mjd.a(this.this$0).post(new QavVideoRecordUICtrl.1.1(this));
    }
    while (!mjd.b) {
      return;
    }
    mjd.a(this.this$0).sendEmptyMessageDelayed(11, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.QavVideoRecordUICtrl.1
 * JD-Core Version:    0.7.0.1
 */