package androidx.coordinatorlayout.widget;

import android.view.ViewTreeObserver.OnPreDrawListener;

class CoordinatorLayout$OnPreDrawListener
  implements ViewTreeObserver.OnPreDrawListener
{
  CoordinatorLayout$OnPreDrawListener(CoordinatorLayout paramCoordinatorLayout) {}
  
  public boolean onPreDraw()
  {
    this.this$0.onChildViewsChanged(0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.coordinatorlayout.widget.CoordinatorLayout.OnPreDrawListener
 * JD-Core Version:    0.7.0.1
 */