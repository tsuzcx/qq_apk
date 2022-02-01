package com.tencent.av.ui;

import android.os.Handler;
import mim;
import mnh;

public class QavVideoRecordUICtrl$1
  implements Runnable
{
  public QavVideoRecordUICtrl$1(mim parammim) {}
  
  public void run()
  {
    mim.a(this.this$0, this.this$0.a());
    mim.b(this.this$0, mnh.a());
    if (mim.a(this.this$0) < 31457280L) {
      mim.a(this.this$0).post(new QavVideoRecordUICtrl.1.1(this));
    }
    while (!mim.b) {
      return;
    }
    mim.a(this.this$0).sendEmptyMessageDelayed(11, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.QavVideoRecordUICtrl.1
 * JD-Core Version:    0.7.0.1
 */