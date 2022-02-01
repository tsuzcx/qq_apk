package com.tencent.mobileqq.apollo.api.impl;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.api.aio.CmShowAioMatcher;
import com.tencent.mobileqq.apollo.handler.ApolloGetBattleGameListVasHandler;
import com.tencent.mobileqq.apollo.task.ApolloMsgPlayController;
import com.tencent.mobileqq.apollo.utils.CmShowWnsUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;

class ApolloManagerServiceImpl$12
  implements Runnable
{
  ApolloManagerServiceImpl$12(ApolloManagerServiceImpl paramApolloManagerServiceImpl, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    try
    {
      localQQAppInterface = ApolloManagerServiceImpl.access$300(this.this$0);
      if (localQQAppInterface == null) {
        return;
      }
      if (!CmShowAioMatcher.a(this.a.jdField_a_of_type_Int, 1)) {
        break label92;
      }
      this.this$0.checkUserDress(localQQAppInterface, this.a.jdField_a_of_type_JavaLangString, "C2CAIO");
      if ((CmShowWnsUtils.h()) && (!StudyModeManager.a())) {
        ApolloGetBattleGameListVasHandler.a(localQQAppInterface, 4021);
      }
    }
    catch (Exception localException)
    {
      QQAppInterface localQQAppInterface;
      while (QLog.isColorLevel())
      {
        QLog.e("ApolloManager", 2, "doAfterOpenAIO error", localException);
        return;
        label92:
        if (CmShowAioMatcher.a(this.a.jdField_a_of_type_Int, 2))
        {
          this.this$0.bulkUpdateUserDress();
          if ((CmShowWnsUtils.i()) && (!StudyModeManager.a())) {
            ApolloGetBattleGameListVasHandler.a(localException, 4022);
          }
        }
      }
    }
    ApolloMsgPlayController.a().a(localQQAppInterface, this.a);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl.12
 * JD-Core Version:    0.7.0.1
 */