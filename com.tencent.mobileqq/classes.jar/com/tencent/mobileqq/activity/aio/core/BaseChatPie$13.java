package com.tencent.mobileqq.activity.aio.core;

import android.content.Intent;
import com.tencent.mobileqq.activity.aio.ForwardUtils;

class BaseChatPie$13
  implements Runnable
{
  BaseChatPie$13(BaseChatPie paramBaseChatPie, Intent paramIntent) {}
  
  public void run()
  {
    ForwardUtils.handleAppShareAction(this.this$0.app, this.this$0.mContext, this.this$0.sessionInfo, this.val$intent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.13
 * JD-Core Version:    0.7.0.1
 */