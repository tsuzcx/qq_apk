package com.tencent.ark;

import android.graphics.Rect;

class ArkViewModelBase$18
  implements Runnable
{
  ArkViewModelBase$18(ArkViewModelBase paramArkViewModelBase, ArkViewImplement paramArkViewImplement, boolean paramBoolean1, boolean paramBoolean2, int paramInt, Rect paramRect) {}
  
  public void run()
  {
    this.val$viewImpl.onInputFocusChanged(this.val$isFocus, this.val$isReadonly, this.val$inputType, this.val$rc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ark.ArkViewModelBase.18
 * JD-Core Version:    0.7.0.1
 */