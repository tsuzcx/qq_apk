package com.tencent.gdtad.api.motivebrowsing;

import android.app.Activity;
import android.content.Intent;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/gdtad/api/motivebrowsing/GdtMotiveBrowsingDialog$Companion;", "", "()V", "TAG", "", "startMotiveBrowsingDialog", "", "activity", "Landroid/app/Activity;", "data", "Lcom/tencent/gdtad/api/motivevideo/GdtMotiveVideoPageData;", "intent", "Landroid/content/Intent;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class GdtMotiveBrowsingDialog$Companion
{
  public final void a(@NotNull Activity paramActivity, @NotNull GdtMotiveVideoPageData paramGdtMotiveVideoPageData, @NotNull Intent paramIntent)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramGdtMotiveVideoPageData, "data");
    Intrinsics.checkParameterIsNotNull(paramIntent, "intent");
    paramActivity.runOnUiThread((Runnable)new GdtMotiveBrowsingDialog.Companion.startMotiveBrowsingDialog.1(paramActivity, paramGdtMotiveVideoPageData, paramIntent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.motivebrowsing.GdtMotiveBrowsingDialog.Companion
 * JD-Core Version:    0.7.0.1
 */