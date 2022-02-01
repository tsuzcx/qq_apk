package com.tencent.mobileqq.activity.aio.photo;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;

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
    return new IAIOImageProviderCallBack.Stub.Proxy(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    int i = 0;
    boolean bool;
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
              paramParcel2.writeString("com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
              return true;
            }
            if (QLog.isColorLevel()) {
              QLog.d("IAIOImageProviderCallBack", 2, "carverW onTransact -> case TRANSACTION_notifyVideoURL");
            }
            paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
            l1 = paramParcel1.readLong();
            paramInt2 = paramParcel1.readInt();
            int j = paramParcel1.readInt();
            paramParcel2 = paramParcel1.readString();
            int k = paramParcel1.readInt();
            String[] arrayOfString = new String[k];
            paramInt1 = i;
            while (paramInt1 < k)
            {
              arrayOfString[paramInt1] = paramParcel1.readString();
              paramInt1 += 1;
            }
            a(l1, paramInt2, j, paramParcel2, arrayOfString, paramParcel1.readString(), (MessageForShortVideo)paramParcel1.readParcelable(MessageForShortVideo.class.getClassLoader()), paramParcel1.readInt(), paramParcel1.readBundle());
            return true;
          }
          paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
          a();
          return true;
        }
        paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
        l1 = paramParcel1.readLong();
        paramInt1 = paramParcel1.readInt();
        paramInt2 = paramParcel1.readInt();
        i = paramParcel1.readInt();
        long l2 = paramParcel1.readLong();
        if (paramParcel1.readByte() == 1) {
          bool = true;
        } else {
          bool = false;
        }
        a(l1, paramInt1, paramInt2, i, l2, bool);
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
      a((AIORichMediaData[])paramParcel1.createTypedArray(AIORichMediaData.CREATOR), paramParcel1.readInt());
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
    long l1 = paramParcel1.readLong();
    paramInt1 = paramParcel1.readInt();
    paramInt2 = paramParcel1.readInt();
    i = paramParcel1.readInt();
    paramParcel2 = paramParcel1.readString();
    if (paramParcel1.readByte() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    a(l1, paramInt1, paramInt2, i, paramParcel2, bool);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack.Stub
 * JD-Core Version:    0.7.0.1
 */