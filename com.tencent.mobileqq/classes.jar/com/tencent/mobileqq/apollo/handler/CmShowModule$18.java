package com.tencent.mobileqq.apollo.handler;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.web.MessengerService;

class CmShowModule$18
  implements Runnable
{
  CmShowModule$18(CmShowModule paramCmShowModule, Bundle paramBundle1, QQAppInterface paramQQAppInterface, Bundle paramBundle2, MessengerService paramMessengerService) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("apollo_face3DData");
    ((IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).save3DFace(str, new CmShowModule.18.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.handler.CmShowModule.18
 * JD-Core Version:    0.7.0.1
 */