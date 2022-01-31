package com.tencent.ark;

class ArkViewModelBase$11
  implements Runnable
{
  ArkViewModelBase$11(ArkViewModelBase paramArkViewModelBase) {}
  
  public void run()
  {
    ArkVsync.getInstance().removeFrameCallback(this.this$0);
    if (this.this$0.mContainer != null)
    {
      ArkViewModelBase.ENV.logD("ArkApp.ArkViewModelBase", String.format("ArkViewModelBase.destroy.delete.container.this.%h.container.%h", new Object[] { this, this.this$0.mContainer }));
      this.this$0.mContainer.DeletePtr();
      this.this$0.mContainer = null;
    }
    if (this.this$0.mApplication != null)
    {
      ArkViewModelBase.ENV.logD("ArkApp.ArkViewModelBase", String.format("ArkViewModelBase.destroy.release.application=%h.this=%h", new Object[] { this.this$0.mApplication, this }));
      this.this$0.applicationRelease(this.this$0.mApplication);
      this.this$0.mApplication.Release();
      this.this$0.mApplication = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.ark.ArkViewModelBase.11
 * JD-Core Version:    0.7.0.1
 */