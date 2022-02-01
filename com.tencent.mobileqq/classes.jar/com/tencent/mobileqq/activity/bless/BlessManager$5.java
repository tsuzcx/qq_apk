package com.tencent.mobileqq.activity.bless;

class BlessManager$5
  implements Runnable
{
  BlessManager$5(BlessManager paramBlessManager) {}
  
  public void run()
  {
    if (BlessManager.d(this.this$0) != null)
    {
      if (!BlessManager.f(this.this$0))
      {
        BlessManager localBlessManager = this.this$0;
        BlessManager.c(localBlessManager, BlessManager.a(localBlessManager, BlessManager.d(localBlessManager), false));
        localBlessManager = this.this$0;
        BlessManager.d(localBlessManager, BlessManager.f(localBlessManager));
        localBlessManager = this.this$0;
        BlessManager.a(localBlessManager, BlessManager.d(localBlessManager), true);
      }
    }
    else {
      BlessManager.d(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessManager.5
 * JD-Core Version:    0.7.0.1
 */