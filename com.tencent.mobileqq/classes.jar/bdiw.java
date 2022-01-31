import android.os.Parcel;
import android.os.Parcelable;

public class bdiw
{
  public static Parcel a(byte[] paramArrayOfByte)
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
    localParcel.setDataPosition(0);
    return localParcel;
  }
  
  /* Error */
  public static <T> T a(byte[] paramArrayOfByte, android.os.Parcelable.Creator<T> paramCreator)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokestatic 28	bdiw:a	([B)Landroid/os/Parcel;
    //   6: astore_0
    //   7: aload_0
    //   8: astore_2
    //   9: aload_1
    //   10: aload_0
    //   11: invokeinterface 34 2 0
    //   16: astore_1
    //   17: aload_1
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: aload_0
    //   22: ifnull +9 -> 31
    //   25: aload_0
    //   26: invokevirtual 38	android/os/Parcel:recycle	()V
    //   29: aload_2
    //   30: astore_1
    //   31: aload_1
    //   32: areturn
    //   33: astore_1
    //   34: aconst_null
    //   35: astore_0
    //   36: aload_0
    //   37: astore_2
    //   38: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   41: ifeq +16 -> 57
    //   44: aload_0
    //   45: astore_2
    //   46: ldc 46
    //   48: iconst_2
    //   49: aload_1
    //   50: invokevirtual 50	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   53: aload_1
    //   54: invokestatic 54	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   57: aload_3
    //   58: astore_1
    //   59: aload_0
    //   60: ifnull -29 -> 31
    //   63: aload_0
    //   64: invokevirtual 38	android/os/Parcel:recycle	()V
    //   67: aconst_null
    //   68: areturn
    //   69: astore_1
    //   70: aconst_null
    //   71: astore_0
    //   72: aload_0
    //   73: astore_2
    //   74: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   77: ifeq +16 -> 93
    //   80: aload_0
    //   81: astore_2
    //   82: ldc 46
    //   84: iconst_2
    //   85: aload_1
    //   86: invokevirtual 55	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   89: aload_1
    //   90: invokestatic 54	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   93: aload_3
    //   94: astore_1
    //   95: aload_0
    //   96: ifnull -65 -> 31
    //   99: aload_0
    //   100: invokevirtual 38	android/os/Parcel:recycle	()V
    //   103: aconst_null
    //   104: areturn
    //   105: astore_0
    //   106: aconst_null
    //   107: astore_2
    //   108: aload_2
    //   109: ifnull +7 -> 116
    //   112: aload_2
    //   113: invokevirtual 38	android/os/Parcel:recycle	()V
    //   116: aload_0
    //   117: athrow
    //   118: astore_0
    //   119: goto -11 -> 108
    //   122: astore_1
    //   123: goto -51 -> 72
    //   126: astore_1
    //   127: goto -91 -> 36
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	paramArrayOfByte	byte[]
    //   0	130	1	paramCreator	android.os.Parcelable.Creator<T>
    //   8	105	2	localObject1	Object
    //   1	93	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	33	java/lang/Exception
    //   2	7	69	java/lang/OutOfMemoryError
    //   2	7	105	finally
    //   9	17	118	finally
    //   38	44	118	finally
    //   46	57	118	finally
    //   74	80	118	finally
    //   82	93	118	finally
    //   9	17	122	java/lang/OutOfMemoryError
    //   9	17	126	java/lang/Exception
  }
  
  public static byte[] a(Parcelable paramParcelable)
  {
    Parcel localParcel = Parcel.obtain();
    paramParcelable.writeToParcel(localParcel, 0);
    paramParcelable = localParcel.marshall();
    localParcel.recycle();
    return paramParcelable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdiw
 * JD-Core Version:    0.7.0.1
 */