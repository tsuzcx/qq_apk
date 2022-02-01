package com.tencent.mobileqq.app;

import com.tencent.mobileqq.flashchat.FlashChatManager;

class QIMNewFriendManager$1
  implements Runnable
{
  QIMNewFriendManager$1(QIMNewFriendManager paramQIMNewFriendManager, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    ((FlashChatManager)this.a.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.QIMNewFriendManager.1
 * JD-Core Version:    0.7.0.1
 */