package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import android.app.Application;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.tencent.component.media.image.ImageLoader.ImageLoadListener;
import com.tencent.component.media.image.ImageLoader.Options;
import com.tencent.qcircle.application.QCircleApplication;

class EmoObjectPool$2
  implements Runnable
{
  EmoObjectPool$2(EmoObjectPool paramEmoObjectPool, String paramString, ImageLoader.Options paramOptions, ImageLoader.ImageLoadListener paramImageLoadListener) {}
  
  public void run()
  {
    Drawable localDrawable = EmoObjectPool.a(this.a, QCircleApplication.APP.getResources());
    if (localDrawable != null)
    {
      if (!this.b.useMainThread)
      {
        this.c.onImageLoaded("", localDrawable, this.b);
        return;
      }
      EmoObjectPool.a(this.this$0).post(new EmoObjectPool.2.1(this, localDrawable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.EmoObjectPool.2
 * JD-Core Version:    0.7.0.1
 */