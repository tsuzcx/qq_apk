package com.tencent.liteav.trtc.impl;

class TRTCCloudImpl$127$1
  implements Runnable
{
  TRTCCloudImpl$127$1(TRTCCloudImpl.127 param127) {}
  
  public void run()
  {
    if (this.this$1.this$0.mRoomInfo.isRoomExit())
    {
      this.this$1.this$0.apiLog("force onExitRoom after 2s");
      int i = this.this$1.this$0.mRoomInfo.getRoomExitCode();
      this.this$1.this$0.mRoomInfo.setRoomExit(false, 0);
      this.this$1.this$0.runOnListenerThread(new TRTCCloudImpl.127.1.1(this, i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.127.1
 * JD-Core Version:    0.7.0.1
 */