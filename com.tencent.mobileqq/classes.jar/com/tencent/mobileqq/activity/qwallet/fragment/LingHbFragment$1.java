package com.tencent.mobileqq.activity.qwallet.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.ChooseItemView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LingHbFragment$1
  implements View.OnClickListener
{
  LingHbFragment$1(LingHbFragment paramLingHbFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.c.clearFocus();
    LingHbFragment.a(this.a).a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.LingHbFragment.1
 * JD-Core Version:    0.7.0.1
 */