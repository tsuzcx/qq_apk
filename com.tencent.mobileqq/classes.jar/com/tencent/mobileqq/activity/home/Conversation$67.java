package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.activity.ConversationTitleBtnCtrl;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendObserver;

class Conversation$67
  extends ExtendFriendObserver
{
  Conversation$67(Conversation paramConversation) {}
  
  public void onUpdateMatchChatConfig(boolean paramBoolean)
  {
    if (this.a.a != null) {
      this.a.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.67
 * JD-Core Version:    0.7.0.1
 */