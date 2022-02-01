package com.tencent.mobileqq.activity.aio.photo;

import android.os.IBinder;

class ICompressionCallBack$Stub$Proxy
  implements ICompressionCallBack
{
  private IBinder a;
  
  ICompressionCallBack$Stub$Proxy(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  /* Error */
  public void a(com.tencent.mobileqq.pic.CompressInfo paramCompressInfo)
  {
    // Byte code:
    //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: aload_2
    //   5: ldc 27
    //   7: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   10: aload_2
    //   11: aload_1
    //   12: iconst_1
    //   13: invokevirtual 35	android/os/Parcel:writeParcelable	(Landroid/os/Parcelable;I)V
    //   16: aload_0
    //   17: getfield 15	com/tencent/mobileqq/activity/aio/photo/ICompressionCallBack$Stub$Proxy:a	Landroid/os/IBinder;
    //   20: iconst_1
    //   21: aload_2
    //   22: aconst_null
    //   23: iconst_1
    //   24: invokeinterface 41 5 0
    //   29: pop
    //   30: goto +25 -> 55
    //   33: astore_1
    //   34: goto +26 -> 60
    //   37: astore_1
    //   38: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   41: ifeq +14 -> 55
    //   44: ldc 49
    //   46: iconst_2
    //   47: aload_1
    //   48: invokevirtual 53	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   51: aload_1
    //   52: invokestatic 57	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   55: aload_2
    //   56: invokevirtual 60	android/os/Parcel:recycle	()V
    //   59: return
    //   60: aload_2
    //   61: invokevirtual 60	android/os/Parcel:recycle	()V
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	Proxy
    //   0	66	1	paramCompressInfo	com.tencent.mobileqq.pic.CompressInfo
    //   3	58	2	localParcel	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   4	30	33	finally
    //   38	55	33	finally
    //   4	30	37	android/os/RemoteException
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  /* Error */
  public void b(com.tencent.mobileqq.pic.CompressInfo paramCompressInfo)
  {
    // Byte code:
    //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: aload_2
    //   5: ldc 27
    //   7: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   10: aload_2
    //   11: aload_1
    //   12: iconst_1
    //   13: invokevirtual 35	android/os/Parcel:writeParcelable	(Landroid/os/Parcelable;I)V
    //   16: aload_0
    //   17: getfield 15	com/tencent/mobileqq/activity/aio/photo/ICompressionCallBack$Stub$Proxy:a	Landroid/os/IBinder;
    //   20: iconst_2
    //   21: aload_2
    //   22: aconst_null
    //   23: iconst_1
    //   24: invokeinterface 41 5 0
    //   29: pop
    //   30: goto +25 -> 55
    //   33: astore_1
    //   34: goto +26 -> 60
    //   37: astore_1
    //   38: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   41: ifeq +14 -> 55
    //   44: ldc 49
    //   46: iconst_2
    //   47: aload_1
    //   48: invokevirtual 53	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   51: aload_1
    //   52: invokestatic 57	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   55: aload_2
    //   56: invokevirtual 60	android/os/Parcel:recycle	()V
    //   59: return
    //   60: aload_2
    //   61: invokevirtual 60	android/os/Parcel:recycle	()V
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	Proxy
    //   0	66	1	paramCompressInfo	com.tencent.mobileqq.pic.CompressInfo
    //   3	58	2	localParcel	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   4	30	33	finally
    //   38	55	33	finally
    //   4	30	37	android/os/RemoteException
  }
  
  /* Error */
  public void c(com.tencent.mobileqq.pic.CompressInfo paramCompressInfo)
  {
    // Byte code:
    //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: aload_2
    //   5: ldc 27
    //   7: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   10: aload_2
    //   11: aload_1
    //   12: iconst_1
    //   13: invokevirtual 35	android/os/Parcel:writeParcelable	(Landroid/os/Parcelable;I)V
    //   16: aload_0
    //   17: getfield 15	com/tencent/mobileqq/activity/aio/photo/ICompressionCallBack$Stub$Proxy:a	Landroid/os/IBinder;
    //   20: iconst_3
    //   21: aload_2
    //   22: aconst_null
    //   23: iconst_1
    //   24: invokeinterface 41 5 0
    //   29: pop
    //   30: goto +25 -> 55
    //   33: astore_1
    //   34: goto +26 -> 60
    //   37: astore_1
    //   38: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   41: ifeq +14 -> 55
    //   44: ldc 49
    //   46: iconst_2
    //   47: aload_1
    //   48: invokevirtual 53	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   51: aload_1
    //   52: invokestatic 57	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   55: aload_2
    //   56: invokevirtual 60	android/os/Parcel:recycle	()V
    //   59: return
    //   60: aload_2
    //   61: invokevirtual 60	android/os/Parcel:recycle	()V
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	Proxy
    //   0	66	1	paramCompressInfo	com.tencent.mobileqq.pic.CompressInfo
    //   3	58	2	localParcel	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   4	30	33	finally
    //   38	55	33	finally
    //   4	30	37	android/os/RemoteException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */