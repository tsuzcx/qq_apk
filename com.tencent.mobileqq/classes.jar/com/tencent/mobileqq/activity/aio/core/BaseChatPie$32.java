package com.tencent.mobileqq.activity.aio.core;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.XEditTextEx;

class BaseChatPie$32
  implements Runnable
{
  BaseChatPie$32(BaseChatPie paramBaseChatPie, boolean paramBoolean) {}
  
  public void run()
  {
    this.this$0.d(true);
    this.this$0.aN();
    this.this$0.l(0);
    this.this$0.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(true);
    if (this.a)
    {
      this.this$0.ab();
      return;
    }
    QQToast.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131690061, 1).b(this.this$0.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.32
 * JD-Core Version:    0.7.0.1
 */