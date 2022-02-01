package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.ImageLoader.ImageLoadListener;
import vfx;

public class EmoObjectPool$1$1
  implements Runnable
{
  public EmoObjectPool$1$1(vfx paramvfx, Drawable paramDrawable) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Vfx.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$ImageLoadListener != null) {
      this.jdField_a_of_type_Vfx.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$ImageLoadListener.onImageLoaded(null, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_Vfx.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$Options);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.EmoObjectPool.1.1
 * JD-Core Version:    0.7.0.1
 */