package com.tencent.biz.qcircleshadow.lib;

import com.ae.light.camera.api.IAEEditorManagerForQzone;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleAEEditorGenerateResultListener;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleAEEditorUICallbackListener;
import com.tencent.biz.qcircleshadow.libmanager.QCircleListenerProxyManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qcircle.tempapi.api.IQQBaseService;
import com.tencent.mobileqq.qcircle.tempapi.interfaces.IAEKitResult;
import com.tencent.mobileqq.qroute.QRoute;

public class QCircleHostAEHelper
{
  public static void addListener(QCircleAEEditorGenerateResultListener paramQCircleAEEditorGenerateResultListener)
  {
    QCircleListenerProxyManager.getInstance().addQCircleAEEditorGenerateResultListener(paramQCircleAEEditorGenerateResultListener);
  }
  
  public static void addUICallbackListener(QCircleAEEditorUICallbackListener paramQCircleAEEditorUICallbackListener)
  {
    QCircleListenerProxyManager.getInstance().addQCircleAEEditorUICallbackListener(paramQCircleAEEditorUICallbackListener);
  }
  
  public static void cancelMission(String paramString)
  {
    ((IAEEditorManagerForQzone)QRoute.api(IAEEditorManagerForQzone.class)).cancelMission(paramString);
  }
  
  public static boolean checkAEResVersionOKForAEBasePackage()
  {
    return ((IAEEditorManagerForQzone)QRoute.api(IAEEditorManagerForQzone.class)).checkAEResVersionOKForAEBasePackage();
  }
  
  public static LocalMediaInfo getMissionInfo(String paramString)
  {
    return ((IAEEditorManagerForQzone)QRoute.api(IAEEditorManagerForQzone.class)).getMissionInfo(paramString);
  }
  
  public static void initAEEditorManagerForQzone()
  {
    ((IAEEditorManagerForQzone)QRoute.api(IAEEditorManagerForQzone.class)).init();
  }
  
  public static boolean initAEKit(IAEKitResult paramIAEKitResult)
  {
    return QCircleServiceImpl.getQQService().initAEKit(paramIAEKitResult);
  }
  
  public static void removeListener(QCircleAEEditorGenerateResultListener paramQCircleAEEditorGenerateResultListener)
  {
    QCircleListenerProxyManager.getInstance().removeQCircleAEEditorGenerateResultListener(paramQCircleAEEditorGenerateResultListener);
  }
  
  public static void removeUICallbackListener(QCircleAEEditorUICallbackListener paramQCircleAEEditorUICallbackListener)
  {
    QCircleListenerProxyManager.getInstance().removeQCircleAEEditorUICallbackListener(paramQCircleAEEditorUICallbackListener);
  }
  
  public static void requestGenerateVideo(String paramString)
  {
    QCircleServiceImpl.getQQService().requestGenerateVideo(paramString);
  }
  
  public static void retryMission(String paramString)
  {
    ((IAEEditorManagerForQzone)QRoute.api(IAEEditorManagerForQzone.class)).retryMission(paramString);
  }
  
  public static void saveMission(String paramString)
  {
    ((IAEEditorManagerForQzone)QRoute.api(IAEEditorManagerForQzone.class)).saveMission(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCircleHostAEHelper
 * JD-Core Version:    0.7.0.1
 */