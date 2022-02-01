package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.ImageLoader.ImageLoadListener;

class EmoObjectPool$1$1
  implements Runnable
{
  EmoObjectPool$1$1(EmoObjectPool.1 param1, Drawable paramDrawable) {}
  
  public void run()
  {
    if (this.b.a != null) {
      this.b.a.onImageLoaded(null, this.a, this.b.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.EmoObjectPool.1.1
 * JD-Core Version:    0.7.0.1
 */