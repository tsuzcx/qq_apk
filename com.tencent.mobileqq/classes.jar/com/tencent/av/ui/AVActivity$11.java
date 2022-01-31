package com.tencent.av.ui;

import com.tencent.av.VideoController;
import lga;
import mcf;

class AVActivity$11
  implements Runnable
{
  AVActivity$11(AVActivity paramAVActivity, long paramLong) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentAvVideoController == null) {}
    lga locallga;
    do
    {
      return;
      locallga = this.this$0.jdField_a_of_type_ComTencentAvVideoController.a();
    } while (!locallga.a());
    this.this$0.jdField_a_of_type_ComTencentAvVideoController.a(locallga.jdField_d_of_type_JavaLangString, 229);
    this.this$0.jdField_a_of_type_ComTencentAvVideoController.b(229);
    int i = locallga.jdField_d_of_type_Int;
    this.this$0.jdField_a_of_type_ComTencentAvVideoController.b(locallga.jdField_d_of_type_JavaLangString, 21);
    if (i == 1)
    {
      locallga.a(this.a, "av.onResume.1", 3);
      if (!locallga.b()) {
        break label156;
      }
    }
    label156:
    for (locallga.i = 1;; locallga.i = 3000)
    {
      locallga.b(this.a, false);
      locallga.D = 0;
      this.this$0.jdField_a_of_type_Mcf.a(this.a);
      return;
      if (i != 2) {
        break;
      }
      locallga.a(this.a, "av.onResume.2", 4);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.11
 * JD-Core Version:    0.7.0.1
 */