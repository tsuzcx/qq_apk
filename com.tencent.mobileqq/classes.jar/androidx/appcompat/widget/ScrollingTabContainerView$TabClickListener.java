package androidx.appcompat.widget;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.app.ActionBar.Tab;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ScrollingTabContainerView$TabClickListener
  implements View.OnClickListener
{
  ScrollingTabContainerView$TabClickListener(ScrollingTabContainerView paramScrollingTabContainerView) {}
  
  public void onClick(View paramView)
  {
    ((ScrollingTabContainerView.TabView)paramView).getTab().select();
    int j = this.this$0.mTabLayout.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = this.this$0.mTabLayout.getChildAt(i);
      boolean bool;
      if (localView == paramView) {
        bool = true;
      } else {
        bool = false;
      }
      localView.setSelected(bool);
      i += 1;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.ScrollingTabContainerView.TabClickListener
 * JD-Core Version:    0.7.0.1
 */