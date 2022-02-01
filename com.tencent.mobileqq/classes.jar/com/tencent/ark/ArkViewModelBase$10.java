package com.tencent.ark;

import android.graphics.Bitmap;

class ArkViewModelBase$10
  implements Runnable
{
  ArkViewModelBase$10(ArkViewModelBase paramArkViewModelBase) {}
  
  public void run()
  {
    ArkViewImplement localArkViewImplement = this.this$0.mViewImpl;
    if (localArkViewImplement != null)
    {
      ArkViewModelBase.ENV.logD("ArkApp.ArkViewModelBase", String.format("ArkViewModelBase.destroy.destroyBitmapBuffer", new Object[0]));
      Bitmap localBitmap = localArkViewImplement.getBitmapBuffer();
      if ((localBitmap != null) && (this.this$0.mApplication != null))
      {
        ark.Application localApplication = this.this$0.mApplication;
        int i = -localBitmap.getWidth();
        localApplication.IncreaseGraphicMemSize(localBitmap.getHeight() * i * 4 * 2);
      }
      localArkViewImplement.destroyBitmapBuffer();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.ArkViewModelBase.10
 * JD-Core Version:    0.7.0.1
 */