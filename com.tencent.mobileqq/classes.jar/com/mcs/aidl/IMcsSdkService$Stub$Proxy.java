package com.mcs.aidl;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

class IMcsSdkService$Stub$Proxy
  implements IMcsSdkService
{
  public static IMcsSdkService a;
  private IBinder b;
  
  IMcsSdkService$Stub$Proxy(IBinder paramIBinder)
  {
    this.b = paramIBinder;
  }
  
  public void a(Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.mcs.aidl.IMcsSdkService");
      if (paramBundle != null)
      {
        localParcel1.writeInt(1);
        paramBundle.writeToParcel(localParcel1, 0);
      }
      else
      {
        localParcel1.writeInt(0);
      }
      if ((!this.b.transact(1, localParcel1, localParcel2, 0)) && (IMcsSdkService.Stub.a() != null))
      {
        IMcsSdkService.Stub.a().a(paramBundle);
        return;
      }
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
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.mcs.aidl.IMcsSdkService.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */