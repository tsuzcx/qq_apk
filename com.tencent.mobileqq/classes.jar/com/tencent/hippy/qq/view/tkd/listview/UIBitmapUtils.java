package com.tencent.hippy.qq.view.tkd.listview;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

public class UIBitmapUtils
{
  public static Drawable getColorImage(Bitmap paramBitmap, int paramInt)
  {
    return getColorImage(new BitmapDrawable(BaseApplicationImpl.getContext().getResources(), paramBitmap), paramInt);
  }
  
  public static Drawable getColorImage(Drawable paramDrawable, int paramInt)
  {
    if (paramDrawable == null) {}
    do
    {
      do
      {
        return null;
        if (paramDrawable.getConstantState() != null) {
          break;
        }
        paramDrawable = paramDrawable.mutate();
      } while (paramDrawable == null);
      return new TintDrawableWrapper(paramDrawable, paramInt);
      paramDrawable = paramDrawable.getConstantState().newDrawable().mutate();
    } while (paramDrawable == null);
    return new TintDrawableWrapper(paramDrawable, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.listview.UIBitmapUtils
 * JD-Core Version:    0.7.0.1
 */