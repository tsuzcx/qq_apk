package com.tencent.mobileqq.activity.recent.msgbox;

import com.tencent.imcore.message.ConversationFacade;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;

class TempMsgBoxManager$1
  extends FriendListObserver
{
  TempMsgBoxManager$1(TempMsgBoxManager paramTempMsgBoxManager) {}
  
  public void onAddFriend(String paramString)
  {
    TempMsgBoxManager.a(this.a).getConversationFacade().d(String.valueOf(paramString), 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxManager.1
 * JD-Core Version:    0.7.0.1
 */