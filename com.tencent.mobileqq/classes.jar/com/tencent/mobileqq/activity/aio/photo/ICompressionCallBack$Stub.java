package com.tencent.mobileqq.activity.aio.photo;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.mobileqq.pic.CompressInfo;

public abstract class ICompressionCallBack$Stub
  extends Binder
  implements ICompressionCallBack
{
  public ICompressionCallBack$Stub()
  {
    attachInterface(this, "com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack");
  }
  
  public static ICompressionCallBack a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack");
    if ((localIInterface != null) && ((localIInterface instanceof ICompressionCallBack))) {
      return (ICompressionCallBack)localIInterface;
    }
    return new ICompressionCallBack.Stub.Proxy(paramIBinder);
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
          paramParcel2.writeString("com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack");
          return true;
        }
        paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack");
        c((CompressInfo)paramParcel1.readParcelable(CompressInfo.class.getClassLoader()));
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack");
      b((CompressInfo)paramParcel1.readParcelable(CompressInfo.class.getClassLoader()));
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack");
    a((CompressInfo)paramParcel1.readParcelable(CompressInfo.class.getClassLoader()));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack.Stub
 * JD-Core Version:    0.7.0.1
 */