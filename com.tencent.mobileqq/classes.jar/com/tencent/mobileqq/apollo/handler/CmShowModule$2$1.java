package com.tencent.mobileqq.apollo.handler;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.lightGame.CmGameAudioManager.UploadEventListener;
import com.tencent.mobileqq.emosm.web.MessengerService;

class CmShowModule$2$1
  implements CmGameAudioManager.UploadEventListener
{
  CmShowModule$2$1(CmShowModule.2 param2) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.handler.CmShowModule.2.1
 * JD-Core Version:    0.7.0.1
 */