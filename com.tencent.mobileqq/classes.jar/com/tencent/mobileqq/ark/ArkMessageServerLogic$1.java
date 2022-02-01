package com.tencent.mobileqq.ark;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ark.api.IArkService;
import mqq.app.AppRuntime;

final class ArkMessageServerLogic$1
  implements Runnable
{
  ArkMessageServerLogic$1(ArkMessageServerLogic.IRequestArkAppListHandler paramIRequestArkAppListHandler) {}
  
  public void run()
  {
    Object localObject = ((IArkService)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IArkService.class, "all")).getSSO();
    if (localObject == null)
    {
      ArkAppCenter.a("ArkApp.ArkMessageServerLogic", "requestArkAppManagerPanelList, ark sso is null");
    }
    else
    {
      if (((IArkAppSSO)localObject).a("ArkAppPanel.List", 10000, 0, new ArkMessageServerLogic.1.1(this))) {
        return;
      }
      ArkAppCenter.a("ArkApp.ArkMessageServerLogic", "requestArkAppManagerPanelList, fail send sso request");
    }
    localObject = this.a;
    if (localObject != null) {
      ((ArkMessageServerLogic.IRequestArkAppListHandler)localObject).b(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkMessageServerLogic.1
 * JD-Core Version:    0.7.0.1
 */