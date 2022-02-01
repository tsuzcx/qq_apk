package com.tencent.mobileqq.app.activateFriends;

import android.content.SharedPreferences;
import android.os.Handler;
import anyq;
import anyr;
import bbyp;
import com.tencent.qphone.base.util.QLog;

public class ActivateFriendsManager$2
  implements Runnable
{
  public ActivateFriendsManager$2(anyr paramanyr) {}
  
  public void run()
  {
    long l = anyr.a(this.this$0).getLong("key_last_birth_msg_stamp", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.Manager", 2, "local birth timestamp = " + l);
    }
    if (bbyp.a() - l > 259200L)
    {
      anyr.a(this.this$0).removeCallbacks(anyr.a(this.this$0));
      this.this$0.a = anyr.b(this.this$0);
      anyq.a(anyr.a(this.this$0), false, true, false, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager.2
 * JD-Core Version:    0.7.0.1
 */