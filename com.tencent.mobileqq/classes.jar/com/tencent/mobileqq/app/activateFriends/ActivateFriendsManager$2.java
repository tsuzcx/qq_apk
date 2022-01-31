package com.tencent.mobileqq.app.activateFriends;

import ambk;
import ambl;
import android.content.SharedPreferences;
import android.os.Handler;
import ayvc;
import com.tencent.qphone.base.util.QLog;

public class ActivateFriendsManager$2
  implements Runnable
{
  public ActivateFriendsManager$2(ambl paramambl) {}
  
  public void run()
  {
    long l = ambl.a(this.this$0).getLong("key_last_birth_msg_stamp", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.Manager", 2, "local birth timestamp = " + l);
    }
    if (ayvc.a() - l > 259200L)
    {
      ambl.a(this.this$0).removeCallbacks(ambl.a(this.this$0));
      this.this$0.a = ambl.b(this.this$0);
      ambk.a(ambl.a(this.this$0), false, true, false, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager.2
 * JD-Core Version:    0.7.0.1
 */