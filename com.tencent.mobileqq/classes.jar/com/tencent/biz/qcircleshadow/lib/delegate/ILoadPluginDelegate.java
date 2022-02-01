package com.tencent.biz.qcircleshadow.lib.delegate;

import com.tencent.biz.qcircleshadow.lib.QCircleInitInject;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import vgw;

public abstract class ILoadPluginDelegate
{
  public static final int CRASH_MAX = 3;
  public static final int EXCEPTION_FAILED = 5;
  public static final int FILE_DELETE = 1;
  public static final int NOT_SUPPORT_VERSION = 4;
  public static final int SUCCESS = 0;
  public static final int VERSION_NOT_MATCHING = 2;
  
  public static void disPatchCallback(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      vgw.a().a(true);
    }
    Object localObject = QCircleInitInject.g().getPluginCallbacks();
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      localObject = ((List)localObject).iterator();
    }
    while (((Iterator)localObject).hasNext())
    {
      ILoadPluginDelegate localILoadPluginDelegate = (ILoadPluginDelegate)((Iterator)localObject).next();
      if (paramInt == 0)
      {
        localILoadPluginDelegate.onLoadingSuccess();
      }
      else
      {
        localILoadPluginDelegate.onLoadingFailed(paramInt, paramString);
        continue;
        QLog.d("QCIRCLE_PLUGIN", 1, "no plugin callbacks");
      }
    }
  }
  
  public abstract void onLoadingFailed(int paramInt, String paramString);
  
  public abstract void onLoadingSuccess();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.delegate.ILoadPluginDelegate
 * JD-Core Version:    0.7.0.1
 */