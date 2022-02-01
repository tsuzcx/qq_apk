package com.tencent.mobileqq.activity.aio.core;

import android.text.Editable;
import android.text.SpannableString;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;

class BaseTroopChatPie$5
  implements Runnable
{
  BaseTroopChatPie$5(BaseTroopChatPie paramBaseTroopChatPie, boolean paramBoolean, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    int i;
    if (this.jdField_a_of_type_Boolean)
    {
      i = this.this$0.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart();
      this.this$0.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().delete(i - 1, i);
    }
    Object localObject = AtTroopMemberSpan.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, this.this$0.u(), this.this$0.jdField_a_of_type_ComTencentWidgetXEditTextEx, true);
    if (localObject != null)
    {
      if (((SpannableString)localObject).length() == 0) {
        return;
      }
      int j = this.this$0.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart();
      i = j;
      if (j < 0) {
        i = 0;
      }
      this.this$0.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().insert(i, (CharSequence)localObject);
      this.this$0.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
      i = this.jdField_a_of_type_Int;
      if (i == 1)
      {
        ReportController.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Press_AIOhead_sendatmsg", 0, 0, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        return;
      }
      if (i == 4)
      {
        localObject = this.jdField_a_of_type_JavaLangString;
        if ((localObject != null) && (((String)localObject).equalsIgnoreCase("0")))
        {
          ReportController.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_atallmber_sendatallmsg", 0, 0, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          return;
        }
        ReportController.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Input_atmber_sendatmsg", 0, 0, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseTroopChatPie.5
 * JD-Core Version:    0.7.0.1
 */