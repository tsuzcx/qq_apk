package com.tencent.mobileqq.activity.aio.coreui.msglist;

import android.os.SystemClock;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.RefreshMessageContext;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.ChatContext;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.app.QQAppInterface;

class FriendListUI$1
  implements Runnable
{
  FriendListUI$1(FriendListUI paramFriendListUI) {}
  
  public void run()
  {
    BaseSessionInfo localBaseSessionInfo = this.this$0.b.O();
    if (!UinTypeUtil.a(this.this$0.b.a().getMessageProxy(localBaseSessionInfo.a).g(localBaseSessionInfo.b, localBaseSessionInfo.a))) {
      return;
    }
    this.this$0.i = SystemClock.uptimeMillis();
    ((ChatContext)this.this$0.h.a).a(this.this$0.i);
    this.this$0.h.g = false;
    this.this$0.h.h = true;
    if (this.this$0.h.n == 0)
    {
      RefreshMessageContext localRefreshMessageContext = this.this$0.h;
      localRefreshMessageContext.n += 1;
      this.this$0.b.a().getMessageFacade().a(localBaseSessionInfo.b, localBaseSessionInfo.a, 15, this.this$0.h);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.FriendListUI.1
 * JD-Core Version:    0.7.0.1
 */