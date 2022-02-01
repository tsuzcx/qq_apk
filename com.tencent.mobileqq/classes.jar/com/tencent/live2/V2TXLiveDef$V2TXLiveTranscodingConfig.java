package com.tencent.live2;

import java.util.ArrayList;

public final class V2TXLiveDef$V2TXLiveTranscodingConfig
{
  public int audioBitrate;
  public int audioChannels;
  public int audioSampleRate;
  public int backgroundColor;
  public String backgroundImage;
  public ArrayList<V2TXLiveDef.V2TXLiveMixStream> mixStreams;
  public String outputStreamId;
  public int videoBitrate;
  public int videoFramerate;
  public int videoGOP;
  public int videoHeight;
  public int videoWidth;
  
  public V2TXLiveDef$V2TXLiveTranscodingConfig()
  {
    this.videoWidth = 0;
    this.videoHeight = 0;
    this.videoBitrate = 0;
    this.videoFramerate = 15;
    this.videoGOP = 2;
    this.backgroundColor = 0;
    this.audioSampleRate = 48000;
    this.audioBitrate = 64;
    this.audioChannels = 1;
    this.outputStreamId = null;
  }
  
  public V2TXLiveDef$V2TXLiveTranscodingConfig(V2TXLiveTranscodingConfig paramV2TXLiveTranscodingConfig)
  {
    this.videoWidth = paramV2TXLiveTranscodingConfig.videoWidth;
    this.videoHeight = paramV2TXLiveTranscodingConfig.videoHeight;
    this.videoBitrate = paramV2TXLiveTranscodingConfig.videoBitrate;
    this.videoFramerate = paramV2TXLiveTranscodingConfig.videoFramerate;
    this.videoGOP = paramV2TXLiveTranscodingConfig.videoGOP;
    this.backgroundColor = paramV2TXLiveTranscodingConfig.backgroundColor;
    this.backgroundImage = paramV2TXLiveTranscodingConfig.backgroundImage;
    this.audioSampleRate = paramV2TXLiveTranscodingConfig.audioSampleRate;
    this.audioBitrate = paramV2TXLiveTranscodingConfig.audioBitrate;
    this.audioChannels = paramV2TXLiveTranscodingConfig.audioChannels;
    this.outputStreamId = paramV2TXLiveTranscodingConfig.outputStreamId;
    this.mixStreams = new ArrayList(paramV2TXLiveTranscodingConfig.mixStreams);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[videoWidth=");
    localStringBuilder.append(this.videoWidth);
    localStringBuilder.append("][videoHeight=");
    localStringBuilder.append(this.videoHeight);
    localStringBuilder.append("][videoBitrate=");
    localStringBuilder.append(this.videoBitrate);
    localStringBuilder.append("][videoFramerate=");
    localStringBuilder.append(this.videoFramerate);
    localStringBuilder.append("][videoGOP=");
    localStringBuilder.append(this.videoGOP);
    localStringBuilder.append("][backgroundColor=");
    localStringBuilder.append(this.backgroundColor);
    localStringBuilder.append("][backgroundImage='");
    localStringBuilder.append(this.backgroundImage);
    localStringBuilder.append('\'');
    localStringBuilder.append("][audioSampleRate=");
    localStringBuilder.append(this.audioSampleRate);
    localStringBuilder.append("][audioBitrate=");
    localStringBuilder.append(this.audioBitrate);
    localStringBuilder.append("][audioChannels=");
    localStringBuilder.append(this.audioChannels);
    localStringBuilder.append("][mixStreams=");
    localStringBuilder.append(this.mixStreams);
    localStringBuilder.append("][outputStreamId='");
    localStringBuilder.append(this.outputStreamId);
    localStringBuilder.append('\'');
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.V2TXLiveDef.V2TXLiveTranscodingConfig
 * JD-Core Version:    0.7.0.1
 */