import android.os.IBinder;

class amuz
  implements amux
{
  private IBinder a;
  
  amuz(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  /* Error */
  public com.tencent.mobileqq.ar.aidl.ARScanStarFaceConfigInfo a()
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 25
    //   11: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 15	amuz:a	Landroid/os/IBinder;
    //   18: iconst_1
    //   19: aload_2
    //   20: aload_3
    //   21: iconst_0
    //   22: invokeinterface 35 5 0
    //   27: pop
    //   28: aload_3
    //   29: invokevirtual 38	android/os/Parcel:readException	()V
    //   32: aload_3
    //   33: invokevirtual 42	android/os/Parcel:readInt	()I
    //   36: ifeq +26 -> 62
    //   39: getstatic 48	com/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo:CREATOR	Landroid/os/Parcelable$Creator;
    //   42: aload_3
    //   43: invokeinterface 54 2 0
    //   48: checkcast 44	com/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo
    //   51: astore_1
    //   52: aload_3
    //   53: invokevirtual 57	android/os/Parcel:recycle	()V
    //   56: aload_2
    //   57: invokevirtual 57	android/os/Parcel:recycle	()V
    //   60: aload_1
    //   61: areturn
    //   62: aconst_null
    //   63: astore_1
    //   64: goto -12 -> 52
    //   67: astore_1
    //   68: aload_3
    //   69: invokevirtual 57	android/os/Parcel:recycle	()V
    //   72: aload_2
    //   73: invokevirtual 57	android/os/Parcel:recycle	()V
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	amuz
    //   51	13	1	localARScanStarFaceConfigInfo	com.tencent.mobileqq.ar.aidl.ARScanStarFaceConfigInfo
    //   67	10	1	localObject	Object
    //   3	70	2	localParcel1	android.os.Parcel
    //   7	62	3	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   8	52	67	finally
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amuz
 * JD-Core Version:    0.7.0.1
 */