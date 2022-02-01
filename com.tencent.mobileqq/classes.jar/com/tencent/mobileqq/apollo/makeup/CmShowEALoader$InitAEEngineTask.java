package com.tencent.mobileqq.apollo.makeup;

import android.content.Context;
import com.tencent.mobileqq.apollo.statistics.ApolloQualityReportUtil;
import com.tencent.mobileqq.apollo.utils.task.AsyncTask;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import dov.com.qq.im.ae.AEKitForQQ;
import dov.com.qq.im.ae.download.AEResInfo;
import dov.com.qq.im.ae.download.AEResUtil;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$InitAEEngineTask;", "Lcom/tencent/mobileqq/apollo/utils/task/AsyncTask;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "executeAsync", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
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
    if (!AEKitForQQ.a()) {
      QLog.e(CmShowEALoader.a.a(), 1, "[CmShowAELoader][initStepInitAEKitEngine] AEKitForQQ init error");
    }
    if (!FeatureManager.loadBasicFeatures())
    {
      QLog.e(CmShowEALoader.a.a(), 1, "[CmShowAELoader][initStepInitAEKitEngine] loadBasicFeatures error");
      a(-5034, "");
      ApolloQualityReportUtil.a("aekit_init", String.valueOf(System.currentTimeMillis() - l), "init AEKit fail");
      return;
    }
    if ((AEResUtil.b(AEResInfo.j)) && (AEResUtil.b(AEResInfo.k))) {}
    for (int i = 1; i == 0; i = 0)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.makeup.CmShowEALoader.InitAEEngineTask
 * JD-Core Version:    0.7.0.1
 */