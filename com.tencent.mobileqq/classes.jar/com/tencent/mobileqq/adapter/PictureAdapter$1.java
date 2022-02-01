package com.tencent.mobileqq.adapter;

import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qphone.base.util.QLog;

class PictureAdapter$1
  implements Runnable
{
  PictureAdapter$1(PictureAdapter paramPictureAdapter, PictureAdapter.ViewHolder paramViewHolder, String paramString) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("height is ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqAdapterPictureAdapter$ViewHolder.a.getHeight());
      ((StringBuilder)localObject1).append(" and width is ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqAdapterPictureAdapter$ViewHolder.a.getWidth());
      QLog.i("PictureAdapter", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterPictureAdapter$ViewHolder.a.getWidth() > 0)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterPictureAdapter$ViewHolder.a.getHeight() > 0)
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = this.jdField_a_of_type_ComTencentMobileqqAdapterPictureAdapter$ViewHolder.a.getHeight();
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = this.jdField_a_of_type_ComTencentMobileqqAdapterPictureAdapter$ViewHolder.a.getWidth();
      }
    }
    localObject1 = URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqAdapterPictureAdapter$ViewHolder.a.setImageDrawable((Drawable)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.PictureAdapter.1
 * JD-Core Version:    0.7.0.1
 */