import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public abstract class bepq
  extends Binder
  implements bepp
{
  public bepq()
  {
    attachInterface(this, "com.tencent.qqmini.sdk.ipc.IAppMainService");
  }
  
  public static bepp a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.qqmini.sdk.ipc.IAppMainService");
    if ((localIInterface != null) && ((localIInterface instanceof bepp))) {
      return (bepp)localIInterface;
    }
    return new bepr(paramIBinder);
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
      paramParcel2.writeString("com.tencent.qqmini.sdk.ipc.IAppMainService");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.qqmini.sdk.ipc.IAppMainService");
      a();
      paramParcel2.writeNoException();
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.tencent.qqmini.sdk.ipc.IAppMainService");
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = (MiniAppInfo)MiniAppInfo.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label191;
        }
        localObject2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label197;
        }
      }
      for (paramParcel1 = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a((MiniAppInfo)localObject1, (Bundle)localObject2, paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localObject1 = null;
        break;
        localObject2 = null;
        break label150;
      }
    case 3: 
      paramParcel1.enforceInterface("com.tencent.qqmini.sdk.ipc.IAppMainService");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (MiniAppInfo)MiniAppInfo.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 4: 
      paramParcel1.enforceInterface("com.tencent.qqmini.sdk.ipc.IAppMainService");
      paramInt1 = paramParcel1.readInt();
      localObject2 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = (MiniAppInfo)MiniAppInfo.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label324;
        }
      }
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(paramInt1, (String)localObject2, (MiniAppInfo)localObject1, paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localObject1 = null;
        break;
      }
    case 5: 
      label150:
      label191:
      label197:
      paramParcel1.enforceInterface("com.tencent.qqmini.sdk.ipc.IAppMainService");
      label324:
      localObject2 = paramParcel1.readString();
      String str = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; localObject1 = null)
      {
        a((String)localObject2, str, (Bundle)localObject1, bepv.a(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      }
    }
    paramParcel1.enforceInterface("com.tencent.qqmini.sdk.ipc.IAppMainService");
    Object localObject1 = paramParcel1.readString();
    Object localObject2 = paramParcel1.readString();
    if (paramParcel1.readInt() != 0)
    {
      paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      paramParcel1 = a((String)localObject1, (String)localObject2, paramParcel1);
      paramParcel2.writeNoException();
      if (paramParcel1 == null) {
        break label471;
      }
      paramParcel2.writeInt(1);
      paramParcel1.writeToParcel(paramParcel2, 1);
    }
    for (;;)
    {
      return true;
      paramParcel1 = null;
      break;
      label471:
      paramParcel2.writeInt(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bepq
 * JD-Core Version:    0.7.0.1
 */