package com.tencent.mobileqq.apollo.utils.api.impl;

import com.tencent.mobileqq.apollo.ipc.ApolloIPCModule;
import com.tencent.mobileqq.apollo.ipc.ApolloIPCModule.Companion;
import com.tencent.mobileqq.apollo.ipc.business.ICMResManager;
import com.tencent.mobileqq.apollo.utils.api.IApolloIPCHelper;
import com.tencent.mobileqq.apollo.utils.api.IApolloIPCHelper.ApolloDressInfoListener;
import com.tencent.mobileqq.apollo.utils.api.IApolloIPCHelper.ApolloRoleInfoListener;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager.ApolloDressInfoListener;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager.ApolloRoleInfoListener;
import com.tencent.mobileqq.qipc.QIPCModule;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/utils/api/impl/ApolloIPCHelperImpl;", "Lcom/tencent/mobileqq/apollo/utils/api/IApolloIPCHelper;", "()V", "getApolloDressInfo", "", "dressList", "Ljava/util/ArrayList;", "", "from", "listener", "Lcom/tencent/mobileqq/apollo/utils/api/IApolloIPCHelper$ApolloDressInfoListener;", "getApolloRoleInfo", "role", "Lcom/tencent/mobileqq/apollo/utils/api/IApolloIPCHelper$ApolloRoleInfoListener;", "getIPCModule", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class ApolloIPCHelperImpl
  implements IApolloIPCHelper
{
  public void getApolloDressInfo(@Nullable ArrayList<Integer> paramArrayList, int paramInt, @Nullable IApolloIPCHelper.ApolloDressInfoListener paramApolloDressInfoListener)
  {
    IApolloResManager.ApolloDressInfoListener localApolloDressInfoListener = (IApolloResManager.ApolloDressInfoListener)null;
    if (paramApolloDressInfoListener != null) {
      localApolloDressInfoListener = (IApolloResManager.ApolloDressInfoListener)new ApolloIPCHelperImpl.getApolloDressInfo.1(paramApolloDressInfoListener);
    }
    ((ICMResManager)ApolloIPCModule.a.a(ICMResManager.class)).a(paramArrayList, paramInt, localApolloDressInfoListener);
  }
  
  public void getApolloRoleInfo(int paramInt1, int paramInt2, @Nullable IApolloIPCHelper.ApolloRoleInfoListener paramApolloRoleInfoListener)
  {
    IApolloResManager.ApolloRoleInfoListener localApolloRoleInfoListener = (IApolloResManager.ApolloRoleInfoListener)null;
    if (paramApolloRoleInfoListener != null) {
      localApolloRoleInfoListener = (IApolloResManager.ApolloRoleInfoListener)new ApolloIPCHelperImpl.getApolloRoleInfo.1(paramApolloRoleInfoListener);
    }
    ((ICMResManager)ApolloIPCModule.a.a(ICMResManager.class)).a(paramInt1, paramInt2, localApolloRoleInfoListener);
  }
  
  @NotNull
  public QIPCModule getIPCModule()
  {
    return (QIPCModule)ApolloIPCModule.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.api.impl.ApolloIPCHelperImpl
 * JD-Core Version:    0.7.0.1
 */