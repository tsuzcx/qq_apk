package com.tencent.ark;

class ArkViewModelBase$4
  implements Runnable
{
  ArkViewModelBase$4(ArkViewModelBase paramArkViewModelBase) {}
  
  public void run()
  {
    ArkVsync.getInstance().removeFrameCallback(this.this$0);
    if (this.this$0.mContainer != null)
    {
      this.this$0.mContainer.SetContainerCallback(null);
      ArkViewModelBase.ENV.logI("ArkApp.ArkViewModelBase", String.format("detachViewArkThread.this.%h", new Object[] { this.this$0 }));
    }
    this.this$0.destroyDrawTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.ark.ArkViewModelBase.4
 * JD-Core Version:    0.7.0.1
 */