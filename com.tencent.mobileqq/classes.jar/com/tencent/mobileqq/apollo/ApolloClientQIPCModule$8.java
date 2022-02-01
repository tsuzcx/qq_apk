package com.tencent.mobileqq.apollo;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader.OnFaceDataDownloadListener;
import eipc.EIPCResult;

class ApolloClientQIPCModule$8
  implements IApolloResDownloader.OnFaceDataDownloadListener
{
  ApolloClientQIPCModule$8(ApolloClientQIPCModule paramApolloClientQIPCModule, Bundle paramBundle, int paramInt) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    EIPCResult localEIPCResult = new EIPCResult();
    if (paramBoolean) {
      paramInt = 0;
    }
    localEIPCResult.code = paramInt;
    localEIPCResult.data = this.jdField_a_of_type_AndroidOsBundle;
    this.jdField_a_of_type_AndroidOsBundle.putString("apolloErrMsg", "success");
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloClientQIPCModule.callbackResult(this.jdField_a_of_type_Int, localEIPCResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloClientQIPCModule.8
 * JD-Core Version:    0.7.0.1
 */