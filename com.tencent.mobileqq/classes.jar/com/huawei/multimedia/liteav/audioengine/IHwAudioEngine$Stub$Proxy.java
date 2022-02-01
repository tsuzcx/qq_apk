package com.huawei.multimedia.liteav.audioengine;

import android.os.IBinder;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;

class IHwAudioEngine$Stub$Proxy
  implements IHwAudioEngine
{
  private IBinder mRemote;
  
  IHwAudioEngine$Stub$Proxy(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public String getInterfaceDescriptor()
  {
    return "com.huawei.multimedia.audioengine.IHwAudioEngine";
  }
  
  public List getSupportedFeatures()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.huawei.multimedia.audioengine.IHwAudioEngine");
      this.mRemote.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      ArrayList localArrayList = localParcel2.readArrayList(getClass().getClassLoader());
      return localArrayList;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void init(String paramString1, String paramString2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.huawei.multimedia.audioengine.IHwAudioEngine");
      localParcel1.writeString(paramString1);
      localParcel1.writeString(paramString2);
      this.mRemote.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public boolean isFeatureSupported(int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.huawei.multimedia.audioengine.IHwAudioEngine");
      localParcel1.writeInt(paramInt);
      IBinder localIBinder = this.mRemote;
      boolean bool = false;
      localIBinder.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramInt = localParcel2.readInt();
      if (paramInt != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.multimedia.liteav.audioengine.IHwAudioEngine.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */