package com.tencent.ark;

import android.graphics.Rect;

class ArkViewModelBase$15
  implements Runnable
{
  ArkViewModelBase$15(ArkViewModelBase paramArkViewModelBase) {}
  
  public void run()
  {
    ArkViewImplement localArkViewImplement = this.this$0.mViewImpl;
    if ((localArkViewImplement != null) && (!this.this$0.mRectArkContainer.isEmpty())) {
      localArkViewImplement.onInvalidate(this.this$0.mRectArkContainer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ark.ArkViewModelBase.15
 * JD-Core Version:    0.7.0.1
 */