package com.tencent.mobileqq.activity.aio.rebuild;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qidian.controller.QidianHandler.NavigationMenuConfig;
import com.tencent.qidian.controller.QidianPubAccountBigDataHandler;
import com.tencent.qidian.data.PubAccountNavigationMenu;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class BusinessCmrTmpChatPie$16
  extends QidianBusinessObserver
{
  BusinessCmrTmpChatPie$16(BusinessCmrTmpChatPie paramBusinessCmrTmpChatPie) {}
  
  public void a(boolean paramBoolean, QidianHandler.NavigationMenuConfig paramNavigationMenuConfig)
  {
    boolean bool = true;
    if ((paramBoolean) && (paramNavigationMenuConfig != null)) {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(String.valueOf(paramNavigationMenuConfig.jdField_a_of_type_Long)))) {
        if (paramNavigationMenuConfig.jdField_a_of_type_Int == 1)
        {
          localQidianPubAccountBigDataHandler = (QidianPubAccountBigDataHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_PA_BIG_DATA_HANDLER);
          localPubAccountNavigationMenu = localQidianPubAccountBigDataHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
          localBusinessCmrTmpChatPie = this.a;
          if (paramNavigationMenuConfig.jdField_b_of_type_Int == 0)
          {
            paramBoolean = bool;
            BusinessCmrTmpChatPie.b(localBusinessCmrTmpChatPie, paramBoolean);
            if ((localPubAccountNavigationMenu != null) && (paramNavigationMenuConfig.jdField_b_of_type_Int == localPubAccountNavigationMenu.version)) {
              break label153;
            }
            localQidianPubAccountBigDataHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramNavigationMenuConfig.jdField_b_of_type_Long);
          }
        }
      }
    }
    label153:
    while (!QLog.isColorLevel())
    {
      do
      {
        do
        {
          PubAccountNavigationMenu localPubAccountNavigationMenu;
          for (;;)
          {
            QidianPubAccountBigDataHandler localQidianPubAccountBigDataHandler;
            BusinessCmrTmpChatPie localBusinessCmrTmpChatPie;
            return;
            paramBoolean = false;
          }
          if (QLog.isColorLevel()) {
            QLog.d("BusinessChatPie", 2, "onGetNatigationStatus show directly");
          }
          if (BusinessCmrTmpChatPie.a(this.a) == 0)
          {
            this.a.a(localPubAccountNavigationMenu);
            return;
          }
          BusinessCmrTmpChatPie.a(this.a, 0);
          return;
          if (paramNavigationMenuConfig.c == 1) {
            BusinessCmrTmpChatPie.a(this.a, 1);
          }
        } while (!QLog.isColorLevel());
        QLog.d("BusinessChatPie", 2, "onGetNatigationStatus response no need show");
        return;
      } while (!QLog.isColorLevel());
      QLog.d("BusinessChatPie", 2, "onGetNatigationStatus response not the same aio");
      return;
    }
    QLog.d("BusinessChatPie", 2, "onGetNatigationStatus response error");
  }
  
  public void a(boolean paramBoolean, PubAccountNavigationMenu paramPubAccountNavigationMenu)
  {
    if (paramBoolean) {
      if ((!BusinessCmrTmpChatPie.b(this.a)) && (BusinessCmrTmpChatPie.a(this.a) != 0)) {
        BusinessCmrTmpChatPie.a(this.a, 0);
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      this.a.a(paramPubAccountNavigationMenu);
      return;
    }
    QLog.d("BusinessChatPie", 2, "onGetNatigation response error");
  }
  
  public void b(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if ((paramBoolean) && (paramHashMap != null) && (paramHashMap.containsKey("external")) && (paramHashMap.get("external") != null))
    {
      paramHashMap = (QidianExternalInfo)paramHashMap.get("external");
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(paramHashMap.uin))
      {
        if ((TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d)) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramHashMap.nickname;
          this.a.e.setText(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
        }
        this.a.v();
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("BusinessChatPie", 2, "onGetQidianMasterInfo not current uin");
      return;
    }
    QLog.d("BusinessChatPie", 2, "onGetQidianMasterInfo fail");
  }
  
  public void e(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    int i = 0;
    super.e(paramBoolean, paramHashMap);
    if ((paramBoolean) && (paramHashMap != null)) {}
    try
    {
      int j = Integer.parseInt(String.valueOf(paramHashMap.get("result")));
      String.valueOf(paramHashMap.get("master_uin"));
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != null) && (j == 1))
      {
        long l1 = Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
        paramHashMap = ((QidianPubAccountBigDataHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_PA_BIG_DATA_HANDLER)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
        QidianHandler localQidianHandler = (QidianHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER);
        long l2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin();
        if (paramHashMap != null) {
          i = paramHashMap.version;
        }
        localQidianHandler.a(l1, l2, i, BusinessCmrTmpChatPie.a(this.a), false);
      }
      return;
    }
    catch (Exception paramHashMap) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie.16
 * JD-Core Version:    0.7.0.1
 */