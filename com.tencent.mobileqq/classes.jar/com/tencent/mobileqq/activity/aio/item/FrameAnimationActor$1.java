package com.tencent.mobileqq.activity.aio.item;

import afmw;
import afmx;
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
      if ((this.this$0.jdField_a_of_type_Int == 0) && (this.this$0.jdField_a_of_type_Afmx != null)) {
        this.this$0.jdField_a_of_type_Afmx.a();
      }
      if (this.this$0.jdField_a_of_type_Int < this.this$0.jdField_a_of_type_ArrayOfInt.length) {
        break;
      }
      this.this$0.jdField_a_of_type_AndroidViewView.setBackgroundResource(this.this$0.jdField_a_of_type_ArrayOfInt[this.this$0.b]);
    } while (this.this$0.jdField_a_of_type_Afmx == null);
    this.this$0.jdField_a_of_type_Afmx.b();
    return;
    this.this$0.jdField_a_of_type_AndroidViewView.setBackgroundResource(this.this$0.jdField_a_of_type_ArrayOfInt[this.this$0.jdField_a_of_type_Int]);
    if (this.this$0.jdField_a_of_type_Afmx != null) {
      this.this$0.jdField_a_of_type_Afmx.a(this.this$0.jdField_a_of_type_Int);
    }
    this.this$0.jdField_a_of_type_AndroidViewView.postDelayed(afmw.a(this.this$0), this.this$0.c);
    afmw localafmw = this.this$0;
    localafmw.jdField_a_of_type_Int += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.FrameAnimationActor.1
 * JD-Core Version:    0.7.0.1
 */