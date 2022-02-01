package com.tencent.av.ui;

import com.tencent.av.VideoController;
import ley;
import mbx;

class AVActivity$12
  implements Runnable
{
  AVActivity$12(AVActivity paramAVActivity, long paramLong) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentAvVideoController == null) {}
    ley localley;
    do
    {
      return;
      localley = this.this$0.jdField_a_of_type_ComTencentAvVideoController.a();
    } while (!localley.b());
    this.this$0.jdField_a_of_type_ComTencentAvVideoController.a(localley.jdField_d_of_type_JavaLangString, 229);
    this.this$0.jdField_a_of_type_ComTencentAvVideoController.b(229);
    int i = localley.jdField_d_of_type_Int;
    this.this$0.jdField_a_of_type_ComTencentAvVideoController.b(localley.jdField_d_of_type_JavaLangString, 21);
    if (i == 1)
    {
      localley.a(this.a, "av.onResume.1", 3);
      if (!localley.c()) {
        break label158;
      }
    }
    label158:
    for (localley.j = 1;; localley.j = 3000)
    {
      localley.b(this.a, false);
      localley.c("AVActivity.onResume", 0);
      this.this$0.jdField_a_of_type_Mbx.a(this.a);
      return;
      if (i != 2) {
        break;
      }
      localley.a(this.a, "av.onResume.2", 4);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.12
 * JD-Core Version:    0.7.0.1
 */