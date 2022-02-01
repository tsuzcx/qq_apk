package com.tencent.mobileqq.apollo.api.data.impl;

import com.tencent.mobileqq.apollo.api.model.ApolloFavActionData;
import java.util.Comparator;

class ApolloDaoManagerServiceImpl$2
  implements Comparator<ApolloFavActionData>
{
  ApolloDaoManagerServiceImpl$2(ApolloDaoManagerServiceImpl paramApolloDaoManagerServiceImpl) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.data.impl.ApolloDaoManagerServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */