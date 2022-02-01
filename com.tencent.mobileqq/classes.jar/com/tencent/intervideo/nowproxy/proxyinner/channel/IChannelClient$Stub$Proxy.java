package com.tencent.intervideo.nowproxy.proxyinner.channel;

import android.os.IBinder;
import android.os.Parcel;

class IChannelClient$Stub$Proxy
  implements IChannelClient
{
  private IBinder a;
  
  IChannelClient$Stub$Proxy(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public String a()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.intervideo.nowproxy.proxyinner.channel.IChannelClient");
      this.a.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      String str = localParcel2.readString();
      return str;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void a(int paramInt, FromService paramFromService)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.intervideo.nowproxy.proxyinner.channel.IChannelClient");
      localParcel1.writeInt(paramInt);
      if (paramFromService != null)
      {
        localParcel1.writeInt(1);
        paramFromService.writeToParcel(localParcel1, 0);
      }
      else
      {
        localParcel1.writeInt(0);
      }
      this.a.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.proxyinner.channel.IChannelClient.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */