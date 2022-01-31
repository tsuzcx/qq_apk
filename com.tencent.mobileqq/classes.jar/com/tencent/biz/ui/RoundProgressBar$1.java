package com.tencent.biz.ui;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class RoundProgressBar$1
  implements Runnable
{
  RoundProgressBar$1(RoundProgressBar paramRoundProgressBar) {}
  
  public void run()
  {
    if (RoundProgressBar.a(this.this$0) < RoundProgressBar.b(this.this$0))
    {
      RoundProgressBar.a(this.this$0, RoundProgressBar.a(this.this$0) + 1);
      this.this$0.invalidate();
      ThreadManager.getUIHandler().postDelayed(this, 30L);
    }
    while (RoundProgressBar.a(this.this$0) <= RoundProgressBar.b(this.this$0)) {
      return;
    }
    RoundProgressBar.a(this.this$0, RoundProgressBar.a(this.this$0) - 1);
    this.this$0.invalidate();
    ThreadManager.getUIHandler().postDelayed(this, 30L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.ui.RoundProgressBar.1
 * JD-Core Version:    0.7.0.1
 */