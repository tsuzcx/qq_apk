package com.tencent.liteav.trtc.impl;

class TRTCCloudImpl$127
  implements Runnable
{
  TRTCCloudImpl$127(TRTCCloudImpl paramTRTCCloudImpl, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.mIsExitOldRoom)
    {
      TRTCCloudImpl localTRTCCloudImpl = this.this$0;
      localTRTCCloudImpl.mIsExitOldRoom = false;
      localTRTCCloudImpl.apiLog("exit no current room, ignore onExitRoom.");
      return;
    }
    if (this.this$0.mRoomInfo.isMicStard())
    {
      this.this$0.mRoomInfo.setRoomExit(true, this.val$err);
      this.this$0.apiLog("onExitRoom delay 2s when mic is not release.");
      TRTCCloudImpl.access$7700(this.this$0, new TRTCCloudImpl.127.1(this), 2000);
      return;
    }
    this.this$0.runOnListenerThread(new TRTCCloudImpl.127.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.127
 * JD-Core Version:    0.7.0.1
 */