package com.tencent.liteav.trtc.impl;

import android.os.Bundle;
import com.tencent.liteav.d;
import com.tencent.liteav.g;
import com.tencent.liteav.g.a;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoEncParam;

class TRTCCloudImpl$47
  implements Runnable
{
  TRTCCloudImpl$47(TRTCCloudImpl paramTRTCCloudImpl, boolean paramBoolean, TRTCCloudDef.TRTCVideoEncParam paramTRTCVideoEncParam) {}
  
  public void run()
  {
    Object localObject1 = this.this$0;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("enableEncSmallVideoStream ");
    ((StringBuilder)localObject2).append(this.val$enable);
    ((TRTCCloudImpl)localObject1).apiLog(((StringBuilder)localObject2).toString());
    TRTCCloudImpl.access$902(this.this$0, this.val$enable);
    localObject1 = this.this$0;
    ((TRTCCloudImpl)localObject1).enableNetworkSmallStream(TRTCCloudImpl.access$900((TRTCCloudImpl)localObject1));
    if (this.val$param != null)
    {
      TRTCCloudImpl.access$1000(this.this$0).videoBitrate = this.val$param.videoBitrate;
      TRTCCloudImpl.access$1000(this.this$0).minVideoBitrate = this.val$param.minVideoBitrate;
      TRTCCloudImpl.access$1000(this.this$0).videoFps = this.val$param.videoFps;
      TRTCCloudImpl.access$1000(this.this$0).videoResolution = this.val$param.videoResolution;
      TRTCCloudImpl.access$1000(this.this$0).videoResolutionMode = this.val$param.videoResolutionMode;
      TRTCCloudImpl.access$4300(this.this$0).putInt("config_fps", this.val$param.videoFps);
      TRTCCloudImpl.access$4300(this.this$0).putBoolean("config_adjust_resolution", this.val$param.enableAdjustRes);
    }
    boolean bool = this.this$0.mConfig.q;
    int i = this.this$0.mConfig.j;
    if (TRTCCloudImpl.access$1600(this.this$0) == TRTCCloudImpl.VideoSourceType.SCREEN)
    {
      if (TRTCCloudImpl.access$3500(this.this$0)) {
        TRTCCloudImpl.access$1000(this.this$0).videoFps = 10;
      }
      i = 3;
      bool = false;
    }
    localObject1 = this.this$0.mRoomInfo;
    localObject2 = this.this$0;
    ((TRTCRoomInfo)localObject1).smallEncSize = TRTCCloudImpl.access$3800((TRTCCloudImpl)localObject2, TRTCCloudImpl.access$1000((TRTCCloudImpl)localObject2).videoResolution, TRTCCloudImpl.access$1000(this.this$0).videoResolutionMode);
    this.this$0.mCaptureAndEnc.a(TRTCCloudImpl.access$900(this.this$0), this.this$0.mRoomInfo.smallEncSize.a, this.this$0.mRoomInfo.smallEncSize.b, TRTCCloudImpl.access$1000(this.this$0).videoFps, TRTCCloudImpl.access$1000(this.this$0).videoBitrate, i);
    if (TRTCCloudImpl.access$900(this.this$0))
    {
      localObject1 = this.this$0;
      TRTCCloudImpl.access$4700((TRTCCloudImpl)localObject1, 3, ((TRTCCloudImpl)localObject1).mRoomInfo.smallEncSize.a, this.this$0.mRoomInfo.smallEncSize.b, TRTCCloudImpl.access$1000(this.this$0).videoFps, TRTCCloudImpl.access$1000(this.this$0).videoBitrate, bool, TRTCCloudImpl.access$1000(this.this$0).minVideoBitrate, false);
      TRTCCloudImpl.access$4800(this.this$0, 3);
      return;
    }
    localObject1 = this.this$0;
    TRTCCloudImpl.access$4900((TRTCCloudImpl)localObject1, 3, 0, 0, 0, 0, 0, ((TRTCCloudImpl)localObject1).mConfig.q, 0, false);
    TRTCCloudImpl.access$5000(this.this$0, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.47
 * JD-Core Version:    0.7.0.1
 */