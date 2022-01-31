package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ImageCommon;
import com.tencent.biz.pubaccount.util.PubAccountHttpDownloader;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class DrawableUtil
{
  public static Drawable a(Context paramContext, String paramString, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    if (paramString == null) {
      return null;
    }
    if (paramString.startsWith("http"))
    {
      paramContext = URLDrawable.URLDrawableOptions.obtain();
      paramContext.mLoadingDrawable = paramDrawable1;
      paramContext.mFailedDrawable = paramDrawable2;
      return URLDrawable.getDrawable(PubAccountHttpDownloader.a(paramString, 3), paramContext);
    }
    Integer localInteger = ImageCommon.a(paramString);
    String str = OfflineUtils.a(paramString);
    if (str != null)
    {
      paramContext = URLDrawable.URLDrawableOptions.obtain();
      paramContext.mLoadingDrawable = paramDrawable1;
      paramContext.mFailedDrawable = paramDrawable2;
      return URLDrawable.getDrawable(new File(str), paramContext);
    }
    if (localInteger != null) {
      try
      {
        paramContext = paramContext.getResources().getDrawable(localInteger.intValue());
        return paramContext;
      }
      catch (Resources.NotFoundException paramContext)
      {
        QLog.d("Q.readinjoy.proteus", 2, "getDrawable: cant find in resources dir, do nothing");
      }
    }
    QLog.e("Q.readinjoy.proteus", 2, "getDrawable: cant find path :" + paramString);
    return null;
  }
  
  public static Drawable a(String paramString)
  {
    return new ColorDrawable(Utils.a(paramString));
  }
  
  public static StateListDrawable a(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3)
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
  
  public static StateListDrawable a(String paramString1, String paramString2, String paramString3)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    if (paramString2 != null)
    {
      paramString2 = a(paramString2);
      localStateListDrawable.addState(new int[] { 16842919 }, paramString2);
    }
    if (paramString3 != null)
    {
      paramString2 = a(paramString3);
      localStateListDrawable.addState(new int[] { 16842913 }, paramString2);
    }
    if (paramString1 != null)
    {
      paramString1 = a(paramString1);
      localStateListDrawable.addState(new int[0], paramString1);
    }
    return localStateListDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil
 * JD-Core Version:    0.7.0.1
 */