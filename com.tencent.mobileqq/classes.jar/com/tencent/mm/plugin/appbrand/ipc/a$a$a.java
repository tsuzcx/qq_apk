package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

class a$a$a
  implements a
{
  private IBinder a;
  
  a$a$a(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public void a(Bundle paramBundle)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
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
  
  public void a(IBinder paramIBinder, String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
      localParcel1.writeStrongBinder(paramIBinder);
      localParcel1.writeString(paramString);
      this.a.transact(3, localParcel1, localParcel2, 0);
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
  
  public void b(Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
      if (paramBundle != null)
      {
        localParcel1.writeInt(1);
        paramBundle.writeToParcel(localParcel1, 0);
      }
      else
      {
        localParcel1.writeInt(0);
      }
      this.a.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0) {
        paramBundle.readFromParcel(localParcel2);
      }
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.a.a.a
 * JD-Core Version:    0.7.0.1
 */