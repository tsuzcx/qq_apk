package com.tencent.beacon.core.strategy;

final class StrategyQueryModule$1
  implements Runnable
{
  StrategyQueryModule$1(StrategyQueryModule paramStrategyQueryModule) {}
  
  public final void run()
  {
    if ((StrategyQueryModule.access$000(this.a) != null) && (this.a.strategy != null)) {
      this.a.strategy.a(StrategyQueryModule.access$100(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.strategy.StrategyQueryModule.1
 * JD-Core Version:    0.7.0.1
 */