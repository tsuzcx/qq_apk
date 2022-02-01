package com.tencent.common.danmaku.core;

import android.graphics.Canvas;
import android.graphics.Point;
import com.tencent.common.danmaku.data.BaseDanmaku;
import com.tencent.common.danmaku.data.R2LDanmaku;
import com.tencent.common.danmaku.inject.DanmakuContext;
import com.tencent.common.danmaku.inject.WindowConfig;
import com.tencent.common.danmaku.tool.DanmakuDrawTimer;
import com.tencent.common.danmaku.tool.PlayerTimer;
import com.tencent.common.danmaku.tool.TouchPoint;
import com.tencent.common.danmaku.util.DanmakuUtils;
import com.tencent.common.danmaku.util.Logger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class R2LWindow
  extends AbsWindow
{
  protected int i;
  protected List<List<BaseDanmaku>> j;
  private int k;
  private int[] l;
  private BaseDanmaku[] m;
  
  public R2LWindow(DanmakuContext paramDanmakuContext, CacheDrawManager paramCacheDrawManager, Comparator<BaseDanmaku> paramComparator, PlayerTimer paramPlayerTimer, DanmakuDrawTimer paramDanmakuDrawTimer)
  {
    super(paramDanmakuContext, paramCacheDrawManager, paramComparator, paramPlayerTimer, paramDanmakuDrawTimer);
  }
  
  private void a(BaseDanmaku paramBaseDanmaku, int paramInt1, int paramInt2)
  {
    if (paramBaseDanmaku.J()) {
      this.f.a(paramBaseDanmaku, this.e);
    }
    paramBaseDanmaku.a(paramInt2, paramInt1, this.g.a(), this.h.b());
  }
  
  private void a(WindowConfig paramWindowConfig)
  {
    Object localObject1;
    if ((this.l == null) || (this.k != paramWindowConfig.b()))
    {
      this.k = paramWindowConfig.b();
      n = this.k;
      this.l = new int[n];
      localObject1 = new BaseDanmaku[n];
      localObject2 = this.m;
      if (localObject2 != null) {
        System.arraycopy(localObject2, 0, localObject1, 0, Math.min(localObject1.length, localObject2.length));
      }
      this.m = ((BaseDanmaku[])localObject1);
      localObject1 = this.j;
      if (localObject1 != null)
      {
        n = ((List)localObject1).size();
        if (n < this.k) {
          while (n < this.k)
          {
            this.j.add(new LinkedList());
            n += 1;
          }
        }
        n -= 1;
        while (n >= this.k)
        {
          this.j.remove(n);
          n -= 1;
        }
      }
      this.j = new ArrayList(this.k);
      n = 0;
      while (n < this.k)
      {
        this.j.add(new LinkedList());
        n += 1;
      }
    }
    int i1 = this.e.c();
    Object localObject2 = new StringBuilder("[");
    int n = 0;
    while (n < this.k)
    {
      int i2 = this.e.a(n, paramWindowConfig);
      if (n > 0)
      {
        localObject1 = this.l;
        int i3 = localObject1[(n - 1)];
        if (i2 > 0) {
          localObject1[n] = (i3 + i2);
        } else {
          localObject1[n] = (i3 + i1);
        }
      }
      else
      {
        this.l[0] = this.i;
      }
      ((StringBuilder)localObject2).append(this.l[n]);
      if (n != this.k - 1) {
        localObject1 = ", ";
      } else {
        localObject1 = "";
      }
      ((StringBuilder)localObject2).append((String)localObject1);
      n += 1;
    }
    ((StringBuilder)localObject2).append("]");
    Logger.b("Danmaku_R2LWindow", new Object[] { "reloadConfig, mRowCount = %d, mMarginTop = %d, defaultLineHeight = %d, lineTops = %s", Integer.valueOf(this.k), Integer.valueOf(this.i), Integer.valueOf(i1), localObject2 });
    a(this.j, this.l);
  }
  
  private void a(List<List<BaseDanmaku>> paramList, int[] paramArrayOfInt)
  {
    int i1 = paramList.size();
    int n = 0;
    while (n < i1)
    {
      Iterator localIterator = ((List)paramList.get(n)).iterator();
      while (localIterator.hasNext())
      {
        R2LDanmaku localR2LDanmaku = (R2LDanmaku)localIterator.next();
        localR2LDanmaku.a();
        long l1 = this.h.b();
        int i2 = (int)localR2LDanmaku.s();
        b(localR2LDanmaku);
        localR2LDanmaku.h(l1 - (int)((localR2LDanmaku.H() - i2) / -localR2LDanmaku.i()));
        localR2LDanmaku.i(paramArrayOfInt[n]);
        localR2LDanmaku.h(i2);
      }
      n += 1;
    }
  }
  
  private boolean e(BaseDanmaku paramBaseDanmaku)
  {
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext()) {
      if (((List)localIterator.next()).contains(paramBaseDanmaku))
      {
        Logger.b("Danmaku_R2LWindow", new Object[] { paramBaseDanmaku, " is repeat" });
        return true;
      }
    }
    return false;
  }
  
  private int f(BaseDanmaku paramBaseDanmaku)
  {
    int i1 = -1;
    int n = i1;
    if (paramBaseDanmaku != null)
    {
      n = i1;
      if (this.l != null)
      {
        if (this.j == null) {
          return -1;
        }
        n = 0;
        i1 = -1;
        while (n < this.l.length)
        {
          if (paramBaseDanmaku.t() == this.l[n]) {
            i1 = n;
          }
          n += 1;
        }
        if (this.j.size() <= i1) {
          return -1;
        }
        n = i1;
      }
    }
    return n;
  }
  
  private void h()
  {
    int i7 = DanmakuContext.a().j();
    int n = Logger.a;
    Object localObject1 = "Danmaku_R2LWindow";
    if (n >= 5) {
      Logger.b("Danmaku_R2LWindow", new Object[] { Integer.valueOf(this.b.size()) });
    }
    Iterator localIterator = this.b.iterator();
    for (int i1 = 0; localIterator.hasNext(); i1 = n)
    {
      BaseDanmaku localBaseDanmaku = (BaseDanmaku)localIterator.next();
      localIterator.remove();
      if ((!localBaseDanmaku.b(this.h.b())) && (!localBaseDanmaku.a(this.g.a())) && (!e(localBaseDanmaku)))
      {
        if (!localBaseDanmaku.n()) {
          DanmakuMeasureManager.a(this.e, localBaseDanmaku);
        }
        int i2 = localBaseDanmaku.d(this.k);
        if (i2 >= 0) {
          i3 = i2;
        } else {
          i3 = localBaseDanmaku.c(this.k);
        }
        n = 2147483647;
        int i5;
        if (i2 >= 0) {
          i5 = i3 + 1;
        } else {
          i5 = this.k + i3;
        }
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("startLayout, startLine = ");
        ((StringBuilder)localObject2).append(i3);
        ((StringBuilder)localObject2).append(", maxLine = ");
        ((StringBuilder)localObject2).append(i5);
        ((StringBuilder)localObject2).append(", danmaku = ");
        ((StringBuilder)localObject2).append(localBaseDanmaku);
        Logger.c((String)localObject1, ((StringBuilder)localObject2).toString());
        while (i3 < i5)
        {
          int i4 = i3;
          for (;;)
          {
            i2 = this.k;
            if (i4 < i2) {
              break;
            }
            i4 -= i2;
          }
          if (Logger.a >= 5)
          {
            Logger.b((String)localObject1, new Object[] { localBaseDanmaku, " try layout" });
            i2 = 0;
            while (i2 < this.k)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("row ");
              localStringBuilder.append(i2);
              localObject2 = this.m;
              if (localObject2[i2] == null) {
                localObject2 = " null";
              } else {
                localObject2 = localObject2[i2];
              }
              localStringBuilder.append(localObject2);
              Logger.b((String)localObject1, localStringBuilder.toString());
              i2 += 1;
            }
          }
          localObject2 = this.m;
          if (localObject2[i4] == null)
          {
            localObject2[i4] = localBaseDanmaku;
            ((List)this.j.get(i4)).add(localBaseDanmaku);
            this.a += 1;
            a(localBaseDanmaku, this.l[i4], i7);
            if (Logger.a >= 4) {
              Logger.b((String)localObject1, new Object[] { localBaseDanmaku, " layout success:", Integer.valueOf(i4), ",top:", Integer.valueOf(this.l[i4]) });
            }
            i3 = i1;
          }
          for (;;)
          {
            i2 = 1;
            i1 = i3;
            break label774;
            if (localObject2[i4].g()) {
              break label763;
            }
            int i6 = DanmakuUtils.a(this.m[i4], localBaseDanmaku, this.h.b());
            i2 = i1;
            i1 = n;
            if (i6 < n)
            {
              i1 = i6;
              i2 = i4;
            }
            if (i1 >= 0) {
              break;
            }
            this.m[i4] = localBaseDanmaku;
            ((List)this.j.get(i4)).add(localBaseDanmaku);
            this.a += 1;
            a(localBaseDanmaku, this.l[i4], i7);
            if (Logger.a >= 4)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(this.l[i4]);
              ((StringBuilder)localObject2).append(", hitTime = ");
              ((StringBuilder)localObject2).append(i1);
              Logger.b((String)localObject1, new Object[] { localBaseDanmaku, " layout success:", Integer.valueOf(i4), ",top:", ((StringBuilder)localObject2).toString() });
              i3 = i2;
              n = i1;
            }
            else
            {
              i3 = i2;
              n = i1;
            }
          }
          n = i1;
          i1 = i2;
          label763:
          i3 += 1;
        }
        i2 = 0;
        label774:
        localObject2 = localObject1;
        int i3 = i2;
        if (i2 == 0)
        {
          i3 = i2;
          if (localBaseDanmaku.a(n))
          {
            this.m[i1] = localBaseDanmaku;
            ((List)this.j.get(i1)).add(localBaseDanmaku);
            this.a += 1;
            a(localBaseDanmaku, this.l[i1], i7);
            if (Logger.a >= 4)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(this.l[i1]);
              ((StringBuilder)localObject1).append(", danmakuRepeatTime = ");
              ((StringBuilder)localObject1).append(localBaseDanmaku.D());
              Logger.b((String)localObject2, new Object[] { localBaseDanmaku, " layout success:", Integer.valueOf(i1), ",top:", ((StringBuilder)localObject1).toString() });
            }
            i3 = 1;
          }
        }
        if (i3 == 0)
        {
          this.c.add(localBaseDanmaku);
          if (Logger.a >= 4) {
            Logger.b((String)localObject2, new Object[] { localBaseDanmaku, " can not in window" });
          }
        }
        localObject1 = localObject2;
        n = i1;
        if (localBaseDanmaku.P())
        {
          localObject1 = localObject2;
          n = i1;
          if (i3 != 0)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("must show danmaku layout success :");
            ((StringBuilder)localObject1).append(localBaseDanmaku);
            Logger.b((String)localObject2, ((StringBuilder)localObject1).toString());
            localObject1 = localObject2;
            n = i1;
          }
        }
      }
      else
      {
        if (Logger.a >= 5) {
          Logger.b((String)localObject1, new Object[] { localBaseDanmaku, " is out side" });
        }
        this.c.add(localBaseDanmaku);
        n = i1;
      }
    }
  }
  
  private void i()
  {
    int i1 = this.j.size();
    int n = 0;
    while (n < i1)
    {
      Iterator localIterator = ((List)this.j.get(n)).iterator();
      while (localIterator.hasNext())
      {
        BaseDanmaku localBaseDanmaku = (BaseDanmaku)localIterator.next();
        if ((localBaseDanmaku.b(this.h.b())) || (!localBaseDanmaku.p()))
        {
          BaseDanmaku[] arrayOfBaseDanmaku = this.m;
          if (localBaseDanmaku == arrayOfBaseDanmaku[n]) {
            arrayOfBaseDanmaku[n] = null;
          }
          localIterator.remove();
          this.a -= 1;
          this.c.add(localBaseDanmaku);
        }
      }
      n += 1;
    }
  }
  
  public BaseDanmaku a(TouchPoint paramTouchPoint)
  {
    int i1 = this.j.size();
    int n = 0;
    while (n < i1)
    {
      Iterator localIterator = ((List)this.j.get(n)).iterator();
      while (localIterator.hasNext())
      {
        BaseDanmaku localBaseDanmaku = (BaseDanmaku)localIterator.next();
        if ((localBaseDanmaku.E()) && (localBaseDanmaku.a(paramTouchPoint.b.x, paramTouchPoint.b.y, paramTouchPoint.c, paramTouchPoint.a)))
        {
          if (Logger.a >= 5) {
            Logger.a("Danmaku_R2LWindow", new Object[] { "onClick:", localBaseDanmaku, "[left:", Float.valueOf(localBaseDanmaku.s()), ",top:", Float.valueOf(localBaseDanmaku.t()), "]" });
          }
          return localBaseDanmaku;
        }
      }
      n += 1;
    }
    Logger.a("Danmaku_R2LWindow", "onClick:null");
    return null;
  }
  
  public void a()
  {
    WindowConfig localWindowConfig = DanmakuContext.a();
    this.i = localWindowConfig.c();
    a(localWindowConfig);
    a(this.j, this.l);
  }
  
  public void b()
  {
    h();
    i();
  }
  
  public void b(Canvas paramCanvas, long paramLong)
  {
    int i1 = this.j.size();
    int n = 0;
    while (n < i1)
    {
      Iterator localIterator = ((List)this.j.get(n)).iterator();
      while (localIterator.hasNext())
      {
        BaseDanmaku localBaseDanmaku = (BaseDanmaku)localIterator.next();
        localBaseDanmaku.a(this.h.e(), this.h.b());
        if (!localBaseDanmaku.c(this.h.b())) {
          a(paramCanvas, localBaseDanmaku);
        }
      }
      n += 1;
    }
  }
  
  public void c()
  {
    int i1 = 0;
    int n = 0;
    while (n < this.k)
    {
      this.m[n] = null;
      n += 1;
    }
    int i2 = this.j.size();
    n = i1;
    while (n < i2)
    {
      Iterator localIterator = ((List)this.j.get(n)).iterator();
      while (localIterator.hasNext())
      {
        BaseDanmaku localBaseDanmaku = (BaseDanmaku)localIterator.next();
        localIterator.remove();
        this.a -= 1;
        this.c.add(localBaseDanmaku);
      }
      n += 1;
    }
  }
  
  public void c(BaseDanmaku paramBaseDanmaku)
  {
    int i1 = f(paramBaseDanmaku);
    if (i1 < 0) {
      return;
    }
    int n = 0;
    Iterator localIterator = ((List)this.j.get(i1)).iterator();
    while (localIterator.hasNext())
    {
      BaseDanmaku localBaseDanmaku = (BaseDanmaku)localIterator.next();
      i1 = n;
      if (localBaseDanmaku == paramBaseDanmaku) {
        i1 = 1;
      }
      n = i1;
      if (i1 != 0)
      {
        localBaseDanmaku.f();
        n = i1;
      }
    }
  }
  
  public void d(BaseDanmaku paramBaseDanmaku)
  {
    int n = f(paramBaseDanmaku);
    if (n < 0) {
      return;
    }
    paramBaseDanmaku = ((List)this.j.get(n)).iterator();
    while (paramBaseDanmaku.hasNext()) {
      ((BaseDanmaku)paramBaseDanmaku.next()).h();
    }
  }
  
  public boolean g()
  {
    List localList = this.j;
    if (localList != null)
    {
      int i1 = localList.size();
      int n = 0;
      while (n < i1)
      {
        localList = (List)this.j.get(n);
        if ((localList != null) && (localList.size() > 0)) {
          return true;
        }
        n += 1;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.core.R2LWindow
 * JD-Core Version:    0.7.0.1
 */