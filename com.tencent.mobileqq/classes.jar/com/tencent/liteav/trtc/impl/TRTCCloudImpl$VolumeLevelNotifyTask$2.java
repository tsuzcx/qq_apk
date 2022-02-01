package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloudListener;
import java.util.ArrayList;

class TRTCCloudImpl$VolumeLevelNotifyTask$2
  implements Runnable
{
  TRTCCloudImpl$VolumeLevelNotifyTask$2(TRTCCloudImpl.VolumeLevelNotifyTask paramVolumeLevelNotifyTask, TRTCCloudListener paramTRTCCloudListener, ArrayList paramArrayList, int paramInt) {}
  
  public void run()
  {
    TRTCCloudListener localTRTCCloudListener = this.val$listener;
    if (localTRTCCloudListener != null) {
      localTRTCCloudListener.onUserVoiceVolume(this.val$volumeInfos, this.val$corePlayVolume);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.VolumeLevelNotifyTask.2
 * JD-Core Version:    0.7.0.1
 */