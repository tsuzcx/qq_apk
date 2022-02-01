package com.tencent.mobileqq.apollo.makeup;

import android.content.Context;
import com.tencent.aelight.camera.cmsshow.api.CmShowAssetsData;
import com.tencent.mobileqq.apollo.ipc.ApolloIPCModule;
import com.tencent.mobileqq.apollo.res.api.IApolloResManager.ApolloUserDressInfoListener;
import com.tencent.mobileqq.apollo.utils.task.AsyncTask;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$CmShowResDownloadTask;", "Lcom/tencent/mobileqq/apollo/utils/task/AsyncTask;", "context", "Landroid/content/Context;", "uin", "", "(Landroid/content/Context;Ljava/lang/String;)V", "cmShowAssetsFullData", "Lcom/tencent/aelight/camera/cmsshow/api/CmShowAssetsData;", "getCmShowAssetsFullData", "()Lcom/tencent/aelight/camera/cmsshow/api/CmShowAssetsData;", "setCmShowAssetsFullData", "(Lcom/tencent/aelight/camera/cmsshow/api/CmShowAssetsData;)V", "executeAsync", "", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CmShowEALoader$CmShowResDownloadTask
  extends AsyncTask
{
  @Nullable
  private CmShowAssetsData jdField_a_of_type_ComTencentAelightCameraCmsshowApiCmShowAssetsData;
  private final String jdField_a_of_type_JavaLangString;
  
  public CmShowEALoader$CmShowResDownloadTask(@NotNull Context paramContext, @NotNull String paramString)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  @Nullable
  public final CmShowAssetsData a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraCmsshowApiCmShowAssetsData;
  }
  
  public void a()
  {
    ApolloIPCModule.a(this.jdField_a_of_type_JavaLangString, (IApolloResManager.ApolloUserDressInfoListener)new CmShowEALoader.CmShowResDownloadTask.executeAsync.1(this));
  }
  
  public final void a(@Nullable CmShowAssetsData paramCmShowAssetsData)
  {
    this.jdField_a_of_type_ComTencentAelightCameraCmsshowApiCmShowAssetsData = paramCmShowAssetsData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.makeup.CmShowEALoader.CmShowResDownloadTask
 * JD-Core Version:    0.7.0.1
 */