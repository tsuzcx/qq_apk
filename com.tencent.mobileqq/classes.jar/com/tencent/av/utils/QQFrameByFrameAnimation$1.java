package com.tencent.av.utils;

import android.os.Handler;

class QQFrameByFrameAnimation$1
  implements Runnable
{
  QQFrameByFrameAnimation$1(QQFrameByFrameAnimation paramQQFrameByFrameAnimation) {}
  
  public void run()
  {
    if ((this.this$0.d > 0) && (this.this$0.c >= this.this$0.d)) {
      this.this$0.c();
    }
    do
    {
      do
      {
        return;
        if ((this.this$0.b > 0) && (this.this$0.c / this.this$0.jdField_a_of_type_ArrayOfInt.length >= this.this$0.b))
        {
          this.this$0.c();
          return;
        }
        this.this$0.a();
        this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(this, this.this$0.jdField_a_of_type_Int);
      } while (this.this$0.jdField_a_of_type_ComTencentAvUtilsQQAnimationListener == null);
      this.this$0.jdField_a_of_type_ComTencentAvUtilsQQAnimationListener.c();
    } while ((this.this$0.jdField_a_of_type_ArrayOfInt.length <= 0) || (this.this$0.c % this.this$0.jdField_a_of_type_ArrayOfInt.length != 0));
    this.this$0.jdField_a_of_type_ComTencentAvUtilsQQAnimationListener.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.utils.QQFrameByFrameAnimation.1
 * JD-Core Version:    0.7.0.1
 */