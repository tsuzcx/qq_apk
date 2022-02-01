package com.tencent.mobileqq.apollo.utils.api;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/utils/api/IApolloIPCHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getApolloDressInfo", "", "dressList", "Ljava/util/ArrayList;", "", "from", "listener", "Lcom/tencent/mobileqq/apollo/utils/api/IApolloIPCHelper$ApolloDressInfoListener;", "getApolloRoleInfo", "role", "Lcom/tencent/mobileqq/apollo/utils/api/IApolloIPCHelper$ApolloRoleInfoListener;", "getIPCModule", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "ApolloDressInfoListener", "ApolloRoleInfoListener", "Constant", "cmshow_api_release"}, k=1, mv={1, 1, 16})
public abstract interface IApolloIPCHelper
  extends QRouteApi
{
  public static final IApolloIPCHelper.Constant Constant = IApolloIPCHelper.Constant.a;
  @NotNull
  public static final String MODULE_NAME = "apollo_client_module";
  
  public abstract void getApolloDressInfo(@Nullable ArrayList<Integer> paramArrayList, int paramInt, @Nullable IApolloIPCHelper.ApolloDressInfoListener paramApolloDressInfoListener);
  
  public abstract void getApolloRoleInfo(int paramInt1, int paramInt2, @Nullable IApolloIPCHelper.ApolloRoleInfoListener paramApolloRoleInfoListener);
  
  @NotNull
  public abstract QIPCModule getIPCModule();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.api.IApolloIPCHelper
 * JD-Core Version:    0.7.0.1
 */