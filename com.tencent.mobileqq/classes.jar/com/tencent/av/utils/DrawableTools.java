package com.tencent.av.utils;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

public class DrawableTools
{
  public static Drawable a(Resources paramResources, int paramInt)
  {
    return a(paramResources, paramInt, 2131166769, true, 2130842986, 2131166772, null);
  }
  
  private static Drawable a(Resources paramResources, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4, Drawable paramDrawable)
  {
    Drawable localDrawable = paramResources.getDrawable(paramInt1);
    Object localObject;
    if (paramBoolean) {
      localObject = TintStateDrawable.a(paramResources, paramInt1, paramInt2);
    } else {
      localObject = localDrawable;
    }
    ((Drawable)localObject).setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    localDrawable = paramResources.getDrawable(paramInt3);
    paramResources = TintStateDrawable.a(paramResources, paramInt3, paramInt4);
    paramResources.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    if (paramDrawable == null)
    {
      paramResources = new LayerDrawable(new Drawable[] { paramResources, localObject });
      paramResources.setLayerInset(0, 0, 0, 0, 0);
      paramResources.setLayerInset(1, 0, 0, 0, 0);
    }
    else
    {
      paramResources = new LayerDrawable(new Drawable[] { paramResources, localObject, paramDrawable });
      paramResources.setLayerInset(0, 0, 0, 0, 0);
      paramResources.setLayerInset(1, 0, 0, 0, 0);
      paramResources.setLayerInset(2, 0, 0, 0, 0);
    }
    paramResources.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    return paramResources;
  }
  
  public static Drawable a(Resources paramResources, int paramInt, Drawable paramDrawable, boolean paramBoolean)
  {
    return a(paramResources, paramInt, 2131166769, paramBoolean, 2130842986, 2131166772, paramDrawable);
  }
  
  public static Drawable a(Resources paramResources, int paramInt, boolean paramBoolean)
  {
    return a(paramResources, paramInt, 2131166769, paramBoolean, 2130842986, 2131166772, null);
  }
  
  public static Drawable b(Resources paramResources, int paramInt)
  {
    Drawable localDrawable = paramResources.getDrawable(paramInt);
    paramResources = TintStateDrawable.a(paramResources, paramInt, 2131166769);
    paramResources.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    return paramResources;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.DrawableTools
 * JD-Core Version:    0.7.0.1
 */