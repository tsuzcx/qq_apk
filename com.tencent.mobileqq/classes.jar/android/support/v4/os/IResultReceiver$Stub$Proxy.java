package android.support.v4.os;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

class IResultReceiver$Stub$Proxy
  implements IResultReceiver
{
  public static IResultReceiver sDefaultImpl;
  private IBinder mRemote;
  
  IResultReceiver$Stub$Proxy(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public String getInterfaceDescriptor()
  {
    return "android.support.v4.os.IResultReceiver";
  }
  
  public void send(int paramInt, Bundle paramBundle)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("android.support.v4.os.IResultReceiver");
      localParcel.writeInt(paramInt);
      if (paramBundle != null)
      {
        localParcel.writeInt(1);
        paramBundle.writeToParcel(localParcel, 0);
      }
      else
      {
        localParcel.writeInt(0);
      }
      if ((!this.mRemote.transact(1, localParcel, null, 1)) && (IResultReceiver.Stub.getDefaultImpl() != null))
      {
        IResultReceiver.Stub.getDefaultImpl().send(paramInt, paramBundle);
        return;
      }
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.os.IResultReceiver.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */