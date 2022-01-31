package com.tencent.mobileqq.app;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;

public class QQWiFiMainManager$RemoteResultReceiver
  extends ResultReceiver
{
  QQAppInterface a;
  
  public QQWiFiMainManager$RemoteResultReceiver(QQAppInterface paramQQAppInterface, Handler paramHandler)
  {
    super(paramHandler);
    this.a = paramQQAppInterface;
  }
  
  private void a()
  {
    RedTouchManager localRedTouchManager = (RedTouchManager)this.a.getManager(35);
    BusinessInfoCheckUpdate.AppInfo localAppInfo = localRedTouchManager.a("100190.100191.100193");
    if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiMainManager", 2, "clearOperationTipRedPoint");
      }
      localRedTouchManager.b(localAppInfo.path.get());
    }
  }
  
  private void b()
  {
    RedTouchManager localRedTouchManager = (RedTouchManager)this.a.getManager(35);
    BusinessInfoCheckUpdate.AppInfo localAppInfo = localRedTouchManager.a("100190.100191.100192");
    if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQWiFiMainManager", 2, "clearShareBtnRedPoint");
      }
      localRedTouchManager.b(localAppInfo.path.get());
    }
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("QQWiFiMainManager", 2, "onReceiveResult, resultCode=" + paramInt);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      a();
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQWiFiMainManager.RemoteResultReceiver
 * JD-Core Version:    0.7.0.1
 */