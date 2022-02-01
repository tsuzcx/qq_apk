package com.tencent.av.ui;

import com.tencent.av.VideoController;
import lez;
import mcc;

class AVActivity$12
  implements Runnable
{
  AVActivity$12(AVActivity paramAVActivity, long paramLong) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentAvVideoController == null) {}
    lez locallez;
    do
    {
      return;
      locallez = this.this$0.jdField_a_of_type_ComTencentAvVideoController.a();
    } while (!locallez.b());
    this.this$0.jdField_a_of_type_ComTencentAvVideoController.a(locallez.jdField_d_of_type_JavaLangString, 229);
    this.this$0.jdField_a_of_type_ComTencentAvVideoController.b(229);
    int i = locallez.jdField_d_of_type_Int;
    this.this$0.jdField_a_of_type_ComTencentAvVideoController.b(locallez.jdField_d_of_type_JavaLangString, 21);
    if (i == 1)
    {
      locallez.a(this.a, "av.onResume.1", 3);
      if (!locallez.c()) {
        break label158;
      }
    }
    label158:
    for (locallez.j = 1;; locallez.j = 3000)
    {
      locallez.b(this.a, false);
      locallez.c("AVActivity.onResume", 0);
      this.this$0.jdField_a_of_type_Mcc.a(this.a);
      return;
      if (i != 2) {
        break;
      }
      locallez.a(this.a, "av.onResume.2", 4);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.12
 * JD-Core Version:    0.7.0.1
 */