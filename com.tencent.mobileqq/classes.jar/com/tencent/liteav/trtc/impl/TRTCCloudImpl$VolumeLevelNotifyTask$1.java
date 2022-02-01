package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.trtc.TRTCCloudDef.TRTCVolumeInfo;
import java.util.ArrayList;

class TRTCCloudImpl$VolumeLevelNotifyTask$1
  implements TRTCRoomInfo.UserAction
{
  TRTCCloudImpl$VolumeLevelNotifyTask$1(TRTCCloudImpl.VolumeLevelNotifyTask paramVolumeLevelNotifyTask, ArrayList paramArrayList) {}
  
  public void accept(String paramString, TRTCRoomInfo.UserInfo paramUserInfo)
  {
    int i = TXCAudioEngine.getInstance().getRemotePlayoutVolumeLevel(String.valueOf(paramUserInfo.tinyID));
    if (i > 0)
    {
      paramString = new TRTCCloudDef.TRTCVolumeInfo();
      paramString.userId = paramUserInfo.userID;
      paramString.volume = i;
      this.val$volumeInfos.add(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.VolumeLevelNotifyTask.1
 * JD-Core Version:    0.7.0.1
 */