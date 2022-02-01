package com.tencent.av.gvideo;

import android.app.Notification;
import android.os.IBinder;
import android.os.Parcel;
import com.tencent.av.service.IAVServiceCallback;

class IGVServiceForQQ$Stub$Proxy
  implements IGVServiceForQQ
{
  private IBinder a;
  
  IGVServiceForQQ$Stub$Proxy(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public int a(long paramLong, int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.av.gvideo.IGVServiceForQQ");
      localParcel1.writeLong(paramLong);
      localParcel1.writeInt(paramInt);
      this.a.transact(4, localParcel1, localParcel2, 0);
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
  
  public void a()
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.av.gvideo.IGVServiceForQQ");
      this.a.transact(5, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void a(IAVServiceCallback paramIAVServiceCallback)
  {
    Parcel localParcel = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel.writeInterfaceToken("com.tencent.av.gvideo.IGVServiceForQQ");
        if (paramIAVServiceCallback != null)
        {
          paramIAVServiceCallback = paramIAVServiceCallback.asBinder();
          localParcel.writeStrongBinder(paramIAVServiceCallback);
          this.a.transact(1, localParcel, null, 1);
          return;
        }
      }
      finally
      {
        localParcel.recycle();
      }
      paramIAVServiceCallback = null;
    }
  }
  
  public void a(boolean paramBoolean, Notification paramNotification)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.av.gvideo.IGVServiceForQQ");
        if (paramBoolean)
        {
          i = 1;
          localParcel1.writeInt(i);
          if (paramNotification != null)
          {
            localParcel1.writeInt(1);
            paramNotification.writeToParcel(localParcel1, 0);
          }
          else
          {
            localParcel1.writeInt(0);
          }
          this.a.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
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
  
  public void a(byte[] paramArrayOfByte)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.tencent.av.gvideo.IGVServiceForQQ");
      localParcel.writeByteArray(paramArrayOfByte);
      this.a.transact(2, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gvideo.IGVServiceForQQ.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */