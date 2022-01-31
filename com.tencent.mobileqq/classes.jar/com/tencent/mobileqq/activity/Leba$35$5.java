package com.tencent.mobileqq.activity;

import abai;
import android.widget.TextView;
import beih;
import com.tencent.qphone.base.util.QLog;

class Leba$35$5
  implements Runnable
{
  Leba$35$5(Leba.35 param35, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_Int != -1)
      {
        if (abai.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$35.this$0) != null) {
          abai.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$35.this$0).setVisibility(0);
        }
        beih.a(abai.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$35.this$0), this.jdField_a_of_type_Int, this.b, 0);
        beih.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$35.this$0.a(), abai.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$35.this$0), this.jdField_a_of_type_Int);
        if (abai.b(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$35.this$0) != null) {
          abai.b(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$35.this$0).setVisibility(8);
        }
      }
      else if (abai.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$35.this$0) != null)
      {
        abai.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$35.this$0).setVisibility(8);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("Leba", 1, "updateQZoneRedFlag" + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.35.5
 * JD-Core Version:    0.7.0.1
 */