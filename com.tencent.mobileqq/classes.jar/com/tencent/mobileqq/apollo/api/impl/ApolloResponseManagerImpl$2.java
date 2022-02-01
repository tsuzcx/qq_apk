package com.tencent.mobileqq.apollo.api.impl;

import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import java.util.Comparator;

class ApolloResponseManagerImpl$2
  implements Comparator<ApolloActionData>
{
  ApolloResponseManagerImpl$2(ApolloResponseManagerImpl paramApolloResponseManagerImpl) {}
  
  public int a(ApolloActionData paramApolloActionData1, ApolloActionData paramApolloActionData2)
  {
    return this.a.getPriority(paramApolloActionData2) - this.a.getPriority(paramApolloActionData1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloResponseManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */