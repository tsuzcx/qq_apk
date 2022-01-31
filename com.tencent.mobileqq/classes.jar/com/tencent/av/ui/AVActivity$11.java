package com.tencent.av.ui;

import com.tencent.av.VideoController;
import lgf;
import mck;

class AVActivity$11
  implements Runnable
{
  AVActivity$11(AVActivity paramAVActivity, long paramLong) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentAvVideoController == null) {}
    lgf locallgf;
    do
    {
      return;
      locallgf = this.this$0.jdField_a_of_type_ComTencentAvVideoController.a();
    } while (!locallgf.a());
    this.this$0.jdField_a_of_type_ComTencentAvVideoController.a(locallgf.jdField_d_of_type_JavaLangString, 229);
    this.this$0.jdField_a_of_type_ComTencentAvVideoController.b(229);
    int i = locallgf.jdField_d_of_type_Int;
    this.this$0.jdField_a_of_type_ComTencentAvVideoController.b(locallgf.jdField_d_of_type_JavaLangString, 21);
    if (i == 1)
    {
      locallgf.a(this.a, "av.onResume.1", 3);
      if (!locallgf.b()) {
        break label156;
      }
    }
    label156:
    for (locallgf.i = 1;; locallgf.i = 3000)
    {
      locallgf.b(this.a, false);
      locallgf.D = 0;
      this.this$0.jdField_a_of_type_Mck.a(this.a);
      return;
      if (i != 2) {
        break;
      }
      locallgf.a(this.a, "av.onResume.2", 4);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.11
 * JD-Core Version:    0.7.0.1
 */