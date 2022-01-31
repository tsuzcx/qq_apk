package com.huawei.arengine.remoteLoader;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class ILoaderProducer$Stub
  extends Binder
  implements ILoaderProducer
{
  private static final String DESCRIPTOR = "com.huawei.arengine.remoteLoader.ILoaderProducer";
  static final int TRANSACTION_newDynamicLoader = 1;
  
  public ILoaderProducer$Stub()
  {
    attachInterface(this, "com.huawei.arengine.remoteLoader.ILoaderProducer");
  }
  
  public static ILoaderProducer asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.huawei.arengine.remoteLoader.ILoaderProducer");
    if ((localIInterface != null) && ((localIInterface instanceof ILoaderProducer))) {
      return (ILoaderProducer)localIInterface;
    }
    return new ILoaderProducer.Stub.a(paramIBinder);
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
      paramParcel2.writeString("com.huawei.arengine.remoteLoader.ILoaderProducer");
      return true;
    }
    paramParcel1.enforceInterface("com.huawei.arengine.remoteLoader.ILoaderProducer");
    paramParcel1 = newDynamicLoader(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
    paramParcel2.writeNoException();
    if (paramParcel1 != null) {}
    for (paramParcel1 = paramParcel1.asBinder();; paramParcel1 = null)
    {
      paramParcel2.writeStrongBinder(paramParcel1);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.huawei.arengine.remoteLoader.ILoaderProducer.Stub
 * JD-Core Version:    0.7.0.1
 */