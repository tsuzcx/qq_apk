package com.tencent.biz.qqcircle.bizparts.danmaku.core;

import android.content.Context;
import android.graphics.Canvas;
import com.tencent.biz.qqcircle.bizparts.danmaku.config.PhotoDanmakuConfig;
import com.tencent.biz.qqcircle.bizparts.danmaku.entity.AbsDanmaku;
import com.tencent.biz.qqcircle.bizparts.danmaku.util.DrawCacheManager;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public abstract class AbsWindow
{
  protected int a;
  protected int b;
  protected final HashSet<AbsDanmaku> c;
  protected final List<AbsDanmaku> d;
  protected final PhotoDanmakuDrawer e;
  protected final PhotoDanmakuConfig f;
  
  protected AbsWindow(Context paramContext, DrawCacheManager paramDrawCacheManager, PhotoDanmakuConfig paramPhotoDanmakuConfig, Comparator<AbsDanmaku> paramComparator)
  {
    this.f = paramPhotoDanmakuConfig;
    this.e = new PhotoDanmakuDrawer(paramContext, paramDrawCacheManager);
    this.c = new HashSet();
    this.d = new LinkedList();
    b();
  }
  
  public static AbsWindow a(Context paramContext, DrawCacheManager paramDrawCacheManager, PhotoDanmakuConfig paramPhotoDanmakuConfig, Comparator<AbsDanmaku> paramComparator, int paramInt)
  {
    if (paramInt != 1) {
      return null;
    }
    return new R2LWindow(paramContext, paramDrawCacheManager, paramPhotoDanmakuConfig, paramComparator);
  }
  
  public PhotoDanmakuDrawer a()
  {
    return this.e;
  }
  
  public abstract AbsDanmaku a(PhotoDanmakuManager.TouchPoint paramTouchPoint);
  
  public void a(Canvas paramCanvas)
  {
    this.e.a(paramCanvas);
  }
  
  public void a(AbsDanmaku paramAbsDanmaku)
  {
    this.c.add(paramAbsDanmaku);
  }
  
  public void b()
  {
    this.a = this.f.e;
  }
  
  public abstract void c();
  
  public abstract void d();
  
  public abstract void e();
  
  public abstract void f();
  
  public List<AbsDanmaku> g()
  {
    return this.d;
  }
  
  public void h()
  {
    this.d.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.core.AbsWindow
 * JD-Core Version:    0.7.0.1
 */