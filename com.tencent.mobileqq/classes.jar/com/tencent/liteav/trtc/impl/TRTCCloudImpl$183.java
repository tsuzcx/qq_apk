package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.d;

class TRTCCloudImpl$183
  implements Runnable
{
  TRTCCloudImpl$183(TRTCCloudImpl paramTRTCCloudImpl, boolean paramBoolean) {}
  
  public void run()
  {
    TRTCCloudImpl.access$400(this.this$0).setEnableH265EncodeByServer(this.val$enableH265ByServer, TRTCEncodeTypeDecision.ModifyCodecReason.REASON_ENTERROOM_RESPOND);
    boolean bool = TRTCCloudImpl.access$400(this.this$0).isVideoEncoderCodecUsingH265();
    if (this.this$0.mCaptureAndEnc != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("codecability onRecvEnterRoomVideoConfig: enabledHevc =");
      localStringBuilder.append(bool);
      TXCLog.i("TRTCCloudImpl", localStringBuilder.toString());
      this.this$0.mCaptureAndEnc.k(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.183
 * JD-Core Version:    0.7.0.1
 */