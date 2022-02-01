package com.tencent.mobileqq.apollo;

import alpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.ArrayList;

public class ApolloStoreStabilityReportManager$2
  implements Runnable
{
  public ApolloStoreStabilityReportManager$2(alpl paramalpl) {}
  
  public void run()
  {
    alpl.a(this.this$0, false);
    if (alpl.a(this.this$0).size() > 0) {
      ThreadManagerV2.excute(alpl.a(this.this$0), 128, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloStoreStabilityReportManager.2
 * JD-Core Version:    0.7.0.1
 */