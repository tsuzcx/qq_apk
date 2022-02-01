package com.tencent.biz.qcircleshadow.lib;

import com.tencent.aelight.camera.api.IAEEditorManagerForQzone;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleAEEditorGenerateResultListener;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleAEEditorUICallbackListener;
import com.tencent.biz.qcircleshadow.libmanager.QCircleListenerProxyManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qcircle.tempapi.interfaces.IAEKitResult;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tavcut.TAVCut;
import com.tencent.ttpic.openapi.initializer.ImageAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.LightSdkInitializer;
import com.tencent.ttpic.openapi.initializer.PtuAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.PtuToolsInitializer;
import com.tencent.ttpic.openapi.initializer.YTCommonInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import mqq.app.MobileQQ;

public class QCircleHostAEHelper
{
  private static final int RETCODE_FAIL = -1;
  private static final String TAG = "QCircleHostAEHelper";
  private static final String UPLOAD_TAG = "[upload2]";
  
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
    if (!((IAEEditorManagerForQzone)QRoute.api(IAEEditorManagerForQzone.class)).isAEKitForQQInit())
    {
      QLog.e("QCircleHostAEHelper", 1, "[upload2]!AEKitForQQ.init()");
      paramIAEKitResult.onDone(-1);
      return false;
    }
    if (!FeatureManager.Features.YT_COMMON.init())
    {
      QLog.e("QCircleHostAEHelper", 1, "[upload2]INIT_FAILED_LOAD_YTCOMMON_FAILED");
      paramIAEKitResult.onDone(-1);
      return false;
    }
    if (!FeatureManager.Features.PTU_TOOLS.init())
    {
      QLog.e("QCircleHostAEHelper", 1, "[upload2]INIT_FAILED_LOAD_PTUTOOLS_FAILED");
      paramIAEKitResult.onDone(-1);
      return false;
    }
    if (!FeatureManager.Features.PTU_ALGO.init())
    {
      QLog.e("QCircleHostAEHelper", 1, "[upload2]INIT_FAILED_LOAD_PTU_ALGO_FAILED");
      paramIAEKitResult.onDone(-1);
      return false;
    }
    if (!FeatureManager.Features.LIGHT_SDK.init())
    {
      QLog.e("QCircleHostAEHelper", 1, "[upload2]INIT_FAILED_LOAD_LIGHT_SDK_FAILED");
      paramIAEKitResult.onDone(-1);
      return false;
    }
    if (!FeatureManager.Features.IMAGE_ALGO.init())
    {
      QLog.e("QCircleHostAEHelper", 1, "[upload2]INIT_FAILED_LOAD_IMAGE_ALGO_FEATURE_FAILED");
      paramIAEKitResult.onDone(-1);
      return false;
    }
    TAVCut.initTAVCut(MobileQQ.sMobileQQ, FeatureManager.getResourceDir(), FeatureManager.getResourceDir(), ((IAEResUtil)QRoute.api(IAEResUtil.class)).getLightModelDir(), new QCircleHostAEHelper.1(paramIAEKitResult));
    return true;
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
    ((IAEEditorManagerForQzone)QRoute.api(IAEEditorManagerForQzone.class)).requestGenerateVideo(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCircleHostAEHelper
 * JD-Core Version:    0.7.0.1
 */