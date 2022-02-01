package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper.InvokeNormalCallBack;
import com.tencent.biz.qcircleshadow.lib.variation.HostEmotionUtil;
import com.tencent.component.media.image.ImageLoader.ImageLoadListener;
import com.tencent.component.media.image.ImageLoader.Options;

class EmoObjectPool$1
  implements HostStaticInvokeHelper.InvokeNormalCallBack
{
  EmoObjectPool$1(EmoObjectPool paramEmoObjectPool, ImageLoader.ImageLoadListener paramImageLoadListener, int paramInt1, int paramInt2, ImageLoader.Options paramOptions) {}
  
  public void onFailed() {}
  
  public void onSuccess()
  {
    if (this.a == null) {
      return;
    }
    Drawable localDrawable = HostEmotionUtil.getEmoDrawable(this.b, this.c);
    if (localDrawable != null)
    {
      if (!this.d.useMainThread)
      {
        ImageLoader.ImageLoadListener localImageLoadListener = this.a;
        if (localImageLoadListener != null)
        {
          localImageLoadListener.onImageLoaded(null, localDrawable, this.d);
          return;
        }
      }
      EmoObjectPool.a(this.e).post(new EmoObjectPool.1.1(this, localDrawable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.EmoObjectPool.1
 * JD-Core Version:    0.7.0.1
 */