package com.tencent.mobileqq.apollo.makeup;

import com.tencent.mobileqq.apollo.utils.CrossEngineResManager;
import com.tencent.mobileqq.apollo.utils.CrossEngineResManager.LoadListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "resultCode", "", "onResult"}, k=3, mv={1, 1, 16})
final class CmShowCrossEngineLoader$InitCEEngineTask$executeAsync$1
  implements CrossEngineResManager.LoadListener
{
  CmShowCrossEngineLoader$InitCEEngineTask$executeAsync$1(CmShowCrossEngineLoader.InitCEEngineTask paramInitCEEngineTask) {}
  
  public final void a(int paramInt)
  {
    if (paramInt != -2)
    {
      if (paramInt != 0)
      {
        this.a.f();
        return;
      }
      CrossEngineResManager.c((CrossEngineResManager.LoadListener)new CmShowCrossEngineLoader.InitCEEngineTask.executeAsync.1.1(this));
      return;
    }
    this.a.a(-5035, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.makeup.CmShowCrossEngineLoader.InitCEEngineTask.executeAsync.1
 * JD-Core Version:    0.7.0.1
 */