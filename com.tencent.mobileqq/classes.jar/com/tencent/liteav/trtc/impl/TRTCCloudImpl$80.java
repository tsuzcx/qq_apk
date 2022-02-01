package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.d;
import org.json.JSONObject;

class TRTCCloudImpl$80
  implements Runnable
{
  TRTCCloudImpl$80(TRTCCloudImpl paramTRTCCloudImpl, String paramString) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        localObject3 = new JSONObject(this.val$jsonStr);
        if (!((JSONObject)localObject3).has("api"))
        {
          localObject1 = this.this$0;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("callExperimentalAPI[lack api or illegal type]: ");
          ((StringBuilder)localObject2).append(this.val$jsonStr);
          ((TRTCCloudImpl)localObject1).apiLog(((StringBuilder)localObject2).toString());
          return;
        }
        localObject2 = ((JSONObject)localObject3).getString("api");
        Object localObject1 = null;
        if (((JSONObject)localObject3).has("params")) {
          localObject1 = ((JSONObject)localObject3).getJSONObject("params");
        }
        if (((String)localObject2).equals("setSEIPayloadType"))
        {
          this.this$0.setSEIPayloadType((JSONObject)localObject1);
          return;
        }
        if (((String)localObject2).equals("setLocalAudioMuteMode"))
        {
          TRTCCloudImpl.access$5100(this.this$0, (JSONObject)localObject1);
          return;
        }
        if (((String)localObject2).equals("setVideoEncodeParamEx"))
        {
          TRTCCloudImpl.access$5200(this.this$0, (JSONObject)localObject1);
          return;
        }
        if (((String)localObject2).equals("setAudioSampleRate"))
        {
          TRTCCloudImpl.access$5300(this.this$0, (JSONObject)localObject1);
          return;
        }
        if (((String)localObject2).equals("muteRemoteAudioInSpeaker"))
        {
          this.this$0.muteRemoteAudioInSpeaker((JSONObject)localObject1);
          return;
        }
        if (((String)localObject2).equals("enableAudioAGC"))
        {
          TRTCCloudImpl.access$5400(this.this$0, (JSONObject)localObject1);
          return;
        }
        if (((String)localObject2).equals("enableAudioAEC"))
        {
          TRTCCloudImpl.access$5500(this.this$0, (JSONObject)localObject1);
          return;
        }
        if (((String)localObject2).equals("enableAudioANS"))
        {
          TRTCCloudImpl.access$5600(this.this$0, (JSONObject)localObject1);
          return;
        }
        if (((String)localObject2).equals("setPerformanceMode"))
        {
          this.this$0.setPerformanceMode((JSONObject)localObject1);
          return;
        }
        if (((String)localObject2).equals("setCustomRenderMode"))
        {
          TRTCCloudImpl.access$5700(this.this$0, (JSONObject)localObject1);
          return;
        }
        if (((String)localObject2).equals("setMediaCodecConfig"))
        {
          TRTCCloudImpl.access$5800(this.this$0, (JSONObject)localObject1);
          return;
        }
        if (((String)localObject2).equals("sendJsonCMD"))
        {
          this.this$0.sendJsonCmd((JSONObject)localObject1, this.val$jsonStr);
          return;
        }
        if (((String)localObject2).equals("updatePrivateMapKey"))
        {
          this.this$0.updatePrivateMapKey((JSONObject)localObject1);
          return;
        }
        if (((String)localObject2).equals("setFramework"))
        {
          TRTCCloudImpl.access$5900(this.this$0, (JSONObject)localObject1);
          return;
        }
        if (((String)localObject2).equals("forceCallbackMixedPlayAudioFrame"))
        {
          TRTCCloudImpl.access$6000(this.this$0, (JSONObject)localObject1);
          return;
        }
        if (((String)localObject2).equals("enableHevcEncode"))
        {
          if (((JSONObject)localObject1).has("enable"))
          {
            int i = ((JSONObject)localObject1).getInt("enable");
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("enableHevcEncode set = ");
            ((StringBuilder)localObject1).append(i);
            ((StringBuilder)localObject1).append(" ,mRoomState=");
            ((StringBuilder)localObject1).append(this.this$0.mRoomState);
            TXCLog.i("TRTCCloudImpl", ((StringBuilder)localObject1).toString());
            localObject1 = this.this$0;
            boolean bool2 = true;
            if (i == 0) {
              break label673;
            }
            bool1 = true;
            TRTCCloudImpl.access$6102((TRTCCloudImpl)localObject1, bool1);
            if (this.this$0.mCaptureAndEnc != null)
            {
              localObject1 = this.this$0.mCaptureAndEnc;
              if ((!TRTCCloudImpl.access$6100(this.this$0)) || (!TRTCCloudImpl.access$6200(this.this$0)) || (!TRTCCloudHevcUtil.isLifeCycleEnableHevcEncode())) {
                break label678;
              }
              bool1 = bool2;
              ((d)localObject1).j(bool1);
            }
          }
        }
        else
        {
          localObject1 = this.this$0;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("callExperimentalAPI[illegal api]: ");
          ((StringBuilder)localObject3).append((String)localObject2);
          ((TRTCCloudImpl)localObject1).apiLog(((StringBuilder)localObject3).toString());
          return;
        }
      }
      catch (Exception localException)
      {
        Object localObject2 = this.this$0;
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("callExperimentalAPI[failed]: ");
        ((StringBuilder)localObject3).append(this.val$jsonStr);
        ((StringBuilder)localObject3).append(" ");
        ((StringBuilder)localObject3).append(localException.getMessage());
        ((TRTCCloudImpl)localObject2).apiLog(((StringBuilder)localObject3).toString());
      }
      return;
      label673:
      boolean bool1 = false;
      continue;
      label678:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.80
 * JD-Core Version:    0.7.0.1
 */