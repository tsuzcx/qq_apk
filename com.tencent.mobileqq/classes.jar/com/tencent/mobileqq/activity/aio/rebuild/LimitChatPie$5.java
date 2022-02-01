package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.LimitMsgLoader;
import com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils;
import com.tencent.mobileqq.qroute.QRoute;

class LimitChatPie$5
  implements Runnable
{
  LimitChatPie$5(LimitChatPie paramLimitChatPie, String paramString1, String paramString2) {}
  
  public void run()
  {
    ((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).addGrayTipsMessage(this.this$0.d, this.this$0.ah.b, this.this$0.ah.a, this.this$0.ah.e, this.a, 3342339, this.b, 36, ((LimitMsgLoader)LimitChatPie.a(this.this$0).c()).b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.5
 * JD-Core Version:    0.7.0.1
 */