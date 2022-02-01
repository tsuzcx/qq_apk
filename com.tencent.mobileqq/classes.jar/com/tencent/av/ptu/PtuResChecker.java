package com.tencent.av.ptu;

import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.support.EffectSupportManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.download.AEResInfo;
import dov.com.qq.im.ae.download.AEResUtil;

public class PtuResChecker
{
  private static final PtuResChecker jdField_a_of_type_ComTencentAvPtuPtuResChecker = new PtuResChecker();
  private final SparseArray<AEKitResItemChecker> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(3);
  private final AEKitResItemChecker jdField_a_of_type_ComTencentAvPtuAEKitResItemChecker;
  
  private PtuResChecker()
  {
    int i = AEResInfo.b.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentAvPtuAEKitResItemChecker = new AEKitResItemChecker(i);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(i, this.jdField_a_of_type_ComTencentAvPtuAEKitResItemChecker);
    i = AEResInfo.d.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidUtilSparseArray.put(i, new AEKitResItemChecker(i));
  }
  
  public static PtuResChecker a()
  {
    return jdField_a_of_type_ComTencentAvPtuPtuResChecker;
  }
  
  public static AEResInfo a(int paramInt)
  {
    AEResInfo localAEResInfo1 = AEResInfo.b;
    AEResInfo[] arrayOfAEResInfo = AEResInfo.jdField_a_of_type_ArrayOfDovComQqImAeDownloadAEResInfo;
    int j = arrayOfAEResInfo.length;
    int i = 0;
    while (i < j)
    {
      AEResInfo localAEResInfo2 = arrayOfAEResInfo[i];
      if ((localAEResInfo2 != null) && (paramInt == localAEResInfo2.jdField_a_of_type_Int)) {
        return localAEResInfo2;
      }
      i += 1;
    }
    return localAEResInfo1;
  }
  
  public static void a(Context paramContext)
  {
    a(paramContext, AEResInfo.b.jdField_a_of_type_Int);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.video.v2q.checkPtuRes");
      localIntent.putExtra("packageIdx", paramInt);
      paramContext.sendBroadcast(localIntent);
      if (QLog.isColorLevel()) {
        QLog.i("PtuResChecker", 2, "sendCheckPtuResBroadcast, res[" + paramInt + "]");
      }
      return;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        QLog.i("PtuResChecker", 1, "sendCheckPtuResBroadcast", paramContext);
      }
    }
  }
  
  public static void a(Intent paramIntent)
  {
    if (paramIntent == null) {}
    int i;
    boolean bool;
    do
    {
      return;
      i = paramIntent.getIntExtra("packageIdx", 0);
      bool = paramIntent.getBooleanExtra("isDownloaded", false);
      int j = paramIntent.getIntExtra("errorType", 0);
      if (QLog.isColorLevel()) {
        QLog.i("PtuResChecker", 2, "onPtuResDownloadRet, package[" + i + ", isDownloaded[" + bool + ", errorType[" + j + "]");
      }
      paramIntent = VideoController.a().a();
      if ((bool) && (paramIntent != null) && (b(i)) && (b()))
      {
        a().a(paramIntent);
        ((EffectSupportManager)paramIntent.a(5)).a(3);
      }
      if ((bool) && (!b(i))) {
        a().a(paramIntent, i);
      }
    } while (paramIntent == null);
    paramIntent.a(new Object[] { Integer.valueOf(9007), Integer.valueOf(i), Boolean.valueOf(bool) });
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    PtuResDownloadCallbackForQav localPtuResDownloadCallbackForQav = null;
    if (paramQQAppInterface != null) {
      localPtuResDownloadCallbackForQav = new PtuResDownloadCallbackForQav(paramQQAppInterface);
    }
    if (b(paramInt)) {}
    for (boolean bool = a(localPtuResDownloadCallbackForQav);; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PtuResChecker", 2, "checkAndDownloadAEKitRes, ret[" + bool + "], packageIndex[" + paramInt + "], app[" + paramQQAppInterface + "]");
      }
      return;
      a(localPtuResDownloadCallbackForQav, a(paramInt));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    if (paramIntent != null) {
      a(paramQQAppInterface, paramIntent.getIntExtra("packageIdx", AEResInfo.b.jdField_a_of_type_Int));
    }
  }
  
  /* Error */
  public static boolean a(dov.com.qq.im.ae.download.AEResManager.AEDownloadCallBack paramAEDownloadCallBack)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: getstatic 31	dov/com/qq/im/ae/download/AEResInfo:b	Ldov/com/qq/im/ae/download/AEResInfo;
    //   7: invokestatic 201	com/tencent/av/ptu/PtuResChecker:a	(Ldov/com/qq/im/ae/download/AEResManager$AEDownloadCallBack;Ldov/com/qq/im/ae/download/AEResInfo;)Z
    //   10: istore_1
    //   11: aload_0
    //   12: getstatic 207	dov/com/qq/im/ae/download/AEResInfo:c	Ldov/com/qq/im/ae/download/AEResInfo;
    //   15: invokestatic 201	com/tencent/av/ptu/PtuResChecker:a	(Ldov/com/qq/im/ae/download/AEResManager$AEDownloadCallBack;Ldov/com/qq/im/ae/download/AEResInfo;)Z
    //   18: istore_2
    //   19: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   22: ifeq +42 -> 64
    //   25: ldc 86
    //   27: iconst_2
    //   28: new 88	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   35: ldc 209
    //   37: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: iload_1
    //   41: invokevirtual 132	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   44: ldc 211
    //   46: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: iload_2
    //   50: invokevirtual 132	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   53: ldc 100
    //   55: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 108	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: iload_1
    //   65: ifeq +14 -> 79
    //   68: iload_2
    //   69: ifeq +10 -> 79
    //   72: iconst_1
    //   73: istore_1
    //   74: ldc 2
    //   76: monitorexit
    //   77: iload_1
    //   78: ireturn
    //   79: iconst_0
    //   80: istore_1
    //   81: goto -7 -> 74
    //   84: astore_0
    //   85: ldc 2
    //   87: monitorexit
    //   88: aload_0
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	paramAEDownloadCallBack	dov.com.qq.im.ae.download.AEResManager.AEDownloadCallBack
    //   10	71	1	bool1	boolean
    //   18	51	2	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   3	64	84	finally
  }
  
  /* Error */
  public static boolean a(dov.com.qq.im.ae.download.AEResManager.AEDownloadCallBack paramAEDownloadCallBack, AEResInfo paramAEResInfo)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_1
    //   4: invokestatic 216	dov/com/qq/im/ae/download/AEResUtil:b	(Ldov/com/qq/im/ae/download/AEResInfo;)Z
    //   7: istore_2
    //   8: iload_2
    //   9: ifne +53 -> 62
    //   12: invokestatic 221	dov/com/qq/im/ae/download/AEResManager:a	()Ldov/com/qq/im/ae/download/AEResManager;
    //   15: aload_1
    //   16: aload_0
    //   17: iconst_0
    //   18: invokevirtual 224	dov/com/qq/im/ae/download/AEResManager:a	(Ldov/com/qq/im/ae/download/AEResInfo;Ldov/com/qq/im/ae/download/AEResManager$AEDownloadCallBack;Z)V
    //   21: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   24: ifeq +33 -> 57
    //   27: ldc 86
    //   29: iconst_2
    //   30: new 88	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   37: ldc 226
    //   39: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: iload_2
    //   43: invokevirtual 132	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   46: ldc 100
    //   48: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 108	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: ldc 2
    //   59: monitorexit
    //   60: iload_2
    //   61: ireturn
    //   62: aload_0
    //   63: ifnull -42 -> 21
    //   66: aload_0
    //   67: aload_1
    //   68: aconst_null
    //   69: iconst_1
    //   70: iconst_0
    //   71: invokeinterface 232 5 0
    //   76: goto -55 -> 21
    //   79: astore_0
    //   80: ldc 2
    //   82: monitorexit
    //   83: aload_0
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	paramAEDownloadCallBack	dov.com.qq.im.ae.download.AEResManager.AEDownloadCallBack
    //   0	85	1	paramAEResInfo	AEResInfo
    //   7	54	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	8	79	finally
    //   12	21	79	finally
    //   21	57	79	finally
    //   66	76	79	finally
  }
  
  public static boolean b()
  {
    return AEResUtil.b();
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == AEResInfo.b.jdField_a_of_type_Int) || (paramInt == AEResInfo.c.jdField_a_of_type_Int);
  }
  
  public static boolean c()
  {
    int i = AEResUtil.a(AEResInfo.b);
    int j = AEResUtil.a(AEResInfo.c);
    return (i != 0) && (j != 0);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentAvPtuAEKitResItemChecker.a();
  }
  
  public boolean a(int paramInt)
  {
    AEKitResItemChecker localAEKitResItemChecker = (AEKitResItemChecker)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    return (localAEKitResItemChecker != null) && (localAEKitResItemChecker.a());
  }
  
  public boolean a(VideoAppInterface paramVideoAppInterface)
  {
    VideoAppInterface localVideoAppInterface = paramVideoAppInterface;
    if (paramVideoAppInterface == null) {
      localVideoAppInterface = VideoController.a().a;
    }
    return this.jdField_a_of_type_ComTencentAvPtuAEKitResItemChecker.a(localVideoAppInterface);
  }
  
  public boolean a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    VideoAppInterface localVideoAppInterface = paramVideoAppInterface;
    if (paramVideoAppInterface == null) {
      localVideoAppInterface = VideoController.a().a;
    }
    AEKitResItemChecker localAEKitResItemChecker = (AEKitResItemChecker)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    paramVideoAppInterface = localAEKitResItemChecker;
    if (localAEKitResItemChecker == null)
    {
      paramVideoAppInterface = localAEKitResItemChecker;
      if (a(paramInt) != AEResInfo.b)
      {
        paramVideoAppInterface = new AEKitResItemChecker(paramInt);
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramVideoAppInterface);
      }
    }
    return (paramVideoAppInterface != null) && (paramVideoAppInterface.a(localVideoAppInterface));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ptu.PtuResChecker
 * JD-Core Version:    0.7.0.1
 */