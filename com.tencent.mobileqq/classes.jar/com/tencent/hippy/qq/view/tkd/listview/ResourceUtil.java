package com.tencent.hippy.qq.view.tkd.listview;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.StringRes;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

public class ResourceUtil
{
  public static Bitmap getBitmap(int paramInt)
  {
    return BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), paramInt);
  }
  
  @ColorInt
  public static int getColor(@ColorRes int paramInt)
  {
    return BaseApplicationImpl.getContext().getResources().getColor(paramInt);
  }
  
  public static String getString(@StringRes int paramInt)
  {
    return BaseApplicationImpl.getContext().getString(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.listview.ResourceUtil
 * JD-Core Version:    0.7.0.1
 */