package com.google.android.material.behavior;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.view.accessibility.AccessibilityViewCommand.CommandArguments;

class SwipeDismissBehavior$2
  implements AccessibilityViewCommand
{
  SwipeDismissBehavior$2(SwipeDismissBehavior paramSwipeDismissBehavior) {}
  
  public boolean perform(@NonNull View paramView, @Nullable AccessibilityViewCommand.CommandArguments paramCommandArguments)
  {
    boolean bool = this.a.a(paramView);
    int k = 0;
    if (bool)
    {
      int i;
      if (ViewCompat.getLayoutDirection(paramView) == 1) {
        i = 1;
      } else {
        i = 0;
      }
      int j;
      if ((this.a.jdField_a_of_type_Int != 0) || (i == 0))
      {
        j = k;
        if (this.a.jdField_a_of_type_Int == 1)
        {
          j = k;
          if (i != 0) {}
        }
      }
      else
      {
        j = 1;
      }
      if (j != 0) {
        i = -paramView.getWidth();
      } else {
        i = paramView.getWidth();
      }
      ViewCompat.offsetLeftAndRight(paramView, i);
      paramView.setAlpha(0.0F);
      if (this.a.jdField_a_of_type_ComGoogleAndroidMaterialBehaviorSwipeDismissBehavior$OnDismissListener != null) {
        this.a.jdField_a_of_type_ComGoogleAndroidMaterialBehaviorSwipeDismissBehavior$OnDismissListener.a(paramView);
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.behavior.SwipeDismissBehavior.2
 * JD-Core Version:    0.7.0.1
 */