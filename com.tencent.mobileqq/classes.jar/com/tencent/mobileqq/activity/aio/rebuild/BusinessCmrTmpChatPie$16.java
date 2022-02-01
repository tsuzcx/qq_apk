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
  
  protected void a(boolean paramBoolean, QidianHandler.NavigationMenuConfig paramNavigationMenuConfig)
  {
    if ((paramBoolean) && (paramNavigationMenuConfig != null))
    {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(String.valueOf(paramNavigationMenuConfig.jdField_a_of_type_Long))))
      {
        int i = paramNavigationMenuConfig.jdField_a_of_type_Int;
        paramBoolean = true;
        if (i == 1)
        {
          QidianPubAccountBigDataHandler localQidianPubAccountBigDataHandler = (QidianPubAccountBigDataHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_PA_BIG_DATA_HANDLER);
          PubAccountNavigationMenu localPubAccountNavigationMenu = localQidianPubAccountBigDataHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
          BusinessCmrTmpChatPie localBusinessCmrTmpChatPie = this.a;
          if (paramNavigationMenuConfig.jdField_b_of_type_Int != 0) {
            paramBoolean = false;
          }
          BusinessCmrTmpChatPie.b(localBusinessCmrTmpChatPie, paramBoolean);
          if ((localPubAccountNavigationMenu != null) && (paramNavigationMenuConfig.jdField_b_of_type_Int == localPubAccountNavigationMenu.version))
          {
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
          }
          localQidianPubAccountBigDataHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramNavigationMenuConfig.jdField_b_of_type_Long);
          return;
        }
        if (paramNavigationMenuConfig.c == 1) {
          BusinessCmrTmpChatPie.a(this.a, 1);
        }
        if (QLog.isColorLevel()) {
          QLog.d("BusinessChatPie", 2, "onGetNatigationStatus response no need show");
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("BusinessChatPie", 2, "onGetNatigationStatus response not the same aio");
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "onGetNatigationStatus response error");
    }
  }
  
  protected void a(boolean paramBoolean, PubAccountNavigationMenu paramPubAccountNavigationMenu)
  {
    if (paramBoolean)
    {
      if ((!BusinessCmrTmpChatPie.b(this.a)) && (BusinessCmrTmpChatPie.a(this.a) != 0))
      {
        BusinessCmrTmpChatPie.a(this.a, 0);
        return;
      }
      this.a.a(paramPubAccountNavigationMenu);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BusinessChatPie", 2, "onGetNatigation response error");
    }
  }
  
  protected void b(boolean paramBoolean, HashMap<String, Object> paramHashMap)
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
        this.a.j();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BusinessChatPie", 2, "onGetQidianMasterInfo not current uin");
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("BusinessChatPie", 2, "onGetQidianMasterInfo fail");
    }
  }
  
  protected void e(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    super.e(paramBoolean, paramHashMap);
    if ((paramBoolean) && (paramHashMap != null)) {}
    for (;;)
    {
      try
      {
        i = Integer.parseInt(String.valueOf(paramHashMap.get("result")));
        String.valueOf(paramHashMap.get("master_uin"));
        if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != null) && (i == 1))
        {
          long l1 = Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
          paramHashMap = ((QidianPubAccountBigDataHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_PA_BIG_DATA_HANDLER)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
          QidianHandler localQidianHandler = (QidianHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER);
          long l2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin();
          if (paramHashMap != null)
          {
            i = paramHashMap.version;
            localQidianHandler.a(l1, l2, i, BusinessCmrTmpChatPie.a(this.a), false);
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramHashMap)
      {
        return;
      }
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie.16
 * JD-Core Version:    0.7.0.1
 */