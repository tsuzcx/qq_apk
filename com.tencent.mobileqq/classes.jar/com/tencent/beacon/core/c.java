package com.tencent.beacon.core;

import android.content.Context;
import com.tencent.beacon.core.a.l;
import com.tencent.beacon.core.d.k;
import com.tencent.beacon.core.e.d;
import java.util.Map;

public class c
{
  private boolean firstStrategyQueryFinishedCalled = true;
  public Context mContext;
  
  public c(Context paramContext)
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
      if ((!k.a(this.mContext).f()) || (!l.a(this.mContext).b("sig_1")) || (!k.a(this.mContext).e())) {
        break label62;
      }
      onModuleStarted();
    }
    for (;;)
    {
      this.firstStrategyQueryFinishedCalled = false;
      return;
      label62:
      d.i("[strategy] get lock failed, on call module started", new Object[0]);
    }
  }
  
  public void onStrategyQueryStarted() {}
  
  public void onStrategyUpdated(com.tencent.beacon.core.strategy.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.c
 * JD-Core Version:    0.7.0.1
 */