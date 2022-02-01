package com.ihoc.mgpa.dataforwardsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class IDataForward$Stub
  extends Binder
  implements IDataForward
{
  public IDataForward$Stub()
  {
    attachInterface(this, "com.ihoc.mgpa.dataforwardsdk.IDataForward");
  }
  
  public static IDataForward a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.ihoc.mgpa.dataforwardsdk.IDataForward");
    if ((localIInterface != null) && ((localIInterface instanceof IDataForward))) {
      return (IDataForward)localIInterface;
    }
    return new IDataForward.Stub.Proxy(paramIBinder);
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
        if (paramInt1 != 1598968902) {
          return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        }
        paramParcel2.writeString("com.ihoc.mgpa.dataforwardsdk.IDataForward");
        return true;
      }
      paramParcel1.enforceInterface("com.ihoc.mgpa.dataforwardsdk.IDataForward");
      a(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.ihoc.mgpa.dataforwardsdk.IDataForward");
    a(ICallBack.Stub.a(paramParcel1.readStrongBinder()));
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.ihoc.mgpa.dataforwardsdk.IDataForward.Stub
 * JD-Core Version:    0.7.0.1
 */