package com.tencent.mobileqq.apollo.persistence.api.impl;

import com.tencent.mobileqq.apollo.model.ApolloFavActionData;
import java.util.Comparator;

class ApolloDaoManagerServiceImpl$4
  implements Comparator<ApolloFavActionData>
{
  ApolloDaoManagerServiceImpl$4(ApolloDaoManagerServiceImpl paramApolloDaoManagerServiceImpl) {}
  
  public int a(ApolloFavActionData paramApolloFavActionData1, ApolloFavActionData paramApolloFavActionData2)
  {
    if (paramApolloFavActionData2.favId == paramApolloFavActionData1.favId) {
      return 0;
    }
    if (paramApolloFavActionData2.favId > paramApolloFavActionData1.favId) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl.4
 * JD-Core Version:    0.7.0.1
 */