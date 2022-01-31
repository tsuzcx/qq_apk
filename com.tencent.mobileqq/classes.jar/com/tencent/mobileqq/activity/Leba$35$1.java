package com.tencent.mobileqq.activity;

import abai;
import android.widget.TextView;
import beih;

class Leba$35$1
  implements Runnable
{
  Leba$35$1(Leba.35 param35, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int > 0)
    {
      if (abai.c(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$35.this$0) != null) {
        abai.c(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$35.this$0).setVisibility(0);
      }
      beih.a(abai.c(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$35.this$0), 9, this.jdField_a_of_type_Int, 0);
      beih.a(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$35.this$0.a(), abai.c(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$35.this$0), 9);
    }
    while (abai.c(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$35.this$0) == null) {
      return;
    }
    abai.c(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$35.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.35.1
 * JD-Core Version:    0.7.0.1
 */