import android.os.IBinder;
import android.os.Parcel;

class axlh
  implements axlf
{
  private IBinder a;
  
  axlh(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  public void onComplete(String paramString, int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.theme.IDownloadListener");
      localParcel1.writeString(paramString);
      localParcel1.writeInt(paramInt);
      this.a.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void onProgress(String paramString, long paramLong1, long paramLong2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.theme.IDownloadListener");
      localParcel1.writeString(paramString);
      localParcel1.writeLong(paramLong1);
      localParcel1.writeLong(paramLong2);
      this.a.transact(1, localParcel1, localParcel2, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axlh
 * JD-Core Version:    0.7.0.1
 */