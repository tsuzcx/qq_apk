package com.tencent.common.danmaku.core;

import com.tencent.common.danmaku.data.BaseDanmaku;

class DanmakuMeasureManager$1
  implements Runnable
{
  DanmakuMeasureManager$1(DanmakuMeasureManager paramDanmakuMeasureManager, BaseDanmaku paramBaseDanmaku, DanmakuMeasureManager.IMeasureCallback paramIMeasureCallback) {}
  
  public void run()
  {
    DanmakuMeasureManager.a(DanmakuMeasureManager.a(this.this$0), this.a);
    DanmakuMeasureManager.IMeasureCallback localIMeasureCallback = this.b;
    if (localIMeasureCallback != null) {
      localIMeasureCallback.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.core.DanmakuMeasureManager.1
 * JD-Core Version:    0.7.0.1
 */