package com.tencent.live2.b;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;

public class c
{
  private static boolean a = false;
  
  public static void a()
  {
    if (!a) {
      return;
    }
    TXCLog.i("V2-MonitorHelper", "unInitMonitorLog");
    Monitor.a();
    a = false;
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    if (a) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initMonitorLog [userId:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("][sdkAppId:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("][roomId:");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("]");
    TXCLog.i("V2-MonitorHelper", localStringBuilder.toString());
    Monitor.a(paramString1, paramInt, paramString2);
    a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.b.c
 * JD-Core Version:    0.7.0.1
 */