package com.tencent.biz.pubaccount.readinjoy.engine;

import java.util.Iterator;
import java.util.List;

class KandianSubscribeManager$1
  implements Runnable
{
  KandianSubscribeManager$1(KandianSubscribeManager paramKandianSubscribeManager) {}
  
  public void run()
  {
    Iterator localIterator = KandianSubscribeManager.a(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      KandianSubscribeManager.KandianSubscribeMessageObserver localKandianSubscribeMessageObserver = (KandianSubscribeManager.KandianSubscribeMessageObserver)localIterator.next();
      if (localKandianSubscribeMessageObserver != null) {
        localKandianSubscribeMessageObserver.C_();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager.1
 * JD-Core Version:    0.7.0.1
 */