package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.d;
import com.tencent.liteav.g;

class TRTCCloudImpl$156
  implements Runnable
{
  TRTCCloudImpl$156(TRTCCloudImpl paramTRTCCloudImpl, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8) {}
  
  public void run()
  {
    int j = this.val$enableH265Enc;
    int i = 0;
    boolean bool;
    if (j == 1) {
      bool = true;
    } else {
      bool = false;
    }
    j = this.val$streamType;
    if (j == 7)
    {
      if (this.this$0.mSubStreamCaptureAndEnc != null) {
        this.this$0.mSubStreamCaptureAndEnc.a(this.val$streamType, this.val$width, this.val$height, this.val$fps, this.val$bitrate, this.val$totalBitrate, this.val$rpsNearestMode, bool);
      }
    }
    else if (j == 2)
    {
      this.this$0.mCaptureAndEnc.a(this.val$streamType, this.val$width, this.val$height, this.val$fps, this.val$bitrate, this.val$totalBitrate, this.val$rpsNearestMode, bool);
      if (this.val$width <= this.val$height) {
        i = 1;
      }
      if ((this.this$0.mConfig.m != i) && (this.val$width != this.val$height))
      {
        this.this$0.mConfig.m = i;
        TRTCCloudImpl.access$100(this.this$0);
      }
    }
    TRTCCloudImpl.access$400(this.this$0).setEnableH265EncodeByServer(bool, TRTCEncodeTypeDecision.ModifyCodecReason.REASON_QOS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.156
 * JD-Core Version:    0.7.0.1
 */