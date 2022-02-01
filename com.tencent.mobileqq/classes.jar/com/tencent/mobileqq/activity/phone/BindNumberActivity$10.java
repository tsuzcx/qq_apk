package com.tencent.mobileqq.activity.phone;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class BindNumberActivity$10
  extends FriendListObserver
{
  BindNumberActivity$10(BindNumberActivity paramBindNumberActivity) {}
  
  public void onGetFriendsHasBindPhone(boolean paramBoolean, int paramInt, List<String> paramList)
  {
    if (QLog.isColorLevel())
    {
      Object localObject;
      if (paramList == null) {
        localObject = "null";
      } else {
        localObject = Integer.valueOf(paramList.size());
      }
      QLog.i("BindNumberActivity", 2, String.format("onGetFriendsHasBindPhone [%s, %s, %s]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), localObject }));
    }
    if (paramBoolean) {
      this.a.runOnUiThread(new BindNumberActivity.10.1(this, paramInt, paramList));
    }
    this.a.app.removeObserver(this.a.h);
    this.a.h = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BindNumberActivity.10
 * JD-Core Version:    0.7.0.1
 */