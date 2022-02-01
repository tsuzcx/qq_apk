package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public final class BottomNavigationMenu
  extends MenuBuilder
{
  public BottomNavigationMenu(Context paramContext)
  {
    super(paramContext);
  }
  
  protected MenuItem addInternal(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    if (size() + 1 <= 5)
    {
      stopDispatchingItemsChanged();
      paramCharSequence = super.addInternal(paramInt1, paramInt2, paramInt3, paramCharSequence);
      if ((paramCharSequence instanceof MenuItemImpl)) {
        ((MenuItemImpl)paramCharSequence).setExclusiveCheckable(true);
      }
      startDispatchingItemsChanged();
      return paramCharSequence;
    }
    throw new IllegalArgumentException("Maximum number of items supported by BottomNavigationView is 5. Limit can be checked with BottomNavigationView#getMaxItemCount()");
  }
  
  @NonNull
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    throw new UnsupportedOperationException("BottomNavigationView does not support submenus");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.bottomnavigation.BottomNavigationMenu
 * JD-Core Version:    0.7.0.1
 */