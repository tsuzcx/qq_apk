package com.tencent.ark;

class ArkViewModelBase$2
  implements Runnable
{
  ArkViewModelBase$2(ArkViewModelBase paramArkViewModelBase) {}
  
  public void run()
  {
    ArkViewImplement localArkViewImplement = this.this$0.mViewImpl;
    if (localArkViewImplement != null) {
      localArkViewImplement.onLoadFailed(this.this$0.mErrorInfo.msg, this.this$0.mErrorInfo.retCode, this.this$0.mErrorInfo.canRetry);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ark.ArkViewModelBase.2
 * JD-Core Version:    0.7.0.1
 */