package com.tencent.av.ui;

import com.tencent.av.VideoController;
import kvq;
import lru;

class AVActivity$11
  implements Runnable
{
  AVActivity$11(AVActivity paramAVActivity, long paramLong) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentAvVideoController == null) {}
    kvq localkvq;
    do
    {
      return;
      localkvq = this.this$0.jdField_a_of_type_ComTencentAvVideoController.a();
    } while (!localkvq.a());
    this.this$0.jdField_a_of_type_ComTencentAvVideoController.a(localkvq.jdField_d_of_type_JavaLangString, 229);
    this.this$0.jdField_a_of_type_ComTencentAvVideoController.b(229);
    int i = localkvq.jdField_d_of_type_Int;
    this.this$0.jdField_a_of_type_ComTencentAvVideoController.b(localkvq.jdField_d_of_type_JavaLangString, 21);
    if (i == 1)
    {
      localkvq.a(this.a, "av.onResume.1", 3);
      if (!localkvq.b()) {
        break label156;
      }
    }
    label156:
    for (localkvq.i = 1;; localkvq.i = 3000)
    {
      localkvq.b(this.a, false);
      localkvq.B = 0;
      this.this$0.jdField_a_of_type_Lru.a(this.a);
      return;
      if (i != 2) {
        break;
      }
      localkvq.a(this.a, "av.onResume.2", 4);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.11
 * JD-Core Version:    0.7.0.1
 */