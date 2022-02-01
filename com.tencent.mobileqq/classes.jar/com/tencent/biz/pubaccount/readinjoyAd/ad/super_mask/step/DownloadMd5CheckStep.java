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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/step/DownloadMd5CheckStep;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/api/SuperMaskStep;", "data", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/materialdownload/MaterialData;", "file", "Ljava/io/File;", "(Lcom/tencent/biz/pubaccount/readinjoyAd/ad/materialdownload/MaterialData;Ljava/io/File;)V", "getData", "()Lcom/tencent/biz/pubaccount/readinjoyAd/ad/materialdownload/MaterialData;", "getFile", "()Ljava/io/File;", "doStep", "", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
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
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMaterialdownloadMaterialData != null)
    {
      localObject1 = this.jdField_a_of_type_JavaIoFile;
      if (localObject1 != null) {
        ((File)localObject1).exists();
      }
    }
    boolean bool2 = false;
    Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMaterialdownloadMaterialData;
    if ((localObject1 != null) && (((MaterialData)localObject1).bid_mask == 1)) {
      return true;
    }
    localObject1 = this.jdField_a_of_type_JavaIoFile;
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((File)localObject1).getPath();
    } else {
      localObject1 = null;
    }
    localObject1 = FileUtils.calcMd5((String)localObject1);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "FileUtils.calcMd5(file?.path)");
    Object localObject3 = Locale.getDefault();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "Locale.getDefault()");
    if (localObject1 != null)
    {
      localObject3 = ((String)localObject1).toLowerCase((Locale)localObject3);
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "(this as java.lang.String).toLowerCase(locale)");
      MaterialData localMaterialData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMaterialdownloadMaterialData;
      localObject1 = localObject2;
      if (localMaterialData != null) {
        localObject1 = localMaterialData.res_md5;
      }
      boolean bool1 = bool2;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          bool1 = bool2;
          if (Intrinsics.areEqual(localObject1, localObject3)) {
            bool1 = true;
          }
        }
      }
      return SuperMaskStepUtil.a.a(bool1, (SuperMaskStep)this);
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step.DownloadMd5CheckStep
 * JD-Core Version:    0.7.0.1
 */