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
    int i = this.jdField_a_of_type_Int;
    Object localObject;
    if (i == 1)
    {
      localObject = this.jdField_a_of_type_ArrayOfLong;
      int j = localObject.length;
      i = 0;
      while (i < j)
      {
        long l = localObject[i];
        SessionInfo localSessionInfo = new SessionInfo();
        localSessionInfo.jdField_a_of_type_JavaLangString = String.valueOf(l);
        localSessionInfo.jdField_a_of_type_Int = 0;
        localSessionInfo.d = ContactUtils.f(ActivateFriendsManager.a(this.this$0), String.valueOf(l));
        ChatActivityFacade.SendMsgParams localSendMsgParams = new ChatActivityFacade.SendMsgParams();
        localSendMsgParams.a = false;
        ChatActivityFacade.a(ActivateFriendsManager.a(this.this$0), ActivateFriendsManager.a(this.this$0).getApp(), localSessionInfo, this.jdField_a_of_type_JavaLangString, null, localSendMsgParams);
        i += 1;
      }
      this.this$0.a(this.jdField_a_of_type_ArrayOfLong, 1);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("key_rt_type", 0);
      ActivateFriendsManager.a(this.this$0).notifyObservers(ActivateFriendsObserver.class, 113, true, (Bundle)localObject);
      return;
    }
    if ((i == 2) && (this.jdField_b_of_type_Int != -1) && (!ActivateFriendServlet.a(ActivateFriendsManager.a(this.this$0), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfLong, this.jdField_b_of_type_ArrayOfLong, this.jdField_b_of_type_Int)))
    {
      localObject = new Bundle();
      ((Bundle)localObject).putInt("key_rt_type", 2);
      ActivateFriendsManager.a(this.this$0).notifyObservers(ActivateFriendsObserver.class, 113, false, (Bundle)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager.3
 * JD-Core Version:    0.7.0.1
 */