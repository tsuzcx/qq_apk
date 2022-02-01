package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloudDef.TRTCMixUser;
import com.tencent.trtc.TRTCCloudDef.TRTCTranscodingConfig;
import java.util.ArrayList;
import java.util.Iterator;

public class TRTCTranscodingConfigInner
  extends TRTCCloudDef.TRTCTranscodingConfig
{
  public String backgroundURL;
  public String mixExtraInfo;
  
  public TRTCTranscodingConfigInner()
  {
    this.backgroundURL = "";
    this.mixExtraInfo = "";
  }
  
  public TRTCTranscodingConfigInner(TRTCCloudDef.TRTCTranscodingConfig paramTRTCTranscodingConfig)
  {
    this.appId = paramTRTCTranscodingConfig.appId;
    this.bizId = paramTRTCTranscodingConfig.bizId;
    this.mode = paramTRTCTranscodingConfig.mode;
    this.videoWidth = paramTRTCTranscodingConfig.videoWidth;
    this.videoHeight = paramTRTCTranscodingConfig.videoHeight;
    this.videoBitrate = paramTRTCTranscodingConfig.videoBitrate;
    this.videoFramerate = paramTRTCTranscodingConfig.videoFramerate;
    this.videoGOP = paramTRTCTranscodingConfig.videoGOP;
    this.backgroundColor = paramTRTCTranscodingConfig.backgroundColor;
    this.backgroundImage = paramTRTCTranscodingConfig.backgroundImage;
    this.audioSampleRate = paramTRTCTranscodingConfig.audioSampleRate;
    this.audioBitrate = paramTRTCTranscodingConfig.audioBitrate;
    this.audioChannels = paramTRTCTranscodingConfig.audioChannels;
    this.streamId = paramTRTCTranscodingConfig.streamId;
    this.backgroundURL = "";
    this.mixExtraInfo = "";
    this.mixUsers = new ArrayList();
    if (paramTRTCTranscodingConfig.mixUsers != null)
    {
      paramTRTCTranscodingConfig = paramTRTCTranscodingConfig.mixUsers.iterator();
      while (paramTRTCTranscodingConfig.hasNext())
      {
        TRTCCloudDef.TRTCMixUser localTRTCMixUser = (TRTCCloudDef.TRTCMixUser)paramTRTCTranscodingConfig.next();
        if (localTRTCMixUser != null) {
          this.mixUsers.add(new TRTCTranscodingConfigInner.TRTCMixUserInner(localTRTCMixUser));
        }
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("backgroundURL=");
    localStringBuilder.append(this.backgroundURL);
    localStringBuilder.append(", mixExtraInfo=");
    localStringBuilder.append(this.mixExtraInfo);
    localStringBuilder.append(", ");
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCTranscodingConfigInner
 * JD-Core Version:    0.7.0.1
 */