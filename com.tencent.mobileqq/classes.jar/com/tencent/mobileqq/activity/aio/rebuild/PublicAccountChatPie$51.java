package com.tencent.mobileqq.activity.aio.rebuild;

import aert;
import aetd;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webprocess.WebProcessManager;

public class PublicAccountChatPie$51
  implements Runnable
{
  public PublicAccountChatPie$51(aert paramaert) {}
  
  public void run()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (WebProcessManager)((QQAppInterface)localObject).getManager(13);
      if ((localObject != null) && (((WebProcessManager)localObject).e())) {
        ((WebProcessManager)localObject).a(-1, new aetd(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.51
 * JD-Core Version:    0.7.0.1
 */