package com.tencent.aelight.camera.ae.report_datong;

import android.app.Activity;
import android.view.View;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/report_datong/AECameraDaTongHelper;", "", "()V", "manualReportDaTongClick", "", "view", "Landroid/view/View;", "map", "", "", "registerDaTongElement", "id", "reuseId", "registerDaTongPage", "page", "Landroid/app/Activity;", "pageId", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class AECameraDaTongHelper
{
  public static final AECameraDaTongHelper a = new AECameraDaTongHelper();
  
  public final void a(@NotNull Activity paramActivity, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "page");
    Intrinsics.checkParameterIsNotNull(paramString, "pageId");
    VideoReport.addToDetectionWhitelist(paramActivity);
    VideoReport.setPageId(paramActivity, paramString);
    VideoReport.setPageParams(paramActivity, "dt_appkey", "0DOU0ILWXG4IHULU");
  }
  
  public final void a(@NotNull View paramView, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramString, "id");
    VideoReport.setElementClickPolicy(paramView, ClickPolicy.REPORT_ALL);
    VideoReport.setElementExposePolicy(paramView, ExposurePolicy.REPORT_NONE);
    VideoReport.setElementEndExposePolicy(paramView, EndExposurePolicy.REPORT_NONE);
    VideoReport.setElementId(paramView, paramString);
    VideoReport.setElementParam(paramView, "dt_appkey", "0DOU0ILWXG4IHULU");
  }
  
  public final void a(@NotNull View paramView, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramString1, "id");
    Intrinsics.checkParameterIsNotNull(paramString2, "reuseId");
    a(paramView, paramString1);
    VideoReport.setElementReuseIdentifier(paramView, paramString2);
  }
  
  public final void a(@NotNull View paramView, @Nullable Map<String, ?> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    VideoReport.setElementParam(paramView, "dt_appkey", "0DOU0ILWXG4IHULU");
    VideoReport.reportEvent("dt_clck", paramView, paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.report_datong.AECameraDaTongHelper
 * JD-Core Version:    0.7.0.1
 */