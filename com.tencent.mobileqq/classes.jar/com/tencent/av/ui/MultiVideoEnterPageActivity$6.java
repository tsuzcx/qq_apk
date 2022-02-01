package com.tencent.av.ui;

import bhnv;
import com.tencent.av.VideoController;

class MultiVideoEnterPageActivity$6
  implements Runnable
{
  MultiVideoEnterPageActivity$6(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity) {}
  
  public void run()
  {
    if ((bhnv.a(this.this$0) == 0) && (!this.this$0.jdField_a_of_type_Boolean))
    {
      this.this$0.finish();
      MultiVideoEnterPageActivity.a(this.this$0, 0, 2130772140);
      if (this.this$0.jdField_a_of_type_ComTencentAvVideoController != null) {
        this.this$0.jdField_a_of_type_ComTencentAvVideoController.a(this.this$0.c, this.this$0.jdField_a_of_type_Long, 22, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoEnterPageActivity.6
 * JD-Core Version:    0.7.0.1
 */