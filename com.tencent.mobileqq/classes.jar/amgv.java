import android.os.IBinder;
import android.os.Parcel;
import cooperation.qzone.plugin.OnQZonePluginInstallListner;

public class amgv
  implements OnQZonePluginInstallListner
{
  private IBinder a;
  
  public amgv(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public void a(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("cooperation.qzone.plugin.OnQZonePluginInstallListner");
      localParcel1.writeString(paramString);
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
  
  public void a(String paramString, float paramFloat, long paramLong)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("cooperation.qzone.plugin.OnQZonePluginInstallListner");
      localParcel1.writeString(paramString);
      localParcel1.writeFloat(paramFloat);
      localParcel1.writeLong(paramLong);
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
  
  public void a(String paramString, int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("cooperation.qzone.plugin.OnQZonePluginInstallListner");
      localParcel1.writeString(paramString);
      localParcel1.writeInt(paramInt);
      this.a.transact(4, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  public void b(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("cooperation.qzone.plugin.OnQZonePluginInstallListner");
      localParcel1.writeString(paramString);
      this.a.transact(3, localParcel1, localParcel2, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amgv
 * JD-Core Version:    0.7.0.1
 */