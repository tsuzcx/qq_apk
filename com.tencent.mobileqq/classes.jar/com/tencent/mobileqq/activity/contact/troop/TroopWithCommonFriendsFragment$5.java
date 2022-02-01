package com.tencent.mobileqq.activity.contact.troop;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopWithCommonFriendsFragment$5
  implements View.OnClickListener
{
  TroopWithCommonFriendsFragment$5(TroopWithCommonFriendsFragment paramTroopWithCommonFriendsFragment) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof TroopCommonHolder))
    {
      TroopCommonHolder localTroopCommonHolder = (TroopCommonHolder)paramView.getTag();
      if ((localTroopCommonHolder != null) && (TroopWithCommonFriendsHelper.a(TroopWithCommonFriendsFragment.g, localTroopCommonHolder.j)))
      {
        TroopWithCommonFriendsHelper.a(TroopWithCommonFriendsFragment.g, localTroopCommonHolder.j, false);
        String str = this.a.getString(2131897501);
        localTroopCommonHolder.h.setText(str);
        localTroopCommonHolder.h.setClickable(false);
        localTroopCommonHolder.h.setBackgroundDrawable(null);
        localTroopCommonHolder.h.setTextAppearance(this.a.d, 2131953504);
        TroopWithCommonFriendsHelper.a(localTroopCommonHolder.j, TroopWithCommonFriendsFragment.g, "", TroopWithCommonFriendsFragment.a(this.a));
        ReportController.b(null, "dc00898", "", "", "0X800AD26", "0X800AD26", 0, 0, "0", "0", "", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment.5
 * JD-Core Version:    0.7.0.1
 */