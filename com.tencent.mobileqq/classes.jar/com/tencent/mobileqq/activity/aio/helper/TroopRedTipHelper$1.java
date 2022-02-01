package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.troopapps.api.ITroopCardAppInfoHelperApi.IGetAppInfoCB;
import com.tencent.mobileqq.troop.troopapps.data.TroopAppInfo;
import com.tencent.mobileqq.troop.troopreddot.api.ITroopRedDotHandler;
import com.tencent.mobileqq.troop.utils.TroopAioNotifyManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class TroopRedTipHelper$1
  implements ITroopCardAppInfoHelperApi.IGetAppInfoCB
{
  TroopRedTipHelper$1(TroopRedTipHelper paramTroopRedTipHelper) {}
  
  public void a()
  {
    ChatActivityUtils.a(TroopRedTipHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, TroopRedTipHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (QLog.isColorLevel()) {
      QLog.d(".troop.notify_feeds.aio", 2, "getAppIds onFailed, reqNotifyItems");
    }
    TroopAioNotifyManager.a(TroopRedTipHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, TroopRedTipHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
  }
  
  public void a(ArrayList<TroopAppInfo> paramArrayList)
  {
    if ((TroopRedTipHelper.a(this.a) != null) && (TroopRedTipHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      if (TroopRedTipHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
        return;
      }
      if (ChatActivityUtils.a(TroopRedTipHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, TroopRedTipHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()) != null) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(1L));
      localArrayList.add(Long.valueOf(2L));
      localArrayList.add(Long.valueOf(1101236949L));
      localArrayList.add(Long.valueOf(1101484419L));
      localArrayList.add(Long.valueOf(1102858908L));
      localArrayList.add(Long.valueOf(1104445552L));
      localArrayList.add(Long.valueOf(1106717414L));
      localArrayList.add(Long.valueOf(101509131L));
      localArrayList.add(Long.valueOf(1106588005L));
      localArrayList.add(Long.valueOf(1106664488L));
      localArrayList.add(Long.valueOf(101618516L));
      localArrayList.add(Long.valueOf(101872323L));
      localArrayList.add(Long.valueOf(101890494L));
      localArrayList.add(Long.valueOf(101896870L));
      Object localObject = ((TroopManager)TroopRedTipHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(TroopRedTipHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      if ((localObject != null) && (((TroopInfo)localObject).isOwnerOrAdmin(TroopRedTipHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        localArrayList.add(Long.valueOf(101913298L));
      }
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext()) {
          localArrayList.add(Long.valueOf(((TroopAppInfo)paramArrayList.next()).appId));
        }
      }
      paramArrayList = (ITroopRedDotHandler)TroopRedTipHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_RED_DOT_HANDLER);
      if (paramArrayList != null)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("send_oidb_0x8c9_2, appIds.size=");
          ((StringBuilder)localObject).append(localArrayList.size());
          QLog.d(".troop.notify_feeds.aio", 2, ((StringBuilder)localObject).toString());
        }
        paramArrayList.a(TroopRedTipHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, localArrayList, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopRedTipHelper.1
 * JD-Core Version:    0.7.0.1
 */