package com.huawei.hms.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public abstract class ResourceLoaderUtil
{
  public static Context a;
  public static String b;
  
  public static int getAnimId(String paramString)
  {
    return a.getResources().getIdentifier(paramString, "anim", b);
  }
  
  public static int getColorId(String paramString)
  {
    return a.getResources().getIdentifier(paramString, "color", b);
  }
  
  public static Drawable getDrawable(String paramString)
  {
    return a.getResources().getDrawable(getDrawableId(paramString));
  }
  
  public static int getDrawableId(String paramString)
  {
    return a.getResources().getIdentifier(paramString, "drawable", b);
  }
  
  public static int getIdId(String paramString)
  {
    return a.getResources().getIdentifier(paramString, "id", b);
  }
  
  public static int getLayoutId(String paramString)
  {
    return a.getResources().getIdentifier(paramString, "layout", b);
  }
  
  public static String getString(String paramString)
  {
    return a.getResources().getString(getStringId(paramString));
  }
  
  public static String getString(String paramString, Object... paramVarArgs)
  {
    return a.getResources().getString(getStringId(paramString), paramVarArgs);
  }
  
  public static int getStringId(String paramString)
  {
    return a.getResources().getIdentifier(paramString, "string", b);
  }
  
  public static int getStyleId(String paramString)
  {
    return a.getResources().getIdentifier(paramString, "style", b);
  }
  
  public static Context getmContext()
  {
    return a;
  }
  
  public static void setmContext(Context paramContext)
  {
    a = paramContext;
    b = paramContext.getPackageName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.utils.ResourceLoaderUtil
 * JD-Core Version:    0.7.0.1
 */