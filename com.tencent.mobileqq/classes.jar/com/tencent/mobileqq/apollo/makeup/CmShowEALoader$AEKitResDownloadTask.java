package com.tencent.mobileqq.apollo.makeup;

import android.content.Context;
import com.tencent.aelight.camera.cmsshow.api.IAECMSShow;
import com.tencent.mobileqq.apollo.utils.task.AsyncTask;
import com.tencent.mobileqq.qroute.QRoute;
import eipc.EIPCResultCallback;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$AEKitResDownloadTask;", "Lcom/tencent/mobileqq/apollo/utils/task/AsyncTask;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "executeAsync", "", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CmShowEALoader$AEKitResDownloadTask
  extends AsyncTask
{
  public CmShowEALoader$AEKitResDownloadTask(@NotNull Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    ((IAECMSShow)QRoute.api(IAECMSShow.class)).downloadAEKitResource((EIPCResultCallback)new CmShowEALoader.AEKitResDownloadTask.executeAsync.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.makeup.CmShowEALoader.AEKitResDownloadTask
 * JD-Core Version:    0.7.0.1
 */