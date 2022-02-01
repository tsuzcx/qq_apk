package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.QLog;

class QBaseActivity$1
  implements Runnable
{
  QBaseActivity$1(QBaseActivity paramQBaseActivity) {}
  
  public void run()
  {
    int i = 0;
    if (!SettingCloneUtil.readValue(this.this$0, null, this.this$0.getString(2131694985), "qqsetting_screenshot_key", false)) {}
    for (;;)
    {
      if (i != 0) {
        this.this$0.turnOnShake();
      }
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      QBaseActivity.access$002(QBaseActivity.access$100().a());
      try
      {
        this.this$0.getApplicationContext().registerReceiver(QBaseActivity.access$000(), localIntentFilter);
        return;
      }
      catch (Exception localException)
      {
        QLog.e("qqBaseActivity", 1, "", localException);
      }
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.QBaseActivity.1
 * JD-Core Version:    0.7.0.1
 */