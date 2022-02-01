package com.tencent.mobileqq.activity;

import NS_QQ_STORY_META.META.StStoryFeed;
import android.util.Base64;
import com.tencent.mobileqq.activity.aio.BeancurdManager;
import com.tencent.mobileqq.activity.aio.BeancurdMsg;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;

final class ChatActivityFacade$9
  implements Runnable
{
  ChatActivityFacade$9(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, META.StStoryFeed paramStStoryFeed) {}
  
  public void run()
  {
    BeancurdManager localBeancurdManager;
    BeancurdMsg localBeancurdMsg;
    if (ChatActivityFacade.f(this.a, this.b, false))
    {
      localBeancurdManager = (BeancurdManager)this.a.getManager(QQManagerFactory.BEANCURD_MANAGER);
      localBeancurdMsg = new BeancurdMsg();
    }
    try
    {
      localBeancurdMsg.buffer = Base64.encodeToString(this.c.toByteArray(), 0);
      localBeancurdMsg.busiid = 7;
      localBeancurdMsg.frienduin = this.b.b;
      localBeancurdMsg.isNeedDelHistory = true;
      localBeancurdMsg.ispush = true;
      localBeancurdMsg.startTime = MessageCache.c();
      localBeancurdMsg.validTime = 604800L;
      localBeancurdManager.a(localBeancurdMsg);
      return;
    }
    catch (Exception localException)
    {
      label100:
      break label100;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ChatActivityFacade.byte encode to String", 2, "encode error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.9
 * JD-Core Version:    0.7.0.1
 */