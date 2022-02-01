package com.tencent.gamecenter.wadl.api;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class IWadlService$Stub
  extends Binder
  implements IWadlService
{
  public IWadlService$Stub()
  {
    attachInterface(this, "com.tencent.gamecenter.wadl.api.IWadlService");
  }
  
  public static IWadlService a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.gamecenter.wadl.api.IWadlService");
    if ((localIInterface != null) && ((localIInterface instanceof IWadlService))) {
      return (IWadlService)localIInterface;
    }
    return new IWadlService.Stub.Proxy(paramIBinder);
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
      paramParcel2.writeString("com.tencent.gamecenter.wadl.api.IWadlService");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.gamecenter.wadl.api.IWadlService");
      paramParcel2 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(paramParcel2, paramParcel1);
        return true;
      }
    case 2: 
      paramParcel1.enforceInterface("com.tencent.gamecenter.wadl.api.IWadlService");
      a(IWadlServiceCallBack.Stub.a(paramParcel1.readStrongBinder()));
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.gamecenter.wadl.api.IWadlService");
    b(IWadlServiceCallBack.Stub.a(paramParcel1.readStrongBinder()));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.api.IWadlService.Stub
 * JD-Core Version:    0.7.0.1
 */