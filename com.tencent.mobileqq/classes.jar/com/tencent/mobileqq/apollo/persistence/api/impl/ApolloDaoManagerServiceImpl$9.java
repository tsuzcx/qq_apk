package com.tencent.mobileqq.apollo.persistence.api.impl;

import com.tencent.mobileqq.apollo.model.ApolloActionData;
import java.util.Comparator;

class ApolloDaoManagerServiceImpl$9
  implements Comparator<ApolloActionData>
{
  ApolloDaoManagerServiceImpl$9(ApolloDaoManagerServiceImpl paramApolloDaoManagerServiceImpl) {}
  
  public int a(ApolloActionData paramApolloActionData1, ApolloActionData paramApolloActionData2)
  {
    if (paramApolloActionData2.version == paramApolloActionData1.version) {
      return 0;
    }
    if (paramApolloActionData2.version > paramApolloActionData1.version) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl.9
 * JD-Core Version:    0.7.0.1
 */