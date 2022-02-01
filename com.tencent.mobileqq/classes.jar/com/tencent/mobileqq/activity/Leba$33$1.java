package com.tencent.mobileqq.activity;

import android.widget.Button;
import android.widget.TextView;
import anvx;
import bgyd;
import blas;
import com.tencent.common.config.AppSetting;

class Leba$33$1
  implements Runnable
{
  Leba$33$1(Leba.33 param33, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int > 0)
    {
      if (Leba.c(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$33.this$0) != null) {
        Leba.c(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$33.this$0).setVisibility(0);
      }
      blas.a(Leba.c(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$33.this$0), 9, this.jdField_a_of_type_Int, 0);
      if (AppSetting.c) {
        bgyd.a(Leba.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$33.this$0), anvx.a(2131705493), Button.class.getName());
      }
    }
    do
    {
      return;
      if (Leba.c(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$33.this$0) != null) {
        Leba.c(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$33.this$0).setVisibility(8);
      }
    } while (!AppSetting.c);
    bgyd.a(Leba.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$33.this$0), anvx.a(2131719159), Button.class.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.33.1
 * JD-Core Version:    0.7.0.1
 */