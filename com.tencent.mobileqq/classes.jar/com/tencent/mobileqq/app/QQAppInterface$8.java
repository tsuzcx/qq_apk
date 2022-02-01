package com.tencent.mobileqq.app;

import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Set;

class QQAppInterface$8
  extends FriendListObserver
{
  QQAppInterface$8(QQAppInterface paramQQAppInterface) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUpdateFriendInfo uin:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",isSuccess:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("QQAppInterface_friendListObserver", 2, ((StringBuilder)localObject).toString());
    }
    if (this.this$0.friendInfoQueue.contains(paramString))
    {
      if ((this.this$0.msgFacade.a.a() == 1) && (paramString != null) && (paramString.equals(((Message)this.this$0.msgFacade.a.a().get(0)).frienduin)) && (this.this$0.isBackgroundPause) && (this.this$0.isShowMsgContent()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQAppInterface_friendListObserver", 2, "update notifcation");
        }
        localObject = this.this$0;
        QQAppInterface.access$1900((QQAppInterface)localObject, (Message)((QQAppInterface)localObject).msgFacade.a.a().get(0), false);
      }
      this.this$0.friendInfoQueue.remove(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface_friendListObserver", 2, "removeObserver");
    }
    this.this$0.removeObserver(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.8
 * JD-Core Version:    0.7.0.1
 */