package com.tencent.biz.pubaccount.readinjoy.engine;

import java.util.Iterator;
import java.util.List;

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
        ((KandianMergeManager.OnMainVideoTabRedChangeListener)localIterator.next()).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.34
 * JD-Core Version:    0.7.0.1
 */