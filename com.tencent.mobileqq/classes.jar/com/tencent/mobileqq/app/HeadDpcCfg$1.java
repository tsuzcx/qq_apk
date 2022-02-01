package com.tencent.mobileqq.app;

import com.tencent.mobileqq.dpc.DPCObserver;

class HeadDpcCfg$1
  implements DPCObserver
{
  HeadDpcCfg$1(HeadDpcCfg paramHeadDpcCfg) {}
  
  public void onDpcPullFinished(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.HeadDpcCfg.1
 * JD-Core Version:    0.7.0.1
 */