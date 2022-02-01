package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import mqq.app.MobileQQ;

public class ReportLoginInfo
  extends AsyncStep
{
  private String a = "mark_time_";
  private String b = "byte_data_time_stamp";
  
  private String a(String paramString)
  {
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes(Charset.forName("US-ASCII")), 0, paramString.length());
      paramString = new StringBuilder();
      localObject = ((MessageDigest)localObject).digest();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        paramString.append(String.format("%02x", new Object[] { Integer.valueOf(localObject[i] & 0xFF) }));
        i += 1;
      }
      paramString = paramString.toString();
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  private void a()
  {
    try
    {
      Object localObject2 = this.mAutomator.a.getCurrentAccountUin();
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject2 = a((String)localObject1);
      MobileQQ localMobileQQ = this.mAutomator.a.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append((String)localObject2);
      long l = localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0).getLong(this.b, 0L);
      ReportController.a(this.mAutomator.a, "dc00899", "TSTViewTime", (String)localObject1, "AChanged", "2", 0, 0, SecUtil.toHexString(NetConnInfoCenter.GUID), "", "", String.valueOf(l));
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("---> report login! --- uin: ");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" Guid: ");
        ((StringBuilder)localObject2).append(SecUtil.toHexString(NetConnInfoCenter.GUID));
        ((StringBuilder)localObject2).append(" reportID： ");
        ((StringBuilder)localObject2).append(l);
        QLog.d("ReportLoginInfo", 2, ((StringBuilder)localObject2).toString());
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected int doStep()
  {
    a();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.ReportLoginInfo
 * JD-Core Version:    0.7.0.1
 */