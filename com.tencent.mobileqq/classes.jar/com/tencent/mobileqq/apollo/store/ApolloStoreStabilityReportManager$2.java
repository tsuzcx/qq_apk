package com.tencent.mobileqq.apollo.store;

import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.ArrayList;

class ApolloStoreStabilityReportManager$2
  implements Runnable
{
  ApolloStoreStabilityReportManager$2(ApolloStoreStabilityReportManager paramApolloStoreStabilityReportManager) {}
  
  public void run()
  {
    ApolloStoreStabilityReportManager.a(this.this$0, false);
    if (ApolloStoreStabilityReportManager.a(this.this$0).size() > 0) {
      ThreadManagerV2.excute(ApolloStoreStabilityReportManager.b(this.this$0), 128, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloStoreStabilityReportManager.2
 * JD-Core Version:    0.7.0.1
 */