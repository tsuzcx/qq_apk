package com.tencent.biz.expand.provider;

import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/expand/provider/AppRuntimeProvider;", "", "appRuntime", "Lmqq/app/AppRuntime;", "getAppRuntime", "()Lmqq/app/AppRuntime;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface AppRuntimeProvider
{
  @NotNull
  public abstract AppRuntime a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.provider.AppRuntimeProvider
 * JD-Core Version:    0.7.0.1
 */