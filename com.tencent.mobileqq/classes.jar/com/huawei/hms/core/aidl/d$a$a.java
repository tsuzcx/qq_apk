package com.huawei.hms.core.aidl;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

class d$a$a
  implements d
{
  public static d b;
  private IBinder a;
  
  d$a$a(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public void a(b paramb, c paramc)
  {
    Parcel localParcel = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel.writeInterfaceToken("com.huawei.hms.core.aidl.IAIDLInvoke");
        if (paramb != null)
        {
          localParcel.writeInt(1);
          paramb.writeToParcel(localParcel, 0);
        }
        else
        {
          localParcel.writeInt(0);
        }
        if (paramc != null)
        {
          localIBinder = paramc.asBinder();
          localParcel.writeStrongBinder(localIBinder);
          if ((!this.a.transact(2, localParcel, null, 1)) && (d.a.a() != null))
          {
            d.a.a().a(paramb, paramc);
            return;
          }
          return;
        }
      }
      finally
      {
        localParcel.recycle();
      }
      IBinder localIBinder = null;
    }
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.core.aidl.d.a.a
 * JD-Core Version:    0.7.0.1
 */