package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.database.Cursor;
import android.os.Handler.Callback;
import android.os.Message;
import android.widget.TextView;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.XListView;

class ChatHistory$1
  implements Handler.Callback
{
  ChatHistory$1(ChatHistory paramChatHistory) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 6: 
    case 4: 
    case 2: 
    case 0: 
    case 1: 
    case 7: 
    case 3: 
    case 5: 
    case 8: 
      do
      {
        do
        {
          do
          {
            return true;
            this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
          } while (!NetworkUtil.d(BaseApplication.getContext()));
          this.a.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.setVisibility(8);
          return true;
          this.a.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this.a, 2131755842);
          this.a.jdField_a_of_type_AndroidAppDialog.setContentView(2131562946);
          ((TextView)this.a.jdField_a_of_type_AndroidAppDialog.findViewById(2131365807)).setText(paramMessage.obj.toString());
          this.a.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(new ChatHistory.1.1(this));
          this.a.jdField_a_of_type_AndroidAppDialog.show();
          return true;
          this.a.i();
          return true;
          this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
          try
          {
            if ((this.a.jdField_a_of_type_AndroidAppDialog != null) && (this.a.jdField_a_of_type_AndroidAppDialog.isShowing())) {
              this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
            }
          }
          catch (IllegalArgumentException paramMessage)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.i("ChatHistory", 2, "tipsDialog dismiss " + paramMessage.getMessage());
              }
              this.a.jdField_a_of_type_AndroidAppDialog = null;
            }
          }
          catch (Exception paramMessage)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.i("ChatHistory", 2, "tipsDialog dismiss " + paramMessage.getMessage());
              }
              this.a.jdField_a_of_type_AndroidAppDialog = null;
            }
          }
          finally
          {
            this.a.jdField_a_of_type_AndroidAppDialog = null;
          }
          this.a.a(10, false);
          return true;
          this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
          if (this.a.jdField_a_of_type_AndroidAppDialog != null) {
            this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
          }
          this.a.a(2130839715, this.a.getString(2131692961));
          return true;
          this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
          if (this.a.jdField_a_of_type_AndroidAppDialog != null) {
            this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
          }
          this.a.a(2130839715, this.a.getString(2131692962));
          return true;
          this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
          if (this.a.jdField_a_of_type_AndroidAppDialog != null) {
            this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
          }
          this.a.a(2130839715, this.a.getString(2131719092));
          return true;
          this.a.a(2130839715, this.a.getString(2131691560));
          return true;
        } while (paramMessage.obj == null);
        paramMessage = (Cursor)paramMessage.obj;
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter != null)
        {
          if (this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.getCursor() != null) {
            this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.getCursor().deactivate();
          }
          this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.changeCursor(paramMessage);
        }
      } while ((this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.c < 0) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.c >= 8));
      this.a.jdField_a_of_type_ComTencentWidgetXListView.setSelection(this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.c + this.a.jdField_a_of_type_ComTencentWidgetXListView.getHeaderViewsCount());
      this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.c = -1;
      return true;
    case 9: 
      this.a.a(paramMessage.arg1, paramMessage.arg2);
      this.a.f();
      this.a.d();
      return true;
    case 10: 
      this.a.a(paramMessage.arg1, paramMessage.arg2);
      this.a.e();
      return true;
    case 11: 
      this.a.a(paramMessage.arg1, paramMessage.arg2);
      this.a.g();
      return true;
    case 12: 
      if (paramMessage.arg1 > 0) {
        this.a.a((String)paramMessage.obj);
      }
      for (;;)
      {
        ReportController.b(this.a.app, "CliOper", "", "", "0X800568F", "0X800568F", this.a.k, 0, "", "", "", "");
        return true;
        this.a.b(this.a.getString(2131690076));
      }
    }
    this.a.a(paramMessage.arg1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.1
 * JD-Core Version:    0.7.0.1
 */