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
  private String b = "mark_time_";
  private String c = "byte_data_time_stamp";
  
  private String a(String paramString)
  {
    int i = 0;
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes(Charset.forName("US-ASCII")), 0, paramString.length());
      paramString = new StringBuilder();
      localObject = ((MessageDigest)localObject).digest();
      int j = localObject.length;
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
      String str2 = this.a.a.getCurrentAccountUin();
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      str2 = a(str1);
      long l = this.a.a.getApplication().getSharedPreferences(this.b + str2, 0).getLong(this.c, 0L);
      ReportController.a(this.a.a, "dc00899", "TSTViewTime", str1, "AChanged", "2", 0, 0, SecUtil.toHexString(NetConnInfoCenter.GUID), "", "", String.valueOf(l));
      if (QLog.isColorLevel()) {
        QLog.d("ReportLoginInfo", 2, "---> report login! --- uin: " + str1 + " Guid: " + SecUtil.toHexString(NetConnInfoCenter.GUID) + " reportID： " + l);
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
    a();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.ReportLoginInfo
 * JD-Core Version:    0.7.0.1
 */