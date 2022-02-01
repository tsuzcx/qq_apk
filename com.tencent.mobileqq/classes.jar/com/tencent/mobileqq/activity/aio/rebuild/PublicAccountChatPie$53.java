package com.tencent.mobileqq.activity.aio.rebuild;

import aido;
import aiey;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.webprocess.WebProcessManager;

public class PublicAccountChatPie$53
  implements Runnable
{
  public PublicAccountChatPie$53(aido paramaido) {}
  
  public void run()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (WebProcessManager)((QQAppInterface)localObject).getManager(QQManagerFactory.WEBPROCESS_MANAGER);
      if ((localObject != null) && (((WebProcessManager)localObject).e())) {
        ((WebProcessManager)localObject).a(-1, new aiey(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.53
 * JD-Core Version:    0.7.0.1
 */