package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.XEditTextEx;

class BaseChatPie$45
  implements Runnable
{
  BaseChatPie$45(BaseChatPie paramBaseChatPie, boolean paramBoolean) {}
  
  public void run()
  {
    this.this$0.e(true);
    this.this$0.aT();
    this.this$0.n(0);
    this.this$0.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(true);
    if (this.a)
    {
      this.this$0.af();
      return;
    }
    QQToast.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131689972, 1).b(this.this$0.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.45
 * JD-Core Version:    0.7.0.1
 */