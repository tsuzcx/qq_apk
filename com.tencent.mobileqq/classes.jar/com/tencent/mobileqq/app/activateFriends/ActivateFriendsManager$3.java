package com.tencent.mobileqq.app.activateFriends;

import android.os.Bundle;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;

class ActivateFriendsManager$3
  implements Runnable
{
  ActivateFriendsManager$3(ActivateFriendsManager paramActivateFriendsManager, int paramInt1, long[] paramArrayOfLong1, String paramString, int paramInt2, long[] paramArrayOfLong2) {}
  
  public void run()
  {
    int i = this.a;
    Object localObject;
    if (i == 1)
    {
      localObject = this.b;
      int j = localObject.length;
      i = 0;
      while (i < j)
      {
        long l = localObject[i];
        SessionInfo localSessionInfo = new SessionInfo();
        localSessionInfo.b = String.valueOf(l);
        localSessionInfo.a = 0;
        localSessionInfo.e = ContactUtils.g(ActivateFriendsManager.e(this.this$0), String.valueOf(l));
        ChatActivityFacade.SendMsgParams localSendMsgParams = new ChatActivityFacade.SendMsgParams();
        localSendMsgParams.a = false;
        ChatActivityFacade.a(ActivateFriendsManager.e(this.this$0), ActivateFriendsManager.e(this.this$0).getApp(), localSessionInfo, this.c, null, localSendMsgParams);
        i += 1;
      }
      this.this$0.a(this.b, 1);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("key_rt_type", 0);
      ActivateFriendsManager.e(this.this$0).notifyObservers(ActivateFriendsObserver.class, 113, true, (Bundle)localObject);
      return;
    }
    if ((i == 2) && (this.d != -1) && (!ActivateFriendServlet.a(ActivateFriendsManager.e(this.this$0), this.c, this.b, this.e, this.d)))
    {
      localObject = new Bundle();
      ((Bundle)localObject).putInt("key_rt_type", 2);
      ActivateFriendsManager.e(this.this$0).notifyObservers(ActivateFriendsObserver.class, 113, false, (Bundle)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager.3
 * JD-Core Version:    0.7.0.1
 */