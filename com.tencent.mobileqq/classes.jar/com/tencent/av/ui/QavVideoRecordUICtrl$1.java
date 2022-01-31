package com.tencent.av.ui;

import android.os.Handler;
import lxz;
import mcg;

public class QavVideoRecordUICtrl$1
  implements Runnable
{
  public QavVideoRecordUICtrl$1(lxz paramlxz) {}
  
  public void run()
  {
    lxz.a(this.this$0, this.this$0.a());
    lxz.b(this.this$0, mcg.a());
    if (lxz.a(this.this$0) < 31457280L) {
      lxz.a(this.this$0).post(new QavVideoRecordUICtrl.1.1(this));
    }
    while (!lxz.b) {
      return;
    }
    lxz.a(this.this$0).sendEmptyMessageDelayed(11, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.QavVideoRecordUICtrl.1
 * JD-Core Version:    0.7.0.1
 */