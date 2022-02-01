package com.tencent.ilinkservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class IIlinkServiceCallback$a
  extends Binder
  implements IIlinkServiceCallback
{
  public IIlinkServiceCallback$a()
  {
    attachInterface(this, "com.tencent.ilinkservice.IIlinkServiceCallback");
  }
  
  public static IIlinkServiceCallback a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.ilinkservice.IIlinkServiceCallback");
    if ((localIInterface != null) && ((localIInterface instanceof IIlinkServiceCallback))) {
      return (IIlinkServiceCallback)localIInterface;
    }
    return new IIlinkServiceCallback.a.a(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    if (paramInt1 != 1598968902)
    {
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 25: 
        paramParcel1.enforceInterface("com.tencent.ilinkservice.IIlinkServiceCallback");
        OnCommonFunctionCallback(paramParcel1.readString(), paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        return true;
      case 24: 
        paramParcel1.enforceInterface("com.tencent.ilinkservice.IIlinkServiceCallback");
        OnRequestUploadLogfiles(paramParcel1.readString(), paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        return true;
      case 23: 
        paramParcel1.enforceInterface("com.tencent.ilinkservice.IIlinkServiceCallback");
        onNewLoginComplete(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.createByteArray(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 22: 
        paramParcel1.enforceInterface("com.tencent.ilinkservice.IIlinkServiceCallback");
        onNetStatusChanged(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 21: 
        paramParcel1.enforceInterface("com.tencent.ilinkservice.IIlinkServiceCallback");
        onCancelOAuthComplete(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 20: 
        paramParcel1.enforceInterface("com.tencent.ilinkservice.IIlinkServiceCallback");
        onGetOAuthCodeComplete(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        return true;
      case 19: 
        paramParcel1.enforceInterface("com.tencent.ilinkservice.IIlinkServiceCallback");
        onFinishGetStrategy();
        paramParcel2.writeNoException();
        return true;
      case 18: 
        paramParcel1.enforceInterface("com.tencent.ilinkservice.IIlinkServiceCallback");
        onNewGetAppPushTokenComplete(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        return true;
      case 17: 
        paramParcel1.enforceInterface("com.tencent.ilinkservice.IIlinkServiceCallback");
        onGetAppPushTokenComplete(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        return true;
      case 16: 
        paramParcel1.enforceInterface("com.tencent.ilinkservice.IIlinkServiceCallback");
        onReceiveMessage(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 15: 
        paramParcel1.enforceInterface("com.tencent.ilinkservice.IIlinkServiceCallback");
        onSendMsgResult(paramParcel1.readInt(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 14: 
        paramParcel1.enforceInterface("com.tencent.ilinkservice.IIlinkServiceCallback");
        onLoginComplete(paramParcel1.readInt(), paramParcel1.createByteArray(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 13: 
        paramParcel1.enforceInterface("com.tencent.ilinkservice.IIlinkServiceCallback");
        onFaceRecognizeConfigComplete(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        return true;
      case 12: 
        paramParcel1.enforceInterface("com.tencent.ilinkservice.IIlinkServiceCallback");
        onAppSessionTimeout(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 11: 
        paramParcel1.enforceInterface("com.tencent.ilinkservice.IIlinkServiceCallback");
        onReceiveAppMessage(paramParcel1.readString(), paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.tencent.ilinkservice.IIlinkServiceCallback");
        onReceiveAppResponse(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.tencent.ilinkservice.IIlinkServiceCallback");
        onCheckLoginQrCode(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.tencent.ilinkservice.IIlinkServiceCallback");
        onGetLoginQrCodeComplete(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.tencent.ilinkservice.IIlinkServiceCallback");
        onLogoutComplete(paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.tencent.ilinkservice.IIlinkServiceCallback");
        onTdiLoginComplete(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.tencent.ilinkservice.IIlinkServiceCallback");
        onFaceExtVerifyComplete(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.ilinkservice.IIlinkServiceCallback");
        onFaceRecognizeComplete(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.ilinkservice.IIlinkServiceCallback");
        onDestroyMultiProcessTdiSession(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.ilinkservice.IIlinkServiceCallback");
        onCloneMultiProcessTdiSession(paramParcel1.readInt(), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.ilinkservice.IIlinkServiceCallback");
      onReceiveMultiProcessCloneTicket(paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel2.writeString("com.tencent.ilinkservice.IIlinkServiceCallback");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilinkservice.IIlinkServiceCallback.a
 * JD-Core Version:    0.7.0.1
 */