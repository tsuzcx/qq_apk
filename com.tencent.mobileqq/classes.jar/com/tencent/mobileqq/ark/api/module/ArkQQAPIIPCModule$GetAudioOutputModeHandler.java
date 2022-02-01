package com.tencent.mobileqq.ark.api.module;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ipc.IPCSyncMethodHandler;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioDeviceHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class ArkQQAPIIPCModule$GetAudioOutputModeHandler
  implements IPCSyncMethodHandler
{
  private int b()
  {
    if (AudioDeviceHelper.a(BaseApplicationImpl.getContext())) {
      return 1;
    }
    if (AudioDeviceHelper.b(BaseApplicationImpl.getContext())) {
      return 2;
    }
    QQAppInterface localQQAppInterface = ArkQQAPIIPCModule.d();
    if (localQQAppInterface != null)
    {
      if (AudioDeviceHelper.a(localQQAppInterface)) {
        return 4;
      }
      return 3;
    }
    return -1;
  }
  
  public EIPCResult a(Bundle paramBundle)
  {
    if (ArkQQAPIIPCModule.d() == null)
    {
      QLog.e("ArkApp.GetAudioOutputModeHandler", 1, "GetAudioOutputModeHandler.onCall, qq app is null");
      return EIPCResult.createResult(-102, new Bundle());
    }
    int i = b();
    paramBundle = new Bundle();
    paramBundle.putInt("mode", i);
    return EIPCResult.createResult(0, paramBundle);
  }
  
  public String a()
  {
    return "QQ.GetAudioOutputModeHandler";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkQQAPIIPCModule.GetAudioOutputModeHandler
 * JD-Core Version:    0.7.0.1
 */