package com.tencent.mobileqq.app;

import akac;
import com.tencent.mobileqq.app.automator.Automator;
import mqq.os.MqqHandler;

public class MayknowRecommendManager$2
  implements Runnable
{
  public MayknowRecommendManager$2(akac paramakac) {}
  
  public void run()
  {
    if (akac.a(this.this$0).a.a() == 1)
    {
      akac.b(this.this$0);
      return;
    }
    synchronized (akac.a(this.this$0))
    {
      if (!akac.a(this.this$0)) {
        akac.a(this.this$0).postDelayed(this, 5000L);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.MayknowRecommendManager.2
 * JD-Core Version:    0.7.0.1
 */