package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.qphone.base.util.QLog;

class LimitChatPie$5
  extends FriendListObserver
{
  LimitChatPie$5(LimitChatPie paramLimitChatPie) {}
  
  public void onAddFriend(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.b, 2, "onAddFriend : " + paramString);
    }
    if ((this.a.t()) && (paramString != null) && (paramString.equals(this.a.a.a))) {
      LimitChatPie.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.5
 * JD-Core Version:    0.7.0.1
 */