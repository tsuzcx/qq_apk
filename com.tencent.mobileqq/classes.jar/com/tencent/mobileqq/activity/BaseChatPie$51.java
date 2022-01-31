package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.XEditTextEx;

class BaseChatPie$51
  implements Runnable
{
  BaseChatPie$51(BaseChatPie paramBaseChatPie, boolean paramBoolean) {}
  
  public void run()
  {
    this.this$0.e(true);
    this.this$0.aX();
    this.this$0.m(0);
    this.this$0.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(true);
    if (this.a)
    {
      this.this$0.af();
      return;
    }
    QQToast.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131690069, 1).b(this.this$0.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.51
 * JD-Core Version:    0.7.0.1
 */