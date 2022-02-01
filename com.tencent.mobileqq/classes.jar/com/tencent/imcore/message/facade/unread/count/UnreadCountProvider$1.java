package com.tencent.imcore.message.facade.unread.count;

import java.util.ArrayList;

class UnreadCountProvider$1
  extends ArrayList<UnreadCountCalculateStrategy>
{
  UnreadCountProvider$1(UnreadCountProvider paramUnreadCountProvider)
  {
    add(new TroopNotificationUnreadCountCalculateStrategy());
    add(new ServiceAccountUnreadCountCalculateStrategy());
    add(new TencentDocsUnreadCountCalculateStrategy());
    add(new TroopSendHelperUnreadCountCalculateStrategy());
    add(new SubAccountUnreadCountCalculateStrategy());
    add(new GameMsgUnreadCountCalculateStrategy());
    add(new ShopAccountUnreadCountCalculateStrategy());
    add(new MsgCallbackUnreadCountCalculateStrategy());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.facade.unread.count.UnreadCountProvider.1
 * JD-Core Version:    0.7.0.1
 */