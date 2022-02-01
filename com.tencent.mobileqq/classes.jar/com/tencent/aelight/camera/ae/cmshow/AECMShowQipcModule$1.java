package com.tencent.aelight.camera.ae.cmshow;

import android.os.Bundle;
import com.tencent.aelight.camera.cmsshow.api.CMJoyEssentialDownloadCallback;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.HashMap;

final class AECMShowQipcModule$1
  implements EIPCResultCallback
{
  AECMShowQipcModule$1(CMJoyEssentialDownloadCallback paramCMJoyEssentialDownloadCallback) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.isSuccess())
    {
      boolean bool = paramEIPCResult.data.getBoolean("key_resource_download_all_succeeded");
      paramEIPCResult = (HashMap)paramEIPCResult.data.getSerializable("key_resource_download_result");
      CMJoyEssentialDownloadCallback localCMJoyEssentialDownloadCallback = this.a;
      if (localCMJoyEssentialDownloadCallback != null) {
        localCMJoyEssentialDownloadCallback.a(bool, paramEIPCResult);
      }
    }
    else
    {
      paramEIPCResult = this.a;
      if (paramEIPCResult != null) {
        paramEIPCResult.a(false, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.cmshow.AECMShowQipcModule.1
 * JD-Core Version:    0.7.0.1
 */