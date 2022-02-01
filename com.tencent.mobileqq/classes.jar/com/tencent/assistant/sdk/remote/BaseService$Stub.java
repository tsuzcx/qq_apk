package com.tencent.assistant.sdk.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class BaseService$Stub
  extends Binder
  implements BaseService
{
  protected static final String DESCRIPTOR = "com.tencent.assistant.sdk.remote.BaseService";
  
  public BaseService$Stub()
  {
    attachInterface(this, "com.tencent.assistant.sdk.remote.BaseService");
  }
  
  public static BaseService asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.assistant.sdk.remote.BaseService");
    if ((localIInterface != null) && ((localIInterface instanceof BaseService))) {
      return (BaseService)localIInterface;
    }
    return new BaseService.Stub.Proxy(paramIBinder);
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
        if (paramInt1 != 3)
        {
          if (paramInt1 != 4)
          {
            if (paramInt1 != 1598968902) {
              return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
            }
            paramParcel2.writeString("com.tencent.assistant.sdk.remote.BaseService");
            return true;
          }
          paramParcel1.enforceInterface("com.tencent.assistant.sdk.remote.BaseService");
          sendAsyncData(paramParcel1.readString(), paramParcel1.createByteArray());
          paramParcel2.writeNoException();
          return true;
        }
        paramParcel1.enforceInterface("com.tencent.assistant.sdk.remote.BaseService");
        paramParcel1 = sendSyncData(paramParcel1.readString(), paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        paramParcel2.writeByteArray(paramParcel1);
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.assistant.sdk.remote.BaseService");
      paramInt1 = unregisterActionCallback(SDKActionCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.assistant.sdk.remote.BaseService");
    paramInt1 = registerActionCallback(paramParcel1.readString(), paramParcel1.readString(), SDKActionCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
    paramParcel2.writeNoException();
    paramParcel2.writeInt(paramInt1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.assistant.sdk.remote.BaseService.Stub
 * JD-Core Version:    0.7.0.1
 */