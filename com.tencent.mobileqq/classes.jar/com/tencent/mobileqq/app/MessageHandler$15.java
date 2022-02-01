package com.tencent.mobileqq.app;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.qphone.base.util.QLog;

class MessageHandler$15
  extends FriendListObserver
{
  MessageHandler$15(MessageHandler paramMessageHandler) {}
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if ((paramBoolean1) && (paramBoolean2) && (paramBoolean3) && (!TextUtils.isEmpty(paramString))) {
      this.a.a.getMessageFacade().k();
    }
  }
  
  protected void onUpdateAnswerAddedFriend(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "onUpdateAnswerAddedFriend isSuccess = " + paramBoolean + ", uin = " + paramString + ", flag = " + paramInt);
    }
    if (paramBoolean) {
      this.a.a.getMessageFacade().k();
    }
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "onUpdateFriendList isSuccess = " + paramBoolean1 + ", isComplete = " + paramBoolean2);
    }
    if ((paramBoolean1) && (paramBoolean2)) {
      this.a.a.getMessageFacade().k();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageHandler.15
 * JD-Core Version:    0.7.0.1
 */