package com.tencent.mobileqq.activity.aio.pluspanel.loader;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.pluspanel.filter.DiscussTeensModeFilter;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ark.api.IArkConfig;
import com.tencent.mobileqq.ark.config.bean.ArkMsgAIDisableConfBean;
import com.tencent.mobileqq.ark.config.config.ArkMsgAIDisableConfig;
import com.tencent.mobileqq.hotpic.HotPicManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.receipt.ReceiptUtil;
import com.tencent.mobileqq.teamwork.TeamWorkManager;
import com.tencent.qphone.base.util.QLog;

public class DiscussPlusPanelAppLoader
  extends CommonPlusPanelAppLoader
{
  DiscussPlusPanelAppLoader()
  {
    a(new DiscussTeensModeFilter());
  }
  
  public void b(BaseChatPie paramBaseChatPie)
  {
    Object localObject = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1200000007);
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1106658188);
    if (HotPicManager.a((QQAppInterface)localObject).b()) {
      a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1107930043);
    }
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1104864062);
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1104864068);
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1104864066);
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1104639410);
    if (this.a.a(paramBaseChatPie.a(), ((QQAppInterface)localObject).getCurrentAccountUin())) {
      a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1106114157);
    }
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1200000010);
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1104864070);
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1104788679);
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1104874204);
    if (ReceiptUtil.a()) {
      a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1106189400);
    }
    try
    {
      IApolloManagerService localIApolloManagerService = (IApolloManagerService)((QQAppInterface)localObject).getRuntimeService(IApolloManagerService.class, "all");
      if ((localIApolloManagerService.isApolloSupport(paramBaseChatPie.a())) && (localIApolloManagerService.queryApolloSwitchSet("discuss") == 1)) {
        a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1200000008);
      }
    }
    catch (Exception localException)
    {
      QLog.e("DiscussPlusPanelAppLoader", 2, "[fillAppInfo] apollo error! ", localException);
    }
    if (((TeamWorkManager)((QQAppInterface)localObject).getManager(QQManagerFactory.TEAMWORK_MANAGER)).a().booleanValue())
    {
      a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1200000002);
      AIOPanelUtiles.a((BaseQQAppInterface)localObject, "0X80093F3", paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    }
    localObject = (ArkMsgAIDisableConfBean)((IArkConfig)QRoute.api(IArkConfig.class)).loadConfig(ArkMsgAIDisableConfBean.class);
    if ((localObject != null) && (((ArkMsgAIDisableConfBean)localObject).a() != null) && (!((ArkMsgAIDisableConfBean)localObject).a().a)) {
      a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 1200000009);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.loader.DiscussPlusPanelAppLoader
 * JD-Core Version:    0.7.0.1
 */