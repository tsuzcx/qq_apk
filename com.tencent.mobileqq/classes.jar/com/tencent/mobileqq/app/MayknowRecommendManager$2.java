package com.tencent.mobileqq.app;

import alwd;
import com.tencent.mobileqq.app.automator.Automator;
import mqq.os.MqqHandler;

public class MayknowRecommendManager$2
  implements Runnable
{
  public MayknowRecommendManager$2(alwd paramalwd) {}
  
  public void run()
  {
    if (alwd.a(this.this$0).a.a() == 1)
    {
      alwd.b(this.this$0);
      return;
    }
    synchronized (alwd.a(this.this$0))
    {
      if (!alwd.a(this.this$0)) {
        alwd.a(this.this$0).postDelayed(this, 5000L);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.MayknowRecommendManager.2
 * JD-Core Version:    0.7.0.1
 */