package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloudListener;

class TRTCCloudImpl$160
  implements Runnable
{
  TRTCCloudImpl$160(TRTCCloudImpl paramTRTCCloudImpl) {}
  
  public void run()
  {
    this.this$0.apiLog("onSendFirstLocalAudioFrame");
    Object localObject = this.this$0;
    TRTCCloudImpl.access$8000((TRTCCloudImpl)localObject, ((TRTCCloudImpl)localObject).mRoomInfo.getUserId(), 0, "onSendFirstLocalAudioFrame");
    localObject = this.this$0.mTRTCListener;
    if (localObject != null) {
      ((TRTCCloudListener)localObject).onSendFirstLocalAudioFrame();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.160
 * JD-Core Version:    0.7.0.1
 */