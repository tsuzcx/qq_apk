package com.tencent.av.ui;

import com.tencent.av.VideoController;
import lid;
import meu;

class AVActivity$12
  implements Runnable
{
  AVActivity$12(AVActivity paramAVActivity, long paramLong) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentAvVideoController == null) {}
    lid locallid;
    do
    {
      return;
      locallid = this.this$0.jdField_a_of_type_ComTencentAvVideoController.a();
    } while (!locallid.b());
    this.this$0.jdField_a_of_type_ComTencentAvVideoController.a(locallid.jdField_d_of_type_JavaLangString, 229);
    this.this$0.jdField_a_of_type_ComTencentAvVideoController.b(229);
    int i = locallid.jdField_d_of_type_Int;
    this.this$0.jdField_a_of_type_ComTencentAvVideoController.b(locallid.jdField_d_of_type_JavaLangString, 21);
    if (i == 1)
    {
      locallid.a(this.a, "av.onResume.1", 3);
      if (!locallid.c()) {
        break label158;
      }
    }
    label158:
    for (locallid.i = 1;; locallid.i = 3000)
    {
      locallid.b(this.a, false);
      locallid.b("AVActivity.onResume", 0);
      this.this$0.jdField_a_of_type_Meu.a(this.a);
      return;
      if (i != 2) {
        break;
      }
      locallid.a(this.a, "av.onResume.2", 4);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.12
 * JD-Core Version:    0.7.0.1
 */