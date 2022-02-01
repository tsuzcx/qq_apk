package com.tencent.mobileqq.apollo.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader.OnFaceDataDownloadListener;
import eipc.EIPCResult;

class ApolloIPCModule$4
  implements IApolloResDownloader.OnFaceDataDownloadListener
{
  ApolloIPCModule$4(ApolloIPCModule paramApolloIPCModule, Bundle paramBundle, int paramInt) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    EIPCResult localEIPCResult = new EIPCResult();
    if (paramBoolean) {
      paramInt = 0;
    }
    localEIPCResult.code = paramInt;
    Bundle localBundle = this.jdField_a_of_type_AndroidOsBundle;
    localEIPCResult.data = localBundle;
    localBundle.putString("apolloErrMsg", "success");
    this.jdField_a_of_type_ComTencentMobileqqApolloIpcApolloIPCModule.callbackResult(this.jdField_a_of_type_Int, localEIPCResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ipc.ApolloIPCModule.4
 * JD-Core Version:    0.7.0.1
 */