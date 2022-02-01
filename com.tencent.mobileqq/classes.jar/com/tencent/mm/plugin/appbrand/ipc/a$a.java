package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class a$a
  extends Binder
  implements a
{
  public a$a()
  {
    attachInterface(this, "com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
  }
  
  public static a a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
    if ((localIInterface != null) && ((localIInterface instanceof a))) {
      return (a)localIInterface;
    }
    return new a.a.a(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject = null;
    Bundle localBundle = null;
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3)
        {
          if (paramInt1 != 1598968902) {
            return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
          }
          paramParcel2.writeString("com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
          return true;
        }
        paramParcel1.enforceInterface("com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
        a(paramParcel1.readStrongBinder(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
      if (paramParcel1.readInt() != 0) {
        localBundle = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      b(localBundle);
      paramParcel2.writeNoException();
      if (localBundle != null)
      {
        paramParcel2.writeInt(1);
        localBundle.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
    paramParcel2 = localObject;
    if (paramParcel1.readInt() != 0) {
      paramParcel2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
    }
    a(paramParcel2);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.a.a
 * JD-Core Version:    0.7.0.1
 */