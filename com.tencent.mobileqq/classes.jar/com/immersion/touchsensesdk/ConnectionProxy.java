package com.immersion.touchsensesdk;

import android.util.Log;
import java.net.SocketTimeoutException;

class ConnectionProxy
  implements IConnectionListener, IConnectionProxy
{
  private static final String TAG = ConnectionProxy.class.getSimpleName();
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
    throws SocketTimeoutException
  {
    Object localObject;
    long l2;
    try
    {
      localObject = this.mConnectionLock;
      long l1 = paramInt1;
      l2 = l1;
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
            for (;;)
            {
              l2 = l1;
              if (this.mGotResponse) {
                break;
              }
              l2 = l1;
              if (this.mAborted) {
                break;
              }
              l2 = l1;
              if (l1 <= 0L) {
                break;
              }
              this.mConnectionLock.wait(l1);
              l1 = paramInt1;
              l2 = (System.nanoTime() - l3) / 1000000L;
              l1 -= l2;
            }
            paramString = finally;
          }
          catch (InterruptedException paramString)
          {
            Log.w(TAG, "Connection wait interrupted.");
            paramString.printStackTrace();
            throw new SocketTimeoutException();
          }
          paramString = finally;
        }
      }
      finally {}
      if (!this.mAborted) {
        break label176;
      }
    }
    finally {}
    Log.i(TAG, "Connection aborted.");
    throw new SocketTimeoutException();
    label176:
    if (this.mResponse != null)
    {
      paramString = this.mResponse;
      return paramString;
    }
    if (l2 <= 0L)
    {
      Log.w(TAG, "Connection timeout.");
      throw new SocketTimeoutException();
    }
    Log.w(TAG, "Connection response is null.");
    throw new SocketTimeoutException();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.immersion.touchsensesdk.ConnectionProxy
 * JD-Core Version:    0.7.0.1
 */