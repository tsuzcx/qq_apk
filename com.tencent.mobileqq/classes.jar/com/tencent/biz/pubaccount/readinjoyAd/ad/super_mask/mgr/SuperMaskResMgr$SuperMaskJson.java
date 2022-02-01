package com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/mgr/SuperMaskResMgr$SuperMaskJson;", "", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "getJson", "()Lorg/json/JSONObject;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class SuperMaskResMgr$SuperMaskJson
{
  @Nullable
  private final JSONObject a;
  
  public SuperMaskResMgr$SuperMaskJson(@Nullable JSONObject paramJSONObject)
  {
    this.a = paramJSONObject;
  }
  
  @Nullable
  public final JSONObject a()
  {
    return this.a;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof SuperMaskJson))
      {
        paramObject = (SuperMaskJson)paramObject;
        if (Intrinsics.areEqual(this.a, paramObject.a)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    JSONObject localJSONObject = this.a;
    if (localJSONObject != null) {
      return localJSONObject.hashCode();
    }
    return 0;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SuperMaskJson(json=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskResMgr.SuperMaskJson
 * JD-Core Version:    0.7.0.1
 */