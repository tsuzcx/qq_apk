package com.tencent.mobileqq.activity;

import android.content.Intent;
import com.tencent.widget.XPanelContainer;
import mqq.os.MqqHandler;

class BaseChatPie$24
  implements Runnable
{
  BaseChatPie$24(BaseChatPie paramBaseChatPie, Intent paramIntent) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 1)
    {
      this.this$0.aB();
      this.this$0.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this, 100L);
      return;
    }
    this.a.removeExtra("KEY_SHOULD_SHOW_KEYBOARD");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.24
 * JD-Core Version:    0.7.0.1
 */