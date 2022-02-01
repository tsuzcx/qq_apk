package com.qflutter.tencent_vista_image;

import android.graphics.Bitmap;
import android.os.Looper;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

class TencentVistaImage$3
  implements IVistaImage.LoadBitmapCallback
{
  TencentVistaImage$3(TencentVistaImage paramTencentVistaImage, String paramString) {}
  
  public void onFailed(String paramString1, int paramInt, String paramString2)
  {
    PLog.e("TencentVistaImage", "[onCreateTexture] recycled bitmap");
  }
  
  public void onLoaded(String paramString, Bitmap paramBitmap, boolean paramBoolean, IRenderer paramIRenderer)
  {
    if (PLog.isColorLevel())
    {
      paramIRenderer = new StringBuilder();
      paramIRenderer.append("[updateTexture][onLoaded] url=");
      paramIRenderer.append(paramString);
      PLog.d("TencentVistaImage", paramIRenderer.toString());
    }
    if (paramBitmap == null)
    {
      PLog.e("TencentVistaImage", "[updateTexture][onLoaded] no bitmap");
      return;
    }
    if (paramBitmap.isRecycled())
    {
      PLog.e("TencentVistaImage", "[updateTexture][onLoaded] recycled bitmap");
      return;
    }
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      this.this$0.doUpdateTexture(this.val$recordKey, paramBitmap);
      return;
    }
    Observable.just(this.val$recordKey).observeOn(AndroidSchedulers.mainThread()).subscribe(new TencentVistaImage.3.1(this, paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.tencent_vista_image.TencentVistaImage.3
 * JD-Core Version:    0.7.0.1
 */