package android.support.v4.app;

import android.os.Handler;
import android.os.Message;

class QFragmentActivity$1
  extends Handler
{
  QFragmentActivity$1(QFragmentActivity paramQFragmentActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      super.handleMessage(paramMessage);
    case 1: 
      do
      {
        return;
      } while (!this.this$0.mStopped);
      this.this$0.doReallyStop(false);
      return;
    }
    this.this$0.onResumeFragments();
    this.this$0.mFragments.execPendingActions();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     android.support.v4.app.QFragmentActivity.1
 * JD-Core Version:    0.7.0.1
 */