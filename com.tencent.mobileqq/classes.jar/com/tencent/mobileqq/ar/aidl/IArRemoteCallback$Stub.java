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
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.mobileqq.ar.aidl.IArRemoteCallback");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArRemoteCallback");
      a();
      paramParcel2.writeNoException();
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArRemoteCallback");
      a(paramParcel1.readLong(), paramParcel1.readLong());
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArRemoteCallback");
      a(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArRemoteCallback");
    ArConfigInfo localArConfigInfo;
    ArEffectConfig localArEffectConfig;
    if (paramParcel1.readInt() != 0)
    {
      localArConfigInfo = (ArConfigInfo)ArConfigInfo.CREATOR.createFromParcel(paramParcel1);
      if (paramParcel1.readInt() == 0) {
        break label219;
      }
      localArEffectConfig = (ArEffectConfig)ArEffectConfig.CREATOR.createFromParcel(paramParcel1);
      label178:
      if (paramParcel1.readInt() == 0) {
        break label225;
      }
    }
    label219:
    label225:
    for (paramParcel1 = (ARCommonConfigInfo)ARCommonConfigInfo.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      a(localArConfigInfo, localArEffectConfig, paramParcel1);
      paramParcel2.writeNoException();
      return true;
      localArConfigInfo = null;
      break;
      localArEffectConfig = null;
      break label178;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.aidl.IArRemoteCallback.Stub
 * JD-Core Version:    0.7.0.1
 */