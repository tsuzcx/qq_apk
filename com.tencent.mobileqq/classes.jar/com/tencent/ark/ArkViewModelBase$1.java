package com.tencent.ark;

import android.graphics.RectF;

class ArkViewModelBase$1
  implements Runnable
{
  ArkViewModelBase$1(ArkViewModelBase paramArkViewModelBase) {}
  
  public void run()
  {
    if ((this.this$0.mContainer != null) && (this.this$0.mAttached))
    {
      this.this$0.mContainer.SetContainerCallback(this.this$0);
      Logger.logI("ArkApp.ViewModel", String.format("initArkContainer.1.viewModel: %h", new Object[] { this.this$0 }));
      Object localObject = this.this$0.mViewImpl;
      if ((!this.this$0.mRectContainerF.isEmpty()) && (localObject != null))
      {
        this.this$0.mContainer.SetBorderType(((ArkViewImplement)localObject).mBorderType);
        this.this$0.mContainer.SetBorderRadiusTop(((ArkViewImplement)localObject).mClipRadiusTop);
        this.this$0.mContainer.SetBorderRadius(((ArkViewImplement)localObject).mClipRadius);
        localObject = this.this$0;
        ((ArkViewModelBase)localObject).SyncRect(((ArkViewModelBase)localObject).mRectContainerF.left, this.this$0.mRectContainerF.top, this.this$0.mRectContainerF.right, this.this$0.mRectContainerF.bottom);
        return;
      }
      Logger.logE("ArkApp.ViewModel", String.format("initArkContainer.2.viewModel: %h", new Object[] { this }));
      return;
    }
    Logger.logE("ArkApp.ViewModel", String.format("initArkContainer.0.viewModel: %h", new Object[] { this.this$0 }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.ArkViewModelBase.1
 * JD-Core Version:    0.7.0.1
 */