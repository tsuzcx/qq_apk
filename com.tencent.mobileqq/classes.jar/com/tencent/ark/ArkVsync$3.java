package com.tencent.ark;

class ArkVsync$3
  implements Runnable
{
  ArkVsync$3(ArkVsync paramArkVsync, ArkVsync.CallbackItem paramCallbackItem) {}
  
  public void run()
  {
    if (this.val$item.callback != null) {
      this.val$item.callback.doFrame();
    }
    this.val$item.isCallbacking = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.ark.ArkVsync.3
 * JD-Core Version:    0.7.0.1
 */