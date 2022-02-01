package com.huawei.hms.core.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class c$a
  extends Binder
  implements c
{
  public c$a()
  {
    attachInterface(this, "com.huawei.hms.core.aidl.IAIDLCallback");
  }
  
  public static c asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.huawei.hms.core.aidl.IAIDLCallback");
    if ((localIInterface != null) && ((localIInterface instanceof c))) {
      return (c)localIInterface;
    }
    return new c.a.a(paramIBinder);
  }
  
  public static c getDefaultImpl()
  {
    return c.a.a.b;
  }
  
  public static boolean setDefaultImpl(c paramc)
  {
    if ((c.a.a.b == null) && (paramc != null))
    {
      c.a.a.b = paramc;
      return true;
    }
    return false;
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
      paramParcel2.writeString("com.huawei.hms.core.aidl.IAIDLCallback");
      return true;
    }
    paramParcel1.enforceInterface("com.huawei.hms.core.aidl.IAIDLCallback");
    if (paramParcel1.readInt() != 0) {
      paramParcel1 = (b)b.CREATOR.createFromParcel(paramParcel1);
    } else {
      paramParcel1 = null;
    }
    call(paramParcel1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.core.aidl.c.a
 * JD-Core Version:    0.7.0.1
 */