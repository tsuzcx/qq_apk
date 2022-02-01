package com.tencent.live2.jsplugin.player;

import android.os.Bundle;
import com.tencent.live2.V2TXLiveDef.V2TXLiveFillMode;
import com.tencent.live2.V2TXLiveDef.V2TXLiveRotation;
import com.tencent.live2.impl.b;

public class V2TXLivePlayerJSConfig
{
  public static int sAudioRoute;
  public int audioRoute = 0;
  public boolean enableDebugView;
  public boolean enableRecvSEIMessage;
  public V2TXLiveDef.V2TXLiveFillMode fillMode = V2TXLiveDef.V2TXLiveFillMode.V2TXLiveFillModeFill;
  public boolean isAutoPlay;
  public boolean isCanAutoPlay = true;
  public boolean isMuteAudio;
  public boolean isMuteVideo;
  public float maxCache = 3.0F;
  public float minCache = 1.0F;
  public int mode = 1;
  public V2TXLiveDef.V2TXLiveRotation renderRotation = V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation0;
  public String url = "";
  public int volumeNotifyIntervals;
  
  public V2TXLivePlayerJSConfig() {}
  
  public V2TXLivePlayerJSConfig(V2TXLivePlayerJSConfig paramV2TXLivePlayerJSConfig)
  {
    this.url = paramV2TXLivePlayerJSConfig.url;
    this.mode = paramV2TXLivePlayerJSConfig.mode;
    this.isAutoPlay = paramV2TXLivePlayerJSConfig.isAutoPlay;
    this.isCanAutoPlay = paramV2TXLivePlayerJSConfig.isCanAutoPlay;
    this.isMuteAudio = paramV2TXLivePlayerJSConfig.isMuteAudio;
    this.isMuteVideo = paramV2TXLivePlayerJSConfig.isMuteVideo;
    this.enableDebugView = paramV2TXLivePlayerJSConfig.enableDebugView;
    this.enableRecvSEIMessage = paramV2TXLivePlayerJSConfig.enableRecvSEIMessage;
    this.minCache = paramV2TXLivePlayerJSConfig.minCache;
    this.maxCache = paramV2TXLivePlayerJSConfig.maxCache;
    this.volumeNotifyIntervals = paramV2TXLivePlayerJSConfig.volumeNotifyIntervals;
    this.audioRoute = paramV2TXLivePlayerJSConfig.audioRoute;
    this.fillMode = paramV2TXLivePlayerJSConfig.fillMode;
    this.renderRotation = paramV2TXLivePlayerJSConfig.renderRotation;
  }
  
  public String diffConfig(V2TXLivePlayerJSConfig paramV2TXLivePlayerJSConfig)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = this.url;
    if ((str != null) && (!str.equals(paramV2TXLivePlayerJSConfig.url)))
    {
      localStringBuilder.append("[url:");
      localStringBuilder.append(b.b(this.url));
      localStringBuilder.append("]");
    }
    if (this.mode != paramV2TXLivePlayerJSConfig.mode)
    {
      localStringBuilder.append("[mode:");
      localStringBuilder.append(this.mode);
      localStringBuilder.append("]");
    }
    if (this.isCanAutoPlay != paramV2TXLivePlayerJSConfig.isCanAutoPlay)
    {
      localStringBuilder.append("[isCanAutoPlay:");
      localStringBuilder.append(this.isCanAutoPlay);
      localStringBuilder.append("]");
    }
    if (this.isAutoPlay != paramV2TXLivePlayerJSConfig.isAutoPlay)
    {
      localStringBuilder.append("[isAutoPlay:");
      localStringBuilder.append(this.isAutoPlay);
      localStringBuilder.append("]");
    }
    if (this.isMuteVideo != paramV2TXLivePlayerJSConfig.isMuteVideo)
    {
      localStringBuilder.append("[isMuteVideo:");
      localStringBuilder.append(this.isMuteVideo);
      localStringBuilder.append("]");
    }
    if (this.isMuteAudio != paramV2TXLivePlayerJSConfig.isMuteAudio)
    {
      localStringBuilder.append("[isMuteAudio:");
      localStringBuilder.append(this.isMuteAudio);
      localStringBuilder.append("]");
    }
    if (this.enableRecvSEIMessage != paramV2TXLivePlayerJSConfig.enableRecvSEIMessage)
    {
      localStringBuilder.append("[enableRecvSEIMessage:");
      localStringBuilder.append(this.enableRecvSEIMessage);
      localStringBuilder.append("]");
    }
    if (this.minCache != paramV2TXLivePlayerJSConfig.minCache)
    {
      localStringBuilder.append("[minCache:");
      localStringBuilder.append(this.minCache);
      localStringBuilder.append("]");
    }
    if (this.maxCache != paramV2TXLivePlayerJSConfig.maxCache)
    {
      localStringBuilder.append("[macCache:");
      localStringBuilder.append(this.maxCache);
      localStringBuilder.append("]");
    }
    if (this.audioRoute != paramV2TXLivePlayerJSConfig.audioRoute)
    {
      localStringBuilder.append("[audioRoute:");
      if (this.audioRoute == 0) {
        str = "speaker";
      } else {
        str = "ear";
      }
      localStringBuilder.append(str);
      localStringBuilder.append("]");
    }
    if (this.volumeNotifyIntervals != paramV2TXLivePlayerJSConfig.volumeNotifyIntervals)
    {
      localStringBuilder.append("[volumeNotifyIntervals:");
      localStringBuilder.append(this.volumeNotifyIntervals);
      localStringBuilder.append("]");
    }
    if (this.fillMode != paramV2TXLivePlayerJSConfig.fillMode)
    {
      localStringBuilder.append("[fillMode:");
      localStringBuilder.append(this.fillMode);
      localStringBuilder.append("]");
    }
    if (this.renderRotation != paramV2TXLivePlayerJSConfig.renderRotation)
    {
      localStringBuilder.append("[renderRotation:");
      localStringBuilder.append(this.renderRotation);
      localStringBuilder.append("]");
    }
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[url:");
    localStringBuilder.append(b.b(this.url));
    localStringBuilder.append("][mode:");
    localStringBuilder.append(this.mode);
    localStringBuilder.append("][isAutoPlay:");
    localStringBuilder.append(this.isAutoPlay);
    localStringBuilder.append("][isCanAutoPlay:");
    localStringBuilder.append(this.isCanAutoPlay);
    localStringBuilder.append("][isMuteVideo:");
    localStringBuilder.append(this.isMuteVideo);
    localStringBuilder.append("][isMuteAudio:");
    localStringBuilder.append(this.isMuteAudio);
    localStringBuilder.append("][enableDebugView:");
    localStringBuilder.append(this.enableDebugView);
    localStringBuilder.append("][enableRecvSEIMessage:");
    localStringBuilder.append(this.enableRecvSEIMessage);
    localStringBuilder.append("][minCache:");
    localStringBuilder.append(this.minCache);
    localStringBuilder.append("][maxCache:");
    localStringBuilder.append(this.maxCache);
    localStringBuilder.append("][volumeNotifyIntervals:");
    localStringBuilder.append(this.volumeNotifyIntervals);
    localStringBuilder.append("][audioRoute:");
    String str;
    if (this.audioRoute == 0) {
      str = "speaker";
    } else {
      str = "ear";
    }
    localStringBuilder.append(str);
    localStringBuilder.append("][fillMode:");
    localStringBuilder.append(this.fillMode);
    localStringBuilder.append("][renderRotation:");
    localStringBuilder.append(this.renderRotation);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public void updateFromBundle(Bundle paramBundle)
  {
    if (paramBundle.containsKey("playUrl")) {
      this.url = paramBundle.getString("playUrl", "");
    }
    if (paramBundle.containsKey("mode")) {
      this.mode = paramBundle.getInt("mode");
    }
    if (paramBundle.containsKey("autoplay")) {
      this.isAutoPlay = paramBundle.getBoolean("autoplay");
    }
    if (paramBundle.containsKey("canStartPlay")) {
      this.isCanAutoPlay = paramBundle.getBoolean("canStartPlay");
    }
    if (paramBundle.containsKey("muteVideo")) {
      this.isMuteVideo = paramBundle.getBoolean("muteVideo");
    }
    if (paramBundle.containsKey("muteAudio")) {
      this.isMuteAudio = paramBundle.getBoolean("muteAudio");
    }
    if (paramBundle.containsKey("muted")) {
      this.isMuteAudio = paramBundle.getBoolean("muted");
    }
    String str;
    if (paramBundle.containsKey("orientation"))
    {
      str = paramBundle.getString("orientation", "");
      if (str.equalsIgnoreCase("horizontal")) {
        this.renderRotation = V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation270;
      } else if (str.equalsIgnoreCase("vertical")) {
        this.renderRotation = V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation0;
      }
    }
    if (paramBundle.containsKey("objectFit"))
    {
      str = paramBundle.getString("objectFit", "");
      if (str.equalsIgnoreCase("fillCrop")) {
        this.fillMode = V2TXLiveDef.V2TXLiveFillMode.V2TXLiveFillModeFill;
      } else if (str.equalsIgnoreCase("contain")) {
        this.fillMode = V2TXLiveDef.V2TXLiveFillMode.V2TXLiveFillModeFit;
      }
    }
    if (paramBundle.containsKey("minCache")) {
      this.minCache = paramBundle.getFloat("minCache");
    }
    if (paramBundle.containsKey("maxCache")) {
      this.maxCache = paramBundle.getFloat("maxCache");
    }
    if (paramBundle.containsKey("enableRecvMessage")) {
      this.enableRecvSEIMessage = paramBundle.getBoolean("enableRecvMessage");
    }
    if (paramBundle.containsKey("needAudioVolume"))
    {
      int i;
      if (paramBundle.getBoolean("needAudioVolume")) {
        i = 300;
      } else {
        i = 0;
      }
      this.volumeNotifyIntervals = i;
    }
    if (paramBundle.containsKey("debug")) {
      this.enableDebugView = paramBundle.getBoolean("debug");
    }
    if (paramBundle.containsKey("soundMode"))
    {
      paramBundle = paramBundle.getString("soundMode", "");
      if (paramBundle.equalsIgnoreCase("speaker")) {
        this.audioRoute = 0;
      } else if (paramBundle.equalsIgnoreCase("ear")) {
        this.audioRoute = 1;
      }
      sAudioRoute = this.audioRoute;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.jsplugin.player.V2TXLivePlayerJSConfig
 * JD-Core Version:    0.7.0.1
 */