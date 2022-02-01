package com.google.android.material.behavior;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;

class SwipeDismissBehavior$SettleRunnable
  implements Runnable
{
  private final View jdField_a_of_type_AndroidViewView;
  private final boolean jdField_a_of_type_Boolean;
  
  SwipeDismissBehavior$SettleRunnable(SwipeDismissBehavior paramSwipeDismissBehavior, View paramView, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_AndroidxCustomviewWidgetViewDragHelper != null) && (this.this$0.jdField_a_of_type_AndroidxCustomviewWidgetViewDragHelper.continueSettling(true)))
    {
      ViewCompat.postOnAnimation(this.jdField_a_of_type_AndroidViewView, this);
      return;
    }
    if ((this.jdField_a_of_type_Boolean) && (this.this$0.jdField_a_of_type_ComGoogleAndroidMaterialBehaviorSwipeDismissBehavior$OnDismissListener != null)) {
      this.this$0.jdField_a_of_type_ComGoogleAndroidMaterialBehaviorSwipeDismissBehavior$OnDismissListener.a(this.jdField_a_of_type_AndroidViewView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.behavior.SwipeDismissBehavior.SettleRunnable
 * JD-Core Version:    0.7.0.1
 */