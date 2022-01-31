package com.tencent.mobileqq.activity.aio.item;

import adfc;
import adfd;
import android.view.View;

public class FrameAnimationActor$1
  implements Runnable
{
  public void run()
  {
    if (this.this$0.jdField_a_of_type_AndroidViewView == null) {}
    do
    {
      return;
      if ((this.this$0.jdField_a_of_type_Int == 0) && (this.this$0.jdField_a_of_type_Adfd != null)) {
        this.this$0.jdField_a_of_type_Adfd.a();
      }
      if (this.this$0.jdField_a_of_type_Int < this.this$0.jdField_a_of_type_ArrayOfInt.length) {
        break;
      }
      this.this$0.jdField_a_of_type_AndroidViewView.setBackgroundResource(this.this$0.jdField_a_of_type_ArrayOfInt[this.this$0.b]);
    } while (this.this$0.jdField_a_of_type_Adfd == null);
    this.this$0.jdField_a_of_type_Adfd.b();
    return;
    this.this$0.jdField_a_of_type_AndroidViewView.setBackgroundResource(this.this$0.jdField_a_of_type_ArrayOfInt[this.this$0.jdField_a_of_type_Int]);
    if (this.this$0.jdField_a_of_type_Adfd != null) {
      this.this$0.jdField_a_of_type_Adfd.a(this.this$0.jdField_a_of_type_Int);
    }
    this.this$0.jdField_a_of_type_AndroidViewView.postDelayed(adfc.a(this.this$0), this.this$0.c);
    adfc localadfc = this.this$0;
    localadfc.jdField_a_of_type_Int += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.FrameAnimationActor.1
 * JD-Core Version:    0.7.0.1
 */