package com.tencent.ark;

class ArkViewModelBase$16
  implements Runnable
{
  ArkViewModelBase$16(ArkViewModelBase paramArkViewModelBase) {}
  
  public void run()
  {
    if (this.this$0.mViewImpl != null) {
      this.this$0.mViewImpl.onLoadFailed(this.this$0.mErrorInfo.msg, this.this$0.mErrorInfo.retCode, this.this$0.mErrorInfo.canRetry);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ark.ArkViewModelBase.16
 * JD-Core Version:    0.7.0.1
 */