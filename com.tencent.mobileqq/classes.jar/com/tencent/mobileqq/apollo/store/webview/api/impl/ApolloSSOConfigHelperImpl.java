package com.tencent.mobileqq.apollo.store.webview.api.impl;

import com.tencent.mobileqq.apollo.store.webview.ApolloSSOConfig;
import com.tencent.mobileqq.apollo.store.webview.api.IApolloSSOConfigHelper;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/store/webview/api/impl/ApolloSSOConfigHelperImpl;", "Lcom/tencent/mobileqq/apollo/store/webview/api/IApolloSSOConfigHelper;", "()V", "checkUpdateApolloWebViewConfig", "", "app", "Lmqq/app/AppRuntime;", "version", "", "update", "", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class ApolloSSOConfigHelperImpl
  implements IApolloSSOConfigHelper
{
  public void checkUpdateApolloWebViewConfig(@Nullable AppRuntime paramAppRuntime, int paramInt, boolean paramBoolean)
  {
    ApolloSSOConfig.a(null, paramAppRuntime, paramInt, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.api.impl.ApolloSSOConfigHelperImpl
 * JD-Core Version:    0.7.0.1
 */