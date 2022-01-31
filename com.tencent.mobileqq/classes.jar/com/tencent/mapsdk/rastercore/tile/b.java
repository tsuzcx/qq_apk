package com.tencent.mapsdk.rastercore.tile;

import android.graphics.Bitmap;
import com.tencent.mapsdk.rastercore.d.f;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnErrorListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class b
  implements e.a
{
  private static final TimeUnit a = TimeUnit.SECONDS;
  private static final int b = Runtime.getRuntime().availableProcessors();
  private f c;
  private Map<String, List<a>> d = new HashMap();
  private Map<String, List<a>> e = new HashMap();
  private final BlockingQueue<Runnable> f = new LinkedBlockingQueue();
  private final BlockingQueue<Runnable> g = new LinkedBlockingQueue();
  private ExecutorService h;
  private ExecutorService i;
  private ThreadFactory j = new ThreadFactory()
  {
    private int a = 0;
    
    public final Thread newThread(Runnable paramAnonymousRunnable)
    {
      StringBuilder localStringBuilder = new StringBuilder("TileFetchThread#");
      int i = this.a;
      this.a = (i + 1);
      paramAnonymousRunnable = new Thread(paramAnonymousRunnable, i);
      paramAnonymousRunnable.setPriority(10);
      return paramAnonymousRunnable;
    }
  };
  
  public b(f paramf)
  {
    this.c = paramf;
    int k = b;
    k = b;
    if (b < 4) {}
    for (k = 3;; k = 4)
    {
      this.i = new ThreadPoolExecutor(k, m, 30L, TimeUnit.SECONDS, this.g, this.j);
      this.h = new ThreadPoolExecutor(1, 1, 30L, a, this.f);
      return;
      m = 4;
    }
  }
  
  public final void a()
  {
    if (this.f != null) {
      this.f.clear();
    }
    if (this.g != null) {
      this.g.clear();
    }
    if (this.h != null)
    {
      this.h.shutdownNow();
      this.h = null;
    }
    if (this.i != null)
    {
      this.i.shutdown();
      this.i = null;
    }
  }
  
  public final void a(e parame)
  {
    if (parame != null)
    {
      Object localObject2 = parame.b();
      Bitmap localBitmap = parame.a();
      synchronized (this.d)
      {
        List localList = (List)this.e.remove(localObject2);
        this.d.remove(localObject2);
        if ((localList != null) && (localBitmap != null) && (!localBitmap.isRecycled()))
        {
          ??? = localList.iterator();
          while (((Iterator)???).hasNext())
          {
            localObject2 = (a)((Iterator)???).next();
            if (!((a)localObject2).i()) {
              ((a)localObject2).a(localBitmap.copy(localBitmap.getConfig(), false));
            }
          }
        }
      }
    }
    this.c.c().postInvalidate();
  }
  
  public final void a(final ArrayList<MapTile> paramArrayList)
  {
    if (com.tencent.mapsdk.rastercore.f.b.a(paramArrayList)) {}
    for (;;)
    {
      return;
      this.f.clear();
      paramArrayList = new Runnable()
      {
        public final void run()
        {
          b.a(b.this).clear();
          for (;;)
          {
            int i;
            a locala;
            synchronized (b.b(b.this))
            {
              b.b(b.this).clear();
              b.b(b.this).putAll(b.c(b.this));
              i = 0;
              if (i >= paramArrayList.size()) {
                break;
              }
              Iterator localIterator = ((MapTile)paramArrayList.get(i)).b().iterator();
              if (!localIterator.hasNext()) {
                break label444;
              }
              locala = (a)localIterator.next();
            }
            com.tencent.mapsdk.rastercore.tile.a.b localb;
            try
            {
              ??? = com.tencent.mapsdk.rastercore.tile.a.a.a().a(locala);
              if ((((com.tencent.mapsdk.rastercore.tile.a.b)???).b() != null) && (((com.tencent.mapsdk.rastercore.tile.a.b)???).d() == locala.l()))
              {
                locala.a(((com.tencent.mapsdk.rastercore.tile.a.b)???).b());
                if ((locala.m() == MapTile.MapSource.TENCENT) && (!b.d(b.this).r())) {
                  f.a += 1;
                }
                if (locala.m() != MapTile.MapSource.WORLD) {
                  continue;
                }
                f.b += 1;
                continue;
                localObject2 = finally;
                throw localObject2;
              }
            }
            catch (Throwable localThrowable)
            {
              for (;;)
              {
                if (TencentMap.getErrorListener() != null) {
                  TencentMap.getErrorListener().collectErrorInfo("TileEngineManager getTiles Runnable call CacheManager Get occured Exception,tileInfo:x=" + locala.b() + ",y=" + locala.c() + ",z=" + locala.d() + "Exception Info:" + localThrowable.toString());
                }
                localb = null;
              }
              if ((localb.b() != null) && (localb.d() != locala.l()) && (locala.m() == MapTile.MapSource.TENCENT))
              {
                new StringBuilder("Have got cache,but version is not ok,tileBitmap.getVersion：").append(localb.d()).append(",tileData.getVersion:").append(locala.l());
                b.a(b.this, locala, true, localb);
              }
            }
            if (localb.b() == null)
            {
              b.a(b.this, locala, false, null);
              if ((locala.m() == MapTile.MapSource.TENCENT) && (!b.d(b.this).r()))
              {
                b.d(b.this);
                f.c += 1;
              }
              if (locala.m() == MapTile.MapSource.WORLD)
              {
                b.d(b.this);
                f.d += 1;
                continue;
                label444:
                b.d(b.this).c().postInvalidate();
                i += 1;
              }
            }
          }
        }
      };
      try
      {
        if (!this.h.isShutdown())
        {
          this.h.execute(paramArrayList);
          return;
        }
      }
      catch (Exception paramArrayList)
      {
        new StringBuilder("getTiles get error:").append(paramArrayList.getMessage());
      }
    }
  }
  
  public final void b(e arg1)
  {
    String str;
    if (??? != null) {
      str = ???.b();
    }
    synchronized (this.d)
    {
      List localList = (List)this.d.remove(str);
      this.e.put(str, localList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.tile.b
 * JD-Core Version:    0.7.0.1
 */