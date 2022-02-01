package com.tencent.av.service;

import android.os.IBinder;
import android.os.Parcel;

class IQQServiceLocationCallback$Stub$Proxy
  implements IQQServiceLocationCallback
{
  private IBinder a;
  
  IQQServiceLocationCallback$Stub$Proxy(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public void a(int paramInt, String paramString)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceLocationCallback");
      localParcel.writeInt(paramInt);
      localParcel.writeString(paramString);
      this.a.transact(1, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void a(boolean paramBoolean, LBSInfo paramLBSInfo)
  {
    Parcel localParcel = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel.writeInterfaceToken("com.tencent.av.service.IQQServiceLocationCallback");
        if (paramBoolean)
        {
          i = 1;
          localParcel.writeInt(i);
          if (paramLBSInfo != null)
          {
            localParcel.writeInt(1);
            paramLBSInfo.writeToParcel(localParcel, 0);
          }
          else
          {
            localParcel.writeInt(0);
          }
          this.a.transact(2, localParcel, null, 1);
          return;
        }
      }
      finally
      {
        localParcel.recycle();
      }
      int i = 0;
    }
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.service.IQQServiceLocationCallback.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */