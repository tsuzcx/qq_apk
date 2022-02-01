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
    Object localObject = this.this$0;
    String str = ((QBaseActivity)localObject).getString(2131694975);
    int i = 0;
    if (SettingCloneUtil.readValue((Context)localObject, null, str, "qqsetting_screenshot_key", false)) {
      i = 1;
    }
    if (i != 0) {
      this.this$0.turnOnShake();
    }
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_OFF");
    ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_ON");
    QBaseActivity.access$002(QBaseActivity.access$100().a());
    try
    {
      this.this$0.getApplicationContext().registerReceiver(QBaseActivity.access$000(), (IntentFilter)localObject);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("qqBaseActivity", 1, "", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.QBaseActivity.1
 * JD-Core Version:    0.7.0.1
 */