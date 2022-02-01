package com.tencent.ark;

class ArkVsync$2
  implements Runnable
{
  ArkVsync$2(ArkVsync paramArkVsync) {}
  
  public void run()
  {
    ArkVsync.ENV.logI("ArkApp.ArkVsync", "removeFrameCallback, stop vsync");
    this.this$0.mImpl.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.ArkVsync.2
 * JD-Core Version:    0.7.0.1
 */