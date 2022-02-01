package com.tencent.biz.expand.utils;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.widget.immersive.SystemBarCompact;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/expand/utils/ActivityExtUtils;", "", "()V", "setTransparentStatusBar", "", "Lcom/tencent/mobileqq/app/BaseActivity;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ActivityExtUtils
{
  public static final ActivityExtUtils a = new ActivityExtUtils();
  
  @JvmStatic
  public static final void a(@NotNull BaseActivity paramBaseActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseActivity, "$this$setTransparentStatusBar");
    if (paramBaseActivity.mSystemBarComp == null)
    {
      paramBaseActivity.setImmersiveStatus(0);
      return;
    }
    paramBaseActivity.mSystemBarComp.setStatusBarDrawable(null);
    paramBaseActivity.mSystemBarComp.setStatusBarColor(0);
    paramBaseActivity.mSystemBarComp.setStatusColor(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.utils.ActivityExtUtils
 * JD-Core Version:    0.7.0.1
 */