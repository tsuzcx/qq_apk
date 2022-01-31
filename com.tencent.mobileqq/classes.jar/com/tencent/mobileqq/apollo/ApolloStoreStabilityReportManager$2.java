package com.tencent.mobileqq.apollo;

import akpr;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.ArrayList;

public class ApolloStoreStabilityReportManager$2
  implements Runnable
{
  public ApolloStoreStabilityReportManager$2(akpr paramakpr) {}
  
  public void run()
  {
    akpr.a(this.this$0, false);
    if (akpr.a(this.this$0).size() > 0) {
      ThreadManagerV2.excute(akpr.a(this.this$0), 128, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloStoreStabilityReportManager.2
 * JD-Core Version:    0.7.0.1
 */