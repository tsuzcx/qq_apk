package com.tencent.mobileqq.activity.miniaio;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.FriendListObserver;
import friendlist.GetOnlineInfoResp;

class MiniPie$10
  extends FriendListObserver
{
  MiniPie$10(MiniPie paramMiniPie) {}
  
  protected void onGetOnlineInfoByUinOrMobile(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if (TextUtils.equals(paramString, this.a.a.a)) {
      this.a.f();
    }
  }
  
  protected void onUpdateOnlineFriend(boolean paramBoolean, String[] paramArrayOfString)
  {
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniPie.10
 * JD-Core Version:    0.7.0.1
 */