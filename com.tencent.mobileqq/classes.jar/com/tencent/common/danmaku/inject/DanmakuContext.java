package com.tencent.common.danmaku.inject;

import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import com.tencent.common.danmaku.core.AbsWindow;
import com.tencent.common.danmaku.core.CacheDrawManager;
import com.tencent.common.danmaku.core.R2LWindow;
import com.tencent.common.danmaku.data.BaseDanmaku;
import com.tencent.common.danmaku.data.DefaultDanmaku;
import com.tencent.common.danmaku.data.DefaultUIConfig;
import com.tencent.common.danmaku.data.ViewDanmaku;
import com.tencent.common.danmaku.render.BaseDanmakuRender;
import com.tencent.common.danmaku.render.DefaultDanmakuRender;
import com.tencent.common.danmaku.tool.DanmakuDrawTimer;
import com.tencent.common.danmaku.tool.DanmakuDrawableCacheManager;
import com.tencent.common.danmaku.tool.PlayerTimer;
import com.tencent.common.danmaku.util.DrawUtils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class DanmakuContext
{
  private static final String a = "DanmakuContext";
  private static WindowConfig c;
  private static DefaultUIConfig d;
  private static IDanmakuWindowConfigCreator j;
  private final DanmakuDrawableCacheManager<Drawable> b;
  private final SparseArray<IDanmakuUIConfig> e = new SparseArray();
  private boolean f = false;
  private IDanmakuPlayTimeSupplier g;
  private IDanmakuExposureCallback h;
  private IDanmakuDrawableFetcher i;
  private IDanmakuUIConfigCreator k;
  private IDanmakuLineHeightDecider l;
  private IDanmakuCreator m;
  private IDanmakuClearScreenCallback n;
  private List<BaseDanmakuRender> o;
  private DefaultDanmakuRender p = new DefaultDanmakuRender();
  private IDanmakuWindowCreator q;
  private int r;
  private boolean s;
  private int t;
  
  private DanmakuContext(DanmakuContext.Builder paramBuilder)
  {
    this.f = DanmakuContext.Builder.a(paramBuilder);
    this.g = DanmakuContext.Builder.b(paramBuilder);
    this.h = DanmakuContext.Builder.c(paramBuilder);
    this.i = DanmakuContext.Builder.d(paramBuilder);
    j = DanmakuContext.Builder.e(paramBuilder);
    this.k = DanmakuContext.Builder.f(paramBuilder);
    this.l = paramBuilder.b;
    this.m = paramBuilder.c;
    this.n = DanmakuContext.Builder.g(paramBuilder);
    this.q = DanmakuContext.Builder.h(paramBuilder);
    this.r = DanmakuContext.Builder.i(paramBuilder);
    this.s = DanmakuContext.Builder.j(paramBuilder);
    this.b = new DanmakuDrawableCacheManager();
    this.t = paramBuilder.a;
    a(paramBuilder);
    m();
  }
  
  public static WindowConfig a()
  {
    if (c == null) {
      try
      {
        if ((c == null) && (j != null)) {
          c = j.a();
        }
      }
      finally {}
    }
    if (c == null) {
      c = new WindowConfig();
    }
    return c;
  }
  
  private void a(DanmakuContext.Builder paramBuilder)
  {
    this.o = new ArrayList();
    this.o.addAll(DanmakuContext.Builder.k(paramBuilder));
  }
  
  public static DefaultUIConfig b()
  {
    if (d == null) {
      try
      {
        if (d == null) {
          d = new DefaultUIConfig();
        }
      }
      finally {}
    }
    return d;
  }
  
  public static DanmakuContext.Builder k()
  {
    return new DanmakuContext.Builder(null);
  }
  
  private void m()
  {
    if (!this.f)
    {
      if (this.g != null) {
        return;
      }
      throw new IllegalArgumentException("Danmaku module need an IDanmakuPlayTimeSupplier or is live setter for computing timeline");
    }
  }
  
  public int a(int paramInt, WindowConfig paramWindowConfig)
  {
    IDanmakuLineHeightDecider localIDanmakuLineHeightDecider = this.l;
    if (localIDanmakuLineHeightDecider != null) {
      return localIDanmakuLineHeightDecider.a(paramInt, paramWindowConfig);
    }
    return 0;
  }
  
  public AbsWindow a(DanmakuContext paramDanmakuContext, CacheDrawManager paramCacheDrawManager, Comparator<BaseDanmaku> paramComparator, PlayerTimer paramPlayerTimer, DanmakuDrawTimer paramDanmakuDrawTimer)
  {
    IDanmakuWindowCreator localIDanmakuWindowCreator = this.q;
    if (localIDanmakuWindowCreator != null) {
      return localIDanmakuWindowCreator.a(paramDanmakuContext, paramCacheDrawManager, paramComparator, paramPlayerTimer, paramDanmakuDrawTimer);
    }
    return new R2LWindow(paramDanmakuContext, paramCacheDrawManager, paramComparator, paramPlayerTimer, paramDanmakuDrawTimer);
  }
  
  public IDanmakuUIConfig a(int paramInt)
  {
    Object localObject3 = (IDanmakuUIConfig)this.e.get(paramInt);
    Object localObject1 = localObject3;
    if (localObject3 == null) {
      try
      {
        localObject3 = (IDanmakuUIConfig)this.e.get(paramInt);
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          localObject1 = localObject3;
          if (this.k != null)
          {
            localObject1 = this.k.a(paramInt);
            this.e.put(paramInt, localObject1);
          }
        }
      }
      finally {}
    }
    localObject3 = localObject2;
    if (localObject2 == null) {
      localObject3 = b();
    }
    return localObject3;
  }
  
  public BaseDanmakuRender a(BaseDanmaku paramBaseDanmaku)
  {
    Iterator localIterator = j().iterator();
    while (localIterator.hasNext())
    {
      localObject = (BaseDanmakuRender)localIterator.next();
      if (((BaseDanmakuRender)localObject).a(paramBaseDanmaku))
      {
        paramBaseDanmaku = (BaseDanmaku)localObject;
        break label44;
      }
    }
    paramBaseDanmaku = null;
    label44:
    Object localObject = paramBaseDanmaku;
    if (paramBaseDanmaku == null) {
      localObject = this.p;
    }
    return localObject;
  }
  
  public BaseDanmaku b(int paramInt)
  {
    if (paramInt == -2147483647) {
      return new ViewDanmaku(this);
    }
    BaseDanmaku localBaseDanmaku = null;
    Object localObject = this.m;
    if (localObject != null) {
      localBaseDanmaku = ((IDanmakuCreator)localObject).a(this, paramInt);
    }
    localObject = localBaseDanmaku;
    if (localBaseDanmaku == null) {
      localObject = new DefaultDanmaku(this);
    }
    return localObject;
  }
  
  public void b(BaseDanmaku paramBaseDanmaku)
  {
    IDanmakuExposureCallback localIDanmakuExposureCallback = this.h;
    if (localIDanmakuExposureCallback != null) {
      localIDanmakuExposureCallback.a(paramBaseDanmaku);
    }
  }
  
  public int c()
  {
    IDanmakuLineHeightDecider localIDanmakuLineHeightDecider = this.l;
    if (localIDanmakuLineHeightDecider != null) {
      return localIDanmakuLineHeightDecider.a();
    }
    return (int)Math.ceil(DrawUtils.a(a()));
  }
  
  public boolean d()
  {
    return (this.f) || (e() < 0L);
  }
  
  public long e()
  {
    IDanmakuPlayTimeSupplier localIDanmakuPlayTimeSupplier = this.g;
    if (localIDanmakuPlayTimeSupplier == null) {
      return -1L;
    }
    return localIDanmakuPlayTimeSupplier.a();
  }
  
  public void f()
  {
    IDanmakuClearScreenCallback localIDanmakuClearScreenCallback = this.n;
    if (localIDanmakuClearScreenCallback != null) {
      localIDanmakuClearScreenCallback.a();
    }
  }
  
  public void g()
  {
    this.b.a(0);
  }
  
  public int h()
  {
    return this.r;
  }
  
  public boolean i()
  {
    return this.s;
  }
  
  public List<BaseDanmakuRender> j()
  {
    return this.o;
  }
  
  public int l()
  {
    return this.t;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.inject.DanmakuContext
 * JD-Core Version:    0.7.0.1
 */