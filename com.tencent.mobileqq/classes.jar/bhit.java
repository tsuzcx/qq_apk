import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class bhit
  extends Binder
  implements bhis
{
  public bhit()
  {
    attachInterface(this, "cooperation.qzone.plugin.OnQZonePluginInstallListner");
  }
  
  public static bhis a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("cooperation.qzone.plugin.OnQZonePluginInstallListner");
    if ((localIInterface != null) && ((localIInterface instanceof bhis))) {
      return (bhis)localIInterface;
    }
    return new bhiu(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("cooperation.qzone.plugin.OnQZonePluginInstallListner");
      return true;
    case 1: 
      paramParcel1.enforceInterface("cooperation.qzone.plugin.OnQZonePluginInstallListner");
      a(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 2: 
      paramParcel1.enforceInterface("cooperation.qzone.plugin.OnQZonePluginInstallListner");
      a(paramParcel1.readString(), paramParcel1.readFloat(), paramParcel1.readLong());
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("cooperation.qzone.plugin.OnQZonePluginInstallListner");
      b(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("cooperation.qzone.plugin.OnQZonePluginInstallListner");
    a(paramParcel1.readString(), paramParcel1.readInt());
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhit
 * JD-Core Version:    0.7.0.1
 */