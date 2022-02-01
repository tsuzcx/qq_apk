package com.tencent.aelight.camera.aioeditor.editipc;

import android.os.Bundle;
import com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.SendPanelItemInfo;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class PeakIpcController$2
  implements EIPCResultCallback
{
  PeakIpcController$2(SendPanelItemInfo paramSendPanelItemInfo) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    boolean bool;
    if ((paramEIPCResult != null) && (paramEIPCResult.data != null)) {
      bool = paramEIPCResult.data.getBoolean("key_result");
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      paramEIPCResult = new StringBuilder();
      paramEIPCResult.append("cancelSendVideoOrPhoto result:");
      paramEIPCResult.append(bool);
      paramEIPCResult.append(", uinseq:");
      paramEIPCResult.append(this.a.a);
      paramEIPCResult.append(", status:");
      paramEIPCResult.append(this.a.b);
      paramEIPCResult.append(", progress:");
      paramEIPCResult.append(this.a.c);
      QLog.d("PeakIpcController", 2, paramEIPCResult.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.editipc.PeakIpcController.2
 * JD-Core Version:    0.7.0.1
 */