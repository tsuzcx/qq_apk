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
    Object localObject = null;
    if (paramDrawable == null) {
      return null;
    }
    Drawable localDrawable;
    if (paramDrawable.getConstantState() == null)
    {
      localDrawable = paramDrawable.mutate();
      paramDrawable = localObject;
      if (localDrawable != null) {
        return new TintDrawableWrapper(localDrawable, paramInt);
      }
    }
    else
    {
      localDrawable = paramDrawable.getConstantState().newDrawable().mutate();
      paramDrawable = localObject;
      if (localDrawable != null) {
        paramDrawable = new TintDrawableWrapper(localDrawable, paramInt);
      }
    }
    return paramDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.listview.UIBitmapUtils
 * JD-Core Version:    0.7.0.1
 */