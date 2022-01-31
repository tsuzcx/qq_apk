package com.tencent.mobileqq.apollo.lightGame;

import android.os.Message;
import bhow;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;

public class CmGameLoadingView$ProgressTimerTask
  extends TimerTask
{
  private float a;
  
  public CmGameLoadingView$ProgressTimerTask(CmGameLoadingView paramCmGameLoadingView, float paramFloat)
  {
    this.a = paramFloat;
  }
  
  public void run()
  {
    CmGameLoadingView.a(this.this$0, CmGameLoadingView.a(this.this$0) + 0.01F);
    if ((CmGameLoadingView.a(this.this$0) > this.a) || (CmGameLoadingView.a(this.this$0)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CmGameLoadingView", 2, new Object[] { "ProgressTimerTask progress has arrival end:", Float.valueOf(this.a) });
      }
      this.this$0.c();
      return;
    }
    Message localMessage = CmGameLoadingView.a(this.this$0).obtainMessage(5);
    localMessage.obj = Float.valueOf(CmGameLoadingView.a(this.this$0));
    CmGameLoadingView.a(this.this$0).removeMessages(5);
    CmGameLoadingView.a(this.this$0).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.lightGame.CmGameLoadingView.ProgressTimerTask
 * JD-Core Version:    0.7.0.1
 */