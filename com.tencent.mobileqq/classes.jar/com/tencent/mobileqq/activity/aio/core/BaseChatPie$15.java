package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.activity.aio.helper.FullScreenInputHelper;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.widget.XEditTextEx;

class BaseChatPie$15
  implements Runnable
{
  BaseChatPie$15(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    if (ZhituManager.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.this$0.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText())) {
      this.this$0.y();
    }
    ((FullScreenInputHelper)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(24)).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.15
 * JD-Core Version:    0.7.0.1
 */