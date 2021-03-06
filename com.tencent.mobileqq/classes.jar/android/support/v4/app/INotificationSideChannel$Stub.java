package android.support.v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class INotificationSideChannel$Stub
  extends Binder
  implements INotificationSideChannel
{
  private static final String DESCRIPTOR = "android.support.v4.app.INotificationSideChannel";
  static final int TRANSACTION_cancel = 2;
  static final int TRANSACTION_cancelAll = 3;
  static final int TRANSACTION_notify = 1;
  
  public INotificationSideChannel$Stub()
  {
    attachInterface(this, "android.support.v4.app.INotificationSideChannel");
  }
  
  public static INotificationSideChannel asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("android.support.v4.app.INotificationSideChannel");
    if ((localIInterface != null) && ((localIInterface instanceof INotificationSideChannel))) {
      return (INotificationSideChannel)localIInterface;
    }
    return new INotificationSideChannel.Stub.Proxy(paramIBinder);
  }
  
  public static INotificationSideChannel getDefaultImpl()
  {
    return INotificationSideChannel.Stub.Proxy.sDefaultImpl;
  }
  
  public static boolean setDefaultImpl(INotificationSideChannel paramINotificationSideChannel)
  {
    if ((INotificationSideChannel.Stub.Proxy.sDefaultImpl == null) && (paramINotificationSideChannel != null))
    {
      INotificationSideChannel.Stub.Proxy.sDefaultImpl = paramINotificationSideChannel;
      return true;
    }
    return false;
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
          if (paramInt1 != 1598968902) {
            return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
          }
          paramParcel2.writeString("android.support.v4.app.INotificationSideChannel");
          return true;
        }
        paramParcel1.enforceInterface("android.support.v4.app.INotificationSideChannel");
        cancelAll(paramParcel1.readString());
        return true;
      }
      paramParcel1.enforceInterface("android.support.v4.app.INotificationSideChannel");
      cancel(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readString());
      return true;
    }
    paramParcel1.enforceInterface("android.support.v4.app.INotificationSideChannel");
    paramParcel2 = paramParcel1.readString();
    paramInt1 = paramParcel1.readInt();
    String str = paramParcel1.readString();
    if (paramParcel1.readInt() != 0) {
      paramParcel1 = (Notification)Notification.CREATOR.createFromParcel(paramParcel1);
    } else {
      paramParcel1 = null;
    }
    notify(paramParcel2, paramInt1, str, paramParcel1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.app.INotificationSideChannel.Stub
 * JD-Core Version:    0.7.0.1
 */