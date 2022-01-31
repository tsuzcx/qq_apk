import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class bepv
  extends Binder
  implements bepu
{
  public bepv()
  {
    attachInterface(this, "com.tencent.qqmini.sdk.ipc.MiniCmdCallback");
  }
  
  public static bepu a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.qqmini.sdk.ipc.MiniCmdCallback");
    if ((localIInterface != null) && ((localIInterface instanceof bepu))) {
      return (bepu)localIInterface;
    }
    return new bepw(paramIBinder);
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
 * Qualified Name:     bepv
 * JD-Core Version:    0.7.0.1
 */