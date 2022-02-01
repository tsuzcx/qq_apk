package com.google.android.material.appbar;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.view.accessibility.AccessibilityViewCommand.CommandArguments;

class AppBarLayout$BaseBehavior$3
  implements AccessibilityViewCommand
{
  AppBarLayout$BaseBehavior$3(AppBarLayout.BaseBehavior paramBaseBehavior, AppBarLayout paramAppBarLayout, boolean paramBoolean) {}
  
  public boolean perform(@NonNull View paramView, @Nullable AccessibilityViewCommand.CommandArguments paramCommandArguments)
  {
    this.a.setExpanded(this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.appbar.AppBarLayout.BaseBehavior.3
 * JD-Core Version:    0.7.0.1
 */