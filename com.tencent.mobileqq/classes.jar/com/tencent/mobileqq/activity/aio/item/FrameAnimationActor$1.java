package com.tencent.mobileqq.activity.aio.item;

import android.view.View;

class FrameAnimationActor$1
  implements Runnable
{
  public void run()
  {
    if (this.this$0.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    if ((this.this$0.jdField_a_of_type_Int == 0) && (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioItemFrameAnimationActor$Listener != null)) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioItemFrameAnimationActor$Listener.a();
    }
    if (this.this$0.jdField_a_of_type_Int >= this.this$0.jdField_a_of_type_ArrayOfInt.length)
    {
      this.this$0.jdField_a_of_type_AndroidViewView.setBackgroundResource(this.this$0.jdField_a_of_type_ArrayOfInt[this.this$0.b]);
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioItemFrameAnimationActor$Listener != null) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioItemFrameAnimationActor$Listener.b();
      }
      return;
    }
    this.this$0.jdField_a_of_type_AndroidViewView.setBackgroundResource(this.this$0.jdField_a_of_type_ArrayOfInt[this.this$0.jdField_a_of_type_Int]);
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioItemFrameAnimationActor$Listener != null) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioItemFrameAnimationActor$Listener.a(this.this$0.jdField_a_of_type_Int);
    }
    this.this$0.jdField_a_of_type_AndroidViewView.postDelayed(FrameAnimationActor.a(this.this$0), this.this$0.c);
    FrameAnimationActor localFrameAnimationActor = this.this$0;
    localFrameAnimationActor.jdField_a_of_type_Int += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.FrameAnimationActor.1
 * JD-Core Version:    0.7.0.1
 */