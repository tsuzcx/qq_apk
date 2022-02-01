package com.tencent.av.ui;

import com.tencent.av.VideoController;
import lff;
import mct;

class AVActivity$12
  implements Runnable
{
  AVActivity$12(AVActivity paramAVActivity, long paramLong) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentAvVideoController == null) {}
    lff locallff;
    do
    {
      return;
      locallff = this.this$0.jdField_a_of_type_ComTencentAvVideoController.a();
    } while (!locallff.b());
    this.this$0.jdField_a_of_type_ComTencentAvVideoController.a(locallff.jdField_d_of_type_JavaLangString, 229);
    this.this$0.jdField_a_of_type_ComTencentAvVideoController.b(229);
    int i = locallff.jdField_d_of_type_Int;
    this.this$0.jdField_a_of_type_ComTencentAvVideoController.b(locallff.jdField_d_of_type_JavaLangString, 21);
    if (i == 1)
    {
      locallff.a(this.a, "av.onResume.1", 3);
      if (!locallff.c()) {
        break label158;
      }
    }
    label158:
    for (locallff.j = 1;; locallff.j = 3000)
    {
      locallff.b(this.a, false);
      locallff.c("AVActivity.onResume", 0);
      this.this$0.jdField_a_of_type_Mct.a(this.a);
      return;
      if (i != 2) {
        break;
      }
      locallff.a(this.a, "av.onResume.2", 4);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.12
 * JD-Core Version:    0.7.0.1
 */