package com.tencent.mobileqq.activity.aio.intimate.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.intimate.BaseIntimateView;
import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class IntimateContentItemCommonTroopView$1
  implements View.OnClickListener
{
  IntimateContentItemCommonTroopView$1(IntimateContentItemCommonTroopView paramIntimateContentItemCommonTroopView) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.i != null) && (!this.a.i.isEmpty()))
    {
      TroopWithCommonFriendsFragment.a(this.a.h.k());
      TroopWithCommonFriendsFragment.a(paramView.getContext(), 2);
      ReportController.b(null, "dc00898", "", "", "0X800AD22", "0X800AD22", 0, 0, "0", "0", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemCommonTroopView.1
 * JD-Core Version:    0.7.0.1
 */