package com.tencent.mobileqq.apollo.store;

import com.tencent.mobileqq.apollo.statistics.product.ApolloConfigDataReport;

class ApolloStoreStabilityReportManager$1
  implements Runnable
{
  ApolloStoreStabilityReportManager$1(ApolloStoreStabilityReportManager paramApolloStoreStabilityReportManager) {}
  
  public void run()
  {
    ApolloConfigDataReport.a(null);
    ApolloStoreStabilityReportManager.a(this.this$0, System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloStoreStabilityReportManager.1
 * JD-Core Version:    0.7.0.1
 */