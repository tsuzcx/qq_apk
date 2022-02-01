package com.tencent.biz.qqcircle.bizparts.danmaku.core;

import android.content.Context;
import android.graphics.Point;
import com.tencent.biz.qqcircle.bizparts.danmaku.config.PhotoDanmakuConfig;
import com.tencent.biz.qqcircle.bizparts.danmaku.entity.AbsDanmaku;
import com.tencent.biz.qqcircle.bizparts.danmaku.entity.PhotoDanmakuTimer;
import com.tencent.biz.qqcircle.bizparts.danmaku.entity.R2LPhotoDanmaku;
import com.tencent.biz.qqcircle.bizparts.danmaku.util.DanmakuUtils;
import com.tencent.biz.qqcircle.bizparts.danmaku.util.DrawCacheManager;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class R2LWindow
  extends AbsWindow
{
  AbsDanmaku g = null;
  private final int h;
  private int i;
  private int[] j;
  private AbsDanmaku[] k;
  private List<List<AbsDanmaku>> l;
  
  protected R2LWindow(Context paramContext, DrawCacheManager paramDrawCacheManager, PhotoDanmakuConfig paramPhotoDanmakuConfig, Comparator<AbsDanmaku> paramComparator)
  {
    super(paramContext, paramDrawCacheManager, paramPhotoDanmakuConfig, paramComparator);
    this.h = paramPhotoDanmakuConfig.u;
  }
  
  private void b(AbsDanmaku paramAbsDanmaku)
  {
    if (!paramAbsDanmaku.e()) {
      paramAbsDanmaku.b(this.e);
    }
  }
  
  public AbsDanmaku a(PhotoDanmakuManager.TouchPoint paramTouchPoint)
  {
    int n = this.l.size();
    int m = 0;
    while (m < n)
    {
      Iterator localIterator = ((List)this.l.get(m)).iterator();
      while (localIterator.hasNext())
      {
        AbsDanmaku localAbsDanmaku = (AbsDanmaku)localIterator.next();
        if ((localAbsDanmaku.I()) && (localAbsDanmaku.a(paramTouchPoint.b.x, paramTouchPoint.b.y - ViewUtils.a(30.0F), paramTouchPoint.c, paramTouchPoint.a)))
        {
          paramTouchPoint = new StringBuilder();
          paramTouchPoint.append(localAbsDanmaku.l());
          paramTouchPoint.append(",top:");
          paramTouchPoint.append(localAbsDanmaku.m());
          paramTouchPoint.append("]");
          QLog.d("R2LWindow", 4, new Object[] { "[left:", paramTouchPoint.toString() });
          localAbsDanmaku.b(true);
          return localAbsDanmaku;
        }
      }
      m += 1;
    }
    return null;
  }
  
  public void b()
  {
    super.b();
    Object localObject = this.j;
    int n = 0;
    if (localObject == null)
    {
      this.i = this.f.f;
      m = this.i;
      this.j = new int[m];
      this.k = new AbsDanmaku[m];
      this.l = new ArrayList();
      this.g = null;
      m = 0;
      while (m < this.i)
      {
        localObject = new LinkedList();
        this.l.add(localObject);
        m += 1;
      }
    }
    int i1 = (int)(PhotoDanmakuDrawer.a(this.f) + 0.99999F);
    int m = n;
    while (m < this.i)
    {
      this.j[m] = (m * i1 + this.a);
      m += 1;
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.c.iterator();
    int m = 0;
    while (localIterator.hasNext())
    {
      AbsDanmaku localAbsDanmaku1 = (AbsDanmaku)localIterator.next();
      b(localAbsDanmaku1);
      localIterator.remove();
      if (localAbsDanmaku1.g())
      {
        this.d.add(localAbsDanmaku1);
      }
      else
      {
        int n = localAbsDanmaku1.h(this.i);
        Object localObject = this.g;
        int i1 = n;
        if (localObject != null)
        {
          i1 = n;
          if (((AbsDanmaku)localObject).ah == localAbsDanmaku1.ah)
          {
            i1 = this.g.ad;
            localAbsDanmaku1.ad = i1;
          }
        }
        int i3 = 2147483647;
        this.g = localAbsDanmaku1;
        int i2 = i1;
        n = m;
        m = i3;
        if (i2 < this.i + i1)
        {
          i3 = i2;
          for (;;)
          {
            i4 = this.i;
            if (i3 < i4) {
              break;
            }
            i3 -= i4;
          }
          localObject = this.k;
          if (localObject[i3] == null)
          {
            localObject[i3] = localAbsDanmaku1;
            ((List)this.l.get(i3)).add(localAbsDanmaku1);
            this.b += 1;
            localAbsDanmaku1.a(this.e, this.h, this.j[i3]);
            localAbsDanmaku1.ad = i3;
            i4 = m;
          }
          for (;;)
          {
            m = 1;
            break label614;
            if ((localAbsDanmaku1.aj) && ((localAbsDanmaku1 instanceof R2LPhotoDanmaku)))
            {
              localObject = (R2LPhotoDanmaku)localAbsDanmaku1;
              AbsDanmaku localAbsDanmaku2 = this.k[i3];
              ((R2LPhotoDanmaku)localObject).l(-localAbsDanmaku2.b());
              ((R2LPhotoDanmaku)localObject).d(((float)localAbsDanmaku2.r() - localAbsDanmaku2.F() / localAbsDanmaku2.b()));
            }
            int i5 = DanmakuUtils.a(this.k[i3], localAbsDanmaku1, localAbsDanmaku1.p().a());
            i4 = m;
            if (i5 < m)
            {
              n = i3;
              i4 = i5;
            }
            if ((i4 >= 0) && (!localAbsDanmaku1.aj))
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(localAbsDanmaku1.ah);
              ((StringBuilder)localObject).append("=mCommentIndex  ");
              ((StringBuilder)localObject).append(localAbsDanmaku1.aj);
              ((StringBuilder)localObject).append("=isreply   ");
              ((StringBuilder)localObject).append(localAbsDanmaku1.ad);
              ((StringBuilder)localObject).append("=mPerferredLine  ");
              ((StringBuilder)localObject).append(localAbsDanmaku1.r());
              ((StringBuilder)localObject).append("=time  ");
              ((StringBuilder)localObject).append(i3);
              ((StringBuilder)localObject).append("hitTime>0=rowIndex ");
              ((StringBuilder)localObject).append(localAbsDanmaku1.s());
              ((StringBuilder)localObject).append("=text  ");
              QLog.e("R2LWindow", 1, ((StringBuilder)localObject).toString());
              i2 += 1;
              m = i4;
              break;
            }
            this.k[i3] = localAbsDanmaku1;
            ((List)this.l.get(i3)).add(localAbsDanmaku1);
            this.b += 1;
            localAbsDanmaku1.a(this.e, this.h, this.j[i3]);
            localAbsDanmaku1.ad = i3;
          }
        }
        i1 = 0;
        int i4 = m;
        m = i1;
        label614:
        i1 = m;
        if (m == 0)
        {
          i1 = m;
          if (localAbsDanmaku1.a(i4))
          {
            this.k[n] = localAbsDanmaku1;
            ((List)this.l.get(n)).add(localAbsDanmaku1);
            this.b += 1;
            localAbsDanmaku1.a(this.e, this.h, this.j[n]);
            localAbsDanmaku1.ad = n;
            i1 = 1;
          }
        }
        if (i1 == 0) {
          this.d.add(localAbsDanmaku1);
        }
        m = n;
      }
    }
  }
  
  public void d()
  {
    int n = this.l.size();
    int m = 0;
    while (m < n)
    {
      Iterator localIterator = ((List)this.l.get(m)).iterator();
      while (localIterator.hasNext())
      {
        AbsDanmaku localAbsDanmaku = (AbsDanmaku)localIterator.next();
        b(localAbsDanmaku);
        if ((localAbsDanmaku.g()) || (!localAbsDanmaku.f()))
        {
          AbsDanmaku[] arrayOfAbsDanmaku = this.k;
          if (localAbsDanmaku == arrayOfAbsDanmaku[m]) {
            arrayOfAbsDanmaku[m] = null;
          }
          localIterator.remove();
          this.b -= 1;
          this.d.add(localAbsDanmaku);
        }
      }
      m += 1;
    }
  }
  
  public void e()
  {
    int n = this.l.size();
    int m = 0;
    while (m < n)
    {
      Iterator localIterator = ((List)this.l.get(m)).iterator();
      while (localIterator.hasNext())
      {
        AbsDanmaku localAbsDanmaku = (AbsDanmaku)localIterator.next();
        localAbsDanmaku.i();
        localAbsDanmaku.a(this.e);
      }
      m += 1;
    }
  }
  
  public void f()
  {
    int n = 0;
    int m = 0;
    while (m < this.i)
    {
      this.k[m] = null;
      m += 1;
    }
    int i1 = this.l.size();
    m = n;
    while (m < i1)
    {
      Iterator localIterator = ((List)this.l.get(m)).iterator();
      while (localIterator.hasNext())
      {
        AbsDanmaku localAbsDanmaku = (AbsDanmaku)localIterator.next();
        localIterator.remove();
        this.b -= 1;
        this.d.add(localAbsDanmaku);
      }
      m += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.core.R2LWindow
 * JD-Core Version:    0.7.0.1
 */