package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.ActionMenuView;

class BottomAppBar$7
  extends AnimatorListenerAdapter
{
  public boolean a;
  
  BottomAppBar$7(BottomAppBar paramBottomAppBar, ActionMenuView paramActionMenuView, int paramInt, boolean paramBoolean) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      boolean bool;
      if (BottomAppBar.d(this.jdField_a_of_type_ComGoogleAndroidMaterialBottomappbarBottomAppBar) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      paramAnimator = this.jdField_a_of_type_ComGoogleAndroidMaterialBottomappbarBottomAppBar;
      paramAnimator.a(BottomAppBar.d(paramAnimator));
      BottomAppBar.a(this.jdField_a_of_type_ComGoogleAndroidMaterialBottomappbarBottomAppBar, this.jdField_a_of_type_AndroidxAppcompatWidgetActionMenuView, this.jdField_a_of_type_Int, this.b, bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.bottomappbar.BottomAppBar.7
 * JD-Core Version:    0.7.0.1
 */