package com.tencent.mobileqq.activity;

import android.widget.Button;
import android.widget.TextView;
import anzj;
import bhga;
import blkk;
import com.tencent.common.config.AppSetting;

class Leba$35$1
  implements Runnable
{
  Leba$35$1(Leba.35 param35, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int > 0)
    {
      if (Leba.c(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$35.this$0) != null) {
        Leba.c(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$35.this$0).setVisibility(0);
      }
      blkk.a(Leba.c(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$35.this$0), 9, this.jdField_a_of_type_Int, 0);
      if (AppSetting.c) {
        bhga.a(Leba.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$35.this$0), anzj.a(2131704912), Button.class.getName());
      }
    }
    do
    {
      return;
      if (Leba.c(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$35.this$0) != null) {
        Leba.c(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$35.this$0).setVisibility(8);
      }
    } while (!AppSetting.c);
    bhga.a(Leba.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$35.this$0), anzj.a(2131718521), Button.class.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.35.1
 * JD-Core Version:    0.7.0.1
 */