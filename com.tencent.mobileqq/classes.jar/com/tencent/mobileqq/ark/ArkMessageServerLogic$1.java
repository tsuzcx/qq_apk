package com.tencent.mobileqq.ark;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

final class ArkMessageServerLogic$1
  implements Runnable
{
  ArkMessageServerLogic$1(ArkMessageServerLogic.IRequestArkAppListHandler paramIRequestArkAppListHandler) {}
  
  public void run()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (localObject == null) {
      ArkAppCenter.c("ArkApp.ArkMessageServerLogic", "requestArkAppManagerPanelList, qq app is null");
    }
    for (;;)
    {
      if (this.a != null) {
        this.a.b(null);
      }
      do
      {
        return;
        localObject = (ArkAppCenter)((QQAppInterface)localObject).getManager(QQManagerFactory.ARK_APP_CENTER_MANAGER);
        if (localObject == null)
        {
          ArkAppCenter.c("ArkApp.ArkMessageServerLogic", "requestArkAppManagerPanelList, ark center is null");
          break;
        }
        localObject = ((ArkAppCenter)localObject).a();
        if (localObject == null)
        {
          ArkAppCenter.c("ArkApp.ArkMessageServerLogic", "requestArkAppManagerPanelList, ark sso is null");
          break;
        }
      } while (((ArkAppSSO)localObject).a("ArkAppPanel.List", 10000, 0, new ArkMessageServerLogic.1.1(this)));
      ArkAppCenter.c("ArkApp.ArkMessageServerLogic", "requestArkAppManagerPanelList, fail send sso request");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkMessageServerLogic.1
 * JD-Core Version:    0.7.0.1
 */