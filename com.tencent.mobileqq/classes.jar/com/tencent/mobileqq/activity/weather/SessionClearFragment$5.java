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
    if (SessionClearFragment.e(this.a) == 0)
    {
      SessionClearFragment.f(this.a).setText(HardCodeUtil.a(2131911262));
      SessionClearFragment.a(this.a, 1);
      SessionClearFragment.d(this.a).b();
    }
    else
    {
      SessionClearFragment.f(this.a).setText(HardCodeUtil.a(2131911260));
      SessionClearFragment.a(this.a, 0);
      SessionClearFragment.d(this.a).c();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.SessionClearFragment.5
 * JD-Core Version:    0.7.0.1
 */