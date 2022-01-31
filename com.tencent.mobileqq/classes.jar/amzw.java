import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class amzw
  extends Binder
  implements amzv
{
  public amzw()
  {
    attachInterface(this, "com.tencent.mobileqq.ar.aidl.IArSoCallback");
  }
  
  public static amzv a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.ar.aidl.IArSoCallback");
    if ((localIInterface != null) && ((localIInterface instanceof amzv))) {
      return (amzv)localIInterface;
    }
    return new amzx(paramIBinder);
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
      paramParcel2.writeString("com.tencent.mobileqq.ar.aidl.IArSoCallback");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArSoCallback");
      a();
      paramParcel2.writeNoException();
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArSoCallback");
      b();
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mobileqq.ar.aidl.IArSoCallback");
    a(paramParcel1.readInt());
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amzw
 * JD-Core Version:    0.7.0.1
 */