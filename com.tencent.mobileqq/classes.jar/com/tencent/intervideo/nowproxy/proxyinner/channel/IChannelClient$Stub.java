package com.tencent.intervideo.nowproxy.proxyinner.channel;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class IChannelClient$Stub
  extends Binder
  implements IChannelClient
{
  public IChannelClient$Stub()
  {
    attachInterface(this, "com.tencent.intervideo.nowproxy.proxyinner.channel.IChannelClient");
  }
  
  public static IChannelClient a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.intervideo.nowproxy.proxyinner.channel.IChannelClient");
    if ((localIInterface != null) && ((localIInterface instanceof IChannelClient))) {
      return (IChannelClient)localIInterface;
    }
    return new IChannelClient.Stub.Proxy(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 1598968902) {
          return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        }
        paramParcel2.writeString("com.tencent.intervideo.nowproxy.proxyinner.channel.IChannelClient");
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.intervideo.nowproxy.proxyinner.channel.IChannelClient");
      paramParcel1 = a();
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.intervideo.nowproxy.proxyinner.channel.IChannelClient");
    paramInt1 = paramParcel1.readInt();
    if (paramParcel1.readInt() != 0) {
      paramParcel1 = (FromService)FromService.CREATOR.createFromParcel(paramParcel1);
    } else {
      paramParcel1 = null;
    }
    a(paramInt1, paramParcel1);
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.proxyinner.channel.IChannelClient.Stub
 * JD-Core Version:    0.7.0.1
 */