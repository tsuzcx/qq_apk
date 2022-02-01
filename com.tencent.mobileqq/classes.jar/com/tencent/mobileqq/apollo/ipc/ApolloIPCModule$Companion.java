package com.tencent.mobileqq.apollo.ipc;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/ipc/ApolloIPCModule$Companion;", "", "()V", "TAG", "", "instance", "Lcom/tencent/mobileqq/apollo/ipc/ApolloIPCModule;", "getInstance", "()Lcom/tencent/mobileqq/apollo/ipc/ApolloIPCModule;", "get", "T", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class ApolloIPCModule$Companion
{
  @NotNull
  public final ApolloIPCModule a()
  {
    return ApolloIPCModule.ApolloClientClass.a.a();
  }
  
  @JvmStatic
  public final <T> T a(@NotNull Class<T> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "clazz");
    return ApolloIPCModule.a(((Companion)this).a(), paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ipc.ApolloIPCModule.Companion
 * JD-Core Version:    0.7.0.1
 */