package com.tencent.biz.pubaccount.readinjoy.engine;

import java.util.Iterator;
import java.util.List;
import pet;

class KandianMergeManager$34
  implements Runnable
{
  KandianMergeManager$34(KandianMergeManager paramKandianMergeManager) {}
  
  public void run()
  {
    if (KandianMergeManager.a(this.this$0) != null)
    {
      Iterator localIterator = KandianMergeManager.a(this.this$0).iterator();
      while (localIterator.hasNext()) {
        ((pet)localIterator.next()).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.34
 * JD-Core Version:    0.7.0.1
 */