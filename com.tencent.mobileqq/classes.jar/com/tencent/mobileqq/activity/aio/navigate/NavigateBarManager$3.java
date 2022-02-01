package com.tencent.mobileqq.activity.aio.navigate;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NavigateBarManager$3
  implements View.OnClickListener
{
  NavigateBarManager$3(NavigateBarManager paramNavigateBarManager) {}
  
  public void onClick(View paramView)
  {
    if (NavigateBarManager.a(this.a) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NavigateBarManager", 2, String.format("onClick barId: %s", new Object[] { Integer.valueOf(NavigateBarManager.a(this.a).e) }));
      }
      NavigateBar localNavigateBar = NavigateBarManager.a(this.a);
      NavigateBarManager.c(this.a);
      if (localNavigateBar != null) {
        localNavigateBar.b();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.navigate.NavigateBarManager.3
 * JD-Core Version:    0.7.0.1
 */