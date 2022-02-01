package com.tencent.mobileqq.ar.aidl;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;

class IArConfigManager$Stub$Proxy
  implements IArConfigManager
{
  private IBinder a;
  
  IArConfigManager$Stub$Proxy(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public ArConfigInfo a()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.ar.aidl.IArConfigManager");
      this.a.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      ArConfigInfo localArConfigInfo;
      if (localParcel2.readInt() != 0) {
        localArConfigInfo = (ArConfigInfo)ArConfigInfo.CREATOR.createFromParcel(localParcel2);
      } else {
        localArConfigInfo = null;
      }
      return localArConfigInfo;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void a(int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.ar.aidl.IArConfigManager");
      localParcel1.writeInt(paramInt);
      this.a.transact(10, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void a(ArConfigInfo paramArConfigInfo)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.ar.aidl.IArConfigManager");
      if (paramArConfigInfo != null)
      {
        localParcel1.writeInt(1);
        paramArConfigInfo.writeToParcel(localParcel1, 0);
      }
      else
      {
        localParcel1.writeInt(0);
      }
      this.a.transact(12, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void a(IArFaceCallback paramIArFaceCallback)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mobileqq.ar.aidl.IArConfigManager");
        if (paramIArFaceCallback != null)
        {
          paramIArFaceCallback = paramIArFaceCallback.asBinder();
          localParcel1.writeStrongBinder(paramIArFaceCallback);
          this.a.transact(8, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      paramIArFaceCallback = null;
    }
  }
  
  public void a(IArRemoteCallback paramIArRemoteCallback)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mobileqq.ar.aidl.IArConfigManager");
        if (paramIArRemoteCallback != null)
        {
          paramIArRemoteCallback = paramIArRemoteCallback.asBinder();
          localParcel1.writeStrongBinder(paramIArRemoteCallback);
          this.a.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      paramIArRemoteCallback = null;
    }
  }
  
  public void a(IArSoCallback paramIArSoCallback)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mobileqq.ar.aidl.IArConfigManager");
        if (paramIArSoCallback != null)
        {
          paramIArSoCallback = paramIArSoCallback.asBinder();
          localParcel1.writeStrongBinder(paramIArSoCallback);
          this.a.transact(15, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      paramIArSoCallback = null;
    }
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  public ArEffectConfig b()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.ar.aidl.IArConfigManager");
      this.a.transact(4, localParcel1, localParcel2, 0);
      localParcel2.readException();
      ArEffectConfig localArEffectConfig;
      if (localParcel2.readInt() != 0) {
        localArEffectConfig = (ArEffectConfig)ArEffectConfig.CREATOR.createFromParcel(localParcel2);
      } else {
        localArEffectConfig = null;
      }
      return localArEffectConfig;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void b(int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.ar.aidl.IArConfigManager");
      localParcel1.writeInt(paramInt);
      this.a.transact(19, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void b(IArFaceCallback paramIArFaceCallback)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mobileqq.ar.aidl.IArConfigManager");
        if (paramIArFaceCallback != null)
        {
          paramIArFaceCallback = paramIArFaceCallback.asBinder();
          localParcel1.writeStrongBinder(paramIArFaceCallback);
          this.a.transact(9, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      paramIArFaceCallback = null;
    }
  }
  
  public void b(IArRemoteCallback paramIArRemoteCallback)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mobileqq.ar.aidl.IArConfigManager");
        if (paramIArRemoteCallback != null)
        {
          paramIArRemoteCallback = paramIArRemoteCallback.asBinder();
          localParcel1.writeStrongBinder(paramIArRemoteCallback);
          this.a.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      paramIArRemoteCallback = null;
    }
  }
  
  public void b(IArSoCallback paramIArSoCallback)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mobileqq.ar.aidl.IArConfigManager");
        if (paramIArSoCallback != null)
        {
          paramIArSoCallback = paramIArSoCallback.asBinder();
          localParcel1.writeStrongBinder(paramIArSoCallback);
          this.a.transact(16, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      paramIArSoCallback = null;
    }
  }
  
  public ARCommonConfigInfo c()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.ar.aidl.IArConfigManager");
      this.a.transact(5, localParcel1, localParcel2, 0);
      localParcel2.readException();
      ARCommonConfigInfo localARCommonConfigInfo;
      if (localParcel2.readInt() != 0) {
        localARCommonConfigInfo = (ARCommonConfigInfo)ARCommonConfigInfo.CREATOR.createFromParcel(localParcel2);
      } else {
        localARCommonConfigInfo = null;
      }
      return localARCommonConfigInfo;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void d()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.ar.aidl.IArConfigManager");
      this.a.transact(6, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void e()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.ar.aidl.IArConfigManager");
      this.a.transact(7, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public boolean f()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.ar.aidl.IArConfigManager");
      IBinder localIBinder = this.a;
      boolean bool = false;
      localIBinder.transact(11, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public boolean g()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.ar.aidl.IArConfigManager");
      IBinder localIBinder = this.a;
      boolean bool = false;
      localIBinder.transact(13, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void h()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.ar.aidl.IArConfigManager");
      this.a.transact(14, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public boolean i()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.ar.aidl.IArConfigManager");
      IBinder localIBinder = this.a;
      boolean bool = false;
      localIBinder.transact(17, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void j()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.ar.aidl.IArConfigManager");
      this.a.transact(18, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.aidl.IArConfigManager.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */