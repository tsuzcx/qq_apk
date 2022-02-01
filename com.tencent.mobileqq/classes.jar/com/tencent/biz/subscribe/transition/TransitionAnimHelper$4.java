package com.tencent.biz.subscribe.transition;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.widget.ImageView;

final class TransitionAnimHelper$4
  extends Property<ImageView, Matrix>
{
  TransitionAnimHelper$4(Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Matrix a(ImageView paramImageView)
  {
    return null;
  }
  
  public void a(ImageView paramImageView, Matrix paramMatrix)
  {
    Drawable localDrawable = paramImageView.getDrawable();
    if (localDrawable == null) {
      return;
    }
    if (paramMatrix == null)
    {
      localDrawable.setBounds(0, 0, paramImageView.getWidth(), paramImageView.getHeight());
    }
    else
    {
      localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      if (paramImageView.getImageMatrix() == null) {
        paramImageView.setImageMatrix(new Matrix());
      }
      paramImageView.setImageMatrix(paramMatrix);
    }
    paramImageView.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.transition.TransitionAnimHelper.4
 * JD-Core Version:    0.7.0.1
 */