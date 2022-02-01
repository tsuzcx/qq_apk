package com.tencent.av.ui;

import android.content.IntentFilter;
import com.tencent.qphone.base.util.QLog;

class AVActivity$5
  implements Runnable
{
  AVActivity$5(AVActivity paramAVActivity) {}
  
  public void run()
  {
    try
    {
      this.this$0.W = new AVActivity.MyBroadCastReceiver(this.this$0);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
      this.this$0.registerReceiver(this.this$0.W, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.i, 2, "Exception", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.5
 * JD-Core Version:    0.7.0.1
 */