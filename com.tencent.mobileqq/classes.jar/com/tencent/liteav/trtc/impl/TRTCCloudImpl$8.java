package com.tencent.liteav.trtc.impl;

class TRTCCloudImpl$8
  implements Runnable
{
  TRTCCloudImpl$8(TRTCCloudImpl paramTRTCCloudImpl) {}
  
  public void run()
  {
    this.this$0.mConfig.h = false;
    this.this$0.exitRoomInternal(true, "call from api");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.8
 * JD-Core Version:    0.7.0.1
 */