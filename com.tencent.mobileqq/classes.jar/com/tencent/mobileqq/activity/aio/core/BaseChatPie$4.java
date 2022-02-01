package com.tencent.mobileqq.activity.aio.core;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.LocalCrashCollector;
import com.tencent.widget.XEditTextEx;

class BaseChatPie$4
  implements View.OnLongClickListener
{
  BaseChatPie$4(BaseChatPie paramBaseChatPie) {}
  
  public boolean onLongClick(View paramView)
  {
    if ("//findcrash".equals(this.this$0.input.getText().toString())) {
      ThreadManager.post(new LocalCrashCollector(this.this$0), 8, null, true);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.4
 * JD-Core Version:    0.7.0.1
 */