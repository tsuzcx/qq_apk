package com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step;

import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.api.SuperMaskStep;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/step/SuperMaskStepUtil;", "", "()V", "dealStepResult", "", "result", "step", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/api/SuperMaskStep;", "doSuperMaskStep", "tag", "", "steps", "", "(Ljava/lang/String;[Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/api/SuperMaskStep;)Z", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class SuperMaskStepUtil
{
  public static final SuperMaskStepUtil a = new SuperMaskStepUtil();
  
  public final boolean a(@NotNull String paramString, @NotNull SuperMaskStep... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "tag");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "steps");
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      SuperMaskStep localSuperMaskStep = paramVarArgs[i];
      localSuperMaskStep.a(paramString);
      if (!localSuperMaskStep.a()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public final boolean a(boolean paramBoolean, @NotNull SuperMaskStep paramSuperMaskStep)
  {
    Intrinsics.checkParameterIsNotNull(paramSuperMaskStep, "step");
    StringBuilder localStringBuilder = new StringBuilder().append(paramSuperMaskStep.a() + " : ").append(paramSuperMaskStep.getClass().getSimpleName() + " : ");
    if (paramSuperMaskStep.b() != null) {
      localStringBuilder.append(paramSuperMaskStep.b() + " : ");
    }
    if (!paramBoolean) {
      localStringBuilder.append("check fail");
    }
    for (;;)
    {
      ReadInJoyAdLog.a("ReadInJoySuperMaskAd", localStringBuilder.toString());
      return paramBoolean;
      localStringBuilder.append("check success");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step.SuperMaskStepUtil
 * JD-Core Version:    0.7.0.1
 */