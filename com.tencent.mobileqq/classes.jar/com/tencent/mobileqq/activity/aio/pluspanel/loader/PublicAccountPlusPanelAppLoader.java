package com.tencent.mobileqq.activity.aio.pluspanel.loader;

import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.C2CPlusPanelAppConfigHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qidian.QidianManager;
import java.util.List;

public class PublicAccountPlusPanelAppLoader
  extends CommonPlusPanelAppLoader
{
  private void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    if (CrmUtils.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int)) {
      a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 201);
    }
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 217);
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 218);
    if (paramSessionInfo.jdField_a_of_type_Int == 1008)
    {
      paramSessionInfo = (PublicAccountInfo)((IPublicAccountDataManager)paramQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all")).findPublicAccountInfo(paramSessionInfo.jdField_a_of_type_JavaLangString);
      if ((paramSessionInfo != null) && ((paramSessionInfo.accountFlag & 0x20000000) != 0) && (ShortVideoUtils.sSupportShortVideo) && (VideoEnvironment.supportShortVideoRecordAndPlay())) {
        a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 1104788673);
      }
      if ((paramSessionInfo != null) && ((paramSessionInfo.accountFlag & 0x10000000) != 0)) {
        this.a.add(0, C2CPlusPanelAppConfigHelper.INSTANCE.getAppInfoByAppID(1000000005));
      }
    }
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 205);
  }
  
  private void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo, QidianManager paramQidianManager)
  {
    if (paramQidianManager.c(paramSessionInfo.jdField_a_of_type_JavaLangString))
    {
      a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 201);
      a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 202);
    }
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 206);
    a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 205);
  }
  
  protected void b(BaseChatPie paramBaseChatPie)
  {
    SessionInfo localSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    QQAppInterface localQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    QidianManager localQidianManager = (QidianManager)localQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER);
    if (localQidianManager.f(localSessionInfo.jdField_a_of_type_JavaLangString))
    {
      a(paramBaseChatPie, localSessionInfo, localQidianManager);
      return;
    }
    a(paramBaseChatPie, localSessionInfo, localQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.pluspanel.loader.PublicAccountPlusPanelAppLoader
 * JD-Core Version:    0.7.0.1
 */