package com.tencent.biz.pubaccount.readinjoy.engine;

import java.util.Iterator;
import java.util.List;
import ogr;

class KandianMergeManager$30
  implements Runnable
{
  KandianMergeManager$30(KandianMergeManager paramKandianMergeManager) {}
  
  public void run()
  {
    if (KandianMergeManager.a(this.this$0) != null)
    {
      Iterator localIterator = KandianMergeManager.a(this.this$0).iterator();
      while (localIterator.hasNext()) {
        ((ogr)localIterator.next()).b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.30
 * JD-Core Version:    0.7.0.1
 */