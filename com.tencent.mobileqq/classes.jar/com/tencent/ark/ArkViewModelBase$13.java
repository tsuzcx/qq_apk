package com.tencent.ark;

class ArkViewModelBase$13
  implements Runnable
{
  ArkViewModelBase$13(ArkViewModelBase paramArkViewModelBase, boolean paramBoolean) {}
  
  public void run()
  {
    ArkViewModelBase.ENV.logI("ArkApp.ArkViewModelBase", String.format("activateView, this=%h, app=%s, container=%h, state=%s", new Object[] { this, this.this$0.mAppInfo.name, this.this$0.mContainer, Boolean.toString(this.val$state) }));
    if (this.this$0.mContainer == null)
    {
      ArkViewModelBase.ENV.logE("ArkApp.ArkViewModelBase", "activateView error mContainer is null");
      return;
    }
    if (!this.this$0.mHasLoaded)
    {
      ArkViewModelBase.ENV.logE("ArkApp.ArkViewModelBase", "activateView error mHasLoaded is false");
      this.this$0.onRunAppFailed();
      return;
    }
    this.this$0.changeContainerActivateStatus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ark.ArkViewModelBase.13
 * JD-Core Version:    0.7.0.1
 */