package com.google.android.material.internal;

import android.view.View;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
public class ToolbarUtils
{
  @Nullable
  public static ActionMenuItemView a(@NonNull Toolbar paramToolbar, @IdRes int paramInt)
  {
    paramToolbar = a(paramToolbar);
    if (paramToolbar != null)
    {
      int i = 0;
      while (i < paramToolbar.getChildCount())
      {
        Object localObject = paramToolbar.getChildAt(i);
        if ((localObject instanceof ActionMenuItemView))
        {
          localObject = (ActionMenuItemView)localObject;
          if (((ActionMenuItemView)localObject).getItemData().getItemId() == paramInt) {
            return localObject;
          }
        }
        i += 1;
      }
    }
    return null;
  }
  
  @Nullable
  public static ActionMenuView a(@NonNull Toolbar paramToolbar)
  {
    int i = 0;
    while (i < paramToolbar.getChildCount())
    {
      View localView = paramToolbar.getChildAt(i);
      if ((localView instanceof ActionMenuView)) {
        return (ActionMenuView)localView;
      }
      i += 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.internal.ToolbarUtils
 * JD-Core Version:    0.7.0.1
 */