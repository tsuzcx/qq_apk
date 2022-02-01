package com.tencent.mobileqq.activity.recent.data;

import com.tencent.mobileqq.activity.aio.tips.PubAccountTips;
import com.tencent.mobileqq.activity.aio.tips.PubAccountTips.PubAccountTipsMsg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;

class RecentItemPublicAccountChatMsgData$1
  implements Runnable
{
  RecentItemPublicAccountChatMsgData$1(RecentItemPublicAccountChatMsgData paramRecentItemPublicAccountChatMsgData, QQAppInterface paramQQAppInterface, PubAccountTips.PubAccountTipsMsg paramPubAccountTipsMsg) {}
  
  public void run()
  {
    PubAccountTips.a(this.a, this.this$0.mUser.uin, this.b, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountChatMsgData.1
 * JD-Core Version:    0.7.0.1
 */