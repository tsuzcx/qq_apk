package com.tencent.av.ui;

import android.os.Handler;
import mlf;
import mpw;

public class QavVideoRecordUICtrl$1
  implements Runnable
{
  public QavVideoRecordUICtrl$1(mlf parammlf) {}
  
  public void run()
  {
    mlf.a(this.this$0, this.this$0.a());
    mlf.b(this.this$0, mpw.a());
    if (mlf.a(this.this$0) < 31457280L) {
      mlf.a(this.this$0).post(new QavVideoRecordUICtrl.1.1(this));
    }
    while (!mlf.b) {
      return;
    }
    mlf.a(this.this$0).sendEmptyMessageDelayed(11, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.QavVideoRecordUICtrl.1
 * JD-Core Version:    0.7.0.1
 */