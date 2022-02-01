package com.tencent.common.danmaku.render;

import android.graphics.Canvas;
import com.tencent.common.danmaku.data.BaseDanmaku;
import com.tencent.common.danmaku.inject.DanmakuContext;
import com.tencent.common.danmaku.util.ContentSize;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class BaseDanmakuRender<D extends BaseDanmaku>
{
  private ArrayList<IDanmakuOverlayDrawer> a;
  
  private void c(Canvas paramCanvas, D paramD, DanmakuContext paramDanmakuContext, float paramFloat1, float paramFloat2)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((IDanmakuOverlayDrawer)((Iterator)localObject).next()).a(paramCanvas, paramD, paramDanmakuContext, paramFloat1, paramFloat2);
      }
    }
  }
  
  public void a() {}
  
  public final void a(Canvas paramCanvas, D paramD, DanmakuContext paramDanmakuContext, float paramFloat1, float paramFloat2)
  {
    b(paramCanvas, paramD, paramDanmakuContext, paramFloat1, paramFloat2);
    c(paramCanvas, paramD, paramDanmakuContext, paramFloat1, paramFloat2);
  }
  
  public abstract boolean a(BaseDanmaku paramBaseDanmaku);
  
  public abstract ContentSize b(D paramD);
  
  public abstract void b(Canvas paramCanvas, D paramD, DanmakuContext paramDanmakuContext, float paramFloat1, float paramFloat2);
  
  public void c(D paramD) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.render.BaseDanmakuRender
 * JD-Core Version:    0.7.0.1
 */