package com.tencent.mobileqq.apollo.makeup;

import android.content.Context;
import com.tencent.mobileqq.apollo.ipc.ApolloIPCModule;
import com.tencent.mobileqq.apollo.res.api.IApolloResManager.ApolloRoleInfoListener;
import com.tencent.mobileqq.apollo.utils.task.AsyncTask;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/makeup/CmShowCrossEngineLoader$DownloadRoleTask;", "Lcom/tencent/mobileqq/apollo/utils/task/AsyncTask;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "executeAsync", "", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CmShowCrossEngineLoader$DownloadRoleTask
  extends AsyncTask
{
  public CmShowCrossEngineLoader$DownloadRoleTask(@NotNull Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    ApolloIPCModule.a(0, (IApolloResManager.ApolloRoleInfoListener)new CmShowCrossEngineLoader.DownloadRoleTask.executeAsync.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.makeup.CmShowCrossEngineLoader.DownloadRoleTask
 * JD-Core Version:    0.7.0.1
 */