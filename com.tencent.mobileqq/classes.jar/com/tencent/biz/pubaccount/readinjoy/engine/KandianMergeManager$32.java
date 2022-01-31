package com.tencent.biz.pubaccount.readinjoy.engine;

import java.util.Iterator;
import java.util.List;
import osc;

class KandianMergeManager$32
  implements Runnable
{
  KandianMergeManager$32(KandianMergeManager paramKandianMergeManager) {}
  
  public void run()
  {
    if (KandianMergeManager.a(this.this$0) != null)
    {
      Iterator localIterator = KandianMergeManager.a(this.this$0).iterator();
      while (localIterator.hasNext()) {
        ((osc)localIterator.next()).b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.32
 * JD-Core Version:    0.7.0.1
 */