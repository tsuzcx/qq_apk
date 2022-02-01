package androidx.coordinatorlayout.widget;

import android.view.View;
import android.view.ViewGroup.OnHierarchyChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CoordinatorLayout$HierarchyChangeListener
  implements ViewGroup.OnHierarchyChangeListener
{
  CoordinatorLayout$HierarchyChangeListener(CoordinatorLayout paramCoordinatorLayout) {}
  
  public void onChildViewAdded(View paramView1, View paramView2)
  {
    EventCollector.getInstance().onChildViewAdded(paramView1, paramView2);
    if (this.this$0.mOnHierarchyChangeListener != null) {
      this.this$0.mOnHierarchyChangeListener.onChildViewAdded(paramView1, paramView2);
    }
  }
  
  public void onChildViewRemoved(View paramView1, View paramView2)
  {
    EventCollector.getInstance().onChildViewRemoved(paramView1, paramView2);
    this.this$0.onChildViewsChanged(2);
    if (this.this$0.mOnHierarchyChangeListener != null) {
      this.this$0.mOnHierarchyChangeListener.onChildViewRemoved(paramView1, paramView2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.coordinatorlayout.widget.CoordinatorLayout.HierarchyChangeListener
 * JD-Core Version:    0.7.0.1
 */