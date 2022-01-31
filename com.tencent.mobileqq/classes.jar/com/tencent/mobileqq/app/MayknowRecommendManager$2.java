package com.tencent.mobileqq.app;

import alro;
import com.tencent.mobileqq.app.automator.Automator;
import mqq.os.MqqHandler;

public class MayknowRecommendManager$2
  implements Runnable
{
  public MayknowRecommendManager$2(alro paramalro) {}
  
  public void run()
  {
    if (alro.a(this.this$0).a.a() == 1)
    {
      alro.b(this.this$0);
      return;
    }
    synchronized (alro.a(this.this$0))
    {
      if (!alro.a(this.this$0)) {
        alro.a(this.this$0).postDelayed(this, 5000L);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.MayknowRecommendManager.2
 * JD-Core Version:    0.7.0.1
 */