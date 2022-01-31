package com.tencent.mobileqq.ar.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import zzw;

public abstract class IArConfigManager$Stub
  extends Binder
  implements IArConfigManager
{
  public IArConfigManager$Stub()
  {
    attachInterface(this, "com.tencent.mobileqq.ar.aidl.IArConfigManager");
  }
  
  public static IArConfigManager a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
    if ((localIInterface != null) && ((localIInterface instanceof IArConfigManager))) {
      return (IArConfigManager)localIInterface;
    }
    return new zzw(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    int j = 0;
    int i = 0;
    boolean bool;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.mobileqq.ar.aidl.IArConfigManager");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
      a(IArRemoteCallback.Stub.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
      b(IArRemoteCallback.Stub.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
      paramParcel1 = a();
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
      paramParcel1 = a();
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
      paramParcel1 = a();
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
      a();
      paramParcel2.writeNoException();
      return true;
    case 7: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
      b();
      paramParcel2.writeNoException();
      return true;
    case 8: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
      a(IArFaceCallback.Stub.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 9: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
      b(IArFaceCallback.Stub.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 10: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
      a(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 11: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
      bool = a();
      paramParcel2.writeNoException();
      paramInt1 = i;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 12: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (ArConfigInfo)ArConfigInfo.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 13: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
      bool = b();
      paramParcel2.writeNoException();
      paramInt1 = j;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 14: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
      c();
      paramParcel2.writeNoException();
      return true;
    case 15: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
      a(IArSoCallback.Stub.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 16: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
      b(IArSoCallback.Stub.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArConfigManager");
    b(paramParcel1.readInt());
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.aidl.IArConfigManager.Stub
 * JD-Core Version:    0.7.0.1
 */