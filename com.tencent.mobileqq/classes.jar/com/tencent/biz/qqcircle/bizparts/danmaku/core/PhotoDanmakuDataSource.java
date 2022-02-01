package com.tencent.biz.qqcircle.bizparts.danmaku.core;

import com.tencent.biz.qqcircle.bizparts.danmaku.config.PhotoDanmakuConfig;
import com.tencent.biz.qqcircle.bizparts.danmaku.entity.AbsDanmaku;
import com.tencent.biz.qqcircle.bizparts.danmaku.entity.DanmuSortedLinkedList;
import com.tencent.biz.qqcircle.bizparts.danmaku.entity.Duration;
import com.tencent.biz.qqcircle.bizparts.danmaku.entity.PhotoDanmakuTimer;
import com.tencent.biz.qqcircle.bizparts.danmaku.entity.SortingPhotoDanmaku;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class PhotoDanmakuDataSource
{
  private final List<AbsDanmaku> a;
  private final DanmuSortedLinkedList b;
  private final BlockingQueue<AbsDanmaku> c;
  private final BlockingQueue<AbsDanmaku> d;
  private final SortingPhotoDanmaku e;
  private final PhotoDanmakuTimer f;
  private final AtomicBoolean g;
  
  public PhotoDanmakuDataSource(PhotoDanmakuTimer paramPhotoDanmakuTimer, PhotoDanmakuConfig paramPhotoDanmakuConfig, PhotoDanmakuManager.DanmakuComparator paramDanmakuComparator)
  {
    this.f = paramPhotoDanmakuTimer;
    this.e = new SortingPhotoDanmaku(paramPhotoDanmakuConfig, new Duration(1L), paramPhotoDanmakuTimer);
    this.e.a(paramPhotoDanmakuTimer);
    this.b = new DanmuSortedLinkedList(paramDanmakuComparator);
    this.a = new LinkedList();
    this.d = new LinkedBlockingQueue();
    this.c = new LinkedBlockingQueue();
    this.g = new AtomicBoolean(false);
  }
  
  List<AbsDanmaku> a()
  {
    return this.a;
  }
  
  public void a(List<AbsDanmaku> paramList)
  {
    this.c.addAll(paramList);
  }
  
  void b()
  {
    while (!this.g.compareAndSet(false, true)) {
      Thread.yield();
    }
    AbsDanmaku localAbsDanmaku;
    while (!this.d.isEmpty())
    {
      localAbsDanmaku = (AbsDanmaku)this.d.remove();
      this.b.a(localAbsDanmaku);
    }
    while (!this.c.isEmpty())
    {
      localAbsDanmaku = (AbsDanmaku)this.c.remove();
      this.b.a(localAbsDanmaku);
    }
    this.e.d(this.f.a());
    this.b.a(this.e, this.a);
    while (!this.g.compareAndSet(true, false)) {
      Thread.yield();
    }
  }
  
  public void c()
  {
    while (!this.g.compareAndSet(false, true)) {
      Thread.yield();
    }
    this.b.a();
    this.c.clear();
    this.d.clear();
    while (!this.g.compareAndSet(true, false)) {
      Thread.yield();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.core.PhotoDanmakuDataSource
 * JD-Core Version:    0.7.0.1
 */