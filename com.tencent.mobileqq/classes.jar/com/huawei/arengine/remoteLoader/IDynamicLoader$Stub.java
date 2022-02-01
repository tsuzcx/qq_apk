package com.huawei.arengine.remoteLoader;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class IDynamicLoader$Stub
  extends Binder
  implements IDynamicLoader
{
  private static final String DESCRIPTOR = "com.huawei.arengine.remoteLoader.IDynamicLoader";
  static final int TRANSACTION_checkUpdate = 3;
  static final int TRANSACTION_closeLibrary = 2;
  static final int TRANSACTION_openLibrary = 1;
  static final int TRANSACTION_updateResourceFromRemote = 4;
  
  public IDynamicLoader$Stub()
  {
    attachInterface(this, "com.huawei.arengine.remoteLoader.IDynamicLoader");
  }
  
  public static IDynamicLoader asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.huawei.arengine.remoteLoader.IDynamicLoader");
    if ((localIInterface != null) && ((localIInterface instanceof IDynamicLoader))) {
      return (IDynamicLoader)localIInterface;
    }
    return new IDynamicLoader.Stub.a(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    int j = 0;
    int i = 0;
    long l;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.huawei.arengine.remoteLoader.IDynamicLoader");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.huawei.arengine.remoteLoader.IDynamicLoader");
      l = openLibrary(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeLong(l);
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.huawei.arengine.remoteLoader.IDynamicLoader");
      closeLibrary(paramParcel1.readLong());
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.huawei.arengine.remoteLoader.IDynamicLoader");
      l = paramParcel1.readLong();
      if (paramParcel1.readInt() != 0) {}
      for (bool = true;; bool = false)
      {
        bool = checkUpdate(l, bool);
        paramParcel2.writeNoException();
        paramInt1 = i;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      }
    }
    paramParcel1.enforceInterface("com.huawei.arengine.remoteLoader.IDynamicLoader");
    boolean bool = updateResourceFromRemote(paramParcel1.readString(), paramParcel1.readString());
    paramParcel2.writeNoException();
    paramInt1 = j;
    if (bool) {
      paramInt1 = 1;
    }
    paramParcel2.writeInt(paramInt1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.arengine.remoteLoader.IDynamicLoader.Stub
 * JD-Core Version:    0.7.0.1
 */