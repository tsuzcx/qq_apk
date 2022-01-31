import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.pic.CompressInfo;

public abstract class aurs
  extends Binder
  implements aurr
{
  public aurs()
  {
    attachInterface(this, "com.tencent.mobileqq.richmedia.ICallBack");
  }
  
  public static aurr a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.richmedia.ICallBack");
    if ((localIInterface != null) && ((localIInterface instanceof aurr))) {
      return (aurr)localIInterface;
    }
    return new aurt(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.tencent.mobileqq.richmedia.ICallBack");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.richmedia.ICallBack");
      paramInt1 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      paramParcel1 = a(paramInt1, (Bundle)localObject1);
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
    case 2: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.richmedia.ICallBack");
      localObject1 = localObject2;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (CompressInfo)CompressInfo.CREATOR.createFromParcel(paramParcel1);
      }
      a((CompressInfo)localObject1);
      paramParcel2.writeNoException();
      if (localObject1 != null)
      {
        paramParcel2.writeInt(1);
        ((CompressInfo)localObject1).writeToParcel(paramParcel2, 1);
      }
      for (;;)
      {
        return true;
        paramParcel2.writeInt(0);
      }
    }
    paramParcel1.enforceInterface("com.tencent.mobileqq.richmedia.ICallBack");
    paramInt1 = paramParcel1.readInt();
    localObject1 = localObject3;
    if (paramParcel1.readInt() != 0) {
      localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
    }
    a(paramInt1, (Bundle)localObject1);
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aurs
 * JD-Core Version:    0.7.0.1
 */