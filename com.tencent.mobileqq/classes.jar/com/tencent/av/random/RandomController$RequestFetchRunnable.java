package com.tencent.av.random;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import java.util.concurrent.atomic.AtomicInteger;

class RandomController$RequestFetchRunnable
  implements Runnable
{
  RandomWebProtocol.RspDouble a;
  
  private RandomController$RequestFetchRunnable(RandomController paramRandomController) {}
  
  void a(RandomWebProtocol.RspDouble paramRspDouble)
  {
    this.a = paramRspDouble;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.random.RandomController.RequestFetchRunnable
 * JD-Core Version:    0.7.0.1
 */