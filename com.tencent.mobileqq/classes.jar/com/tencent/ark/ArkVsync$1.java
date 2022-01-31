package com.tencent.ark;

class ArkVsync$1
  implements Runnable
{
  ArkVsync$1(ArkVsync paramArkVsync1, ArkVsync paramArkVsync2) {}
  
  public void run()
  {
    ArkVsync.ENV.logI("ArkApp.ArkVsync", "addFrameCallback, start vsync");
    this.this$0.mImpl.start(this.val$_this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.ark.ArkVsync.1
 * JD-Core Version:    0.7.0.1
 */