package com.tencent.av.ui;

import android.content.res.Resources;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class MultiVideoEnterPageActivity$TimeoutRunnable
  implements Runnable
{
  MultiVideoEnterPageActivity$TimeoutRunnable(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      String str = this.this$0.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("TimeoutRunnable, mHaveMoreRoom[");
      localStringBuilder.append(this.this$0.jdField_a_of_type_Boolean);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    QQToast.a(this.this$0, 2131695680, 1).b(MultiVideoEnterPageActivity.d(this.this$0).getDimensionPixelSize(2131299168));
    if (!this.this$0.jdField_a_of_type_Boolean)
    {
      this.this$0.b();
      this.this$0.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoEnterPageActivity.TimeoutRunnable
 * JD-Core Version:    0.7.0.1
 */