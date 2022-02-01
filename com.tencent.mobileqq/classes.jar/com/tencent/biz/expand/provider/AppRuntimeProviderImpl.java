package com.tencent.biz.expand.provider;

import com.tencent.mobileqq.app.BaseActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/expand/provider/AppRuntimeProviderImpl;", "Lcom/tencent/biz/expand/provider/AppRuntimeProvider;", "activity", "Lcom/tencent/mobileqq/app/BaseActivity;", "(Lcom/tencent/mobileqq/app/BaseActivity;)V", "appRuntime", "Lmqq/app/AppRuntime;", "getAppRuntime", "()Lmqq/app/AppRuntime;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class AppRuntimeProviderImpl
  implements AppRuntimeProvider
{
  @NotNull
  private final AppRuntime a;
  
  public AppRuntimeProviderImpl(@NotNull BaseActivity paramBaseActivity)
  {
    paramBaseActivity = paramBaseActivity.getAppRuntime();
    Intrinsics.checkExpressionValueIsNotNull(paramBaseActivity, "activity.appRuntime");
    this.a = paramBaseActivity;
  }
  
  @NotNull
  public AppRuntime a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.provider.AppRuntimeProviderImpl
 * JD-Core Version:    0.7.0.1
 */