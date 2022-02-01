package com.immersion.touchsensesdk;

public abstract class AsyncConnectionProxy
{
  private IConnectionListener mListener;
  
  public abstract void connect(String paramString, int paramInt1, int paramInt2);
  
  public IConnectionProxy getConnectionProxy()
  {
    return new ConnectionProxy(this);
  }
  
  public void setConnection(IConnection paramIConnection)
  {
    IConnectionListener localIConnectionListener = this.mListener;
    if (localIConnectionListener != null) {
      localIConnectionListener.notifyConnection(paramIConnection);
    }
  }
  
  void setConnectionListener(IConnectionListener paramIConnectionListener)
  {
    this.mListener = paramIConnectionListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.immersion.touchsensesdk.AsyncConnectionProxy
 * JD-Core Version:    0.7.0.1
 */