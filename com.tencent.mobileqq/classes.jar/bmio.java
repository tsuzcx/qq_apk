import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;

class bmio
  implements bmim
{
  private IBinder a;
  
  bmio(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public Bundle a(String paramString, Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("cooperation.smartdevice.ipc.ISmartDeviceService");
        localParcel1.writeString(paramString);
        if (paramBundle != null)
        {
          localParcel1.writeInt(1);
          paramBundle.writeToParcel(localParcel1, 0);
          this.a.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramString = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
            return paramString;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramString = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  /* Error */
  public void a(String paramString, Bundle paramBundle)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 25
    //   12: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_3
    //   16: aload_1
    //   17: invokevirtual 32	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   20: aload_2
    //   21: ifnull +44 -> 65
    //   24: aload_3
    //   25: iconst_1
    //   26: invokevirtual 36	android/os/Parcel:writeInt	(I)V
    //   29: aload_2
    //   30: aload_3
    //   31: iconst_0
    //   32: invokevirtual 42	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   35: aload_0
    //   36: getfield 15	bmio:a	Landroid/os/IBinder;
    //   39: iconst_2
    //   40: aload_3
    //   41: aload 4
    //   43: iconst_0
    //   44: invokeinterface 48 5 0
    //   49: pop
    //   50: aload 4
    //   52: invokevirtual 51	android/os/Parcel:readException	()V
    //   55: aload 4
    //   57: invokevirtual 68	android/os/Parcel:recycle	()V
    //   60: aload_3
    //   61: invokevirtual 68	android/os/Parcel:recycle	()V
    //   64: return
    //   65: aload_3
    //   66: iconst_0
    //   67: invokevirtual 36	android/os/Parcel:writeInt	(I)V
    //   70: goto -35 -> 35
    //   73: astore_1
    //   74: aload 4
    //   76: invokevirtual 68	android/os/Parcel:recycle	()V
    //   79: aload_3
    //   80: invokevirtual 68	android/os/Parcel:recycle	()V
    //   83: aload_1
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	bmio
    //   0	85	1	paramString	String
    //   0	85	2	paramBundle	Bundle
    //   3	77	3	localParcel1	Parcel
    //   7	68	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	20	73	finally
    //   24	35	73	finally
    //   35	55	73	finally
    //   65	70	73	finally
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmio
 * JD-Core Version:    0.7.0.1
 */