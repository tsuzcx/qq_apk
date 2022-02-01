package com.tencent.common.danmaku.core;

import com.tencent.common.danmaku.data.BaseDanmaku;
import com.tencent.common.danmaku.tool.PlayerTimer;
import com.tencent.common.danmaku.tool.SortedLinkedList;
import com.tencent.common.danmaku.util.Logger;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class DanmakuDataSource
{
  private final List<BaseDanmaku> a;
  private final SortedLinkedList<BaseDanmaku> b;
  private final PlayerTimer c;
  private final AtomicBoolean d;
  private volatile long e = -1L;
  private int f = 3;
  
  public DanmakuDataSource(PlayerTimer paramPlayerTimer, DanmakuManager.DanmakuComparator paramDanmakuComparator)
  {
    this.c = paramPlayerTimer;
    this.b = new SortedLinkedList(paramDanmakuComparator, new DanmakuDataSource.1(this));
    this.a = new LinkedList();
    this.d = new AtomicBoolean(false);
  }
  
  private void a(List<BaseDanmaku> paramList)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      BaseDanmaku localBaseDanmaku = (BaseDanmaku)paramList.get(i);
      if (localBaseDanmaku.x() <= this.e) {
        localBaseDanmaku.a();
      }
      i -= 1;
    }
  }
  
  private void g()
  {
    while (!this.d.compareAndSet(false, true))
    {
      Logger.b("DanmakuDataSource", "lock is blocked");
      Thread.yield();
    }
  }
  
  private void h()
  {
    while (!this.d.compareAndSet(true, false))
    {
      Logger.e("DanmakuDataSource", "update end is blocked! this can not happend!");
      Thread.yield();
    }
  }
  
  List<BaseDanmaku> a()
  {
    g();
    this.b.a(this.c.a(), this.a, this.f);
    a(this.a);
    h();
    return this.a;
  }
  
  public void a(int paramInt)
  {
    if (paramInt > 0) {
      this.f = paramInt;
    }
  }
  
  public void a(BaseDanmaku paramBaseDanmaku)
  {
    g();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("addNow: danmaku = ");
    localStringBuilder.append(paramBaseDanmaku);
    Logger.c("DanmakuDataSource", localStringBuilder.toString());
    this.b.b(paramBaseDanmaku);
    h();
  }
  
  public void b(BaseDanmaku paramBaseDanmaku)
  {
    g();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("addLast: danmaku = ");
    localStringBuilder.append(paramBaseDanmaku);
    Logger.c("DanmakuDataSource", localStringBuilder.toString());
    this.b.a(paramBaseDanmaku);
    h();
  }
  
  public boolean b()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      return true;
    }
    localObject = this.b;
    return (localObject != null) && (((SortedLinkedList)localObject).e() > 0);
  }
  
  public BaseDanmaku c()
  {
    return (BaseDanmaku)this.b.c();
  }
  
  public void d()
  {
    Logger.a("DanmakuDataSource", "clear danmaku queue");
    g();
    this.b.a();
    h();
  }
  
  public int e()
  {
    return this.b.e();
  }
  
  public void f()
  {
    g();
    BaseDanmaku localBaseDanmaku = (BaseDanmaku)this.b.d();
    if (localBaseDanmaku == null) {
      this.e = -1L;
    } else {
      this.e = localBaseDanmaku.x();
    }
    h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.core.DanmakuDataSource
 * JD-Core Version:    0.7.0.1
 */