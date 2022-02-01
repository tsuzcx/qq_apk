package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.d;
import com.tencent.liteav.g;
import java.util.HashMap;

class TRTCCloudImpl$34
  implements Runnable
{
  TRTCCloudImpl$34(TRTCCloudImpl paramTRTCCloudImpl1, boolean paramBoolean, TRTCCloudImpl paramTRTCCloudImpl2) {}
  
  public void run()
  {
    ??? = this.this$0.mCurrentPublishClouds;
    Object localObject1 = Integer.valueOf(2);
    ??? = (TRTCCloudImpl)((HashMap)???).get(localObject1);
    TRTCCloudImpl localTRTCCloudImpl;
    if (!this.val$mute)
    {
      if (??? != this.val$cloud)
      {
        this.this$0.enableVideoStream(false);
        synchronized (this.this$0.mCurrentPublishClouds)
        {
          this.this$0.mCurrentPublishClouds.put(localObject1, this.val$cloud);
          this.this$0.mCurrentPublishClouds.put(Integer.valueOf(3), this.val$cloud);
          this.this$0.mCurrentPublishClouds.put(Integer.valueOf(7), this.val$cloud);
          localObject1 = this.this$0;
          ((TRTCCloudImpl)localObject1).enableNetworkBlackStream(((TRTCCloudImpl)localObject1).mCaptureAndEnc.j());
          localObject1 = this.this$0;
          ((TRTCCloudImpl)localObject1).enableNetworkSmallStream(TRTCCloudImpl.access$900((TRTCCloudImpl)localObject1));
          localObject1 = this.this$0;
          TRTCCloudImpl.access$800((TRTCCloudImpl)localObject1, TRTCCloudImpl.access$600((TRTCCloudImpl)localObject1), TRTCCloudImpl.access$700(this.this$0));
          this.this$0.flushBigVideoEncParamsIntoNetwork();
          this.this$0.flushSmallVideoEncParamsIntoNetwork();
          this.this$0.enableVideoStream(true);
        }
      }
      this.this$0.mCaptureAndEnc.i();
      this.this$0.mRoomInfo.muteLocalVideo = this.val$mute;
      localTRTCCloudImpl = this.this$0;
      localTRTCCloudImpl.enableNetworkBlackStream(localTRTCCloudImpl.mCaptureAndEnc.j());
      TRTCCloudImpl.access$4400(this.this$0, 2, this.val$mute);
      this.this$0.mCaptureAndEnc.k(2);
      if (TRTCCloudImpl.access$900(this.this$0)) {
        this.this$0.mCaptureAndEnc.k(3);
      }
    }
    else if (??? == this.val$cloud)
    {
      this.this$0.mRoomInfo.muteLocalVideo = this.val$mute;
      localTRTCCloudImpl = this.this$0;
      localTRTCCloudImpl.enableNetworkBlackStream(localTRTCCloudImpl.mCaptureAndEnc.j());
      if (this.this$0.mConfig.B != null)
      {
        this.this$0.mCaptureAndEnc.h();
        return;
      }
      TRTCCloudImpl.access$4400(this.this$0, 2, this.val$mute);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.34
 * JD-Core Version:    0.7.0.1
 */