package com.tencent.av.smallscreen;

import com.tencent.av.VideoController;
import lid;
import mbw;
import meu;

public class SmallScreenVideoController$3
  implements Runnable
{
  public SmallScreenVideoController$3(mbw parammbw, long paramLong) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentAvVideoController == null) {
      break label10;
    }
    label10:
    while (this.this$0.jdField_a_of_type_ComTencentAvVideoController.a() == null) {
      return;
    }
    int i;
    if (this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().b())
    {
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.a(this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString, 226);
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.b(226);
      i = this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.b(this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString, 21);
      if (i != 1) {
        break label290;
      }
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().a(this.a, "small.onResume.1", 3);
      label143:
      if (!this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().c()) {
        break label318;
      }
    }
    label290:
    label318:
    for (this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().i = 1;; this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().i = 3000)
    {
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().b(this.a, false);
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().b("SmallScreen.onResume", 0);
      if ((this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().k) && (this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().ax) && (this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().R > 0)) {
        mbw.a(this.this$0);
      }
      if (this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 2) {
        break;
      }
      this.this$0.jdField_a_of_type_Meu.d();
      return;
      if (i != 2) {
        break label143;
      }
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().a(this.a, "small.onResume.2", 4);
      break label143;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoController.3
 * JD-Core Version:    0.7.0.1
 */