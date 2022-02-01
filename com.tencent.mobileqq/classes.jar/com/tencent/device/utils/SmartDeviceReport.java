package com.tencent.device.utils;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;
import mqq.app.AppRuntime;

public final class SmartDeviceReport
{
  protected static SmartDeviceReport a;
  private static String e = "smartdevice::smartdevicereport";
  public String b = "";
  public int c = 0;
  public long d = 0L;
  
  public static SmartDeviceReport a()
  {
    try
    {
      if (a == null) {
        a = new SmartDeviceReport();
      }
      SmartDeviceReport localSmartDeviceReport = a;
      return localSmartDeviceReport;
    }
    finally {}
  }
  
  public static void a(AppRuntime paramAppRuntime, long paramLong, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("action:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" fromType:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" result:");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" din:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" ext2:");
      localStringBuilder.append(paramInt3);
      QLog.d("SDReport", 2, localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramLong);
    a(paramAppRuntime, paramString, localStringBuilder.toString(), paramInt1, paramInt2, paramInt3, 0, "", "");
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("action:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" fromType:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" result:");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" ext2:");
      localStringBuilder.append(paramInt3);
      QLog.d("SDReport", 2, localStringBuilder.toString());
    }
    a(paramAppRuntime, paramString, "", paramInt1, paramInt2, paramInt3, 0, "", "");
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString3, String paramString4)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      paramAppRuntime = (QQAppInterface)paramAppRuntime;
    } else {
      paramAppRuntime = null;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = e;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("smartdevice datareport, actionname:");
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append(", fromType:");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append(", actionResult = ");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append(", ext2:");
      ((StringBuilder)localObject2).append(paramInt3);
      ((StringBuilder)localObject2).append(", ext3:");
      ((StringBuilder)localObject2).append(paramInt4);
      ((StringBuilder)localObject2).append(", ext4:");
      ((StringBuilder)localObject2).append(paramString3);
      ((StringBuilder)localObject2).append(", ext5:");
      ((StringBuilder)localObject2).append(paramString4);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(paramInt3);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(paramInt4);
    localObject2 = ((StringBuilder)localObject2).toString();
    if (paramString3 == null) {
      paramString3 = "";
    }
    if (paramString4 == null) {
      paramString4 = "";
    }
    ReportController.b(paramAppRuntime, "CliOper", "", paramString2, "SmartDevice", paramString1, paramInt1, paramInt2, (String)localObject1, (String)localObject2, paramString3, paramString4);
  }
  
  public void a(int paramInt)
  {
    long l = this.d;
    if (0L == l) {
      this.d = (new Random().nextInt() & 0xFFFFFFFF);
    } else {
      this.d = (l + 1L);
    }
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        this.d %= 1431655765L;
        l = this.d;
        if (0L == l) {
          this.d = (l + 1L);
        }
      }
      else
      {
        this.d = (this.d % 1431655765L + 2863311530L);
      }
    }
    else {
      this.d = (this.d % 1431655765L + 1431655765L);
    }
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString, int paramInt)
  {
    b(paramAppRuntime, paramString, paramInt);
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString1, int paramInt1, int paramInt2, String paramString2, long paramLong)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      paramAppRuntime = (QQAppInterface)paramAppRuntime;
    } else {
      paramAppRuntime = null;
    }
    if (paramString2 == null) {
      paramString2 = "";
    }
    if (QLog.isColorLevel())
    {
      localObject = e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("smartdevice datareport2, actionname:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",result:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", pid:");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(",sn:");
      localStringBuilder.append(paramString2);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(paramLong);
    ReportController.b(paramAppRuntime, "CliOper", "", ((StringBuilder)localObject).toString(), "SmartDevice", paramString1, paramInt1, 0, Long.toString(paramInt2), "", paramString2, "");
  }
  
  public void b(AppRuntime paramAppRuntime, String paramString, int paramInt)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      paramAppRuntime = (QQAppInterface)paramAppRuntime;
    } else {
      paramAppRuntime = null;
    }
    long l = this.d & 0xFFFFFFFF;
    String str2 = this.b;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    if (QLog.isColorLevel())
    {
      str2 = e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("smartdevice datareport, actionname:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",result:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", pid:");
      localStringBuilder.append(Long.toString(this.c));
      localStringBuilder.append(",sn:");
      localStringBuilder.append(str1);
      localStringBuilder.append(",seq:");
      localStringBuilder.append(Long.toString(l));
      QLog.d(str2, 2, localStringBuilder.toString());
    }
    if ((!"Net_Wifi_Config_Time_Used".equals(paramString)) && (!"Net_Wifi_Config_Ack_Time_Used".equals(paramString)))
    {
      ReportController.b(paramAppRuntime, "CliOper", "", "0", "SmartDevice", paramString, paramInt, 0, Long.toString(this.c), Long.toString(l), str1, "");
      return;
    }
    ReportController.b(paramAppRuntime, "CliOper", "", "0", "SmartDevice", paramString, 0, paramInt, Long.toString(this.c), Long.toString(l), str1, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.utils.SmartDeviceReport
 * JD-Core Version:    0.7.0.1
 */