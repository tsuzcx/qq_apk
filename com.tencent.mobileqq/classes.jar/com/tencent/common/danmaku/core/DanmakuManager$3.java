package com.tencent.common.danmaku.core;

import com.tencent.common.danmaku.data.BaseDanmaku;
import com.tencent.common.danmaku.tool.ClickResult;
import com.tencent.common.danmaku.tool.TouchPoint;

class DanmakuManager$3
  implements Runnable
{
  DanmakuManager$3(DanmakuManager paramDanmakuManager, BaseDanmaku paramBaseDanmaku, TouchPoint paramTouchPoint) {}
  
  public void run()
  {
    if (this.this$0.k == null) {
      return;
    }
    Object localObject = this.a;
    if (localObject == null)
    {
      this.this$0.k.a(false);
      return;
    }
    this.b.a(((BaseDanmaku)localObject).F(), this.a.G());
    localObject = this.a.a(this.b);
    if (this.this$0.a((ClickResult)localObject))
    {
      this.this$0.k.a(true);
      if (((ClickResult)localObject).b) {
        this.this$0.j.b(this.a);
      }
      this.this$0.k.a(this.a, this.b, (ClickResult)localObject);
      return;
    }
    this.this$0.k.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.core.DanmakuManager.3
 * JD-Core Version:    0.7.0.1
 */