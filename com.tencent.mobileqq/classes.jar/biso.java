import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qlink.SendMsg;

public abstract class biso
  extends Binder
  implements bisn
{
  public biso()
  {
    attachInterface(this, "cooperation.qlink.IQlinkService");
  }
  
  public static bisn a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("cooperation.qlink.IQlinkService");
    if ((localIInterface != null) && ((localIInterface instanceof bisn))) {
      return (bisn)localIInterface;
    }
    return new bisp(paramIBinder);
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
      paramParcel2.writeString("cooperation.qlink.IQlinkService");
      return true;
    }
    paramParcel1.enforceInterface("cooperation.qlink.IQlinkService");
    if (paramParcel1.readInt() != 0) {}
    for (paramParcel1 = (SendMsg)SendMsg.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      a(paramParcel1);
      paramParcel2.writeNoException();
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     biso
 * JD-Core Version:    0.7.0.1
 */