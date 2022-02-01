package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.d;
import com.tencent.liteav.g;
import com.tencent.liteav.g.a;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoEncParam;
import java.util.HashMap;

class TRTCCloudImpl$30
  implements Runnable
{
  TRTCCloudImpl$30(TRTCCloudImpl paramTRTCCloudImpl1, boolean paramBoolean, TRTCCloudImpl paramTRTCCloudImpl2) {}
  
  public void run()
  {
    ??? = this.this$0.mCurrentPublishClouds;
    Object localObject1 = Integer.valueOf(2);
    ??? = (TRTCCloudImpl)((HashMap)???).get(localObject1);
    Object localObject3;
    if (!this.val$mute)
    {
      TRTCCloudImpl localTRTCCloudImpl = this.val$cloud;
      int i = 0;
      if (??? != localTRTCCloudImpl)
      {
        this.this$0.enableVideoStream(false);
        synchronized (this.this$0.mCurrentPublishClouds)
        {
          this.this$0.mCurrentPublishClouds.put(localObject1, this.val$cloud);
          this.this$0.mCurrentPublishClouds.put(Integer.valueOf(3), this.val$cloud);
          this.this$0.mCurrentPublishClouds.put(Integer.valueOf(7), this.val$cloud);
          localObject1 = this.this$0;
          ((TRTCCloudImpl)localObject1).enableNetworkBlackStream(((TRTCCloudImpl)localObject1).mCaptureAndEnc.i());
          localObject1 = this.this$0;
          ((TRTCCloudImpl)localObject1).enableNetworkSmallStream(TRTCCloudImpl.access$700((TRTCCloudImpl)localObject1));
          localObject1 = this.this$0;
          TRTCCloudImpl.access$500((TRTCCloudImpl)localObject1, TRTCCloudImpl.access$300((TRTCCloudImpl)localObject1), TRTCCloudImpl.access$400(this.this$0));
          localObject1 = this.this$0;
          TRTCCloudImpl.access$600((TRTCCloudImpl)localObject1, 2, ((TRTCCloudImpl)localObject1).mRoomInfo.bigEncSize.a, this.this$0.mRoomInfo.bigEncSize.b, this.this$0.mConfig.h, this.this$0.mConfig.c, this.this$0.mConfig.p, this.this$0.mConfig.e);
          if (TRTCCloudImpl.access$700(this.this$0))
          {
            localObject1 = this.this$0;
            TRTCCloudImpl.access$600((TRTCCloudImpl)localObject1, 3, ((TRTCCloudImpl)localObject1).mRoomInfo.smallEncSize.a, this.this$0.mRoomInfo.smallEncSize.b, TRTCCloudImpl.access$800(this.this$0).videoFps, TRTCCloudImpl.access$800(this.this$0).videoBitrate, this.this$0.mConfig.p, TRTCCloudImpl.access$800(this.this$0).minVideoBitrate);
          }
          else
          {
            localObject1 = this.this$0;
            TRTCCloudImpl.access$900((TRTCCloudImpl)localObject1, 3, 0, 0, 0, 0, 0, ((TRTCCloudImpl)localObject1).mConfig.p, 0);
          }
          i = 1;
        }
      }
      this.this$0.mCaptureAndEnc.h();
      localObject3 = this.this$0.mRoomInfo;
      boolean bool = this.val$mute;
      ((TRTCRoomInfo)localObject3).muteLocalVideo = bool;
      this.this$0.enableVideoStream(bool ^ true);
      localObject3 = this.this$0;
      ((TRTCCloudImpl)localObject3).enableNetworkBlackStream(((TRTCCloudImpl)localObject3).mCaptureAndEnc.i());
      TRTCCloudImpl.access$4100(this.this$0, 2, this.val$mute);
      if (i != 0)
      {
        this.this$0.mCaptureAndEnc.k(2);
        this.this$0.mCaptureAndEnc.k(3);
      }
    }
    else if (??? == this.val$cloud)
    {
      this.this$0.mRoomInfo.muteLocalVideo = this.val$mute;
      localObject3 = this.this$0;
      ((TRTCCloudImpl)localObject3).enableNetworkBlackStream(((TRTCCloudImpl)localObject3).mCaptureAndEnc.i());
      if (this.this$0.mConfig.A != null)
      {
        this.this$0.mCaptureAndEnc.g();
        return;
      }
      this.this$0.enableVideoStream(this.val$mute ^ true);
      TRTCCloudImpl.access$4100(this.this$0, 2, this.val$mute);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.30
 * JD-Core Version:    0.7.0.1
 */