package com.tencent.mobileqq.activity.history;

import android.app.Activity;
import com.tencent.mobileqq.activity.ChatSettingActivity.DeleteHistoryListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;

class ChatHistoryC2CSettingFragment$1
  implements ChatSettingActivity.DeleteHistoryListener
{
  ChatHistoryC2CSettingFragment$1(ChatHistoryC2CSettingFragment paramChatHistoryC2CSettingFragment) {}
  
  public void a(Activity paramActivity)
  {
    QQToast.makeText(paramActivity, 2, 2131888442, 0).show(this.a.getBaseActivity().getTitleBarHeight());
    paramActivity.setResult(-1);
    paramActivity.finish();
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramInt == 0)
    {
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800A17D", "0X800A17D", 2, 0, "", "", "", "");
      return;
    }
    if (paramInt == 1) {
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800A17F", "0X800A17F", 2, 0, "", "", "", "");
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramInt == 0)
    {
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800A17E", "0X800A17E", 2, 0, "", "", "", "");
      return;
    }
    if (paramInt == 1) {
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800A180", "0X800A180", 2, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CSettingFragment.1
 * JD-Core Version:    0.7.0.1
 */