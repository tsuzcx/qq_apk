package com.tencent.ark;

import android.graphics.RectF;

class ArkViewModelBase$1
  implements Runnable
{
  ArkViewModelBase$1(ArkViewModelBase paramArkViewModelBase) {}
  
  public void run()
  {
    if ((this.this$0.mContainer == null) || (!this.this$0.mAttached))
    {
      ArkViewModelBase.ENV.logE("ArkApp.ArkViewModelBase", String.format("initArkContainer.0.viewModel: %h", new Object[] { this.this$0 }));
      return;
    }
    this.this$0.mContainer.SetContainerCallback(this.this$0);
    ArkViewModelBase.ENV.logI("ArkApp.ArkViewModelBase", String.format("initArkContainer.1.viewModel: %h", new Object[] { this.this$0 }));
    ArkViewImplement localArkViewImplement = this.this$0.mViewImpl;
    if ((this.this$0.mRectContainerF.isEmpty()) || (localArkViewImplement == null))
    {
      ArkViewModelBase.ENV.logE("ArkApp.ArkViewModelBase", String.format("initArkContainer.2.viewModel: %h", new Object[] { this }));
      return;
    }
    this.this$0.mContainer.SetBorderType(localArkViewImplement.mBorderType);
    this.this$0.mContainer.SetBorderRadiusTop(localArkViewImplement.mClipRadiusTop);
    this.this$0.mContainer.SetBorderRadius(localArkViewImplement.mClipRadius);
    this.this$0.SyncRect(this.this$0.mRectContainerF.left, this.this$0.mRectContainerF.top, this.this$0.mRectContainerF.right, this.this$0.mRectContainerF.bottom);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.ark.ArkViewModelBase.1
 * JD-Core Version:    0.7.0.1
 */