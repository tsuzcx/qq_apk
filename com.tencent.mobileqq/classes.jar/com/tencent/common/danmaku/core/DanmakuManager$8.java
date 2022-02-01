package com.tencent.common.danmaku.core;

import com.tencent.common.danmaku.data.BaseDanmaku;

class DanmakuManager$8
  implements DanmakuMeasureManager.IMeasureCallback
{
  DanmakuManager$8(DanmakuManager paramDanmakuManager) {}
  
  public void a(BaseDanmaku paramBaseDanmaku)
  {
    DanmakuManager.j(this.a).b(paramBaseDanmaku);
    if (this.a.k != null) {
      this.a.k.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.core.DanmakuManager.8
 * JD-Core Version:    0.7.0.1
 */