package com.tencent.mobileqq.app;

import amvo;
import com.tencent.mobileqq.app.automator.Automator;
import mqq.os.MqqHandler;

public class MayknowRecommendManager$2
  implements Runnable
{
  public MayknowRecommendManager$2(amvo paramamvo) {}
  
  public void run()
  {
    if (amvo.a(this.this$0).mAutomator.a() == 1)
    {
      amvo.b(this.this$0);
      return;
    }
    synchronized (amvo.a(this.this$0))
    {
      if (!amvo.a(this.this$0)) {
        amvo.a(this.this$0).postDelayed(this, 5000L);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.MayknowRecommendManager.2
 * JD-Core Version:    0.7.0.1
 */