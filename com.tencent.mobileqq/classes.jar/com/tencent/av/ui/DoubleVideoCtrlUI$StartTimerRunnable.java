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
    this.this$0.al.a().postDelayed(this.this$0.o, 5000L);
    this.this$0.d = true;
  }
  
  void b(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      String str = this.this$0.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("StartTimerRunnable.remove, mNeedRemoveAudioCallback[");
      localStringBuilder.append(this.this$0.d);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], lastseq[");
      localStringBuilder.append(this.a);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (this.this$0.d) {
      this.this$0.al.a().removeCallbacks(this.this$0.o);
    }
  }
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      String str = this.this$0.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("StartTimerRunnable.Run, seq[");
      localStringBuilder.append(this.a);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    this.this$0.G(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.StartTimerRunnable
 * JD-Core Version:    0.7.0.1
 */