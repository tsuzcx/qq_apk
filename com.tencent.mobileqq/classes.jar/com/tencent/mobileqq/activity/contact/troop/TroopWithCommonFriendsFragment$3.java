package com.tencent.mobileqq.activity.contact.troop;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopWithCommonFriendsFragment$3
  implements View.OnClickListener
{
  TroopWithCommonFriendsFragment$3(TroopWithCommonFriendsFragment paramTroopWithCommonFriendsFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if ((paramView.getTag() instanceof TroopCommonHolder))
    {
      localObject = (TroopCommonHolder)paramView.getTag();
      if (localObject != null) {
        break label30;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label30:
      localObject = TroopInfoActivity.a(((TroopCommonHolder)localObject).b, 4);
      ((Bundle)localObject).putInt("t_s_f", 1002);
      TroopUtils.a(this.a.getActivity(), (Bundle)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment.3
 * JD-Core Version:    0.7.0.1
 */