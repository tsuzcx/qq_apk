package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;

public class AIOTimeReporter
{
  private static String c = "HighDeviceFirstOpenAIOBusiness";
  private static String d = "HighDeviceFirstOpenAIOBase";
  private static String e = "HighDeviceNotFirstOpenAIOBusiness";
  private static String f = "HighDeviceNotFirstOpenAIOBase";
  private static String g = "MidDeviceFirstOpenAIOBusiness";
  private static String h = "MidDeviceFirstOpenAIOBase";
  private static String i = "MidDeviceNotFirstOpenAIOBusiness";
  private static String j = "MidDeviceNotFirstOpenAIOBase";
  private static String k = "LowDeviceFirstOpenAIOBusiness";
  private static String l = "LowDeviceFirstOpenAIOBase";
  private static String m = "LowDeviceNotFirstOpenAIOBusiness";
  private static String n = "LowDeviceNotFirstOpenAIOBase";
  private int a = -1;
  private String b = "0";
  
  private void n()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.aio.AIOTimeReporter", 4, "reSet ");
    }
    this.a = -1;
    this.b = "0";
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.aio.AIOTimeReporter", 4, "reportAIOLifeCycleTime ");
    }
    if (new Random().nextInt(100) != 1)
    {
      n();
      return;
    }
    ThreadManager.post(new AIOTimeReporter.1(this), 1, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOTimeReporter
 * JD-Core Version:    0.7.0.1
 */