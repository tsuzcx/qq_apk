package com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.MaterialData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.api.SuperMaskStep;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/step/DownloadMd5CheckStep;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/api/SuperMaskStep;", "data", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/materialdownload/MaterialData;", "file", "Ljava/io/File;", "(Lcom/tencent/biz/pubaccount/readinjoyAd/ad/materialdownload/MaterialData;Ljava/io/File;)V", "getData", "()Lcom/tencent/biz/pubaccount/readinjoyAd/ad/materialdownload/MaterialData;", "getFile", "()Ljava/io/File;", "doStep", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class DownloadMd5CheckStep
  extends SuperMaskStep
{
  @Nullable
  private final MaterialData jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMaterialdownloadMaterialData;
  @Nullable
  private final File jdField_a_of_type_JavaIoFile;
  
  public DownloadMd5CheckStep(@Nullable MaterialData paramMaterialData, @Nullable File paramFile)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMaterialdownloadMaterialData = paramMaterialData;
    this.jdField_a_of_type_JavaIoFile = paramFile;
  }
  
  public boolean a()
  {
    Object localObject2 = null;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMaterialdownloadMaterialData != null) && (this.jdField_a_of_type_JavaIoFile != null) && (!this.jdField_a_of_type_JavaIoFile.exists())) {}
    Object localObject1 = this.jdField_a_of_type_JavaIoFile;
    if (localObject1 != null) {}
    for (localObject1 = ((File)localObject1).getPath();; localObject1 = null)
    {
      localObject1 = FileUtils.c((String)localObject1);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "FileUtils.calcMd5(file?.path)");
      localObject3 = Locale.getDefault();
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "Locale.getDefault()");
      if (localObject1 != null) {
        break;
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
    Object localObject3 = ((String)localObject1).toLowerCase((Locale)localObject3);
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "(this as java.lang.String).toLowerCase(locale)");
    MaterialData localMaterialData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMaterialdownloadMaterialData;
    localObject1 = localObject2;
    if (localMaterialData != null) {
      localObject1 = localMaterialData.res_md5;
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (Intrinsics.areEqual(localObject1, localObject3))) {}
    for (boolean bool = true;; bool = false) {
      return SuperMaskStepUtil.a.a(bool, (SuperMaskStep)this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step.DownloadMd5CheckStep
 * JD-Core Version:    0.7.0.1
 */