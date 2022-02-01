package android.support.v4.app;

import android.app.Notification;
import android.os.IBinder;
import android.os.Parcel;

class INotificationSideChannel$Stub$Proxy
  implements INotificationSideChannel
{
  public static INotificationSideChannel sDefaultImpl;
  private IBinder mRemote;
  
  INotificationSideChannel$Stub$Proxy(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public void cancel(String paramString1, int paramInt, String paramString2)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
      localParcel.writeString(paramString1);
      localParcel.writeInt(paramInt);
      localParcel.writeString(paramString2);
      if ((!this.mRemote.transact(2, localParcel, null, 1)) && (INotificationSideChannel.Stub.getDefaultImpl() != null))
      {
        INotificationSideChannel.Stub.getDefaultImpl().cancel(paramString1, paramInt, paramString2);
        return;
      }
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void cancelAll(String paramString)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
      localParcel.writeString(paramString);
      if ((!this.mRemote.transact(3, localParcel, null, 1)) && (INotificationSideChannel.Stub.getDefaultImpl() != null))
      {
        INotificationSideChannel.Stub.getDefaultImpl().cancelAll(paramString);
        return;
      }
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public String getInterfaceDescriptor()
  {
    return "android.support.v4.app.INotificationSideChannel";
  }
  
  public void notify(String paramString1, int paramInt, String paramString2, Notification paramNotification)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
      localParcel.writeString(paramString1);
      localParcel.writeInt(paramInt);
      localParcel.writeString(paramString2);
      if (paramNotification != null)
      {
        localParcel.writeInt(1);
        paramNotification.writeToParcel(localParcel, 0);
      }
      else
      {
        localParcel.writeInt(0);
      }
      if ((!this.mRemote.transact(1, localParcel, null, 1)) && (INotificationSideChannel.Stub.getDefaultImpl() != null))
      {
        INotificationSideChannel.Stub.getDefaultImpl().notify(paramString1, paramInt, paramString2, paramNotification);
        return;
      }
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.app.INotificationSideChannel.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */