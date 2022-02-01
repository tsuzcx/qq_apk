package com.tencent.mobileqq.activity.contact.troop;

import com.tencent.mobileqq.friends.intimate.IntimateInfoObserver;
import com.tencent.mobileqq.troop.adapter.CommonAdapter;
import com.tencent.mobileqq.widget.QQProgressDialog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class TroopWithCommonFriendsFragment$6
  extends IntimateInfoObserver
{
  TroopWithCommonFriendsFragment$6(TroopWithCommonFriendsFragment paramTroopWithCommonFriendsFragment) {}
  
  protected void a(boolean paramBoolean, int paramInt, ArrayList<TroopList> paramArrayList)
  {
    if (TroopWithCommonFriendsFragment.b(this.a) != null) {
      TroopWithCommonFriendsFragment.b(this.a).dismiss();
    }
    if (!paramBoolean)
    {
      this.a.n.sendEmptyMessage(1014);
      return;
    }
    TroopWithCommonFriendsHelper.a(TroopWithCommonFriendsFragment.g, paramArrayList);
    TroopWithCommonFriendsHelper.a(TroopWithCommonFriendsFragment.g, paramInt);
    TroopWithCommonFriendsFragment localTroopWithCommonFriendsFragment = this.a;
    localTroopWithCommonFriendsFragment.f = paramInt;
    localTroopWithCommonFriendsFragment.j = TroopWithCommonFriendsHelper.a(paramArrayList, TroopWithCommonFriendsFragment.a(localTroopWithCommonFriendsFragment));
    TroopWithCommonFriendsFragment.c(this.a).b();
    TroopWithCommonFriendsFragment.c(this.a).a(this.a.j);
    this.a.n.sendEmptyMessage(1012);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment.6
 * JD-Core Version:    0.7.0.1
 */