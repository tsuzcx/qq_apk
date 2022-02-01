package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloudListener;

class TRTCCloudImpl$177
  implements Runnable
{
  TRTCCloudImpl$177(TRTCCloudImpl paramTRTCCloudImpl, int paramInt) {}
  
  public void run()
  {
    Object localObject1 = this.this$0;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onSendFirstLocalVideoFrame ");
    ((StringBuilder)localObject2).append(this.val$streamType);
    ((TRTCCloudImpl)localObject1).apiLog(((StringBuilder)localObject2).toString());
    int i = TRTCCloudImpl.access$10100(this.this$0, this.val$streamType);
    localObject1 = this.this$0;
    localObject2 = ((TRTCCloudImpl)localObject1).mRoomInfo.getUserId();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSendFirstLocalVideoFrame:");
    localStringBuilder.append(i);
    TRTCCloudImpl.access$9700((TRTCCloudImpl)localObject1, (String)localObject2, 0, localStringBuilder.toString());
    localObject1 = this.this$0.mTRTCListener;
    if (localObject1 != null) {
      ((TRTCCloudListener)localObject1).onSendFirstLocalVideoFrame(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.177
 * JD-Core Version:    0.7.0.1
 */