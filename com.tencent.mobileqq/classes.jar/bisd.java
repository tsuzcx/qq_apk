import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qappcenter.remote.RecvMsg;

public abstract class bisd
  extends Binder
  implements bisc
{
  public static bisc a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("cooperation.qappcenter.remote.IActionListener");
    if ((localIInterface != null) && ((localIInterface instanceof bisc))) {
      return (bisc)localIInterface;
    }
    return new bise(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("cooperation.qappcenter.remote.IActionListener");
      return true;
    }
    paramParcel1.enforceInterface("cooperation.qappcenter.remote.IActionListener");
    if (paramParcel1.readInt() != 0) {}
    for (paramParcel1 = (RecvMsg)RecvMsg.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      a(paramParcel1);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bisd
 * JD-Core Version:    0.7.0.1
 */