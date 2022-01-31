package com.tencent.mobileqq.activity;

import android.widget.TextView;
import bhvv;

class Leba$36$1
  implements Runnable
{
  Leba$36$1(Leba.36 param36, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int > 0)
    {
      if (Leba.c(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$36.this$0) != null) {
        Leba.c(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$36.this$0).setVisibility(0);
      }
      bhvv.a(Leba.c(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$36.this$0), 9, this.jdField_a_of_type_Int, 0);
    }
    while (Leba.c(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$36.this$0) == null) {
      return;
    }
    Leba.c(this.jdField_a_of_type_ComTencentMobileqqActivityLeba$36.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.36.1
 * JD-Core Version:    0.7.0.1
 */