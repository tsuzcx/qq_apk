package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarManager;
import com.tencent.mobileqq.troop.troopapps.api.ITroopCardAppInfoHelperApi;
import com.tencent.mobileqq.troop.troopapps.api.ITroopCardAppInfoHelperApi.IGetAppInfoCB;
import com.tencent.mobileqq.troop.utils.TroopAioNotifyManager;
import com.tencent.qphone.base.util.QLog;

public class TroopRedTipHelper
  implements ILifeCycleHelper
{
  ITroopCardAppInfoHelperApi a;
  ITroopCardAppInfoHelperApi.IGetAppInfoCB b = new TroopRedTipHelper.1(this);
  private TroopChatPie c;
  
  public TroopRedTipHelper(TroopChatPie paramTroopChatPie)
  {
    this.c = paramTroopChatPie;
  }
  
  protected void a()
  {
    TroopChatPie localTroopChatPie = this.c;
    if ((localTroopChatPie != null) && (localTroopChatPie.d != null))
    {
      this.a = ((ITroopCardAppInfoHelperApi)QRoute.api(ITroopCardAppInfoHelperApi.class));
      this.a.init(this.c.d);
    }
  }
  
  protected void b()
  {
    Object localObject = this.c;
    if ((localObject != null) && (((TroopChatPie)localObject).d != null))
    {
      if (this.c.ah == null) {
        return;
      }
      int i;
      if (ChatActivityUtils.a(this.c.ah.b, this.c.d.getCurrentAccountUin()) == null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d(".troop.notify_feeds.aio", 2, "onShow_troopType, isTroopTipStatusNull== true, getAppInfoBriefList");
        }
        localObject = this.a;
        if (localObject != null) {
          ((ITroopCardAppInfoHelperApi)localObject).getAppInfoBriefList(this.c.ah.b, this.b, true);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(".troop.notify_feeds.aio", 2, "onShow_troopType, reqNotifyItems");
        }
        TroopAioNotifyManager.a(this.c.d, this.c.ah.b);
        ((TroopShortcutBarManager)this.c.d.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER)).a(this.c.ah.b);
      }
    }
  }
  
  protected void c()
  {
    ITroopCardAppInfoHelperApi localITroopCardAppInfoHelperApi = this.a;
    if (localITroopCardAppInfoHelperApi != null)
    {
      localITroopCardAppInfoHelperApi.destroy();
      this.a = null;
    }
  }
  
  public String getTag()
  {
    return "TroopRedTipHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 9, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 9)
      {
        if (paramInt != 15) {
          return;
        }
        c();
        return;
      }
      b();
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopRedTipHelper
 * JD-Core Version:    0.7.0.1
 */