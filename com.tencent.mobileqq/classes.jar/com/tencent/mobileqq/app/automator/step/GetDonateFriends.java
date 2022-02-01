package com.tencent.mobileqq.app.automator.step;

import android.content.Context;
import android.content.SharedPreferences;
import aneg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QUA;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;

public class GetDonateFriends
  extends AsyncStep
{
  public int a()
  {
    boolean bool = false;
    Object localObject = this.a.app.getApplication().getApplicationContext().getSharedPreferences(this.a.app.getCurrentAccountUin(), 0);
    long l = ((SharedPreferences)localObject).getLong("sp_vip_info_request_time", 0L);
    int i = ((SharedPreferences)localObject).getInt("sp_vip_info_update_freq", 10);
    localObject = ((SharedPreferences)localObject).getString("sp_vip_info_current_version", "");
    if (!QUA.getQUA3().equalsIgnoreCase((String)localObject)) {
      bool = true;
    }
    QLog.e("Ilive", 1, " isVersionChange = " + bool);
    if ((NetConnInfoCenter.getServerTime() - l > i * 60) || (bool))
    {
      localObject = this.a.app.getCurrentAccountUin();
      String str = ((TicketManager)this.a.app.getManager(2)).getSkey((String)localObject);
      ((aneg)this.a.app.getBusinessHandler(27)).a(str, (String)localObject);
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetDonateFriends
 * JD-Core Version:    0.7.0.1
 */