package androidx.appcompat.view.menu;

import android.view.View;
import android.widget.FrameLayout;

class MenuItemWrapperICS$CollapsibleActionViewWrapper
  extends FrameLayout
  implements androidx.appcompat.view.CollapsibleActionView
{
  final android.view.CollapsibleActionView mWrappedView;
  
  MenuItemWrapperICS$CollapsibleActionViewWrapper(View paramView)
  {
    super(paramView.getContext());
    this.mWrappedView = ((android.view.CollapsibleActionView)paramView);
    addView(paramView);
  }
  
  View getWrappedView()
  {
    return (View)this.mWrappedView;
  }
  
  public void onActionViewCollapsed()
  {
    this.mWrappedView.onActionViewCollapsed();
  }
  
  public void onActionViewExpanded()
  {
    this.mWrappedView.onActionViewExpanded();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.view.menu.MenuItemWrapperICS.CollapsibleActionViewWrapper
 * JD-Core Version:    0.7.0.1
 */