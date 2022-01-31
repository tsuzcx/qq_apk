import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class bkie
  extends Binder
  implements bkid
{
  public bkie()
  {
    attachInterface(this, "cooperation.wadl.ipc.IWadlService");
  }
  
  public static bkid a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("cooperation.wadl.ipc.IWadlService");
    if ((localIInterface != null) && ((localIInterface instanceof bkid))) {
      return (bkid)localIInterface;
    }
    return new bkif(paramIBinder);
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
      paramParcel2.writeString("cooperation.wadl.ipc.IWadlService");
      return true;
    case 1: 
      paramParcel1.enforceInterface("cooperation.wadl.ipc.IWadlService");
      paramParcel2 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(paramParcel2, paramParcel1);
        return true;
      }
    case 2: 
      paramParcel1.enforceInterface("cooperation.wadl.ipc.IWadlService");
      a(bkih.a(paramParcel1.readStrongBinder()));
      return true;
    }
    paramParcel1.enforceInterface("cooperation.wadl.ipc.IWadlService");
    b(bkih.a(paramParcel1.readStrongBinder()));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkie
 * JD-Core Version:    0.7.0.1
 */