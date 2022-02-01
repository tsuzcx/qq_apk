package com.ihoc.mgpa.dataforwardsdk;

import android.os.IBinder;
import android.os.Parcel;

class ICallBack$Stub$Proxy
  implements ICallBack
{
  private IBinder a;
  
  ICallBack$Stub$Proxy(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public void a(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.ihoc.mgpa.dataforwardsdk.ICallBack");
      localParcel1.writeString(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.ihoc.mgpa.dataforwardsdk.ICallBack.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */