package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.SchoolInfo;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class FriendProfileMoreInfoActivity$1
  extends CardObserver
{
  FriendProfileMoreInfoActivity$1(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity) {}
  
  public void onGetEducationList(boolean paramBoolean, long paramLong, ArrayList<SchoolInfo> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileMoreInfoActivity", 2, "onGetEducationList, success:" + paramBoolean + ", uin=" + paramLong);
    }
    if (paramBoolean) {
      FriendProfileMoreInfoActivity.a(this.a, paramArrayList);
    }
  }
  
  public void onGetLocationDescription(boolean paramBoolean, String paramString, Card paramCard)
  {
    if ((paramBoolean) && (paramCard != null) && (Utils.a(this.a.app.getCurrentAccountUin(), paramCard.uin))) {
      FriendProfileMoreInfoActivity.a(this.a, paramCard, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity.1
 * JD-Core Version:    0.7.0.1
 */