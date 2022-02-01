package com.immersion.touchsensesdk;

import android.util.Log;
import java.net.SocketTimeoutException;

class ConnectionProxy
  implements IConnectionListener, IConnectionProxy
{
  private static final String TAG = "ConnectionProxy";
  private boolean mAborted;
  private Object mConnectionLock = new Object();
  private boolean mGotResponse;
  private AsyncConnectionProxy mProxy;
  private IConnection mResponse;
  
  public ConnectionProxy(AsyncConnectionProxy paramAsyncConnectionProxy)
  {
    this.mProxy = paramAsyncConnectionProxy;
    paramAsyncConnectionProxy.setConnectionListener(this);
  }
  
  public void abort()
  {
    synchronized (this.mConnectionLock)
    {
      this.mResponse = null;
      this.mAborted = true;
      this.mConnectionLock.notifyAll();
      return;
    }
  }
  
  public IConnection connect(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      Object localObject = this.mConnectionLock;
      long l2 = paramInt1;
      long l1 = l2;
      try
      {
        if (!this.mAborted)
        {
          this.mGotResponse = false;
          this.mResponse = null;
          this.mProxy.connect(paramString, paramInt1, paramInt2);
          try
          {
            long l3 = System.nanoTime();
            for (l1 = l2; (!this.mGotResponse) && (!this.mAborted) && (l1 > 0L); l1 = l2 - l1)
            {
              this.mConnectionLock.wait(l1);
              l1 = (System.nanoTime() - l3) / 1000000L;
            }
          }
          catch (InterruptedException paramString)
          {
            Log.w(TAG, "Connection wait interrupted.");
            paramString.printStackTrace();
            throw new SocketTimeoutException();
          }
        }
        if (!this.mAborted)
        {
          if (this.mResponse != null)
          {
            paramString = this.mResponse;
            return paramString;
          }
          if (l1 <= 0L)
          {
            Log.w(TAG, "Connection timeout.");
            throw new SocketTimeoutException();
          }
          Log.w(TAG, "Connection response is null.");
          throw new SocketTimeoutException();
        }
        Log.i(TAG, "Connection aborted.");
        throw new SocketTimeoutException();
      }
      finally {}
      throw paramString;
    }
    finally {}
    for (;;) {}
  }
  
  public void notifyConnection(IConnection paramIConnection)
  {
    synchronized (this.mConnectionLock)
    {
      this.mGotResponse = true;
      this.mResponse = paramIConnection;
      this.mConnectionLock.notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.immersion.touchsensesdk.ConnectionProxy
 * JD-Core Version:    0.7.0.1
 */