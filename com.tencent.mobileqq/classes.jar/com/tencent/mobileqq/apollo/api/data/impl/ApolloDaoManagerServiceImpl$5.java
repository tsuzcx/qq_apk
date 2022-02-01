package com.tencent.mobileqq.apollo.api.data.impl;

import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import java.util.Comparator;

class ApolloDaoManagerServiceImpl$5
  implements Comparator<ApolloActionData>
{
  ApolloDaoManagerServiceImpl$5(ApolloDaoManagerServiceImpl paramApolloDaoManagerServiceImpl) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.data.impl.ApolloDaoManagerServiceImpl.5
 * JD-Core Version:    0.7.0.1
 */