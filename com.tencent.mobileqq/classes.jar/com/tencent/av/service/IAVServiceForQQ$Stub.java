package com.tencent.av.service;

import android.app.Notification;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class IAVServiceForQQ$Stub
  extends Binder
  implements IAVServiceForQQ
{
  public IAVServiceForQQ$Stub()
  {
    attachInterface(this, "com.tencent.av.service.IAVServiceForQQ");
  }
  
  public static IAVServiceForQQ a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.av.service.IAVServiceForQQ");
    if ((localIInterface != null) && ((localIInterface instanceof IAVServiceForQQ))) {
      return (IAVServiceForQQ)localIInterface;
    }
    return new IAVServiceForQQ.Stub.Proxy(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    if (paramInt1 != 1598968902)
    {
      String str = null;
      Object localObject = null;
      boolean bool2 = false;
      boolean bool1 = false;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 15: 
        paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
        c();
        paramParcel2.writeNoException();
        return true;
      case 14: 
        paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
        if (paramParcel1.readInt() != 0) {
          bool1 = true;
        }
        a(bool1);
        paramParcel2.writeNoException();
        return true;
      case 13: 
        paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
        b();
        paramParcel2.writeNoException();
        return true;
      case 12: 
        paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
        a();
        paramParcel2.writeNoException();
        return true;
      case 11: 
        paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
        a(paramParcel1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
        a(paramParcel1.readLong(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
        paramParcel1 = a(paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
        a(paramParcel1.readString());
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
        paramInt1 = a(paramParcel1.readLong(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
        str = paramParcel1.readString();
        paramParcel2 = (Parcel)localObject;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = (Bitmap)Bitmap.CREATOR.createFromParcel(paramParcel1);
        }
        a(str, paramParcel2);
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
        bool1 = bool2;
        if (paramParcel1.readInt() != 0) {
          bool1 = true;
        }
        localObject = str;
        if (paramParcel1.readInt() != 0) {
          localObject = (Notification)Notification.CREATOR.createFromParcel(paramParcel1);
        }
        a(bool1, (Notification)localObject);
        paramParcel2.writeNoException();
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
        c(paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
        b(paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
        a(paramParcel1.createByteArray());
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.av.service.IAVServiceForQQ");
      a(IAVServiceCallback.Stub.a(paramParcel1.readStrongBinder()));
      return true;
    }
    paramParcel2.writeString("com.tencent.av.service.IAVServiceForQQ");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.service.IAVServiceForQQ.Stub
 * JD-Core Version:    0.7.0.1
 */