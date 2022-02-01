package com.tencent.live2.jsplugin.pusher;

import android.os.Bundle;
import com.tencent.liteav.audio.TXAudioEffectManager.TXVoiceReverbType;
import com.tencent.liteav.device.TXDeviceManager.TXSystemVolumeType;
import com.tencent.live2.V2TXLiveDef.V2TXLiveAudioQuality;
import com.tencent.live2.V2TXLiveDef.V2TXLiveMirrorType;
import com.tencent.live2.impl.b;

public class V2TXLivePusherJSConfig
{
  private static final TXAudioEffectManager.TXVoiceReverbType[] REVERB_TYPES = { TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_0, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_1, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_2, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_3, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_4, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_5, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_6, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_7 };
  public int aspect = 2;
  public V2TXLiveDef.V2TXLiveAudioQuality audioQuality = V2TXLiveDef.V2TXLiveAudioQuality.V2TXLiveAudioQualityDefault;
  public String backgroundImagePath = "";
  public int beautyLevel = 5;
  public int beautyStyle = 0;
  public boolean enableAGC = false;
  public boolean enableANS = false;
  public boolean enableAutoFocus = true;
  public boolean enableBGMEventCallback = false;
  public boolean enableCamera = true;
  public boolean enableDebugView = false;
  public boolean enableEarMonitor = false;
  public boolean enableMicrophone = true;
  public boolean enableRemoteMirror = false;
  public boolean enableZoom = false;
  public String filterImagePath;
  public int height = 640;
  public boolean isAutoPush = false;
  public boolean isFrontCamera = true;
  public boolean isMuteAudio = false;
  public boolean isVerticalOrientation = true;
  public int maxBitrate = 0;
  public int minBitrate = 0;
  public V2TXLiveDef.V2TXLiveMirrorType mirrorType = V2TXLiveDef.V2TXLiveMirrorType.V2TXLiveMirrorTypeAuto;
  public int mode = 1;
  public TXAudioEffectManager.TXVoiceReverbType reverbType = TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_0;
  public String url = "";
  public int volumeNotifyIntervals = 0;
  public TXDeviceManager.TXSystemVolumeType volumeType = TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeAuto;
  public String watermarkImagePath = "";
  public float watermarkLeft = 0.0F;
  public float watermarkTop = 0.0F;
  public float watermarkWidth = 0.1F;
  public int whitenessLevel = 3;
  public int width = 368;
  
  public V2TXLivePusherJSConfig() {}
  
  public V2TXLivePusherJSConfig(V2TXLivePusherJSConfig paramV2TXLivePusherJSConfig)
  {
    this.url = paramV2TXLivePusherJSConfig.url;
    this.mode = paramV2TXLivePusherJSConfig.mode;
    this.isAutoPush = paramV2TXLivePusherJSConfig.isAutoPush;
    this.enableBGMEventCallback = paramV2TXLivePusherJSConfig.enableBGMEventCallback;
    this.enableDebugView = paramV2TXLivePusherJSConfig.enableDebugView;
    this.enableCamera = paramV2TXLivePusherJSConfig.enableCamera;
    this.isFrontCamera = paramV2TXLivePusherJSConfig.isFrontCamera;
    this.enableAutoFocus = paramV2TXLivePusherJSConfig.enableAutoFocus;
    this.isVerticalOrientation = paramV2TXLivePusherJSConfig.isVerticalOrientation;
    this.enableZoom = paramV2TXLivePusherJSConfig.enableZoom;
    this.enableRemoteMirror = paramV2TXLivePusherJSConfig.enableRemoteMirror;
    this.aspect = paramV2TXLivePusherJSConfig.aspect;
    this.width = paramV2TXLivePusherJSConfig.width;
    this.height = paramV2TXLivePusherJSConfig.height;
    this.minBitrate = paramV2TXLivePusherJSConfig.minBitrate;
    this.maxBitrate = paramV2TXLivePusherJSConfig.maxBitrate;
    this.mirrorType = paramV2TXLivePusherJSConfig.mirrorType;
    this.enableMicrophone = paramV2TXLivePusherJSConfig.enableMicrophone;
    this.isMuteAudio = paramV2TXLivePusherJSConfig.isMuteAudio;
    this.enableAGC = paramV2TXLivePusherJSConfig.enableAGC;
    this.enableANS = paramV2TXLivePusherJSConfig.enableANS;
    this.enableEarMonitor = paramV2TXLivePusherJSConfig.enableEarMonitor;
    this.volumeNotifyIntervals = paramV2TXLivePusherJSConfig.volumeNotifyIntervals;
    this.volumeType = paramV2TXLivePusherJSConfig.volumeType;
    this.reverbType = paramV2TXLivePusherJSConfig.reverbType;
    this.audioQuality = paramV2TXLivePusherJSConfig.audioQuality;
    this.beautyStyle = paramV2TXLivePusherJSConfig.beautyStyle;
    this.beautyLevel = paramV2TXLivePusherJSConfig.beautyLevel;
    this.whitenessLevel = paramV2TXLivePusherJSConfig.whitenessLevel;
    this.filterImagePath = paramV2TXLivePusherJSConfig.filterImagePath;
    this.watermarkImagePath = paramV2TXLivePusherJSConfig.watermarkImagePath;
    this.watermarkTop = paramV2TXLivePusherJSConfig.watermarkTop;
    this.watermarkLeft = paramV2TXLivePusherJSConfig.watermarkLeft;
    this.watermarkWidth = paramV2TXLivePusherJSConfig.watermarkWidth;
    this.backgroundImagePath = paramV2TXLivePusherJSConfig.backgroundImagePath;
  }
  
  public String diffConfig(V2TXLivePusherJSConfig paramV2TXLivePusherJSConfig)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2;
    if (this.url != paramV2TXLivePusherJSConfig.url)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[url:");
      localStringBuilder2.append(b.b(this.url));
      localStringBuilder2.append("]");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (this.mode != paramV2TXLivePusherJSConfig.mode)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[mode:");
      localStringBuilder2.append(this.mode);
      localStringBuilder2.append("]");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (this.enableCamera != paramV2TXLivePusherJSConfig.enableCamera)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[enableCamera:");
      localStringBuilder2.append(this.enableCamera);
      localStringBuilder2.append("]");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (this.isFrontCamera != paramV2TXLivePusherJSConfig.isFrontCamera)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[isFrontCamera:");
      localStringBuilder2.append(this.isFrontCamera);
      localStringBuilder2.append("]");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (this.isVerticalOrientation != paramV2TXLivePusherJSConfig.isVerticalOrientation)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[isVerticalOrientation:");
      localStringBuilder2.append(this.isVerticalOrientation);
      localStringBuilder2.append("]");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (this.aspect != paramV2TXLivePusherJSConfig.aspect)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[aspect:");
      localStringBuilder2.append(this.aspect);
      localStringBuilder2.append("]");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (this.width != paramV2TXLivePusherJSConfig.width)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[width:");
      localStringBuilder2.append(this.width);
      localStringBuilder2.append("]");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (this.height != paramV2TXLivePusherJSConfig.height)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[height:");
      localStringBuilder2.append(this.height);
      localStringBuilder2.append("]");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (this.minBitrate != paramV2TXLivePusherJSConfig.minBitrate)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[minBitrate:");
      localStringBuilder2.append(this.minBitrate);
      localStringBuilder2.append("]");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (this.maxBitrate != paramV2TXLivePusherJSConfig.maxBitrate)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[maxBitrate:");
      localStringBuilder2.append(this.maxBitrate);
      localStringBuilder2.append("]");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (this.enableMicrophone != paramV2TXLivePusherJSConfig.enableMicrophone)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[enableMicrophone:");
      localStringBuilder2.append(this.enableMicrophone);
      localStringBuilder2.append("]");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (this.isMuteAudio != paramV2TXLivePusherJSConfig.isMuteAudio)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[isMuteAudio:");
      localStringBuilder2.append(this.isMuteAudio);
      localStringBuilder2.append("]");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (this.enableAGC != paramV2TXLivePusherJSConfig.enableAGC)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[enableAGC:");
      localStringBuilder2.append(this.enableAGC);
      localStringBuilder2.append("]");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (this.enableANS != paramV2TXLivePusherJSConfig.enableANS)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[enableANS:");
      localStringBuilder2.append(this.enableANS);
      localStringBuilder2.append("]");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    boolean bool = this.enableEarMonitor;
    if (this.volumeType != paramV2TXLivePusherJSConfig.volumeType)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[volumeType:");
      localStringBuilder2.append(this.volumeType);
      localStringBuilder2.append("]");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (this.audioQuality != paramV2TXLivePusherJSConfig.audioQuality)
    {
      paramV2TXLivePusherJSConfig = new StringBuilder();
      paramV2TXLivePusherJSConfig.append("[audioQuality:");
      paramV2TXLivePusherJSConfig.append(this.audioQuality);
      paramV2TXLivePusherJSConfig.append("]");
      localStringBuilder1.append(paramV2TXLivePusherJSConfig.toString());
    }
    return localStringBuilder1.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[url:");
    localStringBuilder.append(b.b(this.url));
    localStringBuilder.append("][mode:");
    localStringBuilder.append(this.mode);
    localStringBuilder.append("][isAutoPush:");
    localStringBuilder.append(this.isAutoPush);
    localStringBuilder.append("][enableCamera:");
    localStringBuilder.append(this.enableCamera);
    localStringBuilder.append("][isVerticalOrientation:");
    localStringBuilder.append(this.isVerticalOrientation);
    localStringBuilder.append("][aspect:");
    localStringBuilder.append(this.aspect);
    localStringBuilder.append("][width:");
    localStringBuilder.append(this.width);
    localStringBuilder.append("][height:");
    localStringBuilder.append(this.height);
    localStringBuilder.append("][minBitrate:");
    localStringBuilder.append(this.minBitrate);
    localStringBuilder.append("][maxBitrate:");
    localStringBuilder.append(this.maxBitrate);
    localStringBuilder.append("][enableMicrophone:");
    localStringBuilder.append(this.enableMicrophone);
    localStringBuilder.append("][isMuteAudio:");
    localStringBuilder.append(this.isMuteAudio);
    localStringBuilder.append("][enableAGC:");
    localStringBuilder.append(this.enableAGC);
    localStringBuilder.append("][enableANS:");
    localStringBuilder.append(this.enableANS);
    localStringBuilder.append("][enableEarMonitor:");
    localStringBuilder.append(this.enableEarMonitor);
    localStringBuilder.append("][volumeType:");
    localStringBuilder.append(this.volumeType);
    localStringBuilder.append("][audioQuality:");
    localStringBuilder.append(this.audioQuality);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public void updateFromBundle(Bundle paramBundle)
  {
    if (paramBundle.containsKey("pushUrl")) {
      this.url = paramBundle.getString("pushUrl", "");
    }
    if (paramBundle.containsKey("mode")) {
      this.mode = paramBundle.getInt("mode");
    }
    if (paramBundle.containsKey("autopush")) {
      this.isAutoPush = paramBundle.getBoolean("autopush");
    }
    if (paramBundle.containsKey("needBGMEvent")) {
      this.enableBGMEventCallback = paramBundle.getBoolean("needBGMEvent");
    }
    if (paramBundle.containsKey("debug")) {
      this.enableDebugView = paramBundle.getBoolean("debug");
    }
    if (paramBundle.containsKey("enableCamera")) {
      this.enableCamera = paramBundle.getBoolean("enableCamera");
    }
    if (paramBundle.containsKey("devicePosition")) {
      this.isFrontCamera = ("back".equals(paramBundle.getString("devicePosition", "")) ^ true);
    }
    if (paramBundle.containsKey("focusMode"))
    {
      if (paramBundle.getInt("focusMode") == 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.enableAutoFocus = bool;
    }
    if (paramBundle.containsKey("orientation")) {
      this.isVerticalOrientation = ("horizontal".equals(paramBundle.getString("orientation", "")) ^ true);
    }
    if (paramBundle.containsKey("zoom")) {
      this.enableZoom = paramBundle.getBoolean("zoom");
    }
    if (paramBundle.containsKey("mirror")) {
      this.enableRemoteMirror = paramBundle.getBoolean("mirror");
    }
    if (paramBundle.containsKey("remoteMirror")) {
      this.enableRemoteMirror = paramBundle.getBoolean("remoteMirror");
    }
    if (paramBundle.containsKey("aspect")) {
      this.aspect = paramBundle.getInt("aspect");
    }
    if (paramBundle.containsKey("videoWidth")) {
      this.width = paramBundle.getInt("videoWidth");
    }
    if (paramBundle.containsKey("videoHeight")) {
      this.height = paramBundle.getInt("videoHeight");
    }
    if (paramBundle.containsKey("minBitrate")) {
      this.minBitrate = paramBundle.getInt("minBitrate");
    }
    if (paramBundle.containsKey("maxBitrate")) {
      this.maxBitrate = paramBundle.getInt("maxBitrate");
    }
    boolean bool = paramBundle.containsKey("localMirror");
    int j = -1;
    Object localObject;
    int i;
    if (bool)
    {
      localObject = paramBundle.getString("localMirror", "");
      i = ((String)localObject).hashCode();
      if (i != -1298848381)
      {
        if ((i == 1671308008) && (((String)localObject).equals("disable")))
        {
          i = 1;
          break label477;
        }
      }
      else if (((String)localObject).equals("enable"))
      {
        i = 0;
        break label477;
      }
      i = -1;
      label477:
      if (i != 0)
      {
        if (i != 1) {
          this.mirrorType = V2TXLiveDef.V2TXLiveMirrorType.V2TXLiveMirrorTypeAuto;
        } else {
          this.mirrorType = V2TXLiveDef.V2TXLiveMirrorType.V2TXLiveMirrorTypeDisable;
        }
      }
      else {
        this.mirrorType = V2TXLiveDef.V2TXLiveMirrorType.V2TXLiveMirrorTypeEnable;
      }
    }
    if (paramBundle.containsKey("muted")) {
      this.isMuteAudio = paramBundle.getBoolean("muted");
    }
    if (paramBundle.containsKey("enableMic")) {
      this.enableMicrophone = paramBundle.getBoolean("enableMic");
    }
    if (paramBundle.containsKey("audioQuality"))
    {
      localObject = paramBundle.getString("audioQuality", "");
      if ((((String)localObject).hashCode() == 107348) && (((String)localObject).equals("low"))) {
        i = 0;
      } else {
        i = -1;
      }
      if (i != 0) {
        this.audioQuality = V2TXLiveDef.V2TXLiveAudioQuality.V2TXLiveAudioQualityDefault;
      } else {
        this.audioQuality = V2TXLiveDef.V2TXLiveAudioQuality.V2TXLiveAudioQualitySpeech;
      }
    }
    if (paramBundle.containsKey("enableAGC")) {
      this.enableAGC = paramBundle.getBoolean("enableAGC");
    }
    if (paramBundle.containsKey("enableANS")) {
      this.enableANS = paramBundle.getBoolean("enableANS");
    }
    if (paramBundle.containsKey("enableEarMonitor")) {
      this.enableEarMonitor = paramBundle.getBoolean("enableEarMonitor");
    }
    if (paramBundle.containsKey("audioVolumeType"))
    {
      localObject = paramBundle.getString("audioVolumeType", "");
      i = ((String)localObject).hashCode();
      if (i != -1018596720)
      {
        if ((i == 103772132) && (((String)localObject).equals("media")))
        {
          i = 1;
          break label770;
        }
      }
      else if (((String)localObject).equals("voicecall"))
      {
        i = 0;
        break label770;
      }
      i = -1;
      label770:
      if (i != 0)
      {
        if (i != 1) {
          this.volumeType = TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeAuto;
        } else {
          this.volumeType = TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeMedia;
        }
      }
      else {
        this.volumeType = TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeVOIP;
      }
    }
    if (paramBundle.containsKey("audioReverbType"))
    {
      i = paramBundle.getInt("audioReverbType");
      if (i >= 0)
      {
        localObject = REVERB_TYPES;
        if (i < localObject.length) {
          this.reverbType = localObject[i];
        }
      }
    }
    if (paramBundle.containsKey("needAudioVolume"))
    {
      if (paramBundle.getBoolean("needAudioVolume")) {
        i = 300;
      } else {
        i = 0;
      }
      this.volumeNotifyIntervals = i;
    }
    if (paramBundle.containsKey("beautyStyle"))
    {
      localObject = paramBundle.getString("beautyStyle", "");
      if (((String)localObject).hashCode() != -1052607321)
      {
        i = j;
      }
      else
      {
        i = j;
        if (((String)localObject).equals("nature")) {
          i = 0;
        }
      }
      if (i != 0) {
        this.beautyStyle = 0;
      } else {
        this.beautyStyle = 1;
      }
    }
    if (paramBundle.containsKey("beauty")) {
      this.beautyLevel = paramBundle.getInt("beauty");
    }
    if (paramBundle.containsKey("whiteness")) {
      this.whitenessLevel = paramBundle.getInt("whiteness");
    }
    if (paramBundle.containsKey("filterImage")) {
      this.filterImagePath = paramBundle.getString("filterImage", "");
    }
    if (paramBundle.containsKey("watermarkImage")) {
      this.watermarkImagePath = paramBundle.getString("watermarkImage", "");
    }
    if (paramBundle.containsKey("watermarkLeft")) {
      this.watermarkLeft = paramBundle.getFloat("watermarkLeft");
    }
    if (paramBundle.containsKey("watermarkTop")) {
      this.watermarkTop = paramBundle.getFloat("watermarkTop");
    }
    if (paramBundle.containsKey("watermarkWidth")) {
      this.watermarkWidth = paramBundle.getFloat("watermarkWidth");
    }
    if (paramBundle.containsKey("backgroundImage")) {
      this.backgroundImagePath = paramBundle.getString("backgroundImage", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.jsplugin.pusher.V2TXLivePusherJSConfig
 * JD-Core Version:    0.7.0.1
 */