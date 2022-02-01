package com.tencent.liteav.trtc.impl;

class TRTCCloudImpl$140$1
  implements Runnable
{
  TRTCCloudImpl$140$1(TRTCCloudImpl.140 param140) {}
  
  public void run()
  {
    if (this.this$1.this$0.mRoomInfo.isRoomExit())
    {
      this.this$1.this$0.apiLog("force onExitRoom after 2s");
      int i = this.this$1.this$0.mRoomInfo.getRoomExitCode();
      this.this$1.this$0.mRoomInfo.setRoomExit(false, 0);
      this.this$1.this$0.runOnListenerThread(new TRTCCloudImpl.140.1.1(this, i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.140.1
 * JD-Core Version:    0.7.0.1
 */