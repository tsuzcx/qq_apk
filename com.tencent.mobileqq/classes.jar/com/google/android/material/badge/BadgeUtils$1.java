package com.google.android.material.badge;

import android.content.res.Resources;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.R.dimen;
import com.google.android.material.internal.ToolbarUtils;

final class BadgeUtils$1
  implements Runnable
{
  public void run()
  {
    ActionMenuItemView localActionMenuItemView = ToolbarUtils.a(this.jdField_a_of_type_AndroidxAppcompatWidgetToolbar, this.jdField_a_of_type_Int);
    if (localActionMenuItemView != null)
    {
      BadgeDrawable localBadgeDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable;
      localBadgeDrawable.f(localBadgeDrawable.c() + this.jdField_a_of_type_AndroidxAppcompatWidgetToolbar.getResources().getDimensionPixelOffset(R.dimen.K));
      localBadgeDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable;
      localBadgeDrawable.g(localBadgeDrawable.d() + this.jdField_a_of_type_AndroidxAppcompatWidgetToolbar.getResources().getDimensionPixelOffset(R.dimen.L));
      BadgeUtils.a(this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable, localActionMenuItemView, this.jdField_a_of_type_AndroidWidgetFrameLayout);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.badge.BadgeUtils.1
 * JD-Core Version:    0.7.0.1
 */