package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.helper.OnlineStatusHelper;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.onlinestatus.OnlineStatusObserver;
import com.tencent.mobileqq.onlinestatus.olympic.model.OlympicMedalEventInfo;
import com.tencent.qphone.base.util.QLog;

class FriendChatPie$20
  extends OnlineStatusObserver
{
  FriendChatPie$20(FriendChatPie paramFriendChatPie) {}
  
  public void a(boolean paramBoolean, OlympicMedalEventInfo paramOlympicMedalEventInfo)
  {
    QLog.d("FriendChatPie", 1, "onUpdateOlympicMedalEvent");
    paramOlympicMedalEventInfo = ((FriendsManager)this.a.d.getManager(QQManagerFactory.FRIENDS_MANAGER)).m(this.a.ah.b);
    if ((paramOlympicMedalEventInfo != null) && (paramOlympicMedalEventInfo.uExtOnlineStatus == 1080L))
    {
      ((OnlineStatusHelper)this.a.g.a(129)).b();
      if ((this.a.bb() < 8) && (this.a.bb() >= 2)) {
        FriendChatPie.b(this.a);
      }
    }
    this.a.j(131072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.20
 * JD-Core Version:    0.7.0.1
 */