package com.tencent.av.service;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import jnj;

public abstract class IQQServiceForAV$Stub
  extends Binder
  implements IQQServiceForAV
{
  public IQQServiceForAV$Stub()
  {
    attachInterface(this, "com.tencent.av.service.IQQServiceForAV");
  }
  
  public static IQQServiceForAV a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.av.service.IQQServiceForAV");
    if ((localIInterface != null) && ((localIInterface instanceof IQQServiceForAV))) {
      return (IQQServiceForAV)localIInterface;
    }
    return new jnj(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject2 = null;
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    int i6 = 0;
    boolean bool1 = false;
    int i7 = 0;
    int i8 = 0;
    int i9 = 0;
    boolean bool2 = false;
    boolean bool3 = false;
    int i10 = 0;
    int i = 0;
    Object localObject1;
    label777:
    label783:
    long l;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.av.service.IQQServiceForAV");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      bool1 = a(paramParcel1.readString());
      paramParcel2.writeNoException();
      if (bool1) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        paramParcel2.writeInt(paramInt1);
        return true;
      }
    case 2: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      paramInt1 = paramParcel1.readInt();
      localObject1 = paramParcel1.readString();
      localObject2 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0)
      {
        bool1 = true;
        if (paramParcel1.readInt() == 0) {
          break label777;
        }
      }
      for (bool2 = true;; bool2 = false)
      {
        paramParcel1 = a(paramInt1, (String)localObject1, (String)localObject2, bool1, bool2);
        paramParcel2.writeNoException();
        if (paramParcel1 == null) {
          break label783;
        }
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
        bool1 = false;
        break;
      }
      paramParcel2.writeInt(0);
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      paramParcel1 = a(paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      paramParcel1 = a(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      a(paramParcel1.readInt(), paramParcel1.readString());
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      a();
      return true;
    case 7: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      a(IQQServiceCallback.Stub.a(paramParcel1.readStrongBinder()), paramParcel1.readString());
      return true;
    case 8: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      a(IQQServiceCallback.Stub.a(paramParcel1.readStrongBinder()));
      return true;
    case 9: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      a(paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString());
      return true;
    case 10: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      b(paramParcel1.readInt(), paramParcel1.readString());
      return true;
    case 11: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      bool1 = a(paramParcel1.readInt(), paramParcel1.readLong());
      paramParcel2.writeNoException();
      paramInt1 = i;
      if (bool1) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 12: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      paramInt1 = a(paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 13: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      l = a(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeLong(l);
      return true;
    case 14: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      bool1 = a(paramParcel1.readString(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramInt1 = j;
      if (bool1) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 15: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      bool1 = a();
      paramParcel2.writeNoException();
      paramInt1 = k;
      if (bool1) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 16: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      bool1 = b();
      paramParcel2.writeNoException();
      paramInt1 = m;
      if (bool1) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 17: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      paramParcel1 = a(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeLongArray(paramParcel1);
      return true;
    case 18: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      a(paramParcel1.readLong());
      return true;
    case 19: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      bool1 = b(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramInt1 = n;
      if (bool1) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 20: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      paramInt1 = a(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 21: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      paramInt1 = a();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 22: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      l = b(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeLong(l);
      return true;
    case 23: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      bool1 = a(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.createByteArray());
      paramParcel2.writeNoException();
      paramInt1 = i1;
      if (bool1) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 24: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      bool1 = a(paramParcel1.readLong());
      paramParcel2.writeNoException();
      paramInt1 = i2;
      if (bool1) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 25: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      bool1 = b(paramParcel1.readString(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramInt1 = i3;
      if (bool1) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 26: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      localObject1 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (bool1 = true;; bool1 = false)
      {
        bool1 = a((String)localObject1, bool1);
        paramParcel2.writeNoException();
        paramInt1 = i4;
        if (bool1) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      }
    case 27: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      a(IQQServiceLocationCallback.Stub.a(paramParcel1.readStrongBinder()));
      return true;
    case 28: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      b(IQQServiceLocationCallback.Stub.a(paramParcel1.readStrongBinder()));
      return true;
    case 29: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      a(IAVRedPacketCallback.Stub.a(paramParcel1.readStrongBinder()));
      return true;
    case 30: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      b(IAVRedPacketCallback.Stub.a(paramParcel1.readStrongBinder()));
      return true;
    case 31: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      paramParcel1 = a();
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 32: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      a(paramParcel1.readInt());
      return true;
    case 33: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      a(paramParcel1.readString());
      return true;
    case 34: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      bool1 = c(paramParcel1.readString(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramInt1 = i5;
      if (bool1) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 35: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      b(paramParcel1.readString());
      return true;
    case 36: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      c(paramParcel1.readString());
      return true;
    case 37: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      b();
      return true;
    case 38: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      c();
      return true;
    case 39: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      paramInt1 = b(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 40: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      a(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
      return true;
    case 41: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      a(paramParcel1.createLongArray(), paramParcel1.readString());
      return true;
    case 42: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      a(paramParcel1.readLong(), paramParcel1.readString(), paramParcel1.readInt());
      return true;
    case 43: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      bool1 = a(paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      paramInt1 = i6;
      if (bool1) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 44: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      paramParcel1 = b(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeLongArray(paramParcel1);
      return true;
    case 45: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      paramParcel1 = a(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeStringArray(paramParcel1);
      return true;
    case 46: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      paramParcel1 = b(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 47: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      a(bool1);
      return true;
    case 48: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      bool1 = c();
      paramParcel2.writeNoException();
      paramInt1 = i7;
      if (bool1) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 49: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      paramParcel1 = c(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 50: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      paramParcel1 = d(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 51: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      paramInt1 = b();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 52: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      paramInt1 = c();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 53: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      paramParcel1 = a();
      paramParcel2.writeNoException();
      paramParcel2.writeIntArray(paramParcel1);
      return true;
    case 54: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      bool1 = d();
      paramParcel2.writeNoException();
      paramInt1 = i8;
      if (bool1) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 55: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      bool1 = e();
      paramParcel2.writeNoException();
      paramInt1 = i9;
      if (bool1) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 56: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      paramInt1 = d();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 57: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      bool1 = bool2;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      b(bool1);
      return true;
    case 58: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      a(paramParcel1.readString(), paramParcel1.readLong());
      return true;
    case 59: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      bool1 = bool3;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      c(bool1);
      return true;
    case 60: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      bool1 = c(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramInt1 = i10;
      if (bool1) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 61: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      paramParcel1 = e(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 62: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      d(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 63: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      a(paramParcel1.readInt(), paramParcel1.readLong(), paramParcel1.readInt(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 64: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      a(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.createByteArray());
      paramParcel2.writeNoException();
      return true;
    case 65: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      a(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 66: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      a(paramParcel1.readLong(), paramParcel1.readString(), paramParcel1.readLong());
      paramParcel2.writeNoException();
      return true;
    case 67: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      paramInt1 = c(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 68: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      paramInt1 = paramParcel1.readInt();
      paramInt2 = paramParcel1.readInt();
      i = paramParcel1.readInt();
      byte[] arrayOfByte = paramParcel1.createByteArray();
      if (paramParcel1.readInt() != 0) {}
      for (localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; localObject1 = null)
      {
        if (paramParcel1.readInt() != 0) {
          localObject2 = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramParcel1);
        }
        paramParcel1 = a(paramInt1, paramInt2, i, arrayOfByte, (Bundle)localObject1, (ResultReceiver)localObject2);
        paramParcel2.writeNoException();
        if (paramParcel1 == null) {
          break;
        }
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 69: 
      paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
      e(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.av.service.IQQServiceForAV");
    paramInt1 = paramParcel1.readInt();
    paramInt2 = paramParcel1.readInt();
    if (paramParcel1.readInt() != 0) {}
    for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      paramParcel1 = a(paramInt1, paramInt2, paramParcel1);
      paramParcel2.writeNoException();
      if (paramParcel1 == null) {
        break;
      }
      paramParcel2.writeInt(1);
      paramParcel1.writeToParcel(paramParcel2, 1);
      return true;
    }
    paramParcel2.writeInt(0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.service.IQQServiceForAV.Stub
 * JD-Core Version:    0.7.0.1
 */