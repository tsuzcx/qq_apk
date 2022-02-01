package com.tencent.mobileqq.activity.aio.pluspanel.loader;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.pluspanel.filter.DiscussTeensModeFilter;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ark.ArkAiAppCenter;
import com.tencent.mobileqq.hotpic.HotPicManager;
import com.tencent.mobileqq.receipt.ReceiptUtil;
import com.tencent.mobileqq.teamwork.TeamWorkManager;

public class DiscussPlusPanelAppLoader
  extends CommonPlusPanelAppLoader
{
  DiscussPlusPanelAppLoader()
  {
    a(new DiscussTeensModeFilter());
  }
  
  public void b(BaseChatPie paramBaseChatPie)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1200000007);
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1106658188);
    if (HotPicManager.a(localQQAppInterface).b()) {
      a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1107930043);
    }
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1104864062);
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1104864068);
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1104864066);
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1104639410);
    if (this.a.a(paramBaseChatPie.a(), localQQAppInterface.getCurrentAccountUin())) {
      a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1106114157);
    }
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1200000010);
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1104864070);
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1104788679);
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1104874204);
    if (ReceiptUtil.a()) {
      a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1106189400);
    }
    IApolloManagerService localIApolloManagerService = (IApolloManagerService)localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    if ((localIApolloManagerService.isApolloFuncOpen(paramBaseChatPie.a())) && (localIApolloManagerService.queryApolloSwitchSet("discuss") == 1)) {
      a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1200000008);
    }
    if (((TeamWorkManager)localQQAppInterface.getManager(QQManagerFactory.TEAMWORK_MANAGER)).a().booleanValue())
    {
      a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1200000002);
      AIOPanelUtiles.a(localQQAppInterface, "0X80093F3", paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    }
    if (!ArkAiAppCenter.a) {
      a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1200000009);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.loader.DiscussPlusPanelAppLoader
 * JD-Core Version:    0.7.0.1
 */