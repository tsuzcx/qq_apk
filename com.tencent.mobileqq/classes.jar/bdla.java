import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class bdla
  extends Binder
  implements bdkz
{
  public bdla()
  {
    attachInterface(this, "com.tencent.qqmini.sdk.ipc.MiniCmdCallback");
  }
  
  public static bdkz a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.qqmini.sdk.ipc.MiniCmdCallback");
    if ((localIInterface != null) && ((localIInterface instanceof bdkz))) {
      return (bdkz)localIInterface;
    }
    return new bdlb(paramIBinder);
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
      paramParcel2.writeString("com.tencent.qqmini.sdk.ipc.MiniCmdCallback");
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.qqmini.sdk.ipc.MiniCmdCallback");
    boolean bool;
    if (paramParcel1.readInt() != 0)
    {
      bool = true;
      if (paramParcel1.readInt() == 0) {
        break label101;
      }
    }
    label101:
    for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      a(bool, paramParcel1);
      paramParcel2.writeNoException();
      return true;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdla
 * JD-Core Version:    0.7.0.1
 */