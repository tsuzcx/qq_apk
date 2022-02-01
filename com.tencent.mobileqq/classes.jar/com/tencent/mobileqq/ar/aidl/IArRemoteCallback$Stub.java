package com.tencent.mobileqq.ar.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class IArRemoteCallback$Stub
  extends Binder
  implements IArRemoteCallback
{
  public IArRemoteCallback$Stub()
  {
    attachInterface(this, "com.tencent.mobileqq.ar.aidl.IArRemoteCallback");
  }
  
  public static IArRemoteCallback a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.ar.aidl.IArRemoteCallback");
    if ((localIInterface != null) && ((localIInterface instanceof IArRemoteCallback))) {
      return (IArRemoteCallback)localIInterface;
    }
    return new IArRemoteCallback.Stub.Proxy(paramIBinder);
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
          if (paramInt1 != 4)
          {
            if (paramInt1 != 1598968902) {
              return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
            }
            paramParcel2.writeString("com.tencent.mobileqq.ar.aidl.IArRemoteCallback");
            return true;
          }
          paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArRemoteCallback");
          paramInt1 = paramParcel1.readInt();
          ARCommonConfigInfo localARCommonConfigInfo = null;
          ArConfigInfo localArConfigInfo;
          if (paramInt1 != 0) {
            localArConfigInfo = (ArConfigInfo)ArConfigInfo.CREATOR.createFromParcel(paramParcel1);
          } else {
            localArConfigInfo = null;
          }
          ArEffectConfig localArEffectConfig;
          if (paramParcel1.readInt() != 0) {
            localArEffectConfig = (ArEffectConfig)ArEffectConfig.CREATOR.createFromParcel(paramParcel1);
          } else {
            localArEffectConfig = null;
          }
          if (paramParcel1.readInt() != 0) {
            localARCommonConfigInfo = (ARCommonConfigInfo)ARCommonConfigInfo.CREATOR.createFromParcel(paramParcel1);
          }
          a(localArConfigInfo, localArEffectConfig, localARCommonConfigInfo);
          paramParcel2.writeNoException();
          return true;
        }
        paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArRemoteCallback");
        a(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArRemoteCallback");
      a(paramParcel1.readLong(), paramParcel1.readLong());
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArRemoteCallback");
    a();
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.aidl.IArRemoteCallback.Stub
 * JD-Core Version:    0.7.0.1
 */