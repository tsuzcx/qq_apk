package com.tencent.mobileqq.apollo.api.data.impl;

import com.tencent.mobileqq.apollo.api.model.ApolloKapuEntranceTips;
import java.util.Comparator;

class ApolloDaoManagerServiceImpl$9
  implements Comparator<ApolloKapuEntranceTips>
{
  ApolloDaoManagerServiceImpl$9(ApolloDaoManagerServiceImpl paramApolloDaoManagerServiceImpl) {}
  
  public int a(ApolloKapuEntranceTips paramApolloKapuEntranceTips1, ApolloKapuEntranceTips paramApolloKapuEntranceTips2)
  {
    return paramApolloKapuEntranceTips1.priority - paramApolloKapuEntranceTips2.priority;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.data.impl.ApolloDaoManagerServiceImpl.9
 * JD-Core Version:    0.7.0.1
 */