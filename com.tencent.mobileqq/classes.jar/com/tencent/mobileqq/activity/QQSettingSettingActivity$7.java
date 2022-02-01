package com.tencent.mobileqq.activity;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Date;

class QQSettingSettingActivity$7
  implements Runnable
{
  QQSettingSettingActivity$7(QQSettingSettingActivity paramQQSettingSettingActivity) {}
  
  public void run()
  {
    Object localObject = this.this$0.getSharedPreferences("sp_qs_settings", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qsec_status_update_last_time");
    localStringBuilder.append(this.this$0.app.getCurrentAccountUin());
    long l1 = ((SharedPreferences)localObject).getLong(localStringBuilder.toString(), 0L);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("qsec_status_expired_time");
    localStringBuilder.append(this.this$0.app.getCurrentAccountUin());
    long l2 = ((SharedPreferences)localObject).getLong(localStringBuilder.toString(), 3600L);
    if (new Date().getTime() - l1 <= l2 * 1000L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("qsec_status_tip_text");
      localStringBuilder.append(this.this$0.app.getCurrentAccountUin());
      localObject = ((SharedPreferences)localObject).getString(localStringBuilder.toString(), "");
      this.this$0.runOnUiThread(new QQSettingSettingActivity.7.1(this, (String)localObject));
      return;
    }
    QQSettingSettingActivity.e(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingSettingActivity.7
 * JD-Core Version:    0.7.0.1
 */