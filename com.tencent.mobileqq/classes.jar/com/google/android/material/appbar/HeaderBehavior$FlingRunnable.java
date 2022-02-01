package com.google.android.material.appbar;

import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;

class HeaderBehavior$FlingRunnable
  implements Runnable
{
  private final V jdField_a_of_type_AndroidViewView;
  private final CoordinatorLayout jdField_a_of_type_AndroidxCoordinatorlayoutWidgetCoordinatorLayout;
  
  HeaderBehavior$FlingRunnable(CoordinatorLayout paramCoordinatorLayout, V paramV)
  {
    this.jdField_a_of_type_AndroidxCoordinatorlayoutWidgetCoordinatorLayout = paramV;
    Object localObject;
    this.jdField_a_of_type_AndroidViewView = localObject;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.this$0.a != null))
    {
      if (this.this$0.a.computeScrollOffset())
      {
        HeaderBehavior localHeaderBehavior = this.this$0;
        localHeaderBehavior.a(this.jdField_a_of_type_AndroidxCoordinatorlayoutWidgetCoordinatorLayout, this.jdField_a_of_type_AndroidViewView, localHeaderBehavior.a.getCurrY());
        ViewCompat.postOnAnimation(this.jdField_a_of_type_AndroidViewView, this);
        return;
      }
      this.this$0.a(this.jdField_a_of_type_AndroidxCoordinatorlayoutWidgetCoordinatorLayout, this.jdField_a_of_type_AndroidViewView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.appbar.HeaderBehavior.FlingRunnable
 * JD-Core Version:    0.7.0.1
 */