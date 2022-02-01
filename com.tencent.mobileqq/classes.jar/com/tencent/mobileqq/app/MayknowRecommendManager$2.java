package com.tencent.mobileqq.app;

import anpk;
import com.tencent.mobileqq.app.automator.Automator;
import mqq.os.MqqHandler;

public class MayknowRecommendManager$2
  implements Runnable
{
  public MayknowRecommendManager$2(anpk paramanpk) {}
  
  public void run()
  {
    if (anpk.a(this.this$0).a.a() == 1)
    {
      anpk.b(this.this$0);
      return;
    }
    synchronized (anpk.a(this.this$0))
    {
      if (!anpk.a(this.this$0)) {
        anpk.a(this.this$0).postDelayed(this, 5000L);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.MayknowRecommendManager.2
 * JD-Core Version:    0.7.0.1
 */