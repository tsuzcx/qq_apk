package com.tencent.ark;

class ArkViewModelBase$13
  implements Runnable
{
  ArkViewModelBase$13(ArkViewModelBase paramArkViewModelBase, boolean paramBoolean) {}
  
  public void run()
  {
    Logger.logI("ArkApp.ViewModel", String.format("activateView, this=%h, app=%s, container=%h, state=%s", new Object[] { this, this.this$0.mAppInfo.name, this.this$0.mContainer, Boolean.toString(this.val$state) }));
    if (this.this$0.mContainer == null)
    {
      Logger.logE("ArkApp.ViewModel", "activateView error mContainer is null");
      return;
    }
    if (!this.this$0.mHasLoaded)
    {
      Logger.logE("ArkApp.ViewModel", "activateView error mHasLoaded is false");
      this.this$0.onRunAppFailed();
      return;
    }
    this.this$0.changeContainerActivateStatus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.ArkViewModelBase.13
 * JD-Core Version:    0.7.0.1
 */