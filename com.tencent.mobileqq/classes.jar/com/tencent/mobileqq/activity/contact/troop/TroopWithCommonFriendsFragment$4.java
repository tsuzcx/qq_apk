package com.tencent.mobileqq.activity.contact.troop;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.utils.TroopInfoUIUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopWithCommonFriendsFragment$4
  implements View.OnClickListener
{
  TroopWithCommonFriendsFragment$4(TroopWithCommonFriendsFragment paramTroopWithCommonFriendsFragment) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof TroopCommonHolder))
    {
      Object localObject = (TroopCommonHolder)paramView.getTag();
      if (localObject != null)
      {
        localObject = TroopInfoUIUtil.a(((TroopCommonHolder)localObject).b, 4);
        ((Bundle)localObject).putInt("t_s_f", 1002);
        TroopUtils.a(this.a.getActivity(), (Bundle)localObject, 2);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment.4
 * JD-Core Version:    0.7.0.1
 */