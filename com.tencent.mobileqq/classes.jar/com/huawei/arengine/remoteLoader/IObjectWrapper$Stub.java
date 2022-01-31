package com.huawei.arengine.remoteLoader;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class IObjectWrapper$Stub
  extends Binder
  implements IObjectWrapper
{
  private static final String DESCRIPTOR = "com.huawei.arengine.remoteLoader.IObjectWrapper";
  
  public IObjectWrapper$Stub()
  {
    attachInterface(this, "com.huawei.arengine.remoteLoader.IObjectWrapper");
  }
  
  public static IObjectWrapper asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.huawei.arengine.remoteLoader.IObjectWrapper");
    if ((localIInterface != null) && ((localIInterface instanceof IObjectWrapper))) {
      return (IObjectWrapper)localIInterface;
    }
    return new IObjectWrapper.Stub.a(paramIBinder);
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
    }
    paramParcel2.writeString("com.huawei.arengine.remoteLoader.IObjectWrapper");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.huawei.arengine.remoteLoader.IObjectWrapper.Stub
 * JD-Core Version:    0.7.0.1
 */