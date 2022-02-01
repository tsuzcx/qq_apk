package com.tencent.hippy.qq.ipc;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.update.HippyUpdateManager;
import com.tencent.hippy.qq.utils.HippyAccessHelper;
import com.tencent.hippy.qq.utils.HippyAccessHelper.OpenHippyInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class HippyIpcModule
  extends QIPCModule
{
  public static final String ACTION_CANCLE_DOWNLOAD_TASK = "action_cancle_download_task";
  public static final String ACTION_PRELOAD_HIPPY = "action_preload_hippy";
  public static final String BUNDLE_HIPPY_INFO = "hippy_info";
  public static final String NAME = "module_hippy";
  public static HippyIpcModule mInstance;
  
  public HippyIpcModule()
  {
    super("module_hippy");
  }
  
  /* Error */
  public static HippyIpcModule getInstance()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 29	com/tencent/hippy/qq/ipc/HippyIpcModule:mInstance	Lcom/tencent/hippy/qq/ipc/HippyIpcModule;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 29	com/tencent/hippy/qq/ipc/HippyIpcModule:mInstance	Lcom/tencent/hippy/qq/ipc/HippyIpcModule;
    //   15: ifnonnull +13 -> 28
    //   18: new 2	com/tencent/hippy/qq/ipc/HippyIpcModule
    //   21: dup
    //   22: invokespecial 31	com/tencent/hippy/qq/ipc/HippyIpcModule:<init>	()V
    //   25: putstatic 29	com/tencent/hippy/qq/ipc/HippyIpcModule:mInstance	Lcom/tencent/hippy/qq/ipc/HippyIpcModule;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 29	com/tencent/hippy/qq/ipc/HippyIpcModule:mInstance	Lcom/tencent/hippy/qq/ipc/HippyIpcModule;
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: areturn
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   34	5	0	localHippyIpcModule	HippyIpcModule
    //   40	5	0	localObject1	java.lang.Object
    //   46	5	0	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   12	28	40	finally
    //   28	31	40	finally
    //   41	44	40	finally
    //   3	12	46	finally
    //   31	35	46	finally
    //   44	46	46	finally
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("module_hippy", 2, "action = " + paramString + ", params = " + paramBundle + ",callbackId=" + paramInt);
    }
    if ("action_preload_hippy".equals(paramString))
    {
      paramString = paramBundle.getBundle("hippy_info");
      if ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime() != null)
      {
        HippyAccessHelper.checkAndPreloadHippyPage(new HippyAccessHelper.OpenHippyInfo(paramString));
        callbackResult(paramInt, EIPCResult.createResult(0, new Bundle()));
      }
    }
    for (;;)
    {
      return null;
      QLog.w("module_hippy", 1, "app is null");
      break;
      if ("action_cancle_download_task".equals(paramString))
      {
        paramString = paramBundle.getString("bundle_name");
        paramInt = paramBundle.getInt("bundle_version");
        HippyUpdateManager.getInstance().cancleDownloadTask(paramString, paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.ipc.HippyIpcModule
 * JD-Core Version:    0.7.0.1
 */