package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.biz.helper.TroopCardAppInfoHelper.IGetAppInfoCB;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopAppInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.utils.TroopAioNotifyManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class TroopRedTipHelper$1
  implements TroopCardAppInfoHelper.IGetAppInfoCB
{
  TroopRedTipHelper$1(TroopRedTipHelper paramTroopRedTipHelper) {}
  
  public void a()
  {
    if ((ChatActivityUtils.a(TroopRedTipHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, TroopRedTipHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()) != null) || (QLog.isColorLevel())) {
      QLog.d(".troop.notify_feeds.aio", 2, "getAppIds onFailed, reqNotifyItems");
    }
    TroopAioNotifyManager.a(TroopRedTipHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, TroopRedTipHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
  }
  
  public void a(ArrayList<TroopAppInfo> paramArrayList)
  {
    if ((TroopRedTipHelper.a(this.a) == null) || (TroopRedTipHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (TroopRedTipHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    ArrayList localArrayList;
    do
    {
      do
      {
        return;
      } while (ChatActivityUtils.a(TroopRedTipHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, TroopRedTipHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()) != null);
      localArrayList = new ArrayList();
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
      TroopInfo localTroopInfo = ((TroopManager)TroopRedTipHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(TroopRedTipHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      if ((localTroopInfo != null) && (localTroopInfo.isOwnerOrAdmin(TroopRedTipHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        localArrayList.add(Long.valueOf(101913298L));
      }
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext()) {
          localArrayList.add(Long.valueOf(((TroopAppInfo)paramArrayList.next()).appId));
        }
      }
      paramArrayList = (TroopHandler)TroopRedTipHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    } while (paramArrayList == null);
    if (QLog.isColorLevel()) {
      QLog.d(".troop.notify_feeds.aio", 2, "send_oidb_0x8c9_2, appIds.size=" + localArrayList.size());
    }
    paramArrayList.a(TroopRedTipHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, localArrayList, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopRedTipHelper.1
 * JD-Core Version:    0.7.0.1
 */