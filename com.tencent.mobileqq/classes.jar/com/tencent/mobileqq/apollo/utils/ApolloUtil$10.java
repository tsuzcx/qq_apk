package com.tencent.mobileqq.apollo.utils;

import bcql;
import com.tencent.common.app.BaseApplicationImpl;

final class ApolloUtil$10
  implements Runnable
{
  public void run()
  {
    bcql localbcql = bcql.a(BaseApplicationImpl.getApplication(), 1, this.a, 1);
    localbcql.a();
    localbcql.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloUtil.10
 * JD-Core Version:    0.7.0.1
 */