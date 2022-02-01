package com.tencent.mobileqq.apollo.makeup;

import android.content.Context;
import com.tencent.aelight.camera.cmsshow.api.CmShowAssetsData;
import com.tencent.mobileqq.apollo.ipc.ApolloIPCModule;
import com.tencent.mobileqq.apollo.ipc.ApolloIPCModule.Companion;
import com.tencent.mobileqq.apollo.ipc.business.ICMResManager;
import com.tencent.mobileqq.apollo.utils.task.AsyncTask;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager.ApolloUserDressInfoListener;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$CmShowResDownloadTask;", "Lcom/tencent/mobileqq/apollo/utils/task/AsyncTask;", "context", "Landroid/content/Context;", "uin", "", "(Landroid/content/Context;Ljava/lang/String;)V", "cmShowAssetsFullData", "Lcom/tencent/aelight/camera/cmsshow/api/CmShowAssetsData;", "getCmShowAssetsFullData", "()Lcom/tencent/aelight/camera/cmsshow/api/CmShowAssetsData;", "setCmShowAssetsFullData", "(Lcom/tencent/aelight/camera/cmsshow/api/CmShowAssetsData;)V", "executeAsync", "", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CmShowEALoader$CmShowResDownloadTask
  extends AsyncTask
{
  @Nullable
  private CmShowAssetsData a;
  private final String g;
  
  public CmShowEALoader$CmShowResDownloadTask(@NotNull Context paramContext, @NotNull String paramString)
  {
    super(paramContext);
    this.g = paramString;
  }
  
  public void a()
  {
    ((ICMResManager)ApolloIPCModule.a.a(ICMResManager.class)).a(this.g, 1, (IApolloResManager.ApolloUserDressInfoListener)new CmShowEALoader.CmShowResDownloadTask.executeAsync.1(this));
  }
  
  public final void a(@Nullable CmShowAssetsData paramCmShowAssetsData)
  {
    this.a = paramCmShowAssetsData;
  }
  
  @Nullable
  public final CmShowAssetsData b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.makeup.CmShowEALoader.CmShowResDownloadTask
 * JD-Core Version:    0.7.0.1
 */