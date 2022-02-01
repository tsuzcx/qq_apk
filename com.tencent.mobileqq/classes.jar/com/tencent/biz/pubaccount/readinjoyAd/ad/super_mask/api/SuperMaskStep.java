package com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/api/SuperMaskStep;", "", "()V", "sceneTag", "", "getSceneTag", "()Ljava/lang/String;", "setSceneTag", "(Ljava/lang/String;)V", "subTag", "getSubTag", "setSubTag", "doStep", "", "kandian-ad-api_release"}, k=1, mv={1, 1, 16})
public abstract class SuperMaskStep
{
  @NotNull
  private String a = "";
  @Nullable
  private String b;
  
  @NotNull
  public final String a()
  {
    return this.a;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.a = paramString;
  }
  
  @Nullable
  public final String b()
  {
    return this.b;
  }
  
  public final void b(@Nullable String paramString)
  {
    this.b = paramString;
  }
  
  public abstract boolean c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.api.SuperMaskStep
 * JD-Core Version:    0.7.0.1
 */