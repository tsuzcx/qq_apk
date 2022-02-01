package com.tencent.mobileqq.activity.aio.photo;

import android.os.IBinder;

class IAIOImageProviderCallBack$Stub$Proxy
  implements IAIOImageProviderCallBack
{
  private IBinder a;
  
  IAIOImageProviderCallBack$Stub$Proxy(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: invokestatic 24	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_1
    //   4: aload_1
    //   5: ldc 26
    //   7: invokevirtual 30	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   10: aload_0
    //   11: getfield 15	com/tencent/mobileqq/activity/aio/photo/IAIOImageProviderCallBack$Stub$Proxy:a	Landroid/os/IBinder;
    //   14: iconst_4
    //   15: aload_1
    //   16: aconst_null
    //   17: iconst_1
    //   18: invokeinterface 36 5 0
    //   23: pop
    //   24: goto +10 -> 34
    //   27: astore_2
    //   28: aload_1
    //   29: invokevirtual 39	android/os/Parcel:recycle	()V
    //   32: aload_2
    //   33: athrow
    //   34: aload_1
    //   35: invokevirtual 39	android/os/Parcel:recycle	()V
    //   38: return
    //   39: astore_2
    //   40: goto -6 -> 34
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	Proxy
    //   3	32	1	localParcel	android.os.Parcel
    //   27	6	2	localObject	Object
    //   39	1	2	localRemoteException	android.os.RemoteException
    // Exception table:
    //   from	to	target	type
    //   4	24	27	finally
    //   4	24	39	android/os/RemoteException
  }
  
  /* Error */
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 24	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 9
    //   5: aload 9
    //   7: ldc 26
    //   9: invokevirtual 30	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   12: aload 9
    //   14: lload_1
    //   15: invokevirtual 44	android/os/Parcel:writeLong	(J)V
    //   18: aload 9
    //   20: iload_3
    //   21: invokevirtual 48	android/os/Parcel:writeInt	(I)V
    //   24: aload 9
    //   26: iload 4
    //   28: invokevirtual 48	android/os/Parcel:writeInt	(I)V
    //   31: aload 9
    //   33: iload 5
    //   35: invokevirtual 48	android/os/Parcel:writeInt	(I)V
    //   38: aload 9
    //   40: lload 6
    //   42: invokevirtual 44	android/os/Parcel:writeLong	(J)V
    //   45: iload 8
    //   47: ifeq +73 -> 120
    //   50: iconst_1
    //   51: istore_3
    //   52: goto +3 -> 55
    //   55: aload 9
    //   57: iload_3
    //   58: i2b
    //   59: invokevirtual 52	android/os/Parcel:writeByte	(B)V
    //   62: aload_0
    //   63: getfield 15	com/tencent/mobileqq/activity/aio/photo/IAIOImageProviderCallBack$Stub$Proxy:a	Landroid/os/IBinder;
    //   66: iconst_3
    //   67: aload 9
    //   69: aconst_null
    //   70: iconst_1
    //   71: invokeinterface 36 5 0
    //   76: pop
    //   77: goto +29 -> 106
    //   80: astore 10
    //   82: goto +30 -> 112
    //   85: astore 10
    //   87: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   90: ifeq +16 -> 106
    //   93: ldc 60
    //   95: iconst_2
    //   96: aload 10
    //   98: invokevirtual 64	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   101: aload 10
    //   103: invokestatic 68	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   106: aload 9
    //   108: invokevirtual 39	android/os/Parcel:recycle	()V
    //   111: return
    //   112: aload 9
    //   114: invokevirtual 39	android/os/Parcel:recycle	()V
    //   117: aload 10
    //   119: athrow
    //   120: iconst_0
    //   121: istore_3
    //   122: goto -67 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	Proxy
    //   0	125	1	paramLong1	long
    //   0	125	3	paramInt1	int
    //   0	125	4	paramInt2	int
    //   0	125	5	paramInt3	int
    //   0	125	6	paramLong2	long
    //   0	125	8	paramBoolean	boolean
    //   3	110	9	localParcel	android.os.Parcel
    //   80	1	10	localObject	Object
    //   85	33	10	localRemoteException	android.os.RemoteException
    // Exception table:
    //   from	to	target	type
    //   5	45	80	finally
    //   55	77	80	finally
    //   87	106	80	finally
    //   5	45	85	android/os/RemoteException
    //   55	77	85	android/os/RemoteException
  }
  
  /* Error */
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, java.lang.String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 24	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 8
    //   5: aload 8
    //   7: ldc 26
    //   9: invokevirtual 30	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   12: aload 8
    //   14: lload_1
    //   15: invokevirtual 44	android/os/Parcel:writeLong	(J)V
    //   18: aload 8
    //   20: iload_3
    //   21: invokevirtual 48	android/os/Parcel:writeInt	(I)V
    //   24: aload 8
    //   26: iload 4
    //   28: invokevirtual 48	android/os/Parcel:writeInt	(I)V
    //   31: aload 8
    //   33: iload 5
    //   35: invokevirtual 48	android/os/Parcel:writeInt	(I)V
    //   38: aload 8
    //   40: aload 6
    //   42: invokevirtual 72	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   45: iload 7
    //   47: ifeq +73 -> 120
    //   50: iconst_1
    //   51: istore_3
    //   52: goto +3 -> 55
    //   55: aload 8
    //   57: iload_3
    //   58: i2b
    //   59: invokevirtual 52	android/os/Parcel:writeByte	(B)V
    //   62: aload_0
    //   63: getfield 15	com/tencent/mobileqq/activity/aio/photo/IAIOImageProviderCallBack$Stub$Proxy:a	Landroid/os/IBinder;
    //   66: iconst_1
    //   67: aload 8
    //   69: aconst_null
    //   70: iconst_1
    //   71: invokeinterface 36 5 0
    //   76: pop
    //   77: goto +29 -> 106
    //   80: astore 6
    //   82: goto +30 -> 112
    //   85: astore 6
    //   87: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   90: ifeq +16 -> 106
    //   93: ldc 60
    //   95: iconst_2
    //   96: aload 6
    //   98: invokevirtual 64	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   101: aload 6
    //   103: invokestatic 68	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   106: aload 8
    //   108: invokevirtual 39	android/os/Parcel:recycle	()V
    //   111: return
    //   112: aload 8
    //   114: invokevirtual 39	android/os/Parcel:recycle	()V
    //   117: aload 6
    //   119: athrow
    //   120: iconst_0
    //   121: istore_3
    //   122: goto -67 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	Proxy
    //   0	125	1	paramLong	long
    //   0	125	3	paramInt1	int
    //   0	125	4	paramInt2	int
    //   0	125	5	paramInt3	int
    //   0	125	6	paramString	java.lang.String
    //   0	125	7	paramBoolean	boolean
    //   3	110	8	localParcel	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   5	45	80	finally
    //   55	77	80	finally
    //   87	106	80	finally
    //   5	45	85	android/os/RemoteException
    //   55	77	85	android/os/RemoteException
  }
  
  /* Error */
  public void a(long paramLong, int paramInt1, int paramInt2, java.lang.String paramString1, java.lang.String[] paramArrayOfString, java.lang.String paramString2, com.tencent.mobileqq.data.MessageForShortVideo paramMessageForShortVideo, int paramInt3, android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 60
    //   8: iconst_2
    //   9: ldc 75
    //   11: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: invokestatic 24	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   17: astore 11
    //   19: aload 11
    //   21: ldc 26
    //   23: invokevirtual 30	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   26: aload 11
    //   28: lload_1
    //   29: invokevirtual 44	android/os/Parcel:writeLong	(J)V
    //   32: aload 11
    //   34: iload_3
    //   35: invokevirtual 48	android/os/Parcel:writeInt	(I)V
    //   38: aload 11
    //   40: iload 4
    //   42: invokevirtual 48	android/os/Parcel:writeInt	(I)V
    //   45: aload 11
    //   47: aload 5
    //   49: invokevirtual 72	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   52: aload 6
    //   54: ifnull +39 -> 93
    //   57: aload 6
    //   59: arraylength
    //   60: istore 4
    //   62: aload 11
    //   64: iload 4
    //   66: invokevirtual 48	android/os/Parcel:writeInt	(I)V
    //   69: iconst_0
    //   70: istore_3
    //   71: iload_3
    //   72: iload 4
    //   74: if_icmpge +25 -> 99
    //   77: aload 11
    //   79: aload 6
    //   81: iload_3
    //   82: aaload
    //   83: invokevirtual 72	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   86: iload_3
    //   87: iconst_1
    //   88: iadd
    //   89: istore_3
    //   90: goto -19 -> 71
    //   93: aload 11
    //   95: iconst_m1
    //   96: invokevirtual 48	android/os/Parcel:writeInt	(I)V
    //   99: aload 11
    //   101: aload 7
    //   103: invokevirtual 72	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   106: aload 11
    //   108: aload 8
    //   110: iconst_0
    //   111: invokevirtual 83	android/os/Parcel:writeParcelable	(Landroid/os/Parcelable;I)V
    //   114: aload 11
    //   116: iload 9
    //   118: invokevirtual 48	android/os/Parcel:writeInt	(I)V
    //   121: aload 11
    //   123: aload 10
    //   125: invokevirtual 87	android/os/Parcel:writeBundle	(Landroid/os/Bundle;)V
    //   128: aload_0
    //   129: getfield 15	com/tencent/mobileqq/activity/aio/photo/IAIOImageProviderCallBack$Stub$Proxy:a	Landroid/os/IBinder;
    //   132: iconst_5
    //   133: aload 11
    //   135: aconst_null
    //   136: iconst_1
    //   137: invokeinterface 36 5 0
    //   142: pop
    //   143: goto +29 -> 172
    //   146: astore 5
    //   148: goto +30 -> 178
    //   151: astore 5
    //   153: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq +16 -> 172
    //   159: ldc 60
    //   161: iconst_2
    //   162: aload 5
    //   164: invokevirtual 64	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   167: aload 5
    //   169: invokestatic 68	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   172: aload 11
    //   174: invokevirtual 39	android/os/Parcel:recycle	()V
    //   177: return
    //   178: aload 11
    //   180: invokevirtual 39	android/os/Parcel:recycle	()V
    //   183: goto +6 -> 189
    //   186: aload 5
    //   188: athrow
    //   189: goto -3 -> 186
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	this	Proxy
    //   0	192	1	paramLong	long
    //   0	192	3	paramInt1	int
    //   0	192	4	paramInt2	int
    //   0	192	5	paramString1	java.lang.String
    //   0	192	6	paramArrayOfString	java.lang.String[]
    //   0	192	7	paramString2	java.lang.String
    //   0	192	8	paramMessageForShortVideo	com.tencent.mobileqq.data.MessageForShortVideo
    //   0	192	9	paramInt3	int
    //   0	192	10	paramBundle	android.os.Bundle
    //   17	162	11	localParcel	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   19	52	146	finally
    //   57	69	146	finally
    //   77	86	146	finally
    //   93	99	146	finally
    //   99	143	146	finally
    //   153	172	146	finally
    //   19	52	151	android/os/RemoteException
    //   57	69	151	android/os/RemoteException
    //   77	86	151	android/os/RemoteException
    //   93	99	151	android/os/RemoteException
    //   99	143	151	android/os/RemoteException
  }
  
  /* Error */
  public void a(AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 24	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: aload_3
    //   5: ldc 26
    //   7: invokevirtual 30	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   10: aload_3
    //   11: aload_1
    //   12: iconst_0
    //   13: invokevirtual 92	android/os/Parcel:writeTypedArray	([Landroid/os/Parcelable;I)V
    //   16: aload_3
    //   17: iload_2
    //   18: invokevirtual 48	android/os/Parcel:writeInt	(I)V
    //   21: aload_0
    //   22: getfield 15	com/tencent/mobileqq/activity/aio/photo/IAIOImageProviderCallBack$Stub$Proxy:a	Landroid/os/IBinder;
    //   25: iconst_2
    //   26: aload_3
    //   27: aconst_null
    //   28: iconst_1
    //   29: invokeinterface 36 5 0
    //   34: pop
    //   35: goto +25 -> 60
    //   38: astore_1
    //   39: goto +26 -> 65
    //   42: astore_1
    //   43: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   46: ifeq +14 -> 60
    //   49: ldc 60
    //   51: iconst_2
    //   52: aload_1
    //   53: invokevirtual 64	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   56: aload_1
    //   57: invokestatic 68	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   60: aload_3
    //   61: invokevirtual 39	android/os/Parcel:recycle	()V
    //   64: return
    //   65: aload_3
    //   66: invokevirtual 39	android/os/Parcel:recycle	()V
    //   69: aload_1
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	Proxy
    //   0	71	1	paramArrayOfAIORichMediaData	AIORichMediaData[]
    //   0	71	2	paramInt	int
    //   3	63	3	localParcel	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   4	35	38	finally
    //   43	60	38	finally
    //   4	35	42	android/os/RemoteException
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */