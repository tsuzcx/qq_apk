package com.ihoc.mgpa.dataforwardsdk;

import android.os.IBinder;
import android.os.Parcel;

class IDataForward$Stub$Proxy
  implements IDataForward
{
  private IBinder a;
  
  IDataForward$Stub$Proxy(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public void a(ICallBack paramICallBack)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.ihoc.mgpa.dataforwardsdk.IDataForward");
        if (paramICallBack != null)
        {
          paramICallBack = paramICallBack.asBinder();
          localParcel1.writeStrongBinder(paramICallBack);
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
      paramICallBack = null;
    }
  }
  
  public void a(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.ihoc.mgpa.dataforwardsdk.IDataForward");
      localParcel1.writeString(paramString);
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
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.ihoc.mgpa.dataforwardsdk.IDataForward.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */