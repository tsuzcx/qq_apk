package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.tencent.component.media.image.ImageLoader.ImageLoadListener;
import com.tencent.component.media.image.ImageLoader.Options;
import com.tencent.qphone.base.util.BaseApplication;
import vfw;

public class EmoObjectPool$2
  implements Runnable
{
  public EmoObjectPool$2(vfw paramvfw, String paramString, ImageLoader.Options paramOptions, ImageLoader.ImageLoadListener paramImageLoadListener) {}
  
  public void run()
  {
    Drawable localDrawable = vfw.a(this.jdField_a_of_type_JavaLangString, BaseApplication.getContext().getResources());
    if (localDrawable != null)
    {
      if (!this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$Options.useMainThread) {
        this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$ImageLoadListener.onImageLoaded("", localDrawable, this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$Options);
      }
    }
    else {
      return;
    }
    vfw.a(this.this$0).post(new EmoObjectPool.2.1(this, localDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.EmoObjectPool.2
 * JD-Core Version:    0.7.0.1
 */