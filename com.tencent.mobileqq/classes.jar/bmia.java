import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qappcenter.remote.RecvMsg;

public abstract class bmia
  extends Binder
  implements bmhz
{
  public static bmhz a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("cooperation.qappcenter.remote.IActionListener");
    if ((localIInterface != null) && ((localIInterface instanceof bmhz))) {
      return (bmhz)localIInterface;
    }
    return new bmib(paramIBinder);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmia
 * JD-Core Version:    0.7.0.1
 */