package com.tencent.aelight.camera.ae.cmshow;

import android.os.Bundle;
import com.tencent.aelight.camera.cmsshow.api.CMJoyEssentialDownloadCallback;
import eipc.EIPCResult;
import java.util.HashMap;

class AECMShowQipcModule$2
  implements CMJoyEssentialDownloadCallback
{
  AECMShowQipcModule$2(AECMShowQipcModule paramAECMShowQipcModule, int paramInt) {}
  
  public void a(boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_resource_download_all_succeeded", paramBoolean);
    localBundle.putSerializable("key_resource_download_result", paramHashMap);
    this.b.callbackResult(this.a, EIPCResult.createSuccessResult(localBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.cmshow.AECMShowQipcModule.2
 * JD-Core Version:    0.7.0.1
 */