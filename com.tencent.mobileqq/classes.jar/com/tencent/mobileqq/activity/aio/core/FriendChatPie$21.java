package com.tencent.mobileqq.activity.aio.core;

import acnf;
import acnh;
import afrc;
import agab;
import android.os.SystemClock;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.RefreshMessageContext;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

public class FriendChatPie$21
  implements Runnable
{
  public FriendChatPie$21(agab paramagab) {}
  
  public void run()
  {
    if (!acnh.c(this.this$0.app.getMessageProxy(this.this$0.sessionInfo.curType).f(this.this$0.sessionInfo.curFriendUin, this.this$0.sessionInfo.curType))) {}
    do
    {
      return;
      this.this$0.pullReqTime = SystemClock.uptimeMillis();
      ((afrc)this.this$0.refreshMessageContext.context).a(this.this$0.pullReqTime);
      this.this$0.refreshMessageContext.needAutoNavigateTop = false;
      this.this$0.refreshMessageContext.needNotifyUI = true;
    } while (this.this$0.refreshMessageContext.repullStickerMsgIndex != 0);
    QQMessageFacade.RefreshMessageContext localRefreshMessageContext = this.this$0.refreshMessageContext;
    localRefreshMessageContext.repullStickerMsgIndex += 1;
    this.this$0.app.getMessageFacade().refreshMessageListHead(this.this$0.sessionInfo.curFriendUin, this.this$0.sessionInfo.curType, 15, this.this$0.refreshMessageContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.21
 * JD-Core Version:    0.7.0.1
 */