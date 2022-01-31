package com.tencent.av.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import jot;

public abstract class IAVRedPacketCallback$Stub
  extends Binder
  implements IAVRedPacketCallback
{
  public IAVRedPacketCallback$Stub()
  {
    attachInterface(this, "com.tencent.av.service.IAVRedPacketCallback");
  }
  
  public static IAVRedPacketCallback a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.av.service.IAVRedPacketCallback");
    if ((localIInterface != null) && ((localIInterface instanceof IAVRedPacketCallback))) {
      return (IAVRedPacketCallback)localIInterface;
    }
    return new jot(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    boolean bool = false;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.av.service.IAVRedPacketCallback");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.av.service.IAVRedPacketCallback");
      if (paramParcel1.readInt() != 0)
      {
        bool = true;
        if (paramParcel1.readInt() == 0) {
          break label109;
        }
      }
      label109:
      for (paramParcel1 = (AVRedPacketConfig)AVRedPacketConfig.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(bool, paramParcel1);
        return true;
        bool = false;
        break;
      }
    }
    paramParcel1.enforceInterface("com.tencent.av.service.IAVRedPacketCallback");
    if (paramParcel1.readInt() != 0) {
      bool = true;
    }
    a(bool, paramParcel1.readString(), paramParcel1.readString());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.service.IAVRedPacketCallback.Stub
 * JD-Core Version:    0.7.0.1
 */