package com.tencent.mobileqq.app.automator.step;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.VipInfoHandler;
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
  protected int doStep()
  {
    Object localObject = this.mAutomator.k.getApplication().getApplicationContext().getSharedPreferences(this.mAutomator.k.getCurrentAccountUin(), 0);
    long l = ((SharedPreferences)localObject).getLong("sp_vip_info_request_time", 0L);
    int i = ((SharedPreferences)localObject).getInt("sp_vip_info_update_freq", 10);
    localObject = ((SharedPreferences)localObject).getString("sp_vip_info_current_version", "");
    boolean bool = QUA.getQUA3().equalsIgnoreCase((String)localObject) ^ true;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" isVersionChange = ");
    ((StringBuilder)localObject).append(bool);
    QLog.e("Ilive", 1, ((StringBuilder)localObject).toString());
    if ((NetConnInfoCenter.getServerTime() - l > i * 60) || (bool))
    {
      localObject = this.mAutomator.k.getCurrentAccountUin();
      String str = ((TicketManager)this.mAutomator.k.getManager(2)).getSkey((String)localObject);
      ((VipInfoHandler)this.mAutomator.k.getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER)).a(str, (String)localObject);
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetDonateFriends
 * JD-Core Version:    0.7.0.1
 */