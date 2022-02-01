package com.ihoc.mgpa.dataforwardsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class ICallBack$Stub
  extends Binder
  implements ICallBack
{
  public ICallBack$Stub()
  {
    attachInterface(this, "com.ihoc.mgpa.dataforwardsdk.ICallBack");
  }
  
  public static ICallBack a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.ihoc.mgpa.dataforwardsdk.ICallBack");
    if ((localIInterface != null) && ((localIInterface instanceof ICallBack))) {
      return (ICallBack)localIInterface;
    }
    return new ICallBack.Stub.Proxy(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 1598968902) {
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      }
      paramParcel2.writeString("com.ihoc.mgpa.dataforwardsdk.ICallBack");
      return true;
    }
    paramParcel1.enforceInterface("com.ihoc.mgpa.dataforwardsdk.ICallBack");
    a(paramParcel1.readString());
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.ihoc.mgpa.dataforwardsdk.ICallBack.Stub
 * JD-Core Version:    0.7.0.1
 */