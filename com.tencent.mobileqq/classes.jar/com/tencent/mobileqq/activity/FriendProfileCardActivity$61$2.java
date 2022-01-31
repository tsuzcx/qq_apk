package com.tencent.mobileqq.activity;

import abfm;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.qphone.base.util.QLog;

public class FriendProfileCardActivity$61$2
  implements Runnable
{
  public FriendProfileCardActivity$61$2(abfm paramabfm) {}
  
  public void run()
  {
    try
    {
      if (this.a.a.e == null) {
        return;
      }
      this.a.a.g();
      if (this.a.a.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView != null)
      {
        this.a.a.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.a.a.jdField_a_of_type_Auuw, false, new String[0]);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("FriendProfileCardActivity", 1, "onConfigUpdate fail.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.61.2
 * JD-Core Version:    0.7.0.1
 */