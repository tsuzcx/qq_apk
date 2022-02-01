package com.huawei.arengine.service;

import android.os.IBinder;
import android.os.Parcel;

class IAREngine$Stub$a
  implements IAREngine
{
  private IBinder a;
  
  IAREngine$Stub$a(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  public int[] getMetaData()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.huawei.arengine.service.IAREngine");
      this.a.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int[] arrayOfInt = localParcel2.createIntArray();
      return arrayOfInt;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public android.os.ParcelFileDescriptor getSharedFile(String paramString)
  {
    // Byte code:
    //   0: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 28
    //   11: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_2
    //   15: aload_1
    //   16: invokevirtual 52	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   19: aload_0
    //   20: getfield 15	com/huawei/arengine/service/IAREngine$Stub$a:a	Landroid/os/IBinder;
    //   23: iconst_4
    //   24: aload_2
    //   25: aload_3
    //   26: iconst_0
    //   27: invokeinterface 38 5 0
    //   32: pop
    //   33: aload_3
    //   34: invokevirtual 41	android/os/Parcel:readException	()V
    //   37: aload_3
    //   38: invokevirtual 56	android/os/Parcel:readInt	()I
    //   41: ifeq +26 -> 67
    //   44: getstatic 62	android/os/ParcelFileDescriptor:CREATOR	Landroid/os/Parcelable$Creator;
    //   47: aload_3
    //   48: invokeinterface 68 2 0
    //   53: checkcast 58	android/os/ParcelFileDescriptor
    //   56: astore_1
    //   57: aload_3
    //   58: invokevirtual 47	android/os/Parcel:recycle	()V
    //   61: aload_2
    //   62: invokevirtual 47	android/os/Parcel:recycle	()V
    //   65: aload_1
    //   66: areturn
    //   67: aconst_null
    //   68: astore_1
    //   69: goto -12 -> 57
    //   72: astore_1
    //   73: aload_3
    //   74: invokevirtual 47	android/os/Parcel:recycle	()V
    //   77: aload_2
    //   78: invokevirtual 47	android/os/Parcel:recycle	()V
    //   81: aload_1
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	a
    //   0	83	1	paramString	String
    //   3	75	2	localParcel1	Parcel
    //   7	67	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	57	72	finally
  }
  
  public int getVersionCode()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.huawei.arengine.service.IAREngine");
      this.a.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public String getVersionName()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.huawei.arengine.service.IAREngine");
      this.a.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      String str = localParcel2.readString();
      return str;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.arengine.service.IAREngine.Stub.a
 * JD-Core Version:    0.7.0.1
 */