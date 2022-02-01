package androidx.appcompat.app;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ActionBarDrawerToggle$1
  implements View.OnClickListener
{
  ActionBarDrawerToggle$1(ActionBarDrawerToggle paramActionBarDrawerToggle) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.mDrawerIndicatorEnabled) {
      this.this$0.toggle();
    } else if (this.this$0.mToolbarNavigationClickListener != null) {
      this.this$0.mToolbarNavigationClickListener.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.app.ActionBarDrawerToggle.1
 * JD-Core Version:    0.7.0.1
 */