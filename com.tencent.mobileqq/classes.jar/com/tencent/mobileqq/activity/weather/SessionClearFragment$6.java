package com.tencent.mobileqq.activity.weather;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SessionClearFragment$6
  implements View.OnClickListener
{
  SessionClearFragment$6(SessionClearFragment paramSessionClearFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject = HardCodeUtil.a(2131713792);
    localObject = DialogUtil.a(SessionClearFragment.a(this.a), 230, HardCodeUtil.a(2131713794), (String)localObject, 2131694495, 2131720765, new SessionClearFragment.6.1(this), new SessionClearFragment.6.2(this));
    SessionClearFragment.a(this.a, (Dialog)localObject);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.SessionClearFragment.6
 * JD-Core Version:    0.7.0.1
 */