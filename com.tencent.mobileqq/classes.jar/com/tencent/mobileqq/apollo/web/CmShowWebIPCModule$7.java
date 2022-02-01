package com.tencent.mobileqq.apollo.web;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.emosm.web.MessengerService;

class CmShowWebIPCModule$7
  implements IApolloResDownloader.OnApolloDownLoadListener
{
  CmShowWebIPCModule$7(CmShowWebIPCModule paramCmShowWebIPCModule, int paramInt, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    paramString = new Bundle();
    if (paramBoolean)
    {
      paramString.putInt("apollo_result", 0);
      paramString.putInt("apollo_roleId", paramInt1);
      paramString.putInt("apollo_fromSelf", this.jdField_a_of_type_Int);
      paramString.putIntArray("apollo_dressIds", paramArrayOfInt);
      this.jdField_a_of_type_AndroidOsBundle.putBundle("response", paramString);
      this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    paramString.putInt("apollo_result", 1);
    paramString.putInt("apollo_fromSelf", this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidOsBundle.putBundle("response", paramString);
    this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.CmShowWebIPCModule.7
 * JD-Core Version:    0.7.0.1
 */