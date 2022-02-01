package com.tencent.av.random;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import java.util.concurrent.atomic.AtomicInteger;
import lsq;

public class RandomController$RequestFetchRunnable
  implements Runnable
{
  lsq a;
  
  private RandomController$RequestFetchRunnable(RandomController paramRandomController) {}
  
  public void a(lsq paramlsq)
  {
    this.a = paramlsq;
  }
  
  public void run()
  {
    if (!this.this$0.a)
    {
      RandomController.a(this.this$0).incrementAndGet();
      RandomController.a(this.this$0).a(RandomController.b(this.this$0), RandomController.c(this.this$0), 2, new String[] { this.a.f });
      if ((RandomController.a(this.this$0) != null) && (RandomController.a(this.this$0).a() != null)) {
        RandomController.a(this.this$0).a().removeCallbacks(RandomController.a(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.random.RandomController.RequestFetchRunnable
 * JD-Core Version:    0.7.0.1
 */