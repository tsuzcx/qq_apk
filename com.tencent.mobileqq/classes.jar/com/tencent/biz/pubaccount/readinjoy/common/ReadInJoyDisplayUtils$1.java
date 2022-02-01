package com.tencent.biz.pubaccount.readinjoy.common;

import android.graphics.Bitmap;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.utils.ImageUtil;

final class ReadInJoyDisplayUtils$1
  implements URLDrawable.URLDrawableListener
{
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.b);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = ImageUtil.a(paramURLDrawable);
    if (paramURLDrawable != null)
    {
      Bitmap localBitmap = ReadInJoyDisplayUtils.a(paramURLDrawable, paramURLDrawable.getWidth());
      paramURLDrawable.recycle();
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageBitmap(localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils.1
 * JD-Core Version:    0.7.0.1
 */