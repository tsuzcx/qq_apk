package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloudListener;

class TRTCCloudImpl$178
  implements Runnable
{
  TRTCCloudImpl$178(TRTCCloudImpl paramTRTCCloudImpl) {}
  
  public void run()
  {
    this.this$0.apiLog("onSendFirstLocalAudioFrame");
    Object localObject = this.this$0;
    TRTCCloudImpl.access$9700((TRTCCloudImpl)localObject, ((TRTCCloudImpl)localObject).mRoomInfo.getUserId(), 0, "onSendFirstLocalAudioFrame");
    localObject = this.this$0.mTRTCListener;
    if (localObject != null) {
      ((TRTCCloudListener)localObject).onSendFirstLocalAudioFrame();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.178
 * JD-Core Version:    0.7.0.1
 */