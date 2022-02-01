package com.tencent.mobileqq.app;

import anvi;
import aoqy;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Set;

class QQAppInterface$9
  extends anvi
{
  QQAppInterface$9(QQAppInterface paramQQAppInterface) {}
  
  public void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface_friendListObserver", 2, "onUpdateFriendInfo uin:" + paramString + ",isSuccess:" + paramBoolean);
    }
    if (this.this$0.friendInfoQueue.contains(paramString))
    {
      if ((this.this$0.msgFacade.msgNotifyManager.a() == 1) && (paramString != null) && (paramString.equals(((QQMessageFacade.Message)this.this$0.msgFacade.msgNotifyManager.a().get(0)).frienduin)) && (this.this$0.isBackgroundPause) && (this.this$0.isShowMsgContent()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQAppInterface_friendListObserver", 2, "update notifcation");
        }
        QQAppInterface.access$2500(this.this$0, (QQMessageFacade.Message)this.this$0.msgFacade.msgNotifyManager.a().get(0), false);
      }
      this.this$0.friendInfoQueue.remove(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface_friendListObserver", 2, "removeObserver");
    }
    this.this$0.removeObserver(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.9
 * JD-Core Version:    0.7.0.1
 */