package com.tencent.mobileqq.activity.aio.helper;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.FriendListObserver;
import friendlist.GetOnlineInfoResp;

class OnlineStatusHelper$1
  extends FriendListObserver
{
  OnlineStatusHelper$1(OnlineStatusHelper paramOnlineStatusHelper) {}
  
  protected void onGetOnlineInfoByUinOrMobile(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if (TextUtils.equals(paramString, this.a.a.a)) {
      this.a.b();
    }
  }
  
  protected void onUpdateOnlineFriend(boolean paramBoolean, String[] paramArrayOfString)
  {
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.OnlineStatusHelper.1
 * JD-Core Version:    0.7.0.1
 */