package com.tencent.assistant.sdk.remote;

import android.os.IBinder;
import android.os.Parcel;

class BaseService$Stub$Proxy
  implements BaseService
{
  private IBinder mRemote;
  
  BaseService$Stub$Proxy(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public String getInterfaceDescriptor()
  {
    return "com.tencent.assistant.sdk.remote.BaseService";
  }
  
  public int registerActionCallback(String paramString1, String paramString2, SDKActionCallback paramSDKActionCallback)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.assistant.sdk.remote.BaseService");
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        if (paramSDKActionCallback != null)
        {
          paramString1 = paramSDKActionCallback.asBinder();
          localParcel1.writeStrongBinder(paramString1);
          this.mRemote.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      paramString1 = null;
    }
  }
  
  public void sendAsyncData(String paramString, byte[] paramArrayOfByte)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.assistant.sdk.remote.BaseService");
      localParcel1.writeString(paramString);
      localParcel1.writeByteArray(paramArrayOfByte);
      this.mRemote.transact(4, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public byte[] sendSyncData(String paramString, byte[] paramArrayOfByte)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.assistant.sdk.remote.BaseService");
      localParcel1.writeString(paramString);
      localParcel1.writeByteArray(paramArrayOfByte);
      this.mRemote.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramString = localParcel2.createByteArray();
      return paramString;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public int unregisterActionCallback(SDKActionCallback paramSDKActionCallback)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.assistant.sdk.remote.BaseService");
        if (paramSDKActionCallback != null)
        {
          paramSDKActionCallback = paramSDKActionCallback.asBinder();
          localParcel1.writeStrongBinder(paramSDKActionCallback);
          this.mRemote.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      paramSDKActionCallback = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.assistant.sdk.remote.BaseService.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */