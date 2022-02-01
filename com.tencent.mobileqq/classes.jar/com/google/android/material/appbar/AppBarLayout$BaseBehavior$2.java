package com.google.android.material.appbar;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.view.accessibility.AccessibilityViewCommand.CommandArguments;

class AppBarLayout$BaseBehavior$2
  implements AccessibilityViewCommand
{
  AppBarLayout$BaseBehavior$2(AppBarLayout.BaseBehavior paramBaseBehavior, CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, View paramView, int paramInt) {}
  
  public boolean perform(@NonNull View paramView, @Nullable AccessibilityViewCommand.CommandArguments paramCommandArguments)
  {
    this.e.a(this.a, this.b, this.c, 0, this.d, new int[] { 0, 0 }, 1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.appbar.AppBarLayout.BaseBehavior.2
 * JD-Core Version:    0.7.0.1
 */