package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.basic.log.TXCLog;

class TRTCCloudImpl$151
  implements Runnable
{
  TRTCCloudImpl$151(TRTCCloudImpl paramTRTCCloudImpl, long paramLong) {}
  
  public void run()
  {
    int i = this.this$0.mRoomInfo.recvFirstIFrame(this.val$tinyId);
    Object localObject3 = null;
    Object localObject2;
    try
    {
      localObject4 = this.this$0.mRoomInfo.getUserIdByTinyId(this.val$tinyId);
      Object localObject1 = localObject3;
      if (localObject4 != null) {
        localObject1 = this.this$0.mRoomInfo.getUser((String)localObject4);
      }
    }
    catch (Exception localException)
    {
      TXCLog.e("TRTCCloudImpl", "get user info failed.", localException);
      localObject2 = localObject3;
    }
    localObject3 = this.this$0;
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("onRecvFirstVideo ");
    ((StringBuilder)localObject4).append(this.val$tinyId);
    ((StringBuilder)localObject4).append(", ");
    ((StringBuilder)localObject4).append(i);
    ((TRTCCloudImpl)localObject3).apiLog(((StringBuilder)localObject4).toString());
    if (localObject2 != null)
    {
      if (i > 1) {
        return;
      }
      localObject3 = localObject2.userID;
      if (((TRTCRoomInfo.hasMainVideo(localObject2.streamState)) || (TRTCRoomInfo.hasSmallVideo(localObject2.streamState))) && (!TRTCRoomInfo.isMuteMainVideo(localObject2.streamState))) {
        this.this$0.runOnListenerThread(new TRTCCloudImpl.151.1(this, (String)localObject3));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.151
 * JD-Core Version:    0.7.0.1
 */