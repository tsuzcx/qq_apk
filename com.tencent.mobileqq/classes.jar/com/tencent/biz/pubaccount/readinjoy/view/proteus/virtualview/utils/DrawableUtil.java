package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ImageCommon;

public class DrawableUtil
{
  private static final String TAG = "DrawableUtil";
  private static DrawableUtil.DrawableHelper drawableHelper;
  
  public static Drawable getDrawable(Context paramContext, String paramString, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    if (paramString == null) {
      return null;
    }
    DrawableUtil.DrawableHelper localDrawableHelper = drawableHelper;
    if (localDrawableHelper != null) {
      paramDrawable1 = localDrawableHelper.getDrawable(paramContext, paramString, paramDrawable1, paramDrawable2);
    } else {
      paramDrawable1 = null;
    }
    if (paramDrawable1 != null) {
      return paramDrawable1;
    }
    paramDrawable1 = ImageCommon.getDrawableResourceId(paramString);
    if (paramDrawable1 != null) {}
    try
    {
      paramContext = paramContext.getResources().getDrawable(paramDrawable1.intValue());
      return paramContext;
    }
    catch (Resources.NotFoundException paramContext)
    {
      label62:
      break label62;
    }
    LogUtil.QLog.d("readinjoy.proteus", 2, "getDrawable: cant find in resources dir, do nothing");
    paramContext = new StringBuilder();
    paramContext.append("getDrawable: cant find path :");
    paramContext.append(paramString);
    LogUtil.QLog.e("readinjoy.proteus", 2, paramContext.toString());
    return null;
  }
  
  public static Drawable getDrawable(String paramString)
  {
    return new ColorDrawable(Utils.parseColor(paramString));
  }
  
  public static Drawable getDrawableFromNet(Context paramContext, String paramString, Drawable paramDrawable1, Drawable paramDrawable2, int paramInt1, int paramInt2, DrawableUtil.DrawableCallBack paramDrawableCallBack)
  {
    return drawableHelper.getDrawableFromNet(paramContext, paramString, paramDrawable1, paramDrawable2, paramInt1, paramInt2, paramDrawableCallBack);
  }
  
  public static StateListDrawable getSelector(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    if (paramDrawable2 != null) {
      localStateListDrawable.addState(new int[] { 16842919 }, paramDrawable2);
    }
    if (paramDrawable3 != null) {
      localStateListDrawable.addState(new int[] { 16842913 }, paramDrawable3);
    }
    if (paramDrawable1 != null) {
      localStateListDrawable.addState(new int[0], paramDrawable1);
    }
    return localStateListDrawable;
  }
  
  public static StateListDrawable getSelector(String paramString1, String paramString2, String paramString3)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    if (paramString2 != null)
    {
      paramString2 = getDrawable(paramString2);
      localStateListDrawable.addState(new int[] { 16842919 }, paramString2);
    }
    if (paramString3 != null)
    {
      paramString2 = getDrawable(paramString3);
      localStateListDrawable.addState(new int[] { 16842913 }, paramString2);
    }
    if (paramString1 != null)
    {
      paramString1 = getDrawable(paramString1);
      localStateListDrawable.addState(new int[0], paramString1);
    }
    return localStateListDrawable;
  }
  
  public static void setDrawableHelper(DrawableUtil.DrawableHelper paramDrawableHelper)
  {
    if (paramDrawableHelper == null) {
      return;
    }
    drawableHelper = paramDrawableHelper;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil
 * JD-Core Version:    0.7.0.1
 */