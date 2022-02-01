package com.tencent.gdtad.basics.motivebrowsing;

import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/gdtad/basics/motivebrowsing/GdtMotiveBrowsingExperimentReportHelper$ReportCallback;", "", "onReport", "", "url", "", "model", "Lcom/tencent/gdtad/basics/motivevideo/data/GdtMotiveVideoModel;", "qqad-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface GdtMotiveBrowsingExperimentReportHelper$ReportCallback
{
  public abstract void a(@NotNull String paramString, @Nullable GdtMotiveVideoModel paramGdtMotiveVideoModel);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivebrowsing.GdtMotiveBrowsingExperimentReportHelper.ReportCallback
 * JD-Core Version:    0.7.0.1
 */