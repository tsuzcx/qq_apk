package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.d;

class TRTCCloudImpl$162
  implements Runnable
{
  TRTCCloudImpl$162(TRTCCloudImpl paramTRTCCloudImpl, boolean paramBoolean) {}
  
  public void run()
  {
    TRTCCloudImpl.access$6202(this.this$0, this.val$enableHevc);
    if (this.this$0.mCaptureAndEnc != null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("codecability onRecvEnterRoomVideoConfig: ");
      ((StringBuilder)localObject).append(this.val$enableHevc);
      ((StringBuilder)localObject).append(" mEnableHighQualityEncode= ");
      ((StringBuilder)localObject).append(TRTCCloudImpl.access$6100(this.this$0));
      ((StringBuilder)localObject).append(" TRTCCloudHevcUtil.isLifeCycleEnableHevcEncode()=");
      ((StringBuilder)localObject).append(TRTCCloudHevcUtil.isLifeCycleEnableHevcEncode());
      TXCLog.i("TRTCCloudImpl", ((StringBuilder)localObject).toString());
      localObject = this.this$0.mCaptureAndEnc;
      boolean bool;
      if ((TRTCCloudImpl.access$6200(this.this$0)) && (TRTCCloudImpl.access$6100(this.this$0)) && (TRTCCloudHevcUtil.isLifeCycleEnableHevcEncode())) {
        bool = true;
      } else {
        bool = false;
      }
      ((d)localObject).j(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.162
 * JD-Core Version:    0.7.0.1
 */