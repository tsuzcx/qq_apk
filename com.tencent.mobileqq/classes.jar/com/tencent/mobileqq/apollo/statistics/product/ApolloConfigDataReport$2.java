package com.tencent.mobileqq.apollo.statistics.product;

import com.tencent.qphone.base.util.QLog;

final class ApolloConfigDataReport$2
  implements Runnable
{
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloConfigDataReport", 2, "getStoreStabilityWatchCMDSet. mStoreStabilityWatchCMDSet is null, reparse from file");
    }
    ApolloConfigDataReport.a(ApolloConfigDataReport.a(1, ApolloConfigDataReport.e()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.product.ApolloConfigDataReport.2
 * JD-Core Version:    0.7.0.1
 */