package com.mcs.aidl;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class IMcsSdkService$Stub
  extends Binder
  implements IMcsSdkService
{
  public IMcsSdkService$Stub()
  {
    attachInterface(this, "com.mcs.aidl.IMcsSdkService");
  }
  
  public static IMcsSdkService a()
  {
    return IMcsSdkService.Stub.Proxy.a;
  }
  
  public static IMcsSdkService a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.mcs.aidl.IMcsSdkService");
    if ((localIInterface != null) && ((localIInterface instanceof IMcsSdkService))) {
      return (IMcsSdkService)localIInterface;
    }
    return new IMcsSdkService.Stub.Proxy(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 1598968902) {
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      }
      paramParcel2.writeString("com.mcs.aidl.IMcsSdkService");
      return true;
    }
    paramParcel1.enforceInterface("com.mcs.aidl.IMcsSdkService");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.mcs.aidl.IMcsSdkService.Stub
 * JD-Core Version:    0.7.0.1
 */