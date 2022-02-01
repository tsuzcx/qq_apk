package com.tencent.av.ui;

import android.content.IntentFilter;
import com.tencent.qphone.base.util.QLog;

class AVActivity$4
  implements Runnable
{
  AVActivity$4(AVActivity paramAVActivity) {}
  
  public void run()
  {
    try
    {
      this.this$0.a = new AVActivity.MyBroadCastReceiver(this.this$0);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
      this.this$0.registerReceiver(this.this$0.a, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(this.this$0.b, 2, "Exception", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.4
 * JD-Core Version:    0.7.0.1
 */