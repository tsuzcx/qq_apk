package com.tencent.intervideo.nowproxy.proxyinner.channel;

import android.os.IBinder;

class IChannelServer$Stub$Proxy
  implements IChannelServer
{
  private IBinder a;
  
  /* Error */
  public void a(int paramInt, ToService paramToService)
  {
    // Byte code:
    //   0: invokestatic 15	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 15	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 17
    //   12: invokevirtual 21	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_3
    //   16: iload_1
    //   17: invokevirtual 25	android/os/Parcel:writeInt	(I)V
    //   20: aload_2
    //   21: ifnull +44 -> 65
    //   24: aload_3
    //   25: iconst_1
    //   26: invokevirtual 25	android/os/Parcel:writeInt	(I)V
    //   29: aload_2
    //   30: aload_3
    //   31: iconst_0
    //   32: invokevirtual 31	com/tencent/intervideo/nowproxy/proxyinner/channel/ToService:writeToParcel	(Landroid/os/Parcel;I)V
    //   35: aload_0
    //   36: getfield 33	com/tencent/intervideo/nowproxy/proxyinner/channel/IChannelServer$Stub$Proxy:a	Landroid/os/IBinder;
    //   39: iconst_2
    //   40: aload_3
    //   41: aload 4
    //   43: iconst_0
    //   44: invokeinterface 39 5 0
    //   49: pop
    //   50: aload 4
    //   52: invokevirtual 43	android/os/Parcel:readException	()V
    //   55: aload 4
    //   57: invokevirtual 46	android/os/Parcel:recycle	()V
    //   60: aload_3
    //   61: invokevirtual 46	android/os/Parcel:recycle	()V
    //   64: return
    //   65: aload_3
    //   66: iconst_0
    //   67: invokevirtual 25	android/os/Parcel:writeInt	(I)V
    //   70: goto -35 -> 35
    //   73: astore_2
    //   74: aload 4
    //   76: invokevirtual 46	android/os/Parcel:recycle	()V
    //   79: aload_3
    //   80: invokevirtual 46	android/os/Parcel:recycle	()V
    //   83: aload_2
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	Proxy
    //   0	85	1	paramInt	int
    //   0	85	2	paramToService	ToService
    //   3	77	3	localParcel1	android.os.Parcel
    //   7	68	4	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   9	20	73	finally
    //   24	35	73	finally
    //   35	55	73	finally
    //   65	70	73	finally
  }
  
  /* Error */
  public void a(IChannelClient paramIChannelClient)
  {
    // Byte code:
    //   0: invokestatic 15	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 15	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 17
    //   11: invokevirtual 21	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +42 -> 57
    //   18: aload_1
    //   19: invokeinterface 54 1 0
    //   24: astore_1
    //   25: aload_2
    //   26: aload_1
    //   27: invokevirtual 58	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   30: aload_0
    //   31: getfield 33	com/tencent/intervideo/nowproxy/proxyinner/channel/IChannelServer$Stub$Proxy:a	Landroid/os/IBinder;
    //   34: iconst_1
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 39 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 43	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 46	android/os/Parcel:recycle	()V
    //   52: aload_2
    //   53: invokevirtual 46	android/os/Parcel:recycle	()V
    //   56: return
    //   57: aconst_null
    //   58: astore_1
    //   59: goto -34 -> 25
    //   62: astore_1
    //   63: aload_3
    //   64: invokevirtual 46	android/os/Parcel:recycle	()V
    //   67: aload_2
    //   68: invokevirtual 46	android/os/Parcel:recycle	()V
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	Proxy
    //   0	73	1	paramIChannelClient	IChannelClient
    //   3	65	2	localParcel1	android.os.Parcel
    //   7	57	3	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	62	finally
    //   18	25	62	finally
    //   25	48	62	finally
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.proxyinner.channel.IChannelServer.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */