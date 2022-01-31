package com.tencent.mobileqq.app.proxy.fts;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.mobileqq.app.proxy.FTSDBManager;
import com.tencent.qphone.base.util.QLog;

public class FTSSyncHandler
  extends Handler
{
  private FTSDBManager a;
  
  public FTSSyncHandler(Looper paramLooper, QQAppInterface paramQQAppInterface, FTSDBManager paramFTSDBManager)
  {
    super(paramLooper);
    this.a = paramFTSDBManager;
  }
  
  public void a()
  {
    removeCallbacksAndMessages(null);
  }
  
  public void dispatchMessage(Message paramMessage)
  {
    ThreadRegulator.a().b();
    super.dispatchMessage(paramMessage);
  }
  
  public void handleMessage(Message paramMessage)
  {
    FTSIndexOperator localFTSIndexOperator = (FTSIndexOperator)paramMessage.obj;
    paramMessage.obj = null;
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          if (localFTSIndexOperator.c())
          {
            sendMessageDelayed(obtainMessage(2, localFTSIndexOperator), 30000L);
            return;
          }
        } while (!QLog.isColorLevel());
        QLog.w("Q.fts.sync_worker", 2, "readSyncedCursor is false!!");
        return;
        removeMessages(2, localFTSIndexOperator);
        if (localFTSIndexOperator.d()) {
          localFTSIndexOperator.e();
        }
      } while (this.a.b);
      paramMessage = obtainMessage(2, localFTSIndexOperator);
      if (localFTSIndexOperator.e()) {}
      for (long l = 15000L;; l = 30000L)
      {
        sendMessageDelayed(paramMessage, l);
        return;
      }
      removeMessages(3, localFTSIndexOperator);
      localFTSIndexOperator.e();
    } while (!this.a.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.fts.FTSSyncHandler
 * JD-Core Version:    0.7.0.1
 */