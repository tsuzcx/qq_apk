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
    ActionMenuItemView localActionMenuItemView = ToolbarUtils.a(this.a, this.b);
    if (localActionMenuItemView != null)
    {
      BadgeDrawable localBadgeDrawable = this.c;
      localBadgeDrawable.f(localBadgeDrawable.h() + this.a.getResources().getDimensionPixelOffset(R.dimen.K));
      localBadgeDrawable = this.c;
      localBadgeDrawable.g(localBadgeDrawable.i() + this.a.getResources().getDimensionPixelOffset(R.dimen.L));
      BadgeUtils.a(this.c, localActionMenuItemView, this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.badge.BadgeUtils.1
 * JD-Core Version:    0.7.0.1
 */