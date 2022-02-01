package com.tencent.mobileqq.apollo.lightGame;

import amom;
import com.tencent.qphone.base.util.MsfSocketInputBuffer;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

class CmGameSocketConnection$ReadRunnable
  implements Runnable
{
  private WeakReference<CmGameSocketConnection> a;
  
  public CmGameSocketConnection$ReadRunnable(CmGameSocketConnection paramCmGameSocketConnection)
  {
    this.a = new WeakReference(paramCmGameSocketConnection);
  }
  
  public void run()
  {
    if (this.a != null)
    {
      CmGameSocketConnection localCmGameSocketConnection = (CmGameSocketConnection)this.a.get();
      for (;;)
      {
        if ((localCmGameSocketConnection != null) && (CmGameSocketConnection.a(localCmGameSocketConnection).get())) {
          try
          {
            MsfSocketInputBuffer localMsfSocketInputBuffer = CmGameSocketConnection.a(localCmGameSocketConnection);
            if (localMsfSocketInputBuffer == null) {
              return;
            }
            while (!localMsfSocketInputBuffer.isDataAvailable(10000)) {
              if (!CmGameSocketConnection.a(localCmGameSocketConnection).get()) {
                return;
              }
            }
            if (CmGameSocketConnection.a(localCmGameSocketConnection).get())
            {
              if (CmGameSocketConnection.a(localCmGameSocketConnection) != null)
              {
                amom localamom = (amom)CmGameSocketConnection.a(localCmGameSocketConnection).get();
                if (localamom != null) {
                  localamom.a(localMsfSocketInputBuffer);
                }
              }
              localMsfSocketInputBuffer.reset();
            }
          }
          catch (Exception localException)
          {
            QLog.e("CmGameConnection.ReadRunnable", 1, "read exception, e=", localException);
            localCmGameSocketConnection.a(true);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.lightGame.CmGameSocketConnection.ReadRunnable
 * JD-Core Version:    0.7.0.1
 */