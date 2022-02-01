package com.tencent.mobileqq.adapter;

import alkt;
import alku;
import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qphone.base.util.QLog;

public class PictureAdapter$1
  implements Runnable
{
  public PictureAdapter$1(alkt paramalkt, alku paramalku, String paramString) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PictureAdapter", 2, "height is " + this.jdField_a_of_type_Alku.a.getHeight() + " and width is " + this.jdField_a_of_type_Alku.a.getWidth());
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Alku.a.getWidth() > 0)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Alku.a.getHeight() > 0)
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = this.jdField_a_of_type_Alku.a.getHeight();
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = this.jdField_a_of_type_Alku.a.getWidth();
      }
    }
    localObject1 = URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject1);
    this.jdField_a_of_type_Alku.a.setImageDrawable((Drawable)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.PictureAdapter.1
 * JD-Core Version:    0.7.0.1
 */