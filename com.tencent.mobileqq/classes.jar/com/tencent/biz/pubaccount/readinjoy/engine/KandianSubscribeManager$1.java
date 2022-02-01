package com.tencent.biz.pubaccount.readinjoy.engine;

import java.util.Iterator;
import java.util.List;
import pvg;

class KandianSubscribeManager$1
  implements Runnable
{
  KandianSubscribeManager$1(KandianSubscribeManager paramKandianSubscribeManager) {}
  
  public void run()
  {
    Iterator localIterator = KandianSubscribeManager.a(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      pvg localpvg = (pvg)localIterator.next();
      if (localpvg != null) {
        localpvg.y_();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager.1
 * JD-Core Version:    0.7.0.1
 */