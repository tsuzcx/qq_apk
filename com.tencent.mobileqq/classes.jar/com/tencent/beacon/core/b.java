package com.tencent.beacon.core;

import android.content.Context;
import com.tencent.beacon.core.a.f;
import com.tencent.beacon.core.c.i;
import com.tencent.beacon.core.strategy.a;
import java.util.Map;

public class b
{
  private boolean firstStrategyQueryFinishedCalled = true;
  public Context mContext;
  
  public b(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public void onAppFirstRun() {}
  
  public void onFirstStrategyQueryFinished() {}
  
  public void onModuleStarted() {}
  
  public void onModuleStrategyUpdated(int paramInt, Map<String, String> paramMap) {}
  
  public void onSDKInit(Context paramContext) {}
  
  public void onStrategyQueryFinished()
  {
    if (this.firstStrategyQueryFinishedCalled)
    {
      onFirstStrategyQueryFinished();
      if ((!i.a(this.mContext).a()) || (!f.a(this.mContext).a("sig_1")) || (!i.a(this.mContext).b())) {
        break label62;
      }
      onModuleStarted();
    }
    for (;;)
    {
      this.firstStrategyQueryFinishedCalled = false;
      return;
      label62:
      com.tencent.beacon.core.d.b.c("[strategy] get lock failed, on call module started", new Object[0]);
    }
  }
  
  public void onStrategyQueryStarted() {}
  
  public void onStrategyUpdated(a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.beacon.core.b
 * JD-Core Version:    0.7.0.1
 */