package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.biz.helper.TroopCardAppInfoHelper;
import com.tencent.biz.helper.TroopCardAppInfoHelper.IGetAppInfoCB;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarManager;
import com.tencent.mobileqq.troop.utils.TroopAioNotifyManager;
import com.tencent.qphone.base.util.QLog;

public class TroopRedTipHelper
  implements ILifeCycleHelper
{
  TroopCardAppInfoHelper.IGetAppInfoCB jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper$IGetAppInfoCB = new TroopRedTipHelper.1(this);
  TroopCardAppInfoHelper jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper;
  private TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
  
  public TroopRedTipHelper(TroopChatPie paramTroopChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie = paramTroopChatPie;
  }
  
  protected void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
      this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper = new TroopCardAppInfoHelper(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  protected void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {
      return;
    }
    if (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()) == null) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label110;
      }
      if (QLog.isColorLevel()) {
        QLog.d(".troop.notify_feeds.aio", 2, "onShow_troopType, isTroopTipStatusNull== true, getAppInfoBriefList");
      }
      if (this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper$IGetAppInfoCB, true);
      return;
    }
    label110:
    if (QLog.isColorLevel()) {
      QLog.d(".troop.notify_feeds.aio", 2, "onShow_troopType, reqNotifyItems");
    }
    TroopAioNotifyManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    ((TroopShortcutBarManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper != null)
    {
      this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper.a();
      this.jdField_a_of_type_ComTencentBizHelperTroopCardAppInfoHelper = null;
    }
  }
  
  public String getTag()
  {
    return "TroopRedTipHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 8, 14 };
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 4: 
      a();
      return;
    case 8: 
      b();
      return;
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopRedTipHelper
 * JD-Core Version:    0.7.0.1
 */