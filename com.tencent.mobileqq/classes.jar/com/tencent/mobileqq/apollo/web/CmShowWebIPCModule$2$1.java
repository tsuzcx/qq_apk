package com.tencent.mobileqq.apollo.web;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.game.CmGameAudioManager.UploadEventListener;
import com.tencent.mobileqq.emosm.web.MessengerService;

class CmShowWebIPCModule$2$1
  implements CmGameAudioManager.UploadEventListener
{
  CmShowWebIPCModule$2$1(CmShowWebIPCModule.2 param2) {}
  
  public void a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("result", 0);
    this.a.jdField_a_of_type_AndroidOsBundle.putBundle("response", localBundle);
    this.a.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.a.jdField_a_of_type_AndroidOsBundle);
  }
  
  public void a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("result", paramInt);
    this.a.jdField_a_of_type_AndroidOsBundle.putBundle("response", localBundle);
    this.a.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.a.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.CmShowWebIPCModule.2.1
 * JD-Core Version:    0.7.0.1
 */