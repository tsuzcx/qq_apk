package com.tencent.mobileqq.apollo.listener;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/listener/ApolloRspCallback;", "", "onResponse", "", "succ", "", "retCode", "", "errMsg", "", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface ApolloRspCallback
{
  public abstract void a(boolean paramBoolean, long paramLong, @Nullable String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.listener.ApolloRspCallback
 * JD-Core Version:    0.7.0.1
 */