package com.tencent.mobileqq.apollo.api.impl;

import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.api.IApolloEngine;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/api/impl/ApolloEngineImpl;", "Lcom/tencent/mobileqq/apollo/api/IApolloEngine;", "()V", "checkEngineReady", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ApolloEngineImpl
  implements IApolloEngine
{
  public boolean checkEngineReady()
  {
    return ApolloEngine.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloEngineImpl
 * JD-Core Version:    0.7.0.1
 */