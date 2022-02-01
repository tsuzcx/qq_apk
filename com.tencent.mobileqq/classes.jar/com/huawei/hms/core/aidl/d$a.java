package com.huawei.hms.core.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class d$a
  extends Binder
  implements d
{
  public static d a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.huawei.hms.core.aidl.IAIDLInvoke");
    if ((localIInterface != null) && ((localIInterface instanceof d))) {
      return (d)localIInterface;
    }
    return new d.a.a(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject = null;
    b localb = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.huawei.hms.core.aidl.IAIDLInvoke");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.huawei.hms.core.aidl.IAIDLInvoke");
      if (paramParcel1.readInt() != 0) {
        localb = (b)b.CREATOR.createFromParcel(paramParcel1);
      }
      a(localb);
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.huawei.hms.core.aidl.IAIDLInvoke");
    paramParcel2 = localObject;
    if (paramParcel1.readInt() != 0) {
      paramParcel2 = (b)b.CREATOR.createFromParcel(paramParcel1);
    }
    a(paramParcel2, c.a.asInterface(paramParcel1.readStrongBinder()));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.core.aidl.d.a
 * JD-Core Version:    0.7.0.1
 */