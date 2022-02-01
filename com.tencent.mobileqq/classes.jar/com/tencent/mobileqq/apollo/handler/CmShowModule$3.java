package com.tencent.mobileqq.apollo.handler;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.lightGame.CmGameAudioManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.web.MessengerService;

class CmShowModule$3
  implements Runnable
{
  CmShowModule$3(CmShowModule paramCmShowModule, QQAppInterface paramQQAppInterface, Bundle paramBundle1, Bundle paramBundle2, MessengerService paramMessengerService) {}
  
  public void run()
  {
    boolean bool = ((IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getCmGameAudioManager().b(this.jdField_a_of_type_AndroidOsBundle.getString("url"));
    Bundle localBundle = new Bundle();
    if (bool) {}
    for (int i = 0;; i = -1)
    {
      localBundle.putInt("result", i);
      this.b.putBundle("response", localBundle);
      this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.handler.CmShowModule.3
 * JD-Core Version:    0.7.0.1
 */