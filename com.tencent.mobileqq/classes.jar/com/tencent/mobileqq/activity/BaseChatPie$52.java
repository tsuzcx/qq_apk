package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.res.Resources;
import bcql;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.XEditTextEx;

class BaseChatPie$52
  implements Runnable
{
  BaseChatPie$52(BaseChatPie paramBaseChatPie, boolean paramBoolean) {}
  
  public void run()
  {
    this.this$0.e(true);
    this.this$0.aV();
    this.this$0.m(0);
    this.this$0.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(true);
    if (this.a)
    {
      this.this$0.ad();
      return;
    }
    bcql.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131690022, 1).b(this.this$0.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.52
 * JD-Core Version:    0.7.0.1
 */