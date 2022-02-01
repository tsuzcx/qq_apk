package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.util.WeakReferenceHandler;

class FriendProfileCardActivity$4
  extends CardObserver
{
  FriendProfileCardActivity$4(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void onGetLocationDescription(boolean paramBoolean, String paramString, Card paramCard)
  {
    if ((paramBoolean) && (paramCard != null) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a.equals(paramCard.uin)) && (this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null))
    {
      paramString = this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage();
      paramString.what = 8;
      paramString.obj = paramCard;
      this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.4
 * JD-Core Version:    0.7.0.1
 */