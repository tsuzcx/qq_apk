package com.tencent.mobileqq.activity.qwallet.voice;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.observer.BusinessObserver;

class VoiceRedPacketHelper$3$1
  implements BusinessObserver
{
  VoiceRedPacketHelper$3$1(VoiceRedPacketHelper.3 param3, long paramLong) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    ThreadManager.postImmediately(new VoiceRedPacketHelper.3.1.1(this, paramBoolean, paramBundle, paramInt), null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.voice.VoiceRedPacketHelper.3.1
 * JD-Core Version:    0.7.0.1
 */