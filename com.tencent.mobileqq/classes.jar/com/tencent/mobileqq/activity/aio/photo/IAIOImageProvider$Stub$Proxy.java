package com.tencent.mobileqq.activity.aio.photo;

import android.os.IBinder;

class IAIOImageProvider$Stub$Proxy
  implements IAIOImageProvider
{
  private IBinder a;
  
  IAIOImageProvider$Stub$Proxy(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  /* Error */
  public int a(long paramLong, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 4
    //   5: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 5
    //   10: aload 4
    //   12: ldc 27
    //   14: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload 4
    //   19: lload_1
    //   20: invokevirtual 35	android/os/Parcel:writeLong	(J)V
    //   23: aload 4
    //   25: iload_3
    //   26: invokevirtual 39	android/os/Parcel:writeInt	(I)V
    //   29: aload_0
    //   30: getfield 15	com/tencent/mobileqq/activity/aio/photo/IAIOImageProvider$Stub$Proxy:a	Landroid/os/IBinder;
    //   33: bipush 19
    //   35: aload 4
    //   37: aload 5
    //   39: iconst_0
    //   40: invokeinterface 45 5 0
    //   45: pop
    //   46: aload 5
    //   48: invokevirtual 48	android/os/Parcel:readException	()V
    //   51: aload 5
    //   53: invokevirtual 52	android/os/Parcel:readInt	()I
    //   56: istore_3
    //   57: aload 5
    //   59: invokevirtual 55	android/os/Parcel:recycle	()V
    //   62: aload 4
    //   64: invokevirtual 55	android/os/Parcel:recycle	()V
    //   67: iload_3
    //   68: ireturn
    //   69: astore 6
    //   71: goto +33 -> 104
    //   74: astore 6
    //   76: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   79: ifeq +13 -> 92
    //   82: ldc 63
    //   84: iconst_2
    //   85: ldc 65
    //   87: aload 6
    //   89: invokestatic 69	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   92: aload 5
    //   94: invokevirtual 55	android/os/Parcel:recycle	()V
    //   97: aload 4
    //   99: invokevirtual 55	android/os/Parcel:recycle	()V
    //   102: iconst_m1
    //   103: ireturn
    //   104: aload 5
    //   106: invokevirtual 55	android/os/Parcel:recycle	()V
    //   109: aload 4
    //   111: invokevirtual 55	android/os/Parcel:recycle	()V
    //   114: aload 6
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	Proxy
    //   0	117	1	paramLong	long
    //   0	117	3	paramInt	int
    //   3	107	4	localParcel1	android.os.Parcel
    //   8	97	5	localParcel2	android.os.Parcel
    //   69	1	6	localObject	Object
    //   74	41	6	localRemoteException	android.os.RemoteException
    // Exception table:
    //   from	to	target	type
    //   10	57	69	finally
    //   76	92	69	finally
    //   10	57	74	android/os/RemoteException
  }
  
  /* Error */
  public java.lang.String a(java.lang.String paramString1, java.lang.String paramString2)
  {
    // Byte code:
    //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 27
    //   12: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_3
    //   16: aload_1
    //   17: invokevirtual 73	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   20: aload_3
    //   21: aload_2
    //   22: invokevirtual 73	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   25: aload_0
    //   26: getfield 15	com/tencent/mobileqq/activity/aio/photo/IAIOImageProvider$Stub$Proxy:a	Landroid/os/IBinder;
    //   29: bipush 22
    //   31: aload_3
    //   32: aload 4
    //   34: iconst_0
    //   35: invokeinterface 45 5 0
    //   40: pop
    //   41: aload 4
    //   43: invokevirtual 48	android/os/Parcel:readException	()V
    //   46: aload 4
    //   48: invokevirtual 77	android/os/Parcel:readString	()Ljava/lang/String;
    //   51: astore_1
    //   52: aload 4
    //   54: invokevirtual 55	android/os/Parcel:recycle	()V
    //   57: aload_3
    //   58: invokevirtual 55	android/os/Parcel:recycle	()V
    //   61: aload_1
    //   62: areturn
    //   63: astore_1
    //   64: goto +31 -> 95
    //   67: astore_1
    //   68: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   71: ifeq +12 -> 83
    //   74: ldc 63
    //   76: iconst_2
    //   77: ldc 79
    //   79: aload_1
    //   80: invokestatic 69	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   83: aload 4
    //   85: invokevirtual 55	android/os/Parcel:recycle	()V
    //   88: aload_3
    //   89: invokevirtual 55	android/os/Parcel:recycle	()V
    //   92: ldc 81
    //   94: areturn
    //   95: aload 4
    //   97: invokevirtual 55	android/os/Parcel:recycle	()V
    //   100: aload_3
    //   101: invokevirtual 55	android/os/Parcel:recycle	()V
    //   104: aload_1
    //   105: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	Proxy
    //   0	106	1	paramString1	java.lang.String
    //   0	106	2	paramString2	java.lang.String
    //   3	98	3	localParcel1	android.os.Parcel
    //   7	89	4	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   9	52	63	finally
    //   68	83	63	finally
    //   9	52	67	android/os/RemoteException
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_1
    //   4: aload_1
    //   5: ldc 27
    //   7: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   10: aload_0
    //   11: getfield 15	com/tencent/mobileqq/activity/aio/photo/IAIOImageProvider$Stub$Proxy:a	Landroid/os/IBinder;
    //   14: bipush 6
    //   16: aload_1
    //   17: aconst_null
    //   18: iconst_1
    //   19: invokeinterface 45 5 0
    //   24: pop
    //   25: goto +25 -> 50
    //   28: astore_2
    //   29: goto +26 -> 55
    //   32: astore_2
    //   33: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq +14 -> 50
    //   39: ldc 63
    //   41: iconst_2
    //   42: aload_2
    //   43: invokevirtual 84	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   46: aload_2
    //   47: invokestatic 69	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   50: aload_1
    //   51: invokevirtual 55	android/os/Parcel:recycle	()V
    //   54: return
    //   55: aload_1
    //   56: invokevirtual 55	android/os/Parcel:recycle	()V
    //   59: aload_2
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	Proxy
    //   3	53	1	localParcel	android.os.Parcel
    //   28	1	2	localObject	Object
    //   32	28	2	localRemoteException	android.os.RemoteException
    // Exception table:
    //   from	to	target	type
    //   4	25	28	finally
    //   33	50	28	finally
    //   4	25	32	android/os/RemoteException
  }
  
  /* Error */
  public void a(int paramInt)
  {
    // Byte code:
    //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: aload_2
    //   5: ldc 27
    //   7: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   10: aload_2
    //   11: iload_1
    //   12: invokevirtual 39	android/os/Parcel:writeInt	(I)V
    //   15: aload_0
    //   16: getfield 15	com/tencent/mobileqq/activity/aio/photo/IAIOImageProvider$Stub$Proxy:a	Landroid/os/IBinder;
    //   19: iconst_3
    //   20: aload_2
    //   21: aconst_null
    //   22: iconst_1
    //   23: invokeinterface 45 5 0
    //   28: pop
    //   29: goto +25 -> 54
    //   32: astore_3
    //   33: goto +26 -> 59
    //   36: astore_3
    //   37: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   40: ifeq +14 -> 54
    //   43: ldc 63
    //   45: iconst_2
    //   46: aload_3
    //   47: invokevirtual 84	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   50: aload_3
    //   51: invokestatic 69	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   54: aload_2
    //   55: invokevirtual 55	android/os/Parcel:recycle	()V
    //   58: return
    //   59: aload_2
    //   60: invokevirtual 55	android/os/Parcel:recycle	()V
    //   63: aload_3
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	Proxy
    //   0	65	1	paramInt	int
    //   3	57	2	localParcel	android.os.Parcel
    //   32	1	3	localObject	Object
    //   36	28	3	localRemoteException	android.os.RemoteException
    // Exception table:
    //   from	to	target	type
    //   4	29	32	finally
    //   37	54	32	finally
    //   4	29	36	android/os/RemoteException
  }
  
  /* Error */
  public void a(int paramInt, boolean paramBoolean, java.lang.String paramString1, java.lang.String paramString2, java.lang.String paramString3, java.lang.String paramString4)
  {
    // Byte code:
    //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 7
    //   5: aload 7
    //   7: ldc 27
    //   9: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   12: aload 7
    //   14: iload_1
    //   15: invokevirtual 39	android/os/Parcel:writeInt	(I)V
    //   18: iload_2
    //   19: ifeq +93 -> 112
    //   22: iconst_1
    //   23: istore_1
    //   24: goto +3 -> 27
    //   27: aload 7
    //   29: iload_1
    //   30: invokevirtual 39	android/os/Parcel:writeInt	(I)V
    //   33: aload 7
    //   35: aload_3
    //   36: invokevirtual 73	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   39: aload 7
    //   41: aload 4
    //   43: invokevirtual 73	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   46: aload 7
    //   48: aload 5
    //   50: invokevirtual 73	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   53: aload 7
    //   55: aload 6
    //   57: invokevirtual 73	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   60: aload_0
    //   61: getfield 15	com/tencent/mobileqq/activity/aio/photo/IAIOImageProvider$Stub$Proxy:a	Landroid/os/IBinder;
    //   64: bipush 23
    //   66: aload 7
    //   68: aconst_null
    //   69: iconst_1
    //   70: invokeinterface 45 5 0
    //   75: pop
    //   76: goto +23 -> 99
    //   79: astore_3
    //   80: goto +25 -> 105
    //   83: astore_3
    //   84: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   87: ifeq +12 -> 99
    //   90: ldc 63
    //   92: iconst_2
    //   93: ldc 87
    //   95: aload_3
    //   96: invokestatic 69	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   99: aload 7
    //   101: invokevirtual 55	android/os/Parcel:recycle	()V
    //   104: return
    //   105: aload 7
    //   107: invokevirtual 55	android/os/Parcel:recycle	()V
    //   110: aload_3
    //   111: athrow
    //   112: iconst_0
    //   113: istore_1
    //   114: goto -87 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	Proxy
    //   0	117	1	paramInt	int
    //   0	117	2	paramBoolean	boolean
    //   0	117	3	paramString1	java.lang.String
    //   0	117	4	paramString2	java.lang.String
    //   0	117	5	paramString3	java.lang.String
    //   0	117	6	paramString4	java.lang.String
    //   3	103	7	localParcel	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   5	18	79	finally
    //   27	76	79	finally
    //   84	99	79	finally
    //   5	18	83	android/os/RemoteException
    //   27	76	83	android/os/RemoteException
  }
  
  /* Error */
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 5
    //   5: aload 5
    //   7: ldc 27
    //   9: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   12: aload 5
    //   14: lload_1
    //   15: invokevirtual 35	android/os/Parcel:writeLong	(J)V
    //   18: aload 5
    //   20: iload_3
    //   21: invokevirtual 39	android/os/Parcel:writeInt	(I)V
    //   24: aload 5
    //   26: iload 4
    //   28: invokevirtual 39	android/os/Parcel:writeInt	(I)V
    //   31: aload_0
    //   32: getfield 15	com/tencent/mobileqq/activity/aio/photo/IAIOImageProvider$Stub$Proxy:a	Landroid/os/IBinder;
    //   35: iconst_1
    //   36: aload 5
    //   38: aconst_null
    //   39: iconst_1
    //   40: invokeinterface 45 5 0
    //   45: pop
    //   46: goto +29 -> 75
    //   49: astore 6
    //   51: goto +30 -> 81
    //   54: astore 6
    //   56: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +16 -> 75
    //   62: ldc 63
    //   64: iconst_2
    //   65: aload 6
    //   67: invokevirtual 84	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   70: aload 6
    //   72: invokestatic 69	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   75: aload 5
    //   77: invokevirtual 55	android/os/Parcel:recycle	()V
    //   80: return
    //   81: aload 5
    //   83: invokevirtual 55	android/os/Parcel:recycle	()V
    //   86: aload 6
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	Proxy
    //   0	89	1	paramLong	long
    //   0	89	3	paramInt1	int
    //   0	89	4	paramInt2	int
    //   3	79	5	localParcel	android.os.Parcel
    //   49	1	6	localObject	Object
    //   54	33	6	localRemoteException	android.os.RemoteException
    // Exception table:
    //   from	to	target	type
    //   5	46	49	finally
    //   56	75	49	finally
    //   5	46	54	android/os/RemoteException
  }
  
  /* Error */
  public void a(long paramLong, int paramInt, android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 5
    //   5: aload 5
    //   7: ldc 27
    //   9: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   12: aload 5
    //   14: lload_1
    //   15: invokevirtual 35	android/os/Parcel:writeLong	(J)V
    //   18: aload 5
    //   20: iload_3
    //   21: invokevirtual 39	android/os/Parcel:writeInt	(I)V
    //   24: aload 5
    //   26: aload 4
    //   28: invokevirtual 93	android/os/Parcel:writeBundle	(Landroid/os/Bundle;)V
    //   31: aload_0
    //   32: getfield 15	com/tencent/mobileqq/activity/aio/photo/IAIOImageProvider$Stub$Proxy:a	Landroid/os/IBinder;
    //   35: bipush 16
    //   37: aload 5
    //   39: aconst_null
    //   40: iconst_1
    //   41: invokeinterface 45 5 0
    //   46: pop
    //   47: goto +13 -> 60
    //   50: astore 4
    //   52: aload 5
    //   54: invokevirtual 55	android/os/Parcel:recycle	()V
    //   57: aload 4
    //   59: athrow
    //   60: aload 5
    //   62: invokevirtual 55	android/os/Parcel:recycle	()V
    //   65: return
    //   66: astore 4
    //   68: goto -8 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	Proxy
    //   0	71	1	paramLong	long
    //   0	71	3	paramInt	int
    //   0	71	4	paramBundle	android.os.Bundle
    //   3	58	5	localParcel	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   5	47	50	finally
    //   5	47	66	android/os/RemoteException
  }
  
  /* Error */
  public void a(IAIOImageProviderCallBack paramIAIOImageProviderCallBack)
  {
    // Byte code:
    //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: aload_2
    //   5: ldc 27
    //   7: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   10: aload_1
    //   11: ifnull +68 -> 79
    //   14: aload_1
    //   15: invokeinterface 100 1 0
    //   20: astore_1
    //   21: goto +3 -> 24
    //   24: aload_2
    //   25: aload_1
    //   26: invokevirtual 103	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   29: aload_0
    //   30: getfield 15	com/tencent/mobileqq/activity/aio/photo/IAIOImageProvider$Stub$Proxy:a	Landroid/os/IBinder;
    //   33: iconst_4
    //   34: aload_2
    //   35: aconst_null
    //   36: iconst_1
    //   37: invokeinterface 45 5 0
    //   42: pop
    //   43: goto +25 -> 68
    //   46: astore_1
    //   47: goto +26 -> 73
    //   50: astore_1
    //   51: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   54: ifeq +14 -> 68
    //   57: ldc 63
    //   59: iconst_2
    //   60: aload_1
    //   61: invokevirtual 84	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   64: aload_1
    //   65: invokestatic 69	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   68: aload_2
    //   69: invokevirtual 55	android/os/Parcel:recycle	()V
    //   72: return
    //   73: aload_2
    //   74: invokevirtual 55	android/os/Parcel:recycle	()V
    //   77: aload_1
    //   78: athrow
    //   79: aconst_null
    //   80: astore_1
    //   81: goto -57 -> 24
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	Proxy
    //   0	84	1	paramIAIOImageProviderCallBack	IAIOImageProviderCallBack
    //   3	71	2	localParcel	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   4	10	46	finally
    //   14	21	46	finally
    //   24	43	46	finally
    //   51	68	46	finally
    //   4	10	50	android/os/RemoteException
    //   14	21	50	android/os/RemoteException
    //   24	43	50	android/os/RemoteException
  }
  
  /* Error */
  public void a(com.tencent.mobileqq.data.MessageForShortVideo paramMessageForShortVideo)
  {
    // Byte code:
    //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: aload_2
    //   5: ldc 27
    //   7: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   10: aload_2
    //   11: aload_1
    //   12: iconst_0
    //   13: invokevirtual 108	android/os/Parcel:writeParcelable	(Landroid/os/Parcelable;I)V
    //   16: aload_0
    //   17: getfield 15	com/tencent/mobileqq/activity/aio/photo/IAIOImageProvider$Stub$Proxy:a	Landroid/os/IBinder;
    //   20: bipush 18
    //   22: aload_2
    //   23: aconst_null
    //   24: iconst_1
    //   25: invokeinterface 45 5 0
    //   30: pop
    //   31: goto +25 -> 56
    //   34: astore_1
    //   35: goto +26 -> 61
    //   38: astore_1
    //   39: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   42: ifeq +14 -> 56
    //   45: ldc 63
    //   47: iconst_2
    //   48: aload_1
    //   49: invokevirtual 84	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   52: aload_1
    //   53: invokestatic 69	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   56: aload_2
    //   57: invokevirtual 55	android/os/Parcel:recycle	()V
    //   60: return
    //   61: aload_2
    //   62: invokevirtual 55	android/os/Parcel:recycle	()V
    //   65: aload_1
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	Proxy
    //   0	67	1	paramMessageForShortVideo	com.tencent.mobileqq.data.MessageForShortVideo
    //   3	59	2	localParcel	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   4	31	34	finally
    //   39	56	34	finally
    //   4	31	38	android/os/RemoteException
  }
  
  /* Error */
  public void a(java.lang.String paramString, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: aload_3
    //   5: ldc 27
    //   7: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   10: aload_3
    //   11: aload_1
    //   12: invokevirtual 73	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   15: aload_3
    //   16: iload_2
    //   17: invokevirtual 39	android/os/Parcel:writeInt	(I)V
    //   20: aload_0
    //   21: getfield 15	com/tencent/mobileqq/activity/aio/photo/IAIOImageProvider$Stub$Proxy:a	Landroid/os/IBinder;
    //   24: bipush 8
    //   26: aload_3
    //   27: aconst_null
    //   28: iconst_1
    //   29: invokeinterface 45 5 0
    //   34: pop
    //   35: goto +25 -> 60
    //   38: astore_1
    //   39: goto +26 -> 65
    //   42: astore_1
    //   43: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   46: ifeq +14 -> 60
    //   49: ldc 63
    //   51: iconst_2
    //   52: aload_1
    //   53: invokevirtual 84	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   56: aload_1
    //   57: invokestatic 69	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   60: aload_3
    //   61: invokevirtual 55	android/os/Parcel:recycle	()V
    //   64: return
    //   65: aload_3
    //   66: invokevirtual 55	android/os/Parcel:recycle	()V
    //   69: aload_1
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	Proxy
    //   0	71	1	paramString	java.lang.String
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
  
  /* Error */
  public android.content.Intent b(long paramLong, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 6
    //   5: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 7
    //   10: aconst_null
    //   11: astore 5
    //   13: aload 6
    //   15: ldc 27
    //   17: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   20: aload 6
    //   22: lload_1
    //   23: invokevirtual 35	android/os/Parcel:writeLong	(J)V
    //   26: aload 6
    //   28: iload_3
    //   29: invokevirtual 39	android/os/Parcel:writeInt	(I)V
    //   32: aload_0
    //   33: getfield 15	com/tencent/mobileqq/activity/aio/photo/IAIOImageProvider$Stub$Proxy:a	Landroid/os/IBinder;
    //   36: iconst_5
    //   37: aload 6
    //   39: aload 7
    //   41: iconst_0
    //   42: invokeinterface 45 5 0
    //   47: pop
    //   48: aload 7
    //   50: invokevirtual 48	android/os/Parcel:readException	()V
    //   53: aload 5
    //   55: astore 4
    //   57: aload 7
    //   59: invokevirtual 52	android/os/Parcel:readInt	()I
    //   62: ifeq +55 -> 117
    //   65: getstatic 119	android/content/Intent:CREATOR	Landroid/os/Parcelable$Creator;
    //   68: aload 7
    //   70: invokeinterface 125 2 0
    //   75: checkcast 115	android/content/Intent
    //   78: astore 4
    //   80: goto +37 -> 117
    //   83: astore 4
    //   85: goto +45 -> 130
    //   88: astore 8
    //   90: aload 5
    //   92: astore 4
    //   94: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   97: ifeq +20 -> 117
    //   100: ldc 63
    //   102: iconst_2
    //   103: aload 8
    //   105: invokevirtual 126	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   108: aload 8
    //   110: invokestatic 69	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   113: aload 5
    //   115: astore 4
    //   117: aload 7
    //   119: invokevirtual 55	android/os/Parcel:recycle	()V
    //   122: aload 6
    //   124: invokevirtual 55	android/os/Parcel:recycle	()V
    //   127: aload 4
    //   129: areturn
    //   130: aload 7
    //   132: invokevirtual 55	android/os/Parcel:recycle	()V
    //   135: aload 6
    //   137: invokevirtual 55	android/os/Parcel:recycle	()V
    //   140: aload 4
    //   142: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	this	Proxy
    //   0	143	1	paramLong	long
    //   0	143	3	paramInt	int
    //   55	24	4	localObject1	Object
    //   83	1	4	localObject2	Object
    //   92	49	4	localObject3	Object
    //   11	103	5	localObject4	Object
    //   3	133	6	localParcel1	android.os.Parcel
    //   8	123	7	localParcel2	android.os.Parcel
    //   88	21	8	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   13	53	83	finally
    //   57	80	83	finally
    //   94	113	83	finally
    //   13	53	88	java/lang/Exception
    //   57	80	88	java/lang/Exception
  }
  
  /* Error */
  public com.tencent.mobileqq.data.MessageForShortVideo b(long paramLong)
  {
    // Byte code:
    //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 5
    //   5: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 6
    //   10: aconst_null
    //   11: astore 4
    //   13: aload 5
    //   15: ldc 27
    //   17: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   20: aload 5
    //   22: lload_1
    //   23: invokevirtual 35	android/os/Parcel:writeLong	(J)V
    //   26: aload_0
    //   27: getfield 15	com/tencent/mobileqq/activity/aio/photo/IAIOImageProvider$Stub$Proxy:a	Landroid/os/IBinder;
    //   30: bipush 14
    //   32: aload 5
    //   34: aload 6
    //   36: iconst_0
    //   37: invokeinterface 45 5 0
    //   42: pop
    //   43: aload 6
    //   45: invokevirtual 48	android/os/Parcel:readException	()V
    //   48: aload 4
    //   50: astore_3
    //   51: aload 6
    //   53: invokevirtual 52	android/os/Parcel:readInt	()I
    //   56: ifeq +48 -> 104
    //   59: getstatic 130	com/tencent/mobileqq/data/MessageForShortVideo:CREATOR	Landroid/os/Parcelable$Creator;
    //   62: aload 6
    //   64: invokeinterface 125 2 0
    //   69: checkcast 129	com/tencent/mobileqq/data/MessageForShortVideo
    //   72: astore_3
    //   73: goto +31 -> 104
    //   76: astore_3
    //   77: goto +39 -> 116
    //   80: astore 7
    //   82: aload 4
    //   84: astore_3
    //   85: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   88: ifeq +16 -> 104
    //   91: ldc 63
    //   93: iconst_2
    //   94: ldc 81
    //   96: aload 7
    //   98: invokestatic 69	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   101: aload 4
    //   103: astore_3
    //   104: aload 6
    //   106: invokevirtual 55	android/os/Parcel:recycle	()V
    //   109: aload 5
    //   111: invokevirtual 55	android/os/Parcel:recycle	()V
    //   114: aload_3
    //   115: areturn
    //   116: aload 6
    //   118: invokevirtual 55	android/os/Parcel:recycle	()V
    //   121: aload 5
    //   123: invokevirtual 55	android/os/Parcel:recycle	()V
    //   126: aload_3
    //   127: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	Proxy
    //   0	128	1	paramLong	long
    //   50	23	3	localObject1	Object
    //   76	1	3	localObject2	Object
    //   84	43	3	localObject3	Object
    //   11	91	4	localObject4	Object
    //   3	119	5	localParcel1	android.os.Parcel
    //   8	109	6	localParcel2	android.os.Parcel
    //   80	17	7	localRemoteException	android.os.RemoteException
    // Exception table:
    //   from	to	target	type
    //   13	48	76	finally
    //   51	73	76	finally
    //   85	101	76	finally
    //   13	48	80	android/os/RemoteException
    //   51	73	80	android/os/RemoteException
  }
  
  /* Error */
  public void b(long paramLong, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 5
    //   5: aload 5
    //   7: ldc 27
    //   9: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   12: aload 5
    //   14: lload_1
    //   15: invokevirtual 35	android/os/Parcel:writeLong	(J)V
    //   18: aload 5
    //   20: iload_3
    //   21: invokevirtual 39	android/os/Parcel:writeInt	(I)V
    //   24: aload 5
    //   26: iload 4
    //   28: invokevirtual 39	android/os/Parcel:writeInt	(I)V
    //   31: aload_0
    //   32: getfield 15	com/tencent/mobileqq/activity/aio/photo/IAIOImageProvider$Stub$Proxy:a	Landroid/os/IBinder;
    //   35: iconst_2
    //   36: aload 5
    //   38: aconst_null
    //   39: iconst_1
    //   40: invokeinterface 45 5 0
    //   45: pop
    //   46: goto +29 -> 75
    //   49: astore 6
    //   51: goto +30 -> 81
    //   54: astore 6
    //   56: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +16 -> 75
    //   62: ldc 63
    //   64: iconst_2
    //   65: aload 6
    //   67: invokevirtual 84	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   70: aload 6
    //   72: invokestatic 69	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   75: aload 5
    //   77: invokevirtual 55	android/os/Parcel:recycle	()V
    //   80: return
    //   81: aload 5
    //   83: invokevirtual 55	android/os/Parcel:recycle	()V
    //   86: aload 6
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	Proxy
    //   0	89	1	paramLong	long
    //   0	89	3	paramInt1	int
    //   0	89	4	paramInt2	int
    //   3	79	5	localParcel	android.os.Parcel
    //   49	1	6	localObject	Object
    //   54	33	6	localRemoteException	android.os.RemoteException
    // Exception table:
    //   from	to	target	type
    //   5	46	49	finally
    //   56	75	49	finally
    //   5	46	54	android/os/RemoteException
  }
  
  /* Error */
  public void b(java.lang.String paramString, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 27
    //   12: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_3
    //   16: aload_1
    //   17: invokevirtual 73	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   20: aload_3
    //   21: iload_2
    //   22: invokevirtual 39	android/os/Parcel:writeInt	(I)V
    //   25: aload_0
    //   26: getfield 15	com/tencent/mobileqq/activity/aio/photo/IAIOImageProvider$Stub$Proxy:a	Landroid/os/IBinder;
    //   29: bipush 21
    //   31: aload_3
    //   32: aload 4
    //   34: iconst_1
    //   35: invokeinterface 45 5 0
    //   40: pop
    //   41: aload 4
    //   43: invokevirtual 48	android/os/Parcel:readException	()V
    //   46: goto +23 -> 69
    //   49: astore_1
    //   50: goto +29 -> 79
    //   53: astore_1
    //   54: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   57: ifeq +12 -> 69
    //   60: ldc 63
    //   62: iconst_2
    //   63: ldc 132
    //   65: aload_1
    //   66: invokestatic 69	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   69: aload 4
    //   71: invokevirtual 55	android/os/Parcel:recycle	()V
    //   74: aload_3
    //   75: invokevirtual 55	android/os/Parcel:recycle	()V
    //   78: return
    //   79: aload 4
    //   81: invokevirtual 55	android/os/Parcel:recycle	()V
    //   84: aload_3
    //   85: invokevirtual 55	android/os/Parcel:recycle	()V
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	Proxy
    //   0	90	1	paramString	java.lang.String
    //   0	90	2	paramInt	int
    //   3	82	3	localParcel1	android.os.Parcel
    //   7	73	4	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   9	46	49	finally
    //   54	69	49	finally
    //   9	46	53	android/os/RemoteException
  }
  
  /* Error */
  public void b(long[] paramArrayOfLong)
  {
    // Byte code:
    //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: aload_2
    //   5: ldc 27
    //   7: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   10: aload_2
    //   11: aload_1
    //   12: arraylength
    //   13: invokevirtual 39	android/os/Parcel:writeInt	(I)V
    //   16: aload_2
    //   17: aload_1
    //   18: invokevirtual 136	android/os/Parcel:writeLongArray	([J)V
    //   21: aload_0
    //   22: getfield 15	com/tencent/mobileqq/activity/aio/photo/IAIOImageProvider$Stub$Proxy:a	Landroid/os/IBinder;
    //   25: bipush 20
    //   27: aload_2
    //   28: aconst_null
    //   29: iconst_1
    //   30: invokeinterface 45 5 0
    //   35: pop
    //   36: goto +25 -> 61
    //   39: astore_1
    //   40: goto +26 -> 66
    //   43: astore_1
    //   44: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   47: ifeq +14 -> 61
    //   50: ldc 63
    //   52: iconst_2
    //   53: aload_1
    //   54: invokevirtual 84	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   57: aload_1
    //   58: invokestatic 69	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   61: aload_2
    //   62: invokevirtual 55	android/os/Parcel:recycle	()V
    //   65: return
    //   66: aload_2
    //   67: invokevirtual 55	android/os/Parcel:recycle	()V
    //   70: aload_1
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	Proxy
    //   0	72	1	paramArrayOfLong	long[]
    //   3	64	2	localParcel	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   4	36	39	finally
    //   44	61	39	finally
    //   4	36	43	android/os/RemoteException
  }
  
  /* Error */
  public android.content.Intent c(long paramLong, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 7
    //   5: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 8
    //   10: aconst_null
    //   11: astore 6
    //   13: aload 7
    //   15: ldc 27
    //   17: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   20: aload 7
    //   22: lload_1
    //   23: invokevirtual 35	android/os/Parcel:writeLong	(J)V
    //   26: aload 7
    //   28: iload_3
    //   29: invokevirtual 39	android/os/Parcel:writeInt	(I)V
    //   32: aload 7
    //   34: iload 4
    //   36: invokevirtual 39	android/os/Parcel:writeInt	(I)V
    //   39: aload_0
    //   40: getfield 15	com/tencent/mobileqq/activity/aio/photo/IAIOImageProvider$Stub$Proxy:a	Landroid/os/IBinder;
    //   43: bipush 9
    //   45: aload 7
    //   47: aload 8
    //   49: iconst_0
    //   50: invokeinterface 45 5 0
    //   55: pop
    //   56: aload 8
    //   58: invokevirtual 48	android/os/Parcel:readException	()V
    //   61: aload 6
    //   63: astore 5
    //   65: aload 8
    //   67: invokevirtual 52	android/os/Parcel:readInt	()I
    //   70: ifeq +55 -> 125
    //   73: getstatic 119	android/content/Intent:CREATOR	Landroid/os/Parcelable$Creator;
    //   76: aload 8
    //   78: invokeinterface 125 2 0
    //   83: checkcast 115	android/content/Intent
    //   86: astore 5
    //   88: goto +37 -> 125
    //   91: astore 5
    //   93: goto +45 -> 138
    //   96: astore 9
    //   98: aload 6
    //   100: astore 5
    //   102: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   105: ifeq +20 -> 125
    //   108: ldc 63
    //   110: iconst_2
    //   111: aload 9
    //   113: invokevirtual 84	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   116: aload 9
    //   118: invokestatic 69	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   121: aload 6
    //   123: astore 5
    //   125: aload 7
    //   127: invokevirtual 55	android/os/Parcel:recycle	()V
    //   130: aload 8
    //   132: invokevirtual 55	android/os/Parcel:recycle	()V
    //   135: aload 5
    //   137: areturn
    //   138: aload 7
    //   140: invokevirtual 55	android/os/Parcel:recycle	()V
    //   143: aload 8
    //   145: invokevirtual 55	android/os/Parcel:recycle	()V
    //   148: aload 5
    //   150: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	Proxy
    //   0	151	1	paramLong	long
    //   0	151	3	paramInt1	int
    //   0	151	4	paramInt2	int
    //   63	24	5	localObject1	Object
    //   91	1	5	localObject2	Object
    //   100	49	5	localObject3	Object
    //   11	111	6	localObject4	Object
    //   3	136	7	localParcel1	android.os.Parcel
    //   8	136	8	localParcel2	android.os.Parcel
    //   96	21	9	localRemoteException	android.os.RemoteException
    // Exception table:
    //   from	to	target	type
    //   13	61	91	finally
    //   65	88	91	finally
    //   102	121	91	finally
    //   13	61	96	android/os/RemoteException
    //   65	88	96	android/os/RemoteException
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_1
    //   4: aload_1
    //   5: ldc 27
    //   7: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   10: aload_0
    //   11: getfield 15	com/tencent/mobileqq/activity/aio/photo/IAIOImageProvider$Stub$Proxy:a	Landroid/os/IBinder;
    //   14: bipush 15
    //   16: aload_1
    //   17: aconst_null
    //   18: iconst_1
    //   19: invokeinterface 45 5 0
    //   24: pop
    //   25: goto +25 -> 50
    //   28: astore_2
    //   29: goto +26 -> 55
    //   32: astore_2
    //   33: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq +14 -> 50
    //   39: ldc 63
    //   41: iconst_2
    //   42: aload_2
    //   43: invokevirtual 84	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   46: aload_2
    //   47: invokestatic 69	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   50: aload_1
    //   51: invokevirtual 55	android/os/Parcel:recycle	()V
    //   54: return
    //   55: aload_1
    //   56: invokevirtual 55	android/os/Parcel:recycle	()V
    //   59: aload_2
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	Proxy
    //   3	53	1	localParcel	android.os.Parcel
    //   28	1	2	localObject	Object
    //   32	28	2	localRemoteException	android.os.RemoteException
    // Exception table:
    //   from	to	target	type
    //   4	25	28	finally
    //   33	50	28	finally
    //   4	25	32	android/os/RemoteException
  }
  
  /* Error */
  public void c(long paramLong)
  {
    // Byte code:
    //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: aload_3
    //   5: ldc 27
    //   7: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   10: aload_3
    //   11: lload_1
    //   12: invokevirtual 35	android/os/Parcel:writeLong	(J)V
    //   15: aload_0
    //   16: getfield 15	com/tencent/mobileqq/activity/aio/photo/IAIOImageProvider$Stub$Proxy:a	Landroid/os/IBinder;
    //   19: bipush 17
    //   21: aload_3
    //   22: aconst_null
    //   23: iconst_1
    //   24: invokeinterface 45 5 0
    //   29: pop
    //   30: goto +29 -> 59
    //   33: astore 4
    //   35: goto +29 -> 64
    //   38: astore 4
    //   40: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   43: ifeq +16 -> 59
    //   46: ldc 63
    //   48: iconst_2
    //   49: aload 4
    //   51: invokevirtual 84	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   54: aload 4
    //   56: invokestatic 69	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   59: aload_3
    //   60: invokevirtual 55	android/os/Parcel:recycle	()V
    //   63: return
    //   64: aload_3
    //   65: invokevirtual 55	android/os/Parcel:recycle	()V
    //   68: aload 4
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	Proxy
    //   0	71	1	paramLong	long
    //   3	62	3	localParcel	android.os.Parcel
    //   33	1	4	localObject	Object
    //   38	31	4	localRemoteException	android.os.RemoteException
    // Exception table:
    //   from	to	target	type
    //   4	30	33	finally
    //   40	59	33	finally
    //   4	30	38	android/os/RemoteException
  }
  
  /* Error */
  public void c(long paramLong, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 4
    //   5: aload 4
    //   7: ldc 27
    //   9: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   12: aload 4
    //   14: lload_1
    //   15: invokevirtual 35	android/os/Parcel:writeLong	(J)V
    //   18: aload 4
    //   20: iload_3
    //   21: invokevirtual 39	android/os/Parcel:writeInt	(I)V
    //   24: aload_0
    //   25: getfield 15	com/tencent/mobileqq/activity/aio/photo/IAIOImageProvider$Stub$Proxy:a	Landroid/os/IBinder;
    //   28: bipush 7
    //   30: aload 4
    //   32: aconst_null
    //   33: iconst_1
    //   34: invokeinterface 45 5 0
    //   39: pop
    //   40: goto +29 -> 69
    //   43: astore 5
    //   45: goto +30 -> 75
    //   48: astore 5
    //   50: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   53: ifeq +16 -> 69
    //   56: ldc 63
    //   58: iconst_2
    //   59: aload 5
    //   61: invokevirtual 84	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   64: aload 5
    //   66: invokestatic 69	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   69: aload 4
    //   71: invokevirtual 55	android/os/Parcel:recycle	()V
    //   74: return
    //   75: aload 4
    //   77: invokevirtual 55	android/os/Parcel:recycle	()V
    //   80: aload 5
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	Proxy
    //   0	83	1	paramLong	long
    //   0	83	3	paramInt	int
    //   3	73	4	localParcel	android.os.Parcel
    //   43	1	5	localObject	Object
    //   48	33	5	localRemoteException	android.os.RemoteException
    // Exception table:
    //   from	to	target	type
    //   5	40	43	finally
    //   50	69	43	finally
    //   5	40	48	android/os/RemoteException
  }
  
  /* Error */
  public void d(long paramLong)
  {
    // Byte code:
    //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: aload_3
    //   5: ldc 27
    //   7: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   10: aload_3
    //   11: lload_1
    //   12: invokevirtual 35	android/os/Parcel:writeLong	(J)V
    //   15: aload_0
    //   16: getfield 15	com/tencent/mobileqq/activity/aio/photo/IAIOImageProvider$Stub$Proxy:a	Landroid/os/IBinder;
    //   19: bipush 10
    //   21: aload_3
    //   22: aconst_null
    //   23: iconst_1
    //   24: invokeinterface 45 5 0
    //   29: pop
    //   30: goto +29 -> 59
    //   33: astore 4
    //   35: goto +29 -> 64
    //   38: astore 4
    //   40: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   43: ifeq +16 -> 59
    //   46: ldc 63
    //   48: iconst_2
    //   49: aload 4
    //   51: invokevirtual 84	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   54: aload 4
    //   56: invokestatic 69	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   59: aload_3
    //   60: invokevirtual 55	android/os/Parcel:recycle	()V
    //   63: return
    //   64: aload_3
    //   65: invokevirtual 55	android/os/Parcel:recycle	()V
    //   68: aload 4
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	Proxy
    //   0	71	1	paramLong	long
    //   3	62	3	localParcel	android.os.Parcel
    //   33	1	4	localObject	Object
    //   38	31	4	localRemoteException	android.os.RemoteException
    // Exception table:
    //   from	to	target	type
    //   4	30	33	finally
    //   40	59	33	finally
    //   4	30	38	android/os/RemoteException
  }
  
  /* Error */
  public void e(long paramLong)
  {
    // Byte code:
    //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: aload_3
    //   5: ldc 27
    //   7: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   10: aload_3
    //   11: lload_1
    //   12: invokevirtual 35	android/os/Parcel:writeLong	(J)V
    //   15: aload_0
    //   16: getfield 15	com/tencent/mobileqq/activity/aio/photo/IAIOImageProvider$Stub$Proxy:a	Landroid/os/IBinder;
    //   19: bipush 11
    //   21: aload_3
    //   22: aconst_null
    //   23: iconst_1
    //   24: invokeinterface 45 5 0
    //   29: pop
    //   30: goto +29 -> 59
    //   33: astore 4
    //   35: goto +29 -> 64
    //   38: astore 4
    //   40: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   43: ifeq +16 -> 59
    //   46: ldc 63
    //   48: iconst_2
    //   49: aload 4
    //   51: invokevirtual 84	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   54: aload 4
    //   56: invokestatic 69	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   59: aload_3
    //   60: invokevirtual 55	android/os/Parcel:recycle	()V
    //   63: return
    //   64: aload_3
    //   65: invokevirtual 55	android/os/Parcel:recycle	()V
    //   68: aload 4
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	Proxy
    //   0	71	1	paramLong	long
    //   3	62	3	localParcel	android.os.Parcel
    //   33	1	4	localObject	Object
    //   38	31	4	localRemoteException	android.os.RemoteException
    // Exception table:
    //   from	to	target	type
    //   4	30	33	finally
    //   40	59	33	finally
    //   4	30	38	android/os/RemoteException
  }
  
  /* Error */
  public void f(long paramLong)
  {
    // Byte code:
    //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: aload_3
    //   5: ldc 27
    //   7: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   10: aload_3
    //   11: lload_1
    //   12: invokevirtual 35	android/os/Parcel:writeLong	(J)V
    //   15: aload_0
    //   16: getfield 15	com/tencent/mobileqq/activity/aio/photo/IAIOImageProvider$Stub$Proxy:a	Landroid/os/IBinder;
    //   19: bipush 24
    //   21: aload_3
    //   22: aconst_null
    //   23: iconst_1
    //   24: invokeinterface 45 5 0
    //   29: pop
    //   30: goto +29 -> 59
    //   33: astore 4
    //   35: goto +29 -> 64
    //   38: astore 4
    //   40: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   43: ifeq +16 -> 59
    //   46: ldc 63
    //   48: iconst_2
    //   49: aload 4
    //   51: invokevirtual 84	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   54: aload 4
    //   56: invokestatic 69	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   59: aload_3
    //   60: invokevirtual 55	android/os/Parcel:recycle	()V
    //   63: return
    //   64: aload_3
    //   65: invokevirtual 55	android/os/Parcel:recycle	()V
    //   68: aload 4
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	Proxy
    //   0	71	1	paramLong	long
    //   3	62	3	localParcel	android.os.Parcel
    //   33	1	4	localObject	Object
    //   38	31	4	localRemoteException	android.os.RemoteException
    // Exception table:
    //   from	to	target	type
    //   4	30	33	finally
    //   40	59	33	finally
    //   4	30	38	android/os/RemoteException
  }
  
  /* Error */
  public void g(long paramLong)
  {
    // Byte code:
    //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: aload_3
    //   5: ldc 27
    //   7: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   10: aload_3
    //   11: lload_1
    //   12: invokevirtual 35	android/os/Parcel:writeLong	(J)V
    //   15: aload_0
    //   16: getfield 15	com/tencent/mobileqq/activity/aio/photo/IAIOImageProvider$Stub$Proxy:a	Landroid/os/IBinder;
    //   19: bipush 26
    //   21: aload_3
    //   22: aconst_null
    //   23: iconst_1
    //   24: invokeinterface 45 5 0
    //   29: pop
    //   30: goto +29 -> 59
    //   33: astore 4
    //   35: goto +29 -> 64
    //   38: astore 4
    //   40: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   43: ifeq +16 -> 59
    //   46: ldc 63
    //   48: iconst_2
    //   49: aload 4
    //   51: invokevirtual 84	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   54: aload 4
    //   56: invokestatic 69	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   59: aload_3
    //   60: invokevirtual 55	android/os/Parcel:recycle	()V
    //   63: return
    //   64: aload_3
    //   65: invokevirtual 55	android/os/Parcel:recycle	()V
    //   68: aload 4
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	Proxy
    //   0	71	1	paramLong	long
    //   3	62	3	localParcel	android.os.Parcel
    //   33	1	4	localObject	Object
    //   38	31	4	localRemoteException	android.os.RemoteException
    // Exception table:
    //   from	to	target	type
    //   4	30	33	finally
    //   40	59	33	finally
    //   4	30	38	android/os/RemoteException
  }
  
  /* Error */
  public void h(long paramLong)
  {
    // Byte code:
    //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: aload_3
    //   5: ldc 27
    //   7: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   10: aload_3
    //   11: lload_1
    //   12: invokevirtual 35	android/os/Parcel:writeLong	(J)V
    //   15: aload_0
    //   16: getfield 15	com/tencent/mobileqq/activity/aio/photo/IAIOImageProvider$Stub$Proxy:a	Landroid/os/IBinder;
    //   19: bipush 13
    //   21: aload_3
    //   22: aconst_null
    //   23: iconst_1
    //   24: invokeinterface 45 5 0
    //   29: pop
    //   30: goto +29 -> 59
    //   33: astore 4
    //   35: goto +29 -> 64
    //   38: astore 4
    //   40: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   43: ifeq +16 -> 59
    //   46: ldc 63
    //   48: iconst_2
    //   49: aload 4
    //   51: invokevirtual 84	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   54: aload 4
    //   56: invokestatic 69	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   59: aload_3
    //   60: invokevirtual 55	android/os/Parcel:recycle	()V
    //   63: return
    //   64: aload_3
    //   65: invokevirtual 55	android/os/Parcel:recycle	()V
    //   68: aload 4
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	Proxy
    //   0	71	1	paramLong	long
    //   3	62	3	localParcel	android.os.Parcel
    //   33	1	4	localObject	Object
    //   38	31	4	localRemoteException	android.os.RemoteException
    // Exception table:
    //   from	to	target	type
    //   4	30	33	finally
    //   40	59	33	finally
    //   4	30	38	android/os/RemoteException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */