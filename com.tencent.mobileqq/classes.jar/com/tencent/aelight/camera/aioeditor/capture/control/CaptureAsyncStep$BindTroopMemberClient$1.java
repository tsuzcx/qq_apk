package com.tencent.aelight.camera.aioeditor.capture.control;

import android.os.Bundle;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;

class CaptureAsyncStep$BindTroopMemberClient$1
  implements ITroopMemberApiClientApi.Callback
{
  CaptureAsyncStep$BindTroopMemberClient$1(CaptureAsyncStep.BindTroopMemberClient paramBindTroopMemberClient) {}
  
  public void callback(Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("nickName");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    localObject = QIMManager.a();
    if ((localObject instanceof PeakAppInterface)) {
      ((PeakAppInterface)localObject).a(paramBundle);
    }
    this.a.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.control.CaptureAsyncStep.BindTroopMemberClient.1
 * JD-Core Version:    0.7.0.1
 */