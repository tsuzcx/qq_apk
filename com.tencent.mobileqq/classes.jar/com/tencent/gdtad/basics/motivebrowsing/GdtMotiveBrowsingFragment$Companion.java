package com.tencent.gdtad.basics.motivebrowsing;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.pb.PBStringField;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DestInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/gdtad/basics/motivebrowsing/GdtMotiveBrowsingFragment$Companion;", "", "()V", "COUNT_DOWN_TOTAL_SECOND", "", "KEY_MOTIVE_BROWSING", "", "TAG", "startMotiveBrowsingActivity", "", "activity", "Landroid/app/Activity;", "data", "Lcom/tencent/gdtad/basics/motivevideo/data/GdtMotiveVideoPageData;", "intent", "Landroid/content/Intent;", "qqad-impl_release"}, k=1, mv={1, 1, 16})
public final class GdtMotiveBrowsingFragment$Companion
{
  public final void a(@NotNull Activity paramActivity, @NotNull GdtMotiveVideoPageData paramGdtMotiveVideoPageData, @NotNull Intent paramIntent)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramGdtMotiveVideoPageData, "data");
    Intrinsics.checkParameterIsNotNull(paramIntent, "intent");
    paramGdtMotiveVideoPageData = new GdtMotiveVideoModel(paramGdtMotiveVideoPageData);
    paramIntent.putExtra("fragment_class", GdtMotiveBrowsingFragment.class.getCanonicalName());
    paramIntent.putExtra("url", paramGdtMotiveVideoPageData.a().dest_info.landing_page.get());
    paramIntent.putExtra("isTransparentTitle", true);
    GdtAd localGdtAd = paramGdtMotiveVideoPageData.a();
    Intrinsics.checkExpressionValueIsNotNull(localGdtAd, "modelData.gdtAd");
    paramIntent.putExtra("GdtWebReportQQ_TRACE_ID", localGdtAd.getTraceId());
    paramGdtMotiveVideoPageData = paramGdtMotiveVideoPageData.a();
    Intrinsics.checkExpressionValueIsNotNull(paramGdtMotiveVideoPageData, "modelData.gdtAd");
    paramIntent.putExtra("GdtWebReportQQ_ACTION_URL", paramGdtMotiveVideoPageData.getUrlForAction());
    RouteUtils.a((Context)paramActivity, paramIntent, "/base/browser");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivebrowsing.GdtMotiveBrowsingFragment.Companion
 * JD-Core Version:    0.7.0.1
 */