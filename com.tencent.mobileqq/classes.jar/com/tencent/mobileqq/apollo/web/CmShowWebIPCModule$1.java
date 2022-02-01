package com.tencent.mobileqq.apollo.web;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.game.CmGameAudioManager.RecorderEventListener;
import com.tencent.mobileqq.emosm.web.MessengerService;

class CmShowWebIPCModule$1
  implements CmGameAudioManager.RecorderEventListener
{
  CmShowWebIPCModule$1(CmShowWebIPCModule paramCmShowWebIPCModule, Bundle paramBundle1, Bundle paramBundle2, MessengerService paramMessengerService) {}
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsBundle.putInt("result", 0);
    this.b.putBundle("response", this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.b);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsBundle.putInt("result", paramInt);
    this.b.putBundle("response", this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.b);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.CmShowWebIPCModule.1
 * JD-Core Version:    0.7.0.1
 */