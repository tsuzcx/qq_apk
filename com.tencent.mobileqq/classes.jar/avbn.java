import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.nearby.ipc.BasicTypeDataParcel;

public abstract class avbn
  extends Binder
  implements avbm
{
  public avbn()
  {
    attachInterface(this, "com.tencent.mobileqq.nearby.ipc.NearbyProcessInterface");
  }
  
  public static avbm a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.nearby.ipc.NearbyProcessInterface");
    if ((localIInterface != null) && ((localIInterface instanceof avbm))) {
      return (avbm)localIInterface;
    }
    return new avbo(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.mobileqq.nearby.ipc.NearbyProcessInterface");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.nearby.ipc.NearbyProcessInterface");
      if (paramParcel1.readInt() != 0) {
        localObject1 = (BasicTypeDataParcel)BasicTypeDataParcel.CREATOR.createFromParcel(paramParcel1);
      }
      paramParcel1 = a((BasicTypeDataParcel)localObject1);
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
      }
      for (;;)
      {
        return true;
        paramParcel2.writeInt(0);
      }
    }
    paramParcel1.enforceInterface("com.tencent.mobileqq.nearby.ipc.NearbyProcessInterface");
    localObject1 = localObject2;
    if (paramParcel1.readInt() != 0) {
      localObject1 = (Message)Message.CREATOR.createFromParcel(paramParcel1);
    }
    paramParcel1 = a((Message)localObject1);
    paramParcel2.writeNoException();
    if (paramParcel1 != null)
    {
      paramParcel2.writeInt(1);
      paramParcel1.writeToParcel(paramParcel2, 1);
    }
    for (;;)
    {
      return true;
      paramParcel2.writeInt(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avbn
 * JD-Core Version:    0.7.0.1
 */