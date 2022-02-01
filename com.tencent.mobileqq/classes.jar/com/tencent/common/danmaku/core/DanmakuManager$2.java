package com.tencent.common.danmaku.core;

import android.view.Choreographer;

class DanmakuManager$2
  implements Runnable
{
  DanmakuManager$2(DanmakuManager paramDanmakuManager) {}
  
  public void run()
  {
    if (this.this$0.l == null) {
      return;
    }
    DanmakuManager.b(this.this$0).removeFrameCallback(this.this$0.l);
    if (this.this$0.l()) {
      this.this$0.j();
    }
    DanmakuManager.b(this.this$0).postFrameCallback(this.this$0.l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.core.DanmakuManager.2
 * JD-Core Version:    0.7.0.1
 */