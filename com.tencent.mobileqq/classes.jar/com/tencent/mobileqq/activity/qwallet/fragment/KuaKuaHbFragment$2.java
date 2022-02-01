package com.tencent.mobileqq.activity.qwallet.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.ChooseItemView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class KuaKuaHbFragment$2
  implements View.OnClickListener
{
  KuaKuaHbFragment$2(KuaKuaHbFragment paramKuaKuaHbFragment) {}
  
  public void onClick(View paramView)
  {
    if (KuaKuaHbFragment.a(this.a) != null) {
      KuaKuaHbFragment.a(this.a).a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.KuaKuaHbFragment.2
 * JD-Core Version:    0.7.0.1
 */