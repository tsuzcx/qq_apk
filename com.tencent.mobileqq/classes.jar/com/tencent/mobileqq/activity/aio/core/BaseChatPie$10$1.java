package com.tencent.mobileqq.activity.aio.core;

import android.content.Context;
import android.content.res.Resources;
import android.widget.TextView;

class BaseChatPie$10$1
  implements Runnable
{
  BaseChatPie$10$1(BaseChatPie.10 param10) {}
  
  public void run()
  {
    if (this.this$1.this$0.shieldTV != null)
    {
      this.this$1.this$0.shieldTV.setText(this.this$1.this$0.mContext.getResources().getString(2131689957));
      this.this$1.this$0.shieldTV.setTag(Integer.valueOf(1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.10.1
 * JD-Core Version:    0.7.0.1
 */