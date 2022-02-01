package com.tencent.aelight.camera.aioeditor.editipc;

import android.os.Bundle;
import com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.SendPanelManager;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class PeakIpcController$5
  implements EIPCResultCallback
{
  PeakIpcController$5(String paramString) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult != null)
    {
      paramEIPCResult = paramEIPCResult.data.getString("uinname");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getTroopMemberName success name = ");
        localStringBuilder.append(paramEIPCResult);
        QLog.i("PeakIpcController", 2, localStringBuilder.toString());
      }
      SendPanelManager.a().a(this.a, paramEIPCResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.editipc.PeakIpcController.5
 * JD-Core Version:    0.7.0.1
 */