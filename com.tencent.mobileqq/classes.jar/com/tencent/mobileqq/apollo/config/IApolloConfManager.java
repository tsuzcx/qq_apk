package com.tencent.mobileqq.apollo.config;

import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/config/IApolloConfManager;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getGrayProcessClazz", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/config/IQConfigProcessor;", "getProcessClazz", "Companion", "cmshow_api_release"}, k=1, mv={1, 1, 16})
public abstract interface IApolloConfManager
  extends QRouteApi
{
  public static final int APOLLO_CONFIG_ID = 67;
  public static final int APOLLO_GRAY_CONFIG_ID = 430;
  public static final IApolloConfManager.Companion Companion = IApolloConfManager.Companion.a;
  
  @NotNull
  public abstract Class<? extends IQConfigProcessor<?>> getGrayProcessClazz();
  
  @NotNull
  public abstract Class<? extends IQConfigProcessor<?>> getProcessClazz();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.config.IApolloConfManager
 * JD-Core Version:    0.7.0.1
 */