package com.tencent.biz.qcircleshadow.lib.delegate;

import com.tencent.biz.qcircleshadow.lib.QCircleInitInject;
import com.tencent.biz.qcircleshadow.local.QCircleSampleInfo;
import com.tencent.biz.qcircleshadow.local.QCircleShadow;
import com.tencent.biz.qcircleshadow.remoteCheck.QCirclePluginManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public abstract class ILoadPluginDelegate
{
  public static final int CRASH_MAX = 3;
  public static final int EXCEPTION_FAILED = 5;
  public static final int FILE_DELETE = 1;
  public static final int NOT_SUPPORT_VERSION = 4;
  public static final int NO_PLUGIN_INFO = 6;
  public static final int SUCCESS = 0;
  public static final int VERSION_NOT_MATCHING = 2;
  
  public static void disPatchCallback(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      QCircleShadow.a().a(true);
    }
    if (paramInt == 4) {
      setCurrentVersionInvalid();
    }
    List localList = QCircleInitInject.g().getPluginCallbacks();
    if ((localList != null) && (localList.size() > 0))
    {
      iteratorCallbacks(localList, paramInt, paramString);
      return;
    }
    QLog.d("QCIRCLE_PLUGIN", 1, "no plugin callbacks");
  }
  
  private static void iteratorCallbacks(List<WeakReference<ILoadPluginDelegate>> paramList, int paramInt, String paramString)
  {
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ILoadPluginDelegate localILoadPluginDelegate = (ILoadPluginDelegate)((WeakReference)paramList.next()).get();
        if (paramInt == 0)
        {
          if (localILoadPluginDelegate != null) {
            localILoadPluginDelegate.onLoadingSuccess();
          }
        }
        else if (localILoadPluginDelegate != null) {
          localILoadPluginDelegate.onLoadingFailed(paramInt, paramString);
        }
      }
      return;
    }
    catch (Exception paramList)
    {
      QLog.d("QCIRCLE_PLUGIN", 1, paramList.getMessage());
    }
  }
  
  private static void setCurrentVersionInvalid()
  {
    QCircleSampleInfo localQCircleSampleInfo = QCircleShadow.a().a();
    if (localQCircleSampleInfo != null) {
      QCirclePluginManager.a().a(localQCircleSampleInfo.b());
    }
  }
  
  public abstract void onLoadingFailed(int paramInt, String paramString);
  
  public abstract void onLoadingSuccess();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.delegate.ILoadPluginDelegate
 * JD-Core Version:    0.7.0.1
 */