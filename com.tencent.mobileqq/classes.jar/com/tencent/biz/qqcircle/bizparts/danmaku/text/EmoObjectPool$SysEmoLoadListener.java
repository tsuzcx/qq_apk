package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.ImageLoader.ImageLoadListener;
import com.tencent.mobileqq.text.TextUtils.LoadSysEmojiCallback;
import java.lang.ref.WeakReference;

class EmoObjectPool$SysEmoLoadListener
  implements TextUtils.LoadSysEmojiCallback
{
  private SystemEmoCell b;
  private WeakReference<TextLayoutBase> c;
  private ImageLoader.ImageLoadListener d;
  
  public EmoObjectPool$SysEmoLoadListener(EmoObjectPool paramEmoObjectPool, TextLayoutBase paramTextLayoutBase, SystemEmoCell paramSystemEmoCell, ImageLoader.ImageLoadListener paramImageLoadListener)
  {
    this.b = paramSystemEmoCell;
    this.c = new WeakReference(paramTextLayoutBase);
    this.d = paramImageLoadListener;
  }
  
  public void callbackWhenSysEmojiLoaded(Drawable paramDrawable)
  {
    Object localObject = this.b;
    if ((localObject != null) && (paramDrawable != null))
    {
      ((SystemEmoCell)localObject).isDrawableLoaded = true;
      ((SystemEmoCell)localObject).emoDrawable = paramDrawable;
      EmoObjectPool.a(paramDrawable, ((SystemEmoCell)localObject).mHeight);
      localObject = this.c;
      if (localObject == null) {
        return;
      }
      localObject = (TextLayoutBase)((WeakReference)localObject).get();
      if (localObject != null) {
        if (paramDrawable.getBounds().width() != this.b.mWidth)
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
    localObject = this.d;
    if (localObject != null) {
      ((ImageLoader.ImageLoadListener)localObject).onImageLoaded(null, paramDrawable, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.EmoObjectPool.SysEmoLoadListener
 * JD-Core Version:    0.7.0.1
 */