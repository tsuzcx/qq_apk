package com.tencent.ark;

import android.graphics.Rect;

class ArkViewModelBase$20
  implements Runnable
{
  ArkViewModelBase$20(ArkViewModelBase paramArkViewModelBase, ArkViewImplement paramArkViewImplement, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Rect paramRect) {}
  
  public void run()
  {
    this.val$viewImpl.onInputSelectChanged(this.val$nStartX, this.val$nStartY, this.val$nEndX, this.val$nEndY, this.val$rc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.ArkViewModelBase.20
 * JD-Core Version:    0.7.0.1
 */