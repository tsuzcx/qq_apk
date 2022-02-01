package com.tencent.ark;

import android.graphics.Rect;

class ArkViewModelBase$5
  implements Runnable
{
  ArkViewModelBase$5(ArkViewModelBase paramArkViewModelBase, Rect paramRect) {}
  
  public void run()
  {
    if ((this.val$rect != null) && (this.this$0.mContainer != null) && (!this.val$rect.equals(this.this$0.mRectContainer)))
    {
      ArkViewModelBase.Size localSize = this.this$0.limitToSizeRange(this.val$rect.width(), this.val$rect.height());
      ArkViewModelBase.ENV.logI("ArkApp.ArkViewModelBase", String.format("onConfigurationChanged.setViewRect.2.rect: %s, limit size(%d,%d) this.%h", new Object[] { this.val$rect.toString(), Integer.valueOf(localSize.width), Integer.valueOf(localSize.height), this.this$0 }));
      this.this$0.mContainer.SetSize(localSize.width, localSize.height);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.ArkViewModelBase.5
 * JD-Core Version:    0.7.0.1
 */