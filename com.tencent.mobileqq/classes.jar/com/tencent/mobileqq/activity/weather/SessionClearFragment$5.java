package com.tencent.mobileqq.activity.weather;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SessionClearFragment$5
  implements View.OnClickListener
{
  SessionClearFragment$5(SessionClearFragment paramSessionClearFragment) {}
  
  public void onClick(View paramView)
  {
    if (SessionClearFragment.a(this.a) == 0)
    {
      SessionClearFragment.a(this.a).setText(HardCodeUtil.a(2131713791));
      SessionClearFragment.a(this.a, 1);
      SessionClearFragment.a(this.a).b();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      SessionClearFragment.a(this.a).setText(HardCodeUtil.a(2131713789));
      SessionClearFragment.a(this.a, 0);
      SessionClearFragment.a(this.a).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.SessionClearFragment.5
 * JD-Core Version:    0.7.0.1
 */