package com.tencent.mobileqq.ar.model;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IQRScanReportApi;
import com.tencent.qphone.base.util.QLog;

class QRSession$CustomHandler
  extends Handler
{
  public QRSession$CustomHandler(QRSession paramQRSession, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 100)
    {
      if (i != 101) {
        return;
      }
      if (QRSession.a(this.a))
      {
        QRSession.a(this.a, false);
        ((IQRScanReportApi)QRoute.api(IQRScanReportApi.class)).markScanStart();
      }
      try
      {
        QRSession.b(this.a);
        return;
      }
      catch (Throwable paramMessage)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      QLog.i("QRSession", 2, paramMessage.getMessage(), paramMessage);
    }
    else
    {
      QRSession.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QRSession.CustomHandler
 * JD-Core Version:    0.7.0.1
 */