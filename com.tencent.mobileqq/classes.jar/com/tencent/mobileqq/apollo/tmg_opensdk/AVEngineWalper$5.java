package com.tencent.mobileqq.apollo.tmg_opensdk;

import com.tencent.TMG.sdk.AVAudioCtrl.EnableSpeakerCompleteCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqavopensdk.AVEngineEventHandler;

class AVEngineWalper$5
  extends AVAudioCtrl.EnableSpeakerCompleteCallback
{
  AVEngineWalper$5(AVEngineWalper paramAVEngineWalper) {}
  
  public void onComplete(boolean paramBoolean, int paramInt)
  {
    QLog.d("AVEngineWalper", 1, "StartOpenSpeaker.OnComplete. bOpen = " + paramBoolean + ", result = " + paramInt);
    if (this.a.a != null) {
      this.a.a.b(paramBoolean, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.tmg_opensdk.AVEngineWalper.5
 * JD-Core Version:    0.7.0.1
 */