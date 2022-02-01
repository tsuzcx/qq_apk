package com.tencent.ark;

import android.graphics.RectF;

class ArkViewModelBase$14
  implements Runnable
{
  ArkViewModelBase$14(ArkViewModelBase paramArkViewModelBase) {}
  
  public void run()
  {
    if (!this.this$0.mRectContainerF.isEmpty())
    {
      ArkViewModelBase localArkViewModelBase = this.this$0;
      localArkViewModelBase.Update(localArkViewModelBase.mRectContainerF.left, this.this$0.mRectContainerF.top, this.this$0.mRectContainerF.right, this.this$0.mRectContainerF.bottom);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.ArkViewModelBase.14
 * JD-Core Version:    0.7.0.1
 */