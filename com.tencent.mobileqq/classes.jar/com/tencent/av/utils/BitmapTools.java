package com.tencent.av.utils;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.qphone.base.util.QLog;

public class BitmapTools
{
  public static Drawable a(Context paramContext, int paramInt)
  {
    int i = UITools.a(paramContext);
    int j = UITools.b(paramContext);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("screenWidth = ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" # screenHeight =");
      ((StringBuilder)localObject).append(j);
      QLog.d("BitmapTools", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new BitmapFactory.Options();
    if (i <= 480)
    {
      ((BitmapFactory.Options)localObject).inSampleSize = 4;
    }
    else
    {
      if (i > 720) {
        break label128;
      }
      ((BitmapFactory.Options)localObject).inSampleSize = 2;
    }
    label128:
    try
    {
      paramContext = new BitmapDrawable(paramContext.getResources(), BitmapFactory.decodeResource(paramContext.getResources(), paramInt, (BitmapFactory.Options)localObject));
      return paramContext;
    }
    catch (Exception|OutOfMemoryError paramContext) {}
    return null;
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.BitmapTools
 * JD-Core Version:    0.7.0.1
 */