package com.tencent.av.ui;

import android.os.Handler;
import mji;
import moe;

public class QavVideoRecordUICtrl$1
  implements Runnable
{
  public QavVideoRecordUICtrl$1(mji parammji) {}
  
  public void run()
  {
    mji.a(this.this$0, this.this$0.a());
    mji.b(this.this$0, moe.a());
    if (mji.a(this.this$0) < 31457280L) {
      mji.a(this.this$0).post(new QavVideoRecordUICtrl.1.1(this));
    }
    while (!mji.b) {
      return;
    }
    mji.a(this.this$0).sendEmptyMessageDelayed(11, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.QavVideoRecordUICtrl.1
 * JD-Core Version:    0.7.0.1
 */