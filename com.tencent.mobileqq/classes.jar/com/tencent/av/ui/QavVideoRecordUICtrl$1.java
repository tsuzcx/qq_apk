package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.ui.funchat.record.FileSwapHelper;

class QavVideoRecordUICtrl$1
  implements Runnable
{
  QavVideoRecordUICtrl$1(QavVideoRecordUICtrl paramQavVideoRecordUICtrl) {}
  
  public void run()
  {
    QavVideoRecordUICtrl localQavVideoRecordUICtrl = this.this$0;
    QavVideoRecordUICtrl.a(localQavVideoRecordUICtrl, localQavVideoRecordUICtrl.a());
    QavVideoRecordUICtrl.b(this.this$0, FileSwapHelper.a());
    if (QavVideoRecordUICtrl.a(this.this$0) < 31457280L)
    {
      QavVideoRecordUICtrl.a(this.this$0).post(new QavVideoRecordUICtrl.1.1(this));
      return;
    }
    if (QavVideoRecordUICtrl.b) {
      QavVideoRecordUICtrl.a(this.this$0).sendEmptyMessageDelayed(11, 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavVideoRecordUICtrl.1
 * JD-Core Version:    0.7.0.1
 */