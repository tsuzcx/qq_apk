package com.tencent.mobileqq.apollo.web.ipc;

import com.tencent.mobileqq.apollo.web.api.impl.ApolloJsPluginImpl.CmStoreUserInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/web/ipc/IStoreAvatar2D$GetApolloDataCallback;", "", "onGetApolloData", "", "result", "", "userInfo", "Lcom/tencent/mobileqq/apollo/web/api/impl/ApolloJsPluginImpl$CmStoreUserInfo;", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IStoreAvatar2D$GetApolloDataCallback
{
  public abstract void a(int paramInt, @Nullable ApolloJsPluginImpl.CmStoreUserInfo paramCmStoreUserInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.ipc.IStoreAvatar2D.GetApolloDataCallback
 * JD-Core Version:    0.7.0.1
 */