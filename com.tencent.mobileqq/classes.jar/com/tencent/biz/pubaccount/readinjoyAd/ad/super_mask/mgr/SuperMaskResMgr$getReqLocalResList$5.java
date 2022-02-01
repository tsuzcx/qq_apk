package com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr;

import com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.MaterialData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/materialdownload/MaterialData;", "invoke"}, k=3, mv={1, 1, 16})
final class SuperMaskResMgr$getReqLocalResList$5
  extends Lambda
  implements Function1<MaterialData, Long>
{
  public static final 5 INSTANCE = new 5();
  
  SuperMaskResMgr$getReqLocalResList$5()
  {
    super(1);
  }
  
  public final long invoke(@NotNull MaterialData paramMaterialData)
  {
    Intrinsics.checkParameterIsNotNull(paramMaterialData, "it");
    return paramMaterialData.start_time;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskResMgr.getReqLocalResList.5
 * JD-Core Version:    0.7.0.1
 */