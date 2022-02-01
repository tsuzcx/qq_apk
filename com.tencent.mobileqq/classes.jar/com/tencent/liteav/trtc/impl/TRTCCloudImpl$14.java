package com.tencent.liteav.trtc.impl;

class TRTCCloudImpl$14
  implements Runnable
{
  TRTCCloudImpl$14(TRTCCloudImpl paramTRTCCloudImpl, int paramInt) {}
  
  public void run()
  {
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    if (this.val$role == 20) {
      localObject = "Anchor";
    } else {
      localObject = "Audience";
    }
    localTRTCCloudImpl.apiOnlineLog(String.format("switchRole:%s", new Object[] { localObject }));
    Object localObject = this.this$0;
    ((TRTCCloudImpl)localObject).mTargetRole = this.val$role;
    TRTCCloudImpl.access$1900((TRTCCloudImpl)localObject, ((TRTCCloudImpl)localObject).mNativeRtcContext, this.val$role);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.14
 * JD-Core Version:    0.7.0.1
 */