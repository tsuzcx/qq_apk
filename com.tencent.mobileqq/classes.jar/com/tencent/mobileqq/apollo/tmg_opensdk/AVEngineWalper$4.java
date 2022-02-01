package com.tencent.mobileqq.apollo.tmg_opensdk;

import com.tencent.TMG.sdk.AVAudioCtrl.EnableMicCompleteCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqavopensdk.AVEngineEventHandler;

class AVEngineWalper$4
  extends AVAudioCtrl.EnableMicCompleteCallback
{
  AVEngineWalper$4(AVEngineWalper paramAVEngineWalper) {}
  
  public void onComplete(boolean paramBoolean, int paramInt)
  {
    QLog.d("AVEngineWalper", 1, "StartOpenMic.OnComplete. bOpen = " + paramBoolean + ", result = " + paramInt);
    if (this.a.a != null) {
      this.a.a.a(paramBoolean, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.tmg_opensdk.AVEngineWalper.4
 * JD-Core Version:    0.7.0.1
 */