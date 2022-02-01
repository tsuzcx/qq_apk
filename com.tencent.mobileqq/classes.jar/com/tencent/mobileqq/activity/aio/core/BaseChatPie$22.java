package com.tencent.mobileqq.activity.aio.core;

import android.content.Intent;
import com.tencent.widget.XPanelContainer;
import mqq.os.MqqHandler;

class BaseChatPie$22
  implements Runnable
{
  BaseChatPie$22(BaseChatPie paramBaseChatPie, Intent paramIntent) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 1)
    {
      this.this$0.ax();
      this.this$0.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this, 100L);
      return;
    }
    this.a.removeExtra("KEY_SHOULD_SHOW_KEYBOARD");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.22
 * JD-Core Version:    0.7.0.1
 */