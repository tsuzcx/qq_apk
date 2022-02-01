import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class bdas
  extends Binder
  implements bdar
{
  private static final String DESCRIPTOR = "com.tencent.mobileqq.theme.ISwitchCallback";
  static final int TRANSACTION_beginSwitch = 1;
  static final int TRANSACTION_doSwitch = 3;
  static final int TRANSACTION_onProgress = 2;
  static final int TRANSACTION_postSwitch = 4;
  
  public bdas()
  {
    attachInterface(this, "com.tencent.mobileqq.theme.ISwitchCallback");
  }
  
  public static bdar asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.theme.ISwitchCallback");
    if ((localIInterface != null) && ((localIInterface instanceof bdar))) {
      return (bdar)localIInterface;
    }
    return new bdat(paramIBinder);
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
      paramParcel2.writeString("com.tencent.mobileqq.theme.ISwitchCallback");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.theme.ISwitchCallback");
      beginSwitch();
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.theme.ISwitchCallback");
      onProgress(paramParcel1.readLong(), paramParcel1.readLong());
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.theme.ISwitchCallback");
      doSwitch(paramParcel1.readString(), paramParcel1.readString());
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mobileqq.theme.ISwitchCallback");
    postSwitch(paramParcel1.readInt());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdas
 * JD-Core Version:    0.7.0.1
 */