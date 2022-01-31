package com.tencent.ark;

class ArkViewModelBase$23
  implements Runnable
{
  ArkViewModelBase$23(ArkViewModelBase paramArkViewModelBase, boolean paramBoolean) {}
  
  public void run()
  {
    this.this$0.changeContainerActivateStatus();
    if (this.this$0.mApplication != null) {
      this.this$0.mApplication.SetForeground(this.val$isForeground);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ark.ArkViewModelBase.23
 * JD-Core Version:    0.7.0.1
 */