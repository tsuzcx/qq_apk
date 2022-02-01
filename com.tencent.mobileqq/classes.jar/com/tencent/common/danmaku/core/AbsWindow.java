package com.tencent.common.danmaku.core;

import android.graphics.Canvas;
import com.tencent.common.danmaku.data.BaseDanmaku;
import com.tencent.common.danmaku.inject.DanmakuContext;
import com.tencent.common.danmaku.render.BaseDanmakuRender;
import com.tencent.common.danmaku.render.DanmakuDrawer;
import com.tencent.common.danmaku.render.IDMViewOverlayDrawer;
import com.tencent.common.danmaku.tool.DanmakuDrawTimer;
import com.tencent.common.danmaku.tool.PlayerTimer;
import com.tencent.common.danmaku.tool.TouchPoint;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public abstract class AbsWindow
{
  protected int a;
  protected final TreeSet<BaseDanmaku> b;
  protected final List<BaseDanmaku> c;
  protected final DanmakuDrawer d;
  protected DanmakuContext e;
  protected CacheDrawManager f;
  protected PlayerTimer g;
  protected DanmakuDrawTimer h;
  private ArrayList<IDMViewOverlayDrawer> i;
  
  protected AbsWindow(DanmakuContext paramDanmakuContext, CacheDrawManager paramCacheDrawManager, Comparator<BaseDanmaku> paramComparator, PlayerTimer paramPlayerTimer, DanmakuDrawTimer paramDanmakuDrawTimer)
  {
    this.e = paramDanmakuContext;
    this.f = paramCacheDrawManager;
    this.g = paramPlayerTimer;
    this.h = paramDanmakuDrawTimer;
    this.d = new DanmakuDrawer(paramCacheDrawManager);
    this.b = new TreeSet(paramComparator);
    this.c = new LinkedList();
    a();
  }
  
  public static AbsWindow a(DanmakuContext paramDanmakuContext, CacheDrawManager paramCacheDrawManager, Comparator<BaseDanmaku> paramComparator, PlayerTimer paramPlayerTimer, DanmakuDrawTimer paramDanmakuDrawTimer)
  {
    return paramDanmakuContext.a(paramDanmakuContext, paramCacheDrawManager, paramComparator, paramPlayerTimer, paramDanmakuDrawTimer);
  }
  
  private void a(Canvas paramCanvas, DanmakuContext paramDanmakuContext, long paramLong)
  {
    Object localObject = this.i;
    if ((localObject != null) && (paramCanvas != null))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((IDMViewOverlayDrawer)((Iterator)localObject).next()).a(paramCanvas, paramDanmakuContext, paramLong);
      }
    }
  }
  
  public abstract BaseDanmaku a(TouchPoint paramTouchPoint);
  
  public void a() {}
  
  public final void a(Canvas paramCanvas, long paramLong)
  {
    b(paramCanvas, paramLong);
    a(paramCanvas, this.e, paramLong);
  }
  
  protected void a(Canvas paramCanvas, BaseDanmaku paramBaseDanmaku)
  {
    BaseDanmakuRender localBaseDanmakuRender = this.e.a(paramBaseDanmaku);
    this.d.a(paramCanvas, paramBaseDanmaku, this.e, localBaseDanmakuRender);
    paramBaseDanmaku.m();
  }
  
  public void a(BaseDanmaku paramBaseDanmaku)
  {
    this.b.add(paramBaseDanmaku);
  }
  
  public void a(DanmakuDrawTimer paramDanmakuDrawTimer)
  {
    this.h = paramDanmakuDrawTimer;
  }
  
  public abstract void b();
  
  public abstract void b(Canvas paramCanvas, long paramLong);
  
  public void b(BaseDanmaku paramBaseDanmaku)
  {
    paramBaseDanmaku.c(true);
    paramBaseDanmaku.d(true);
    float f1 = paramBaseDanmaku.A();
    DanmakuMeasureManager.a(this.e, paramBaseDanmaku);
    paramBaseDanmaku.c((paramBaseDanmaku.A() + paramBaseDanmaku.H()) / (f1 + paramBaseDanmaku.H()));
  }
  
  public abstract void c();
  
  public abstract void c(BaseDanmaku paramBaseDanmaku);
  
  public int d()
  {
    return this.a;
  }
  
  public abstract void d(BaseDanmaku paramBaseDanmaku);
  
  public List<BaseDanmaku> e()
  {
    return this.c;
  }
  
  public void f()
  {
    this.c.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.core.AbsWindow
 * JD-Core Version:    0.7.0.1
 */