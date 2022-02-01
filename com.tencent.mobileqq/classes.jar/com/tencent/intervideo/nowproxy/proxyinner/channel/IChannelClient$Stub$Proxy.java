package com.tencent.intervideo.nowproxy.proxyinner.channel;

import android.os.IBinder;
import android.os.Parcel;

class IChannelClient$Stub$Proxy
  implements IChannelClient
{
  private IBinder a;
  
  IChannelClient$Stub$Proxy(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public String a()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.intervideo.nowproxy.proxyinner.channel.IChannelClient");
      this.a.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      String str = localParcel2.readString();
      return str;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public void a(int paramInt, FromService paramFromService)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 25
    //   12: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_3
    //   16: iload_1
    //   17: invokevirtual 49	android/os/Parcel:writeInt	(I)V
    //   20: aload_2
    //   21: ifnull +44 -> 65
    //   24: aload_3
    //   25: iconst_1
    //   26: invokevirtual 49	android/os/Parcel:writeInt	(I)V
    //   29: aload_2
    //   30: aload_3
    //   31: iconst_0
    //   32: invokevirtual 55	com/tencent/intervideo/nowproxy/proxyinner/channel/FromService:writeToParcel	(Landroid/os/Parcel;I)V
    //   35: aload_0
    //   36: getfield 15	com/tencent/intervideo/nowproxy/proxyinner/channel/IChannelClient$Stub$Proxy:a	Landroid/os/IBinder;
    //   39: iconst_1
    //   40: aload_3
    //   41: aload 4
    //   43: iconst_0
    //   44: invokeinterface 35 5 0
    //   49: pop
    //   50: aload 4
    //   52: invokevirtual 38	android/os/Parcel:readException	()V
    //   55: aload 4
    //   57: invokevirtual 44	android/os/Parcel:recycle	()V
    //   60: aload_3
    //   61: invokevirtual 44	android/os/Parcel:recycle	()V
    //   64: return
    //   65: aload_3
    //   66: iconst_0
    //   67: invokevirtual 49	android/os/Parcel:writeInt	(I)V
    //   70: goto -35 -> 35
    //   73: astore_2
    //   74: aload 4
    //   76: invokevirtual 44	android/os/Parcel:recycle	()V
    //   79: aload_3
    //   80: invokevirtual 44	android/os/Parcel:recycle	()V
    //   83: aload_2
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	Proxy
    //   0	85	1	paramInt	int
    //   0	85	2	paramFromService	FromService
    //   3	77	3	localParcel1	Parcel
    //   7	68	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	20	73	finally
    //   24	35	73	finally
    //   35	55	73	finally
    //   65	70	73	finally
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.proxyinner.channel.IChannelClient.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */