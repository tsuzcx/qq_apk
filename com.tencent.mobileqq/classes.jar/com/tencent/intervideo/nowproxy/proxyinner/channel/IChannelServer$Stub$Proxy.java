package com.tencent.intervideo.nowproxy.proxyinner.channel;

import android.os.IBinder;
import android.os.Parcel;

class IChannelServer$Stub$Proxy
  implements IChannelServer
{
  private IBinder a;
  
  public void a(int paramInt, ToService paramToService)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.intervideo.nowproxy.proxyinner.channel.IChannelServer");
      localParcel1.writeInt(paramInt);
      if (paramToService != null)
      {
        localParcel1.writeInt(1);
        paramToService.writeToParcel(localParcel1, 0);
      }
      else
      {
        localParcel1.writeInt(0);
      }
      this.a.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void a(IChannelClient paramIChannelClient)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.intervideo.nowproxy.proxyinner.channel.IChannelServer");
        if (paramIChannelClient != null)
        {
          paramIChannelClient = paramIChannelClient.asBinder();
          localParcel1.writeStrongBinder(paramIChannelClient);
          this.a.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      paramIChannelClient = null;
    }
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.proxyinner.channel.IChannelServer.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */