package com.tencent.mobileqq.app.activateFriends;

import android.content.SharedPreferences;
import android.os.Handler;
import aohd;
import aohe;
import bcrg;
import com.tencent.qphone.base.util.QLog;

public class ActivateFriendsManager$2
  implements Runnable
{
  public ActivateFriendsManager$2(aohe paramaohe) {}
  
  public void run()
  {
    long l = aohe.a(this.this$0).getLong("key_last_birth_msg_stamp", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.Manager", 2, "local birth timestamp = " + l);
    }
    if (bcrg.a() - l > 259200L)
    {
      aohe.a(this.this$0).removeCallbacks(aohe.a(this.this$0));
      this.this$0.a = aohe.b(this.this$0);
      aohd.a(aohe.a(this.this$0), false, true, false, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager.2
 * JD-Core Version:    0.7.0.1
 */