package com.tencent.av.app;

import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;

public class MSFNetInfoMonitor
  implements INetInfoHandler
{
  private MSFNetInfoMonitor.IApnChangeListener a;
  
  public MSFNetInfoMonitor(MSFNetInfoMonitor.IApnChangeListener paramIApnChangeListener)
  {
    this.a = paramIApnChangeListener;
  }
  
  public static int a()
  {
    boolean bool = AppNetConnInfo.isWifiConn();
    int i = 3;
    int j;
    if (bool)
    {
      j = 1;
      i = 1;
    }
    else if (AppNetConnInfo.isMobileConn())
    {
      int k = AppNetConnInfo.getMobileInfo();
      j = k;
      if (k != 1) {
        if (k != 2)
        {
          if (k != 3)
          {
            if (k != 4)
            {
              i = 100;
              j = k;
            }
            else
            {
              i = 14;
              j = k;
            }
          }
          else
          {
            i = 11;
            j = k;
          }
        }
        else
        {
          i = 9;
          j = k;
        }
      }
    }
    else
    {
      i = 0;
      j = -1;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getApn: ");
      localStringBuilder.append(i);
      localStringBuilder.append(" mobileType:");
      localStringBuilder.append(j);
      QLog.d("MSFNetInfoMonitor", 2, localStringBuilder.toString());
    }
    return i;
  }
  
  public static int b()
  {
    if (AppNetConnInfo.isWifiConn()) {
      return 1;
    }
    if (AppNetConnInfo.isMobileConn()) {
      return AppNetConnInfo.getMobileInfo();
    }
    return -1;
  }
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSFNetInfoMonitor", 2, "Net Change: onNetMobile2None");
    }
    MSFNetInfoMonitor.IApnChangeListener localIApnChangeListener = this.a;
    if (localIApnChangeListener != null) {
      localIApnChangeListener.a(0);
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSFNetInfoMonitor", 2, "Net Change: onNetMobile2Wifi");
    }
    paramString = this.a;
    if (paramString != null) {
      paramString.a(1);
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSFNetInfoMonitor", 2, "Net Change: onNetNone2Mobile");
    }
    paramString = this.a;
    if (paramString != null) {
      paramString.a(2);
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSFNetInfoMonitor", 2, "Net Change: onNetNone2Wifi");
    }
    paramString = this.a;
    if (paramString != null) {
      paramString.a(1);
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSFNetInfoMonitor", 2, "Net Change: onNetWifi2Mobile");
    }
    paramString = this.a;
    if (paramString != null) {
      paramString.a(2);
    }
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSFNetInfoMonitor", 2, "Net Change: onNetWifi2None");
    }
    MSFNetInfoMonitor.IApnChangeListener localIApnChangeListener = this.a;
    if (localIApnChangeListener != null) {
      localIApnChangeListener.a(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.MSFNetInfoMonitor
 * JD-Core Version:    0.7.0.1
 */