package com.tencent.mobileqq.activity.aio.photo;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;

public abstract class IAIOImageProvider$Stub
  extends Binder
  implements IBinder.DeathRecipient, IAIOImageProvider
{
  protected IAIOImageProviderCallBack y;
  
  protected IAIOImageProvider$Stub()
  {
    attachInterface(this, "com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
  }
  
  public static IAIOImageProvider a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
    if ((localIInterface != null) && ((localIInterface instanceof IAIOImageProvider))) {
      return (IAIOImageProvider)localIInterface;
    }
    return new IAIOImageProvider.Stub.Proxy(paramIBinder);
  }
  
  private boolean a(int paramInt, Parcel paramParcel1, Parcel paramParcel2)
  {
    switch (paramInt)
    {
    case 17: 
    case 18: 
    case 20: 
    default: 
      return false;
    case 23: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      paramInt = paramParcel1.readInt();
      int i = paramParcel1.readInt();
      String str1 = paramParcel1.readString();
      String str2 = paramParcel1.readString();
      String str3 = paramParcel1.readString();
      paramParcel1 = paramParcel1.readString();
      boolean bool;
      if (i == 1) {
        bool = true;
      } else {
        bool = false;
      }
      a(paramInt, bool, str1, str2, str3, paramParcel1);
      paramParcel2.writeNoException();
      return true;
    case 22: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      paramParcel1 = a(paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 21: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      b(paramParcel1.readString(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 19: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      paramInt = a(paramParcel1.readLong(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt);
      return true;
    case 16: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      a(paramParcel1.readLong(), paramParcel1.readInt(), paramParcel1.readBundle());
      paramParcel2.writeNoException();
      return true;
    case 15: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
      c();
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
    paramParcel1 = b(paramParcel1.readLong());
    paramParcel2.writeNoException();
    if (paramParcel1 != null)
    {
      paramParcel2.writeInt(1);
      paramParcel1.writeToParcel(paramParcel2, 1);
      return true;
    }
    paramParcel2.writeInt(0);
    return true;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PEAK", 2, "binder destoryed");
    }
    this.y = null;
  }
  
  public void a(IAIOImageProviderCallBack paramIAIOImageProviderCallBack)
  {
    try
    {
      paramIAIOImageProviderCallBack.asBinder().linkToDeath(this, 0);
      this.y = paramIAIOImageProviderCallBack;
      return;
    }
    catch (RemoteException paramIAIOImageProviderCallBack)
    {
      label19:
      break label19;
    }
    binderDied();
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public void binderDied()
  {
    a();
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    if (paramInt1 != 13) {
      if (paramInt1 != 20) {
        if (paramInt1 != 24) {
          if (paramInt1 != 26) {
            if (paramInt1 != 1598968902) {
              if (paramInt1 != 17) {
                if (paramInt1 != 18) {
                  switch (paramInt1)
                  {
                  }
                }
              }
            }
          }
        }
      }
    }
    try
    {
      if (a(paramInt1, paramParcel1, paramParcel2)) {
        return true;
      }
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    }
    catch (RuntimeException paramParcel1)
    {
      long[] arrayOfLong;
      break label571;
    }
    paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
    e(paramParcel1.readLong());
    paramParcel2.writeNoException();
    return true;
    paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
    d(paramParcel1.readLong());
    paramParcel2.writeNoException();
    return true;
    paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
    paramParcel1 = c(paramParcel1.readLong(), paramParcel1.readInt(), paramParcel1.readInt());
    paramParcel2.writeNoException();
    if (paramParcel1 != null)
    {
      paramParcel2.writeInt(1);
      paramParcel1.writeToParcel(paramParcel2, 1);
      return true;
    }
    paramParcel2.writeInt(0);
    return true;
    paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
    a(paramParcel1.readString(), paramParcel1.readInt());
    paramParcel2.writeNoException();
    return true;
    paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
    c(paramParcel1.readLong(), paramParcel1.readInt());
    paramParcel2.writeNoException();
    return true;
    paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
    a();
    paramParcel2.writeNoException();
    return true;
    paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
    paramParcel1 = b(paramParcel1.readLong(), paramParcel1.readInt());
    paramParcel2.writeNoException();
    if (paramParcel1 != null)
    {
      paramParcel2.writeInt(1);
      paramParcel1.writeToParcel(paramParcel2, 1);
      return true;
    }
    paramParcel2.writeInt(0);
    return true;
    paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
    a(IAIOImageProviderCallBack.Stub.a(paramParcel1.readStrongBinder()));
    paramParcel2.writeNoException();
    return true;
    paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
    a(paramParcel1.readInt());
    paramParcel2.writeNoException();
    return true;
    paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
    b(paramParcel1.readLong(), paramParcel1.readInt(), paramParcel1.readInt());
    paramParcel2.writeNoException();
    return true;
    paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
    a(paramParcel1.readLong(), paramParcel1.readInt(), paramParcel1.readInt());
    paramParcel2.writeNoException();
    return true;
    paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
    a((MessageForShortVideo)paramParcel1.readParcelable(MessageForShortVideo.class.getClassLoader()));
    paramParcel2.writeNoException();
    return true;
    paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
    c(paramParcel1.readLong());
    paramParcel2.writeNoException();
    return true;
    paramParcel2.writeString("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
    return true;
    paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
    g(paramParcel1.readLong());
    paramParcel2.writeNoException();
    return true;
    paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
    f(paramParcel1.readLong());
    paramParcel2.writeNoException();
    return true;
    paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
    arrayOfLong = new long[paramParcel1.readInt()];
    paramParcel1.readLongArray(arrayOfLong);
    b(arrayOfLong);
    paramParcel2.writeNoException();
    return true;
    paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider");
    h(paramParcel1.readLong());
    paramParcel2.writeNoException();
    return true;
    label571:
    paramParcel1.printStackTrace();
    throw paramParcel1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider.Stub
 * JD-Core Version:    0.7.0.1
 */