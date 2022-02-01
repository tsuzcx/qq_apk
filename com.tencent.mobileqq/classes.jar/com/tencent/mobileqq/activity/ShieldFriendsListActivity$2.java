package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class ShieldFriendsListActivity$2
  extends FriendListObserver
{
  ShieldFriendsListActivity$2(ShieldFriendsListActivity paramShieldFriendsListActivity) {}
  
  protected void onUpdateFriendShieldFlag(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    super.onUpdateFriendShieldFlag(paramLong, paramBoolean1, paramBoolean2, paramBoolean3, paramString);
    if (!paramBoolean2)
    {
      if (ShieldFriendsListActivity.a(this.a, paramLong, paramBoolean1 ^ true)) {
        QQToast.a(BaseApplication.getContext(), HardCodeUtil.a(2131713873), 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299168));
      }
    }
    else
    {
      if (ShieldFriendsListActivity.a(this.a).a(String.valueOf(paramLong)))
      {
        ShieldFriendsListActivity.a(this.a, paramLong, paramBoolean1);
        return;
      }
      paramString = ((FriendsManager)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(String.valueOf(paramLong));
      if ((paramString != null) && (!paramString.isShield()))
      {
        ShieldFriendsListActivity.a(this.a).a(paramString);
        ShieldFriendsListActivity.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ShieldFriendsListActivity.2
 * JD-Core Version:    0.7.0.1
 */