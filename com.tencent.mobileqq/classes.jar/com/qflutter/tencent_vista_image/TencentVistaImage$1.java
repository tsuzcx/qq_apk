package com.qflutter.tencent_vista_image;

import android.graphics.Bitmap;

class TencentVistaImage$1
  implements IVistaImage.LoadBitmapCallback
{
  TencentVistaImage$1(TencentVistaImage paramTencentVistaImage, TextureRecord paramTextureRecord) {}
  
  public void onFailed(String paramString1, int paramInt, String paramString2)
  {
    this.val$record.notifyDartFail("-5", "load bitmap error occurred", null);
  }
  
  public void onLoaded(String paramString, Bitmap paramBitmap, boolean paramBoolean, IRenderer paramIRenderer)
  {
    if (PLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[createTexture][onLoaded] url=");
      localStringBuilder.append(paramString);
      PLog.d("TencentVistaImage", localStringBuilder.toString());
    }
    if (paramBitmap == null)
    {
      PLog.e("TencentVistaImage", "[createTexture] no bitmap");
      this.val$record.notifyDartFail("-2", "no bitmap", null);
      return;
    }
    if (paramBitmap.isRecycled())
    {
      PLog.e("TencentVistaImage", "[createTexture] recycled bitmap");
      this.val$record.notifyDartFail("-3", "recycled bitmap", null);
      return;
    }
    this.val$record.setBitmap(paramBitmap);
    this.val$record.setBitmapClipped(paramBoolean);
    this.val$record.setRenderer(paramIRenderer);
    this.this$0.onCreateTexture(this.val$record);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.tencent_vista_image.TencentVistaImage.1
 * JD-Core Version:    0.7.0.1
 */