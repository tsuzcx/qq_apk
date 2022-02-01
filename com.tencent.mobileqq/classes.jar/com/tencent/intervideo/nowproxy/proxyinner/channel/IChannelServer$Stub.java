package com.tencent.intervideo.nowproxy.proxyinner.channel;

import android.os.Binder;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class IChannelServer$Stub
  extends Binder
  implements IChannelServer
{
  public IChannelServer$Stub()
  {
    attachInterface(this, "com.tencent.intervideo.nowproxy.proxyinner.channel.IChannelServer");
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.intervideo.nowproxy.proxyinner.channel.IChannelServer");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.intervideo.nowproxy.proxyinner.channel.IChannelServer");
      a(IChannelClient.Stub.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.intervideo.nowproxy.proxyinner.channel.IChannelServer");
    paramInt1 = paramParcel1.readInt();
    if (paramParcel1.readInt() != 0) {}
    for (paramParcel1 = (ToService)ToService.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      a(paramInt1, paramParcel1);
      paramParcel2.writeNoException();
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.proxyinner.channel.IChannelServer.Stub
 * JD-Core Version:    0.7.0.1
 */