package com.tencent.mobileqq.apollo.game;

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
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    localObject = (CmGameSocketConnection)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    for (;;)
    {
      if (CmGameSocketConnection.a((CmGameSocketConnection)localObject).get()) {
        try
        {
          MsfSocketInputBuffer localMsfSocketInputBuffer = CmGameSocketConnection.a((CmGameSocketConnection)localObject);
          if (localMsfSocketInputBuffer == null) {
            return;
          }
          while (!localMsfSocketInputBuffer.isDataAvailable(10000)) {
            if (!CmGameSocketConnection.a((CmGameSocketConnection)localObject).get()) {
              return;
            }
          }
          if (!CmGameSocketConnection.a((CmGameSocketConnection)localObject).get()) {
            return;
          }
          if (CmGameSocketConnection.a((CmGameSocketConnection)localObject) != null)
          {
            CmGameSocketConnection.CmGameSocketConnectionListener localCmGameSocketConnectionListener = (CmGameSocketConnection.CmGameSocketConnectionListener)CmGameSocketConnection.a((CmGameSocketConnection)localObject).get();
            if (localCmGameSocketConnectionListener != null) {
              localCmGameSocketConnectionListener.a(localMsfSocketInputBuffer);
            }
          }
          localMsfSocketInputBuffer.reset();
        }
        catch (Exception localException)
        {
          QLog.e("[cmshow]CmGameConnection.ReadRunnable", 1, "read exception, e=", localException);
          ((CmGameSocketConnection)localObject).a(true);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.CmGameSocketConnection.ReadRunnable
 * JD-Core Version:    0.7.0.1
 */