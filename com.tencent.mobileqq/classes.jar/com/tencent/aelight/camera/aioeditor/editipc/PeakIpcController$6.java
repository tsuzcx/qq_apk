package com.tencent.aelight.camera.aioeditor.editipc;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class PeakIpcController$6
  implements EIPCResultCallback
{
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult != null)
    {
      boolean bool = paramEIPCResult.data.getBoolean("key_result");
      paramEIPCResult = new StringBuilder();
      paramEIPCResult.append("sendVideoArkMsg result:");
      paramEIPCResult.append(bool);
      QLog.d("PeakIpcController", 2, paramEIPCResult.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.editipc.PeakIpcController.6
 * JD-Core Version:    0.7.0.1
 */