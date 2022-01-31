package com.huawei.remoteLoader.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class ARBaseProxy
  implements IInterface
{
  private final String mDescriptor;
  private final IBinder mRemote;
  
  protected ARBaseProxy(IBinder paramIBinder, String paramString)
  {
    this.mRemote = paramIBinder;
    this.mDescriptor = paramString;
  }
  
  public IBinder asBinder()
  {
    return this.mRemote;
  }
  
  protected Parcel obtainAndWriteInterfaceToken()
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.writeInterfaceToken(this.mDescriptor);
    return localParcel;
  }
  
  protected Parcel transactAndReadException(int paramInt, Parcel paramParcel)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      this.mRemote.transact(paramInt, paramParcel, localParcel, 0);
      localParcel.readException();
      return localParcel;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    finally
    {
      paramParcel.recycle();
    }
  }
  
  protected void transactAndReadExceptionReturnVoid(int paramInt, Parcel paramParcel)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      this.mRemote.transact(paramInt, paramParcel, localParcel, 0);
      localParcel.readException();
      return;
    }
    finally
    {
      paramParcel.recycle();
      localParcel.recycle();
    }
  }
  
  protected void transactOneway(int paramInt, Parcel paramParcel)
  {
    try
    {
      this.mRemote.transact(paramInt, paramParcel, null, 1);
      return;
    }
    finally
    {
      paramParcel.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.huawei.remoteLoader.client.ARBaseProxy
 * JD-Core Version:    0.7.0.1
 */