package com.tencent.biz.pubaccount.readinjoy.engine;

import java.util.Iterator;
import java.util.List;
import ogs;

class KandianMergeManager$31
  implements Runnable
{
  KandianMergeManager$31(KandianMergeManager paramKandianMergeManager) {}
  
  public void run()
  {
    if (KandianMergeManager.b(this.this$0) != null)
    {
      Iterator localIterator = KandianMergeManager.b(this.this$0).iterator();
      while (localIterator.hasNext()) {
        ((ogs)localIterator.next()).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.31
 * JD-Core Version:    0.7.0.1
 */