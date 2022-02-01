package com.tencent.mobileqq.activity.aio.core;

import android.text.Editable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.widget.XEditTextEx;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

class BaseChatPie$47
  implements Runnable
{
  BaseChatPie$47(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    int i = this.this$0.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length();
    if ((BaseChatPie.a(this.this$0) == i) && (BaseChatPie.b(this.this$0) != 1)) {
      BaseChatPie.c(this.this$0);
    }
    while (BaseChatPie.d(this.this$0) <= BaseChatPie.e(this.this$0))
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendMsgSignal();
      BaseChatPie.f(this.this$0);
      ThreadManager.getSubThreadHandler().postDelayed(BaseChatPie.a(this.this$0), 2000L);
      return;
      BaseChatPie.a(this.this$0, i);
      BaseChatPie.b(this.this$0, 0);
    }
    BaseChatPie.a(this.this$0, false);
    BaseChatPie.c(this.this$0, 50);
    BaseChatPie.b(this.this$0, 0);
    BaseChatPie.d(this.this$0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.47
 * JD-Core Version:    0.7.0.1
 */