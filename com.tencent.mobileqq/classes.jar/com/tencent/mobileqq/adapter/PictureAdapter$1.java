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
      ((StringBuilder)localObject1).append(this.a.a.getHeight());
      ((StringBuilder)localObject1).append(" and width is ");
      ((StringBuilder)localObject1).append(this.a.a.getWidth());
      QLog.i("PictureAdapter", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.a.a.getWidth() > 0)
    {
      localObject1 = localObject2;
      if (this.a.a.getHeight() > 0)
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = this.a.a.getHeight();
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = this.a.a.getWidth();
      }
    }
    localObject1 = URLDrawable.getDrawable(this.b, (URLDrawable.URLDrawableOptions)localObject1);
    this.a.a.setImageDrawable((Drawable)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.PictureAdapter.1
 * JD-Core Version:    0.7.0.1
 */