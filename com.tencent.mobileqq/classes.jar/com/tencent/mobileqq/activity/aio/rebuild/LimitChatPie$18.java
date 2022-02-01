package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;

class LimitChatPie$18
  implements DialogInterface.OnClickListener
{
  LimitChatPie$18(LimitChatPie paramLimitChatPie) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    com.tencent.mobileqq.activity.aio.AIOUtils.o = true;
    PlusPanelUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true, null, null);
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800ADC9", "0X800ADC9", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.18
 * JD-Core Version:    0.7.0.1
 */