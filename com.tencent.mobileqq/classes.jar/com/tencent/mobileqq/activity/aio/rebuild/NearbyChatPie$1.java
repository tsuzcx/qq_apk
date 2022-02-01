package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.StringUtil;

class NearbyChatPie$1
  implements Runnable
{
  NearbyChatPie$1(NearbyChatPie paramNearbyChatPie) {}
  
  public void run()
  {
    try
    {
      if ((((FriendsManager)this.this$0.d.getManager(QQManagerFactory.FRIENDS_MANAGER)).f(this.this$0.ah.b) == null) && (StringUtil.verifyUin(this.this$0.ah.b)))
      {
        ((CardHandler)this.this$0.d.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(this.this$0.d.getCurrentAccountUin(), this.this$0.ah.b, (byte)1, 0);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.1
 * JD-Core Version:    0.7.0.1
 */