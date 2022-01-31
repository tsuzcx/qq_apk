package com.tencent.mobileqq.app.activateFriends;

import amfz;
import amga;
import android.content.SharedPreferences;
import android.os.Handler;
import ayzl;
import com.tencent.qphone.base.util.QLog;

public class ActivateFriendsManager$2
  implements Runnable
{
  public ActivateFriendsManager$2(amga paramamga) {}
  
  public void run()
  {
    long l = amga.a(this.this$0).getLong("key_last_birth_msg_stamp", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.Manager", 2, "local birth timestamp = " + l);
    }
    if (ayzl.a() - l > 259200L)
    {
      amga.a(this.this$0).removeCallbacks(amga.a(this.this$0));
      this.this$0.a = amga.b(this.this$0);
      amfz.a(amga.a(this.this$0), false, true, false, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager.2
 * JD-Core Version:    0.7.0.1
 */