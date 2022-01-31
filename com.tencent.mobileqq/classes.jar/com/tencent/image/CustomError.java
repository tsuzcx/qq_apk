package com.tencent.image;

import android.graphics.drawable.Drawable;

public class CustomError
  extends Exception
{
  protected Drawable getFailedDrawable()
  {
    return URLDrawable.sDefaultDrawableParms.getDefualtFailedDrawable();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.CustomError
 * JD-Core Version:    0.7.0.1
 */