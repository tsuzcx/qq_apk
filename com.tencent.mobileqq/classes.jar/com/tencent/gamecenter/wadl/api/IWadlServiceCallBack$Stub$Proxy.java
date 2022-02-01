package com.tencent.gamecenter.wadl.api;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

class IWadlServiceCallBack$Stub$Proxy
  implements IWadlServiceCallBack
{
  private IBinder a;
  
  IWadlServiceCallBack$Stub$Proxy(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.gamecenter.wadl.api.IWadlServiceCallBack");
      localParcel.writeString(paramString);
      if (paramBundle != null)
      {
        localParcel.writeInt(1);
        paramBundle.writeToParcel(localParcel, 0);
      }
      else
      {
        localParcel.writeInt(0);
      }
      this.a.transact(1, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.api.IWadlServiceCallBack.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */