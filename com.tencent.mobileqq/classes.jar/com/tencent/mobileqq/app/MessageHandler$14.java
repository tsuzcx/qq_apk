package com.tencent.mobileqq.app;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.qphone.base.util.QLog;

class MessageHandler$14
  extends FriendListObserver
{
  MessageHandler$14(MessageHandler paramMessageHandler) {}
  
  protected void onUpdateAnswerAddedFriend(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateAnswerAddedFriend isSuccess = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", uin = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", flag = ");
      localStringBuilder.append(paramInt);
      QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
    }
    if (paramBoolean) {
      this.a.a.getMessageFacade().k();
    }
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateFriendList isSuccess = ");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(", isComplete = ");
      localStringBuilder.append(paramBoolean2);
      QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
    }
    if ((paramBoolean1) && (paramBoolean2)) {
      this.a.a.getMessageFacade().k();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageHandler.14
 * JD-Core Version:    0.7.0.1
 */