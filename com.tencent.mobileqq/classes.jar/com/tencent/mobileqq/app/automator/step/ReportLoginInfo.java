package com.tencent.mobileqq.app.automator.step;

import awqx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;

public class ReportLoginInfo
  extends AsyncStep
{
  private void b()
  {
    try
    {
      String str2 = this.a.app.getCurrentAccountUin();
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      awqx.a(this.a.app, "dc00899", "TSTViewTime", str1, "AChanged", "2", 0, 0, SecUtil.toHexString(NetConnInfoCenter.GUID), "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("ReportLoginInfo", 2, "---> report login! --- uin: " + str1 + " Guid: " + SecUtil.toHexString(NetConnInfoCenter.GUID));
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public int a()
  {
    b();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.ReportLoginInfo
 * JD-Core Version:    0.7.0.1
 */