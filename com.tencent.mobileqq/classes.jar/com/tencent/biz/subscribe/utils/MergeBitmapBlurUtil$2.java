package com.tencent.biz.subscribe.utils;

import android.graphics.Bitmap;
import android.widget.ImageView;

public final class MergeBitmapBlurUtil$2
  implements Runnable
{
  public MergeBitmapBlurUtil$2(Bitmap paramBitmap, ImageView paramImageView) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.MergeBitmapBlurUtil.2
 * JD-Core Version:    0.7.0.1
 */