package com.tencent.mobileqq.apollo.web;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.game.CmGameAudioManager;
import com.tencent.mobileqq.apollo.game.api.IApolloGameManager;
import com.tencent.mobileqq.apollo.game.api.impl.ApolloGameManagerImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.web.MessengerService;

class CmShowWebIPCModule$2
  implements Runnable
{
  CmShowWebIPCModule$2(CmShowWebIPCModule paramCmShowWebIPCModule, QQAppInterface paramQQAppInterface, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void run()
  {
    CmGameAudioManager localCmGameAudioManager = ((ApolloGameManagerImpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloGameManager.class, "all")).getCmGameAudioManager();
    localCmGameAudioManager.a(localCmGameAudioManager.a(), new CmShowWebIPCModule.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.CmShowWebIPCModule.2
 * JD-Core Version:    0.7.0.1
 */