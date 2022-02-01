package com.tencent.mobileqq.activity.aio.core;

import android.content.Intent;
import com.tencent.widget.XPanelContainer;
import mqq.os.MqqHandler;

class BaseChatPie$11
  implements Runnable
{
  BaseChatPie$11(BaseChatPie paramBaseChatPie, Intent paramIntent) {}
  
  public void run()
  {
    if (this.this$0.n.getCurrentPanel() != 1)
    {
      this.this$0.aF();
      this.this$0.m.postDelayed(this, 100L);
      return;
    }
    this.a.removeExtra("KEY_SHOULD_SHOW_KEYBOARD");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.11
 * JD-Core Version:    0.7.0.1
 */