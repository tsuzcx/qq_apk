package com.tencent.mobileqq.activity.contact.troop;

import com.tencent.mobileqq.activity.contact.recommendtroop.base.CommonAdapter;
import com.tencent.mobileqq.friends.intimate.IntimateInfoObserver;
import com.tencent.mobileqq.widget.QQProgressDialog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class TroopWithCommonFriendsFragment$6
  extends IntimateInfoObserver
{
  TroopWithCommonFriendsFragment$6(TroopWithCommonFriendsFragment paramTroopWithCommonFriendsFragment) {}
  
  public void a(boolean paramBoolean, int paramInt, ArrayList<TroopList> paramArrayList)
  {
    if (TroopWithCommonFriendsFragment.a(this.a) != null) {
      TroopWithCommonFriendsFragment.a(this.a).dismiss();
    }
    if (!paramBoolean)
    {
      this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1014);
      return;
    }
    TroopWithCommonFriendsHelper.a(TroopWithCommonFriendsFragment.jdField_a_of_type_JavaLangString, paramArrayList);
    TroopWithCommonFriendsHelper.a(TroopWithCommonFriendsFragment.jdField_a_of_type_JavaLangString, paramInt);
    this.a.b = paramInt;
    this.a.jdField_a_of_type_JavaUtilList = TroopWithCommonFriendsHelper.a(paramArrayList, TroopWithCommonFriendsFragment.a(this.a));
    TroopWithCommonFriendsFragment.a(this.a).a();
    TroopWithCommonFriendsFragment.a(this.a).a(this.a.jdField_a_of_type_JavaUtilList);
    this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1012);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment.6
 * JD-Core Version:    0.7.0.1
 */