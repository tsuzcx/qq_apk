package com.tencent.mobileqq.apollo.web;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.game.CmGameAudioManager;
import com.tencent.mobileqq.apollo.game.api.IApolloGameManager;
import com.tencent.mobileqq.apollo.game.api.impl.ApolloGameManagerImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.web.MessengerService;

class CmShowWebIPCModule$3
  implements Runnable
{
  CmShowWebIPCModule$3(CmShowWebIPCModule paramCmShowWebIPCModule, QQAppInterface paramQQAppInterface, Bundle paramBundle1, Bundle paramBundle2, MessengerService paramMessengerService) {}
  
  public void run()
  {
    boolean bool = ((ApolloGameManagerImpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloGameManager.class, "all")).getCmGameAudioManager().a(this.jdField_a_of_type_AndroidOsBundle.getString("url"));
    Bundle localBundle = new Bundle();
    int i;
    if (bool) {
      i = 0;
    } else {
      i = -1;
    }
    localBundle.putInt("result", i);
    this.b.putBundle("response", localBundle);
    this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.CmShowWebIPCModule.3
 * JD-Core Version:    0.7.0.1
 */