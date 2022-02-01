package com.tencent.beacon.core.strategy;

import android.content.Context;
import com.tencent.beacon.core.a.g.a;
import com.tencent.beacon.core.event.UserEventModule;

class h
  implements g.a
{
  h(StrategyQueryModule paramStrategyQueryModule, Context paramContext) {}
  
  public void a()
  {
    if ((!this.b.isAtLeastAComQuerySuccess()) && (UserEventModule.getInstance() != null) && (StrategyQueryModule.getInstance(this.a).getCommonQueryTime() != 0) && (this.b.getCurrentQueryStep() != 2)) {
      this.b.startQuery();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.strategy.h
 * JD-Core Version:    0.7.0.1
 */