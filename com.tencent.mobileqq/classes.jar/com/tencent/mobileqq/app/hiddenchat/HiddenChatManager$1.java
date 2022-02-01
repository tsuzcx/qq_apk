package com.tencent.mobileqq.app.hiddenchat;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.statistics.ReportController;

class HiddenChatManager$1
  implements DialogInterface.OnClickListener
{
  HiddenChatManager$1(HiddenChatManager paramHiddenChatManager, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("back_for_hidden_chat", true);
    paramDialogInterface.setFlags(603979776);
    HiddenChatFragment.a(this.jdField_a_of_type_AndroidAppActivity, 3, 0, paramDialogInterface);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppHiddenchatHiddenChatManager.a, "dc00898", "", "", "0X800A34A", "0X800A34A", 0, 0, "0", "0", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.hiddenchat.HiddenChatManager.1
 * JD-Core Version:    0.7.0.1
 */