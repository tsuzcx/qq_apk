package com.tencent.mobileqq.apollo.ipc;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/ipc/ApolloIPCModule$ApolloClientClass;", "", "()V", "instance", "Lcom/tencent/mobileqq/apollo/ipc/ApolloIPCModule;", "getInstance", "()Lcom/tencent/mobileqq/apollo/ipc/ApolloIPCModule;", "setInstance", "(Lcom/tencent/mobileqq/apollo/ipc/ApolloIPCModule;)V", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
final class ApolloIPCModule$ApolloClientClass
{
  public static final ApolloClientClass a = new ApolloClientClass();
  @NotNull
  private static ApolloIPCModule b = new ApolloIPCModule("apollo_client_module", null);
  
  @NotNull
  public final ApolloIPCModule a()
  {
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ipc.ApolloIPCModule.ApolloClientClass
 * JD-Core Version:    0.7.0.1
 */