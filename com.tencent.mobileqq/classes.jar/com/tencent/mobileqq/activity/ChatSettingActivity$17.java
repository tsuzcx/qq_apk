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

class ChatSettingActivity$17
  implements ActionSheet.OnButtonClickListener
{
  ChatSettingActivity$17(ChatSettingActivity paramChatSettingActivity, String paramString, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if ((paramInt == 1) && (Utils.c(this.a))) {
        ReportController.b(this.c.app, "dc00898", "", "", "0X8007FE0", "0X8007FE0", 0, 0, "", "", "", "");
      }
    }
    else if (NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      ((FriendListHandler)this.c.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).delFriend(this.a, (byte)2);
      paramView = this.c.app.getHandler(ChatActivity.class);
      if (paramView != null)
      {
        paramView.removeMessages(16711681);
        paramView.sendMessage(paramView.obtainMessage(16711681, this.a));
      }
      ReportController.b(this.c.app, "CliOper", "", "", "AIO", "AIO_delete_frd", 0, 0, "", "", "", "");
      if (Utils.c(this.a)) {
        ReportController.b(this.c.app, "dc00898", "", "", "0X8007FDF", "0X8007FDF", 0, 0, "", "", "", "");
      }
      this.c.finish();
    }
    else
    {
      ChatSettingActivity.a(this.c, 2131888422, 1);
    }
    this.b.superDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity.17
 * JD-Core Version:    0.7.0.1
 */