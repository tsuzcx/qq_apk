package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import mqq.os.MqqHandler;

class ChatSettingActivity$16
  implements ActionSheet.OnButtonClickListener
{
  ChatSettingActivity$16(ChatSettingActivity paramChatSettingActivity, String paramString, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.superDismiss();
      return;
      if (NetworkUtil.d(BaseApplication.getContext()))
      {
        ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).delFriend(this.jdField_a_of_type_JavaLangString, (byte)2);
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity.app.getHandler(ChatActivity.class);
        if (paramView != null)
        {
          paramView.removeMessages(16711681);
          paramView.sendMessage(paramView.obtainMessage(16711681, this.jdField_a_of_type_JavaLangString));
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity.app, "CliOper", "", "", "AIO", "AIO_delete_frd", 0, 0, "", "", "", "");
        if (Utils.b(this.jdField_a_of_type_JavaLangString)) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity.app, "dc00898", "", "", "0X8007FDF", "0X8007FDF", 0, 0, "", "", "", "");
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity.finish();
      }
      else
      {
        ChatSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity, 2131691543, 1);
        continue;
        if (Utils.b(this.jdField_a_of_type_JavaLangString)) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity.app, "dc00898", "", "", "0X8007FE0", "0X8007FE0", 0, 0, "", "", "", "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity.16
 * JD-Core Version:    0.7.0.1
 */