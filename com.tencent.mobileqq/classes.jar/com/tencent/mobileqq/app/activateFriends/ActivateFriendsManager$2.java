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
    long l = ActivateFriendsManager.a(this.this$0).getLong("key_last_birth_msg_stamp", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.Manager", 2, "local birth timestamp = " + l);
    }
    if (MessageCache.a() - l > 259200L)
    {
      ActivateFriendsManager.a(this.this$0).removeCallbacks(ActivateFriendsManager.a(this.this$0));
      this.this$0.a = ActivateFriendsManager.b(this.this$0);
      ActivateFriendServlet.a(ActivateFriendsManager.a(this.this$0), false, true, false, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager.2
 * JD-Core Version:    0.7.0.1
 */