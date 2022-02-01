package com.tencent.gdtad.views.video.circle;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public class Utils
{
  public static Bitmap a(Context paramContext, int paramInt)
  {
    if (paramContext == null) {
      return null;
    }
    return a(paramContext.getResources().getDrawable(paramInt));
  }
  
  public static Bitmap a(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    throw new IllegalArgumentException("unsupported drawable type");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.views.video.circle.Utils
 * JD-Core Version:    0.7.0.1
 */