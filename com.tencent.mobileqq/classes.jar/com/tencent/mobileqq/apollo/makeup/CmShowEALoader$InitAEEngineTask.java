package com.tencent.mobileqq.apollo.makeup;

import android.content.Context;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEKitForQQ;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.mobileqq.apollo.statistics.ApolloQualityReportUtil;
import com.tencent.mobileqq.apollo.utils.task.AsyncTask;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$InitAEEngineTask;", "Lcom/tencent/mobileqq/apollo/utils/task/AsyncTask;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "executeAsync", "", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CmShowEALoader$InitAEEngineTask
  extends AsyncTask
{
  public CmShowEALoader$InitAEEngineTask(@NotNull Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    long l = System.currentTimeMillis();
    if (!((IAEKitForQQ)QRoute.api(IAEKitForQQ.class)).init())
    {
      QLog.e(CmShowEALoader.a.a(), 1, "[CmShowAELoader][initStepInitAEKitEngine] AEKitForQQ init error");
      a(-5034, "");
      return;
    }
    if (!FeatureManager.loadBasicFeatures())
    {
      QLog.e(CmShowEALoader.a.a(), 1, "[CmShowAELoader][initStepInitAEKitEngine] loadBasicFeatures error");
      a(-5034, "");
      ApolloQualityReportUtil.a("aekit_init", String.valueOf(System.currentTimeMillis() - l), "init AEKit fail");
      return;
    }
    int i;
    if ((((IAEResUtil)QRoute.api(IAEResUtil.class)).isAEResExist(AEResInfo.LIGHT_RES_BUNDLE_ACE3D)) && (((IAEResUtil)QRoute.api(IAEResUtil.class)).isAEResExist(AEResInfo.LIGHT_RES_BUNDLE_3DMM))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      QLog.e(CmShowEALoader.a.a(), 1, "[CmShowAELoader][initStepInitAEKitEngine] load FACE_3D_LIB error");
      a(-5034, "");
      ApolloQualityReportUtil.a("aekit_init", String.valueOf(System.currentTimeMillis() - l), "init 3DFeature fail");
      return;
    }
    QLog.i(CmShowEALoader.a.a(), 1, "[CmShowAELoader][initStepInitAEKitEngine] success");
    e();
    ApolloQualityReportUtil.a("aekit_init", String.valueOf(System.currentTimeMillis() - l), "success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.makeup.CmShowEALoader.InitAEEngineTask
 * JD-Core Version:    0.7.0.1
 */