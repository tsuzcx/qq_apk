package com.tencent.mobileqq.apollo.utils;

import com.tencent.qphone.base.util.QLog;

final class ApolloConfigDataReport$3
  implements Runnable
{
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloConfigDataReport", 2, "getStoreStabilityWatchURLSet. mStoreStabilityWatchURLSet is null, reparse from file");
    }
    ApolloConfigDataReport.b(ApolloConfigDataReport.a(2, ApolloConfigDataReport.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloConfigDataReport.3
 * JD-Core Version:    0.7.0.1
 */