package com.tencent.av.ptu;

import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEDownloadCallBack;
import com.tencent.aelight.camera.download.api.IAEResDownload;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.support.EffectSupportManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class PtuResChecker
{
  private static final PtuResChecker a = new PtuResChecker();
  private final AEKitResItemChecker b;
  private final SparseArray<AEKitResItemChecker> c = new SparseArray(3);
  
  private PtuResChecker()
  {
    int i = AEResInfo.AE_RES_BASE_PACKAGE.index;
    this.b = new AEKitResItemChecker(i);
    this.c.put(i, this.b);
    i = AEResInfo.LIGHT_RES_BUNDLE_HAND.index;
    this.c.put(i, new AEKitResItemChecker(i));
  }
  
  public static PtuResChecker a()
  {
    return a;
  }
  
  public static void a(Context paramContext)
  {
    a(paramContext, AEResInfo.AE_RES_BASE_PACKAGE.index);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.video.v2q.checkPtuRes");
      localIntent.putExtra("packageIdx", paramInt);
      paramContext.sendBroadcast(localIntent);
    }
    catch (Throwable paramContext)
    {
      QLog.i("PtuResChecker", 1, "sendCheckPtuResBroadcast", paramContext);
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("sendCheckPtuResBroadcast, res[");
      paramContext.append(paramInt);
      paramContext.append("]");
      QLog.i("PtuResChecker", 2, paramContext.toString());
    }
  }
  
  public static void a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    int i = paramIntent.getIntExtra("packageIdx", 0);
    boolean bool = paramIntent.getBooleanExtra("isDownloaded", false);
    int j = paramIntent.getIntExtra("errorType", 0);
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("onPtuResDownloadRet, package[");
      paramIntent.append(i);
      paramIntent.append(", isDownloaded[");
      paramIntent.append(bool);
      paramIntent.append(", errorType[");
      paramIntent.append(j);
      paramIntent.append("]");
      QLog.i("PtuResChecker", 2, paramIntent.toString());
    }
    paramIntent = VideoController.f().aj();
    if ((bool) && (paramIntent != null) && (b(i)) && (c()))
    {
      a().a(paramIntent);
      ((EffectSupportManager)paramIntent.c(5)).a(3);
    }
    if ((bool) && (!b(i))) {
      a().a(paramIntent, i);
    }
    if (paramIntent != null) {
      paramIntent.a(new Object[] { Integer.valueOf(9007), Integer.valueOf(i), Boolean.valueOf(bool) });
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    Object localObject;
    if (paramQQAppInterface != null) {
      localObject = new PtuResDownloadCallbackForQav(paramQQAppInterface);
    } else {
      localObject = null;
    }
    boolean bool;
    if (b(paramInt))
    {
      bool = a((IAEDownloadCallBack)localObject);
    }
    else
    {
      a((IAEDownloadCallBack)localObject, c(paramInt));
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkAndDownloadAEKitRes, ret[");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append("], packageIndex[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], app[");
      ((StringBuilder)localObject).append(paramQQAppInterface);
      ((StringBuilder)localObject).append("]");
      QLog.i("PtuResChecker", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    if (paramIntent != null) {
      a(paramQQAppInterface, paramIntent.getIntExtra("packageIdx", AEResInfo.AE_RES_BASE_PACKAGE.index));
    }
  }
  
  public static boolean a(IAEDownloadCallBack paramIAEDownloadCallBack)
  {
    try
    {
      boolean bool1 = a(paramIAEDownloadCallBack, AEResInfo.AE_RES_BASE_PACKAGE);
      boolean bool2 = a(paramIAEDownloadCallBack, AEResInfo.LIGHT_RES_BASE_PACKAGE);
      if (QLog.isColorLevel())
      {
        paramIAEDownloadCallBack = new StringBuilder();
        paramIAEDownloadCallBack.append("startDownloadAEKitResBase, aeResBaseExist[");
        paramIAEDownloadCallBack.append(bool1);
        paramIAEDownloadCallBack.append("], lightBaseExist[");
        paramIAEDownloadCallBack.append(bool2);
        paramIAEDownloadCallBack.append("]");
        QLog.i("PtuResChecker", 2, paramIAEDownloadCallBack.toString());
      }
      if ((bool1) && (bool2)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      return bool1;
    }
    finally
    {
      paramIAEDownloadCallBack = finally;
      throw paramIAEDownloadCallBack;
    }
  }
  
  public static boolean a(IAEDownloadCallBack paramIAEDownloadCallBack, AEResInfo paramAEResInfo)
  {
    try
    {
      boolean bool = ((IAEResUtil)QRoute.api(IAEResUtil.class)).isAEResExist(paramAEResInfo);
      if (!bool) {
        ((IAEResDownload)QRoute.api(IAEResDownload.class)).requestDownload(paramAEResInfo, paramIAEDownloadCallBack, false);
      } else if (paramIAEDownloadCallBack != null) {
        paramIAEDownloadCallBack.onAEDownloadFinish(paramAEResInfo, null, true, 0);
      }
      if (QLog.isColorLevel())
      {
        paramIAEDownloadCallBack = new StringBuilder();
        paramIAEDownloadCallBack.append("startDownloadAEKitRes, ret[");
        paramIAEDownloadCallBack.append(bool);
        paramIAEDownloadCallBack.append("]");
        QLog.i("PtuResChecker", 2, paramIAEDownloadCallBack.toString());
      }
      return bool;
    }
    finally {}
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == AEResInfo.AE_RES_BASE_PACKAGE.index) || (paramInt == AEResInfo.LIGHT_RES_BASE_PACKAGE.index);
  }
  
  public static AEResInfo c(int paramInt)
  {
    AEResInfo localAEResInfo1 = AEResInfo.AE_RES_BASE_PACKAGE;
    AEResInfo[] arrayOfAEResInfo = AEResInfo.values;
    int j = arrayOfAEResInfo.length;
    int i = 0;
    while (i < j)
    {
      AEResInfo localAEResInfo2 = arrayOfAEResInfo[i];
      if ((localAEResInfo2 != null) && (paramInt == localAEResInfo2.index)) {
        return localAEResInfo2;
      }
      i += 1;
    }
    return localAEResInfo1;
  }
  
  public static boolean c()
  {
    return ((IAEResUtil)QRoute.api(IAEResUtil.class)).isLightCameraResExist();
  }
  
  public boolean a(int paramInt)
  {
    AEKitResItemChecker localAEKitResItemChecker = (AEKitResItemChecker)this.c.get(paramInt);
    return (localAEKitResItemChecker != null) && (localAEKitResItemChecker.a());
  }
  
  public boolean a(VideoAppInterface paramVideoAppInterface)
  {
    VideoAppInterface localVideoAppInterface = paramVideoAppInterface;
    if (paramVideoAppInterface == null) {
      localVideoAppInterface = VideoController.f().e;
    }
    return this.b.a(localVideoAppInterface);
  }
  
  public boolean a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    VideoAppInterface localVideoAppInterface = paramVideoAppInterface;
    if (paramVideoAppInterface == null) {
      localVideoAppInterface = VideoController.f().e;
    }
    AEKitResItemChecker localAEKitResItemChecker = (AEKitResItemChecker)this.c.get(paramInt);
    paramVideoAppInterface = localAEKitResItemChecker;
    if (localAEKitResItemChecker == null)
    {
      paramVideoAppInterface = localAEKitResItemChecker;
      if (c(paramInt) != AEResInfo.AE_RES_BASE_PACKAGE)
      {
        paramVideoAppInterface = new AEKitResItemChecker(paramInt);
        this.c.put(paramInt, paramVideoAppInterface);
      }
    }
    return (paramVideoAppInterface != null) && (paramVideoAppInterface.a(localVideoAppInterface));
  }
  
  public boolean b()
  {
    return this.b.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ptu.PtuResChecker
 * JD-Core Version:    0.7.0.1
 */