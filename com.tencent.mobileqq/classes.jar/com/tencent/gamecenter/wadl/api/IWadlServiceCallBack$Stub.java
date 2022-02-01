package com.tencent.gamecenter.wadl.api;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class IWadlServiceCallBack$Stub
  extends Binder
  implements IWadlServiceCallBack
{
  public IWadlServiceCallBack$Stub()
  {
    attachInterface(this, "com.tencent.gamecenter.wadl.api.IWadlServiceCallBack");
  }
  
  public static IWadlServiceCallBack a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.gamecenter.wadl.api.IWadlServiceCallBack");
    if ((localIInterface != null) && ((localIInterface instanceof IWadlServiceCallBack))) {
      return (IWadlServiceCallBack)localIInterface;
    }
    return new IWadlServiceCallBack.Stub.Proxy(paramIBinder);
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
      paramParcel2.writeString("com.tencent.gamecenter.wadl.api.IWadlServiceCallBack");
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.gamecenter.wadl.api.IWadlServiceCallBack");
    paramParcel2 = paramParcel1.readString();
    if (paramParcel1.readInt() != 0) {
      paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
    } else {
      paramParcel1 = null;
    }
    a(paramParcel2, paramParcel1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.api.IWadlServiceCallBack.Stub
 * JD-Core Version:    0.7.0.1
 */