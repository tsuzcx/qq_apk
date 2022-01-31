package com.tencent.av.app;

import com.tencent.av.VideoController;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;

public class MSFNetInfoMonitor
  implements INetInfoHandler
{
  VideoAppInterface a;
  
  public MSFNetInfoMonitor(VideoAppInterface paramVideoAppInterface)
  {
    this.a = paramVideoAppInterface;
  }
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSFNetInfoMonitor", 2, "Net Change: onNetMobile2None");
    }
    VideoController localVideoController = this.a.a();
    if (localVideoController != null) {
      localVideoController.a(0);
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSFNetInfoMonitor", 2, "Net Change: onNetMobile2Wifi");
    }
    paramString = this.a.a();
    if (paramString != null) {
      paramString.a(1);
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSFNetInfoMonitor", 2, "Net Change: onNetNone2Mobile");
    }
    paramString = this.a.a();
    if (paramString != null) {
      paramString.a(2);
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSFNetInfoMonitor", 2, "Net Change: onNetNone2Wifi");
    }
    paramString = this.a.a();
    if (paramString != null) {
      paramString.a(1);
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSFNetInfoMonitor", 2, "Net Change: onNetWifi2Mobile");
    }
    paramString = this.a.a();
    if (paramString != null) {
      paramString.a(2);
    }
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSFNetInfoMonitor", 2, "Net Change: onNetWifi2None");
    }
    VideoController localVideoController = this.a.a();
    if (localVideoController != null) {
      localVideoController.a(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.app.MSFNetInfoMonitor
 * JD-Core Version:    0.7.0.1
 */