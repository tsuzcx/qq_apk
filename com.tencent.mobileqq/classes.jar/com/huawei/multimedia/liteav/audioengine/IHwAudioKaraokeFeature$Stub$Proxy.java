package com.huawei.multimedia.liteav.audioengine;

import android.os.IBinder;
import android.os.Parcel;

class IHwAudioKaraokeFeature$Stub$Proxy
  implements IHwAudioKaraokeFeature
{
  private IBinder mRemote;
  
  IHwAudioKaraokeFeature$Stub$Proxy(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public int enableKaraokeFeature(boolean paramBoolean)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
        if (paramBoolean)
        {
          i = 1;
          localParcel1.writeInt(i);
          this.mRemote.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          i = localParcel2.readInt();
          return i;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      int i = 0;
    }
  }
  
  public String getInterfaceDescriptor()
  {
    return "com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature";
  }
  
  public int getKaraokeLatency()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
      this.mRemote.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void init(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
      localParcel1.writeString(paramString);
      this.mRemote.transact(5, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public boolean isKaraokeFeatureSupport()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
      IBinder localIBinder = this.mRemote;
      boolean bool = false;
      localIBinder.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0) {
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
  
  public int setParameter(String paramString, int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
      localParcel1.writeString(paramString);
      localParcel1.writeInt(paramInt);
      this.mRemote.transact(4, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramInt = localParcel2.readInt();
      return paramInt;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.multimedia.liteav.audioengine.IHwAudioKaraokeFeature.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */