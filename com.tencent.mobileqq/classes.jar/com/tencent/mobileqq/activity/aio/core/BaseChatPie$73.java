package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.apollo.api.script.ISpriteCommFunc;
import com.tencent.mobileqq.qroute.QRoute;

class BaseChatPie$73
  implements Runnable
{
  BaseChatPie$73(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    this.this$0.ar();
    ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.this$0.a, "receipt_msg", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.73
 * JD-Core Version:    0.7.0.1
 */