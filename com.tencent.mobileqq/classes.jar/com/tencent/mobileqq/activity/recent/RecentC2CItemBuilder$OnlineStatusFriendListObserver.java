package com.tencent.mobileqq.activity.recent;

import android.os.Message;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import friendlist.GetOnlineInfoResp;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

class RecentC2CItemBuilder$OnlineStatusFriendListObserver
  extends FriendListObserver
{
  private final QQAppInterface a;
  private final RecentBaseData b;
  
  private RecentC2CItemBuilder$OnlineStatusFriendListObserver(QQAppInterface paramQQAppInterface, RecentBaseData paramRecentBaseData)
  {
    this.a = paramQQAppInterface;
    this.b = paramRecentBaseData;
  }
  
  protected void onGetOnlineInfoByUinOrMobile(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    paramString = this.a.getHandler(Conversation.class);
    if (paramString == null) {
      return;
    }
    paramString = paramString.obtainMessage(1019);
    paramGetOnlineInfoResp = new ArrayList();
    paramGetOnlineInfoResp.add(this.b);
    paramString.obj = paramGetOnlineInfoResp;
    paramString.sendToTarget();
    this.a.removeObserver(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentC2CItemBuilder.OnlineStatusFriendListObserver
 * JD-Core Version:    0.7.0.1
 */