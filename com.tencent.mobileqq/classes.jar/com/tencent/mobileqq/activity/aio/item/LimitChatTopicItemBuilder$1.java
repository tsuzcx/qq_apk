package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;

class LimitChatTopicItemBuilder$1
  implements Runnable
{
  LimitChatTopicItemBuilder$1(LimitChatTopicItemBuilder paramLimitChatTopicItemBuilder, LimitChatTopicItemBuilder.TopicViewHolder paramTopicViewHolder) {}
  
  public void run()
  {
    if ((this.this$0.a != null) && (this.a != null)) {
      ((ExtendFriendManager)this.this$0.a.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a(this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.LimitChatTopicItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */