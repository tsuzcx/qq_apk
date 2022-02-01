package com.tencent.biz.pubaccount.readinjoy.reward.aidl;

import android.os.IBinder;
import android.os.Parcel;

class IRIJAidlInterfaceForRewardTask$Stub$Proxy
  implements IRIJAidlInterfaceForRewardTask
{
  private IBinder a;
  
  IRIJAidlInterfaceForRewardTask$Stub$Proxy(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public int a()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.biz.pubaccount.readinjoy.reward.aidl.IRIJAidlInterfaceForRewardTask");
      this.a.transact(8, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTask a()
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 25
    //   11: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 15	com/tencent/biz/pubaccount/readinjoy/reward/aidl/IRIJAidlInterfaceForRewardTask$Stub$Proxy:a	Landroid/os/IBinder;
    //   18: iconst_2
    //   19: aload_2
    //   20: aload_3
    //   21: iconst_0
    //   22: invokeinterface 35 5 0
    //   27: pop
    //   28: aload_3
    //   29: invokevirtual 38	android/os/Parcel:readException	()V
    //   32: aload_3
    //   33: invokevirtual 41	android/os/Parcel:readInt	()I
    //   36: ifeq +21 -> 57
    //   39: getstatic 51	com/tencent/biz/pubaccount/readinjoy/reward/RIJRewardTask:CREATOR	Lcom/tencent/biz/pubaccount/readinjoy/reward/RIJRewardTask$CREATOR;
    //   42: aload_3
    //   43: invokevirtual 56	com/tencent/biz/pubaccount/readinjoy/reward/RIJRewardTask$CREATOR:a	(Landroid/os/Parcel;)Lcom/tencent/biz/pubaccount/readinjoy/reward/RIJRewardTask;
    //   46: astore_1
    //   47: aload_3
    //   48: invokevirtual 44	android/os/Parcel:recycle	()V
    //   51: aload_2
    //   52: invokevirtual 44	android/os/Parcel:recycle	()V
    //   55: aload_1
    //   56: areturn
    //   57: aconst_null
    //   58: astore_1
    //   59: goto -12 -> 47
    //   62: astore_1
    //   63: aload_3
    //   64: invokevirtual 44	android/os/Parcel:recycle	()V
    //   67: aload_2
    //   68: invokevirtual 44	android/os/Parcel:recycle	()V
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	Proxy
    //   46	13	1	localRIJRewardTask	com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTask
    //   62	10	1	localObject	Object
    //   3	65	2	localParcel1	Parcel
    //   7	57	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	47	62	finally
  }
  
  public void a(int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.biz.pubaccount.readinjoy.reward.aidl.IRIJAidlInterfaceForRewardTask");
      localParcel1.writeInt(paramInt);
      this.a.transact(10, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public void a(com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTask paramRIJRewardTask)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 25
    //   11: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +41 -> 56
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 60	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 65	com/tencent/biz/pubaccount/readinjoy/reward/RIJRewardTask:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 15	com/tencent/biz/pubaccount/readinjoy/reward/aidl/IRIJAidlInterfaceForRewardTask$Stub$Proxy:a	Landroid/os/IBinder;
    //   33: iconst_1
    //   34: aload_2
    //   35: aload_3
    //   36: iconst_0
    //   37: invokeinterface 35 5 0
    //   42: pop
    //   43: aload_3
    //   44: invokevirtual 38	android/os/Parcel:readException	()V
    //   47: aload_3
    //   48: invokevirtual 44	android/os/Parcel:recycle	()V
    //   51: aload_2
    //   52: invokevirtual 44	android/os/Parcel:recycle	()V
    //   55: return
    //   56: aload_2
    //   57: iconst_0
    //   58: invokevirtual 60	android/os/Parcel:writeInt	(I)V
    //   61: goto -32 -> 29
    //   64: astore_1
    //   65: aload_3
    //   66: invokevirtual 44	android/os/Parcel:recycle	()V
    //   69: aload_2
    //   70: invokevirtual 44	android/os/Parcel:recycle	()V
    //   73: aload_1
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	Proxy
    //   0	75	1	paramRIJRewardTask	com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTask
    //   3	67	2	localParcel1	Parcel
    //   7	59	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	64	finally
    //   18	29	64	finally
    //   29	47	64	finally
    //   56	61	64	finally
  }
  
  public void a(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.biz.pubaccount.readinjoy.reward.aidl.IRIJAidlInterfaceForRewardTask");
      localParcel1.writeString(paramString);
      this.a.transact(6, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public void a(String paramString, int paramInt, IReportTaskProgressCallback paramIReportTaskProgressCallback)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 4
    //   5: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 5
    //   10: aload 4
    //   12: ldc 25
    //   14: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload 4
    //   19: aload_1
    //   20: invokevirtual 68	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   23: aload 4
    //   25: iload_2
    //   26: invokevirtual 60	android/os/Parcel:writeInt	(I)V
    //   29: aload_3
    //   30: ifnull +49 -> 79
    //   33: aload_3
    //   34: invokeinterface 75 1 0
    //   39: astore_1
    //   40: aload 4
    //   42: aload_1
    //   43: invokevirtual 78	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   46: aload_0
    //   47: getfield 15	com/tencent/biz/pubaccount/readinjoy/reward/aidl/IRIJAidlInterfaceForRewardTask$Stub$Proxy:a	Landroid/os/IBinder;
    //   50: bipush 7
    //   52: aload 4
    //   54: aload 5
    //   56: iconst_0
    //   57: invokeinterface 35 5 0
    //   62: pop
    //   63: aload 5
    //   65: invokevirtual 38	android/os/Parcel:readException	()V
    //   68: aload 5
    //   70: invokevirtual 44	android/os/Parcel:recycle	()V
    //   73: aload 4
    //   75: invokevirtual 44	android/os/Parcel:recycle	()V
    //   78: return
    //   79: aconst_null
    //   80: astore_1
    //   81: goto -41 -> 40
    //   84: astore_1
    //   85: aload 5
    //   87: invokevirtual 44	android/os/Parcel:recycle	()V
    //   90: aload 4
    //   92: invokevirtual 44	android/os/Parcel:recycle	()V
    //   95: aload_1
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	Proxy
    //   0	97	1	paramString	String
    //   0	97	2	paramInt	int
    //   0	97	3	paramIReportTaskProgressCallback	IReportTaskProgressCallback
    //   3	88	4	localParcel1	Parcel
    //   8	78	5	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   10	29	84	finally
    //   33	40	84	finally
    //   40	68	84	finally
  }
  
  public boolean a()
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.biz.pubaccount.readinjoy.reward.aidl.IRIJAidlInterfaceForRewardTask");
      this.a.transact(11, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.biz.pubaccount.readinjoy.reward.aidl.IRIJAidlInterfaceForRewardTask");
      localParcel1.writeString(paramString);
      this.a.transact(5, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0) {
        bool = true;
      }
      return bool;
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
  
  public int b()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.biz.pubaccount.readinjoy.reward.aidl.IRIJAidlInterfaceForRewardTask");
      this.a.transact(9, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTask b()
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 25
    //   11: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 15	com/tencent/biz/pubaccount/readinjoy/reward/aidl/IRIJAidlInterfaceForRewardTask$Stub$Proxy:a	Landroid/os/IBinder;
    //   18: iconst_4
    //   19: aload_2
    //   20: aload_3
    //   21: iconst_0
    //   22: invokeinterface 35 5 0
    //   27: pop
    //   28: aload_3
    //   29: invokevirtual 38	android/os/Parcel:readException	()V
    //   32: aload_3
    //   33: invokevirtual 41	android/os/Parcel:readInt	()I
    //   36: ifeq +21 -> 57
    //   39: getstatic 51	com/tencent/biz/pubaccount/readinjoy/reward/RIJRewardTask:CREATOR	Lcom/tencent/biz/pubaccount/readinjoy/reward/RIJRewardTask$CREATOR;
    //   42: aload_3
    //   43: invokevirtual 56	com/tencent/biz/pubaccount/readinjoy/reward/RIJRewardTask$CREATOR:a	(Landroid/os/Parcel;)Lcom/tencent/biz/pubaccount/readinjoy/reward/RIJRewardTask;
    //   46: astore_1
    //   47: aload_3
    //   48: invokevirtual 44	android/os/Parcel:recycle	()V
    //   51: aload_2
    //   52: invokevirtual 44	android/os/Parcel:recycle	()V
    //   55: aload_1
    //   56: areturn
    //   57: aconst_null
    //   58: astore_1
    //   59: goto -12 -> 47
    //   62: astore_1
    //   63: aload_3
    //   64: invokevirtual 44	android/os/Parcel:recycle	()V
    //   67: aload_2
    //   68: invokevirtual 44	android/os/Parcel:recycle	()V
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	Proxy
    //   46	13	1	localRIJRewardTask	com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTask
    //   62	10	1	localObject	Object
    //   3	65	2	localParcel1	Parcel
    //   7	57	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	47	62	finally
  }
  
  /* Error */
  public void b(com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTask paramRIJRewardTask)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 25
    //   11: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +41 -> 56
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 60	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 65	com/tencent/biz/pubaccount/readinjoy/reward/RIJRewardTask:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 15	com/tencent/biz/pubaccount/readinjoy/reward/aidl/IRIJAidlInterfaceForRewardTask$Stub$Proxy:a	Landroid/os/IBinder;
    //   33: iconst_3
    //   34: aload_2
    //   35: aload_3
    //   36: iconst_0
    //   37: invokeinterface 35 5 0
    //   42: pop
    //   43: aload_3
    //   44: invokevirtual 38	android/os/Parcel:readException	()V
    //   47: aload_3
    //   48: invokevirtual 44	android/os/Parcel:recycle	()V
    //   51: aload_2
    //   52: invokevirtual 44	android/os/Parcel:recycle	()V
    //   55: return
    //   56: aload_2
    //   57: iconst_0
    //   58: invokevirtual 60	android/os/Parcel:writeInt	(I)V
    //   61: goto -32 -> 29
    //   64: astore_1
    //   65: aload_3
    //   66: invokevirtual 44	android/os/Parcel:recycle	()V
    //   69: aload_2
    //   70: invokevirtual 44	android/os/Parcel:recycle	()V
    //   73: aload_1
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	Proxy
    //   0	75	1	paramRIJRewardTask	com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTask
    //   3	67	2	localParcel1	Parcel
    //   7	59	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	64	finally
    //   18	29	64	finally
    //   29	47	64	finally
    //   56	61	64	finally
  }
  
  public boolean b()
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.biz.pubaccount.readinjoy.reward.aidl.IRIJAidlInterfaceForRewardTask");
      this.a.transact(12, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public int c()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.biz.pubaccount.readinjoy.reward.aidl.IRIJAidlInterfaceForRewardTask");
      this.a.transact(13, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public int d()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.biz.pubaccount.readinjoy.reward.aidl.IRIJAidlInterfaceForRewardTask");
      this.a.transact(14, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public int e()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.biz.pubaccount.readinjoy.reward.aidl.IRIJAidlInterfaceForRewardTask");
      this.a.transact(15, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public int f()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.tencent.biz.pubaccount.readinjoy.reward.aidl.IRIJAidlInterfaceForRewardTask");
      this.a.transact(16, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.reward.aidl.IRIJAidlInterfaceForRewardTask.Stub.Proxy
 * JD-Core Version:    0.7.0.1
 */