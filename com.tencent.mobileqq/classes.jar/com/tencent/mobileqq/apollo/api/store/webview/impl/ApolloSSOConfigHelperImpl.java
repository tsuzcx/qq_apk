package com.tencent.mobileqq.apollo.api.store.webview.impl;

import com.tencent.mobileqq.apollo.api.store.webview.IApolloSSOConfigHelper;
import com.tencent.mobileqq.apollo.store.webview.ApolloSSOConfig;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/api/store/webview/impl/ApolloSSOConfigHelperImpl;", "Lcom/tencent/mobileqq/apollo/api/store/webview/IApolloSSOConfigHelper;", "()V", "checkUpdateApolloWebViewConfig", "", "app", "Lmqq/app/AppRuntime;", "version", "", "update", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ApolloSSOConfigHelperImpl
  implements IApolloSSOConfigHelper
{
  public void checkUpdateApolloWebViewConfig(@Nullable AppRuntime paramAppRuntime, int paramInt, boolean paramBoolean)
  {
    ApolloSSOConfig.a(null, paramAppRuntime, paramInt, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.store.webview.impl.ApolloSSOConfigHelperImpl
 * JD-Core Version:    0.7.0.1
 */