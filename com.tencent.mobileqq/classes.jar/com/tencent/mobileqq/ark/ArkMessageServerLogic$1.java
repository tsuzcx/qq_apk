package com.tencent.mobileqq.ark;

import altn;
import altx;
import alty;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

public final class ArkMessageServerLogic$1
  implements Runnable
{
  public ArkMessageServerLogic$1(alty paramalty) {}
  
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
        localObject = (ArkAppCenter)((QQAppInterface)localObject).getManager(121);
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
      } while (((altn)localObject).a("ArkAppPanel.List", 10000, 0, new altx(this)));
      ArkAppCenter.c("ArkApp.ArkMessageServerLogic", "requestArkAppManagerPanelList, fail send sso request");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkMessageServerLogic.1
 * JD-Core Version:    0.7.0.1
 */