package com.tencent.mobileqq.apollo.makeup;

import android.content.Context;
import com.tencent.aelight.camera.cmsshow.api.CMJoyEssentialDownloadCallback;
import com.tencent.aelight.camera.cmsshow.api.IAECMSShow;
import com.tencent.mobileqq.apollo.utils.task.AsyncTask;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/makeup/CmShowCrossEngineLoader$AEKitEssentialResDownloadTask;", "Lcom/tencent/mobileqq/apollo/utils/task/AsyncTask;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "materialPath", "", "getMaterialPath", "()Ljava/lang/String;", "setMaterialPath", "(Ljava/lang/String;)V", "executeAsync", "", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CmShowCrossEngineLoader$AEKitEssentialResDownloadTask
  extends AsyncTask
{
  @NotNull
  public String a;
  
  public CmShowCrossEngineLoader$AEKitEssentialResDownloadTask(@NotNull Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    long l = System.currentTimeMillis();
    IAECMSShow localIAECMSShow = (IAECMSShow)QRoute.api(IAECMSShow.class);
    QRouteApi localQRouteApi = QRoute.api(IAECMSShow.class);
    Intrinsics.checkExpressionValueIsNotNull(localQRouteApi, "QRoute.api(IAECMSShow::class.java)");
    localIAECMSShow.downloadEssentialResource(((IAECMSShow)localQRouteApi).getEssetialResourceIdlist(), (CMJoyEssentialDownloadCallback)new CmShowCrossEngineLoader.AEKitEssentialResDownloadTask.executeAsync.1(this, l));
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.a = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.makeup.CmShowCrossEngineLoader.AEKitEssentialResDownloadTask
 * JD-Core Version:    0.7.0.1
 */