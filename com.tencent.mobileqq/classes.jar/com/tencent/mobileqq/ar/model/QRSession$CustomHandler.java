package com.tencent.mobileqq.ar.model;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.ar.codeEngine.MiniScanReport;
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
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      QRSession.a(this.a);
      return;
      if (QRSession.a(this.a))
      {
        QRSession.a(this.a, false);
        MiniScanReport.a();
      }
      try
      {
        QRSession.b(this.a);
        return;
      }
      catch (Throwable paramMessage) {}
    } while (!QLog.isColorLevel());
    QLog.i("QRSession", 2, paramMessage.getMessage(), paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QRSession.CustomHandler
 * JD-Core Version:    0.7.0.1
 */