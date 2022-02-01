package com.tencent.mobileqq.activity.aio.rebuild;

import aibs;
import anwd;
import bfxw;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;

public class HotChatPie$16
  implements Runnable
{
  public HotChatPie$16(aibs paramaibs, HotChatInfo paramHotChatInfo) {}
  
  public void run()
  {
    if (aibs.e(this.this$0) == null) {
      aibs.b(this.this$0, new bfxw(this.this$0.app, this.this$0.mActivity, this.this$0.sessionInfo, aibs.b(this.this$0), aibs.b(this.this$0), this.this$0.mTroopTips, aibs.b(this.this$0), null));
    }
    anwd localanwd = (anwd)this.this$0.app.getBusinessHandler(BusinessHandlerFactory.HOT_CHAT_HANDLER);
    if (this.a.userCreate == 1) {
      localanwd.a(this.a.troopUin);
    }
    while (this.a.uuid == null) {
      return;
    }
    localanwd.a(this.a.uuid.getBytes(), this.a.troopUin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.16
 * JD-Core Version:    0.7.0.1
 */