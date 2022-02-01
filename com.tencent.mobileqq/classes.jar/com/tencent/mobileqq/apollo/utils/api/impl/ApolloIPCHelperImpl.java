package com.tencent.mobileqq.apollo.utils.api.impl;

import com.tencent.mobileqq.apollo.ipc.ApolloIPCModule;
import com.tencent.mobileqq.apollo.res.api.IApolloResManager.ApolloDressInfoListener;
import com.tencent.mobileqq.apollo.res.api.IApolloResManager.ApolloRoleInfoListener;
import com.tencent.mobileqq.apollo.utils.api.IApolloIPCHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/utils/api/impl/ApolloIPCHelperImpl;", "Lcom/tencent/mobileqq/apollo/utils/api/IApolloIPCHelper;", "()V", "getApolloDressInfo", "", "dressList", "Ljava/util/ArrayList;", "", "listener", "Lcom/tencent/mobileqq/apollo/res/api/IApolloResManager$ApolloDressInfoListener;", "getApolloRoleInfo", "role", "Lcom/tencent/mobileqq/apollo/res/api/IApolloResManager$ApolloRoleInfoListener;", "getIPCModule", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class ApolloIPCHelperImpl
  implements IApolloIPCHelper
{
  public void getApolloDressInfo(@Nullable ArrayList<Integer> paramArrayList, @Nullable IApolloResManager.ApolloDressInfoListener paramApolloDressInfoListener)
  {
    ApolloIPCModule.a(paramArrayList, paramApolloDressInfoListener);
  }
  
  public void getApolloRoleInfo(int paramInt, @Nullable IApolloResManager.ApolloRoleInfoListener paramApolloRoleInfoListener)
  {
    ApolloIPCModule.a(paramInt, paramApolloRoleInfoListener);
  }
  
  @NotNull
  public QIPCModule getIPCModule()
  {
    ApolloIPCModule localApolloIPCModule = ApolloIPCModule.a();
    Intrinsics.checkExpressionValueIsNotNull(localApolloIPCModule, "ApolloIPCModule.getInstance()");
    return (QIPCModule)localApolloIPCModule;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.api.impl.ApolloIPCHelperImpl
 * JD-Core Version:    0.7.0.1
 */