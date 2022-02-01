package com.tencent.gamecenter.wadl.api;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

class IWadlService$Stub$Proxy
  implements IWadlService
{
  private IBinder a;
  
  IWadlService$Stub$Proxy(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public void a(IWadlServiceCallBack paramIWadlServiceCallBack)
  {
    Parcel localParcel = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel.writeInterfaceToken("com.tencent.gamecenter.wadl.api.IWadlService");
        if (paramIWadlServiceCallBack != null)
        {
          paramIWadlServiceCallBack = paramIWadlServiceCallBack.asBinder();
          localParcel.writeStrongBinder(paramIWadlServiceCallBack);
          this.a.transact(2, localParcel, null, 1);
          return;
        }
      }
      finally
      {
        localParcel.recycle();
      }
      paramIWadlServiceCallBack = null;
    }
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.gamecenter.wadl.api.IWadlService");
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
  
  public void b(IWadlServiceCallBack paramIWadlServiceCallBack)
  {
    Parcel localParcel = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel.writeInterfaceToken("com.tencent.gamecenter.wadl.api.IWadlService");
        if (paramIWadlServiceCallBack != null)
        {
          paramIWadlServiceCallBack = paramIWadlServiceCallBack.asBinder();
          localParcel.writeStrongBinder(paramIWadlServiceCallBack);
          this.a.transact(3, localParcel, null, 1);
          return;
        }
      }
      finally
      {
        localParcel.recycle();
      }
      paramIWadlServiceCallBack = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.api.IWadlService.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */