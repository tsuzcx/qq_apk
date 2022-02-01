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
      if ((localTroopCommonHolder != null) && (TroopWithCommonFriendsHelper.a(TroopWithCommonFriendsFragment.jdField_a_of_type_JavaLangString, localTroopCommonHolder.b)))
      {
        TroopWithCommonFriendsHelper.a(TroopWithCommonFriendsFragment.jdField_a_of_type_JavaLangString, localTroopCommonHolder.b, false);
        String str = this.a.getString(2131699470);
        localTroopCommonHolder.a.setText(str);
        localTroopCommonHolder.a.setClickable(false);
        localTroopCommonHolder.a.setBackgroundDrawable(null);
        localTroopCommonHolder.a.setTextAppearance(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131756341);
        TroopWithCommonFriendsHelper.a(localTroopCommonHolder.b, TroopWithCommonFriendsFragment.jdField_a_of_type_JavaLangString, "", TroopWithCommonFriendsFragment.a(this.a));
        ReportController.b(null, "dc00898", "", "", "0X800AD26", "0X800AD26", 0, 0, "0", "0", "", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment.5
 * JD-Core Version:    0.7.0.1
 */