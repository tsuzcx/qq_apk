package com.tencent.mobileqq.activity.aio.rebuild;

import admh;
import aidd;
import anri;
import anvk;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.utils.StringUtil;

public class NearbyChatPie$1
  implements Runnable
{
  public NearbyChatPie$1(aidd paramaidd) {}
  
  public void run()
  {
    try
    {
      Card localCard = ((anvk)this.this$0.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.this$0.sessionInfo.curFriendUin);
      if (localCard == null)
      {
        if (StringUtil.verifyUin(this.this$0.sessionInfo.curFriendUin)) {
          ((anri)this.this$0.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(this.this$0.app.getCurrentAccountUin(), this.this$0.sessionInfo.curFriendUin, (byte)1, 0);
        }
      }
      else if ((localCard != null) && (localCard.strCertificationInfo != null) && (!localCard.strCertificationInfo.equals("")))
      {
        admh.f(this.this$0.app, this.this$0.sessionInfo);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.1
 * JD-Core Version:    0.7.0.1
 */