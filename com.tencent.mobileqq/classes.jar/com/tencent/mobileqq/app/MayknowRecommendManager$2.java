package com.tencent.mobileqq.app;

import akaa;
import com.tencent.mobileqq.app.automator.Automator;
import mqq.os.MqqHandler;

public class MayknowRecommendManager$2
  implements Runnable
{
  public MayknowRecommendManager$2(akaa paramakaa) {}
  
  public void run()
  {
    if (akaa.a(this.this$0).a.a() == 1)
    {
      akaa.b(this.this$0);
      return;
    }
    synchronized (akaa.a(this.this$0))
    {
      if (!akaa.a(this.this$0)) {
        akaa.a(this.this$0).postDelayed(this, 5000L);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.MayknowRecommendManager.2
 * JD-Core Version:    0.7.0.1
 */