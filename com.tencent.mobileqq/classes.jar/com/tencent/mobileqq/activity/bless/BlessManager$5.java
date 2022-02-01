package com.tencent.mobileqq.activity.bless;

class BlessManager$5
  implements Runnable
{
  BlessManager$5(BlessManager paramBlessManager) {}
  
  public void run()
  {
    if (BlessManager.a(this.this$0) != null)
    {
      if (!BlessManager.a(this.this$0))
      {
        BlessManager localBlessManager = this.this$0;
        BlessManager.c(localBlessManager, BlessManager.a(localBlessManager, BlessManager.a(localBlessManager), false));
        localBlessManager = this.this$0;
        BlessManager.a(localBlessManager, BlessManager.a(localBlessManager));
        localBlessManager = this.this$0;
        BlessManager.a(localBlessManager, BlessManager.a(localBlessManager), true);
      }
    }
    else {
      BlessManager.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessManager.5
 * JD-Core Version:    0.7.0.1
 */