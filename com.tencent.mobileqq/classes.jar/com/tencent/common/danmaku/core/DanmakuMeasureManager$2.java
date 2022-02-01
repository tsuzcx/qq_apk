package com.tencent.common.danmaku.core;

import com.tencent.common.danmaku.data.BaseDanmaku;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class DanmakuMeasureManager$2
  implements Runnable
{
  DanmakuMeasureManager$2(DanmakuMeasureManager paramDanmakuMeasureManager, List paramList, DanmakuMeasureManager.IMeasureCallback paramIMeasureCallback) {}
  
  public void run()
  {
    Iterator localIterator = new ArrayList(this.a).iterator();
    while (localIterator.hasNext())
    {
      BaseDanmaku localBaseDanmaku = (BaseDanmaku)localIterator.next();
      DanmakuMeasureManager.a(DanmakuMeasureManager.a(this.this$0), localBaseDanmaku);
      DanmakuMeasureManager.IMeasureCallback localIMeasureCallback = this.b;
      if (localIMeasureCallback != null) {
        localIMeasureCallback.a(localBaseDanmaku);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.core.DanmakuMeasureManager.2
 * JD-Core Version:    0.7.0.1
 */