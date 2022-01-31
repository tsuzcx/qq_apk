import android.os.IBinder;
import android.os.Parcel;

class bgsj
  implements bgsh
{
  private IBinder a;
  
  bgsj(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public void a(bgsk parambgsk)
  {
    IBinder localIBinder = null;
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("cooperation.wadl.ipc.IWadlService");
      if (parambgsk != null) {
        localIBinder = parambgsk.asBinder();
      }
      localParcel.writeStrongBinder(localIBinder);
      this.a.transact(2, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  /* Error */
  public void a(java.lang.String paramString, android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: aload_3
    //   5: ldc 25
    //   7: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   10: aload_3
    //   11: aload_1
    //   12: invokevirtual 51	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   15: aload_2
    //   16: ifnull +33 -> 49
    //   19: aload_3
    //   20: iconst_1
    //   21: invokevirtual 55	android/os/Parcel:writeInt	(I)V
    //   24: aload_2
    //   25: aload_3
    //   26: iconst_0
    //   27: invokevirtual 61	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   30: aload_0
    //   31: getfield 15	bgsj:a	Landroid/os/IBinder;
    //   34: iconst_1
    //   35: aload_3
    //   36: aconst_null
    //   37: iconst_1
    //   38: invokeinterface 44 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 47	android/os/Parcel:recycle	()V
    //   48: return
    //   49: aload_3
    //   50: iconst_0
    //   51: invokevirtual 55	android/os/Parcel:writeInt	(I)V
    //   54: goto -24 -> 30
    //   57: astore_1
    //   58: aload_3
    //   59: invokevirtual 47	android/os/Parcel:recycle	()V
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	bgsj
    //   0	64	1	paramString	java.lang.String
    //   0	64	2	paramBundle	android.os.Bundle
    //   3	56	3	localParcel	Parcel
    // Exception table:
    //   from	to	target	type
    //   4	15	57	finally
    //   19	30	57	finally
    //   30	44	57	finally
    //   49	54	57	finally
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  public void b(bgsk parambgsk)
  {
    IBinder localIBinder = null;
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("cooperation.wadl.ipc.IWadlService");
      if (parambgsk != null) {
        localIBinder = parambgsk.asBinder();
      }
      localParcel.writeStrongBinder(localIBinder);
      this.a.transact(3, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgsj
 * JD-Core Version:    0.7.0.1
 */