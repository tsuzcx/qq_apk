package com.tencent.mobileqq.activity;

import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;

class ChatSettingActivity$5
  implements ChatSettingActivity.DeleteHistoryListener
{
  ChatSettingActivity$5(ChatSettingActivity paramChatSettingActivity) {}
  
  public void a(Activity paramActivity)
  {
    QQToast.makeText(this.a, 2, 2131888442, 0).show(this.a.getTitleBarHeight());
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramInt == 0)
    {
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800A17D", "0X800A17D", 1, 0, "", "", "", "");
      return;
    }
    if (paramInt == 1) {
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800A17F", "0X800A17F", 1, 0, "", "", "", "");
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramInt == 0)
    {
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800A17E", "0X800A17E", 1, 0, "", "", "", "");
      return;
    }
    if (paramInt == 1) {
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800A180", "0X800A180", 1, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity.5
 * JD-Core Version:    0.7.0.1
 */