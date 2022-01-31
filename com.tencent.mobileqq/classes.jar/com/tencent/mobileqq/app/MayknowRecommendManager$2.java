package com.tencent.mobileqq.app;

import ajls;
import com.tencent.mobileqq.app.automator.Automator;
import mqq.os.MqqHandler;

public class MayknowRecommendManager$2
  implements Runnable
{
  public MayknowRecommendManager$2(ajls paramajls) {}
  
  public void run()
  {
    if (ajls.a(this.this$0).a.a() == 1)
    {
      ajls.b(this.this$0);
      return;
    }
    ajls.a(this.this$0).postDelayed(this, 5000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.MayknowRecommendManager.2
 * JD-Core Version:    0.7.0.1
 */