package com.tencent.mobileqq.activity;

import android.widget.TextView;
import bhvv;
import com.tencent.qphone.base.util.QLog;

class Leba$36$5
  implements Runnable
{
  Leba$36$5(Leba.36 param36, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_Int != -1)
      {
        if (Leba.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$36.this$0) != null) {
          Leba.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$36.this$0).setVisibility(0);
        }
        bhvv.a(Leba.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$36.this$0), this.jdField_a_of_type_Int, this.b, 0);
        bhvv.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$36.this$0.a(), Leba.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$36.this$0), this.jdField_a_of_type_Int, Leba.d(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$36.this$0));
        if (Leba.b(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$36.this$0) != null) {
          Leba.b(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$36.this$0).setVisibility(8);
        }
      }
      else if (Leba.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$36.this$0) != null)
      {
        Leba.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$36.this$0).setVisibility(8);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("Leba", 1, "updateQZoneRedFlag" + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.36.5
 * JD-Core Version:    0.7.0.1
 */