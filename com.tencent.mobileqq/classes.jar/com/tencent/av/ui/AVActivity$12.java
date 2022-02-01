package com.tencent.av.ui;

import com.tencent.av.VideoController;
import lfe;
import mcx;

class AVActivity$12
  implements Runnable
{
  AVActivity$12(AVActivity paramAVActivity, long paramLong) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentAvVideoController == null) {}
    lfe locallfe;
    do
    {
      return;
      locallfe = this.this$0.jdField_a_of_type_ComTencentAvVideoController.a();
    } while (!locallfe.b());
    this.this$0.jdField_a_of_type_ComTencentAvVideoController.a(locallfe.jdField_d_of_type_JavaLangString, 229);
    this.this$0.jdField_a_of_type_ComTencentAvVideoController.b(229);
    int i = locallfe.jdField_d_of_type_Int;
    this.this$0.jdField_a_of_type_ComTencentAvVideoController.b(locallfe.jdField_d_of_type_JavaLangString, 21);
    if (i == 1)
    {
      locallfe.a(this.a, "av.onResume.1", 3);
      if (!locallfe.c()) {
        break label158;
      }
    }
    label158:
    for (locallfe.j = 1;; locallfe.j = 3000)
    {
      locallfe.b(this.a, false);
      locallfe.c("AVActivity.onResume", 0);
      this.this$0.jdField_a_of_type_Mcx.a(this.a);
      return;
      if (i != 2) {
        break;
      }
      locallfe.a(this.a, "av.onResume.2", 4);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.12
 * JD-Core Version:    0.7.0.1
 */