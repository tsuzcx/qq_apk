package com.tencent.mobileqq.activity.qwallet.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class KuaKuaHbFragment$4
  implements View.OnClickListener
{
  KuaKuaHbFragment$4(KuaKuaHbFragment paramKuaKuaHbFragment) {}
  
  public void onClick(View paramView)
  {
    if ((paramView instanceof TextView)) {
      KuaKuaHbFragment.a(this.a).setText(((TextView)paramView).getText().toString());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.KuaKuaHbFragment.4
 * JD-Core Version:    0.7.0.1
 */