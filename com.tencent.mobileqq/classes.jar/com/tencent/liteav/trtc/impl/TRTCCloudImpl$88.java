package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.audio.TXCAudioEngine;
import org.json.JSONObject;

class TRTCCloudImpl$88
  implements Runnable
{
  TRTCCloudImpl$88(TRTCCloudImpl paramTRTCCloudImpl, String paramString1, JSONObject paramJSONObject, String paramString2) {}
  
  public void run()
  {
    try
    {
      if (this.val$api.equals("enableBlackStream"))
      {
        TRTCCloudImpl.access$6000(this.this$0, this.val$params);
        return;
      }
      if (this.val$api.equals("setSEIPayloadType"))
      {
        this.this$0.setSEIPayloadType(this.val$params);
        return;
      }
      if (this.val$api.equals("setLocalAudioMuteMode"))
      {
        TRTCCloudImpl.access$6100(this.this$0, this.val$params);
        return;
      }
      if (this.val$api.equals("setVideoEncodeParamEx"))
      {
        TRTCCloudImpl.access$6200(this.this$0, this.val$params);
        return;
      }
      if (this.val$api.equals("setAudioSampleRate"))
      {
        TRTCCloudImpl.access$6300(this.this$0, this.val$params);
        return;
      }
      if (this.val$api.equals("muteRemoteAudioInSpeaker"))
      {
        this.this$0.muteRemoteAudioInSpeaker(this.val$params);
        return;
      }
      if (this.val$api.equals("enableAudioAGC"))
      {
        TRTCCloudImpl.access$6400(this.this$0, this.val$params);
        return;
      }
      if (this.val$api.equals("enableAudioAEC"))
      {
        TRTCCloudImpl.access$6500(this.this$0, this.val$params);
        return;
      }
      if (this.val$api.equals("enableAudioANS"))
      {
        TRTCCloudImpl.access$6600(this.this$0, this.val$params);
        return;
      }
      if (this.val$api.equals("setPerformanceMode"))
      {
        this.this$0.setPerformanceMode(this.val$params);
        return;
      }
      if (this.val$api.equals("setCustomRenderMode"))
      {
        TRTCCloudImpl.access$6700(this.this$0, this.val$params);
        return;
      }
      if (this.val$api.equals("setMediaCodecConfig"))
      {
        TRTCCloudImpl.access$6800(this.this$0, this.val$params);
        return;
      }
      if (this.val$api.equals("sendJsonCMD"))
      {
        this.this$0.sendJsonCmd(this.val$params, this.val$jsonStr);
        return;
      }
      if (this.val$api.equals("updatePrivateMapKey"))
      {
        this.this$0.updatePrivateMapKey(this.val$params);
        return;
      }
      if (this.val$api.equals("setFramework"))
      {
        TRTCCloudImpl.access$6900(this.this$0, this.val$params);
        return;
      }
      if (this.val$api.equals("forceCallbackMixedPlayAudioFrame"))
      {
        TRTCCloudImpl.access$7000(this.this$0, this.val$params);
        return;
      }
      if (this.val$api.equals("setSystemAudioKitEnabled"))
      {
        TXCAudioEngine.getInstance().setSystemAudioKitEnabled();
        return;
      }
      if (this.val$api.equals("setKeepAVCaptureOption"))
      {
        TRTCCloudImpl.access$7100(this.this$0, this.val$params);
        return;
      }
      if (this.val$api.equals("setHeartBeatTimeoutSec"))
      {
        TRTCCloudImpl.access$7200(this.this$0, this.val$params);
        return;
      }
      if (this.val$api.equals("setNetEnv"))
      {
        TRTCCloudImpl.access$7300(this.this$0, this.val$params);
        return;
      }
      if (this.val$api.equals("SetAudioCacheParams"))
      {
        TXCAudioEngine.getInstance().SetAudioCacheParams(this.val$params.getInt("min_cache_time"), this.val$params.getInt("max_cache_time"));
        return;
      }
      if (this.val$api.equals("setRoomType"))
      {
        this.this$0.setRoomType(this.val$params);
        return;
      }
      if (this.val$api.equals("setAVSyncPlaySources"))
      {
        TRTCCloudImpl.access$7400(this.this$0, this.val$params);
        return;
      }
      if (this.val$api.equals("enableHevcEncode"))
      {
        TRTCCloudImpl.access$7500(this.this$0, this.val$params);
        return;
      }
      if (this.val$api.equals("setCustomCaptureGLSyncMode"))
      {
        TRTCCloudImpl.access$7600(this.this$0, this.val$params);
        return;
      }
      if (this.val$api.equals("setThreadPriority"))
      {
        TRTCCloudImpl.access$7700(this.this$0, this.val$params);
        return;
      }
      TRTCCloudImpl localTRTCCloudImpl = this.this$0;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("callExperimentalAPI[illegal api]: ");
      ((StringBuilder)localObject).append(this.val$api);
      localTRTCCloudImpl.apiLog(((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception localException)
    {
      Object localObject = this.this$0;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("callExperimentalAPI[failed]: ");
      localStringBuilder.append(this.val$jsonStr);
      localStringBuilder.append(" ");
      localStringBuilder.append(localException.getMessage());
      ((TRTCCloudImpl)localObject).apiLog(localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.88
 * JD-Core Version:    0.7.0.1
 */