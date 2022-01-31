package com.tencent.mobileqq.activity.aio.rebuild;

import aemd;
import android.text.Editable;
import android.text.SpannableString;
import axqy;
import bafv;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;

public class BaseTroopChatPie$5
  implements Runnable
{
  public BaseTroopChatPie$5(aemd paramaemd, boolean paramBoolean, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    int i;
    if (this.jdField_a_of_type_Boolean)
    {
      i = this.this$0.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart();
      this.this$0.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().delete(i - 1, i);
    }
    SpannableString localSpannableString = bafv.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, this.this$0.E(), this.this$0.jdField_a_of_type_ComTencentWidgetXEditTextEx, true);
    if ((localSpannableString == null) || (localSpannableString.length() == 0)) {}
    do
    {
      return;
      int j = this.this$0.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart();
      i = j;
      if (j < 0) {
        i = 0;
      }
      this.this$0.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().insert(i, localSpannableString);
      aemd.a(this.this$0).a(1);
      if (this.jdField_a_of_type_Int == 1)
      {
        axqy.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Press_AIOhead_sendatmsg", 0, 0, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        return;
      }
    } while (this.jdField_a_of_type_Int != 4);
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("0")))
    {
      axqy.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_atallmber_sendatallmsg", 0, 0, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      return;
    }
    axqy.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Input_atmber_sendatmsg", 0, 0, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.BaseTroopChatPie.5
 * JD-Core Version:    0.7.0.1
 */