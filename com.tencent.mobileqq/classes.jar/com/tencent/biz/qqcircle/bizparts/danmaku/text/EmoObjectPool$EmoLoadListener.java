package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.ImageLoader.ImageLoadListener;
import com.tencent.component.media.image.ImageLoader.Options;
import com.tencent.component.media.image.drawable.BitmapRefDrawable;
import java.lang.ref.WeakReference;

class EmoObjectPool$EmoLoadListener
  implements ImageLoader.ImageLoadListener
{
  private int b;
  private WeakReference<TextLayoutBase> c;
  private ImageLoader.ImageLoadListener d;
  
  public EmoObjectPool$EmoLoadListener(EmoObjectPool paramEmoObjectPool, int paramInt, TextLayoutBase paramTextLayoutBase, ImageLoader.ImageLoadListener paramImageLoadListener)
  {
    this.b = paramInt;
    this.c = new WeakReference(paramTextLayoutBase);
    this.d = paramImageLoadListener;
  }
  
  public void onImageCanceled(String paramString, ImageLoader.Options paramOptions)
  {
    ImageLoader.ImageLoadListener localImageLoadListener = this.d;
    if (localImageLoadListener != null) {
      localImageLoadListener.onImageCanceled(paramString, paramOptions);
    }
  }
  
  public void onImageFailed(String paramString, ImageLoader.Options paramOptions)
  {
    ImageLoader.ImageLoadListener localImageLoadListener = this.d;
    if (localImageLoadListener != null) {
      localImageLoadListener.onImageFailed(paramString, paramOptions);
    }
  }
  
  public void onImageLoaded(String paramString, Drawable paramDrawable, ImageLoader.Options paramOptions)
  {
    if (paramOptions != null)
    {
      if (paramOptions.obj == null) {
        return;
      }
      EmoCell localEmoCell = (EmoCell)paramOptions.obj;
      if (paramDrawable != null)
      {
        if ((paramDrawable instanceof BitmapRefDrawable)) {
          localObject = ((BitmapRefDrawable)paramDrawable).newDrawable();
        } else {
          localObject = paramDrawable;
        }
        EmoObjectPool.a((Drawable)localObject, this.b);
        localEmoCell.emoDrawable = ((Drawable)localObject);
        localEmoCell.isDrawableLoaded = true;
        localObject = this.c;
        if (localObject == null) {
          return;
        }
        localObject = (TextLayoutBase)((WeakReference)localObject).get();
        if (localObject != null) {
          if (paramDrawable.getBounds().width() != this.b)
          {
            ((TextLayoutBase)localObject).c();
            ((TextLayoutBase)localObject).postInvalidate();
          }
          else
          {
            ((TextLayoutBase)localObject).postInvalidate();
          }
        }
      }
      Object localObject = this.d;
      if (localObject != null) {
        ((ImageLoader.ImageLoadListener)localObject).onImageLoaded(paramString, paramDrawable, paramOptions);
      }
    }
  }
  
  public void onImageProgress(String paramString, float paramFloat, ImageLoader.Options paramOptions)
  {
    ImageLoader.ImageLoadListener localImageLoadListener = this.d;
    if (localImageLoadListener != null) {
      localImageLoadListener.onImageProgress(paramString, paramFloat, paramOptions);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.EmoObjectPool.EmoLoadListener
 * JD-Core Version:    0.7.0.1
 */