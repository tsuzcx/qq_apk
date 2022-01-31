package com.tencent.av.ui;

import android.content.res.Resources;
import bbmy;
import com.tencent.qphone.base.util.QLog;

class MultiVideoEnterPageActivity$TimeoutRunnable
  implements Runnable
{
  MultiVideoEnterPageActivity$TimeoutRunnable(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.this$0.jdField_a_of_type_JavaLangString, 1, "TimeoutRunnable, mHaveMoreRoom[" + this.this$0.jdField_a_of_type_Boolean + "]");
    }
    bbmy.a(this.this$0, 2131630289, 1).b(MultiVideoEnterPageActivity.d(this.this$0).getDimensionPixelSize(2131167766));
    if (!this.this$0.jdField_a_of_type_Boolean)
    {
      this.this$0.b();
      this.this$0.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoEnterPageActivity.TimeoutRunnable
 * JD-Core Version:    0.7.0.1
 */