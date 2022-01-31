package com.tencent.mobileqq.app.automator.step;

import amfs;
import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;

public class GetDonateFriends
  extends AsyncStep
{
  public int a()
  {
    Object localObject = this.a.app.getApplication().getApplicationContext().getSharedPreferences(this.a.app.getCurrentAccountUin(), 0);
    long l = ((SharedPreferences)localObject).getLong("sp_vip_info_request_time", 0L);
    int i = ((SharedPreferences)localObject).getInt("sp_vip_info_update_freq", 10);
    if (NetConnInfoCenter.getServerTime() - l <= i * 60) {}
    for (;;)
    {
      return 7;
      localObject = this.a.app.getCurrentAccountUin();
      String str = ((TicketManager)this.a.app.getManager(2)).getSkey((String)localObject);
      ((amfs)this.a.app.a(27)).a(str, (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetDonateFriends
 * JD-Core Version:    0.7.0.1
 */