package com.huawei.hms.core.aidl;

import android.os.IBinder;

class d$a$a
  implements d
{
  private IBinder a;
  
  d$a$a(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  /* Error */
  public void a(b paramb)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 25
    //   11: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +41 -> 56
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 33	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 39	com/huawei/hms/core/aidl/b:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 15	com/huawei/hms/core/aidl/d$a$a:a	Landroid/os/IBinder;
    //   33: iconst_1
    //   34: aload_2
    //   35: aload_3
    //   36: iconst_0
    //   37: invokeinterface 45 5 0
    //   42: pop
    //   43: aload_3
    //   44: invokevirtual 48	android/os/Parcel:readException	()V
    //   47: aload_3
    //   48: invokevirtual 51	android/os/Parcel:recycle	()V
    //   51: aload_2
    //   52: invokevirtual 51	android/os/Parcel:recycle	()V
    //   55: return
    //   56: aload_2
    //   57: iconst_0
    //   58: invokevirtual 33	android/os/Parcel:writeInt	(I)V
    //   61: goto -32 -> 29
    //   64: astore_1
    //   65: aload_3
    //   66: invokevirtual 51	android/os/Parcel:recycle	()V
    //   69: aload_2
    //   70: invokevirtual 51	android/os/Parcel:recycle	()V
    //   73: aload_1
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	a
    //   0	75	1	paramb	b
    //   3	67	2	localParcel1	android.os.Parcel
    //   7	59	3	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	64	finally
    //   18	29	64	finally
    //   29	47	64	finally
    //   56	61	64	finally
  }
  
  /* Error */
  public void a(b paramb, c paramc)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   5: astore 4
    //   7: aload 4
    //   9: ldc 25
    //   11: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +56 -> 71
    //   18: aload 4
    //   20: iconst_1
    //   21: invokevirtual 33	android/os/Parcel:writeInt	(I)V
    //   24: aload_1
    //   25: aload 4
    //   27: iconst_0
    //   28: invokevirtual 39	com/huawei/hms/core/aidl/b:writeToParcel	(Landroid/os/Parcel;I)V
    //   31: aload_3
    //   32: astore_1
    //   33: aload_2
    //   34: ifnull +10 -> 44
    //   37: aload_2
    //   38: invokeinterface 58 1 0
    //   43: astore_1
    //   44: aload 4
    //   46: aload_1
    //   47: invokevirtual 61	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   50: aload_0
    //   51: getfield 15	com/huawei/hms/core/aidl/d$a$a:a	Landroid/os/IBinder;
    //   54: iconst_2
    //   55: aload 4
    //   57: aconst_null
    //   58: iconst_1
    //   59: invokeinterface 45 5 0
    //   64: pop
    //   65: aload 4
    //   67: invokevirtual 51	android/os/Parcel:recycle	()V
    //   70: return
    //   71: aload 4
    //   73: iconst_0
    //   74: invokevirtual 33	android/os/Parcel:writeInt	(I)V
    //   77: goto -46 -> 31
    //   80: astore_1
    //   81: aload 4
    //   83: invokevirtual 51	android/os/Parcel:recycle	()V
    //   86: aload_1
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	a
    //   0	88	1	paramb	b
    //   0	88	2	paramc	c
    //   1	31	3	localObject	Object
    //   5	77	4	localParcel	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   7	14	80	finally
    //   18	31	80	finally
    //   37	44	80	finally
    //   44	65	80	finally
    //   71	77	80	finally
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.core.aidl.d.a.a
 * JD-Core Version:    0.7.0.1
 */