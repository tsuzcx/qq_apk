package com.tencent.mobileqq.activity.recent.guidebanner;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/recent/guidebanner/NewerGuideBannerPreloadWebProcessConfigProcessor$Config;", "", "()V", "preloadWebProcess", "", "getPreloadWebProcess", "()Z", "setPreloadWebProcess", "(Z)V", "parse", "", "configText", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class NewerGuideBannerPreloadWebProcessConfigProcessor$Config
{
  private boolean a = true;
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "configText");
    if (QLog.isColorLevel()) {
      QLog.d("NewerBannerGuidePreloadWebProcessConfigProcessor", 2, paramString);
    }
    if (!TextUtils.isEmpty((CharSequence)paramString)) {}
    try
    {
      if (new JSONObject(paramString).optInt("ConfigEnablePreloadWebProcess", 1) == 1) {}
      for (boolean bool = true;; bool = false)
      {
        this.a = bool;
        return;
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("NewerBannerGuidePreloadWebProcessConfigProcessor", 1, paramString, new Object[0]);
    }
  }
  
  public final boolean a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerPreloadWebProcessConfigProcessor.Config
 * JD-Core Version:    0.7.0.1
 */