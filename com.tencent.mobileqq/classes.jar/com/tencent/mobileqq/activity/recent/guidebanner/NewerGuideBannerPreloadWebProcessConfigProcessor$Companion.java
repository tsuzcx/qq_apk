package com.tencent.mobileqq.activity.recent.guidebanner;

import com.tencent.mobileqq.config.QConfigManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/recent/guidebanner/NewerGuideBannerPreloadWebProcessConfigProcessor$Companion;", "", "()V", "CONFIG_ID", "", "TAG", "", "enablePreloadWebProcess", "", "qq-newer-guide_release"}, k=1, mv={1, 1, 16})
public final class NewerGuideBannerPreloadWebProcessConfigProcessor$Companion
{
  public final boolean a()
  {
    Object localObject = QConfigManager.a().a(699);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "QConfigManager.getSingle…n().loadConObj(CONFIG_ID)");
    return ((NewerGuideBannerPreloadWebProcessConfigProcessor.Config)localObject).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerPreloadWebProcessConfigProcessor.Companion
 * JD-Core Version:    0.7.0.1
 */