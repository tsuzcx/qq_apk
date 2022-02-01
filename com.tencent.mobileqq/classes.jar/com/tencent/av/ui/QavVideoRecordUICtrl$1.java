package com.tencent.av.ui;

import android.os.Handler;
import mih;
import mnb;

public class QavVideoRecordUICtrl$1
  implements Runnable
{
  public QavVideoRecordUICtrl$1(mih parammih) {}
  
  public void run()
  {
    mih.a(this.this$0, this.this$0.a());
    mih.b(this.this$0, mnb.a());
    if (mih.a(this.this$0) < 31457280L) {
      mih.a(this.this$0).post(new QavVideoRecordUICtrl.1.1(this));
    }
    while (!mih.b) {
      return;
    }
    mih.a(this.this$0).sendEmptyMessageDelayed(11, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.QavVideoRecordUICtrl.1
 * JD-Core Version:    0.7.0.1
 */