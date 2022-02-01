package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import mqq.os.MqqHandler;

class NotificationActivity$MyDialogClickListener
  implements DialogInterface.OnClickListener
{
  private int jdField_a_of_type_Int;
  
  public NotificationActivity$MyDialogClickListener(NotificationActivity paramNotificationActivity, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 0) {
      if (this.jdField_a_of_type_Int == 1) {
        NotificationActivity.access$1900(this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity);
      }
    }
    while (paramInt != 1)
    {
      NotificationActivity.access$1500(this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity).sendEmptyMessage(4);
      do
      {
        return;
      } while (this.jdField_a_of_type_Int != 2);
      NotificationActivity.access$1700(this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity, NotificationActivity.access$1600(this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity));
      return;
    }
    NotificationActivity.access$2000(this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity.MyDialogClickListener
 * JD-Core Version:    0.7.0.1
 */