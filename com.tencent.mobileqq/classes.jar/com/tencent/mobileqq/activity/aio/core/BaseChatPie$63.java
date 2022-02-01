package com.tencent.mobileqq.activity.aio.core;

import android.text.Editable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.widget.XEditTextEx;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

class BaseChatPie$63
  implements Runnable
{
  BaseChatPie$63(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    int i = this.this$0.input.getText().length();
    if ((BaseChatPie.access$1800(this.this$0) == i) && (BaseChatPie.access$1900(this.this$0) != 1)) {
      BaseChatPie.access$2008(this.this$0);
    }
    while (BaseChatPie.access$2000(this.this$0) <= BaseChatPie.access$2100(this.this$0))
    {
      this.this$0.app.sendMsgSignal();
      BaseChatPie.access$1908(this.this$0);
      ThreadManager.getSubThreadHandler().postDelayed(BaseChatPie.access$2200(this.this$0), 2000L);
      return;
      BaseChatPie.access$1802(this.this$0, i);
      BaseChatPie.access$2002(this.this$0, 0);
    }
    BaseChatPie.access$2302(this.this$0, false);
    BaseChatPie.access$1902(this.this$0, 50);
    BaseChatPie.access$2002(this.this$0, 0);
    BaseChatPie.access$2402(this.this$0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.63
 * JD-Core Version:    0.7.0.1
 */