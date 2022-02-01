package com.tencent.mobileqq.activity.aio.core;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StrangerHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;
import java.util.List;

class BaseChatPie$10
  implements ActionSheet.OnButtonClickListener
{
  BaseChatPie$10(BaseChatPie paramBaseChatPie, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      do
      {
        for (;;)
        {
          return;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "Manage_stranger", "Manage_str_delete", 0, 0, "", "", "", "");
          ReportController.b(null, "dc00898", "", "", "0X800ACA3", "0X800ACA3", 0, 0, "", "0", "0", "");
          paramView = (StrangerHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.STRANGER_HANDLER);
          ArrayList localArrayList = new ArrayList();
          try
          {
            localArrayList.add(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a())));
            paramView.a(localArrayList);
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c == null) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, 0);
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.show();
          }
          catch (NumberFormatException paramView) {}
        }
      } while (!QLog.isColorLevel());
      QLog.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b, 2, "delete Stranger parseLong() error", paramView);
      return;
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, QQBrowserActivity.class);
      paramView.putExtra("url", "https://ti.qq.com/friends/unidirection?_wv=2&_wwv=128&tuin=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(paramView);
      ReportController.b(null, "dc00898", "", "", "0X800ACA4", "0X800ACA4", 0, 0, "", "0", "0", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.10
 * JD-Core Version:    0.7.0.1
 */