package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;

class PublicAccountChatPie$53
  implements Runnable
{
  PublicAccountChatPie$53(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void run()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (IWebProcessManagerService)((QQAppInterface)localObject).getRuntimeService(IWebProcessManagerService.class, "");
      if ((localObject != null) && (((IWebProcessManagerService)localObject).enablePreloadInBusiness(9))) {
        ((IWebProcessManagerService)localObject).startWebProcess(-1, new PublicAccountChatPie.53.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.53
 * JD-Core Version:    0.7.0.1
 */