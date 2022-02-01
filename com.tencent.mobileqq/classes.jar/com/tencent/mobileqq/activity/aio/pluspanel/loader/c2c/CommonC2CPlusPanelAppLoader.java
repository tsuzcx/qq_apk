package com.tencent.mobileqq.activity.aio.pluspanel.loader.c2c;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.panel.miniapp.AioPanelMiniAppManager;
import com.tencent.mobileqq.activity.aio.pluspanel.C2CPlusPanelAppConfigHelper;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.PlusPanelAppLoader.ScribbleResMgrShowConfig;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ark.ArkAiAppCenter;
import com.tencent.mobileqq.hotpic.HotPicManager;
import com.tencent.mobileqq.receipt.ReceiptUtil;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkManager;
import java.util.Iterator;
import java.util.List;

public class CommonC2CPlusPanelAppLoader
  extends C2CPlusPanelAppLoader
{
  private void a(BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface)
  {
    b(paramBaseChatPie, paramQQAppInterface);
    c(paramBaseChatPie, paramQQAppInterface);
    c(paramBaseChatPie);
    d(paramBaseChatPie, paramQQAppInterface);
  }
  
  private void a(BaseChatPie paramBaseChatPie, List<PlusPanelAppInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        PlusPanelAppInfo localPlusPanelAppInfo = (PlusPanelAppInfo)paramList.next();
        if (localPlusPanelAppInfo.getAppID() == 215)
        {
          IApolloManagerService localIApolloManagerService = (IApolloManagerService)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
          if ((localIApolloManagerService.isApolloFuncOpen(paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, Boolean.valueOf(false))) && (localIApolloManagerService.queryStatusInConfig(paramBaseChatPie.a(), "aio", null) > 0)) {
            a(localPlusPanelAppInfo);
          }
        }
        else
        {
          a(localPlusPanelAppInfo);
        }
      }
    }
  }
  
  private void b(BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface)
  {
    c(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 201);
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 202);
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 203);
    if (HotPicManager.a(paramQQAppInterface).b()) {
      a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 204);
    }
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 219);
    if ((AioPanelMiniAppManager.a(paramQQAppInterface).a()) && (SimpleUIUtil.a())) {
      a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 209);
    }
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 205);
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 206);
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 207);
    if ((AioPanelMiniAppManager.a(paramQQAppInterface).a()) && (!SimpleUIUtil.a())) {
      a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 209);
    }
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 208);
  }
  
  private void c(BaseChatPie paramBaseChatPie)
  {
    if (!ArkAiAppCenter.jdField_a_of_type_Boolean) {
      a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 1000000001);
    }
  }
  
  private void c(BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPluspanelLoaderPlusPanelAppLoader$ScribbleResMgrShowConfig.a(paramBaseChatPie.a(), paramQQAppInterface.getCurrentAccountUin())) {
      a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 210);
    }
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 1000000006);
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 211);
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 212);
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 213);
    if (ReceiptUtil.a()) {
      a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 216);
    }
    if (((TeamWorkManager)paramQQAppInterface.getManager(QQManagerFactory.TEAMWORK_MANAGER)).a().booleanValue())
    {
      a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 214);
      AIOPanelUtiles.a(paramQQAppInterface, "0X80093F3", paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
    IApolloManagerService localIApolloManagerService = (IApolloManagerService)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    if ((localIApolloManagerService.isApolloFuncOpen(paramBaseChatPie.jdField_a_of_type_AndroidContentContext, Boolean.valueOf(false))) && (localIApolloManagerService.queryStatusInConfig(paramQQAppInterface, "aio", null) > 0)) {
      a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 215);
    }
  }
  
  private void d(BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface.getAccount() != null) && (paramQQAppInterface.getAccount().equals(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 211);
      a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 203);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      PlusPanelAppInfo localPlusPanelAppInfo = C2CPlusPanelAppConfigHelper.INSTANCE.getAppInfoByAppID(paramInt2);
      if (localPlusPanelAppInfo != null)
      {
        this.jdField_a_of_type_JavaUtilList.add(localPlusPanelAppInfo);
        return;
      }
    }
    super.a(paramInt1, paramInt2);
  }
  
  protected void b(BaseChatPie paramBaseChatPie)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    ReportController.b(localQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "transferAIOshow", 0, 0, "", "", "", "");
    this.jdField_a_of_type_Boolean = false;
    List localList = C2CPlusPanelAppConfigHelper.INSTANCE.getC2CAppInfo();
    if (!localList.isEmpty())
    {
      this.jdField_a_of_type_Boolean = true;
      a(paramBaseChatPie, localList);
      return;
    }
    a(paramBaseChatPie, localQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.loader.c2c.CommonC2CPlusPanelAppLoader
 * JD-Core Version:    0.7.0.1
 */