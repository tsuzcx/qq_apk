package com.tencent.mobileqq.activity.aio.photo;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import vov;

public abstract class IAIOImageProviderCallBack$Stub
  extends Binder
  implements IAIOImageProviderCallBack
{
  public IAIOImageProviderCallBack$Stub()
  {
    attachInterface(this, "com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
  }
  
  public static IAIOImageProviderCallBack a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
    if ((localIInterface != null) && ((localIInterface instanceof IAIOImageProviderCallBack))) {
      return (IAIOImageProviderCallBack)localIInterface;
    }
    return new vov(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
      l1 = paramParcel1.readLong();
      paramInt1 = paramParcel1.readInt();
      paramInt2 = paramParcel1.readInt();
      i = paramParcel1.readInt();
      paramParcel2 = paramParcel1.readString();
      if (paramParcel1.readByte() != 0) {
        bool1 = true;
      }
      a(l1, paramInt1, paramInt2, i, paramParcel2, bool1);
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
      a((AIORichMediaData[])paramParcel1.createTypedArray(AIORichMediaData.CREATOR), paramParcel1.readInt());
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
    long l1 = paramParcel1.readLong();
    paramInt1 = paramParcel1.readInt();
    paramInt2 = paramParcel1.readInt();
    int i = paramParcel1.readInt();
    long l2 = paramParcel1.readLong();
    bool1 = bool2;
    if (paramParcel1.readByte() == 1) {
      bool1 = true;
    }
    a(l1, paramInt1, paramInt2, i, l2, bool1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack.Stub
 * JD-Core Version:    0.7.0.1
 */