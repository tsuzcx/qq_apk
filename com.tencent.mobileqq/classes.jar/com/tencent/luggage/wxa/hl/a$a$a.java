package com.tencent.luggage.wxa.hl;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;

class a$a$a
  implements a
{
  private IBinder a;
  
  a$a$a(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public Bundle a(Bundle paramBundle, String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeBridge");
      if (paramBundle != null)
      {
        localParcel1.writeInt(1);
        paramBundle.writeToParcel(localParcel1, 0);
      }
      else
      {
        localParcel1.writeInt(0);
      }
      localParcel1.writeString(paramString);
      this.a.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      if (localParcel2.readInt() != 0) {
        paramBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
      } else {
        paramBundle = null;
      }
      return paramBundle;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void a(Bundle paramBundle, String paramString, b paramb)
  {
    Parcel localParcel = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel.writeInterfaceToken("com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeBridge");
        if (paramBundle != null)
        {
          localParcel.writeInt(1);
          paramBundle.writeToParcel(localParcel, 0);
        }
        else
        {
          localParcel.writeInt(0);
        }
        localParcel.writeString(paramString);
        if (paramb != null)
        {
          paramBundle = paramb.asBinder();
          localParcel.writeStrongBinder(paramBundle);
          this.a.transact(1, localParcel, null, 1);
          return;
        }
      }
      finally
      {
        localParcel.recycle();
      }
      paramBundle = null;
    }
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hl.a.a.a
 * JD-Core Version:    0.7.0.1
 */