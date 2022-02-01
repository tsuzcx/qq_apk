package com.tencent.liteav.trtc.impl;

import com.tencent.rtmp.ui.TXCloudVideoView;

class TRTCCloudImpl$105
  implements Runnable
{
  TRTCCloudImpl$105(TRTCCloudImpl paramTRTCCloudImpl, int paramInt) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showDebugView ");
    localStringBuilder.append(this.val$showType);
    ((TRTCCloudImpl)localObject).apiLog(localStringBuilder.toString());
    localObject = this.this$0;
    ((TRTCCloudImpl)localObject).mDebugType = this.val$showType;
    localObject = ((TRTCCloudImpl)localObject).mRoomInfo.localView;
    if (localObject != null) {
      this.this$0.runOnMainThread(new TRTCCloudImpl.105.1(this, (TXCloudVideoView)localObject));
    }
    this.this$0.mRoomInfo.forEachUser(new TRTCCloudImpl.105.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.105
 * JD-Core Version:    0.7.0.1
 */