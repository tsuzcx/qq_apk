package com.google.android.material.resources;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class MaterialAttributes
{
  public static int a(@NonNull Context paramContext, @AttrRes int paramInt, @NonNull String paramString)
  {
    TypedValue localTypedValue = a(paramContext, paramInt);
    if (localTypedValue != null) {
      return localTypedValue.data;
    }
    throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", new Object[] { paramString, paramContext.getResources().getResourceName(paramInt) }));
  }
  
  public static int a(@NonNull View paramView, @AttrRes int paramInt)
  {
    return a(paramView.getContext(), paramInt, paramView.getClass().getCanonicalName());
  }
  
  @Nullable
  public static TypedValue a(@NonNull Context paramContext, @AttrRes int paramInt)
  {
    TypedValue localTypedValue = new TypedValue();
    if (paramContext.getTheme().resolveAttribute(paramInt, localTypedValue, true)) {
      return localTypedValue;
    }
    return null;
  }
  
  public static boolean a(@NonNull Context paramContext, @AttrRes int paramInt, boolean paramBoolean)
  {
    paramContext = a(paramContext, paramInt);
    boolean bool = paramBoolean;
    if (paramContext != null)
    {
      bool = paramBoolean;
      if (paramContext.type == 18)
      {
        if (paramContext.data != 0) {
          return true;
        }
        bool = false;
      }
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.resources.MaterialAttributes
 * JD-Core Version:    0.7.0.1
 */