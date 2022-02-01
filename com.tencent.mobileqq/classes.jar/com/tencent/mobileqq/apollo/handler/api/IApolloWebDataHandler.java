package com.tencent.mobileqq.apollo.handler.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/handler/api/IApolloWebDataHandler;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "doInterceptApolloCmd", "", "url", "", "requestStr", "app", "Lcom/tencent/common/app/AppInterface;", "plugin", "Ljava/lang/Object;", "initInAsyncThreadIfNeed", "", "Constant", "cmshow_api_release"}, k=1, mv={1, 1, 16})
public abstract interface IApolloWebDataHandler
  extends QRouteApi
{
  public static final IApolloWebDataHandler.Constant Constant = IApolloWebDataHandler.Constant.a;
  @NotNull
  public static final String KEY_APOLLO_CLIENT = "thunder_id";
  @NotNull
  public static final String TAG = "apollo_client_ApolloWebDataHandler";
  
  public abstract boolean doInterceptApolloCmd(@Nullable String paramString1, @Nullable String paramString2, @Nullable AppInterface paramAppInterface, @Nullable Object paramObject);
  
  public abstract void initInAsyncThreadIfNeed();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.handler.api.IApolloWebDataHandler
 * JD-Core Version:    0.7.0.1
 */