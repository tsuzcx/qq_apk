package com.tencent.luggage.wxa.hl;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class b$a
  extends Binder
  implements b
{
  public b$a()
  {
    attachInterface(this, "com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeCallback");
  }
  
  public static b a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeCallback");
    if ((localIInterface != null) && ((localIInterface instanceof b))) {
      return (b)localIInterface;
    }
    return new b.a.a(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 1598968902) {
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      }
      paramParcel2.writeString("com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeCallback");
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeCallback");
    if (paramParcel1.readInt() != 0) {
      paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
    } else {
      paramParcel1 = null;
    }
    a(paramParcel1);
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hl.b.a
 * JD-Core Version:    0.7.0.1
 */