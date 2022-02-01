package com.tencent.common.danmaku.render;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.common.danmaku.core.CacheDrawManager;
import com.tencent.common.danmaku.data.BaseDanmaku;
import com.tencent.common.danmaku.inject.DanmakuContext;
import com.tencent.common.danmaku.inject.WindowConfig;

public class DanmakuDrawer
{
  private final Rect a = new Rect();
  private final Rect b = new Rect();
  private final CacheDrawManager c;
  private final Paint d = new Paint();
  
  public DanmakuDrawer(CacheDrawManager paramCacheDrawManager)
  {
    this.c = paramCacheDrawManager;
  }
  
  private boolean b(Canvas paramCanvas, BaseDanmaku paramBaseDanmaku, DanmakuContext paramDanmakuContext, BaseDanmakuRender paramBaseDanmakuRender)
  {
    paramDanmakuContext = this.c.b(paramBaseDanmaku, paramDanmakuContext);
    if (paramDanmakuContext == null) {
      return false;
    }
    int i = paramCanvas.save();
    this.a.set(0, 0, (int)paramBaseDanmaku.A(), (int)paramBaseDanmaku.B());
    this.b.set((int)paramBaseDanmaku.s(), (int)paramBaseDanmaku.t(), (int)paramBaseDanmaku.u(), (int)paramBaseDanmaku.v());
    paramCanvas.drawBitmap(paramDanmakuContext, this.a, this.b, this.d);
    paramCanvas.restoreToCount(i);
    return true;
  }
  
  private void c(Canvas paramCanvas, BaseDanmaku paramBaseDanmaku, DanmakuContext paramDanmakuContext, BaseDanmakuRender paramBaseDanmakuRender)
  {
    int i = paramCanvas.save();
    paramBaseDanmakuRender.a(paramCanvas, paramBaseDanmaku, paramDanmakuContext, paramBaseDanmaku.F(), paramBaseDanmaku.G());
    paramCanvas.restoreToCount(i);
  }
  
  public void a(Canvas paramCanvas, BaseDanmaku paramBaseDanmaku, DanmakuContext paramDanmakuContext, BaseDanmakuRender paramBaseDanmakuRender)
  {
    if (paramCanvas == null) {
      return;
    }
    if (paramBaseDanmaku.J())
    {
      if (b(paramCanvas, paramBaseDanmaku, paramDanmakuContext, paramBaseDanmakuRender)) {
        return;
      }
      WindowConfig.a(false);
    }
    c(paramCanvas, paramBaseDanmaku, paramDanmakuContext, paramBaseDanmakuRender);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.render.DanmakuDrawer
 * JD-Core Version:    0.7.0.1
 */