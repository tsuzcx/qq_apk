package com.tencent.mobileqq.activity.aio.rebuild;

import acvv;
import ahik;
import amov;
import amsw;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.utils.StringUtil;

public class NearbyChatPie$1
  implements Runnable
{
  public NearbyChatPie$1(ahik paramahik) {}
  
  public void run()
  {
    try
    {
      Card localCard = ((amsw)this.this$0.app.getManager(51)).b(this.this$0.sessionInfo.curFriendUin);
      if (localCard == null)
      {
        if (StringUtil.verifyUin(this.this$0.sessionInfo.curFriendUin)) {
          ((amov)this.this$0.app.getBusinessHandler(2)).a(this.this$0.app.getCurrentAccountUin(), this.this$0.sessionInfo.curFriendUin, (byte)1, 0);
        }
      }
      else if ((localCard != null) && (localCard.strCertificationInfo != null) && (!localCard.strCertificationInfo.equals("")))
      {
        acvv.f(this.this$0.app, this.this$0.sessionInfo);
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