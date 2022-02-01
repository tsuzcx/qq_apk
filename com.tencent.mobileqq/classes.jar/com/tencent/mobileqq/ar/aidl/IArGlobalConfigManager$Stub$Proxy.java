package com.tencent.mobileqq.ar.aidl;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;

class IArGlobalConfigManager$Stub$Proxy
  implements IArGlobalConfigManager
{
  private IBinder a;
  
  public ARScanStarFaceConfigInfo a()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.mobileqq.ar.aidl.IArGlobalConfigManager");
      this.a.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      ARScanStarFaceConfigInfo localARScanStarFaceConfigInfo;
      if (localParcel2.readInt() != 0) {
        localARScanStarFaceConfigInfo = (ARScanStarFaceConfigInfo)ARScanStarFaceConfigInfo.CREATOR.createFromParcel(localParcel2);
      } else {
        localARScanStarFaceConfigInfo = null;
      }
      return localARScanStarFaceConfigInfo;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.aidl.IArGlobalConfigManager.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */