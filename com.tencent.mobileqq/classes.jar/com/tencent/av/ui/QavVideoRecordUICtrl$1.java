package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.ui.funchat.record.FileSwapHelper;

class QavVideoRecordUICtrl$1
  implements Runnable
{
  QavVideoRecordUICtrl$1(QavVideoRecordUICtrl paramQavVideoRecordUICtrl) {}
  
  public void run()
  {
    QavVideoRecordUICtrl.a(this.this$0, this.this$0.a());
    QavVideoRecordUICtrl.b(this.this$0, FileSwapHelper.a());
    if (QavVideoRecordUICtrl.a(this.this$0) < 31457280L) {
      QavVideoRecordUICtrl.a(this.this$0).post(new QavVideoRecordUICtrl.1.1(this));
    }
    while (!QavVideoRecordUICtrl.b) {
      return;
    }
    QavVideoRecordUICtrl.a(this.this$0).sendEmptyMessageDelayed(11, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.QavVideoRecordUICtrl.1
 * JD-Core Version:    0.7.0.1
 */