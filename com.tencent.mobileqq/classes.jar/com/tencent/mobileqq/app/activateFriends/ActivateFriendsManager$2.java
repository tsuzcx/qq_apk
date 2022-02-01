package com.tencent.mobileqq.app.activateFriends;

import android.content.SharedPreferences;
import android.os.Handler;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;

class ActivateFriendsManager$2
  implements Runnable
{
  ActivateFriendsManager$2(ActivateFriendsManager paramActivateFriendsManager) {}
  
  public void run()
  {
    long l = ActivateFriendsManager.g(this.this$0).getLong("key_last_birth_msg_stamp", 0L);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("local birth timestamp = ");
      ((StringBuilder)localObject).append(l);
      QLog.d("ActivateFriends.Manager", 2, ((StringBuilder)localObject).toString());
    }
    if (MessageCache.c() - l > 259200L)
    {
      ActivateFriendsManager.i(this.this$0).removeCallbacks(ActivateFriendsManager.h(this.this$0));
      localObject = this.this$0;
      ((ActivateFriendsManager)localObject).a = ActivateFriendsManager.j((ActivateFriendsManager)localObject);
      ActivateFriendServlet.a(ActivateFriendsManager.e(this.this$0), false, true, false, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager.2
 * JD-Core Version:    0.7.0.1
 */