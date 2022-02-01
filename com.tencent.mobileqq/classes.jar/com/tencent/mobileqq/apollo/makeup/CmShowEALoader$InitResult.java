package com.tencent.mobileqq.apollo.makeup;

import com.tencent.aelight.camera.cmsshow.api.CmShowAssetsData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$InitResult;", "", "()V", "mCmShowAssetsFullData", "Lcom/tencent/aelight/camera/cmsshow/api/CmShowAssetsData;", "getMCmShowAssetsFullData", "()Lcom/tencent/aelight/camera/cmsshow/api/CmShowAssetsData;", "setMCmShowAssetsFullData", "(Lcom/tencent/aelight/camera/cmsshow/api/CmShowAssetsData;)V", "mMaterialPath", "", "getMMaterialPath", "()Ljava/lang/String;", "setMMaterialPath", "(Ljava/lang/String;)V", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CmShowEALoader$InitResult
{
  @NotNull
  public CmShowAssetsData a;
  @NotNull
  public volatile String a;
  
  public final void a(@NotNull CmShowAssetsData paramCmShowAssetsData)
  {
    Intrinsics.checkParameterIsNotNull(paramCmShowAssetsData, "<set-?>");
    this.jdField_a_of_type_ComTencentAelightCameraCmsshowApiCmShowAssetsData = paramCmShowAssetsData;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.makeup.CmShowEALoader.InitResult
 * JD-Core Version:    0.7.0.1
 */