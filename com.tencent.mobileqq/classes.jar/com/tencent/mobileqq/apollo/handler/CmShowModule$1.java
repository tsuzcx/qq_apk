package com.tencent.mobileqq.apollo.handler;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.lightGame.CmGameAudioManager.RecorderEventListener;
import com.tencent.mobileqq.emosm.web.MessengerService;

class CmShowModule$1
  implements CmGameAudioManager.RecorderEventListener
{
  CmShowModule$1(CmShowModule paramCmShowModule, Bundle paramBundle1, Bundle paramBundle2, MessengerService paramMessengerService) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.handler.CmShowModule.1
 * JD-Core Version:    0.7.0.1
 */