import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class azjn
  extends Binder
  implements azjm
{
  public azjn()
  {
    attachInterface(this, "com.tencent.mobileqq.pic.IPresendPicMgr");
  }
  
  public static azjm a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.pic.IPresendPicMgr");
    if ((localIInterface != null) && ((localIInterface instanceof azjm))) {
      return (azjm)localIInterface;
    }
    return new azjo(paramIBinder);
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
      paramParcel2.writeString("com.tencent.mobileqq.pic.IPresendPicMgr");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.pic.IPresendPicMgr");
      String str1 = paramParcel1.readString();
      String str2 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        a(str1, str2, bool, paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      }
    case 2: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.pic.IPresendPicMgr");
      a(paramParcel1.readString(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.pic.IPresendPicMgr");
      a(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.pic.IPresendPicMgr");
      a();
      paramParcel2.writeNoException();
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.pic.IPresendPicMgr");
      paramInt1 = a();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.tencent.mobileqq.pic.IPresendPicMgr");
      paramParcel1 = a();
      paramParcel2.writeNoException();
      paramParcel2.writeBooleanArray(paramParcel1);
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mobileqq.pic.IPresendPicMgr");
    paramParcel1 = a();
    paramParcel2.writeNoException();
    paramParcel2.writeIntArray(paramParcel1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azjn
 * JD-Core Version:    0.7.0.1
 */