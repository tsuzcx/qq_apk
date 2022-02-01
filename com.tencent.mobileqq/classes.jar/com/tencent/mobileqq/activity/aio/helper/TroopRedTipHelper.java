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
  private TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
  ITroopCardAppInfoHelperApi.IGetAppInfoCB jdField_a_of_type_ComTencentMobileqqTroopTroopappsApiITroopCardAppInfoHelperApi$IGetAppInfoCB = new TroopRedTipHelper.1(this);
  ITroopCardAppInfoHelperApi jdField_a_of_type_ComTencentMobileqqTroopTroopappsApiITroopCardAppInfoHelperApi;
  
  public TroopRedTipHelper(TroopChatPie paramTroopChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie = paramTroopChatPie;
  }
  
  protected void a()
  {
    TroopChatPie localTroopChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
    if ((localTroopChatPie != null) && (localTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsApiITroopCardAppInfoHelperApi = ((ITroopCardAppInfoHelperApi)QRoute.api(ITroopCardAppInfoHelperApi.class));
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsApiITroopCardAppInfoHelperApi.init(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  protected void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
    if ((localObject != null) && (((TroopChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
        return;
      }
      int i;
      if (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()) == null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d(".troop.notify_feeds.aio", 2, "onShow_troopType, isTroopTipStatusNull== true, getAppInfoBriefList");
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsApiITroopCardAppInfoHelperApi;
        if (localObject != null) {
          ((ITroopCardAppInfoHelperApi)localObject).getAppInfoBriefList(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsApiITroopCardAppInfoHelperApi$IGetAppInfoCB, true);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(".troop.notify_feeds.aio", 2, "onShow_troopType, reqNotifyItems");
        }
        TroopAioNotifyManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
        ((TroopShortcutBarManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      }
    }
  }
  
  protected void c()
  {
    ITroopCardAppInfoHelperApi localITroopCardAppInfoHelperApi = this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsApiITroopCardAppInfoHelperApi;
    if (localITroopCardAppInfoHelperApi != null)
    {
      localITroopCardAppInfoHelperApi.destroy();
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsApiITroopCardAppInfoHelperApi = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopRedTipHelper
 * JD-Core Version:    0.7.0.1
 */