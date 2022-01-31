package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

class DoubleVideoCtrlUI$StartTimerRunnable
  implements Runnable
{
  long a;
  
  DoubleVideoCtrlUI$StartTimerRunnable(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  void a(long paramLong)
  {
    this.a = paramLong;
    this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.this$0.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable, 5000L);
    this.this$0.c = true;
  }
  
  void b(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.this$0.d, 1, "StartTimerRunnable.remove, mNeedRemoveAudioCallback[" + this.this$0.c + "], seq[" + paramLong + "], lastseq[" + this.a + "]");
    }
    if (this.this$0.c) {
      this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.this$0.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI$StartTimerRunnable);
    }
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.this$0.d, 1, "StartTimerRunnable.Run, seq[" + this.a + "]");
    }
    this.this$0.A(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.StartTimerRunnable
 * JD-Core Version:    0.7.0.1
 */