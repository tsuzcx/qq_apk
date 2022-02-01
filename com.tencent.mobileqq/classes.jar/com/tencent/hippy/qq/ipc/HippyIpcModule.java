package com.tencent.hippy.qq.ipc;

import android.os.Bundle;
import com.tencent.hippy.qq.api.IHippyUpdate;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.utils.HippyAccessHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.statemachine.MainStateManager;
import eipc.EIPCResult;

public class HippyIpcModule
  extends QIPCModule
{
  public static final String IPC_BUNDLE_KEY_BUNDLE_NAME = "bundle_name";
  public static final String IPC_BUNDLE_KEY_BUNDLE_VERSION = "bundle_version";
  public static HippyIpcModule mInstance;
  
  public HippyIpcModule()
  {
    super("module_hippy");
  }
  
  public static HippyIpcModule getInstance()
  {
    try
    {
      if (mInstance == null) {
        try
        {
          if (mInstance == null) {
            mInstance = new HippyIpcModule();
          }
        }
        finally {}
      }
      HippyIpcModule localHippyIpcModule = mInstance;
      return localHippyIpcModule;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("action = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", params = ");
      localStringBuilder.append(paramBundle);
      localStringBuilder.append(",callbackId=");
      localStringBuilder.append(paramInt);
      QLog.d("module_hippy", 2, localStringBuilder.toString());
    }
    if ("action_preload_hippy".equals(paramString))
    {
      HippyAccessHelper.checkAndPreloadHippyPage(new OpenHippyInfo(paramBundle.getBundle("hippy_info")));
      callbackResult(paramInt, EIPCResult.createResult(0, new Bundle()));
    }
    else if ("action_cancle_download_task".equals(paramString))
    {
      paramString = paramBundle.getString("bundle_name");
      paramInt = paramBundle.getInt("bundle_version");
      ((IHippyUpdate)QRoute.api(IHippyUpdate.class)).cancelDownloadTask(paramString, paramInt);
    }
    else if ("action_get_main_state".equals(paramString))
    {
      paramString = MainStateManager.getInstance().getCurrentState();
      paramBundle = new Bundle();
      paramBundle.putString("current_main_state", paramString);
      return EIPCResult.createSuccessResult(paramBundle);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.ipc.HippyIpcModule
 * JD-Core Version:    0.7.0.1
 */