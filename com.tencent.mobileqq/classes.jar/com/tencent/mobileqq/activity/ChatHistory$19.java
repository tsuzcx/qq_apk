package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

class ChatHistory$19
  implements DialogInterface.OnClickListener
{
  ChatHistory$19(ChatHistory paramChatHistory) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      this.a.h();
      ReportController.b(this.a.app, "CliOper", "", "", "AIO", "AIO_chatlog_lately", 0, 0, "", "", "", "");
      return;
    }
    this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
    this.a.jdField_c_of_type_AndroidAppDialog.dismiss();
    if (this.a.jdField_a_of_type_AndroidAppDialog != null) {
      this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    this.a.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.setVisibility(0);
    this.a.jdField_c_of_type_AndroidWidgetTextView.setText(this.a.getString(2131692183));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.19
 * JD-Core Version:    0.7.0.1
 */