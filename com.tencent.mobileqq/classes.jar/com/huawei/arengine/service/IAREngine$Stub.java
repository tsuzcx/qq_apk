package com.huawei.arengine.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;

public abstract class IAREngine$Stub
  extends Binder
  implements IAREngine
{
  private static final String DESCRIPTOR = "com.huawei.arengine.service.IAREngine";
  static final int TRANSACTION_getMetaData = 3;
  static final int TRANSACTION_getSharedFile = 4;
  static final int TRANSACTION_getVersionCode = 2;
  static final int TRANSACTION_getVersionName = 1;
  
  public IAREngine$Stub()
  {
    attachInterface(this, "com.huawei.arengine.service.IAREngine");
  }
  
  public static IAREngine asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.huawei.arengine.service.IAREngine");
    if ((localIInterface != null) && ((localIInterface instanceof IAREngine))) {
      return (IAREngine)localIInterface;
    }
    return new IAREngine.Stub.a(paramIBinder);
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
      paramParcel2.writeString("com.huawei.arengine.service.IAREngine");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.huawei.arengine.service.IAREngine");
      paramParcel1 = getVersionName();
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.huawei.arengine.service.IAREngine");
      paramInt1 = getVersionCode();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.huawei.arengine.service.IAREngine");
      paramParcel1 = getMetaData();
      paramParcel2.writeNoException();
      paramParcel2.writeIntArray(paramParcel1);
      return true;
    }
    paramParcel1.enforceInterface("com.huawei.arengine.service.IAREngine");
    paramParcel1 = getSharedFile(paramParcel1.readString());
    paramParcel2.writeNoException();
    if (paramParcel1 != null)
    {
      paramParcel2.writeInt(1);
      paramParcel1.writeToParcel(paramParcel2, 1);
      return true;
    }
    paramParcel2.writeInt(0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.huawei.arengine.service.IAREngine.Stub
 * JD-Core Version:    0.7.0.1
 */