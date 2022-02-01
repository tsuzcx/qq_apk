package com.tencent.mobileqq.activity.aio.core;

import android.content.Context;
import android.content.res.Resources;
import android.widget.TextView;

class BaseChatPie$9$2
  implements Runnable
{
  BaseChatPie$9$2(BaseChatPie.9 param9) {}
  
  public void run()
  {
    if (this.this$1.this$0.shieldTV != null)
    {
      this.this$1.this$0.shieldTV.setText(this.this$1.this$0.mContext.getResources().getString(2131689987));
      this.this$1.this$0.shieldTV.setTag(Integer.valueOf(2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.9.2
 * JD-Core Version:    0.7.0.1
 */