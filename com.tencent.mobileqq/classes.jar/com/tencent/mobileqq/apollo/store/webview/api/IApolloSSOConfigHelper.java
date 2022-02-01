package com.tencent.mobileqq.apollo.store.webview.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/store/webview/api/IApolloSSOConfigHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "checkUpdateApolloWebViewConfig", "", "app", "Lmqq/app/AppRuntime;", "version", "", "update", "", "cmshow_api_release"}, k=1, mv={1, 1, 16})
public abstract interface IApolloSSOConfigHelper
  extends QRouteApi
{
  public abstract void checkUpdateApolloWebViewConfig(@Nullable AppRuntime paramAppRuntime, int paramInt, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.api.IApolloSSOConfigHelper
 * JD-Core Version:    0.7.0.1
 */