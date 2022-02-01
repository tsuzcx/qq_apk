package com.tencent.mobileqq.apollo.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.aio.api.impl.CmShowAioMatcherImpl;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.handler.ApolloRequest;
import com.tencent.mobileqq.apollo.task.ApolloMsgPlayController;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;

class ApolloManagerServiceImpl$7
  implements Runnable
{
  ApolloManagerServiceImpl$7(ApolloManagerServiceImpl paramApolloManagerServiceImpl, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    try
    {
      AppInterface localAppInterface = ApolloManagerServiceImpl.access$200(this.this$0);
      if (localAppInterface == null) {
        return;
      }
      if (CmShowAioMatcherImpl.judgeSupported(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 1))
      {
        this.this$0.checkUserDress(localAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "C2CAIO");
        if ((CmShowWnsUtils.j()) && (!StudyModeManager.a())) {
          ApolloRequest.a(localAppInterface, 4021);
        }
      }
      else if (CmShowAioMatcherImpl.judgeSupported(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 2))
      {
        this.this$0.bulkUpdateUserDress();
        if ((CmShowWnsUtils.k()) && (!StudyModeManager.a())) {
          ApolloRequest.a(localAppInterface, 4022);
        }
      }
      ApolloMsgPlayController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("[cmshow]ApolloManager", 2, "doAfterOpenAIO error", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl.7
 * JD-Core Version:    0.7.0.1
 */