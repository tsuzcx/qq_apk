package com.tencent.mobileqq.ar.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class IArFaceCallback$Stub
  extends Binder
  implements IArFaceCallback
{
  public IArFaceCallback$Stub()
  {
    attachInterface(this, "com.tencent.mobileqq.ar.aidl.IArFaceCallback");
  }
  
  public static IArFaceCallback a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.ar.aidl.IArFaceCallback");
    if ((localIInterface != null) && ((localIInterface instanceof IArFaceCallback))) {
      return (IArFaceCallback)localIInterface;
    }
    return new IArFaceCallback.Stub.Proxy(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3)
        {
          if (paramInt1 != 1598968902) {
            return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
          }
          paramParcel2.writeString("com.tencent.mobileqq.ar.aidl.IArFaceCallback");
          return true;
        }
        paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArFaceCallback");
        b(paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArFaceCallback");
      a(paramParcel1.readInt(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArFaceCallback");
    a(paramParcel1.readInt());
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.aidl.IArFaceCallback.Stub
 * JD-Core Version:    0.7.0.1
 */