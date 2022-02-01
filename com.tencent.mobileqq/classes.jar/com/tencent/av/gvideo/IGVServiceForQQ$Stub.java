package com.tencent.av.gvideo;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.av.service.IAVServiceCallback.Stub;

public abstract class IGVServiceForQQ$Stub
  extends Binder
  implements IGVServiceForQQ
{
  public IGVServiceForQQ$Stub()
  {
    attachInterface(this, "com.tencent.av.gvideo.IGVServiceForQQ");
  }
  
  public static IGVServiceForQQ a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.av.gvideo.IGVServiceForQQ");
    if ((localIInterface != null) && ((localIInterface instanceof IGVServiceForQQ))) {
      return (IGVServiceForQQ)localIInterface;
    }
    return new IGVServiceForQQ.Stub.Proxy(paramIBinder);
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
            if (paramInt1 != 5)
            {
              if (paramInt1 != 1598968902) {
                return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
              }
              paramParcel2.writeString("com.tencent.av.gvideo.IGVServiceForQQ");
              return true;
            }
            paramParcel1.enforceInterface("com.tencent.av.gvideo.IGVServiceForQQ");
            a();
            return true;
          }
          paramParcel1.enforceInterface("com.tencent.av.gvideo.IGVServiceForQQ");
          paramInt1 = a(paramParcel1.readLong(), paramParcel1.readInt());
          paramParcel2.writeNoException();
          paramParcel2.writeInt(paramInt1);
          return true;
        }
        paramParcel1.enforceInterface("com.tencent.av.gvideo.IGVServiceForQQ");
        boolean bool;
        if (paramParcel1.readInt() != 0) {
          bool = true;
        } else {
          bool = false;
        }
        if (paramParcel1.readInt() != 0) {
          paramParcel1 = (Notification)Notification.CREATOR.createFromParcel(paramParcel1);
        } else {
          paramParcel1 = null;
        }
        a(bool, paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.av.gvideo.IGVServiceForQQ");
      a(paramParcel1.createByteArray());
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.av.gvideo.IGVServiceForQQ");
    a(IAVServiceCallback.Stub.a(paramParcel1.readStrongBinder()));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gvideo.IGVServiceForQQ.Stub
 * JD-Core Version:    0.7.0.1
 */